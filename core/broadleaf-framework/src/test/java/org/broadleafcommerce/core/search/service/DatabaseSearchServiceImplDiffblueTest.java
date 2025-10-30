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
package org.broadleafcommerce.core.search.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.cache.Cache;
import javax.cache.CacheManager;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.service.CatalogService;
import org.broadleafcommerce.core.search.dao.FieldDao;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class DatabaseSearchServiceImplDiffblueTest {
  @InjectMocks
  private DatabaseSearchServiceImpl databaseSearchServiceImpl;

  @Mock
  private CatalogService catalogService;

  @Mock
  private FieldDao fieldDao;

  @Mock
  private CacheManager cacheManager;

  /**
   * Test {@link DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(Category, SearchCriteria)}.
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findExplicitSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"})
  public void testFindExplicitSearchResultsByCategory() throws ServiceException {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findExplicitSearchResultsByCategory(category, new SearchCriteria()));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String, SearchCriteria)}.
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(org.broadleafcommerce.core.catalog.domain.Category, String, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategoryAndQuery(org.broadleafcommerce.core.catalog.domain.Category, String, SearchCriteria)"})
  public void testFindSearchResultsByCategoryAndQuery() throws ServiceException {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategoryAndQuery(category, "Query", new SearchCriteria()));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findFilteredActiveProductsByCategory(Category, SearchCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"})
  public void testFindSearchResultsByCategory_thenCallsFindFilteredActiveProductsByCategory() {
    // Arrange
    when(catalogService.findFilteredActiveProductsByCategory(
        Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(), Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException("category:"));
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, new SearchCriteria()));
    verify(catalogService).findFilteredActiveProductsByCategory(
        isA(org.broadleafcommerce.core.catalog.domain.Category.class), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link Field#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"})
  public void testFindSearchResultsByCategory_thenCallsGetQualifiedFieldName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenThrow(new UnsupportedOperationException(","));
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);
    CategoryImpl category = new CategoryImpl();

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("", new String[]{"foo"});
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(eq(""));
    verify(field).getQualifiedFieldName();
    verify(searchCriteria).getFilterCriteria();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findFilteredActiveProductsByQuery(String, SearchCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"})
  public void testFindSearchResultsByQuery_thenCallsFindFilteredActiveProductsByQuery() {
    // Arrange
    when(catalogService.findFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException("blc-search"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", new SearchCriteria()));
    verify(catalogService).findFilteredActiveProductsByQuery(eq("Query"), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link Field#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"})
  public void testFindSearchResultsByQuery_thenCallsGetQualifiedFieldName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenThrow(new UnsupportedOperationException(","));
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("", new String[]{"foo"});
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(eq(""));
    verify(field).getQualifiedFieldName();
    verify(searchCriteria).getFilterCriteria();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link CatalogService#findFilteredActiveProductsByQuery(String, SearchCriteria)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"})
  public void testFindSearchResults_thenCallsFindFilteredActiveProductsByQuery() throws ServiceException {
    // Arrange
    when(catalogService.findFilteredActiveProductsByQuery(Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException("blc-search"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(new SearchCriteria()));
    verify(catalogService).findFilteredActiveProductsByQuery(isNull(), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   * <ul>
   *   <li>Then calls {@link Field#getQualifiedFieldName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"})
  public void testFindSearchResults_thenCallsGetQualifiedFieldName() throws ServiceException {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenThrow(new UnsupportedOperationException(","));
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("", new String[]{"foo"});
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getQuery()).thenReturn("Query");
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(eq(""));
    verify(field).getQualifiedFieldName();
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria).getQuery();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getSearchFacets(Category)} with {@code Category}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getSearchFacets(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List DatabaseSearchServiceImpl.getSearchFacets(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetSearchFacetsWithCategory_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new UnsupportedOperationException("blc-search"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.getSearchFacets(new CategoryImpl()));
    verify(cacheManager).getCache(eq("blStandardElements"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getSearchFacets()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getSearchFacets()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getSearchFacets()"})
  public void testGetSearchFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new UnsupportedOperationException("blc-search"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> databaseSearchServiceImpl.getSearchFacets());
    verify(cacheManager).getCache(eq("blStandardElements"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCategoryFacets(Category)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getCategoryFacets(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "List DatabaseSearchServiceImpl.getCategoryFacets(org.broadleafcommerce.core.catalog.domain.Category)"})
  public void testGetCategoryFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new UnsupportedOperationException("category:"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.getCategoryFacets(new CategoryImpl()));
    verify(cacheManager).getCache(eq("blStandardElements"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenThrow(new UnsupportedOperationException(","));
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("", new String[]{"foo"});
    SearchCriteria criteria = mock(SearchCriteria.class);
    when(criteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> databaseSearchServiceImpl.setQualifiedKeys(criteria));
    verify(fieldDao).readFieldByAbbreviation(eq(""));
    verify(field).getQualifiedFieldName();
    verify(criteria).getFilterCriteria();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenEmptyString() {
    // Arrange
    SearchCriteria criteria = mock(SearchCriteria.class);
    when(criteria.getSortQuery()).thenReturn("");
    when(criteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(criteria).getFilterCriteria();
    verify(criteria).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given {@link Field} {@link Field#getQualifiedFieldName()} return {@code defaultSku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFieldGetQualifiedFieldNameReturnDefaultSku() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("defaultSku");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("foo", new String[]{"foo"});
    SearchCriteria criteria = mock(SearchCriteria.class);
    doNothing().when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn("Sort Query");
    when(criteria.getFilterCriteria()).thenReturn(stringStringArrayMap);
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao, atLeast(1)).readFieldByAbbreviation(Mockito.<String>any());
    verify(field, atLeast(1)).getQualifiedFieldName();
    verify(criteria).getFilterCriteria();
    verify(criteria, atLeast(1)).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
    verify(criteria).setSortQuery(eq("defaultSku Query"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given {@link Field} {@link Field#getQualifiedFieldName()} return {@code productAttributes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFieldGetQualifiedFieldNameReturnProductAttributes() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("productAttributes");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("foo", new String[]{"foo"});
    SearchCriteria criteria = mock(SearchCriteria.class);
    doNothing().when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn("Sort Query");
    when(criteria.getFilterCriteria()).thenReturn(stringStringArrayMap);
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao, atLeast(1)).readFieldByAbbreviation(Mockito.<String>any());
    verify(field, atLeast(1)).getQualifiedFieldName();
    verify(criteria).getFilterCriteria();
    verify(criteria, atLeast(1)).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
    verify(criteria).setSortQuery(eq("productAttributes Query"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given {@link Field} {@link Field#getQualifiedFieldName()} return {@code Qualified Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFieldGetQualifiedFieldNameReturnQualifiedFieldName() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("foo", new String[]{"foo"});
    SearchCriteria criteria = mock(SearchCriteria.class);
    doNothing().when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn("Sort Query");
    when(criteria.getFilterCriteria()).thenReturn(stringStringArrayMap);
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao, atLeast(1)).readFieldByAbbreviation(Mockito.<String>any());
    verify(field, atLeast(1)).getQualifiedFieldName();
    verify(criteria).getFilterCriteria();
    verify(criteria, atLeast(1)).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
    verify(criteria).setSortQuery(eq("Qualified Field Name Query"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFoo_whenSearchCriteriaGetSortQueryReturnFoo() {
    // Arrange
    SearchCriteria criteria = mock(SearchCriteria.class);
    doNothing().when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn("foo");
    when(criteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(criteria).getFilterCriteria();
    verify(criteria, atLeast(1)).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
    verify(criteria).setSortQuery(eq(""));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenSpace_whenSearchCriteriaGetSortQueryReturnSpace() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put("foo", new String[]{"foo"});
    SearchCriteria criteria = mock(SearchCriteria.class);
    when(criteria.getSortQuery()).thenReturn(" ");
    when(criteria.getFilterCriteria()).thenReturn(stringStringArrayMap);
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation(eq("foo"));
    verify(field).getQualifiedFieldName();
    verify(criteria).getFilterCriteria();
    verify(criteria).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>Then return {@code productAttributes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_thenReturnProductAttributes() {
    // Arrange, Act and Assert
    assertEquals("productAttributes", databaseSearchServiceImpl.getDatabaseQualifiedFieldName("productAttributes"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>Then return {@code Qualified Field Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_thenReturnQualifiedFieldName() {
    // Arrange, Act and Assert
    assertEquals("Qualified Field Name",
        databaseSearchServiceImpl.getDatabaseQualifiedFieldName("Qualified Field Name"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>When {@code defaultSku}.</li>
   *   <li>Then return {@code defaultSku}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_whenDefaultSku_thenReturnDefaultSku() {
    // Arrange, Act and Assert
    assertEquals("defaultSku", databaseSearchServiceImpl.getDatabaseQualifiedFieldName("defaultSku"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   * <ul>
   *   <li>Then return first Facet is {@link SearchFacetImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_thenReturnFirstFacetIsSearchFacetImpl() {
    // Arrange
    ArrayList<SearchFacetRange> searchFacetRanges = new ArrayList<>();
    searchFacetRanges.add(new SearchFacetRangeImpl());

    SearchFacetImpl searchFacetImpl = new SearchFacetImpl();
    searchFacetImpl.setCanMultiselect(true);
    searchFacetImpl.setFieldType(new IndexFieldTypeImpl());
    searchFacetImpl.setId(1L);
    searchFacetImpl.setLabel("Label");
    searchFacetImpl.setName("Name");
    searchFacetImpl.setRequiredFacets(new ArrayList<>());
    searchFacetImpl.setRequiresAllDependentFacets(true);
    searchFacetImpl.setSearchDisplayPriority(1);
    searchFacetImpl.setShowOnSearch(true);
    searchFacetImpl.setUseFacetRanges(true);
    searchFacetImpl.setSearchFacetRanges(searchFacetRanges);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult = databaseSearchServiceImpl
        .buildSearchFacetDtos(categoryFacets);

    // Assert
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    assertSame(searchFacetImpl, actualBuildSearchFacetDtosResult.get(0).getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(databaseSearchServiceImpl.buildSearchFacetDtos(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return first ValueKey is {@code range%5Bnull%3Anull%5D}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_givenTrue_thenReturnFirstValueKeyIsRange5Bnull3Anull5d() {
    // Arrange
    ArrayList<SearchFacetRange> searchFacetRanges = new ArrayList<>();
    searchFacetRanges.add(new SearchFacetRangeImpl());

    SearchFacetImpl facet = new SearchFacetImpl();
    facet.setCanMultiselect(true);
    facet.setFieldType(new IndexFieldTypeImpl());
    facet.setId(1L);
    facet.setLabel("Label");
    facet.setName("Name");
    facet.setRequiredFacets(new ArrayList<>());
    facet.setRequiresAllDependentFacets(true);
    facet.setSearchDisplayPriority(1);
    facet.setShowOnSearch(true);
    facet.setUseFacetRanges(true);
    facet.setSearchFacetRanges(searchFacetRanges);

    // Act
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    assertEquals(1, actualFacetValues.size());
    SearchFacetResultDTO getResult = actualFacetValues.get(0);
    assertEquals("range%5Bnull%3Anull%5D", getResult.getValueKey());
    assertEquals("range[null:null]", getResult.getUnencodedValueKey());
    assertNull(getResult.getValue());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getRangeFacetValues(SearchFacet)"})
  public void testGetRangeFacetValues_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<SearchFacetRange> searchFacetRanges = new ArrayList<>();
    searchFacetRanges.add(new SearchFacetRangeImpl());

    SearchFacetImpl facet = new SearchFacetImpl();
    facet.setCanMultiselect(true);
    facet.setFieldType(new IndexFieldTypeImpl());
    facet.setId(1L);
    facet.setLabel("Label");
    facet.setName("Name");
    facet.setRequiredFacets(new ArrayList<>());
    facet.setRequiresAllDependentFacets(true);
    facet.setSearchDisplayPriority(1);
    facet.setShowOnSearch(true);
    facet.setUseFacetRanges(true);
    facet.setSearchFacetRanges(searchFacetRanges);

    // Act
    List<SearchFacetResultDTO> actualRangeFacetValues = databaseSearchServiceImpl.getRangeFacetValues(facet);

    // Assert
    assertEquals(1, actualRangeFacetValues.size());
    SearchFacetResultDTO getResult = actualRangeFacetValues.get(0);
    SearchFacet facet2 = getResult.getFacet();
    assertTrue(facet2 instanceof SearchFacetImpl);
    assertEquals("range%5Bnull%3Anull%5D", getResult.getValueKey());
    assertEquals("range[null:null]", getResult.getUnencodedValueKey());
    assertNull(getResult.getQuantity());
    assertNull(getResult.getValue());
    assertNull(getResult.getMaxValue());
    assertNull(getResult.getMinValue());
    assertFalse(getResult.isActive());
    assertSame(facet, facet2);
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>When {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getRangeFacetValues(SearchFacet)"})
  public void testGetRangeFacetValues_whenSearchFacetImpl_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(databaseSearchServiceImpl.getRangeFacetValues(new SearchFacetImpl()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#isActive()}.
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DatabaseSearchServiceImpl.isActive()"})
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseSearchServiceImpl()).isActive());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCache()}.
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache DatabaseSearchServiceImpl.getCache()"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, List<SearchFacetDTO>> actualCache = databaseSearchServiceImpl.getCache();

    // Assert
    verify(cacheManager).getCache(eq("blStandardElements"));
    assertNull(actualCache);
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCache()}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#getCache()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Cache DatabaseSearchServiceImpl.getCache()"})
  public void testGetCache_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> databaseSearchServiceImpl.getCache());
    verify(cacheManager).getCache(eq("blStandardElements"));
  }
}
