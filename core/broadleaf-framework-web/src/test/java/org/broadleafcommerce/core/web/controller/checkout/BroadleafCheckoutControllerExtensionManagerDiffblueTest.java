package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class BroadleafCheckoutControllerExtensionManagerDiffblueTest {
  @Autowired
  private BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;

  /**
   * Test {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager = new BroadleafCheckoutControllerExtensionManager();
    broadleafCheckoutControllerExtensionManager
        .registerHandler(mock(BroadleafCheckoutControllerExtensionHandler.class));

    // Act and Assert
    assertTrue(broadleafCheckoutControllerExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  @Disabled("TODO: Complete this test")
  void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.controller.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass907 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.controller.checkout.BroadleafCheckoutControllerExtensionManager broadleafCheckoutControllerExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new BroadleafCheckoutControllerExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link BroadleafCheckoutControllerExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafCheckoutControllerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled(); given BroadleafCheckoutControllerExtensionManager (default constructor)")
  void testContinueOnHandled_givenBroadleafCheckoutControllerExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new BroadleafCheckoutControllerExtensionManager()).continueOnHandled());
  }
}
