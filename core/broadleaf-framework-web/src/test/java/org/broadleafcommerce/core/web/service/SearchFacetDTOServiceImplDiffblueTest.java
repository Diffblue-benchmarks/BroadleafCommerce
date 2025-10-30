/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

@ExtendWith(MockitoExtension.class)
class SearchFacetDTOServiceImplDiffblueTest {
  @InjectMocks
  private SearchFacetDTOServiceImpl searchFacetDTOServiceImpl;

  /**
   * Test {@link SearchFacetDTOServiceImpl#createSearchCriteria()}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#createSearchCriteria()}
   */
  @Test
  @DisplayName("Test createSearchCriteria()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchCriteria SearchFacetDTOServiceImpl.createSearchCriteria()"})
  void testCreateSearchCriteria() {
    // Arrange and Act
    SearchCriteria actualCreateSearchCriteriaResult = searchFacetDTOServiceImpl.createSearchCriteria();

    // Assert
    Collection<String> filterQueries = actualCreateSearchCriteriaResult.getFilterQueries();
    assertTrue(filterQueries instanceof List);
    assertNull(actualCreateSearchCriteriaResult.getPageSize());
    assertNull(actualCreateSearchCriteriaResult.getStartIndex());
    assertNull(actualCreateSearchCriteriaResult.getQuery());
    assertNull(actualCreateSearchCriteriaResult.getRequestHandler());
    assertNull(actualCreateSearchCriteriaResult.getSortQuery());
    assertNull(actualCreateSearchCriteriaResult.getCategory());
    assertEquals(1, actualCreateSearchCriteriaResult.getPage().intValue());
    assertFalse(actualCreateSearchCriteriaResult.getSearchExplicitCategory());
    assertTrue(filterQueries.isEmpty());
    assertTrue(actualCreateSearchCriteriaResult.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test setActiveFacetResults(List, HttpServletRequest); then ArrayList() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SearchFacetDTOServiceImpl.setActiveFacetResults(List, HttpServletRequest)"})
  void testSetActiveFacetResults_thenArrayListSizeIsOne() {
    // Arrange
    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("42");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(facetValues);
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    assertEquals(1, facets.size());
    List<SearchFacetResultDTO> facetValues2 = facets.get(0).getFacetValues();
    assertEquals(1, facetValues2.size());
    assertFalse(facetValues2.get(0).isActive());
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  @DisplayName("Test isActive(SearchFacetResultDTO, HttpServletRequest); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SearchFacetDTOServiceImpl.isActive(SearchFacetResultDTO, HttpServletRequest)"})
  void testIsActive_thenReturnFalse() {
    // Arrange
    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        searchFacetDTOServiceImpl.isActive(result, new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)} with {@code SearchFacetDTO}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetDTO) with 'SearchFacetDTO'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getUrlKey(SearchFacetDTO)"})
  void testGetUrlKeyWithSearchFacetDTO_thenReturnNull() {
    // Arrange
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    SearchFacetDTO result = new SearchFacetDTO();
    result.setAbbreviation("Abbreviation");
    result.setActive(true);
    result.setFacet(facet);
    result.setFacetValues(new ArrayList<>());
    result.setShowQuantity(true);

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(facet).getField();
    assertNull(actualUrlKey);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)} with {@code SearchFacetResultDTO}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getUrlKey(SearchFacetResultDTO) with 'SearchFacetResultDTO'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getUrlKey(SearchFacetResultDTO)"})
  void testGetUrlKeyWithSearchFacetResultDTO_thenReturnNull() {
    // Arrange
    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(facet);
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(facet).getField();
    assertNull(actualUrlKey);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}.
   * <p>
   * Method under test: {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  @DisplayName("Test getValue(SearchFacetResultDTO)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getValue(SearchFacetResultDTO)"})
  void testGetValue() {
    // Arrange
    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act and Assert
    assertEquals("42", searchFacetDTOServiceImpl.getValue(result));
  }
}
