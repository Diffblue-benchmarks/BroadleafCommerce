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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.SolrRequest.METHOD;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.search.domain.SearchResult;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SolrSearchServiceImplDiffblueTest {
  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is {@code null}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.filterEmptyFacets(List)"})
  public void testFilterEmptyFacets_givenSearchFacetResultDTOQuantityIsNull_thenArrayListEmpty() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setValue("42");
    searchFacetResultDTO.setQuantity(null);

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
    solrSearchServiceImpl.filterEmptyFacets(facets);

    // Assert
    assertTrue(facets.isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is zero.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.filterEmptyFacets(List)"})
  public void testFilterEmptyFacets_givenSearchFacetResultDTOQuantityIsZero_thenArrayListEmpty() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setValue("42");
    searchFacetResultDTO.setQuantity(0);

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
    solrSearchServiceImpl.filterEmptyFacets(facets);

    // Assert
    assertTrue(facets.isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.filterEmptyFacets(List)"})
  public void testFilterEmptyFacets_thenArrayListSizeIsOne() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    SearchFacetResultDTO searchFacetResultDTO = new SearchFacetResultDTO();
    searchFacetResultDTO.setActive(true);
    searchFacetResultDTO.setFacet(new SearchFacetImpl());
    searchFacetResultDTO.setMaxValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setMinValue(new BigDecimal("2.3"));
    searchFacetResultDTO.setValue("42");
    searchFacetResultDTO.setQuantity(1);

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
    solrSearchServiceImpl.filterEmptyFacets(facets);

    // Assert that nothing has changed
    assertEquals(1, facets.size());
  }

  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.filterEmptyFacets(List)"})
  public void testFilterEmptyFacets_whenArrayList_thenArrayListEmpty() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.filterEmptyFacets(facets);

    // Assert that nothing has changed
    assertTrue(facets.isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}.
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrSearchServiceImpl.getDefaultSort(SearchCriteria)"})
  public void testGetDefaultSort_whenSearchCriteria_thenReturnNull() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    // Act and Assert
    assertNull(solrSearchServiceImpl.getDefaultSort(new SearchCriteria()));
  }

  /**
   * Test {@link SolrSearchServiceImpl#getLocalePrefix()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getLocalePrefix()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SolrSearchServiceImpl.getLocalePrefix()"})
  public void testGetLocalePrefix() {
    // Arrange, Act and Assert
    assertEquals("", (new SolrSearchServiceImpl()).getLocalePrefix());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link IndexFieldImpl#getFieldTypes()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.getQueryFields(SolrQuery, List, IndexField, SearchCriteria)"})
  public void testGetQueryFields_givenArrayList_thenCallsGetFieldTypes() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = new SolrQuery("foo");
    ArrayList<String> queryFields = new ArrayList<>();
    IndexFieldImpl indexField = mock(IndexFieldImpl.class);
    when(indexField.getFieldTypes()).thenReturn(new ArrayList<>());
    when(indexField.getSearchable()).thenReturn(true);

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());

    // Assert
    verify(indexField).getFieldTypes();
    verify(indexField).getSearchable();
  }

  /**
   * Test {@link SolrSearchServiceImpl#createSearchContextDTO()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#createSearchContextDTO()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "org.broadleafcommerce.core.search.service.solr.SearchContextDTO SolrSearchServiceImpl.createSearchContextDTO()"})
  public void testCreateSearchContextDTO() {
    // Arrange, Act and Assert
    assertTrue((new SolrSearchServiceImpl()).createSearchContextDTO().getAttributes().isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}.
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).</li>
   *   <li>Then {@link SearchResult} (default constructor) PageSize is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.setPagingAttributes(SearchResult, int, SearchCriteria)"})
  public void testSetPagingAttributes_whenSearchCriteria_thenSearchResultPageSizeIsNull() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    SearchResult result = new SearchResult();
    result.setFacets(new ArrayList<>());
    result.setPage(1);
    result.setPageSize(3);
    result.setProducts(new ArrayList<>());
    result.setQueryResponse(new QueryResponse());
    result.setTotalResults(1);

    // Act
    solrSearchServiceImpl.setPagingAttributes(result, 10, new SearchCriteria());

    // Assert
    assertNull(result.getPageSize());
    assertEquals(10, result.getTotalResults().intValue());
  }

  /**
   * Test {@link SolrSearchServiceImpl#isActive()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#isActive()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SolrSearchServiceImpl.isActive()"})
  public void testIsActive() {
    // Arrange, Act and Assert
    assertFalse((new SolrSearchServiceImpl()).isActive());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SolrSearchServiceImpl}
   *   <li>{@link SolrSearchServiceImpl#getSolrQueryMethod()}
   *   <li>{@link SolrSearchServiceImpl#shouldShowDebugQuery()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SolrSearchServiceImpl.<init>()",
      "SolrRequest.METHOD SolrSearchServiceImpl.getSolrQueryMethod()",
      "boolean SolrSearchServiceImpl.shouldShowDebugQuery()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrSearchServiceImpl actualSolrSearchServiceImpl = new SolrSearchServiceImpl();
    METHOD actualSolrQueryMethod = actualSolrSearchServiceImpl.getSolrQueryMethod();

    // Assert
    assertNull(actualSolrQueryMethod);
    assertFalse(actualSolrSearchServiceImpl.shouldShowDebugQuery());
  }
}
