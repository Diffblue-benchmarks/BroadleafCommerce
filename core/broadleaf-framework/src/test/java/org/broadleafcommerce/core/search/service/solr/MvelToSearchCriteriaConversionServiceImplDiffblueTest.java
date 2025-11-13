package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.IndexFieldType;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.solr.FieldType;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MvelToSearchCriteriaConversionServiceImplDiffblueTest {
  @Mock private IndexFieldDao indexFieldDao;

  @Mock private LocaleService localeService;

  @InjectMocks
  private MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;

  @Mock private SolrHelperService solrHelperService;

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert() {
    // Arrange
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            mvelToSearchCriteriaConversionServiceImpl.convert(
                "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0"));
    verify(solrHelperService).getExplicitCategoryFieldName();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert2() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert3() {
    // Arrange
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(new FieldImpl());

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenThrow(new UnsupportedOperationException());
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert4() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenReturn("Explicit Category Field Name");

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0||");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(444L);
    verify(solrHelperService).getExplicitCategoryFieldName();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("Explicit Category Field Name:(\"1,1,1\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenArrayListAddLocaleImpl() {
    // Arrange
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getTranslatable()).thenReturn(true);
    when(fieldImpl.getAbbreviation()).thenReturn("Abbreviation");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(new LocaleImpl());
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(fieldImpl).getAbbreviation();
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("(Abbreviation_b:\"\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getTranslatable()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenFieldImplGetTranslatableReturnNull() {
    // Arrange
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getTranslatable()).thenReturn(null);
    when(fieldImpl.getAbbreviation()).thenReturn("Abbreviation");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(fieldImpl).getAbbreviation();
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("(Abbreviation_b:\"\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Given {@link LocaleService} {@link LocaleService#findAllLocales()} throw {@link
   *       UnsupportedOperationException#UnsupportedOperationException()}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenLocaleServiceFindAllLocalesThrowUnsupportedOperationException() {
    // Arrange
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getTranslatable()).thenReturn(true);

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);
    when(localeService.findAllLocales()).thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl).getField();
    verify(indexFieldTypeImpl).getIndexField();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Given {@link MvelToSearchCriteriaConversionServiceImpl} (default constructor).
   *   <li>When {@code Mvel Rule}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenMvelToSearchCriteriaConversionServiceImpl_whenMvelRule() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> new MvelToSearchCriteriaConversionServiceImpl().convert("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Then return FilterQueries first is {@code (en_Abbreviation_b:"")}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_thenReturnFilterQueriesFirstIsEnAbbreviationB() {
    // Arrange
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getTranslatable()).thenReturn(true);
    when(fieldImpl.getAbbreviation()).thenReturn("Abbreviation");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(fieldImpl).getAbbreviation();
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("(en_Abbreviation_b:\"\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Then return FilterQueries first is {@code Explicit Category Field Name:("1,1,1")}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_thenReturnFilterQueriesFirstIsExplicitCategoryFieldName111() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenReturn("Explicit Category Field Name");

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(444L);
    verify(solrHelperService).getExplicitCategoryFieldName();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("Explicit Category Field Name:(\"1,1,1\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>Then return FilterQueries first is {@code (null_b:"")}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_thenReturnFilterQueriesFirstIsNullB() {
    // Arrange
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(new FieldImpl());

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals("(null_b:\"\")", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>When a string.
   *   <li>Then return FilterQueries first is {@code (en_Abbreviation_b:("444,"444","444""))}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_whenAString_thenReturnFilterQueriesFirstIsEnAbbreviationB444444444() {
    // Arrange
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getTranslatable()).thenReturn(true);
    when(fieldImpl.getAbbreviation()).thenReturn("Abbreviation");

    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(fieldImpl);

    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenReturn(FieldType.BOOLEAN);
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    Locale locale = mock(Locale.class);
    when(locale.getLocaleCode()).thenReturn("en");

    ArrayList<Locale> localeList = new ArrayList<>();
    localeList.add(locale);
    when(localeService.findAllLocales()).thenReturn(localeList);

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0CollectionUtils"
                + ".intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0");

    // Assert
    verify(locale, atLeast(1)).getLocaleCode();
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("allParentCategoryIds");
    verify(fieldImpl).getAbbreviation();
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertEquals(1, filterQueries.size());
    assertTrue(filterQueries instanceof List);
    assertEquals(
        "(en_Abbreviation_b:(\"444,\"444\",\"444\"\"))", ((List<String>) filterQueries).get(0));
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   *
   * <ul>
   *   <li>When {@code product.}.
   *   <li>Then return FilterQueries Empty.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_whenProduct_thenReturnFilterQueriesEmpty() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SearchCriteria actualConvertResult =
        mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    Collection<String> filterQueries = actualConvertResult.getFilterQueries();
    assertTrue(filterQueries instanceof List);
    assertNull(actualConvertResult.getStartIndex());
    assertNull(actualConvertResult.getQuery());
    assertNull(actualConvertResult.getRequestHandler());
    assertNull(actualConvertResult.getSortQuery());
    assertNull(actualConvertResult.getCategory());
    assertEquals(1, actualConvertResult.getPage().intValue());
    assertFalse(actualConvertResult.getSearchExplicitCategory());
    assertTrue(filterQueries.isEmpty());
    assertTrue(actualConvertResult.getFilterCriteria().isEmpty());
    assertEquals(Integer.MAX_VALUE, actualConvertResult.getPageSize().intValue());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   *
   * <ul>
   *   <li>When {@code product.}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isProductRule(String)"})
  public void testIsProductRule_whenProduct_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MvelToSearchCriteriaConversionServiceImpl().isProductRule("product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   *
   * <ul>
   *   <li>When {@code Rule}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isProductRule(String)"})
  public void testIsProductRule_whenRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MvelToSearchCriteriaConversionServiceImpl().isProductRule("Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"
  })
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl_thenReturnTrue() {
    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl =
        new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   *
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"
  })
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl_thenReturnTrue2() {
    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl =
        new MvelToSearchCriteriaConversionServiceImpl();

    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"
  })
  public void testIsCustomFieldIndexed_whenArrayList_thenReturnFalse() {
    // Arrange
    MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl =
        new MvelToSearchCriteriaConversionServiceImpl();

    // Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(new ArrayList<>()));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"
  })
  public void testIsCustomFieldIndexed_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MvelToSearchCriteriaConversionServiceImpl().isCustomFieldIndexed(null));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule(String)"
  })
  public void testIsCategoryTargetingRule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        new MvelToSearchCriteriaConversionServiceImpl()
            .isCategoryTargetingRule(
                "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean MvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule(String)"
  })
  public void testIsCategoryTargetingRule_whenMvelRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        new MvelToSearchCriteriaConversionServiceImpl().isCategoryTargetingRule("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}.
   *
   * <ul>
   *   <li>Then return array of {@link Long} with two.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long[] MvelToSearchCriteriaConversionServiceImpl.getCategoryIds(String)"})
  public void testGetCategoryIds_thenReturnArrayOfLongWithTwo() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new Long[] {2L}, new MvelToSearchCriteriaConversionServiceImpl().getCategoryIds("42\"]"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("Match Rule"));
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("Match Rule");
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters2() {
    // Arrange
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
                "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0"));
    verify(solrHelperService).getExplicitCategoryFieldName();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters3() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenReturn("Explicit Category Field Name");

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0||");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(444L);
    verify(solrHelperService).getExplicitCategoryFieldName();
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals(
        "Explicit Category Field Name:(\"1,1,1\")",
        ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>Then return first is empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_thenReturnFirstIsEmptyString() {
    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult =
        new MvelToSearchCriteriaConversionServiceImpl().convertRuleToFilters("||");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>Then return first is {@code Explicit Category Field Name:("1,1,1")}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_thenReturnFirstIsExplicitCategoryFieldName111() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName())
        .thenReturn("Explicit Category Field Name");

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(444L);
    verify(solrHelperService).getExplicitCategoryFieldName();
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals(
        "Explicit Category Field Name:(\"1,1,1\")",
        ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When a string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenAString() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0CollectionUtils"
                + ".intersection(product.?allParentCategoryIds,[\"444,\"444\",\"444\"\"]).size()>0");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("allParentCategoryIds");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code &&}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenAmpersandAmpersand() {
    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult =
        new MvelToSearchCriteriaConversionServiceImpl().convertRuleToFilters("&&");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@link MvelToSearchCriteriaConversionServiceImpl#CATEGORY_FORMAT_REGEX}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenCategory_format_regex() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
            MvelToSearchCriteriaConversionServiceImpl.CATEGORY_FORMAT_REGEX);

    // Assert
    verify(indexFieldDao)
        .getIndexFieldTypesByAbbreviationOrPropertyName("product\\.\\allParentCategoryIds");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code :("}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenColonLeftParenthesisQuotationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(":(\"");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(":(\"");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenEmptyString() {
    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult =
        new MvelToSearchCriteriaConversionServiceImpl().convertRuleToFilters("");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenExclamationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("!");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("!");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenExclamationMarkEqualsSign() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("!=");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("!");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code !="}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenExclamationMarkEqualsSignQuotationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("!=\"");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("!");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code Match Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenMatchRule() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("Match Rule");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("Match Rule");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"
  })
  public void testConvertRuleToFilters_whenQuestionMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult =
        mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters("?");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName("");
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName() {
    // Arrange, Act and Assert
    assertEquals("\"))", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\"))", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName3() {
    // Arrange, Act and Assert
    assertEquals("\"))", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\"))?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName4() {
    // Arrange, Act and Assert
    assertEquals(
        "\"))\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\"))\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code *\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnAsteriskBackslash() {
    // Arrange, Act and Assert
    assertEquals("*\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("*\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \*}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\*", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \:("}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashColonLeftParenthesisQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\\:(\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \=}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("\\=", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\!", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!=}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("\\!=", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \!="}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\\!=\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \"}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \","}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMarkCommaQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\",\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code \")}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(
        "\\\")", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code :("}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnColonLeftParenthesisQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(":(\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code !\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkBackslash() {
    // Arrange, Act and Assert
    assertEquals("!\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code !=\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignBackslash() {
    // Arrange, Act and Assert
    assertEquals("!=\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!=\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code !="\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignQuotationMarkBackslash() {
    // Arrange, Act and Assert
    assertEquals(
        "!=\"\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!=\"\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code ()\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnLeftParenthesisRightParenthesisBackslash() {
    // Arrange, Act and Assert
    assertEquals("()\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("()\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code "\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkBackslash() {
    // Arrange, Act and Assert
    assertEquals("\"\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\"\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code ","\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkCommaQuotationMarkBackslash() {
    // Arrange, Act and Assert
    assertEquals(
        "\",\"\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\",\"\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code ")\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkRightParenthesisBackslash() {
    // Arrange, Act and Assert
    assertEquals(
        "\")\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\")\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?42}.
   *   <li>Then return {@code \42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("\\42", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code 42?}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("42?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code 42\?}.
   *   <li>Then return {@code 42\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("42\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code *?}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenAsteriskQuestionMark_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals("*", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("*?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMarkLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \??}.
   *   <li>Then return {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMarkQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\??"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?}.
   *   <li>Then return {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?.contains}.
   *   <li>Then return {@code .contains}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains() {
    // Arrange, Act and Assert
    assertEquals(
        ".contains",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?.contains"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?.contains}.
   *   <li>Then return {@code \.contains}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\.contains",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?.contains"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code .contains?}.
   *   <li>Then return {@code .contains}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains3() {
    // Arrange, Act and Assert
    assertEquals(
        ".contains",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName(".contains?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code .contains\?}.
   *   <li>Then return {@code .contains\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains4() {
    // Arrange, Act and Assert
    assertEquals(
        ".contains\\",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName(".contains\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?.endsWith}.
   *   <li>Then return {@code .endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith() {
    // Arrange, Act and Assert
    assertEquals(
        ".endsWith",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?.endsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?.endsWith}.
   *   <li>Then return {@code \.endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\.endsWith",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?.endsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code .endsWith?}.
   *   <li>Then return {@code .endsWith}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith3() {
    // Arrange, Act and Assert
    assertEquals(
        ".endsWith",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName(".endsWith?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code .endsWith\?}.
   *   <li>Then return {@code .endsWith\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith4() {
    // Arrange, Act and Assert
    assertEquals(
        ".endsWith\\",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName(".endsWith\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code !=?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenExclamationMarkEqualsSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("!=", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!=?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code !="?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenExclamationMarkEqualsSignQuotationMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("!=\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!=\"?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code !?}.
   *   <li>Then return {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenExclamationMarkQuestionMark_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("!?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "Field Name",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?Field Name}.
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName2() {
    // Arrange, Act and Assert
    assertEquals(
        "Field Name",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?Field Name}.
   *   <li>Then return {@code \Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName3() {
    // Arrange, Act and Assert
    assertEquals(
        "\\Field Name",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name?}.
   *   <li>Then return {@code Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName4() {
    // Arrange, Act and Assert
    assertEquals(
        "Field Name",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("Field Name?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name\?}.
   *   <li>Then return {@code Field Name\}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName5() {
    // Arrange, Act and Assert
    assertEquals(
        "Field Name\\",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("Field Name\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code product.\?}.
   *   <li>Then return {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals(
        "\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("product.\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code product.}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?product.}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code product.?}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString3() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("product.?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?product.}.
   *   <li>Then return {@code \product.}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnProduct() {
    // Arrange, Act and Assert
    assertEquals(
        "\\product.",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?*}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkAsterisk_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals("*", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?\?}.
   *   <li>Then return {@code \}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkBackslashQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?=}.
   *   <li>Then return {@code =}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkEqualsSign_thenReturnEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?!=}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkExclamationMarkEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("!=", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?!="}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("!=\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?!}.
   *   <li>Then return {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkExclamationMark_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ??}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuestionMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("??"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?","}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuotationMarkCommaQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\",\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?")}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\")", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?"}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ","?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuotationMarkCommaQuotationMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\",\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\",\"?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code "?}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuotationMarkQuestionMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\"?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ")?}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuotationMarkRightParenthesisQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("\")", new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\")?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code ?.startsWith}.
   *   <li>Then return {@code .startsWith}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenStartsWith_thenReturnStartsWith() {
    // Arrange, Act and Assert
    assertEquals(
        ".startsWith",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("?.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code \?.startsWith}.
   *   <li>Then return {@code \.startsWith}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenStartsWith_thenReturnStartsWith2() {
    // Arrange, Act and Assert
    assertEquals(
        "\\.startsWith",
        new MvelToSearchCriteriaConversionServiceImpl().convertFieldName("\\?.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code Field Name}.
   *   <li>Then return {@code field Na}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenFieldName_thenReturnFieldNa() {
    // Arrange, Act and Assert
    assertEquals(
        "field Na", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code getField Name}.
   *   <li>Then return {@code field Na}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetFieldName_thenReturnFieldNa() {
    // Arrange, Act and Assert
    assertEquals(
        "field Na", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("getField Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code get(^get)}.
   *   <li>Then return {@code (^ge}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetGet_thenReturnGe() {
    // Arrange, Act and Assert
    assertEquals("(^ge", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("get(^get)"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code get!="}.
   *   <li>Then return {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("get!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code get"))}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("get\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code get","}.
   *   <li>Then return {@code "}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnQuotationMark2() {
    // Arrange, Act and Assert
    assertEquals("\"", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("get\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   *
   * <ul>
   *   <li>When {@code getget}.
   *   <li>Then return {@code g}.
   * </ul>
   *
   * <p>Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetget_thenReturnG() {
    // Arrange, Act and Assert
    assertEquals("g", new MvelToSearchCriteriaConversionServiceImpl().parseMethod("getget"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new MvelToSearchCriteriaConversionServiceImpl().isWildCardSearch("42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   *
   * <ul>
   *   <li>When {@code 42*}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MvelToSearchCriteriaConversionServiceImpl().isWildCardSearch("42*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   *
   * <ul>
   *   <li>When {@code *}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_whenAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new MvelToSearchCriteriaConversionServiceImpl().isWildCardSearch("*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName() {
    // Arrange, Act and Assert
    assertEquals(
        "org.apache.commons.lang3.StringUtils.contains",
        new MvelToSearchCriteriaConversionServiceImpl()
            .getCustomFieldPropertyName("org.apache.commons.lang3.StringUtils.contains,"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>Then return {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "!", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(
        "()", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code CollectionUtils,}.
   *   <li>Then return {@code CollectionUtils}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenCollectionUtils_thenReturnCollectionUtils() {
    // Arrange, Act and Assert
    assertEquals(
        "CollectionUtils",
        new MvelToSearchCriteriaConversionServiceImpl()
            .getCustomFieldPropertyName("CollectionUtils,"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code ,.endsWith}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenEndsWith_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName(",.endsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code (}.
   *   <li>Then return {@code (}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenLeftParenthesis_thenReturnLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals(
        "(", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("("));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule}.
   *   <li>Then return {@code Mvel Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenMvelRule_thenReturnMvelRule() {
    // Arrange, Act and Assert
    assertEquals(
        "Mvel Rule",
        new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule!}.
   *   <li>Then return {@code Mvel Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenMvelRule_thenReturnMvelRule2() {
    // Arrange, Act and Assert
    assertEquals(
        "Mvel Rule",
        new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("Mvel Rule!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code ,.startsWith}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenStartsWith_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName(",.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   *
   * <ul>
   *   <li>When {@code (UUU)}.
   *   <li>Then return {@code UUU}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"
  })
  public void testGetCustomFieldPropertyName_whenUuu_thenReturnUuu() {
    // Arrange, Act and Assert
    assertEquals(
        "UUU", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldPropertyName("(UUU)"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>Then return {@code !}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "!", new MvelToSearchCriteriaConversionServiceImpl().getRuleOrPropertyFromFunction("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>Then return {@code ()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(
        "()", new MvelToSearchCriteriaConversionServiceImpl().getRuleOrPropertyFromFunction("()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>Then return {@code ""}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_thenReturnQuotationMarkQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(
        "\"\"",
        new MvelToSearchCriteriaConversionServiceImpl().getRuleOrPropertyFromFunction(":(\"\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>Then return {@code ")}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_thenReturnQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(
        "\")",
        new MvelToSearchCriteriaConversionServiceImpl().getRuleOrPropertyFromFunction("\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule}.
   *   <li>Then return {@code Mvel Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_whenMvelRule_thenReturnMvelRule() {
    // Arrange, Act and Assert
    assertEquals(
        "Mvel Rule",
        new MvelToSearchCriteriaConversionServiceImpl().getRuleOrPropertyFromFunction("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule!}.
   *   <li>Then return {@code Mvel Rule}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"
  })
  public void testGetRuleOrPropertyFromFunction_whenMvelRule_thenReturnMvelRule2() {
    // Arrange, Act and Assert
    assertEquals(
        "Mvel Rule",
        new MvelToSearchCriteriaConversionServiceImpl()
            .getRuleOrPropertyFromFunction("Mvel Rule!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code ==}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_thenReturnEqualsSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals(
        "==", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("==\"==\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>Then return {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_thenReturnLeftSquareBracket() {
    // Arrange, Act and Assert
    assertEquals("[", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("!=["));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code .contains"))}.
   *   <li>Then return {@code contains}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenContains_thenReturnContains() {
    // Arrange, Act and Assert
    assertEquals(
        "contains",
        new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue(".contains\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code ==}.
   *   <li>Then return {@code =}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenEqualsSignEqualsSign_thenReturnEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("=="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code !="}.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code !=}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSign_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenMvelRule_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals(
        "", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   *
   * <ul>
   *   <li>When {@code Mvel Rule==}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"
  })
  public void testGetCustomFieldValue_whenMvelRule_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals(
        "", new MvelToSearchCriteriaConversionServiceImpl().getCustomFieldValue("Mvel Rule=="));
  }
}
