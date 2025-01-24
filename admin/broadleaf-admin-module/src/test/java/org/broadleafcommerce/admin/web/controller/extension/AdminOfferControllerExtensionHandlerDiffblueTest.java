package org.broadleafcommerce.admin.web.controller.extension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

@ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml", "/bl-admin-applicationContext.xml",
    "/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-admin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminOfferControllerExtensionHandlerDiffblueTest {
  @Autowired
  private AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler;

  /**
   * Test {@link AdminOfferControllerExtensionHandler#init()}.
   * <p>
   * Method under test: {@link AdminOfferControllerExtensionHandler#init()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass376 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new AdminOfferControllerExtensionHandler()).init();
  }

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAdditionalModelAttributes() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.admin.web.controller.extension;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-admin-applicationContext-servlet.xml","/bl-admin-applicationContext.xml","/blc-config/admin/framework/bl-admin-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-admin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass379 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.admin.web.controller.extension.AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler2 = new AdminOfferControllerExtensionHandler();

    // Act
    adminOfferControllerExtensionHandler2.setAdditionalModelAttributes(new ConcurrentModel(), "Section Key");
  }

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>Given {@link Function} {@link Function#apply(Object)} return
   * {@code Apply}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_givenFunctionApplyReturnApply_thenCallsApply() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();
    Function<String, Object> function = mock(Function.class);
    when(function.apply(Mockito.<String>any())).thenReturn("Apply");

    ConcurrentModel model = new ConcurrentModel();
    model.computeIfAbsent("offer", function);

    // Act
    ExtensionResultStatusType actualSetAdditionalModelAttributesResult = adminOfferControllerExtensionHandler
        .setAdditionalModelAttributes(model, "Section Key");

    // Assert
    verify(function).apply(eq("offer"));
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE, actualSetAdditionalModelAttributesResult);
  }

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>When {@link ConcurrentModel#ConcurrentModel()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_whenConcurrentModel() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "Section Key"));
  }

  /**
   * Test
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}.
   * <ul>
   *   <li>When {@code offer}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminOfferControllerExtensionHandler#setAdditionalModelAttributes(Model, String)}
   */
  @Test
  public void testSetAdditionalModelAttributes_whenOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminOfferControllerExtensionHandler adminOfferControllerExtensionHandler = new AdminOfferControllerExtensionHandler();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.HANDLED_CONTINUE,
        adminOfferControllerExtensionHandler.setAdditionalModelAttributes(new ConcurrentModel(), "offer"));
  }
}
