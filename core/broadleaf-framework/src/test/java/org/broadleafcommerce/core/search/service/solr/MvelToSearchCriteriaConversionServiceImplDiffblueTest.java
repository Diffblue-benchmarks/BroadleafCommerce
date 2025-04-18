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
package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.core.catalog.service.CatalogService;
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
  @Mock
  private CatalogService catalogService;

  @Mock
  private IndexFieldDao indexFieldDao;

  @Mock
  private LocaleService localeService;

  @InjectMocks
  private MvelToSearchCriteriaConversionServiceImpl mvelToSearchCriteriaConversionServiceImpl;

  @Mock
  private SolrHelperService solrHelperService;

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert2() {
    // Arrange
    IndexFieldImpl indexFieldImpl = mock(IndexFieldImpl.class);
    when(indexFieldImpl.getField()).thenReturn(new FieldImpl());
    IndexFieldTypeImpl indexFieldTypeImpl = mock(IndexFieldTypeImpl.class);
    when(indexFieldTypeImpl.getFieldType()).thenThrow(new UnsupportedOperationException(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));
    when(indexFieldTypeImpl.getIndexField()).thenReturn(indexFieldImpl);

    ArrayList<IndexFieldType> indexFieldTypeList = new ArrayList<>();
    indexFieldTypeList.add(indexFieldTypeImpl);
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(indexFieldTypeList);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
    verify(indexFieldImpl, atLeast(1)).getField();
    verify(indexFieldTypeImpl).getFieldType();
    verify(indexFieldTypeImpl, atLeast(1)).getIndexField();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert3() {
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
    when(localeService.findAllLocales()).thenThrow(new UnsupportedOperationException(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("product."));
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
    verify(fieldImpl).getTranslatable();
    verify(indexFieldImpl).getField();
    verify(indexFieldTypeImpl).getIndexField();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link LocaleImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(localeService).findAllLocales();
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
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
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getTranslatable()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
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
   * <ul>
   *   <li>Given {@link IndexFieldDao}.</li>
   *   <li>When {@code Mvel Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenIndexFieldDao_whenMvelRule() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convert("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <ul>
   *   <li>Given {@link SolrHelperService}.</li>
   *   <li>When a string.</li>
   *   <li>Then return FilterQueries Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenSolrHelperService_whenAString_thenReturnFilterQueriesEmpty() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl.convert(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0CollectionUtils"
            + ".intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("allParentCategoryIds"));
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
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <ul>
   *   <li>Given {@link SolrHelperService}.</li>
   *   <li>When {@code product.}.</li>
   *   <li>Then return FilterQueries Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_givenSolrHelperService_whenProduct_thenReturnFilterQueriesEmpty() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
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
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}.
   * <ul>
   *   <li>Then return FilterQueries first is {@code Explicit Category Field Name:("1,1,1")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"SearchCriteria MvelToSearchCriteriaConversionServiceImpl.convert(String)"})
  public void testConvert_thenReturnFilterQueriesFirstIsExplicitCategoryFieldName111() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName()).thenReturn("Explicit Category Field Name");

    // Act
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl
        .convert("CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(eq(9L));
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
   * <ul>
   *   <li>Then return FilterQueries first is {@code (null_b:"")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convert(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
    SearchCriteria actualConvertResult = mvelToSearchCriteriaConversionServiceImpl.convert("product.");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(""));
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
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   * <ul>
   *   <li>When {@code product.}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isProductRule(String)"})
  public void testIsProductRule_whenProduct_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isProductRule("product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}.
   * <ul>
   *   <li>When {@code Rule}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isProductRule(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isProductRule(String)"})
  public void testIsProductRule_whenRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isProductRule("Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"})
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl_thenReturnTrue() {
    // Arrange
    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>Given {@link IndexFieldTypeImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"})
  public void testIsCustomFieldIndexed_givenIndexFieldTypeImpl_thenReturnTrue2() {
    // Arrange
    ArrayList<IndexFieldType> indexFieldTypes = new ArrayList<>();
    indexFieldTypes.add(new IndexFieldTypeImpl());
    indexFieldTypes.add(new IndexFieldTypeImpl());

    // Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(indexFieldTypes));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"})
  public void testIsCustomFieldIndexed_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(new ArrayList<>()));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCustomFieldIndexed(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(List)"})
  public void testIsCustomFieldIndexed_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCustomFieldIndexed(null));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule(String)"})
  public void testIsCategoryTargetingRule_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isCategoryTargetingRule(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule(String)"})
  public void testIsCategoryTargetingRule_whenMvelRule_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isCategoryTargetingRule("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}.
   * <ul>
   *   <li>When {@code 42"]}.</li>
   *   <li>Then return array of {@link Long} with two.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCategoryIds(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long[] MvelToSearchCriteriaConversionServiceImpl.getCategoryIds(String)"})
  public void testGetCategoryIds_when42_thenReturnArrayOfLongWithTwo() {
    // Arrange, Act and Assert
    assertArrayEquals(new Long[]{2L}, mvelToSearchCriteriaConversionServiceImpl.getCategoryIds("42\"]"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName()).thenReturn("Explicit Category Field Name");

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0||");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(eq(9L));
    verify(solrHelperService).getExplicitCategoryFieldName();
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("Explicit Category Field Name:(\"1,1,1\")", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>Given {@link IndexFieldDao}.</li>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_givenIndexFieldDao_whenEmptyString_thenReturnEmpty() {
    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>Then return first is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_thenReturnFirstIsEmptyString() {
    // Arrange and Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("||");

    // Assert
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>Then return first is {@code Explicit Category Field Name:("1,1,1")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_thenReturnFirstIsExplicitCategoryFieldName111() {
    // Arrange
    when(solrHelperService.getCategoryId(Mockito.<Long>any())).thenReturn(1L);
    when(solrHelperService.getExplicitCategoryFieldName()).thenReturn("Explicit Category Field Name");

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0");

    // Assert
    verify(solrHelperService, atLeast(1)).getCategoryId(eq(9L));
    verify(solrHelperService).getExplicitCategoryFieldName();
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertEquals(1, actualConvertRuleToFiltersResult.size());
    assertEquals("Explicit Category Field Name:(\"1,1,1\")", ((List<String>) actualConvertRuleToFiltersResult).get(0));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_thenThrowUnsupportedOperationException() {
    // Arrange
    when(solrHelperService.getExplicitCategoryFieldName()).thenThrow(new UnsupportedOperationException(
        "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> mvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0"));
    verify(solrHelperService).getExplicitCategoryFieldName();
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When a string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenAString() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters(
            "CollectionUtils.intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0CollectionUtils"
                + ".intersection(product.?allParentCategoryIds,[\"9,\"9\",\"9\"\"]).size()>0");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("allParentCategoryIds"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@link MvelToSearchCriteriaConversionServiceImpl#CATEGORY_FORMAT_REGEX}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenCategory_format_regex() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters(MvelToSearchCriteriaConversionServiceImpl.CATEGORY_FORMAT_REGEX);

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("product\\.\\allParentCategoryIds"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code :("}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenColonLeftParenthesisQuotationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters(":(\"");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq(":(\""));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenExclamationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("!");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("!"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenExclamationMarkEqualsSign() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("!=");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("!"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code !="}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenExclamationMarkEqualsSignQuotationMark() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("!=\"");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("!"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}.
   * <ul>
   *   <li>When {@code Match Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertRuleToFilters(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Collection MvelToSearchCriteriaConversionServiceImpl.convertRuleToFilters(String)"})
  public void testConvertRuleToFilters_whenMatchRule() {
    // Arrange
    when(indexFieldDao.getIndexFieldTypesByAbbreviationOrPropertyName(Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    Collection<String> actualConvertRuleToFiltersResult = mvelToSearchCriteriaConversionServiceImpl
        .convertRuleToFilters("Match Rule");

    // Assert
    verify(indexFieldDao).getIndexFieldTypesByAbbreviationOrPropertyName(eq("Match Rule"));
    assertTrue(actualConvertRuleToFiltersResult instanceof List);
    assertTrue(actualConvertRuleToFiltersResult.isEmpty());
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName() {
    // Arrange, Act and Assert
    assertEquals("\\\"))", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \*}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashAsterisk() {
    // Arrange, Act and Assert
    assertEquals("\\*", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \:("}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashColonLeftParenthesisQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\:(\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("\\=", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("\\!", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("\\!=", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \!="}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\!=\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \","}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMarkCommaQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\\\",\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code \")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnBackslashQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\\")", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code :("}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnColonLeftParenthesisQuotationMark() {
    // Arrange, Act and Assert
    assertEquals(":(\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkBackslash() {
    // Arrange, Act and Assert
    assertEquals("!\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("!\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !=\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignBackslash() {
    // Arrange, Act and Assert
    assertEquals("!=\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("!=\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code !="}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("!=\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ()\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnLeftParenthesisRightParenthesisBackslash() {
    // Arrange, Act and Assert
    assertEquals("()\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("()\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ","}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkCommaQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\",\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code ")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\")", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>Then return {@code "))}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_thenReturnQuotationMarkRightParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\"))", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?42}.</li>
   *   <li>Then return {@code \42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("\\42", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code 42?}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("42", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("42?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code 42\?}.</li>
   *   <li>Then return {@code 42\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_when42_thenReturn424() {
    // Arrange, Act and Assert
    assertEquals("42\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("42\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMarkLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \??}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMarkQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\??"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenBackslashQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.contains}.</li>
   *   <li>Then return {@code .contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains() {
    // Arrange, Act and Assert
    assertEquals(".contains", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?.contains"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?.contains}.</li>
   *   <li>Then return {@code \.contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenContains_thenReturnContains2() {
    // Arrange, Act and Assert
    assertEquals("\\.contains", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?.contains"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.endsWith}.</li>
   *   <li>Then return {@code .endsWith}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith() {
    // Arrange, Act and Assert
    assertEquals(".endsWith", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?.endsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?.endsWith}.</li>
   *   <li>Then return {@code \.endsWith}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenEndsWith_thenReturnEndsWith2() {
    // Arrange, Act and Assert
    assertEquals("\\.endsWith", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?.endsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code !=?}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenExclamationMarkEqualsSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("!=", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("!=?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code !?}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenExclamationMarkQuestionMark_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("!?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName() {
    // Arrange, Act and Assert
    assertEquals("Field Name", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?Field Name}.</li>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName2() {
    // Arrange, Act and Assert
    assertEquals("Field Name", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?Field Name}.</li>
   *   <li>Then return {@code \Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName3() {
    // Arrange, Act and Assert
    assertEquals("\\Field Name", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code Field Name?}.</li>
   *   <li>Then return {@code Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName4() {
    // Arrange, Act and Assert
    assertEquals("Field Name", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("Field Name?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code Field Name\?}.</li>
   *   <li>Then return {@code Field Name\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenFieldName_thenReturnFieldName5() {
    // Arrange, Act and Assert
    assertEquals("Field Name\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("Field Name\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code product.\?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("product.\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code product.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?product.}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString2() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code product.?}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnEmptyString3() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("product.?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?product.}.</li>
   *   <li>Then return {@code \product.}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenProduct_thenReturnProduct() {
    // Arrange, Act and Assert
    assertEquals("\\product.", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?product."));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?*}.</li>
   *   <li>Then return {@code *}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkAsterisk_thenReturnAsterisk() {
    // Arrange, Act and Assert
    assertEquals("*", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?\?}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkBackslashQuestionMark_thenReturnBackslash() {
    // Arrange, Act and Assert
    assertEquals("\\", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?\\?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?=}.</li>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkEqualsSign_thenReturnEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?!=}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkExclamationMarkEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("!=", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?!}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkExclamationMark_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ??}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuestionMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("??"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?"}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMarkQuotationMark_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenQuestionMark_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code ?.startsWith}.</li>
   *   <li>Then return {@code .startsWith}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenStartsWith_thenReturnStartsWith() {
    // Arrange, Act and Assert
    assertEquals(".startsWith", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("?.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}.
   * <ul>
   *   <li>When {@code \?.startsWith}.</li>
   *   <li>Then return {@code \.startsWith}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#convertFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.convertFieldName(String)"})
  public void testConvertFieldName_whenStartsWith_thenReturnStartsWith2() {
    // Arrange, Act and Assert
    assertEquals("\\.startsWith", mvelToSearchCriteriaConversionServiceImpl.convertFieldName("\\?.startsWith"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code Field Name}.</li>
   *   <li>Then return {@code field Na}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenFieldName_thenReturnFieldNa() {
    // Arrange, Act and Assert
    assertEquals("field Na", mvelToSearchCriteriaConversionServiceImpl.parseMethod("Field Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code getField Name}.</li>
   *   <li>Then return {@code field Na}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetFieldName_thenReturnFieldNa() {
    // Arrange, Act and Assert
    assertEquals("field Na", mvelToSearchCriteriaConversionServiceImpl.parseMethod("getField Name"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get(^get)}.</li>
   *   <li>Then return {@code (^ge}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetGet_thenReturnGe() {
    // Arrange, Act and Assert
    assertEquals("(^ge", mvelToSearchCriteriaConversionServiceImpl.parseMethod("get(^get)"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get:("}.</li>
   *   <li>Then return {@code :}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnColon() {
    // Arrange, Act and Assert
    assertEquals(":", mvelToSearchCriteriaConversionServiceImpl.parseMethod("get:(\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get!="}.</li>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", mvelToSearchCriteriaConversionServiceImpl.parseMethod("get!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get"))}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", mvelToSearchCriteriaConversionServiceImpl.parseMethod("get\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code get","}.</li>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGet_thenReturnQuotationMark2() {
    // Arrange, Act and Assert
    assertEquals("\"", mvelToSearchCriteriaConversionServiceImpl.parseMethod("get\",\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}.
   * <ul>
   *   <li>When {@code getget}.</li>
   *   <li>Then return {@code g}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#parseMethod(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.parseMethod(String)"})
  public void testParseMethod_whenGetget_thenReturnG() {
    // Arrange, Act and Assert
    assertEquals("g", mvelToSearchCriteriaConversionServiceImpl.parseMethod("getget"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(mvelToSearchCriteriaConversionServiceImpl.isWildCardSearch("42"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code 42*}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_when42_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isWildCardSearch("42*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}.
   * <ul>
   *   <li>When {@code *}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#isWildCardSearch(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MvelToSearchCriteriaConversionServiceImpl.isWildCardSearch(String)"})
  public void testIsWildCardSearch_whenAsterisk_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(mvelToSearchCriteriaConversionServiceImpl.isWildCardSearch("*"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code ()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("()", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code ["}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_thenReturnLeftSquareBracketQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("[\"", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("[\"!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>Then return {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_thenReturnQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("\"", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("(\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code CollectionUtils,}.</li>
   *   <li>Then return {@code CollectionUtils}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_whenCollectionUtils_thenReturnCollectionUtils() {
    // Arrange, Act and Assert
    assertEquals("CollectionUtils",
        mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("CollectionUtils,"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code (}.</li>
   *   <li>Then return {@code (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_whenLeftParenthesis_thenReturnLeftParenthesis() {
    // Arrange, Act and Assert
    assertEquals("(", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("("));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code Mvel Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldPropertyName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName(String)"})
  public void testGetCustomFieldPropertyName_whenMvelRule_thenReturnMvelRule() {
    // Arrange, Act and Assert
    assertEquals("Mvel Rule", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldPropertyName("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"})
  public void testGetRuleOrPropertyFromFunction_thenReturnEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", mvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction("=!"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code !}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"})
  public void testGetRuleOrPropertyFromFunction_thenReturnExclamationMark() {
    // Arrange, Act and Assert
    assertEquals("!", mvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code ()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"})
  public void testGetRuleOrPropertyFromFunction_thenReturnLeftParenthesisRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("()", mvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction("()"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>Then return {@code ")}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"})
  public void testGetRuleOrPropertyFromFunction_thenReturnQuotationMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("\")", mvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction("\")"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return {@code Mvel Rule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getRuleOrPropertyFromFunction(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction(String)"})
  public void testGetRuleOrPropertyFromFunction_whenMvelRule_thenReturnMvelRule() {
    // Arrange, Act and Assert
    assertEquals("Mvel Rule", mvelToSearchCriteriaConversionServiceImpl.getRuleOrPropertyFromFunction("Mvel Rule"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code .contains"))}.</li>
   *   <li>Then return {@code contains}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"})
  public void testGetCustomFieldValue_whenContains_thenReturnContains() {
    // Arrange, Act and Assert
    assertEquals("contains", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(".contains\"))"));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code ==}.</li>
   *   <li>Then return {@code =}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"})
  public void testGetCustomFieldValue_whenEqualsSignEqualsSign_thenReturnEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue("=="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code !="}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"})
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSignQuotationMark() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue("!=\""));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code !=}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"})
  public void testGetCustomFieldValue_whenExclamationMarkEqualsSign_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue("!="));
  }

  /**
   * Test {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}.
   * <ul>
   *   <li>When {@code Mvel Rule}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link MvelToSearchCriteriaConversionServiceImpl#getCustomFieldValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String MvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue(String)"})
  public void testGetCustomFieldValue_whenMvelRule_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", mvelToSearchCriteriaConversionServiceImpl.getCustomFieldValue("Mvel Rule"));
  }
}
