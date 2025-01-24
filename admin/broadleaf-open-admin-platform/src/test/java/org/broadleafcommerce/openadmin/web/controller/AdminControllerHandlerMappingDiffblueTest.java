package org.broadleafcommerce.openadmin.web.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.openadmin.web.controller.entity.AdminBasicEntityController;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StringValueResolver;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerHandlerMappingDiffblueTest {
  @Autowired
  private AdminControllerHandlerMapping adminControllerHandlerMapping;

  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    adminControllerHandlerMapping.setEmbeddedValueResolver(mock(StringValueResolver.class));
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   * <p>
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsHandler2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.controller;
    //   @org.springframework.test.context.web.WebAppConfiguration
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass8098 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.controller.AdminControllerHandlerMapping adminControllerHandlerMapping;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping2 = new AdminControllerHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act
    adminControllerHandlerMapping2.isHandler(beanType);
  }

  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    Class<AdminBasicEntityController> beanType = AdminBasicEntityController.class;

    // Act and Assert
    assertTrue(adminControllerHandlerMapping.isHandler(beanType));
  }

  /**
   * Test {@link AdminControllerHandlerMapping#isHandler(Class)}.
   * <ul>
   *   <li>When {@code java.lang.Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminControllerHandlerMapping#isHandler(Class)}
   */
  @Test
  public void testIsHandler_whenJavaLangObject_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminControllerHandlerMapping adminControllerHandlerMapping = new AdminControllerHandlerMapping();
    Class<Object> beanType = Object.class;

    // Act and Assert
    assertFalse(adminControllerHandlerMapping.isHandler(beanType));
  }
}
