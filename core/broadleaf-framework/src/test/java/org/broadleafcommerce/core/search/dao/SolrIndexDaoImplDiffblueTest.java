package org.broadleafcommerce.core.search.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SolrIndexDaoImplDiffblueTest {
  @Autowired
  private SolrIndexDaoImpl solrIndexDaoImpl;

  /**
   * Test
   * {@link SolrIndexDaoImpl#populateProductCatalogStructure(List, CatalogStructure)}.
   * <p>
   * Method under test:
   * {@link SolrIndexDaoImpl#populateProductCatalogStructure(List, CatalogStructure)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateProductCatalogStructure() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5877 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SolrIndexDaoImpl solrIndexDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexDaoImpl solrIndexDaoImpl2 = new SolrIndexDaoImpl();
    ArrayList<Long> productIds = new ArrayList<>();

    CatalogStructure catalogStructure = new CatalogStructure();
    catalogStructure.setDisplayOrdersByCategoryProduct(new HashMap<>());
    catalogStructure.setParentCategoriesByCategory(new HashMap<>());
    catalogStructure.setParentCategoriesByProduct(new HashMap<>());

    // Act
    solrIndexDaoImpl2.populateProductCatalogStructure(productIds, catalogStructure);
  }

  /**
   * Test {@link SolrIndexDaoImpl#readFullCategoryHierarchy(Map, Set)}.
   * <p>
   * Method under test:
   * {@link SolrIndexDaoImpl#readFullCategoryHierarchy(Map, Set)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadFullCategoryHierarchy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass5905 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SolrIndexDaoImpl solrIndexDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SolrIndexDaoImpl solrIndexDaoImpl2 = new SolrIndexDaoImpl();
    HashMap<Long, Set<Long>> categoryHierarchy = new HashMap<>();

    // Act
    solrIndexDaoImpl2.readFullCategoryHierarchy(categoryHierarchy, new HashSet<>());
  }
}
