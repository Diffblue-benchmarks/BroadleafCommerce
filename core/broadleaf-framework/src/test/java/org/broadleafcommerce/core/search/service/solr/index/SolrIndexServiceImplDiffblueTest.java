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
import static org.junit.Assert.assertFalse;
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.SSLConfig;
import org.apache.solr.client.solrj.impl.Http2SolrClient;
import org.apache.solr.client.solrj.impl.Http2SolrClient.Builder;
import org.apache.solr.client.solrj.impl.LBHttp2SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.sandbox.SandBoxHelper;
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
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
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
import org.mvel2.util.InternalNumber;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
public class SolrIndexServiceImplDiffblueTest {
  @Mock private IndexFieldDao indexFieldDao;

  @Mock private LocaleService localeService;

  @Mock private PlatformTransactionManager platformTransactionManager;

  @Mock private ProductDao productDao;

  @Mock private SandBoxHelper sandBoxHelper;

  @Mock private SolrConfiguration solrConfiguration;

  @Mock private SolrHelperService solrHelperService;

  @Mock private SolrIndexDao solrIndexDao;

  @Mock private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  @InjectMocks private SolrIndexServiceImpl solrIndexServiceImpl;

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.performCachedOperation(CacheOperation)"})
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    // Arrange
    CacheOperation cacheOperation = mock(CacheOperation.class);
    doThrow(new IllegalStateException()).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>When {@link CacheOperation} {@link CacheOperation#execute()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#performCachedOperation(CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.performCachedOperation(CacheOperation)"})
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing()
      throws ServiceException {
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
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#rebuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.rebuildIndex()"})
  public void testRebuildIndex() throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.rebuildIndex());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#preBuildIndex()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#preBuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.preBuildIndex()"})
  public void testPreBuildIndex() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.preBuildIndex());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIndex()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.buildIndex()"})
  public void testBuildIndex_thenThrowIllegalStateException() throws IOException, ServiceException {
    // Arrange
    when(productDao.readCountAllActiveProducts()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.buildIndex());
    verify(productDao).readCountAllActiveProducts();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex() throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);

