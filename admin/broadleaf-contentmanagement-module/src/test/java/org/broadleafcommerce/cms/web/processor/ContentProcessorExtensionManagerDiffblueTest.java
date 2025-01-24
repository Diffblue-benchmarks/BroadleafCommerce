package org.broadleafcommerce.cms.web.processor;

import static org.junit.Assert.assertTrue;
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
public class ContentProcessorExtensionManagerDiffblueTest {
  @Autowired
  private ContentProcessorExtensionManager contentProcessorExtensionManager;

  /**
   * Test {@link ContentProcessorExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link ContentProcessorExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ContentProcessorExtensionManager contentProcessorExtensionManager = new ContentProcessorExtensionManager();
    contentProcessorExtensionManager.registerHandler(mock(ContentProcessorExtensionHandler.class));

    // Act and Assert
    assertTrue(contentProcessorExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link ContentProcessorExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link ContentProcessorExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.cms.web.processor;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-cms-contentClient.xml","/applicationContext-servlet-cms-contentCreator.xml","/bl-cms-applicationContext-entity.xml","/bl-cms-contentClient-applicationContext.xml","/bl-cms-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-cms-admin-applicationContext.xml","/blc-config/site/framework/bl-cms-applicationContext-servlet.xml","/blc-config/site/framework/bl-cms-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3401 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.cms.web.processor.ContentProcessorExtensionManager contentProcessorExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ContentProcessorExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link ContentProcessorExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link ContentProcessorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ContentProcessorExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenContentProcessorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ContentProcessorExtensionManager()).continueOnHandled());
  }
}
