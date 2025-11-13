package org.broadleafcommerce.core.search.service.solr;

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
   *
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is {@code null}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is zero.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrSearchServiceImpl.getDefaultSort(SearchCriteria)"})
  public void testGetDefaultSort_whenSearchCriteria_thenReturnNull() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    // Act and Assert
    assertNull(solrSearchServiceImpl.getDefaultSort(new SearchCriteria()));
  }

  /**
   * Test {@link SolrSearchServiceImpl#getLocalePrefix()}.
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#getLocalePrefix()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String SolrSearchServiceImpl.getLocalePrefix()"})
  public void testGetLocalePrefix() {
    // Arrange, Act and Assert
    assertEquals("", new SolrSearchServiceImpl().getLocalePrefix());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then calls {@link IndexFieldImpl#getFieldTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrSearchServiceImpl.getQueryFields(SolrQuery, List, IndexField, SearchCriteria)"
  })
  public void testGetQueryFields_given42_whenArrayListAdd42_thenCallsGetFieldTypes() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = new SolrQuery();

    ArrayList<String> queryFields = new ArrayList<>();
    queryFields.add("42");
    queryFields.add("foo");

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
   * Test {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link IndexFieldImpl#getFieldTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrSearchServiceImpl.getQueryFields(SolrQuery, List, IndexField, SearchCriteria)"
  })
  public void testGetQueryFields_givenArrayList_thenCallsGetFieldTypes() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = new SolrQuery();
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
   * Test {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then calls {@link IndexFieldImpl#getFieldTypes()}.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrSearchServiceImpl.getQueryFields(SolrQuery, List, IndexField, SearchCriteria)"
  })
  public void testGetQueryFields_givenFoo_whenArrayListAddFoo_thenCallsGetFieldTypes() {
    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrQuery query = new SolrQuery();

    ArrayList<String> queryFields = new ArrayList<>();
    queryFields.add("foo");

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
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#createSearchContextDTO()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.service.solr.SearchContextDTO SolrSearchServiceImpl.createSearchContextDTO()"
  })
  public void testCreateSearchContextDTO() {
    // Arrange, Act and Assert
    assertTrue(new SolrSearchServiceImpl().createSearchContextDTO().getAttributes().isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}.
   *
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).
   *   <li>Then {@link SearchResult} (default constructor) PageSize is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrSearchServiceImpl.setPagingAttributes(SearchResult, int, SearchCriteria)"
  })
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
   *
   * <p>Method under test: {@link SolrSearchServiceImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SolrSearchServiceImpl.isActive()"})
  public void testIsActive() {
    // Arrange, Act and Assert
    assertFalse(new SolrSearchServiceImpl().isActive());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SolrSearchServiceImpl}
   *   <li>{@link SolrSearchServiceImpl#getSolrQueryMethod()}
   *   <li>{@link SolrSearchServiceImpl#shouldShowDebugQuery()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SolrSearchServiceImpl.<init>()",
    "SolrRequest.METHOD SolrSearchServiceImpl.getSolrQueryMethod()",
    "boolean SolrSearchServiceImpl.shouldShowDebugQuery()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrSearchServiceImpl actualSolrSearchServiceImpl = new SolrSearchServiceImpl();
    METHOD actualSolrQueryMethod = actualSolrSearchServiceImpl.getSolrQueryMethod();

    // Assert
    assertNull(actualSolrQueryMethod);
    assertFalse(actualSolrSearchServiceImpl.shouldShowDebugQuery());
  }
}