    // Act
    solrIndexServiceImpl.postBuildIndex();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex2() throws IOException, ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.postBuildIndex());
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.postBuildIndex()"})
  public void testPostBuildIndex3() throws IOException, ServiceException {
    // Arrange
    doThrow(new IllegalStateException())
        .when(solrHelperService)
        .swapActiveCores(Mockito.<SolrConfiguration>any());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.postBuildIndex());
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#postBuildIndex()}.
   *
   * <ul>
   *   <li>Given {@link SolrHelperService} {@link
   *       SolrHelperService#swapActiveCores(SolrConfiguration)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#postBuildIndex()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#executeSolrIndexOperation(SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.executeSolrIndexOperation(SolrIndexOperation)"})
  public void testExecuteSolrIndexOperation_thenThrowIllegalStateException()
      throws IOException, ServiceException {
    // Arrange
    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    when(operation.obtainLock()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.executeSolrIndexOperation(operation));
    verify(operation).obtainLock();
  }

  /**
   * Test {@link SolrIndexServiceImpl#countIndexableItems()}.
   *
   * <ul>
   *   <li>Then return longValue is three.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#countIndexableItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#countIndexableItems()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long SolrIndexServiceImpl.countIndexableItems()"})
  public void testCountIndexableItems_thenThrowIllegalStateException() {
    // Arrange
    when(productDao.readCountAllActiveProducts()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.countIndexableItems());
    verify(productDao).readCountAllActiveProducts();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllDocuments()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#deleteAllDocuments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllDocuments()"})
  public void testDeleteAllDocuments() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.deleteAllDocuments());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#useLegacyIndexer()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#useLegacyIndexer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrIndexServiceImpl.useLegacyIndexer()"})
  public void testUseLegacyIndexer() {
    // Arrange, Act and Assert
    assertTrue(solrIndexServiceImpl.useLegacyIndexer());
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#deleteAllReindexCoreDocuments()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteAllReindexCoreDocuments()"})
  public void testDeleteAllReindexCoreDocuments() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexCollectionName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> solrIndexServiceImpl.deleteAllReindexCoreDocuments());
    verify(solrConfiguration).getReindexCollectionName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                "Collection",
                indexables,
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer2()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                "Collection",
                indexables,
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer3()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                "Collection",
                indexables,
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer4()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                "Collection",
                indexables,
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer5()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenThrow(new IllegalStateException());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                "Collection",
                indexables,
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List, SolrClient)} with {@code
   * collection}, {@code indexables}, {@code solrServer}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(String, List,
   * SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection SolrIndexServiceImpl.buildIncrementalIndex(String, List, SolrClient)"
  })
  public void testBuildIncrementalIndexWithCollectionIndexablesSolrServer_thenReturnList()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(
            Mockito.<Collection<SolrInputDocument>>any(),
            Mockito.<List<Indexable>>any(),
            Mockito.<List<IndexField>>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(
            "Collection",
            indexables,
            new LBHttp2SolrClient(httpClient, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler)
        .modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer2()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer3()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer4()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer5()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenThrow(new IllegalStateException());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    when(solrHelperService.getCurrentProductId(Mockito.<Indexable>any())).thenReturn(1L);
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    ArrayList<Indexable> indexables = new ArrayList<>();
    indexables.add(new ProductBundleImpl());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.buildIncrementalIndex(
                indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example")));
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
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)} with {@code
   * indexables}, {@code solrServer}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(List, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection SolrIndexServiceImpl.buildIncrementalIndex(List, SolrClient)"})
  public void testBuildIncrementalIndexWithIndexablesSolrServer_thenReturnList()
      throws ServiceException, TransactionException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.modifyBuiltDocuments(
            Mockito.<Collection<SolrInputDocument>>any(),
            Mockito.<List<Indexable>>any(),
            Mockito.<List<IndexField>>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());
    ArrayList<Indexable> indexables = new ArrayList<>();

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act
    Collection<SolrInputDocument> actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(
            indexables, new LBHttp2SolrClient(httpClient, "https://example.org/example"));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler)
        .modifyBuiltDocuments(isA(Collection.class), isA(List.class), isNull(), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertTrue(actualBuildIncrementalIndexResult instanceof List);
    assertTrue(actualBuildIncrementalIndexResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with
   * {@code pageSize}, {@code lastId}, {@code operation}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long,
   * SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"
  })
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation()
      throws ServiceException, TransactionException {
    // Arrange
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(null);
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isNull());
    verify(operation).readIndexables(3, 1L);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with
   * {@code pageSize}, {@code lastId}, {@code operation}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long,
   * SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"
  })
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation2()
      throws ServiceException, TransactionException {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
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
    Long actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(3, 1L);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with
   * {@code pageSize}, {@code lastId}, {@code operation}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long,
   * SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"
  })
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_givenArrayList()
      throws ServiceException, TransactionException {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
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
    Long actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isA(List.class));
    verify(operation).readIndexables(3, 1L);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with
   * {@code pageSize}, {@code lastId}, {@code operation}.
   *
   * <ul>
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long,
   * SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"
  })
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_thenCallsCommit()
      throws ServiceException, TransactionException {
    // Arrange
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus(true));

    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(null);
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isNull());
    verify(operation).readIndexables(3, 1L);
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long, SolrIndexOperation)} with
   * {@code pageSize}, {@code lastId}, {@code operation}.
   *
   * <ul>
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildIncrementalIndex(int, Long,
   * SolrIndexOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.buildIncrementalIndex(int, Long, SolrIndexOperation)"
  })
  public void testBuildIncrementalIndexWithPageSizeLastIdOperation_thenCallsIsRollbackOnly()
      throws ServiceException, TransactionException {
    // Arrange
    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    SolrIndexOperation operation = mock(SolrIndexOperation.class);
    Mockito.<List<? extends Indexable>>when(operation.readIndexables(anyInt(), Mockito.<Long>any()))
        .thenReturn(null);
    doNothing().when(operation).afterBuildPage();
    doNothing().when(operation).afterReadIndexables();
    doNothing().when(operation).beforeBuildPage();
    doNothing().when(operation).beforeReadIndexables();
    doNothing().when(operation).buildPage(Mockito.<List<Indexable>>any());

    // Act
    Long actualBuildIncrementalIndexResult =
        solrIndexServiceImpl.buildIncrementalIndex(3, 1L, operation);

    // Assert
    verify(operation).afterBuildPage();
    verify(operation).afterReadIndexables();
    verify(operation).beforeBuildPage();
    verify(operation).beforeReadIndexables();
    verify(operation).buildPage(isNull());
    verify(operation).readIndexables(3, 1L);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertNull(actualBuildIncrementalIndexResult);
  }

  /**
   * Test {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrIndexServiceImpl.readAllActiveIndexables(int, Long)"})
  public void testReadAllActiveIndexables_thenReturnEmpty() {
    // Arrange
    when(productDao.readAllActiveProducts(Mockito.<Integer>any(), Mockito.<Long>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<? extends Indexable> actualReadAllActiveIndexablesResult =
        solrIndexServiceImpl.readAllActiveIndexables(3, 1L);

    // Assert
    verify(productDao).readAllActiveProducts(3, 1L);
    assertTrue(actualReadAllActiveIndexablesResult.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#readAllActiveIndexables(int, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrIndexServiceImpl.readAllActiveIndexables(int, Long)"})
  public void testReadAllActiveIndexables_thenThrowIllegalStateException() {
    // Arrange
    when(productDao.readAllActiveProducts(Mockito.<Integer>any(), Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> solrIndexServiceImpl.readAllActiveIndexables(3, 1L));
    verify(productDao).readAllActiveProducts(3, 1L);
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   *
   * <ul>
   *   <li>Given {@link Locale} {@link Locale#getLocaleCode()} return {@code en}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrIndexServiceImpl.getAllLocales()"})
  public void testGetAllLocales_givenLocaleGetLocaleCodeReturnEn_thenReturnSizeIsOne() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    List<Locale> actualAllLocales = solrIndexServiceImpl.getAllLocales();

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    assertEquals(1, actualAllLocales.size());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getAllLocales()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List SolrIndexServiceImpl.getAllLocales()"})
  public void testGetAllLocales_thenThrowIllegalStateException() {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> solrIndexServiceImpl.getAllLocales());
    verify(localeService).findAllLocales();
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_givenLocaleImpl_whenArrayListAddLocaleImpl2() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, locales));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}.
   *
   * <ul>
   *   <li>When {@link ProductBundleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SolrInputDocument SolrIndexServiceImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocument_whenProductBundleImpl() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildDocument(indexable, fields, new ArrayList<>()));
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenIndexFieldImpl() {
    // Arrange
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    solrIndexServiceImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(document.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_givenNull_whenArrayListAddNull() {
    // Arrange
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(null);

    // Act
    solrIndexServiceImpl.attachIndexableDocumentFields(
        document, indexable, fields, new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(document.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>Then calls {@link IndexFieldImpl#getField()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenCallsGetField() {
    // Arrange
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());
    ProductBundleImpl indexable = new ProductBundleImpl();

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenThrow(new IllegalStateException());
    when(indexFieldImpl.getFieldTypes()).thenThrow(new IllegalStateException());

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.attachIndexableDocumentFields(
                document, indexable, fields, new ArrayList<>()));
    verify(indexFieldImpl).getField();
    verify(indexFieldImpl).getFieldTypes();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldImpl#getPropertyName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenCallsGetPropertyName()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.populateDocumentForIndexField(
            Mockito.<SolrInputDocument>any(),
            Mockito.<IndexField>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());
    ProductBundleImpl indexable = new ProductBundleImpl();

    FieldImpl field = mock(FieldImpl.class);
    when(field.getPropertyName()).thenReturn("Property Name");
    when(field.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenThrow(new IllegalStateException());

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(new IndexFieldTypeImpl());
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(field);
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.attachIndexableDocumentFields(
                document, indexable, fields, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(field).getPropertyName();
    verify(field).getQualifiedFieldName();
    verify(indexFieldTypeImpl).getFieldType();
    verify(i18nSolrIndexServiceExtensionHandler)
        .populateDocumentForIndexField(
            isA(SolrInputDocument.class), isA(IndexField.class), isNull(), isA(Map.class));
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            (FieldType) isNull(),
            isA(Map.class),
            eq("Property Name"),
            isA(List.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldImpl#getQualifiedFieldName()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_thenCallsGetQualifiedFieldName() {
    // Arrange
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());
    ProductBundleImpl indexable = new ProductBundleImpl();

    FieldImpl field = mock(FieldImpl.class);
    when(field.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenThrow(new IllegalStateException());

    ArrayList<IndexFieldType> fieldTypes = new ArrayList<>();
    fieldTypes.add(indexFieldTypeImpl);

    IndexFieldImpl indexFieldImpl = new IndexFieldImpl();
    indexFieldImpl.setField(field);
    indexFieldImpl.setId(1L);
    indexFieldImpl.setSearchable(true);
    indexFieldImpl.setFieldTypes(fieldTypes);

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(indexFieldImpl);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.attachIndexableDocumentFields(
                document, indexable, fields, new ArrayList<>()));
    verify(field).getQualifiedFieldName();
    verify(indexFieldTypeImpl).getFieldType();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable,
   * List, List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * SolrIndexServiceImpl#attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachIndexableDocumentFields(SolrInputDocument, Indexable, List, List)"
  })
  public void testAttachIndexableDocumentFields_whenNull_thenNull() {
    // Arrange
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    solrIndexServiceImpl.attachIndexableDocumentFields(null, indexable, fields, new ArrayList<>());

    // Assert that nothing has changed
    assertNull(null);
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable,
   * SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachAdditionalDocumentFields() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());

    // Act
    solrIndexServiceImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable, SolrInputDocument)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#attachAdditionalDocumentFields(Indexable,
   * SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachAdditionalDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachAdditionalDocumentFields_thenThrowIllegalStateException() {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.attachAdditionalDocumentFields(new ProductBundleImpl(), null));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable, SolrInputDocument)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#attachBasicDocumentFields(Indexable,
   * SolrInputDocument)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.attachBasicDocumentFields(Indexable, SolrInputDocument)"
  })
  public void testAttachBasicDocumentFields() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.attachBasicDocumentFields(new ProductBundleImpl(), null));
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    HashSet<Long> resultLongSet = new HashSet<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);
    cache.setParentCategoriesByProduct(new HashMap<>());
    HashSet<Long> indexedParents = new HashSet<>();

    // Act
    solrIndexServiceImpl.buildFullCategoryHierarchy(document, cache, 1L, indexedParents);

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals(1, getResult.getValueCount());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals(1L, ((Long) iteratorResult.next()).longValue());
    assertEquals(1L, ((Long) ((List<Object>) values).get(0)).longValue());
    assertEquals(1L, ((Long) getResult.getFirstValue()).longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertFalse(iteratorResult.hasNext());
    assertEquals(resultLongSet, indexedParents);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy2() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);
    cache.setParentCategoriesByProduct(new HashMap<>());
    HashSet<Long> indexedParents = new HashSet<>();

    // Act
    solrIndexServiceImpl.buildFullCategoryHierarchy(document, cache, 1L, indexedParents);

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService, atLeast(1)).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    Collection<Object> values = getResult.getValues();
    assertEquals(1, values.size());
    assertTrue(values instanceof List);
    assertEquals(1, getResult.getValueCount());
    Iterator<Object> iteratorResult = getResult.iterator();
    assertEquals(1L, ((Long) iteratorResult.next()).longValue());
    assertEquals(1L, ((Long) ((List<Object>) values).get(0)).longValue());
    assertEquals(1L, ((Long) getResult.getFirstValue()).longValue());
    assertEquals(1L, ((Long) getResult.getValue()).longValue());
    assertFalse(iteratorResult.hasNext());
    assertEquals(resultLongSet, indexedParents);
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy3() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(null);
    when(solrHelperService.getCategoryFieldName()).thenReturn("Category Field Name");
    SolrInputDocument document = new SolrInputDocument(new HashMap<>());

    HashSet<Long> resultLongSet = new HashSet<>();
    resultLongSet.add(1L);

    HashMap<Long, Set<Long>> parentCategoriesByCategory = new HashMap<>();
    parentCategoriesByCategory.put(1L, resultLongSet);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(parentCategoriesByCategory);
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act
    solrIndexServiceImpl.buildFullCategoryHierarchy(document, cache, 1L, new HashSet<>());

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryFieldName();
    verify(solrHelperService, atLeast(1)).getCategoryId(1L);
    assertEquals(1, document.size());
    SolrInputField getResult = document.get("Category Field Name");
    assertNull(getResult.getFirstValue());
    assertNull(getResult.getValue());
    assertNull(getResult.getValues());
    assertEquals(0, getResult.getValueCount());
    assertFalse(getResult.iterator().hasNext());
  }

  /**
   * Test {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#buildFullCategoryHierarchy(SolrInputDocument,
   * CatalogStructure, Long, Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrIndexServiceImpl.buildFullCategoryHierarchy(SolrInputDocument, CatalogStructure, Long, Set)"
  })
  public void testBuildFullCategoryHierarchy_thenThrowIllegalStateException() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any()))
        .thenThrow(new IllegalStateException());

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(new HashMap<>());
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.buildFullCategoryHierarchy(null, cache, 1L, new HashSet<>()));
    verify(solrHelperService).getCategoryId(1L);
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.getPropertyValues(
                indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenThrow(new IllegalStateException());
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.getPropertyValues(
                indexedItem, field, FieldType.BOOLEAN, new ArrayList<>()));
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues =
        solrIndexServiceImpl.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty2()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    Map<String, Object> actualPropertyValues =
        solrIndexServiceImpl.getPropertyValues(indexedItem, field, FieldType.BOOLEAN, locales);

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_thenReturnEmpty()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.addPropertyValues(
            Mockito.<Indexable>any(),
            Mockito.<Field>any(),
            Mockito.<FieldType>any(),
            Mockito.<Map<String, Object>>any(),
            Mockito.<String>any(),
            Mockito.<List<Locale>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues =
        solrIndexServiceImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(i18nSolrIndexServiceExtensionHandler)
        .addPropertyValues(
            isA(Indexable.class),
            isA(Field.class),
            isA(FieldType.class),
            isA(Map.class),
            (String) isNull(),
            isA(List.class));
    assertTrue(actualPropertyValues.isEmpty());
  }

  /**
   * Test {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field, FieldType, List)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#getPropertyValues(Indexable, Field,
   * FieldType, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map SolrIndexServiceImpl.getPropertyValues(Indexable, Field, FieldType, List)"
  })
  public void testGetPropertyValues_thenReturnSizeIsOne()
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(solrHelperService.getPropertyValue(Mockito.<Object>any(), Mockito.<Field>any()))
        .thenReturn(GlobalSolrFullReIndexOperation.LOCK_OBJECT);
    ProductBundleImpl indexedItem = new ProductBundleImpl();
    FieldImpl field = new FieldImpl();

    // Act
    Map<String, Object> actualPropertyValues =
        solrIndexServiceImpl.getPropertyValues(
            indexedItem, field, FieldType.BOOLEAN, new ArrayList<>());

    // Assert
    verify(solrIndexServiceExtensionManager).getProxy();
    verify(solrHelperService).getPropertyValue(isA(Object.class), isA(Field.class));
    assertEquals(1, actualPropertyValues.size());
    assertTrue(actualPropertyValues.containsKey(""));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code \.}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenBackslashDot_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        solrIndexServiceImpl.convertToMappedProperty(
            "\\.", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        solrIndexServiceImpl.convertToMappedProperty(
            "", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Long}.
   *   <li>Then return {@code Long}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenJavaLangLong_thenReturnJavaLangLong() {
    // Arrange, Act and Assert
    assertEquals(
        "java.lang.Long",
        solrIndexServiceImpl.convertToMappedProperty(
            "java.lang.Long", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code java}.
   *   <li>Then return {@code Map Property Name(lang).value.Long}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenJava_thenReturnMapPropertyNameLangValueLong() {
    // Arrange, Act and Assert
    assertEquals(
        "Map Property Name(lang).value.Long",
        solrIndexServiceImpl.convertToMappedProperty(
            "java.lang.Long", "java", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertToMappedProperty(String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Property Name}.
   *   <li>Then return {@code Property Name}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertToMappedProperty(String, String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrIndexServiceImpl.convertToMappedProperty(String, String, String)"})
  public void testConvertToMappedProperty_whenPropertyName_thenReturnPropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "Property Name",
        solrIndexServiceImpl.convertToMappedProperty(
            "Property Name", "List Property Name", "Map Property Name"));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)} with {@code collection},
   * {@code server}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(String, SolrClient)"})
  public void testOptimizeIndexWithCollectionServer() throws IOException, ServiceException {
    // Arrange
    doNothing()
        .when(solrHelperService)
        .optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act
    solrIndexServiceImpl.optimizeIndex(
        "Collection", new LBHttp2SolrClient(httpClient, "https://example.org/example"));

    // Assert
    verify(solrHelperService).optimizeIndex(eq("Collection"), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)} with {@code collection},
   * {@code server}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#optimizeIndex(String, SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(String, SolrClient)"})
  public void testOptimizeIndexWithCollectionServer_thenThrowIllegalStateException()
      throws IOException, ServiceException {
    // Arrange
    doThrow(new IllegalStateException())
        .when(solrHelperService)
        .optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.optimizeIndex(
                "Collection", new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrHelperService).optimizeIndex(eq("Collection"), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)} with {@code server}.
   *
   * <ul>
   *   <li>Given {@link SolrHelperService} {@link SolrHelperService#optimizeIndex(String,
   *       SolrClient)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(SolrClient)"})
  public void testOptimizeIndexWithServer_givenSolrHelperServiceOptimizeIndexDoesNothing()
      throws IOException, ServiceException {
    // Arrange
    doNothing()
        .when(solrHelperService)
        .optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act
    solrIndexServiceImpl.optimizeIndex(
        new LBHttp2SolrClient(httpClient, "https://example.org/example"));

    // Assert
    verify(solrHelperService).optimizeIndex(isNull(), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)} with {@code server}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#optimizeIndex(SolrClient)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.optimizeIndex(SolrClient)"})
  public void testOptimizeIndexWithServer_thenThrowIllegalStateException()
      throws IOException, ServiceException {
    // Arrange
    doThrow(new IllegalStateException())
        .when(solrHelperService)
        .optimizeIndex(Mockito.<String>any(), Mockito.<SolrClient>any());

    Builder connectionTimeoutResult = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult2 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult3 = new Builder().connectionTimeout(1);

    Builder connectionTimeoutResult4 = new Builder().connectionTimeout(1);

    Builder maxConnectionsPerHostResult =
        connectionTimeoutResult3
            .withHttpClient(
                connectionTimeoutResult4
                    .withHttpClient(new Builder().build())
                    .idleTimeout(1)
                    .maxConnectionsPerHost(3)
                    .withSSLConfig(null)
                    .useHttp1_1(true)
                    .build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult2 =
        connectionTimeoutResult2
            .withHttpClient(
                maxConnectionsPerHostResult.withSSLConfig(sslConfig).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig2 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");

    Builder maxConnectionsPerHostResult3 =
        connectionTimeoutResult
            .withHttpClient(
                maxConnectionsPerHostResult2.withSSLConfig(sslConfig2).useHttp1_1(true).build())
            .idleTimeout(1)
            .maxConnectionsPerHost(3);
    SSLConfig sslConfig3 =
        new SSLConfig(true, true, "Key Store", "iloveyou", "Trust Store", "iloveyou");
    Http2SolrClient httpClient =
        maxConnectionsPerHostResult3.withSSLConfig(sslConfig3).useHttp1_1(true).build();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            solrIndexServiceImpl.optimizeIndex(
                new LBHttp2SolrClient(httpClient, "https://example.org/example")));
    verify(solrHelperService).optimizeIndex(isNull(), isA(SolrClient.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 2300000}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_thenReturnLongValueIs2300000() {
    // Arrange
    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    displayOrdersByCategoryProduct.put("42", new BigDecimal("2.3"));

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertEquals(2300000L, solrIndexServiceImpl.convertDisplayOrderToLong(cache, "42").longValue());
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_thenThrowIllegalStateException() {
    // Arrange
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.multiply(Mockito.<BigDecimal>any())).thenThrow(new IllegalStateException());

    HashMap<String, BigDecimal> displayOrdersByCategoryProduct = new HashMap<>();
    displayOrdersByCategoryProduct.put("42", internalNumber);

    CatalogStructure cache = new CatalogStructure();
    cache.setDisplayOrdersByCategoryProduct(displayOrdersByCategoryProduct);
    cache.setParentCategoriesByCategory(new HashMap<>());
    cache.setParentCategoriesByProduct(new HashMap<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> solrIndexServiceImpl.convertDisplayOrderToLong(cache, "42"));
    verify(internalNumber).multiply(isA(BigDecimal.class));
  }

  /**
   * Test {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure, String)}.
   *
   * <ul>
   *   <li>When {@code Display Order Key}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#convertDisplayOrderToLong(CatalogStructure,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long SolrIndexServiceImpl.convertDisplayOrderToLong(CatalogStructure, String)"
  })
  public void testConvertDisplayOrderToLong_whenDisplayOrderKey_thenReturnNull() {
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
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#deleteByQuery(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteByQuery(String)"})
  public void testDeleteByQuery() throws IOException, SolrServerException {
    // Arrange
    when(solrHelperService.getTypeFieldName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> solrIndexServiceImpl.deleteByQuery("Delete Query"));
    verify(solrHelperService).getTypeFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#deleteByQuery(String)}.
   *
   * <ul>
   *   <li>Then calls {@link SolrConfiguration#getServer()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#deleteByQuery(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.deleteByQuery(String)"})
  public void testDeleteByQuery_thenCallsGetServer() throws IOException, SolrServerException {
    // Arrange
    when(solrHelperService.getPrimaryDocumentType()).thenReturn("Primary Document Type");
    when(solrHelperService.getTypeFieldName()).thenReturn("Type Field Name");
    when(solrConfiguration.getServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> solrIndexServiceImpl.deleteByQuery("Delete Query"));
    verify(solrConfiguration).getServer();
    verify(solrHelperService).getPrimaryDocumentType();
    verify(solrHelperService).getTypeFieldName();
  }

  /**
   * Test {@link SolrIndexServiceImpl#addDocuments(Collection)}.
   *
   * <p>Method under test: {@link SolrIndexServiceImpl#addDocuments(Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SolrIndexServiceImpl.addDocuments(Collection)"})
  public void testAddDocuments() throws IOException, SolrServerException {
    // Arrange
    when(solrConfiguration.getServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> solrIndexServiceImpl.addDocuments(new ArrayList<>()));
    verify(solrConfiguration).getServer();
  }
}
