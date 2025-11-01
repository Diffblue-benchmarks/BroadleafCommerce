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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.search.domain.SearchResult;
import org.junit.Test;
import org.mockito.Mockito;

public class SolrSearchServiceImplDiffblueTest {
  /**
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.filterEmptyFacets(facets);

    // Assert that nothing has changed
    assertTrue(facets.isEmpty());
  }

  /**
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test:
   * {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}
   */
  @Test
  public void testGetDefaultSort() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    // Act and Assert
    assertNull(solrSearchServiceImpl.getDefaultSort(new SearchCriteria()));
  }

  /**
   * Method under test: {@link SolrSearchServiceImpl#getLocalePrefix()}
   */
  @Test
  public void testGetLocalePrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SolrSearchServiceImpl()).getLocalePrefix());
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    ArrayList<String> queryFields = new ArrayList<>();
    IndexFieldImpl indexField = new IndexFieldImpl();

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");

    ArrayList<String> queryFields = new ArrayList<>();
    queryFields.add("foo");
    IndexFieldImpl indexField = new IndexFieldImpl();

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");

    ArrayList<String> queryFields = new ArrayList<>();
    queryFields.add("42");
    queryFields.add("foo");
    IndexFieldImpl indexField = new IndexFieldImpl();

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    ArrayList<String> queryFields = new ArrayList<>();

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, null, new SearchCriteria());

    // Assert that nothing has changed
    verify(query).addTermsField(eq("42"));
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = mock(SolrQuery.class);
    when(query.addTermsField(Mockito.<String>any())).thenReturn(new SolrQuery("foo"));
    query.addTermsField("42");
    ArrayList<String> queryFields = new ArrayList<>();
    IndexFieldImpl indexField = mock(IndexFieldImpl.class);
    when(indexField.getFieldTypes()).thenReturn(new ArrayList<>());
    when(indexField.getSearchable()).thenReturn(true);

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());

    // Assert
    verify(query).addTermsField(eq("42"));
    verify(indexField).getFieldTypes();
    verify(indexField).getSearchable();
  }

  /**
   * Method under test: {@link SolrSearchServiceImpl#createSearchContextDTO()}
   */
  @Test
  public void testCreateSearchContextDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrSearchServiceImpl()).createSearchContextDTO().getAttributes().isEmpty());
  }

  /**
   * Method under test:
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}
   */
  @Test
  public void testSetPagingAttributes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Method under test: {@link SolrSearchServiceImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SolrSearchServiceImpl()).isActive());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SolrSearchServiceImpl}
   *   <li>{@link SolrSearchServiceImpl#getSolrQueryMethod()}
   *   <li>{@link SolrSearchServiceImpl#shouldShowDebugQuery()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrSearchServiceImpl actualSolrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrRequest.METHOD actualSolrQueryMethod = actualSolrSearchServiceImpl.getSolrQueryMethod();

    // Assert
    assertNull(actualSolrQueryMethod);
    assertFalse(actualSolrSearchServiceImpl.shouldShowDebugQuery());
  }
}
