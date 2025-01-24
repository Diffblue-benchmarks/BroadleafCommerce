package org.broadleafcommerce.openadmin.web.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.openadmin.web.service.extension.TranslationsFormBuilderExtensionHandler;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class FormBuilderExtensionManagerDiffblueTest {
  @Autowired
  private FormBuilderExtensionManager formBuilderExtensionManager;

  /**
   * Test {@link FormBuilderExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link FormBuilderExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FormBuilderExtensionManager formBuilderExtensionManager = new FormBuilderExtensionManager();
    formBuilderExtensionManager.registerHandler(mock(TranslationsFormBuilderExtensionHandler.class));

    // Act and Assert
    assertTrue(formBuilderExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link FormBuilderExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link FormBuilderExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass6006 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.service.FormBuilderExtensionManager formBuilderExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FormBuilderExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link FormBuilderExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link FormBuilderExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link FormBuilderExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenFormBuilderExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FormBuilderExtensionManager()).continueOnHandled());
  }
}
