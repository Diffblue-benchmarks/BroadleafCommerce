package org.broadleafcommerce.core.util.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ResourcePurgeExtensionManagerDiffblueTest {
  @Autowired
  private ResourcePurgeExtensionManager resourcePurgeExtensionManager;

  /**
   * Test {@link ResourcePurgeExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link ResourcePurgeExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ResourcePurgeExtensionManager resourcePurgeExtensionManager = new ResourcePurgeExtensionManager();
    resourcePurgeExtensionManager.registerHandler(mock(AbstractResourcePurgeExtensionHandler.class));

    // Act and Assert
    assertTrue(resourcePurgeExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link ResourcePurgeExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link ResourcePurgeExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.util.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass0 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.util.service.ResourcePurgeExtensionManager resourcePurgeExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new ResourcePurgeExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link ResourcePurgeExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link ResourcePurgeExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ResourcePurgeExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenResourcePurgeExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new ResourcePurgeExtensionManager()).continueOnHandled());
  }
}
