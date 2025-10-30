/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.search.service.solr.index;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.impl.client.AutoRetryHttpClient;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.BinaryResponseParser;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient.Builder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.dao.SolrIndexDao;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient;
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionExecution;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
public class SolrIndexServiceImplDiffblueTest {
  @Mock
  private SolrConfiguration solrConfiguration;

  @InjectMocks
  private SolrIndexServiceImpl solrIndexServiceImpl;

  @Mock
  private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  @Mock
  private SolrHelperService solrHelperService;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @Mock
  private LocaleService localeService;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private SolrIndexDao solrIndexDao;

  @Mock
  private IndexFieldDao indexFieldDao;

  @Mock
  private ProductDao productDao;

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.performCachedOperation(CacheOperation)"})
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    // Arrange
    CacheOperation cacheOperation = mock(CacheOperation.class);
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.performCachedOperation(CacheOperation)"})
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing() throws ServiceException {
    // Arrange
    CacheOperation cacheOperation = mock(CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    solrIndexServiceImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#rebuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.rebuildIndex()"})
  public void testRebuildIndex() throws IOException, ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.rebuildIndex());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#rebuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#rebuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.rebuildIndex()"})
  public void testRebuildIndex2() throws IOException, ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    when(solrConfiguration.getReindexServer()).thenReturn(new DelegatingHttpSolrClient(delegate));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.rebuildIndex());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#rebuildIndex()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#rebuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.rebuildIndex()"})
  public void testRebuildIndex_thenThrowRuntimeException() throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName())
        .thenThrow(new RuntimeException("Rebuilding the entire Solr index..."));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.rebuildIndex());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.preBuildIndex()"})
  public void testPreBuildIndex() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.preBuildIndex());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.preBuildIndex()"})
  public void testPreBuildIndex2() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    when(solrConfiguration.getReindexServer()).thenReturn(new DelegatingHttpSolrClient(delegate));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.preBuildIndex());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   * <ul>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.preBuildIndex()"})
  public void testPreBuildIndex_thenCallsCommit() throws IOException, SolrServerException, ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    solrIndexServiceImpl.preBuildIndex();

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Reindex Collection Name"));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Reindex Collection Name"), eq("Namespace Field Name:(\"Namespace\")"));
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.preBuildIndex()"})
  public void testPreBuildIndex_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new RuntimeException("NULL"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.preBuildIndex());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIndex()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.buildIndex()"})
  public void testBuildIndex_thenThrowIllegalStateException() throws IOException, ServiceException {
    // Arrange
    when(productDao.readCountAllActiveProducts()).thenThrow(new IllegalStateException("Executing Indexing operation"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIndex());
    verify(productDao).readCountAllActiveProducts();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex() throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.postBuildIndex());
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex2() throws IOException, ServiceException {
    // Arrange
    doThrow(new IllegalStateException("foo")).when(solrHelperService).swapActiveCores(Mockito.<SolrConfiguration>any());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.postBuildIndex());
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   * <ul>
   *   <li>Given {@code blCatalogSolrConfiguration} {@link SolrConfiguration#isSingleCoreMode()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex_givenBlCatalogSolrConfigurationIsSingleCoreModeReturnTrue()
      throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);

    // Act
    solrIndexServiceImpl.postBuildIndex();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   * <ul>
   *   <li>Given {@link SolrHelperService} {@link SolrHelperService#swapActiveCores(SolrConfiguration)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex_givenSolrHelperServiceSwapActiveCoresDoesNothing()
      throws IOException, ServiceException {
    // Arrange
    doNothing().when(solrHelperService).swapActiveCores(Mockito.<SolrConfiguration>any());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act
    solrIndexServiceImpl.postBuildIndex();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.executeSolrIndexOperation(SolrIndexOperation)"})
  public void testExecuteSolrIndexOperation_thenThrowRuntimeException() throws IOException, ServiceException {
    // Arrange
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    when(operation.obtainLock()).thenThrow(new RuntimeException("Executing Indexing operation"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.executeSolrIndexOperation(operation));
    verify(operation).obtainLock();
  }

  /**
   * Test {@link SolrIndexServiceImpl#countIndexableItems()}.
   * <ul>
   *   <li>Then return longValue is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#countIndexableItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.countIndexableItems()"})
  public void testCountIndexableItems_thenReturnLongValueIsThree() {
    // Arrange
    when(productDao.readCountAllActiveProducts()).thenReturn(3L);

    // Act
    Long actualCountIndexableItemsResult = solrIndexServiceImpl.countIndexableItems();

    // Assert
    verify(productDao).readCountAllActiveProducts();
    assertEquals(3L, actualCountIndexableItemsResult.longValue());
  }

  /**
   * Test {@link SolrIndexServiceImpl#countIndexableItems()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#countIndexableItems()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.countIndexableItems()"})
  public void testCountIndexableItems_thenThrowIllegalStateException() {
    // Arrange
    when(productDao.readCountAllActiveProducts()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.countIndexableItems());
    verify(productDao).readCountAllActiveProducts();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments()"})
  public void testDeleteAllDocuments() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllDocuments());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments()"})
  public void testDeleteAllDocuments2() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    when(solrConfiguration.getReindexServer()).thenReturn(new DelegatingHttpSolrClient(delegate));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllDocuments());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with {@code collection}, {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(String, SolrClient)"})
  public void testDeleteAllDocumentsWithCollectionServer() throws ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllDocuments("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with {@code collection}, {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(String, SolrClient)"})
  public void testDeleteAllDocumentsWithCollectionServer2() throws ServiceException {
    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments("Collection", new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)} with {@code collection}, {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(String, SolrClient)"})
  public void testDeleteAllDocumentsWithCollectionServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments("Collection", server);

    // Assert
    verify(server).commit(eq("Collection"));
    verify(server).deleteByQuery(eq("Collection"), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(SolrClient)"})
  public void testDeleteAllDocumentsWithServer() throws ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .deleteAllDocuments(new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(SolrClient)"})
  public void testDeleteAllDocumentsWithServer2() throws ServiceException {
    // Arrange
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> solrIndexServiceImpl.deleteAllDocuments(new DelegatingHttpSolrClient(delegate)));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)} with {@code server}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments(SolrClient)"})
  public void testDeleteAllDocumentsWithServer_givenUpdateResponse_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(server.deleteByQuery(Mockito.<String>any(), Mockito.<String>any())).thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.deleteAllDocuments(server);

    // Assert
    verify(server).commit(isNull());
    verify(server).deleteByQuery((String) isNull(), eq("*:*"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   * <ul>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments()"})
  public void testDeleteAllDocuments_thenCallsCommit() throws IOException, SolrServerException, ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    solrIndexServiceImpl.deleteAllDocuments();

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Reindex Collection Name"));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Reindex Collection Name"), eq("Namespace Field Name:(\"Namespace\")"));
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments()"})
  public void testDeleteAllDocuments_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new RuntimeException("NULL"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.deleteAllDocuments());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#useLegacyIndexer()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SolrIndexServiceImpl.useLegacyIndexer()"})
  public void testUseLegacyIndexer() {
    // Arrange, Act and Assert
    assertTrue(solrIndexServiceImpl.useLegacyIndexer());
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllReindexCoreDocuments()"})
  public void testDeleteAllReindexCoreDocuments() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllReindexCoreDocuments());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllReindexCoreDocuments()"})
  public void testDeleteAllReindexCoreDocuments2() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    when(solrConfiguration.getReindexServer()).thenReturn(new DelegatingHttpSolrClient(delegate));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllReindexCoreDocuments());
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   * <ul>
   *   <li>Then calls {@link SolrClient#commit(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllReindexCoreDocuments()"})
  public void testDeleteAllReindexCoreDocuments_thenCallsCommit()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    when(solrConfiguration.getReindexCollectionName()).thenReturn("Reindex Collection Name");
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    solrIndexServiceImpl.deleteAllReindexCoreDocuments();

    // Assert
    verify(lbHttp2SolrClient).commit(eq("Reindex Collection Name"));
    verify(lbHttp2SolrClient).deleteByQuery(eq("Reindex Collection Name"), eq("Namespace Field Name:(\"Namespace\")"));
    verify(solrConfiguration).getNamespace();
    verify(solrConfiguration).getReindexCollectionName();
    verify(solrConfiguration).getReindexServer();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllReindexCoreDocuments()"})
  public void testDeleteAllReindexCoreDocuments_thenThrowRuntimeException() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new RuntimeException("NULL"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.deleteAllReindexCoreDocuments());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)} with {@code collection}, {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllNamespaceDocuments(String, SolrClient)"})
  public void testDeleteAllNamespaceDocumentsWithCollectionServer() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllNamespaceDocuments("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrConfiguration).getNamespace();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)} with {@code collection}, {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllNamespaceDocuments(String, SolrClient)"})
  public void testDeleteAllNamespaceDocumentsWithCollectionServer2() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenThrow(new IllegalStateException("NULL"));
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.deleteAllNamespaceDocuments("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrConfiguration).getNamespace();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)} with {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllNamespaceDocuments(SolrClient)"})
  public void testDeleteAllNamespaceDocumentsWithServer() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenReturn("Namespace");
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .deleteAllNamespaceDocuments(new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrConfiguration).getNamespace();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)} with {@code server}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteAllNamespaceDocuments(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllNamespaceDocuments(SolrClient)"})
  public void testDeleteAllNamespaceDocumentsWithServer2() throws ServiceException {
    // Arrange
    when(solrHelperService.getNamespaceFieldName()).thenReturn("Namespace Field Name");
    when(solrConfiguration.getNamespace()).thenThrow(new IllegalStateException("NULL"));
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .deleteAllNamespaceDocuments(new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrConfiguration).getNamespace();
    verify(solrHelperService).getNamespaceFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code collection}, {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"})
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(
        "Collection", indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code collection}, {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"})
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer2()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIncrementalIndex("Collection", indexables,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(solrHelperService).getCurrentProductId(isA(Indexable.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code collection}, {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"})
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer3()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    indexables.add(new ProductBundleImpl());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIncrementalIndex("Collection", indexables,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(solrHelperService, atLeast(1)).getCurrentProductId(isA(Indexable.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code collection}, {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"})
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer_thenCallsCommit()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(
        "Collection", indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code collection}, {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"})
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer_thenReturnList()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(
        "Collection", indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code indexables}, {@code solrServer}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer() throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl
        .buildIncrementalIndex(indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer_thenCallsCommit()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl
        .buildIncrementalIndex(indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer_thenReturnList()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(Mockito.<Collection<SolrInputDocument>>any(),
        Mockito.<List<Indexable>>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult = solrIndexServiceImpl
        .buildIncrementalIndex(indexables, new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(),
        isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer_thenThrowIllegalStateException()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIncrementalIndex(indexables,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(solrHelperService).getCurrentProductId(isA(Indexable.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code indexables}, {@code solrServer}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer_thenThrowIllegalStateException2()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    indexables.add(new ProductBundleImpl());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIncrementalIndex(indexables,
        new LBHttp2SolrClient(httpClient5, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(solrHelperService, atLeast(1)).getCurrentProductId(isA(Indexable.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with {@code pageSize}, {@code lastId}, {@code operation}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"})
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation() throws ServiceException, TransactionException {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(eq(3), eq(1L));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with {@code pageSize}, {@code lastId}, {@code operation}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"})
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation2() throws ServiceException, TransactionException {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexableList = new ArrayList<>();
    indexableList.add(new ProductBundleImpl());
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(indexableList);
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(eq(3), eq(1L));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with {@code pageSize}, {@code lastId}, {@code operation}.
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"})
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_thenCallsCommit()
      throws ServiceException, TransactionException {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(eq(3), eq(1L));
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with {@code pageSize}, {@code lastId}, {@code operation}.
   * <ul>
   *   <li>Then calls {@link TransactionExecution#isRollbackOnly()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"})
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_thenCallsIsRollbackOnly()
      throws ServiceException, TransactionException {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any())).thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult = solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(eq(3), eq(1L));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with {@code pageSize}, {@code lastId}, {@code operation}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"})
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_thenThrowRuntimeException()
      throws ServiceException, TransactionException {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    doThrow(new RuntimeException("readItemsToIndex")).when(operation).afterReadIndexables();
    doThrow(new RuntimeException("readItemsToIndex")).when(operation).beforeReadIndexables();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation));
    verify(operation).afterReadIndexables();
    verify(operation).beforeReadIndexables();
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SolrIndexServiceImpl.readAllActiveIndexables(int, Long)"})
  public void testReadAllActiveIndexables_thenReturnEmpty() {
    // Arrange
    when(productDao.readAllActiveProducts(Mockito.<Integer>any(), Mockito.<Long>any())).thenReturn(new ArrayList<>());

    // Act
    List<? extends Indexable> actualReadAllActiveIndexablesResult = solrIndexServiceImpl.readAllActiveIndexables(3, 1L);

    // Assert
    verify(productDao).readAllActiveProducts(eq(3), eq(1L));
    assertTrue(actualReadAllActiveIndexablesResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SolrIndexServiceImpl.readAllActiveIndexables(int, Long)"})
  public void testReadAllActiveIndexables_thenThrowIllegalStateException() {
    // Arrange
    when(productDao.readAllActiveProducts(Mockito.<Integer>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.readAllActiveIndexables(3, 1L));
    verify(productDao).readAllActiveProducts(eq(3), eq(1L));
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   * <ul>
   *   <li>Given {@link LocaleImpl} {@link LocaleImpl#getLocaleCode()} return {@code en}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SolrIndexServiceImpl.getAllLocales()"})
  public void testGetAllLocales_givenLocaleImplGetLocaleCodeReturnEn_thenReturnSizeIsOne() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(localeImpl);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    List<Locale> actualAllLocales = solrIndexServiceImpl.getAllLocales();

    // Assert
    verify(localeImpl, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    assertEquals(1, actualAllLocales.size());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SolrIndexServiceImpl.getAllLocales()"})
  public void testGetAllLocales_thenReturnEmpty() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    List<Locale> actualAllLocales = solrIndexServiceImpl.getAllLocales();

    // Assert
    verify(localeService).findAllLocales();
    assertTrue(actualAllLocales.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List SolrIndexServiceImpl.getAllLocales()"})
  public void testGetAllLocales_thenThrowIllegalStateException() {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.getAllLocales());
    verify(localeService).findAllLocales();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_whenProductBundleImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"})
  public void testAttachIndexableDocumentFields() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException("Could not get value for property["));
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}.
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"})
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException("foo"));

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>()));
    verify(fieldImpl).getQualifiedFieldName();
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachAdditionalDocumentFields() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());

    // Act
    solrIndexServiceImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachAdditionalDocumentFields_thenThrowIllegalStateException() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.attachBasicDocumentFields(Indexable, SolrInputDocument)"})
  public void testAttachBasicDocumentFields() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void SolrIndexServiceImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"})
  public void testBuildFullCategoryHierarchy_thenThrowRuntimeException() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> solrIndexServiceImpl.buildFullCategoryHierarchy(null, cache, 1L, new HashSet<>()));
    verify(solrHelperService).getCategoryId(eq(1L));
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues = solrIndexServiceImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues = solrIndexServiceImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(Mockito.<Indexable>any(), Mockito.<Field>any(),
        Mockito.<FieldType>any(), Mockito.<Map<String, Object>>any(), Mockito.<String>any(),
        Mockito.<List<Locale>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues = solrIndexServiceImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler).addPropertyValues(isA(Indexable.class), isA(Field.class),
        isA(FieldType.class), isA(Map.class), (String) isNull(), isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenReturnSizeIsOne()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn(GlobalSolrFullReIndexOperation.LOCK_OBJECT);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues = solrIndexServiceImpl.getPropertyValues(indexedItem, field,
        FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, actualPropertyValues.size());
    assertTrue(actualPropertyValues.containsKey(""));
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"})
  public void testGetPropertyValues_thenThrowIllegalStateException()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> solrIndexServiceImpl.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code \.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenBackslashDot_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", solrIndexServiceImpl.convertToMappedProperty("\\.", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", solrIndexServiceImpl.convertToMappedProperty("", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code Long}.</li>
   *   <li>Then return {@code Long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenJavaLangLong_thenReturnJavaLangLong() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Long",
        solrIndexServiceImpl.convertToMappedProperty("java.lang.Long", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code java}.</li>
   *   <li>Then return {@code Map Property Name(lang).value.Long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenJava_thenReturnMapPropertyNameLangValueLong() {
    // Arrange, Act and Assert
    assertEquals("Map Property Name(lang).value.Long",
        solrIndexServiceImpl.convertToMappedProperty("java.lang.Long", "java", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   * <ul>
   *   <li>When {@code Property Name}.</li>
   *   <li>Then return {@code Property Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenPropertyName_thenReturnPropertyName() {
    // Arrange, Act and Assert
    assertEquals("Property Name",
        solrIndexServiceImpl.convertToMappedProperty("Property Name", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#saveState()}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#saveState()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object[] SolrIndexServiceImpl.saveState()"})
  public void testSaveState() {
    // Arrange and Act
    Object[] actualSaveStateResult = solrIndexServiceImpl.saveState();

    // Assert
    assertTrue(actualSaveStateResult[0] instanceof BroadleafRequestContext);
    assertNull(actualSaveStateResult[1]);
    assertNull(actualSaveStateResult[2]);
    assertNull(actualSaveStateResult[3]);
    assertEquals(4, actualSaveStateResult.length);
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)} with {@code collection}, {@code server}.
   * <ul>
   *   <li>Then calls {@link SolrHelperService#optimizeIndex(String, SolrClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(String, SolrClient)"})
  public void testOptimizeIndexWithCollectionServer_thenCallsOptimizeIndex() throws IOException, ServiceException {
    // Arrange
    doNothing().when(solrHelperService).optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    solrIndexServiceImpl.optimizeIndex("Collection", new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrHelperService).optimizeIndex(eq("Collection"), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)} with {@code server}.
   * <ul>
   *   <li>Then calls {@link SolrHelperService#optimizeIndex(String, SolrClient)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(SolrClient)"})
  public void testOptimizeIndexWithServer_thenCallsOptimizeIndex() throws IOException, ServiceException {
    // Arrange
    doNothing().when(solrHelperService).optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act
    solrIndexServiceImpl.optimizeIndex(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Assert
    verify(solrHelperService).optimizeIndex(isNull(), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)} with {@code collection}, {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(String, SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection",
        new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)} with {@code collection}, {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(String, SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit("Collection", server, true, true, true);

    // Assert
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)} with {@code collection}, {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(String, SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(String, SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithCollectionServerSoftCommitWaitSearcherWaitFlush3()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit("Collection", server, true, true, true));
    verify(server).commit(eq("Collection"), eq(true), eq(true), eq(true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)} with {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush() throws IOException, ServiceException {
    // Arrange
    Builder connectionTimeoutResult = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult2 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult3 = (new Builder()).connectionTimeout(1);
    Builder connectionTimeoutResult4 = (new Builder()).connectionTimeout(1);
    Http2SolrClient httpClient = (new Builder()).build();
    Http2SolrClient httpClient2 = connectionTimeoutResult4.withHttpClient(httpClient)
        .idleTimeout(1)
        .maxConnectionsPerHost(3)
        .withSSLConfig(null)
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult = connectionTimeoutResult3.withHttpClient(httpClient2)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient3 = maxConnectionsPerHostResult
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult2 = connectionTimeoutResult2.withHttpClient(httpClient3)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient4 = maxConnectionsPerHostResult2
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();
    Builder maxConnectionsPerHostResult3 = connectionTimeoutResult.withHttpClient(httpClient4)
        .idleTimeout(1)
        .maxConnectionsPerHost(3);
    Http2SolrClient httpClient5 = maxConnectionsPerHostResult3
        .withSSLConfig(new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou"))
        .useHttp1_1(true)
        .build();

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl
        .commit(new LBHttp2SolrClient(httpClient5, "https://example.org/example"), true, true, true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)} with {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush2()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new SolrServerException("An error occurred"));

    // Act and Assert
    assertThrows(ServiceException.class, () -> solrIndexServiceImpl.commit(server, true, true, true));
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)} with {@code server}, {@code softCommit}, {@code waitSearcher}, {@code waitFlush}.
   * <ul>
   *   <li>Given {@link UpdateResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#commit(SolrClient, boolean, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.commit(SolrClient, boolean, boolean, boolean)"})
  public void testCommitWithServerSoftCommitWaitSearcherWaitFlush_givenUpdateResponse()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient server = mock(LBHttp2SolrClient.class);
    when(server.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());

    // Act
    solrIndexServiceImpl.commit(server, true, true, true);

    // Assert
    verify(server).commit(isNull(), eq(true), eq(true), eq(true));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long SolrIndexServiceImpl.convertDisplayOrderToLong(CatalogStructure, String)"})
  public void testConvertDisplayOrderToLong() {
    // Arrange
    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertNull(solrIndexServiceImpl.convertDisplayOrderToLong(cache, "Display Order Key"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteByQuery(String)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteByQuery(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteByQuery(String)"})
  public void testDeleteByQuery_thenCallsDeleteByQuery() throws IOException, SolrServerException {
    // Arrange
    when(solrHelperService.getPrimaryDocumentType()).thenReturn("Primary Document Type");
    when(solrHelperService.getTypeFieldName()).thenReturn("Type Field Name");
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getQueryCollectionName()).thenReturn("Query Collection Name");
    when(solrConfiguration.getServer()).thenReturn(lbHttp2SolrClient);

    // Act
    solrIndexServiceImpl.deleteByQuery("Delete Query");

    // Assert
    verify(lbHttp2SolrClient, atLeast(1)).deleteByQuery(eq("Query Collection Name"), Mockito.<String>any());
    verify(solrConfiguration, atLeast(1)).getQueryCollectionName();
    verify(solrConfiguration, atLeast(1)).getServer();
    verify(solrHelperService).getPrimaryDocumentType();
    verify(solrHelperService).getTypeFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteByQuery(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#deleteByQuery(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteByQuery(String)"})
  public void testDeleteByQuery_thenThrowRuntimeException() throws IOException, SolrServerException {
    // Arrange
    when(solrHelperService.getPrimaryDocumentType()).thenReturn("Primary Document Type");
    when(solrHelperService.getTypeFieldName()).thenReturn("Type Field Name");
    when(solrConfiguration.getServer()).thenThrow(new RuntimeException(":"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> solrIndexServiceImpl.deleteByQuery("Delete Query"));
    verify(solrConfiguration).getServer();
    verify(solrHelperService).getPrimaryDocumentType();
    verify(solrHelperService).getTypeFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#addDocuments(Collection)}.
   * <ul>
   *   <li>Given {@link LBHttp2SolrClient} {@link SolrClient#add(String, Collection)} return {@link UpdateResponse} (default constructor).</li>
   *   <li>Then calls {@link SolrClient#add(String, Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#addDocuments(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.addDocuments(Collection)"})
  public void testAddDocuments_givenLBHttp2SolrClientAddReturnUpdateResponse_thenCallsAdd()
      throws IOException, SolrServerException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getQueryCollectionName()).thenReturn("Query Collection Name");
    when(solrConfiguration.getServer()).thenReturn(lbHttp2SolrClient);

    // Act
    solrIndexServiceImpl.addDocuments(new ArrayList<>());

    // Assert
    verify(lbHttp2SolrClient).add(eq("Query Collection Name"), isA(Collection.class));
    verify(solrConfiguration).getQueryCollectionName();
    verify(solrConfiguration).getServer();
  }

  /**
   * Test {@link SolrIndexServiceImpl#addDocuments(Collection)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#addDocuments(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.addDocuments(Collection)"})
  public void testAddDocuments_givenSolrInputDocument_whenArrayListAddSolrInputDocument()
      throws IOException, SolrServerException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getQueryCollectionName()).thenReturn("Query Collection Name");
    when(solrConfiguration.getServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    documents.add(mock(SolrInputDocument.class));

    // Act
    solrIndexServiceImpl.addDocuments(documents);

    // Assert
    verify(lbHttp2SolrClient).add(eq("Query Collection Name"), isA(Collection.class));
    verify(solrConfiguration).getQueryCollectionName();
    verify(solrConfiguration).getServer();
  }

  /**
   * Test {@link SolrIndexServiceImpl#addDocuments(Collection)}.
   * <ul>
   *   <li>Given {@link SolrInputDocument}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link SolrInputDocument}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrIndexServiceImpl#addDocuments(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrIndexServiceImpl.addDocuments(Collection)"})
  public void testAddDocuments_givenSolrInputDocument_whenArrayListAddSolrInputDocument2()
      throws IOException, SolrServerException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.add(Mockito.<String>any(), Mockito.<Collection<SolrInputDocument>>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getQueryCollectionName()).thenReturn("Query Collection Name");
    when(solrConfiguration.getServer()).thenReturn(lbHttp2SolrClient);

    ArrayList<SolrInputDocument> documents = new ArrayList<>();
    documents.add(mock(SolrInputDocument.class));
    documents.add(mock(SolrInputDocument.class));

    // Act
    solrIndexServiceImpl.addDocuments(documents);

    // Assert
    verify(lbHttp2SolrClient).add(eq("Query Collection Name"), isA(Collection.class));
    verify(solrConfiguration).getQueryCollectionName();
    verify(solrConfiguration).getServer();
  }
}
