package org.broadleafcommerce.core.web.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class SearchFacetDTOServiceImplDiffblueTest {
  /**
   * Test {@link SearchFacetDTOServiceImpl#createSearchCriteria()}.
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#createSearchCriteria()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"SearchCriteria SearchFacetDTOServiceImpl.createSearchCriteria()"})
  public void testCreateSearchCriteria() {
    // Arrange and Act
    SearchCriteria actualCreateSearchCriteriaResult =
        new SearchFacetDTOServiceImpl().createSearchCriteria();

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
   *
   * <ul>
   *   <li>Given {@link SearchFacetDTOServiceImpl} (default constructor).
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#setActiveFacetResults(List,
   * HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchFacetDTOServiceImpl.setActiveFacetResults(List, HttpServletRequest)"
  })
  public void testSetActiveFacetResults_givenSearchFacetDTOServiceImpl_thenArrayListSizeIsOne() {
    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setQuantity(1);
    searchFacetResultDTO.setValue("Facets");

    ArrayList<SearchFacetResultDTO> facetValues = new ArrayList<>();
    facetValues.add(searchFacetResultDTO);

    SearchFacetDTO searchFacetDTO = new SearchFacetDTO();
    searchFacetDTO.setAbbreviation("Abbreviation");
    searchFacetDTO.setActive(true);
    searchFacetDTO.setFacet(new SearchFacetImpl());
    searchFacetDTO.setShowQuantity(true);
    searchFacetDTO.setFacetValues(facetValues);

    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    facets.add(searchFacetDTO);

    // Act
    searchFacetDTOServiceImpl.setActiveFacetResults(facets, new MockHttpServletRequest());

    // Assert
    assertEquals(1, facets.size());
    List<SearchFacetResultDTO> facetValues2 = facets.get(0).getFacetValues();
    assertEquals(1, facetValues2.size());
    assertFalse(facetValues2.get(0).isActive());
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   *
   * <ul>
   *   <li>Given {@link SearchFacet} {@link SearchFacet#getField()} return {@link FieldImpl}
   *       (default constructor).
   *   <li>Then calls {@link SearchFacet#getField()}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO,
   * HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetDTOServiceImpl.isActive(SearchFacetResultDTO, HttpServletRequest)"
  })
  public void testIsActive_givenSearchFacetGetFieldReturnFieldImpl_thenCallsGetField() {
    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

    SearchFacet facet = mock(SearchFacet.class);
    when(facet.getField()).thenReturn(new FieldImpl());

    SearchFacetResultDTO result = new SearchFacetResultDTO();
    result.setActive(true);
    result.setFacet(facet);
    result.setMaxValue(new BigDecimal("2.3"));
    result.setMinValue(new BigDecimal("2.3"));
    result.setQuantity(1);
    result.setValue("42");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("Name", "42");

    // Act
    boolean actualIsActiveResult = searchFacetDTOServiceImpl.isActive(result, request);

    // Assert
    verify(facet).getField();
    assertFalse(actualIsActiveResult);
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO, HttpServletRequest)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#isActive(SearchFacetResultDTO,
   * HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SearchFacetDTOServiceImpl.isActive(SearchFacetResultDTO, HttpServletRequest)"
  })
  public void testIsActive_whenMockHttpServletRequest_thenReturnFalse() {
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
    assertFalse(searchFacetDTOServiceImpl.isActive(result, new MockHttpServletRequest()));
  }

  /**
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)} with {@code SearchFacetDTO}.
   *
   * <ul>
   *   <li>Given {@link SearchFacetDTOServiceImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getUrlKey(SearchFacetDTO)"})
  public void testGetUrlKeyWithSearchFacetDTO_givenSearchFacetDTOServiceImpl_thenReturnNull() {
    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

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
   * Test {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)} with {@code
   * SearchFacetResultDTO}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#getUrlKey(SearchFacetResultDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getUrlKey(SearchFacetResultDTO)"})
  public void testGetUrlKeyWithSearchFacetResultDTO_thenReturnNull() {
    // Arrange
    SearchFacetDTOServiceImpl searchFacetDTOServiceImpl = new SearchFacetDTOServiceImpl();

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
   *
   * <p>Method under test: {@link SearchFacetDTOServiceImpl#getValue(SearchFacetResultDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SearchFacetDTOServiceImpl.getValue(SearchFacetResultDTO)"})
  public void testGetValue() {
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
}
