package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SearchResultDiffblueTest {
  /**
   * Test {@link SearchResult#getStartResult()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getStartResult()"})
  public void testGetStartResult_givenArrayListAddProductBundleImpl_thenReturnIntValueIsOne() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setProducts(products);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);

    // Act and Assert
    assertEquals(1, searchResult.getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getStartResult()}.
   *
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) Page is one.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getStartResult()"})
  public void testGetStartResult_givenSearchResultPageIsOne_thenReturnIntValueIsZero() {
    // Arrange
    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setProducts(new ArrayList<>());
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);

    // Act and Assert
    assertEquals(0, searchResult.getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getStartResult()}.
   *
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor).
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getStartResult()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getStartResult()"})
  public void testGetStartResult_givenSearchResult_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, new SearchResult().getStartResult().intValue());
  }

  /**
   * Test {@link SearchResult#getEndResult()}.
   *
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) Facets is {@link ArrayList#ArrayList()}.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getEndResult()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getEndResult()"})
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
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ProductBundleImpl} (default constructor).
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getTotalPages()"})
  public void testGetTotalPages_givenArrayListAddProductBundleImpl_thenReturnIntValueIsOne() {
    // Arrange
    ArrayList<Product> products = new ArrayList<>();
    products.add(new ProductBundleImpl());

    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setProducts(products);
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);

    // Act and Assert
    assertEquals(1, searchResult.getTotalPages().intValue());
  }

  /**
   * Test {@link SearchResult#getTotalPages()}.
   *
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor) PageSize is three.
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getTotalPages()"})
  public void testGetTotalPages_givenSearchResultPageSizeIsThree_thenReturnIntValueIsOne() {
    // Arrange
    SearchResult searchResult = new SearchResult();
    searchResult.setFacets(new ArrayList<>());
    searchResult.setPage(1);
    searchResult.setPageSize(3);
    searchResult.setProducts(new ArrayList<>());
    searchResult.setQueryResponse(new QueryResponse());
    searchResult.setTotalResults(1);

    // Act and Assert
    assertEquals(1, searchResult.getTotalPages().intValue());
  }

  /**
   * Test {@link SearchResult#getTotalPages()}.
   *
   * <ul>
   *   <li>Given {@link SearchResult} (default constructor).
   *   <li>Then return intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link SearchResult#getTotalPages()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer SearchResult.getTotalPages()"})
  public void testGetTotalPages_givenSearchResult_thenReturnIntValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1, new SearchResult().getTotalPages().intValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SearchResult.<init>()",
    "List SearchResult.getFacets()",
    "Integer SearchResult.getPage()",
    "Integer SearchResult.getPageSize()",
    "List SearchResult.getProducts()",
    "QueryResponse SearchResult.getQueryResponse()",
    "Integer SearchResult.getTotalResults()",
    "void SearchResult.setFacets(List)",
    "void SearchResult.setPage(Integer)",
    "void SearchResult.setPageSize(Integer)",
    "void SearchResult.setProducts(List)",
    "void SearchResult.setQueryResponse(QueryResponse)",
    "void SearchResult.setTotalResults(Integer)"
  })
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

    // Assert
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
