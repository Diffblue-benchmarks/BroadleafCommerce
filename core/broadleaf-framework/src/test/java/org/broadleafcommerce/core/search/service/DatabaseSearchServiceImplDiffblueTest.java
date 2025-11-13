package org.broadleafcommerce.core.search.service;

import static org.junit.Assert.assertArrayEquals;
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
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
import org.broadleafcommerce.core.search.dao.SearchFacetDao;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldEntity;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mvel2.util.InternalNumber;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class DatabaseSearchServiceImplDiffblueTest {
  @Mock private CacheManager cacheManager;

  @Mock private CatalogService catalogService;

  @InjectMocks private DatabaseSearchServiceImpl databaseSearchServiceImpl;

  @Mock private FieldDao fieldDao;

  @Mock private SearchFacetDao searchFacetDao;

  /**
   * Test {@link DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(Category,
   * SearchCriteria)}.
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findExplicitSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findExplicitSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindExplicitSearchResultsByCategory() throws ServiceException {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            databaseSearchServiceImpl.findExplicitSearchResultsByCategory(
                category, new SearchCriteria()));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String,
   * SearchCriteria)}.
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategoryAndQuery(org.broadleafcommerce.core.catalog.domain.Category,
   * String, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategoryAndQuery(org.broadleafcommerce.core.catalog.domain.Category, String, SearchCriteria)"
  })
  public void testFindSearchResultsByCategoryAndQuery() throws ServiceException {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            databaseSearchServiceImpl.findSearchResultsByCategoryAndQuery(
                category, "Query", new SearchCriteria()));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindSearchResultsByCategory() {
    // Arrange
    when(catalogService.findFilteredActiveProductsByCategory(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException());
    CategoryImpl category = new CategoryImpl();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            databaseSearchServiceImpl.findSearchResultsByCategory(category, new SearchCriteria()));
    verify(catalogService)
        .findFilteredActiveProductsByCategory(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class),
            isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@code not blank}.
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindSearchResultsByCategory_givenNotBlank_thenCallsReadFieldByAbbreviation() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    CategoryImpl category = new CategoryImpl();

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery("not blank");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(fieldDao).readFieldByAbbreviation("not");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindSearchResultsByCategory_thenCallsGetCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(catalogService.findFilteredActiveProductsByCategory(
            Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any(),
            Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());
    CategoryImpl category = new CategoryImpl();

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery(" ");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(cacheManager).getCache("blStandardElements");
    verify(catalogService)
        .findFilteredActiveProductsByCategory(
            isA(org.broadleafcommerce.core.catalog.domain.Category.class),
            isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link SearchCriteria#getSortQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindSearchResultsByCategory_thenCallsGetSortQuery() {
    // Arrange
    CategoryImpl category = new CategoryImpl();

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException())
        .when(searchCriteria)
        .setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn("foo,bar");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery("");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByCategory(org.broadleafcommerce.core.catalog.domain.Category, SearchCriteria)"
  })
  public void testFindSearchResultsByCategory_thenCallsReadFieldByAbbreviation() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    CategoryImpl category = new CategoryImpl();

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put(",", new String[] {","});

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByCategory(category, searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(",");
    verify(searchCriteria).getFilterCriteria();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"
  })
  public void testFindSearchResultsByQuery() {
    // Arrange
    when(catalogService.findFilteredActiveProductsByQuery(
            Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", new SearchCriteria()));
    verify(catalogService)
        .findFilteredActiveProductsByQuery(eq("Query"), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"
  })
  public void testFindSearchResultsByQuery_thenCallsGetCache() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(catalogService.findFilteredActiveProductsByQuery(
            Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery(",");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(cacheManager).getCache("blStandardElements");
    verify(catalogService)
        .findFilteredActiveProductsByQuery(eq("Query"), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link SearchCriteria#getSortQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"
  })
  public void testFindSearchResultsByQuery_thenCallsGetSortQuery() {
    // Arrange
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException())
        .when(searchCriteria)
        .setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn("foo,bar");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery("");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"
  })
  public void testFindSearchResultsByQuery_thenCallsReadFieldByAbbreviation() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put(",", new String[] {","});

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(",");
    verify(searchCriteria).getFilterCriteria();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResultsByQuery(String,
   * SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResultsByQuery(String, SearchCriteria)"
  })
  public void testFindSearchResultsByQuery_thenCallsReadFieldByAbbreviation2() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery("not blank");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResultsByQuery("Query", searchCriteria));
    verify(fieldDao).readFieldByAbbreviation("not");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"
  })
  public void testFindSearchResults() throws ServiceException {
    // Arrange
    when(catalogService.findFilteredActiveProductsByQuery(
            Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(new SearchCriteria()));
    verify(catalogService).findFilteredActiveProductsByQuery(isNull(), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@link UnsupportedOperationException#UnsupportedOperationException()}.
   *   <li>Then calls {@link SearchCriteria#getSortQuery()}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"
  })
  public void testFindSearchResults_givenUnsupportedOperationException_thenCallsGetSortQuery()
      throws ServiceException {
    // Arrange
    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    doThrow(new UnsupportedOperationException())
        .when(searchCriteria)
        .setSortQuery(Mockito.<String>any());
    when(searchCriteria.getSortQuery()).thenReturn("foo,bar");
    when(searchCriteria.getQuery()).thenReturn("Query");
    when(searchCriteria.getFilterCriteria()).thenReturn(new HashMap<>());
    doNothing().when(searchCriteria).setFilterCriteria(Mockito.<Map<String, String[]>>any());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria).getQuery();
    verify(searchCriteria, atLeast(1)).getSortQuery();
    verify(searchCriteria).setFilterCriteria(isA(Map.class));
    verify(searchCriteria).setSortQuery("");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheManager#getCache(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"
  })
  public void testFindSearchResults_thenCallsGetCache() throws ServiceException {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    when(catalogService.findFilteredActiveProductsByQuery(
            Mockito.<String>any(), Mockito.<SearchCriteria>any()))
        .thenReturn(new ArrayList<>());

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery(",");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(cacheManager).getCache("blStandardElements");
    verify(catalogService).findFilteredActiveProductsByQuery(isNull(), isA(SearchCriteria.class));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"
  })
  public void testFindSearchResults_thenCallsReadFieldByAbbreviation() throws ServiceException {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    HashMap<String, String[]> stringStringArrayMap = new HashMap<>();
    stringStringArrayMap.put(",", new String[] {","});

    SearchCriteria searchCriteria = mock(SearchCriteria.class);
    when(searchCriteria.getQuery()).thenReturn("Query");
    when(searchCriteria.getFilterCriteria()).thenReturn(stringStringArrayMap);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(fieldDao).readFieldByAbbreviation(",");
    verify(searchCriteria).getFilterCriteria();
    verify(searchCriteria).getQuery();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then calls {@link FieldDao#readFieldByAbbreviation(String)}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.search.domain.SearchResult DatabaseSearchServiceImpl.findSearchResults(SearchCriteria)"
  })
  public void testFindSearchResults_thenCallsReadFieldByAbbreviation2() throws ServiceException {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    SearchCriteria searchCriteria = new SearchCriteria();
    searchCriteria.setSortQuery("not blank");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.findSearchResults(searchCriteria));
    verify(fieldDao).readFieldByAbbreviation("not");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getSearchFacets(Category)} with {@code Category}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#getSearchFacets(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DatabaseSearchServiceImpl.getSearchFacets(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetSearchFacetsWithCategory_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.getSearchFacets(new CategoryImpl()));
    verify(cacheManager).getCache("blStandardElements");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getSearchFacets()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getSearchFacets()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getSearchFacets()"})
  public void testGetSearchFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> databaseSearchServiceImpl.getSearchFacets());
    verify(cacheManager).getCache("blStandardElements");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCategoryFacets(Category)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DatabaseSearchServiceImpl#getCategoryFacets(org.broadleafcommerce.core.catalog.domain.Category)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List DatabaseSearchServiceImpl.getCategoryFacets(org.broadleafcommerce.core.catalog.domain.Category)"
  })
  public void testGetCategoryFacets_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.getCategoryFacets(new CategoryImpl()));
    verify(cacheManager).getCache("blStandardElements");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link SearchCriteria} (default constructor) SortQuery is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenEmptyString_whenSearchCriteriaSortQueryIsEmptyString() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert that nothing has changed
    assertEquals("", criteria.getSortQuery());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@link FieldDao} {@link FieldDao#readFieldByAbbreviation(String)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFieldDaoReadFieldByAbbreviationReturnNull() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(null);

    HashMap<String, String[]> filterCriteria = new HashMap<>();
    filterCriteria.put("foo", new String[] {"foo"});

    SearchCriteria criteria = new SearchCriteria();
    criteria.setFilterCriteria(filterCriteria);

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation("foo");
    assertNull(criteria.getSortQuery());
    assertTrue(criteria.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@code foo,bar}.
   *   <li>When {@link SearchCriteria} (default constructor) SortQuery is {@code foo,bar}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenFooBar_whenSearchCriteriaSortQueryIsFooBar() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("foo,bar");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    assertEquals("", criteria.getSortQuery());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then {@link SearchCriteria} (default constructor) SortQuery is space.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_givenSpace_thenSearchCriteriaSortQueryIsSpace() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery(" ");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert that nothing has changed
    assertEquals(" ", criteria.getSortQuery());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then {@link SearchCriteria} (default constructor) FilterCriteria size is one.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenSearchCriteriaFilterCriteriaSizeIsOne() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(fieldImpl);

    HashMap<String, String[]> filterCriteria = new HashMap<>();
    filterCriteria.put("foo", new String[] {"foo"});

    SearchCriteria criteria = new SearchCriteria();
    criteria.setFilterCriteria(filterCriteria);

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation("foo");
    assertNull(criteria.getSortQuery());
    Map<String, String[]> filterCriteria2 = criteria.getFilterCriteria();
    assertEquals(1, filterCriteria2.size());
    assertArrayEquals(new String[] {"foo"}, filterCriteria2.get("Category.null"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then {@link SearchCriteria} (default constructor) SortQuery is {@code Category.null
   *       blank}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenSearchCriteriaSortQueryIsCategoryNullBlank() {
    // Arrange
    FieldImpl fieldImpl = new FieldImpl();
    fieldImpl.setEntityType(FieldEntity.CATEGORY);
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(fieldImpl);

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("not blank");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation("not");
    assertEquals("Category.null blank", criteria.getSortQuery());
    assertTrue(criteria.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then {@link SearchCriteria} (default constructor) SortQuery is {@code defaultSku blank}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenSearchCriteriaSortQueryIsDefaultSkuBlank() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("defaultSku");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("not blank");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation("not");
    verify(field).getQualifiedFieldName();
    assertEquals("defaultSku blank", criteria.getSortQuery());
    assertTrue(criteria.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then {@link SearchCriteria} (default constructor) SortQuery is {@code productAttributes
   *       blank}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenSearchCriteriaSortQueryIsProductAttributesBlank() {
    // Arrange
    Field field = mock(Field.class);
    when(field.getQualifiedFieldName()).thenReturn("productAttributes");
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any())).thenReturn(field);

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("not blank");

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert
    verify(fieldDao).readFieldByAbbreviation("not");
    verify(field).getQualifiedFieldName();
    assertEquals("productAttributes blank", criteria.getSortQuery());
    assertTrue(criteria.getFilterCriteria().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenThrowUnsupportedOperationException() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    SearchCriteria criteria = new SearchCriteria();
    criteria.setSortQuery("not blank");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.setQualifiedKeys(criteria));
    verify(fieldDao).readFieldByAbbreviation("not");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_thenThrowUnsupportedOperationException2() {
    // Arrange
    when(fieldDao.readFieldByAbbreviation(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    HashMap<String, String[]> filterCriteria = new HashMap<>();
    filterCriteria.put("foo", new String[] {"foo"});

    SearchCriteria criteria = new SearchCriteria();
    criteria.setFilterCriteria(filterCriteria);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.setQualifiedKeys(criteria));
    verify(fieldDao).readFieldByAbbreviation("foo");
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}.
   *
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).
   *   <li>Then {@link SearchCriteria} (default constructor) SortQuery is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setQualifiedKeys(SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setQualifiedKeys(SearchCriteria)"})
  public void testSetQualifiedKeys_whenSearchCriteria_thenSearchCriteriaSortQueryIsNull() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();
    SearchCriteria criteria = new SearchCriteria();

    // Act
    databaseSearchServiceImpl.setQualifiedKeys(criteria);

    // Assert that nothing has changed
    assertNull(criteria.getSortQuery());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code productAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_thenReturnProductAttributes() {
    // Arrange, Act and Assert
    assertEquals(
        "productAttributes",
        new DatabaseSearchServiceImpl().getDatabaseQualifiedFieldName("productAttributes"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   *
   * <ul>
   *   <li>Then return {@code Qualified Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_thenReturnQualifiedFieldName() {
    // Arrange, Act and Assert
    assertEquals(
        "Qualified Field Name",
        new DatabaseSearchServiceImpl().getDatabaseQualifiedFieldName("Qualified Field Name"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}.
   *
   * <ul>
   *   <li>When {@code defaultSku}.
   *   <li>Then return {@code defaultSku}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getDatabaseQualifiedFieldName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String DatabaseSearchServiceImpl.getDatabaseQualifiedFieldName(String)"})
  public void testGetDatabaseQualifiedFieldName_whenDefaultSku_thenReturnDefaultSku() {
    // Arrange, Act and Assert
    assertEquals(
        "defaultSku", new DatabaseSearchServiceImpl().getDatabaseQualifiedFieldName("defaultSku"));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       defaultSku}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setActiveFacets(List, SearchCriteria)"})
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnDefaultSku() {
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
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       productAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setActiveFacets(List, SearchCriteria)"})
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnProductAttributes() {
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
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code Qualified
   *       Field Name}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#setActiveFacets(List, SearchCriteria)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DatabaseSearchServiceImpl.setActiveFacets(List, SearchCriteria)"})
  public void testSetActiveFacets_givenFieldImplGetQualifiedFieldNameReturnQualifiedFieldName() {
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
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("productAttributes");
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(stringList);

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(searchFacetImpl.getField()).thenReturn(fieldImpl);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(searchFacetImpl).getField();
    verify(searchFacetImpl).getSearchFacetRanges();
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    List<SearchFacetResultDTO> facetValues =
        actualBuildSearchFacetDtosResult.get(0).getFacetValues();
    assertEquals(1, facetValues.size());
    SearchFacetResultDTO getResult = facetValues.get(0);
    assertEquals("productAttributes", getResult.getUnencodedValueKey());
    assertEquals("productAttributes", getResult.getValue());
    assertEquals("productAttributes", getResult.getValueKey());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos2() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("productAttributes");

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(searchFacetImpl.getField()).thenReturn(fieldImpl);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("productAttributes"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(searchFacetImpl).getField();
    verify(searchFacetImpl).getSearchFacetRanges();
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    assertNull(getResult.getAbbreviation());
    assertFalse(getResult.isActive());
    assertFalse(getResult.isShowQuantity());
    assertTrue(getResult.getFacetValues().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       defaultSku}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_givenFieldImplGetQualifiedFieldNameReturnDefaultSku() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("defaultSku");

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(searchFacetImpl.getField()).thenReturn(fieldImpl);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("defaultSku"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(searchFacetImpl).getField();
    verify(searchFacetImpl).getSearchFacetRanges();
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    assertNull(getResult.getAbbreviation());
    assertFalse(getResult.isActive());
    assertFalse(getResult.isShowQuantity());
    assertTrue(getResult.getFacetValues().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>Then return first Facet is {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_thenReturnFirstFacetIsSearchFacetImpl() {
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
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    assertEquals(1, getResult.getFacetValues().size());
    assertSame(searchFacetImpl, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>Then return first FacetValues size is two.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_thenReturnFirstFacetValuesSizeIsTwo() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.compareTo(Mockito.<BigDecimal>any())).thenReturn(1);

    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setMinValue(minValue);

    ArrayList<SearchFacetRange> searchFacetRangeList = new ArrayList<>();
    searchFacetRangeList.add(new SearchFacetRangeImpl());
    searchFacetRangeList.add(searchFacetRangeImpl);

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(searchFacetRangeList);
    when(searchFacetImpl.getField()).thenReturn(mock(FieldImpl.class));

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    verify(minValue).compareTo(isNull());
    verify(searchFacetImpl, atLeast(1)).getSearchFacetRanges();
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    List<SearchFacetResultDTO> facetValues = getResult.getFacetValues();
    assertEquals(2, facetValues.size());
    SearchFacetResultDTO getResult2 = facetValues.get(1);
    assertNull(getResult2.getQuantity());
    assertNull(getResult.getAbbreviation());
    assertNull(getResult2.getValue());
    assertNull(getResult2.getMaxValue());
    assertFalse(getResult2.isActive());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>Then return not first Active.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_thenReturnNotFirstActive() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(searchFacetImpl.getField()).thenReturn(fieldImpl);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act
    List<SearchFacetDTO> actualBuildSearchFacetDtosResult =
        databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(searchFacetImpl).getField();
    verify(searchFacetImpl).getSearchFacetRanges();
    assertEquals(1, actualBuildSearchFacetDtosResult.size());
    SearchFacetDTO getResult = actualBuildSearchFacetDtosResult.get(0);
    assertNull(getResult.getAbbreviation());
    assertFalse(getResult.isActive());
    assertFalse(getResult.isShowQuantity());
    assertTrue(getResult.getFacetValues().isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_thenThrowUnsupportedOperationException() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenThrow(new UnsupportedOperationException());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl searchFacetImpl = mock(SearchFacetImpl.class);
    when(searchFacetImpl.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(searchFacetImpl.getField()).thenReturn(fieldImpl);

    ArrayList<SearchFacet> categoryFacets = new ArrayList<>();
    categoryFacets.add(searchFacetImpl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.buildSearchFacetDtos(categoryFacets));
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(searchFacetImpl).getField();
    verify(searchFacetImpl).getSearchFacetRanges();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#buildSearchFacetDtos(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.buildSearchFacetDtos(List)"})
  public void testBuildSearchFacetDtos_whenArrayList_thenReturnEmpty() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    // Act and Assert
    assertTrue(databaseSearchServiceImpl.buildSearchFacetDtos(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       defaultSku}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_givenFieldImplGetQualifiedFieldNameReturnDefaultSku() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("defaultSku");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("defaultSku"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    verify(facet).getSearchFacetRanges();
    assertTrue(actualFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       productAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_givenFieldImplGetQualifiedFieldNameReturnProductAttributes() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("productAttributes");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("productAttributes"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    verify(facet).getSearchFacetRanges();
    assertTrue(actualFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link InternalNumber} {@link InternalNumber#compareTo(BigDecimal)} return one.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_givenInternalNumberCompareToReturnOne_thenReturnSizeIsTwo() {
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
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    verify(minValue).compareTo(isNull());
    verify(facet, atLeast(1)).getSearchFacetRanges();
    assertEquals(2, actualFacetValues.size());
    SearchFacetResultDTO getResult = actualFacetValues.get(1);
    assertNull(getResult.getQuantity());
    assertNull(getResult.getValue());
    assertNull(getResult.getMaxValue());
    assertFalse(getResult.isActive());
    assertSame(facet, actualFacetValues.get(0).getFacet());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return first Facet is {@link SearchFacetImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_givenTrue_thenReturnFirstFacetIsSearchFacetImpl() {
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
    assertSame(facet, actualFacetValues.get(0).getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_thenReturnEmpty() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    verify(facet).getSearchFacetRanges();
    assertTrue(actualFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Then return first UnencodedValueKey is {@code productAttributes}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_thenReturnFirstUnencodedValueKeyIsProductAttributes() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("productAttributes");
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(stringList);

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualFacetValues = databaseSearchServiceImpl.getFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    verify(facet).getSearchFacetRanges();
    assertEquals(1, actualFacetValues.size());
    SearchFacetResultDTO getResult = actualFacetValues.get(0);
    assertEquals("productAttributes", getResult.getUnencodedValueKey());
    assertEquals("productAttributes", getResult.getValue());
    assertEquals("productAttributes", getResult.getValueKey());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getFacetValues(SearchFacet)"})
  public void testGetFacetValues_thenThrowUnsupportedOperationException() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenThrow(new UnsupportedOperationException());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getSearchFacetRanges()).thenReturn(new ArrayList<>());
    when(facet.getField()).thenReturn(fieldImpl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> databaseSearchServiceImpl.getFacetValues(facet));
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    verify(facet).getSearchFacetRanges();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link DatabaseSearchServiceImpl} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getRangeFacetValues(SearchFacet)"})
  public void testGetRangeFacetValues_givenDatabaseSearchServiceImpl_thenReturnSizeIsOne() {
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
    List<SearchFacetResultDTO> actualRangeFacetValues =
        databaseSearchServiceImpl.getRangeFacetValues(facet);

    // Assert
    assertEquals(1, actualRangeFacetValues.size());
    SearchFacetResultDTO getResult = actualRangeFacetValues.get(0);
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
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getRangeFacetValues(SearchFacet)"})
  public void testGetRangeFacetValues_thenReturnSizeIsTwo() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    InternalNumber minValue = mock(InternalNumber.class);
    when(minValue.compareTo(Mockito.<BigDecimal>any())).thenReturn(1);

    SearchFacetRangeImpl searchFacetRangeImpl = new SearchFacetRangeImpl();
    searchFacetRangeImpl.setMinValue(minValue);

    ArrayList<SearchFacetRange> searchFacetRanges = new ArrayList<>();
    searchFacetRanges.add(new SearchFacetRangeImpl());
    searchFacetRanges.add(searchFacetRangeImpl);

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
    List<SearchFacetResultDTO> actualRangeFacetValues =
        databaseSearchServiceImpl.getRangeFacetValues(facet);

    // Assert
    verify(minValue).compareTo(isNull());
    assertEquals(2, actualRangeFacetValues.size());
    SearchFacet facet2 = actualRangeFacetValues.get(0).getFacet();
    assertTrue(facet2 instanceof SearchFacetImpl);
    SearchFacetResultDTO getResult = actualRangeFacetValues.get(1);
    assertNull(getResult.getQuantity());
    assertNull(getResult.getValue());
    assertNull(getResult.getMaxValue());
    List<SearchFacetRange> searchFacetRanges2 = facet2.getSearchFacetRanges();
    assertEquals(2, searchFacetRanges2.size());
    assertFalse(getResult.isActive());
    assertSame(facet, getResult.getFacet());
    assertSame(searchFacetRangeImpl, searchFacetRanges2.get(1));
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>When {@link SearchFacetImpl} (default constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getRangeFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getRangeFacetValues(SearchFacet)"})
  public void testGetRangeFacetValues_whenSearchFacetImpl_thenReturnEmpty() {
    // Arrange
    DatabaseSearchServiceImpl databaseSearchServiceImpl = new DatabaseSearchServiceImpl();

    // Act and Assert
    assertTrue(databaseSearchServiceImpl.getRangeFacetValues(new SearchFacetImpl()).isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}.
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getMatchFacetValues(SearchFacet)"})
  public void testGetMatchFacetValues() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("productAttributes");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualMatchFacetValues =
        databaseSearchServiceImpl.getMatchFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("productAttributes"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    assertTrue(actualMatchFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code productAttributes}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getMatchFacetValues(SearchFacet)"})
  public void testGetMatchFacetValues_givenArrayListAddProductAttributes_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("productAttributes");
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(stringList);

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualMatchFacetValues =
        databaseSearchServiceImpl.getMatchFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    assertEquals(1, actualMatchFacetValues.size());
    SearchFacetResultDTO getResult = actualMatchFacetValues.get(0);
    assertEquals("productAttributes", getResult.getUnencodedValueKey());
    assertEquals("productAttributes", getResult.getValue());
    assertEquals("productAttributes", getResult.getValueKey());
    assertNull(getResult.getQuantity());
    assertNull(getResult.getMaxValue());
    assertNull(getResult.getMinValue());
    assertFalse(getResult.isActive());
    assertSame(facet, getResult.getFacet());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Given {@link FieldImpl} {@link FieldImpl#getQualifiedFieldName()} return {@code
   *       defaultSku}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getMatchFacetValues(SearchFacet)"})
  public void testGetMatchFacetValues_givenFieldImplGetQualifiedFieldNameReturnDefaultSku() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("defaultSku");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualMatchFacetValues =
        databaseSearchServiceImpl.getMatchFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("defaultSku"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    assertTrue(actualMatchFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getMatchFacetValues(SearchFacet)"})
  public void testGetMatchFacetValues_thenReturnEmpty() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenReturn(new ArrayList<>());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(fieldImpl);

    // Act
    List<SearchFacetResultDTO> actualMatchFacetValues =
        databaseSearchServiceImpl.getMatchFacetValues(facet);

    // Assert
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
    assertTrue(actualMatchFacetValues.isEmpty());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getMatchFacetValues(SearchFacet)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List DatabaseSearchServiceImpl.getMatchFacetValues(SearchFacet)"})
  public void testGetMatchFacetValues_thenThrowUnsupportedOperationException() {
    // Arrange
    when(searchFacetDao.readDistinctValuesForField(
            Mockito.<String>any(), Mockito.<Class<String>>any()))
        .thenThrow(new UnsupportedOperationException());

    FieldImpl fieldImpl = mock(FieldImpl.class);
    when(fieldImpl.getQualifiedFieldName()).thenReturn("Qualified Field Name");

    SearchFacetImpl facet = mock(SearchFacetImpl.class);
    when(facet.getField()).thenReturn(fieldImpl);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> databaseSearchServiceImpl.getMatchFacetValues(facet));
    verify(searchFacetDao).readDistinctValuesForField(eq("Qualified Field Name"), isA(Class.class));
    verify(fieldImpl).getQualifiedFieldName();
    verify(facet).getField();
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#isActive()}.
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#isActive()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DatabaseSearchServiceImpl.isActive()"})
  public void testIsActive() {
    // Arrange, Act and Assert
    assertTrue(new DatabaseSearchServiceImpl().isActive());
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCache()}.
   *
   * <ul>
   *   <li>Given {@link CacheManager} {@link CacheManager#getCache(String)} return {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DatabaseSearchServiceImpl.getCache()"})
  public void testGetCache_givenCacheManagerGetCacheReturnNull_thenReturnNull() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(null);

    // Act
    Cache<String, List<SearchFacetDTO>> actualCache = databaseSearchServiceImpl.getCache();

    // Assert
    verify(cacheManager).getCache("blStandardElements");
    assertNull(actualCache);
  }

  /**
   * Test {@link DatabaseSearchServiceImpl#getCache()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DatabaseSearchServiceImpl#getCache()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Cache DatabaseSearchServiceImpl.getCache()"})
  public void testGetCache_thenThrowUnsupportedOperationException() {
    // Arrange
    when(cacheManager.getCache(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> databaseSearchServiceImpl.getCache());
    verify(cacheManager).getCache("blStandardElements");
  }
}
