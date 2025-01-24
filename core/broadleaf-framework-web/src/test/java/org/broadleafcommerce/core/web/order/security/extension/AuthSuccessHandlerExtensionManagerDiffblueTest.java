package org.broadleafcommerce.core.web.order.security.extension;

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
class AuthSuccessHandlerExtensionManagerDiffblueTest {
  @Autowired
  private AuthSuccessHandlerExtensionManager authSuccessHandlerExtensionManager;

  /**
   * Test {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled()")
  void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AuthSuccessHandlerExtensionManager authSuccessHandlerExtensionManager = new AuthSuccessHandlerExtensionManager();
    authSuccessHandlerExtensionManager.registerHandler(mock(AbstractAuthSuccessHandlerExtensionHandler.class));

    // Act and Assert
    assertTrue(authSuccessHandlerExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test:
   * {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}
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
    //   package org.broadleafcommerce.core.web.order.security.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9296 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.order.security.extension.AuthSuccessHandlerExtensionManager authSuccessHandlerExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AuthSuccessHandlerExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link AuthSuccessHandlerExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuthSuccessHandlerExtensionManager#continueOnHandled()}
   */
  @Test
  @DisplayName("Test continueOnHandled(); given AuthSuccessHandlerExtensionManager (default constructor)")
  void testContinueOnHandled_givenAuthSuccessHandlerExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new AuthSuccessHandlerExtensionManager()).continueOnHandled());
  }
}
