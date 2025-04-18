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
package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
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
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.search.dao.CatalogStructure;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.dao.SolrIndexDao;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.service.solr.DelegatingHttpSolrClient;
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexServiceExtensionManager;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(MockitoJUnitRunner.class)
public class CatalogSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @Mock
  private CatalogDocumentBuilder catalogDocumentBuilder;

  @InjectMocks
  private CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;

  @Mock
  private IndexFieldDao indexFieldDao;

  @Mock
  private LocaleService localeService;

  @Mock
  private PlatformTransactionManager platformTransactionManager;

  @Mock
  private ProductDao productDao;

  @Mock
  private SandBoxHelper sandBoxHelper;

  @Mock
  private SiteService siteService;

  @Mock
  private SolrConfiguration solrConfiguration;

  @Mock
  private SolrHelperService solrHelperService;

  @Mock
  private SolrIndexDao solrIndexDao;

  @Mock
  private SolrIndexQueueProvider solrIndexQueueProvider;

  @Mock
  private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCommand(SolrUpdateCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeCommand(SolrUpdateCommand)"})
  public void testExecuteCommand() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class,
        () -> (new CatalogSolrIndexUpdateCommandHandlerImpl()).executeCommand(FullReindexCommand.DEFAULT_INSTANCE));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable,
        fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl2() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable,
        fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable,
        fields, locales);

    // Assert
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl2() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable,
        fields, locales);

    // Assert
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_thenReturnNull() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable,
        fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with {@code indexable}, {@code fields}, {@code locales}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"})
  public void testBuildDocumentWithIndexableFieldsLocales_thenThrowIllegalStateException() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenThrow(new IllegalStateException("foo"));
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable, fields, new ArrayList<>()));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code indexable}.
   * <ul>
   *   <li>Then calls {@link LocaleImpl#getLocaleCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"})
  public void testBuildDocumentWithIndexable_thenCallsGetLocaleCode() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    when(localeImpl.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(localeImpl);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl
        .buildDocument(new ProductBundleImpl());

    // Assert
    verify(localeImpl, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code indexable}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"})
  public void testBuildDocumentWithIndexable_thenReturnNull() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    SolrInputDocument actualBuildDocumentResult = catalogSolrIndexUpdateCommandHandlerImpl
        .buildDocument(new ProductBundleImpl());

    // Assert
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code indexable}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"})
  public void testBuildDocumentWithIndexable_thenThrowIllegalStateException() {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(new ProductBundleImpl()));
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand() throws ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);
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
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE));
    verify(solrConfiguration, atLeast(1)).getReindexName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(solrConfiguration, atLeast(1)).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand2() throws ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);
    HttpSolrClient.Builder withConnectionTimeoutResult = (new HttpSolrClient.Builder())
        .withBaseSolrUrl("https://example.org/example")
        .allowCompression(true)
        .withConnectionTimeout(10);
    HttpSolrClient.Builder withHttpClientResult = withConnectionTimeoutResult.withHttpClient(new AutoRetryHttpClient());
    HttpSolrClient delegate = withHttpClientResult.withResponseParser(new BinaryResponseParser())
        .withSocketTimeout(10)
        .build();
    when(solrConfiguration.getReindexServer()).thenReturn(new DelegatingHttpSolrClient(delegate));
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE));
    verify(solrConfiguration, atLeast(1)).getReindexName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(solrConfiguration, atLeast(1)).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand3() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException("(*:*)"));
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.rollback(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE));
    verify(lbHttp2SolrClient, atLeast(1)).commit(isNull(), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery((String) isNull(), eq("(*:*)"));
    verify(lbHttp2SolrClient).rollback(eq("Reindex Name"));
    verify(solrConfiguration, atLeast(1)).getReindexName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(solrConfiguration, atLeast(1)).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <ul>
   *   <li>Given {@link LBHttp2SolrClient} {@link SolrClient#commit(String, boolean, boolean, boolean)} return {@link UpdateResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand_givenLBHttp2SolrClientCommitReturnUpdateResponse()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.rollback(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE);

    // Assert
    verify(lbHttp2SolrClient).commit(isNull(), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery((String) isNull(), eq("(*:*)"));
    verify(lbHttp2SolrClient).rollback(eq("Reindex Name"));
    verify(solrConfiguration, atLeast(1)).getReindexName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(solrConfiguration, atLeast(1)).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand_thenCallsDeleteByQuery()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.rollback(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE);

    // Assert
    verify(lbHttp2SolrClient).deleteByQuery((String) isNull(), eq("(*:*)"));
    verify(lbHttp2SolrClient).rollback(eq("Reindex Name"));
    verify(solrConfiguration, atLeast(1)).getReindexName();
    verify(solrConfiguration, atLeast(1)).getReindexServer();
    verify(solrConfiguration, atLeast(1)).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"})
  public void testExecuteFullReindexCommand_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenThrow(new UnsupportedOperationException("(*:*)"));
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand.DEFAULT_INSTANCE));
    verify(solrConfiguration).getReindexName();
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogSolrIndexUpdateCommandHandlerImpl.executeCatalogReindexCommand(CatalogReindexCommand)"})
  public void testExecuteCatalogReindexCommand_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeCatalogReindexCommand(new CatalogReindexCommand(1L)));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.executeSiteReindexCommand(SiteReindexCommand)"})
  public void testExecuteSiteReindexCommand_thenThrowUnsupportedOperationException() throws ServiceException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.executeSiteReindexCommand(new SiteReindexCommand(1L)));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments(String, boolean)"})
  public void testDeleteAllDocuments() throws ServiceException {
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
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments("Collection", true));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments(String, boolean)"})
  public void testDeleteAllDocuments2() throws ServiceException {
    // Arrange
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
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments("Collection", true));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#commit(String, boolean, boolean, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments(String, boolean)"})
  public void testDeleteAllDocuments_thenCallsCommit() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments("Collection", true);

    // Assert
    verify(lbHttp2SolrClient).commit(isNull(), eq(true), eq(true), eq(false));
    verify(lbHttp2SolrClient).deleteByQuery((String) isNull(), eq("(*:*)"));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link SolrClient#deleteByQuery(String, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments(String, boolean)"})
  public void testDeleteAllDocuments_whenFalse_thenCallsDeleteByQuery()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.deleteByQuery(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments("Collection", false);

    // Assert
    verify(lbHttp2SolrClient).deleteByQuery((String) isNull(), eq("(*:*)"));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges() throws ServiceException {
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
    when(solrConfiguration.getReindexServer())
        .thenReturn(new LBHttp2SolrClient(httpClient5, "https://example.org/example"));

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", true, true));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges2() throws ServiceException {
    // Arrange
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
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", true, true));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges3() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, true);

    // Assert
    verify(lbHttp2SolrClient).commit(isNull(), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getReindexServer();
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges4() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException("Issuing commit to Solr index: "));
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, true));
    verify(lbHttp2SolrClient, atLeast(1)).commit(isNull(), eq(true), eq(true), eq(false));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges5() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenThrow(new IllegalStateException("Issuing commit to Solr index: "));
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act and Assert
    assertThrows(ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, false));
    verify(lbHttp2SolrClient, atLeast(1)).commit(isNull(), eq(true), eq(true), eq(false));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <ul>
   *   <li>Given {@link LBHttp2SolrClient} {@link SolrClient#commit(String, boolean, boolean, boolean)} return {@link UpdateResponse} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges_givenLBHttp2SolrClientCommitReturnUpdateResponse()
      throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, false);

    // Assert
    verify(lbHttp2SolrClient).commit(isNull(), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <ul>
   *   <li>Then calls {@link SolrClient#rollback(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges_thenCallsRollback() throws IOException, SolrServerException, ServiceException {
    // Arrange
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.rollback(Mockito.<String>any())).thenReturn(new UpdateResponse());
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", true, true);

    // Assert
    verify(lbHttp2SolrClient).rollback(eq("Collection"));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}.
   * <ul>
   *   <li>Then calls {@link SolrHelperService#swapActiveCores(SolrConfiguration)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"})
  public void testFinalizeChanges_thenCallsSwapActiveCores() throws IOException, SolrServerException, ServiceException {
    // Arrange
    doNothing().when(solrHelperService).swapActiveCores(Mockito.<SolrConfiguration>any());
    LBHttp2SolrClient lbHttp2SolrClient = mock(LBHttp2SolrClient.class);
    when(lbHttp2SolrClient.commit(Mockito.<String>any(), anyBoolean(), anyBoolean(), anyBoolean()))
        .thenReturn(new UpdateResponse());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);
    when(solrConfiguration.getReindexServer()).thenReturn(lbHttp2SolrClient);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, true);

    // Assert
    verify(lbHttp2SolrClient).commit(isNull(), eq(true), eq(true), eq(false));
    verify(solrConfiguration).getReindexServer();
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ThreadPoolTaskExecutor CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundOperationExecutor()"})
  public void testCreateBackgroundOperationExecutor() {
    // Arrange and Act
    ThreadPoolTaskExecutor actualCreateBackgroundOperationExecutorResult = catalogSolrIndexUpdateCommandHandlerImpl
        .createBackgroundOperationExecutor();

    // Assert
    assertEquals("catalog-solr-reindex-worker-", actualCreateBackgroundOperationExecutorResult.getThreadNamePrefix());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getActiveCount());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getPoolSize());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getQueueSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getCorePoolSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getMaxPoolSize());
    assertEquals(5, actualCreateBackgroundOperationExecutorResult.getThreadPriority());
    assertEquals(60, actualCreateBackgroundOperationExecutorResult.getKeepAliveSeconds());
    assertFalse(actualCreateBackgroundOperationExecutorResult.isDaemon());
    assertEquals(Integer.MAX_VALUE, actualCreateBackgroundOperationExecutorResult.getQueueCapacity());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"})
  public void testCreateBackgroundRunnable_givenOne_whenArrayListAddOne() {
    // Arrange
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals("blPU",
        catalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"})
  public void testCreateBackgroundRunnable_givenZero_whenArrayListAddZero() {
    // Arrange
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals("blPU",
        catalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"})
  public void testCreateBackgroundRunnable_whenArrayList() {
    // Arrange
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    ArrayList<Long> ids = new ArrayList<>();
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals("blPU",
        catalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage() throws Exception {
    // Arrange
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(sandBoxHelper)
        .ignoreCloneCache(anyBoolean());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(sandBoxHelper).ignoreCloneCache(eq(true));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage2() throws Exception {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link CatalogDocumentBuilder} {@link DocumentBuilder#buildDocument(Indexable, List, List)} return {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenCatalogDocumentBuilderBuildDocumentReturnNull_thenReturnEmpty() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertTrue(actualBuildPageResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl2() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnSizeIsOne() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnSizeIsOne2() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add one.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenOne_whenArrayListAddOne_thenReturnEmpty() throws Exception {
    // Arrange
    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertTrue(catalogSolrIndexUpdateCommandHandlerImpl
        .buildPage(productIds, products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true))
        .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given {@link SandBoxHelper}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenSandBoxHelper_thenReturnEmpty() throws Exception {
    // Arrange
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertTrue(catalogSolrIndexUpdateCommandHandlerImpl
        .buildPage(productIds, products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true))
        .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then calls {@link ReindexStateHolder#incrementIndexableCount(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenThree_thenCallsIncrementIndexableCount() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();
    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.incrementIndexableCount(anyLong())).thenReturn(3L);

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, holder);

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    verify(holder).incrementIndexableCount(eq(1L));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Given zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add zero.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_givenZero_whenArrayListAddZero_thenReturnEmpty() throws Exception {
    // Arrange
    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(0L);
    productIds.add(1L);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertTrue(catalogSolrIndexUpdateCommandHandlerImpl
        .buildPage(productIds, products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true))
        .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_thenReturnSizeIsOne() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(1, actualBuildPageResult.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List, ReindexStateHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"})
  public void testBuildPage_thenReturnSizeIsTwo() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(mock(SolrInputDocument.class));
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult = catalogSolrIndexUpdateCommandHandlerImpl.buildPage(productIds,
        products, locales, fields, ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).modifyBuiltDocuments(isA(Collection.class), isA(List.class),
        isA(List.class), isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder, atLeast(1)).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertEquals(2, actualBuildPageResult.size());
    assertSame(actualBuildPageResult.get(0), actualBuildPageResult.get(1));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"})
  public void testBuildIncrementalIndex() throws Exception {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(sandBoxHelper)
        .ignoreCloneCache(anyBoolean());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateCommandHandlerImpl
        .buildIncrementalIndex(productIds, products, holder, catalog, new SiteImpl()));
    verify(localeService).findAllLocales();
    verify(sandBoxHelper).ignoreCloneCache(eq(true));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}.
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"})
  public void testBuildIncrementalIndex2() throws Exception {
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException("ThreadLocalManager.notify.orphans")).when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> catalogSolrIndexUpdateCommandHandlerImpl
        .buildIncrementalIndex(productIds, products, holder, catalog, new SiteImpl()));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}.
   * <ul>
   *   <li>Then calls {@link DocumentBuilder#buildDocument(Indexable, List, List)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"})
  public void testBuildIncrementalIndex_thenCallsBuildDocument() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(),
        Mockito.<List<Locale>>any())).thenReturn(null);
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler = mock(
        I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any())).thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing().when(solrIndexDao)
        .populateProductCatalogStructure(Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(productIds, products, holder, catalog,
        new SiteImpl());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder).buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterProcess(ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadIdBatch(ReindexStateHolder, Long, int, Long)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadProducts(ReindexStateHolder, List)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforePage(List, List, List, List, ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeProcess(ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadIdBatch(ReindexStateHolder, Long, int, Long)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadProducts(ReindexStateHolder, List)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getBackgroundOperationExecutor()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalCommitInterval()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getSolrConfiguration()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getThreadsForBackgroundExecution()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CatalogSolrIndexUpdateCommandHandlerImpl.afterBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.afterProcess(ReindexStateHolder)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.afterReadIdBatch(ReindexStateHolder, Long, int, Long)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.afterReadProducts(ReindexStateHolder, List)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.beforeBackgroundThread(ReindexStateHolder, Catalog, Site, SandBox)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.beforePage(List, List, List, List, ReindexStateHolder)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.beforeProcess(ReindexStateHolder)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.beforeReadIdBatch(ReindexStateHolder, Long, int, Long)",
      "void CatalogSolrIndexUpdateCommandHandlerImpl.beforeReadProducts(ReindexStateHolder, List)",
      "ThreadPoolTaskExecutor CatalogSolrIndexUpdateCommandHandlerImpl.getBackgroundOperationExecutor()",
      "long CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalCommitInterval()",
      "SolrConfiguration CatalogSolrIndexUpdateCommandHandlerImpl.getSolrConfiguration()",
      "int CatalogSolrIndexUpdateCommandHandlerImpl.getThreadsForBackgroundExecution()"})
  public void testGettersAndSetters() throws IllegalStateException, ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl = new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.afterBackgroundThread(holder, catalog, site, new SandBoxImpl());
    catalogSolrIndexUpdateCommandHandlerImpl
        .afterProcess(ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .afterReadIdBatch(ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder2 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.afterReadProducts(holder2, new ArrayList<>());
    ReindexStateHolder holder3 = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog2 = new CatalogImpl();
    SiteImpl site2 = new SiteImpl();
    catalogSolrIndexUpdateCommandHandlerImpl.beforeBackgroundThread(holder3, catalog2, site2, new SandBoxImpl());
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    ArrayList<IndexField> fields = new ArrayList<>();
    catalogSolrIndexUpdateCommandHandlerImpl.beforePage(productIds, products, locales, fields,
        ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .beforeProcess(ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl
        .beforeReadIdBatch(ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder4 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.beforeReadProducts(holder4, new ArrayList<>());
    ThreadPoolTaskExecutor actualBackgroundOperationExecutor = catalogSolrIndexUpdateCommandHandlerImpl
        .getBackgroundOperationExecutor();
    long actualIncrementalCommitInterval = catalogSolrIndexUpdateCommandHandlerImpl.getIncrementalCommitInterval();
    SolrConfiguration actualSolrConfiguration = catalogSolrIndexUpdateCommandHandlerImpl.getSolrConfiguration();
    int actualThreadsForBackgroundExecution = catalogSolrIndexUpdateCommandHandlerImpl
        .getThreadsForBackgroundExecution();

    // Assert
    assertEquals("catalog-solr-reindex-worker-", actualBackgroundOperationExecutor.getThreadNamePrefix());
    assertNull(actualSolrConfiguration);
    ThreadPoolExecutor threadPoolExecutor = actualBackgroundOperationExecutor.getThreadPoolExecutor();
    assertEquals(0, threadPoolExecutor.getActiveCount());
    assertEquals(0, threadPoolExecutor.getLargestPoolSize());
    assertEquals(0, threadPoolExecutor.getPoolSize());
    assertEquals(0, actualBackgroundOperationExecutor.getActiveCount());
    assertEquals(0, actualBackgroundOperationExecutor.getPoolSize());
    assertEquals(0, actualBackgroundOperationExecutor.getQueueSize());
    assertEquals(0L, threadPoolExecutor.getCompletedTaskCount());
    assertEquals(0L, threadPoolExecutor.getTaskCount());
    assertEquals(10, threadPoolExecutor.getCorePoolSize());
    assertEquals(10, threadPoolExecutor.getMaximumPoolSize());
    assertEquals(10, actualThreadsForBackgroundExecution);
    assertEquals(10, actualBackgroundOperationExecutor.getCorePoolSize());
    assertEquals(10, actualBackgroundOperationExecutor.getMaxPoolSize());
    assertEquals(30000L, actualIncrementalCommitInterval);
    assertEquals(5, actualBackgroundOperationExecutor.getThreadPriority());
    assertEquals(60, actualBackgroundOperationExecutor.getKeepAliveSeconds());
    assertFalse(actualBackgroundOperationExecutor.isDaemon());
    assertEquals(Integer.MAX_VALUE, actualBackgroundOperationExecutor.getQueueCapacity());
  }
}
