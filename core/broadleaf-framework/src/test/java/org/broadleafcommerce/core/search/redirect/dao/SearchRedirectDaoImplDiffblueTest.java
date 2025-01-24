package org.broadleafcommerce.core.search.redirect.dao;

import static org.junit.Assert.assertEquals;
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
public class SearchRedirectDaoImplDiffblueTest {
  @Autowired
  private SearchRedirectDaoImpl searchRedirectDaoImpl;

  /**
   * Test
   * {@link SearchRedirectDaoImpl#getCurrentDateAfterFactoringInDateResolution()}.
   * <p>
   * Method under test:
   * {@link SearchRedirectDaoImpl#getCurrentDateAfterFactoringInDateResolution()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrentDateAfterFactoringInDateResolution() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.redirect.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1867 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.redirect.dao.SearchRedirectDaoImpl searchRedirectDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchRedirectDaoImpl()).getCurrentDateAfterFactoringInDateResolution();
  }

  /**
   * Test {@link SearchRedirectDaoImpl#findSearchRedirectBySearchTerm(String)}.
   * <p>
   * Method under test:
   * {@link SearchRedirectDaoImpl#findSearchRedirectBySearchTerm(String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFindSearchRedirectBySearchTerm() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.search.redirect.dao;
    //   @org.springframework.transaction.annotation.Transactional
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1837 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.search.redirect.dao.SearchRedirectDaoImpl searchRedirectDaoImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new SearchRedirectDaoImpl()).findSearchRedirectBySearchTerm("Search Term");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SearchRedirectDaoImpl#setCurrentDateResolution(Long)}
   *   <li>{@link SearchRedirectDaoImpl#getCurrentDateResolution()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SearchRedirectDaoImpl searchRedirectDaoImpl = new SearchRedirectDaoImpl();

    // Act
    searchRedirectDaoImpl.setCurrentDateResolution(1L);

    // Assert that nothing has changed
    assertEquals(1L, searchRedirectDaoImpl.getCurrentDateResolution().longValue());
  }
}
