package org.broadleafcommerce.core.search.dao;

import static org.junit.Assert.assertFalse;
import org.broadleafcommerce.core.search.domain.Field;
import org.broadleafcommerce.core.search.domain.FieldEntity;
import org.broadleafcommerce.core.search.domain.FieldImpl;
import org.broadleafcommerce.core.search.domain.SearchFacet;
import org.broadleafcommerce.core.search.domain.SearchFacetImpl;
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
public class SearchFacetDaoImplDiffblueTest {
  @Autowired
  private SearchFacetDaoImpl searchFacetDaoImpl;

  /**
   * Test {@link SearchFacetDaoImpl#readAllSearchFacets(FieldEntity)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDaoImpl#readAllSearchFacets(FieldEntity)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadAllSearchFacets() {
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
    //   public class DiffblueFakeClass5726 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchFacetDaoImpl()).readAllSearchFacets(FieldEntity.CATEGORY);
  }

  /**
   * Test {@link SearchFacetDaoImpl#readDistinctValuesForField(String, Class)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDaoImpl#readDistinctValuesForField(String, Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadDistinctValuesForField() {
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
    //   public class DiffblueFakeClass5738 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDaoImpl searchFacetDaoImpl2 = new SearchFacetDaoImpl();
    Class<Object> fieldValueClass = Object.class;

    // Act
    searchFacetDaoImpl2.readDistinctValuesForField("Field Name", fieldValueClass);
  }

  /**
   * Test {@link SearchFacetDaoImpl#save(SearchFacet)}.
   * <p>
   * Method under test: {@link SearchFacetDaoImpl#save(SearchFacet)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSave() {
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
    //   public class DiffblueFakeClass5798 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDaoImpl searchFacetDaoImpl2 = new SearchFacetDaoImpl();

    // Act
    searchFacetDaoImpl2.save(new SearchFacetImpl());
  }

  /**
   * Test {@link SearchFacetDaoImpl#readSearchFacetForField(Field)}.
   * <p>
   * Method under test: {@link SearchFacetDaoImpl#readSearchFacetForField(Field)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadSearchFacetForField() {
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
    //   public class DiffblueFakeClass5768 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDaoImpl searchFacetDaoImpl2 = new SearchFacetDaoImpl();

    // Act
    searchFacetDaoImpl2.readSearchFacetForField(new FieldImpl());
  }

  /**
   * Test
   * {@link SearchFacetDaoImpl#readSearchFacetRangesForSearchFacet(SearchFacet)}.
   * <p>
   * Method under test:
   * {@link SearchFacetDaoImpl#readSearchFacetRangesForSearchFacet(SearchFacet)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testReadSearchFacetRangesForSearchFacet() {
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
    //   public class DiffblueFakeClass5781 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchFacetDaoImpl searchFacetDaoImpl2 = new SearchFacetDaoImpl();

    // Act
    searchFacetDaoImpl2.readSearchFacetRangesForSearchFacet(new SearchFacetImpl());
  }

  /**
   * Test {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}.
   * <p>
   * Method under test: {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}
   */
  @Test
  public void testIsSearchFacetRangeArchivable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new SearchFacetDaoImpl()).isSearchFacetRangeArchivable());
  }

  /**
   * Test {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}.
   * <p>
   * Method under test: {@link SearchFacetDaoImpl#isSearchFacetRangeArchivable()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsSearchFacetRangeArchivable2() {
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
    //   public class DiffblueFakeClass5725 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchFacetDaoImpl searchFacetDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchFacetDaoImpl()).isSearchFacetRangeArchivable();
  }
}
