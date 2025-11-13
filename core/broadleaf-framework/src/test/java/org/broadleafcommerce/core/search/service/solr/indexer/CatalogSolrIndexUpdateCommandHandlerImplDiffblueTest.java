package org.broadleafcommerce.core.search.service.solr.indexer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
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
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.index.I18nSolrIndexServiceExtensionHandler;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
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
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.SimpleTransactionStatus;

@RunWith(MockitoJUnitRunner.class)
public class CatalogSolrIndexUpdateCommandHandlerImplDiffblueTest {
  @Mock private CatalogDocumentBuilder catalogDocumentBuilder;

  @InjectMocks
  private CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl;

  @Mock private IndexFieldDao indexFieldDao;

  @Mock private LocaleService localeService;

  @Mock private PlatformTransactionManager platformTransactionManager;

  @Mock private ProductDao productDao;

  @Mock private SandBoxHelper sandBoxHelper;

  @Mock private SiteService siteService;

  @Mock private SolrConfiguration solrConfiguration;

  @Mock private SolrHelperService solrHelperService;

  @Mock private SolrIndexDao solrIndexDao;

  @Mock private SolrIndexServiceExtensionManager solrIndexServiceExtensionManager;

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code
   * indexable}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"
  })
  public void testBuildDocumentWithIndexable() {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(new ProductBundleImpl()));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code
   * indexable}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"
  })
  public void testBuildDocumentWithIndexable2() {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(new ProductBundleImpl()));
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(
            indexable, fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_givenIndexFieldImpl2() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(
            indexable, fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable, fields, locales);

    // Assert
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_givenLocaleImpl2() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(indexable, fields, locales);

    // Assert
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_thenReturnNull() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(
            indexable, fields, new ArrayList<>());

    // Assert
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable, List, List)} with
   * {@code indexable}, {@code fields}, {@code locales}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable,
   * List, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable, List, List)"
  })
  public void testBuildDocumentWithIndexableFieldsLocales_thenThrowIllegalStateException() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenThrow(new IllegalStateException());
    ProductBundleImpl indexable = new ProductBundleImpl();
    ArrayList<IndexField> fields = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(
                indexable, fields, new ArrayList<>()));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code
   * indexable}.
   *
   * <ul>
   *   <li>Then calls {@link Locale#getLocaleCode()}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"
  })
  public void testBuildDocumentWithIndexable_thenCallsGetLocaleCode() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(new ProductBundleImpl());

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)} with {@code
   * indexable}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildDocument(Indexable)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "SolrInputDocument CatalogSolrIndexUpdateCommandHandlerImpl.buildDocument(Indexable)"
  })
  public void testBuildDocumentWithIndexable_thenReturnNull() {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    SolrInputDocument actualBuildDocumentResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildDocument(new ProductBundleImpl());

    // Assert
    verify(localeService).findAllLocales();
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualBuildDocumentResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"
  })
  public void testExecuteFullReindexCommand() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(solrConfiguration.getReindexName()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(
                FullReindexCommand.DEFAULT_INSTANCE));
    verify(solrConfiguration).getReindexName();
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}.
   *
   * <ul>
   *   <li>Then calls {@link SolrConfiguration#isSingleCoreMode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeFullReindexCommand(FullReindexCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(FullReindexCommand)"
  })
  public void testExecuteFullReindexCommand_thenCallsIsSingleCoreMode() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenThrow(new IllegalStateException());
    when(solrConfiguration.getReindexName()).thenReturn("Reindex Name");

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.executeFullReindexCommand(
                FullReindexCommand.DEFAULT_INSTANCE));
    verify(solrConfiguration).getReindexName();
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeCatalogReindexCommand(CatalogReindexCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.executeCatalogReindexCommand(CatalogReindexCommand)"
  })
  public void testExecuteCatalogReindexCommand_thenThrowUnsupportedOperationException()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.executeCatalogReindexCommand(
                new CatalogReindexCommand(1L)));
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#executeSiteReindexCommand(SiteReindexCommand)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.executeSiteReindexCommand(SiteReindexCommand)"
  })
  public void testExecuteSiteReindexCommand_thenThrowUnsupportedOperationException()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.executeSiteReindexCommand(
                new SiteReindexCommand(1L)));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}.
   *
   * <ul>
   *   <li>Given {@link Locale} {@link Locale#getLocaleCode()} return {@code en}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CatalogSolrIndexUpdateCommandHandlerImpl.getAllLocales()"})
  public void testGetAllLocales_givenLocaleGetLocaleCodeReturnEn_thenReturnSizeIsOne() {
    // Arrange
    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    List<Locale> actualAllLocales = catalogSolrIndexUpdateCommandHandlerImpl.getAllLocales();

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    assertEquals(1, actualAllLocales.size());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CatalogSolrIndexUpdateCommandHandlerImpl.getAllLocales()"})
  public void testGetAllLocales_thenReturnEmpty() {
    // Arrange
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());

    // Act
    List<Locale> actualAllLocales = catalogSolrIndexUpdateCommandHandlerImpl.getAllLocales();

    // Assert
    verify(localeService).findAllLocales();
    assertTrue(actualAllLocales.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#getAllLocales()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CatalogSolrIndexUpdateCommandHandlerImpl.getAllLocales()"})
  public void testGetAllLocales_thenThrowIllegalStateException() {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.getAllLocales());
    verify(localeService).findAllLocales();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(SolrIndexCachedOperation.CacheOperation)"
  })
  public void testPerformCachedOperation_thenThrowIllegalStateException() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    CacheOperation cacheOperation = mock(CacheOperation.class);
    doThrow(new IllegalStateException()).when(cacheOperation).execute();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(cacheOperation));
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(CacheOperation)}.
   *
   * <ul>
   *   <li>When {@link SolrIndexCachedOperation.CacheOperation} {@link
   *       SolrIndexCachedOperation.CacheOperation#execute()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#performCachedOperation(SolrIndexCachedOperation.CacheOperation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(SolrIndexCachedOperation.CacheOperation)"
  })
  public void testPerformCachedOperation_whenCacheOperationExecuteDoesNothing()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    CacheOperation cacheOperation = mock(CacheOperation.class);
    doNothing().when(cacheOperation).execute();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.performCachedOperation(cacheOperation);

    // Assert
    verify(cacheOperation).execute();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex() throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(
                holder, 1L, 1L, new SandBoxImpl()));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex2() throws ServiceException {
    // Arrange
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(siteService.retrieveNonPersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(holder, 1L, 1L, new SandBoxImpl());

    // Assert
    verify(siteService).findCatalogById(1L);
    verify(siteService).retrieveNonPersistentSiteById(1L);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex_givenCatalogSolrIndexUpdateCommandHandlerImpl()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.getFailure()).thenReturn(new Exception());
    doNothing().when(holder).failFast(Mockito.<Exception>any());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(
                holder, 1L, 1L, new SandBoxImpl()));
    verify(holder).failFast(isA(Exception.class));
    verify(holder).getFailure();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex_givenCatalogSolrIndexUpdateCommandHandlerImpl_whenNull()
      throws ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.getFailure()).thenReturn(new Exception());
    doNothing().when(holder).failFast(Mockito.<Exception>any());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(
                holder, null, 1L, new SandBoxImpl()));
    verify(holder).failFast(isA(Exception.class));
    verify(holder).getFailure();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex_givenIllegalStateException() throws ServiceException {
    // Arrange
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(siteService.retrieveNonPersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.getFailure()).thenReturn(new Exception());
    doNothing().when(holder).failFast(Mockito.<Exception>any());
    when(holder.isFailed()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(
                holder, 1L, 1L, new SandBoxImpl()));
    verify(siteService).findCatalogById(1L);
    verify(siteService).retrieveNonPersistentSiteById(1L);
    verify(holder).failFast(isA(Exception.class));
    verify(holder).getFailure();
    verify(holder).isFailed();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex_givenIllegalStateException2() throws ServiceException {
    // Arrange
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.getFailure()).thenReturn(new Exception());
    doNothing().when(holder).failFast(Mockito.<Exception>any());
    when(holder.isFailed()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(
                holder, 1L, null, new SandBoxImpl()));
    verify(siteService).findCatalogById(1L);
    verify(holder).failFast(isA(Exception.class));
    verify(holder).getFailure();
    verify(holder).isFailed();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long,
   * Long, SandBox)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link ReindexStateHolder} {@link ReindexStateHolder#isFailed()} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#populateIndex(ReindexStateHolder, Long, Long,
   * SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.populateIndex(ReindexStateHolder, Long, Long, SandBox)"
  })
  public void testPopulateIndex_givenTrue_whenReindexStateHolderIsFailedReturnTrue()
      throws ServiceException {
    // Arrange
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(siteService.retrieveNonPersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.isFailed()).thenReturn(true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.populateIndex(holder, 1L, 1L, new SandBoxImpl());

    // Assert
    verify(siteService).findCatalogById(1L);
    verify(siteService).retrieveNonPersistentSiteById(1L);
    verify(holder).isFailed();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#deleteAllDocuments(String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments(String, boolean)"
  })
  public void testDeleteAllDocuments() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.deleteAllDocuments("Collection", true));
    verify(solrConfiguration).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"
  })
  public void testFinalizeChanges_whenFalse() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, true));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"
  })
  public void testFinalizeChanges_whenFalse2() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", false, false));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String, boolean,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#finalizeChanges(String,
   * boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges(String, boolean, boolean)"
  })
  public void testFinalizeChanges_whenTrue() throws ServiceException {
    // Arrange
    when(solrConfiguration.getReindexServer()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        ServiceException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.finalizeChanges("Collection", true, true));
    verify(solrConfiguration, atLeast(1)).getReindexServer();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.swapCollections()"})
  public void testSwapCollections() throws ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenReturn(true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.swapCollections();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.swapCollections()"})
  public void testSwapCollections2() throws ServiceException {
    // Arrange
    when(solrConfiguration.isSingleCoreMode()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.swapCollections());
    verify(solrConfiguration).isSingleCoreMode();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.swapCollections()"})
  public void testSwapCollections3() throws ServiceException {
    // Arrange
    doThrow(new IllegalStateException())
        .when(solrHelperService)
        .swapActiveCores(Mockito.<SolrConfiguration>any());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.swapCollections());
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}.
   *
   * <ul>
   *   <li>Given {@link SolrHelperService} {@link
   *       SolrHelperService#swapActiveCores(SolrConfiguration)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#swapCollections()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CatalogSolrIndexUpdateCommandHandlerImpl.swapCollections()"})
  public void testSwapCollections_givenSolrHelperServiceSwapActiveCoresDoesNothing()
      throws ServiceException {
    // Arrange
    doNothing().when(solrHelperService).swapActiveCores(Mockito.<SolrConfiguration>any());
    when(solrConfiguration.isSingleCoreMode()).thenReturn(false);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.swapCollections();

    // Assert
    verify(solrConfiguration).isSingleCoreMode();
    verify(solrHelperService).swapActiveCores(isA(SolrConfiguration.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundOperationExecutor()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ThreadPoolTaskExecutor CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundOperationExecutor()"
  })
  public void testCreateBackgroundOperationExecutor() {
    // Arrange and Act
    ThreadPoolTaskExecutor actualCreateBackgroundOperationExecutorResult =
        new CatalogSolrIndexUpdateCommandHandlerImpl().createBackgroundOperationExecutor();

    // Assert
    assertEquals(
        "catalog-solr-reindex-worker-",
        actualCreateBackgroundOperationExecutorResult.getThreadNamePrefix());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getActiveCount());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getPoolSize());
    assertEquals(0, actualCreateBackgroundOperationExecutorResult.getQueueSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getCorePoolSize());
    assertEquals(10, actualCreateBackgroundOperationExecutorResult.getMaxPoolSize());
    assertEquals(5, actualCreateBackgroundOperationExecutorResult.getThreadPriority());
    assertEquals(60, actualCreateBackgroundOperationExecutorResult.getKeepAliveSeconds());
    assertFalse(actualCreateBackgroundOperationExecutorResult.isDaemon());
    assertEquals(
        Integer.MAX_VALUE, actualCreateBackgroundOperationExecutorResult.getQueueCapacity());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"
  })
  public void testCreateBackgroundRunnable_givenOne_whenArrayListAddOne() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals(
        "blPU",
        catalogSolrIndexUpdateCommandHandlerImpl
            .createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"
  })
  public void testCreateBackgroundRunnable_givenZero_whenArrayListAddZero() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals(
        "blPU",
        catalogSolrIndexUpdateCommandHandlerImpl
            .createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#createBackgroundRunnable(ReindexStateHolder, List,
   * Semaphore, Long, Long, SandBox)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.EntityManagerAwareRunnable CatalogSolrIndexUpdateCommandHandlerImpl.createBackgroundRunnable(ReindexStateHolder, List, Semaphore, Long, Long, SandBox)"
  })
  public void testCreateBackgroundRunnable_whenArrayList() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    ArrayList<Long> ids = new ArrayList<>();
    Semaphore sem = new Semaphore(1);

    // Act and Assert
    assertEquals(
        "blPU",
        catalogSolrIndexUpdateCommandHandlerImpl
            .createBackgroundRunnable(holder, ids, sem, 1L, 1L, new SandBoxImpl())
            .getEntityManagerName());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation() throws Throwable {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(localeService).findAllLocales();
    verify(productDao).readProductsByIds(isA(List.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation2() throws Throwable {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(new I18nSolrIndexServiceExtensionHandler());
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(productDao).readProductsByIds(isA(List.class));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation3() throws Throwable {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenReturn(null);
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(productDao).readProductsByIds(isA(List.class));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation4() throws Throwable {
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(productDao).readProductsByIds(isA(List.class));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao)
        .populateProductCatalogStructure(isA(List.class), isA(CatalogStructure.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_givenArrayListAddLocaleImpl() throws Throwable {
    // Arrange
    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(new LocaleImpl());
    when(localeService.findAllLocales()).thenReturn(localeList);

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(localeService).findAllLocales();
    verify(productDao).readProductsByIds(isA(List.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_givenCatalogSolrIndexUpdateCommandHandlerImpl()
      throws Throwable {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act and Assert
    assertNull(
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_givenZero_whenArrayListAddZero() throws Throwable {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(0L);
    ids.add(1L);

    // Act and Assert
    assertNull(
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute());
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogDocumentBuilder#buildDocument(Indexable, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_thenCallsBuildDocument() throws Throwable {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(productDao).readProductsByIds(isA(List.class));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao)
        .populateProductCatalogStructure(isA(List.class), isA(CatalogStructure.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ReindexStateHolder#failFast(Exception)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_thenCallsFailFast() throws Throwable {
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    ArrayList<Product> productList = new ArrayList<>();
    productList.add(new ProductBundleImpl());
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(productList);
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new UnsupportedOperationException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    doNothing().when(holder).failFast(Mockito.<Exception>any());
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(productDao).readProductsByIds(isA(List.class));
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao)
        .populateProductCatalogStructure(isA(List.class), isA(CatalogStructure.class));
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(holder).failFast(isA(Exception.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductDao#readProductsByIds(List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_thenCallsReadProductsByIds() throws Throwable {
    // Arrange
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    ArrayList<Long> ids = new ArrayList<>();
    ids.add(1L);

    // Act
    Void actualExecuteResult =
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, ids)
            .execute();

    // Assert
    verify(productDao).readProductsByIds(isA(List.class));
    assertNull(actualExecuteResult);
  }

  /**
   * Test {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalIndexOperation(ReindexStateHolder,
   * Catalog, Site, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.util.tenant.IdentityOperation CatalogSolrIndexUpdateCommandHandlerImpl.getIncrementalIndexOperation(ReindexStateHolder, Catalog, Site, List)"
  })
  public void testGetIncrementalIndexOperation_whenArrayList() throws Throwable {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act and Assert
    assertNull(
        catalogSolrIndexUpdateCommandHandlerImpl
            .getIncrementalIndexOperation(holder, catalog, site, new ArrayList<>())
            .execute());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage() throws Exception {
    // Arrange
    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage2() throws Exception {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage3() throws Exception {
    // Arrange
    when(solrIndexServiceExtensionManager.getProxy()).thenThrow(new IllegalStateException());
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link CatalogDocumentBuilder} {@link
   *       CatalogDocumentBuilder#buildDocument(Indexable, List, List)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenCatalogDocumentBuilderBuildDocumentReturnNull() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act
    List<SolrInputDocument> actualBuildPageResult =
        catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
            productIds,
            products,
            locales,
            new ArrayList<>(),
            ReindexStateHolder.getInstance("Collection Name", true, true));

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    assertTrue(actualBuildPageResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link CatalogDocumentBuilder} {@link
   *       CatalogDocumentBuilder#buildDocument(Indexable, List, List)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenCatalogDocumentBuilderBuildDocumentThrowIllegalStateException()
      throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenThrow(new IllegalStateException());

    I18nSolrIndexServiceExtensionHandler i18nSolrIndexServiceExtensionHandler =
        mock(I18nSolrIndexServiceExtensionHandler.class);
    when(i18nSolrIndexServiceExtensionHandler.endBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(i18nSolrIndexServiceExtensionHandler.startBatchEvent(Mockito.<List<Indexable>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(solrIndexServiceExtensionManager.getProxy())
        .thenReturn(i18nSolrIndexServiceExtensionHandler);
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenCatalogSolrIndexUpdateCommandHandlerImpl_thenReturnEmpty()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenCatalogSolrIndexUpdateCommandHandlerImpl_whenNull()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                null,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl_thenReturnEmpty()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                fields,
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link IndexFieldImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenIndexFieldImpl_whenArrayListAddIndexFieldImpl_thenReturnEmpty2()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    ArrayList<IndexField> fields = new ArrayList<>();
    fields.add(new IndexFieldImpl());
    fields.add(new IndexFieldImpl());

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                fields,
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link LocaleImpl} (default constructor).
   *   <li>When {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenLocaleImpl_whenArrayListAddLocaleImpl_thenReturnEmpty2()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    ArrayList<Locale> locales = new ArrayList<>();
    locales.add(new LocaleImpl());
    locales.add(new LocaleImpl());

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenOne_whenArrayListAddOne_thenReturnEmpty() throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@link SandBoxHelper} {@link SandBoxHelper#ignoreCloneCache(boolean)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenSandBoxHelperIgnoreCloneCacheThrowIllegalStateException()
      throws Exception {
    // Arrange
    doThrow(new IllegalStateException()).when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true)));
    verify(sandBoxHelper).ignoreCloneCache(true);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List, List, List,
   * ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildPage(List, List,
   * List, List, ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.buildPage(List, List, List, List, ReindexStateHolder)"
  })
  public void testBuildPage_givenZero_whenArrayListAddZero_thenReturnEmpty() throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(0L);
    productIds.add(1L);
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();

    // Act and Assert
    assertTrue(
        catalogSolrIndexUpdateCommandHandlerImpl
            .buildPage(
                productIds,
                products,
                locales,
                new ArrayList<>(),
                ReindexStateHolder.getInstance("Collection Name", true, true))
            .isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder,
   * List)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(ReindexStateHolder, List)"
  })
  public void testReadProductsByIds_givenZero_whenArrayListAddZero_thenReturnEmpty()
      throws Exception {
    // Arrange
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(0L);
    productIds.add(1L);

    // Act
    List<Product> actualReadProductsByIdsResult =
        catalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(holder, productIds);

    // Assert
    verify(productDao).readProductsByIds(isA(List.class));
    assertTrue(actualReadProductsByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder,
   * List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(ReindexStateHolder, List)"
  })
  public void testReadProductsByIds_thenReturnEmpty() throws Exception {
    // Arrange
    when(productDao.readProductsByIds(Mockito.<List<Long>>any())).thenReturn(new ArrayList<>());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);

    // Act
    List<Product> actualReadProductsByIdsResult =
        catalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(holder, productIds);

    // Assert
    verify(productDao).readProductsByIds(isA(List.class));
    assertTrue(actualReadProductsByIdsResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(ReindexStateHolder, List)"
  })
  public void testReadProductsByIds_whenArrayList_thenReturnNull() throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);

    // Act and Assert
    assertNull(
        catalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(holder, new ArrayList<>()));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder,
   * List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readProductsByIds(ReindexStateHolder, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readProductsByIds(ReindexStateHolder, List)"
  })
  public void testReadProductsByIds_whenNull_thenReturnNull() throws Exception {
    // Arrange, Act and Assert
    assertNull(
        new CatalogSolrIndexUpdateCommandHandlerImpl()
            .readProductsByIds(
                ReindexStateHolder.getInstance("Collection Name", true, true), null));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CatalogSolrIndexUpdateCommandHandlerImpl.getIndexFields()"})
  public void testGetIndexFields_thenReturnEmpty() {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<IndexField> actualIndexFields = catalogSolrIndexUpdateCommandHandlerImpl.getIndexFields();

    // Assert
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    assertTrue(actualIndexFields.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#getIndexFields()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CatalogSolrIndexUpdateCommandHandlerImpl.getIndexFields()"})
  public void testGetIndexFields_thenThrowIllegalStateException() {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> catalogSolrIndexUpdateCommandHandlerImpl.getIndexFields());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex() throws Exception {
    // Arrange
    when(localeService.findAllLocales()).thenThrow(new IllegalStateException());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
                productIds, products, holder, catalog, new SiteImpl()));
    verify(localeService).findAllLocales();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex2() throws Exception {
    // Arrange
    when(indexFieldDao.readFieldsByEntityType(Mockito.<FieldEntity>any()))
        .thenReturn(new ArrayList<>());
    when(localeService.findAllLocales()).thenReturn(new ArrayList<>());
    doThrow(new IllegalStateException()).when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
                productIds, products, holder, catalog, new SiteImpl()));
    verify(localeService).findAllLocales();
    verify(sandBoxHelper).ignoreCloneCache(true);
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex3() throws Exception {
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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doThrow(new IllegalStateException())
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
                productIds, products, holder, catalog, new SiteImpl()));
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
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex_givenOne_whenArrayListAddOne() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(1L);

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.incrementUnindexedItemCount(anyLong())).thenReturn(3L);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
        productIds, products, holder, catalog, new SiteImpl());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    verify(holder).incrementUnindexedItemCount(1L);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then calls {@link ReindexStateHolder#incrementUnindexedItemCount(long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex_givenThree_thenCallsIncrementUnindexedItemCount()
      throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.incrementUnindexedItemCount(anyLong())).thenReturn(3L);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
        productIds, products, holder, catalog, new SiteImpl());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    verify(holder).incrementUnindexedItemCount(1L);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link ArrayList#ArrayList()} add zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex_givenZero_whenArrayListAddZero() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());

    ArrayList<Long> productIds = new ArrayList<>();
    productIds.add(0L);
    productIds.add(1L);

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.incrementUnindexedItemCount(anyLong())).thenReturn(3L);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
        productIds, products, holder, catalog, new SiteImpl());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
    verify(holder).incrementUnindexedItemCount(1L);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <ul>
   *   <li>Then calls {@link CatalogDocumentBuilder#buildDocument(Indexable, List, List)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex_thenCallsBuildDocument() throws Exception {
    // Arrange
    when(catalogDocumentBuilder.buildDocument(
            Mockito.<Indexable>any(), Mockito.<List<IndexField>>any(), Mockito.<List<Locale>>any()))
        .thenReturn(null);

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
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());
    doNothing().when(sandBoxHelper).ignoreCloneCache(anyBoolean());
    doNothing()
        .when(solrIndexDao)
        .populateProductCatalogStructure(
            Mockito.<List<Long>>any(), Mockito.<CatalogStructure>any());
    ArrayList<Long> productIds = new ArrayList<>();

    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
        productIds, products, holder, catalog, new SiteImpl());

    // Assert
    verify(solrIndexServiceExtensionManager, atLeast(1)).getProxy();
    verify(localeService).findAllLocales();
    verify(localeService).findDefaultLocale();
    verify(sandBoxHelper, atLeast(1)).ignoreCloneCache(anyBoolean());
    verify(indexFieldDao).readFieldsByEntityType(isA(FieldEntity.class));
    verify(solrIndexDao).populateProductCatalogStructure(isA(List.class), isNull());
    verify(i18nSolrIndexServiceExtensionHandler).endBatchEvent(isA(List.class));
    verify(i18nSolrIndexServiceExtensionHandler).startBatchEvent(isA(List.class));
    verify(catalogDocumentBuilder)
        .buildDocument(isA(Indexable.class), isA(List.class), isA(List.class));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List,
   * ReindexStateHolder, Catalog, Site)}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#buildIncrementalIndex(List, List, ReindexStateHolder,
   * Catalog, Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(List, List, ReindexStateHolder, Catalog, Site)"
  })
  public void testBuildIncrementalIndex_thenDoesNotThrow() throws Exception {
    // Arrange
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();

    // Act and Assert
    catalogSolrIndexUpdateCommandHandlerImpl.buildIncrementalIndex(
        productIds, products, holder, catalog, new SiteImpl());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@link PlatformTransactionManager} {@link
   *       PlatformTransactionManager#commit(TransactionStatus)} does nothing.
   *   <li>Then calls {@link PlatformTransactionManager#commit(TransactionStatus)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(ReindexStateHolder, Long, int, Long)"
  })
  public void testReadIdBatch_givenPlatformTransactionManagerCommitDoesNothing_thenCallsCommit()
      throws Exception {
    // Arrange
    when(productDao.readAllActiveProductIds(Mockito.<Long>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    doNothing().when(platformTransactionManager).commit(Mockito.<TransactionStatus>any());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(new SimpleTransactionStatus());

    // Act
    List<Long> actualReadIdBatchResult =
        catalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(
            ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);

    // Assert
    verify(productDao).readAllActiveProductIds(1L, 3);
    verify(platformTransactionManager).commit(isA(TransactionStatus.class));
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    assertTrue(actualReadIdBatchResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int,
   * Long)}.
   *
   * <ul>
   *   <li>Given {@link PlatformTransactionManager} {@link
   *       PlatformTransactionManager#getTransaction(TransactionDefinition)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(ReindexStateHolder, Long, int, Long)"
  })
  public void testReadIdBatch_givenPlatformTransactionManagerGetTransactionReturnNull()
      throws Exception {
    // Arrange
    when(productDao.readAllActiveProductIds(Mockito.<Long>any(), anyInt()))
        .thenReturn(new ArrayList<>());
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(null);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    List<Long> actualReadIdBatchResult =
        catalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(
            ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);

    // Assert
    verify(productDao).readAllActiveProductIds(1L, 3);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isNull());
    assertTrue(actualReadIdBatchResult.isEmpty());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int,
   * Long)}.
   *
   * <ul>
   *   <li>Then calls {@link TransactionStatus#isRollbackOnly()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#readIdBatch(ReindexStateHolder, Long, int, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List CatalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(ReindexStateHolder, Long, int, Long)"
  })
  public void testReadIdBatch_thenCallsIsRollbackOnly() throws Exception {
    // Arrange
    when(productDao.readAllActiveProductIds(Mockito.<Long>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    TransactionStatus transactionStatus = mock(TransactionStatus.class);
    when(transactionStatus.isRollbackOnly()).thenReturn(true);
    when(platformTransactionManager.getTransaction(Mockito.<TransactionDefinition>any()))
        .thenReturn(transactionStatus);
    doNothing().when(platformTransactionManager).rollback(Mockito.<TransactionStatus>any());

    // Act
    List<Long> actualReadIdBatchResult =
        catalogSolrIndexUpdateCommandHandlerImpl.readIdBatch(
            ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);

    // Assert
    verify(productDao).readAllActiveProductIds(1L, 3);
    verify(platformTransactionManager).getTransaction(isA(TransactionDefinition.class));
    verify(platformTransactionManager).rollback(isA(TransactionStatus.class));
    verify(transactionStatus).isRollbackOnly();
    assertTrue(actualReadIdBatchResult.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterBackgroundThread(ReindexStateHolder,
   *       Catalog, Site, SandBox)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterProcess(ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadIdBatch(ReindexStateHolder,
   *       Long, int, Long)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#afterReadProducts(ReindexStateHolder,
   *       List)}
   *   <li>{@link
   *       CatalogSolrIndexUpdateCommandHandlerImpl#beforeBackgroundThread(ReindexStateHolder,
   *       Catalog, Site, SandBox)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforePage(List, List, List, List,
   *       ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeProcess(ReindexStateHolder)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadIdBatch(ReindexStateHolder,
   *       Long, int, Long)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#beforeReadProducts(ReindexStateHolder,
   *       List)}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getBackgroundOperationExecutor()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getIncrementalCommitInterval()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getSolrConfiguration()}
   *   <li>{@link CatalogSolrIndexUpdateCommandHandlerImpl#getThreadsForBackgroundExecution()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    "int CatalogSolrIndexUpdateCommandHandlerImpl.getThreadsForBackgroundExecution()"
  })
  public void testGettersAndSetters() throws IllegalStateException, ServiceException {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();
    ReindexStateHolder holder = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog = new CatalogImpl();
    SiteImpl site = new SiteImpl();

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.afterBackgroundThread(
        holder, catalog, site, new SandBoxImpl());
    catalogSolrIndexUpdateCommandHandlerImpl.afterProcess(
        ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl.afterReadIdBatch(
        ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder2 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.afterReadProducts(holder2, new ArrayList<>());
    ReindexStateHolder holder3 = ReindexStateHolder.getInstance("Collection Name", true, true);
    CatalogImpl catalog2 = new CatalogImpl();
    SiteImpl site2 = new SiteImpl();
    catalogSolrIndexUpdateCommandHandlerImpl.beforeBackgroundThread(
        holder3, catalog2, site2, new SandBoxImpl());
    ArrayList<Long> productIds = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Locale> locales = new ArrayList<>();
    catalogSolrIndexUpdateCommandHandlerImpl.beforePage(
        productIds,
        products,
        locales,
        new ArrayList<>(),
        ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl.beforeProcess(
        ReindexStateHolder.getInstance("Collection Name", true, true));
    catalogSolrIndexUpdateCommandHandlerImpl.beforeReadIdBatch(
        ReindexStateHolder.getInstance("Collection Name", true, true), 1L, 3, 1L);
    ReindexStateHolder holder4 = ReindexStateHolder.getInstance("Collection Name", true, true);
    catalogSolrIndexUpdateCommandHandlerImpl.beforeReadProducts(holder4, new ArrayList<>());
    ThreadPoolTaskExecutor actualBackgroundOperationExecutor =
        catalogSolrIndexUpdateCommandHandlerImpl.getBackgroundOperationExecutor();
    long actualIncrementalCommitInterval =
        catalogSolrIndexUpdateCommandHandlerImpl.getIncrementalCommitInterval();
    SolrConfiguration actualSolrConfiguration =
        catalogSolrIndexUpdateCommandHandlerImpl.getSolrConfiguration();

    // Assert
    assertEquals(
        "catalog-solr-reindex-worker-", actualBackgroundOperationExecutor.getThreadNamePrefix());
    assertNull(actualSolrConfiguration);
    ThreadPoolExecutor threadPoolExecutor =
        actualBackgroundOperationExecutor.getThreadPoolExecutor();
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
    assertEquals(10, catalogSolrIndexUpdateCommandHandlerImpl.getThreadsForBackgroundExecution());
    assertEquals(10, actualBackgroundOperationExecutor.getCorePoolSize());
    assertEquals(10, actualBackgroundOperationExecutor.getMaxPoolSize());
    assertEquals(30000L, actualIncrementalCommitInterval);
    assertEquals(5, actualBackgroundOperationExecutor.getThreadPriority());
    assertEquals(60, actualBackgroundOperationExecutor.getKeepAliveSeconds());
    assertFalse(actualBackgroundOperationExecutor.isDaemon());
    assertEquals(Integer.MAX_VALUE, actualBackgroundOperationExecutor.getQueueCapacity());
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog CatalogSolrIndexUpdateCommandHandlerImpl.findCatalog(Long)"})
  public void testFindCatalog_givenCatalogSolrIndexUpdateCommandHandlerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CatalogSolrIndexUpdateCommandHandlerImpl().findCatalog(null));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}.
   *
   * <ul>
   *   <li>Then return {@link CatalogImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#findCatalog(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Catalog CatalogSolrIndexUpdateCommandHandlerImpl.findCatalog(Long)"})
  public void testFindCatalog_thenReturnCatalogImpl() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalogImpl);

    // Act
    Catalog actualFindCatalogResult = catalogSolrIndexUpdateCommandHandlerImpl.findCatalog(1L);

    // Assert
    verify(siteService).findCatalogById(1L);
    assertSame(catalogImpl, actualFindCatalogResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}.
   *
   * <ul>
   *   <li>Given {@link CatalogSolrIndexUpdateCommandHandlerImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site CatalogSolrIndexUpdateCommandHandlerImpl.findSite(Long)"})
  public void testFindSite_givenCatalogSolrIndexUpdateCommandHandlerImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new CatalogSolrIndexUpdateCommandHandlerImpl().findSite(null));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}.
   *
   * <ul>
   *   <li>Then return {@link SiteImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CatalogSolrIndexUpdateCommandHandlerImpl#findSite(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site CatalogSolrIndexUpdateCommandHandlerImpl.findSite(Long)"})
  public void testFindSite_thenReturnSiteImpl() {
    // Arrange
    SiteImpl siteImpl = new SiteImpl();
    when(siteService.retrieveNonPersistentSiteById(Mockito.<Long>any())).thenReturn(siteImpl);

    // Act
    Site actualFindSiteResult = catalogSolrIndexUpdateCommandHandlerImpl.findSite(1L);

    // Assert
    verify(siteService).retrieveNonPersistentSiteById(1L);
    assertSame(siteImpl, actualFindSiteResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.incrementalCommit(ReindexStateHolder)"
  })
  public void testIncrementalCommit_givenFalse() throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.isIncrementalCommits()).thenReturn(false);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.incrementalCommit(holder);

    // Assert
    verify(holder).isIncrementalCommits();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}.
   *
   * <ul>
   *   <li>When {@link ReindexStateHolder} {@link ReindexStateHolder#getLastCommitted()} return
   *       {@link Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#incrementalCommit(ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CatalogSolrIndexUpdateCommandHandlerImpl.incrementalCommit(ReindexStateHolder)"
  })
  public void testIncrementalCommit_whenReindexStateHolderGetLastCommittedReturnMax_value()
      throws Exception {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.getLastCommitted()).thenReturn(Long.MAX_VALUE);
    when(holder.isIncrementalCommits()).thenReturn(true);

    // Act
    catalogSolrIndexUpdateCommandHandlerImpl.incrementalCommit(holder);

    // Assert
    verify(holder, atLeast(1)).getLastCommitted();
    verify(holder).isIncrementalCommits();
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}.
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CatalogSolrIndexUpdateCommandHandlerImpl.isReindexSuccessful(ReindexStateHolder)"
  })
  public void testIsReindexSuccessful() {
    // Arrange, Act and Assert
    assertFalse(
        new CatalogSolrIndexUpdateCommandHandlerImpl()
            .isReindexSuccessful(ReindexStateHolder.getInstance("Collection Name", true, true)));
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CatalogSolrIndexUpdateCommandHandlerImpl.isReindexSuccessful(ReindexStateHolder)"
  })
  public void testIsReindexSuccessful_givenOne_thenReturnTrue() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.isFailed()).thenReturn(false);
    when(holder.getIndexableCount()).thenReturn(1L);

    // Act
    boolean actualIsReindexSuccessfulResult =
        catalogSolrIndexUpdateCommandHandlerImpl.isReindexSuccessful(holder);

    // Assert
    verify(holder).getIndexableCount();
    verify(holder).isFailed();
    assertTrue(actualIsReindexSuccessfulResult);
  }

  /**
   * Test {@link CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * CatalogSolrIndexUpdateCommandHandlerImpl#isReindexSuccessful(ReindexStateHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CatalogSolrIndexUpdateCommandHandlerImpl.isReindexSuccessful(ReindexStateHolder)"
  })
  public void testIsReindexSuccessful_givenZero() {
    // Arrange
    CatalogSolrIndexUpdateCommandHandlerImpl catalogSolrIndexUpdateCommandHandlerImpl =
        new CatalogSolrIndexUpdateCommandHandlerImpl();

    ReindexStateHolder holder = mock(ReindexStateHolder.class);
    when(holder.isFailed()).thenReturn(false);
    when(holder.getIndexableCount()).thenReturn(0L);

    // Act
    boolean actualIsReindexSuccessfulResult =
        catalogSolrIndexUpdateCommandHandlerImpl.isReindexSuccessful(holder);

    // Assert
    verify(holder).getIndexableCount();
    verify(holder).isFailed();
    assertFalse(actualIsReindexSuccessfulResult);
  }
}
