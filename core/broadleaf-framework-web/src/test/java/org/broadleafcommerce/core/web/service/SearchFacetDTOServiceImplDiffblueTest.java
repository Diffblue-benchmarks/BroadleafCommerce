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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class SearchFacetDTOServiceImplDiffblueTest {
  /**
   * Method under test: {@link SearchFacetDTOServiceImpl#createSearchCriteria()}
   */
  @Test
  void testCreateSearchCriteria() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SearchCriteria actualCreateSearchCriteriaResult = (new SearchFacetDTOServiceImpl()).createSearchCriteria();

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
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  void testSetActiveFacetResults() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert that nothing has changed
    assertTrue(facets.isEmpty());
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  void testSetActiveFacetResults2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert that nothing has changed
    assertEquals(1, facets.size());
    assertSame(searchFacetDTO, facets.get(0));
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  void testSetActiveFacetResults3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setFacetValues(new ArrayList<>());
    searchFacetDTO.setShowQuantity(true);

    SearchFacetDTO searchFacetDTO2 = new SearchFacetDTO();
    searchFacetDTO2.setAbbreviation("42");
    searchFacetDTO2.setActive(false);
    searchFacetDTO2.setFacet(new SearchFacetImpl());
    searchFacetDTO2.setFacetValues(new ArrayList<>());
    searchFacetDTO2.setShowQuantity(false);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO2);
    facets.add(searchFacetDTO);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert that nothing has changed
    assertEquals(2, facets.size());
    assertSame(searchFacetDTO2, facets.get(0));
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  void testSetActiveFacetResults4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert that nothing has changed
    assertTrue(facets.isEmpty());
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List, HttpServletRequest)}
   */
  @Test
  void testSetActiveFacetResults5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

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
    assertSame(searchFacetDTO, facets.get(0));
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

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
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act
    boolean actualIsActiveResult = searchFacetDTOServiceImpl.isActive(result,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}
   */
  @Test
  void testIsActive3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    servletRequest.addParameter("https://example.org/example", "https://example.org/example");

    // Act
    boolean actualIsActiveResult = searchFacetDTOServiceImpl.isActive(result,
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Assert
    verify(searchFacetImpl).getField();
    verify(result).getFacet();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertFalse(actualIsActiveResult);
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)}
   */
  @Test
  void testGetUrlKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetDTO result = mock(SearchFacetDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setAbbreviation(Mockito.<String>any());
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(result).setShowQuantity(anyBoolean());
    result.setAbbreviation("Abbreviation");
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setFacetValues(new ArrayList<>());
    result.setShowQuantity(true);

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(result).getFacet();
    verify(result).setAbbreviation(eq("Abbreviation"));
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setFacetValues(isA(List.class));
    verify(result).setShowQuantity(eq(true));
    verify(searchFacetImpl).getField();
    assertNull(actualUrlKey);
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)}
   */
  @Test
  void testGetUrlKey2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getField()).thenReturn(new FieldImpl());
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getFacet()).thenReturn(searchFacetImpl);
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    String actualUrlKey = searchFacetDTOServiceImpl.getUrlKey(result);

    // Assert
    verify(searchFacetImpl).getField();
    verify(result).getFacet();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertNull(actualUrlKey);
  }

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  void testGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

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

  /**
   * Method under test:
   * {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  void testGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();
    SearchFacetResultDTO result = mock(SearchFacetResultDTO.class);
    when(result.getUnencodedValueKey()).thenReturn("secret");
    doNothing().when(result).setActive(anyBoolean());
    doNothing().when(result).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(result).setMaxValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setMinValue(Mockito.<BigDecimal>any());
    doNothing().when(result).setQuantity(Mockito.<Integer>any());
    doNothing().when(result).setValue(Mockito.<String>any());
    result.setActive(true);
    result.setFacet(new SearchFacetImpl());
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    // Act
    String actualValue = searchFacetDTOServiceImpl.getValue(result);

    // Assert
    verify(result).getUnencodedValueKey();
    verify(result).setActive(eq(true));
    verify(result).setFacet(isA(SearchFacet.class));
    verify(result).setMaxValue(isA(BigDecimal.class));
    verify(result).setMinValue(isA(BigDecimal.class));
    verify(result).setQuantity(eq(1));
    verify(result).setValue(eq("42"));
    assertEquals("secret", actualValue);
  }
}
