/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.IndexFieldTypeImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class DatabaseSearchServiceImplDiffblueTest {
  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(Category, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(Category, SearchCriteria)}
   */
  @Test
  public void testFindExplicitSearchResultsByCategory() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findExplicitSearchResultsByCategory(category, new SearchCriteria()));
  }

  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String, SearchCriteria)}
   */
  @Test
  public void testFindSearchResultsByCategoryAndQuery() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategoryAndQuery(category, "Query", new SearchCriteria()));
  }

  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}
   */
  @Test
  public void testFindSearchResultsByCategory_givenFoo_whenSearchCriteriaGetSortQueryReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn("foo");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}
   */
  @Test
  public void testFindSearchResultsByCategory_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn(",");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   * <ul>
   *   <li>Given {@code ,}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}
   */
  @Test
  public void testFindSearchResultsByQuery_givenComma_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn(",");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test
   * {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}
   */
  @Test
  public void testFindSearchResultsByQuery_givenFoo_whenSearchCriteriaGetSortQueryReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn("foo");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   * <ul>
   *   <li>Given {@code ,}.</li>
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  public void testFindSearchResults_givenComma_thenThrowUnsupportedOperationException() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getQuery()).thenReturn("Query");
    when(searchCriteria.getSortQuery()).thenReturn(",");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria).getQuery();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  public void testFindSearchResults_givenFoo_whenSearchCriteriaGetSortQueryReturnFoo() throws ServiceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(searchCriteria).setSortQuery(Mockito.<String>any());
    when(searchCriteria.getQuery()).thenReturn("Query");
    when(searchCriteria.getSortQuery()).thenReturn("foo");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria).getQuery();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery(eq(""));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   * <ul>
   *   <li>Given {@code ,}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#setSortQuery(String)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  public void testSetQualifiedKeys_givenComma_whenSearchCriteriaSetSortQueryDoesNothing() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria criteria = mock(SearchCriteria.class);
    doNothing().when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn(",");
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
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  public void testSetQualifiedKeys_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
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
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link SearchCriteria} {@link SearchCriteria#getSortQuery()} return
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  public void testSetQualifiedKeys_givenFoo_whenSearchCriteriaGetSortQueryReturnFoo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
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
   *   <li>Then throw {@link UnsupportedOperationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  public void testSetQualifiedKeys_thenThrowUnsupportedOperationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria criteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException(",")).when(criteria).setSortQuery(Mockito.<String>any());
    when(criteria.getSortQuery()).thenReturn(",");
    when(criteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(criteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> databaseSearchServiceImpl.setQualifiedKeys(criteria));
    verify(criteria).getFilterCriteria();
    verify(criteria, atLeast(1)).getSortQuery();
    verify(criteria).setFilterCriteria(isA(Map.class));
    verify(criteria).setSortQuery(eq(""));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>Then return {@code productAttributes}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  public void testGetDatabaseQualifiedFieldName_thenReturnProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("productAttributes",
        (new DatabaseSearchServiceImpl()).getDatabaseQualifiedFieldName("productAttributes"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>Then return {@code Qualified Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  public void testGetDatabaseQualifiedFieldName_thenReturnQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("Qualified Field Name",
        (new DatabaseSearchServiceImpl()).getDatabaseQualifiedFieldName("Qualified Field Name"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   * <ul>
   *   <li>When {@code defaultSku}.</li>
   *   <li>Then return {@code defaultSku}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  public void testGetDatabaseQualifiedFieldName_whenDefaultSku_thenReturnDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("defaultSku", (new DatabaseSearchServiceImpl()).getDatabaseQualifiedFieldName("defaultSku"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return
   * {@code defaultSku}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnDefaultSku() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("defaultSku");
    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(fieldImpl);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(facet);
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act
    databaseSearchServiceImpl.setActiveFacets(facets, new SearchCriteria());

    // Assert
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return
   * {@code productAttributes}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnProductAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("productAttributes");
    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(fieldImpl);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(facet);
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act
    databaseSearchServiceImpl.setActiveFacets(facets, new SearchCriteria());

    // Assert
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return
   * {@code Qualified Field Name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnQualifiedFieldName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");
    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(fieldImpl);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(facet);
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act
    databaseSearchServiceImpl.setActiveFacets(facets, new SearchCriteria());

    // Assert
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  public void testBuildSearchFacetDtos_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

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
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    List<SearchFacetResultDTO> facetValues = getResult.getFacetValues();
    assertEquals(1, facetValues.size());
    SearchFacetResultDTO getResult2 = facetValues.get(0);
    assertEquals("range%5Bnull%3Anull%5D", getResult2.getValueKey());
    assertEquals("range[null:null]", getResult2.getUnencodedValueKey());
    assertNull(getResult2.getQuantity());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getMaxValue());
    assertNull(getResult2.getMinValue());
    assertFalse(getResult.isActive());
    assertFalse(getResult.isShowQuantity());
    assertFalse(getResult2.isActive());
    assertSame(searchFacetImpl, getResult.getFacet());
    assertSame(searchFacetImpl, getResult2.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  public void testBuildSearchFacetDtos_whenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    // Act and Assert
    assertTrue(databaseSearchServiceImpl.buildSearchFacetDtos(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  public void testGetFacetValues_givenTrue_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

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
    assertNull(getResult.getQuantity());
    assertNull(getResult.getValue());
    assertNull(getResult.getMaxValue());
    assertNull(getResult.getMinValue());
    assertFalse(getResult.isActive());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  public void testGetRangeFacetValues_givenArrayList_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());

    // Act
    List<SearchFacetResultDTO> actualRangeFacetValues = databaseSearchServiceImpl.getRangeFacetValues(facet);

    // Assert
    verify(facet).getSearchFacetRanges();
    assertTrue(actualRangeFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  public void testGetRangeFacetValues_givenTrue_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

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
    assertSame(facet, actualRangeFacetValues.get(0).getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  public void testGetRangeFacetValues_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.compareTo(Mockito.<BigDecimal>any())).thenReturn(1);

    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setMinValue(minValue);

    ArrayList<SearchFacetRange> searchFacetRangeList = new ArrayList<>();
    searchFacetRangeList.add(new SearchFacetRangeImpl());
    searchFacetRangeList.add(searchFacetRangeImpl);
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(searchFacetRangeList);

    // Act
    List<SearchFacetResultDTO> actualRangeFacetValues = databaseSearchServiceImpl.getRangeFacetValues(facet);

    // Assert
    verify(minValue).compareTo(isNull());
    verify(facet).getSearchFacetRanges();
    assertEquals(2, actualRangeFacetValues.size());
    SearchFacetResultDTO getResult = actualRangeFacetValues.get(1);
    assertNull(getResult.getQuantity());
    assertNull(getResult.getValue());
    assertNull(getResult.getMaxValue());
    assertFalse(getResult.isActive());
    assertSame(facet, actualRangeFacetValues.get(0).getFacet());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   * <ul>
   *   <li>When {@link SearchFacetImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  public void testGetRangeFacetValues_whenSearchFacetImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    // Act and Assert
    assertTrue(databaseSearchServiceImpl.getRangeFacetValues(new SearchFacetImpl()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#isActive()}.
   * <p>
   * Method under test: {@link DatabaseSearchServiceImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue((new DatabaseSearchServiceImpl()).isActive());
  }
}
