package org.broadleafcommerce.cms.page.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml",
    "/applicationContext-servlet-cms-contentCreator.xml", "/bl-cms-applicationContext-entity.xml",
    "/bl-cms-contentClient-applicationContext.xml", "/bl-cms-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-cms-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-cms-applicationContext-servlet.xml",
    "/blc-config/site/framework/bl-cms-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PageServiceExtensionManagerDiffblueTest {
  @Autowired
  private PageServiceExtensionManager pageServiceExtensionManager;

  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageServiceExtensionManager pageServiceExtensionManager = new PageServiceExtensionManager();
    pageServiceExtensionManager.registerHandler(mock(PageServiceExtensionHandler.class));

    // Act and Assert
    assertFalse(pageServiceExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.page.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass562 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.page.service.PageServiceExtensionManager pageServiceExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PageServiceExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link PageServiceExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link PageServiceExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PageServiceExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenPageServiceExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PageServiceExtensionManager()).continueOnHandled());
  }
}
