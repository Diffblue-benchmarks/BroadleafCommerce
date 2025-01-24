package org.broadleafcommerce.core.search.dao;

import org.broadleafcommerce.core.search.domain.SearchSynonym;
import org.broadleafcommerce.core.search.domain.SearchSynonymImpl;
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
public class SearchSynonymDaoImplDiffblueTest {
  @Autowired
  private SearchSynonymDaoImpl searchSynonymDaoImpl;

  /**
   * Test {@link SearchSynonymDaoImpl#getAllSynonyms()}.
   * <p>
   * Method under test: {@link SearchSynonymDaoImpl#getAllSynonyms()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetAllSynonyms() {
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
    //   public class DiffblueFakeClass5868 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchSynonymDaoImpl searchSynonymDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchSynonymDaoImpl()).getAllSynonyms();
  }

  /**
   * Test {@link SearchSynonymDaoImpl#createSynonym(SearchSynonym)}.
   * <p>
   * Method under test: {@link SearchSynonymDaoImpl#createSynonym(SearchSynonym)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateSynonym() {
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
    //   public class DiffblueFakeClass5852 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchSynonymDaoImpl searchSynonymDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchSynonymDaoImpl searchSynonymDaoImpl2 = new SearchSynonymDaoImpl();

    // Act
    searchSynonymDaoImpl2.createSynonym(new SearchSynonymImpl());
  }

  /**
   * Test {@link SearchSynonymDaoImpl#deleteSynonym(SearchSynonym)}.
   * <p>
   * Method under test: {@link SearchSynonymDaoImpl#deleteSynonym(SearchSynonym)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteSynonym() {
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
    //   public class DiffblueFakeClass5860 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchSynonymDaoImpl searchSynonymDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchSynonymDaoImpl searchSynonymDaoImpl2 = new SearchSynonymDaoImpl();

    // Act
    searchSynonymDaoImpl2.deleteSynonym(new SearchSynonymImpl());
  }

  /**
   * Test {@link SearchSynonymDaoImpl#updateSynonym(SearchSynonym)}.
   * <p>
   * Method under test: {@link SearchSynonymDaoImpl#updateSynonym(SearchSynonym)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateSynonym() {
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
    //   public class DiffblueFakeClass5869 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.dao.SearchSynonymDaoImpl searchSynonymDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    SearchSynonymDaoImpl searchSynonymDaoImpl2 = new SearchSynonymDaoImpl();

    // Act
    searchSynonymDaoImpl2.updateSynonym(new SearchSynonymImpl());
  }
}
