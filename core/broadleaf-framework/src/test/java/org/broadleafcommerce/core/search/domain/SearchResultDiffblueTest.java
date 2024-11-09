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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;

public class SearchResultDiffblueTest {
  /**
   * Test {@link SearchResult#getStartResult()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl}
   * (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  public void testGetStartResult_givenArrayListAddProductBundleImpl_thenReturnIntValueIsOne() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);
    searchResult.setProducts(products);

    // Act and Assert
    assertEquals(1, searchResult.getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getStartResult()}.
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) Page is one.</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  public void testGetStartResult_givenSearchResultPageIsOne_thenReturnIntValueIsZero() {
    // Arrange
    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);
    searchResult.setProducts(new ArrayList<>());

    // Act and Assert
    assertEquals(0, searchResult.getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getStartResult()}.
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor).</li>
   *   <li>Then return intValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  public void testGetStartResult_givenSearchResult_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new SearchResult()).getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getEndResult()}.
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) Facets is
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getEndResult()}
   */
  @Test
  public void testGetEndResult_givenSearchResultFacetsIsArrayList_thenReturnIntValueIsOne() {
    // Arrange
    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setProducts(new ArrayList<>());
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);

    // Act and Assert
    assertEquals(1, searchResult.getEndResult().intValue());
  }

  /**
   * Test {@link SearchResult#getTotalPages()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl}
   * (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  public void testGetTotalPages_givenArrayListAddProductBundleImpl_thenReturnIntValueIsOne() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);
    searchResult.setProducts(products);

    // Act and Assert
    assertEquals(1, searchResult.getTotalPages().intValue());
  }

  /**
   * Test {@link SearchResult#getTotalPages()}.
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) PageSize is three.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  public void testGetTotalPages_givenSearchResultPageSizeIsThree_thenReturnIntValueIsOne() {
    // Arrange
    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);
    searchResult.setProducts(new ArrayList<>());

    // Act and Assert
    assertEquals(1, searchResult.getTotalPages().intValue());
  }

  /**
   * Test {@link SearchResult#getTotalPages()}.
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor).</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  public void testGetTotalPages_givenSearchResult_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, (new SearchResult()).getTotalPages().intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SearchResult}
   *   <li>{@link SearchResult#setFacets(List)}
   *   <li>{@link SearchResult#setPage(Integer)}
   *   <li>{@link SearchResult#setPageSize(Integer)}
   *   <li>{@link SearchResult#setProducts(List)}
   *   <li>{@link SearchResult#setQueryResponse(QueryResponse)}
   *   <li>{@link SearchResult#setTotalResults(Integer)}
   *   <li>{@link SearchResult#getFacets()}
   *   <li>{@link SearchResult#getPage()}
   *   <li>{@link SearchResult#getPageSize()}
   *   <li>{@link SearchResult#getProducts()}
   *   <li>{@link SearchResult#getQueryResponse()}
   *   <li>{@link SearchResult#getTotalResults()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SearchResult actualSearchResult = new SearchResult();
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();
    actualSearchResult.setFacets(facets);
    actualSearchResult.setPage(1);
    actualSearchResult.setPageSize(3);
    ArrayList<Product> products = new ArrayList<>();
    actualSearchResult.setProducts(products);
    QueryResponse queryResponse = new QueryResponse();
    actualSearchResult.setQueryResponse(queryResponse);
    actualSearchResult.setTotalResults(1);
    List<SearchFacetDTO> actualFacets = actualSearchResult.getFacets();
    Integer actualPage = actualSearchResult.getPage();
    Integer actualPageSize = actualSearchResult.getPageSize();
    List<Product> actualProducts = actualSearchResult.getProducts();
    QueryResponse actualQueryResponse = actualSearchResult.getQueryResponse();
    Integer actualTotalResults = actualSearchResult.getTotalResults();

    // Assert that nothing has changed
    assertEquals(1, actualPage.intValue());
    assertEquals(1, actualTotalResults.intValue());
    assertEquals(3, actualPageSize.intValue());
    assertTrue(actualFacets.isEmpty());
    assertTrue(actualProducts.isEmpty());
    assertSame(facets, actualFacets);
    assertSame(products, actualProducts);
    assertSame(queryResponse, actualQueryResponse);
  }
}
