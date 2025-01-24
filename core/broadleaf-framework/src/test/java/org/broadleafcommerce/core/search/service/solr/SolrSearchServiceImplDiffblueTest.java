package org.broadleafcommerce.core.search.service.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.catalog.dao.ProductDao;
import org.broadleafcommerce.core.catalog.dao.SkuDao;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.search.dao.FieldDao;
import org.broadleafcommerce.core.search.dao.IndexFieldDao;
import org.broadleafcommerce.core.search.dao.SearchFacetDao;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.domain.IndexFieldImpl;
import org.broadleafcommerce.core.search.domain.SearchCriteria;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetRange;
import org.broadleafcommerce.core.search.domain.SearchFacetRangeImpl;
import org.broadleafcommerce.core.search.domain.SearchFacetResultDTO;
import org.broadleafcommerce.core.search.domain.SearchResult;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {SolrSearchServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SolrSearchServiceImplDiffblueTest {
  @MockBean
  private FieldDao fieldDao;

  @MockBean
  private IndexFieldDao indexFieldDao;

  @MockBean
  private ProductDao productDao;

  @MockBean
  private SearchFacetDao searchFacetDao;

  @MockBean
  private SkuDao skuDao;

  @MockBean(name = "blCatalogSolrConfiguration")
  private SolrConfiguration solrConfiguration;

  @MockBean
  private SolrHelperService solrHelperService;

  @MockBean(name = "blSolrSearchServiceExtensionManager")
  private SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;

  @Autowired
  private SolrSearchServiceImpl solrSearchServiceImpl;

  /**
   * Test
   * {@link SolrSearchServiceImpl#findExplicitSearchResultsByCategory(Category, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findExplicitSearchResultsByCategory(Category, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindExplicitSearchResultsByCategory() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1157 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    solrSearchServiceImpl.findExplicitSearchResultsByCategory(category, new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResultsByCategory(Category, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsByCategory() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1161 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    solrSearchServiceImpl.findSearchResultsByCategory(category, new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResultsByQuery(String, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsByQuery() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1163 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.findSearchResultsByQuery("Query", new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResultsByCategoryAndQuery(Category, String, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsByCategoryAndQuery() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1162 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CategoryImpl category = new CategoryImpl();

    // Act
    solrSearchServiceImpl.findSearchResultsByCategoryAndQuery(category, "Query", new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#findSearchResults(String, List, SearchCriteria, String)}
   * with {@code qualifiedSolrQuery}, {@code facets}, {@code searchCriteria},
   * {@code defaultSort}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResults(String, List, SearchCriteria, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsWithQualifiedSolrQueryFacetsSearchCriteriaDefaultSort() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1158 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.findSearchResults("Qualified Solr Query", facets, new SearchCriteria(), "Default Sort");
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#findSearchResults(String, List, SearchCriteria, String, String[])}
   * with {@code qualifiedSolrQuery}, {@code facets}, {@code searchCriteria},
   * {@code defaultSort}, {@code filterQueries}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResults(String, List, SearchCriteria, String, String[])}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsWithQualifiedSolrQueryFacetsSearchCriteriaDefaultSortFilterQueries()
      throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1159 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.findSearchResults("Qualified Solr Query", facets, new SearchCriteria(), "Default Sort",
        "Filter Queries");
  }

  /**
   * Test {@link SolrSearchServiceImpl#findSearchResults(SearchCriteria)} with
   * {@code searchCriteria}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#findSearchResults(SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchResultsWithSearchCriteria() throws ServiceException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1160 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.findSearchResults(new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#filterProductsBasedOnInactiveCategory(List, Category)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#filterProductsBasedOnInactiveCategory(List, Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterProductsBasedOnInactiveCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1156 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ArrayList<Product> products = new ArrayList<>();

    // Act
    solrSearchServiceImpl.filterProductsBasedOnInactiveCategory(products, new CategoryImpl());
  }

  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFilterEmptyFacets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1155 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.filterEmptyFacets(new ArrayList<>());
  }

  /**
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets_givenSearchFacetResultDTOQuantityIsNull() {
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
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Given {@link SearchFacetResultDTO} (default constructor) Quantity is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets_givenSearchFacetResultDTOQuantityIsZero() {
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
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets_thenArrayListSizeIsOne() {
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
   * Test {@link SolrSearchServiceImpl#filterEmptyFacets(List)}.
   * <ul>
   *   <li>Then calls {@link SearchFacetDTO#getFacetValues()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#filterEmptyFacets(List)}
   */
  @Test
  public void testFilterEmptyFacets_thenCallsGetFacetValues() {
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
    SearchFacetDTO searchFacetDTO = mock(SearchFacetDTO.class);
    when(searchFacetDTO.getFacetValues()).thenReturn(new ArrayList<>());
    doNothing().when(searchFacetDTO).setAbbreviation(Mockito.<String>any());
    doNothing().when(searchFacetDTO).setActive(anyBoolean());
    doNothing().when(searchFacetDTO).setFacet(Mockito.<SearchFacet>any());
    doNothing().when(searchFacetDTO).setFacetValues(Mockito.<List<SearchFacetResultDTO>>any());
    doNothing().when(searchFacetDTO).setShowQuantity(anyBoolean());
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
    verify(searchFacetDTO).getFacetValues();
    verify(searchFacetDTO).setAbbreviation(eq("Abbreviation"));
    verify(searchFacetDTO).setActive(eq(true));
    verify(searchFacetDTO).setFacet(isA(SearchFacet.class));
    verify(searchFacetDTO).setFacetValues(isA(List.class));
    verify(searchFacetDTO).setShowQuantity(eq(true));
    assertTrue(facets.isEmpty());
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
  public void testFilterEmptyFacets_whenArrayList_thenArrayListEmpty() {
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
   * Test {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDefaultSort() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1166 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getDefaultSort(new SearchCriteria());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}.
   * <ul>
   *   <li>When {@link SearchCriteria} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getDefaultSort(SearchCriteria)}
   */
  @Test
  public void testGetDefaultSort_whenSearchCriteria_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();

    // Act and Assert
    assertNull(solrSearchServiceImpl.getDefaultSort(new SearchCriteria()));
  }

  /**
   * Test {@link SolrSearchServiceImpl#getCategoryFilter(SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getCategoryFilter(SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryFilter() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1165 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getCategoryFilter(new SearchCriteria());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getLocalePrefix()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getLocalePrefix()}
   */
  @Test
  public void testGetLocalePrefix() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals("", (new SolrSearchServiceImpl()).getLocalePrefix());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getLocalePrefix()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getLocalePrefix()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetLocalePrefix2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1167 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getLocalePrefix();
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#buildQueryFieldsString(SolrQuery, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#buildQueryFieldsString(SolrQuery, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildQueryFieldsString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1151 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");

    // Act
    solrSearchServiceImpl.buildQueryFieldsString(query, new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQueryFields() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1170 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");
    ArrayList<String> queryFields = new ArrayList<>();
    IndexFieldImpl indexField = new IndexFieldImpl();

    // Act
    solrSearchServiceImpl.getQueryFields(query, queryFields, indexField, new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link IndexFieldImpl#getFieldTypes()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getQueryFields(SolrQuery, List, IndexField, SearchCriteria)}
   */
  @Test
  public void testGetQueryFields_givenArrayList_thenCallsGetFieldTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

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
   * Test
   * {@link SolrSearchServiceImpl#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#modifySolrQuery(SolrQuery, String, List, SearchCriteria, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testModifySolrQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1179 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.modifySolrQuery(query, "Qualified Solr Query", facets, new SearchCriteria(), "Default Sort");
  }

  /**
   * Test {@link SolrSearchServiceImpl#createSearchContextDTO()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#createSearchContextDTO()}
   */
  @Test
  public void testCreateSearchContextDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new SolrSearchServiceImpl()).createSearchContextDTO().getAttributes().isEmpty());
  }

  /**
   * Test {@link SolrSearchServiceImpl#createSearchContextDTO()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#createSearchContextDTO()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateSearchContextDTO2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1153 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.createSearchContextDTO();
  }

  /**
   * Test {@link SolrSearchServiceImpl#getResponseDocuments(QueryResponse)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getResponseDocuments(QueryResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetResponseDocuments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1171 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getResponseDocuments(new QueryResponse());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getSearchFacets()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getSearchFacets()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSearchFacets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1172 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getSearchFacets();
  }

  /**
   * Test {@link SolrSearchServiceImpl#getSearchFacets(Category)} with
   * {@code Category}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getSearchFacets(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSearchFacetsWithCategory() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1173 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getSearchFacets(new CategoryImpl());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getCategoryFacets(Category)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getCategoryFacets(Category)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCategoryFacets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1164 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getCategoryFacets(new CategoryImpl());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#attachSortClause(SolrQuery, SearchCriteria, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachSortClause() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1150 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");

    // Act
    solrSearchServiceImpl.attachSortClause(query, new SearchCriteria(), "Default Sort");
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#attachActiveFacetFilters(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachActiveFacetFilters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1148 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrSearchServiceImpl.attachActiveFacetFilters(query, namedFacetMap, new SearchCriteria());
  }

  /**
   * Test {@link SolrSearchServiceImpl#scrubFacetValue(String)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#scrubFacetValue(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testScrubFacetValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1181 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.scrubFacetValue("42");
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#attachFacets(SolrQuery, Map, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAttachFacets() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1149 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrQuery query = new SolrQuery("foo");
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrSearchServiceImpl.attachFacets(query, namedFacetMap, new SearchCriteria());
  }

  /**
   * Test {@link SolrSearchServiceImpl#setFacetResults(Map, QueryResponse)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#setFacetResults(Map, QueryResponse)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetFacetResults() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1182 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    HashMap<String, SearchFacetDTO> namedFacetMap = new HashMap<>();

    // Act
    solrSearchServiceImpl.setFacetResults(namedFacetMap, new QueryResponse());
  }

  /**
   * Test {@link SolrSearchServiceImpl#sortFacetResults(Map)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#sortFacetResults(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSortFacetResults() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1184 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.sortFacetResults(new HashMap<>());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetPagingAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1183 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchResult result = new SearchResult();
    result.setFacets(new ArrayList<>());
    result.setPage(1);
    result.setPageSize(3);
    result.setProducts(new ArrayList<>());
    result.setQueryResponse(new QueryResponse());
    result.setTotalResults(1);

    // Act
    solrSearchServiceImpl.setPagingAttributes(result, 10, new SearchCriteria());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}.
   * <ul>
   *   <li>Then {@link SearchResult} (default constructor) PageSize is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}
   */
  @Test
  public void testSetPagingAttributes_thenSearchResultPageSizeIsNull() {
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
   * Test
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}.
   * <ul>
   *   <li>When {@link SearchResult} {@link SearchResult#setFacets(List)} does
   * nothing.</li>
   *   <li>Then calls {@link SearchResult#setFacets(List)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#setPagingAttributes(SearchResult, int, SearchCriteria)}
   */
  @Test
  public void testSetPagingAttributes_whenSearchResultSetFacetsDoesNothing_thenCallsSetFacets() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SolrSearchServiceImpl solrSearchServiceImpl = new SolrSearchServiceImpl();
    SearchResult result = mock(SearchResult.class);
    doNothing().when(result).setFacets(Mockito.<List<SearchFacetDTO>>any());
    doNothing().when(result).setPage(Mockito.<Integer>any());
    doNothing().when(result).setPageSize(Mockito.<Integer>any());
    doNothing().when(result).setProducts(Mockito.<List<Product>>any());
    doNothing().when(result).setQueryResponse(Mockito.<QueryResponse>any());
    doNothing().when(result).setTotalResults(Mockito.<Integer>any());
    result.setFacets(new ArrayList<>());
    result.setPage(1);
    result.setPageSize(3);
    result.setProducts(new ArrayList<>());
    result.setQueryResponse(new QueryResponse());
    result.setTotalResults(1);

    // Act
    solrSearchServiceImpl.setPagingAttributes(result, 10, new SearchCriteria());

    // Assert
    verify(result).setFacets(isA(List.class));
    verify(result, atLeast(1)).setPage(eq(1));
    verify(result, atLeast(1)).setPageSize(Mockito.<Integer>any());
    verify(result).setProducts(isA(List.class));
    verify(result).setQueryResponse(isA(QueryResponse.class));
    verify(result, atLeast(1)).setTotalResults(Mockito.<Integer>any());
  }

  /**
   * Test {@link SolrSearchServiceImpl#getProducts(List)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#getProducts(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetProducts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1169 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getProducts(new ArrayList<>());
  }

  /**
   * Test {@link SolrSearchServiceImpl#buildSearchFacetDTOs(List)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#buildSearchFacetDTOs(List)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildSearchFacetDTOs() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1152 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.buildSearchFacetDTOs(new ArrayList<>());
  }

  /**
   * Test {@link SolrSearchServiceImpl#facetIsAvailable(SearchFacet, Map)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#facetIsAvailable(SearchFacet, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFacetIsAvailable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1154 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetImpl facet = new SearchFacetImpl();

    // Act
    solrSearchServiceImpl.facetIsAvailable(facet, new HashMap<>());
  }

  /**
   * Test {@link SolrSearchServiceImpl#sanitizeQuery(String)}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#sanitizeQuery(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSanitizeQuery() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1180 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.sanitizeQuery("Query");
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getSolrTaggedFieldString(String, String, SearchFacetRange)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSolrTaggedFieldString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1177 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getSolrTaggedFieldString("Index Field", "Tag", new SearchFacetRangeImpl());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getSolrFieldTag(String, String, SearchFacetRange)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSolrFieldTag() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1174 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.getSolrFieldTag("Tag Field", "Tag", new SearchFacetRangeImpl());
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getSolrRangeString(String, BigDecimal, BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSolrRangeString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1176 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BigDecimal minValue = new BigDecimal("2.3");

    // Act
    solrSearchServiceImpl.getSolrRangeString("Field Name", minValue, new BigDecimal("2.3"));
  }

  /**
   * Test
   * {@link SolrSearchServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getSolrRangeFunctionString(BigDecimal, BigDecimal)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSolrRangeFunctionString() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1175 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    BigDecimal minValue = new BigDecimal("2.3");

    // Act
    solrSearchServiceImpl.getSolrRangeFunctionString(minValue, new BigDecimal("2.3"));
  }

  /**
   * Test {@link SolrSearchServiceImpl#getNamedFacetMap(List, SearchCriteria)}.
   * <p>
   * Method under test:
   * {@link SolrSearchServiceImpl#getNamedFacetMap(List, SearchCriteria)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetNamedFacetMap() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1168 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ArrayList<SearchFacetDTO> facets = new ArrayList<>();

    // Act
    solrSearchServiceImpl.getNamedFacetMap(facets, new SearchCriteria());
  }

  /**
   * Test {@link SolrSearchServiceImpl#isActive()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SolrSearchServiceImpl()).isActive());
  }

  /**
   * Test {@link SolrSearchServiceImpl#isActive()}.
   * <p>
   * Method under test: {@link SolrSearchServiceImpl#isActive()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsActive2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.service.solr;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1178 {
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.FieldDao fieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.IndexFieldDao indexFieldDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.ProductDao productDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.dao.SearchFacetDao searchFacetDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.catalog.dao.SkuDao skuDao;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blCatalogSolrConfiguration") org.broadleafcommerce.core.search.service.solr.SolrConfiguration solrConfiguration;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.core.search.service.solr.SolrHelperService solrHelperService;
    //     @org.springframework.boot.test.mock.mockito.MockBean(name = "blSolrSearchServiceExtensionManager") org.broadleafcommerce.core.search.service.solr.SolrSearchServiceExtensionManager solrSearchServiceExtensionManager;
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.service.solr.SolrSearchServiceImpl solrSearchServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    solrSearchServiceImpl.isActive();
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
  public void testGettersAndSetters() {
    // Arrange and Act
    SolrSearchServiceImpl actualSolrSearchServiceImpl = new SolrSearchServiceImpl();
    SolrRequest.METHOD actualSolrQueryMethod = actualSolrSearchServiceImpl.getSolrQueryMethod();

    // Assert
    assertNull(actualSolrQueryMethod);
    assertFalse(actualSolrSearchServiceImpl.shouldShowDebugQuery());
  }
}
