package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class CheckoutFormVariableExpressionDiffblueTest {
  @Autowired
  private CheckoutFormVariableExpression checkoutFormVariableExpression;

  /**
   * Test {@link CheckoutFormVariableExpression#getName()}.
   * <p>
   * Method under test: {@link CheckoutFormVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("checkoutForm", (new CheckoutFormVariableExpression()).getName());
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}.
   * <p>
   * Method under test:
   * {@link CheckoutFormVariableExpression#shouldShowShippingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowShippingInfoStage()")
  @Disabled("TODO: Complete this test")
  void testShouldShowShippingInfoStage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3490 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.CheckoutFormVariableExpression checkoutFormVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CheckoutFormVariableExpression()).shouldShowShippingInfoStage();
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}.
   * <p>
   * Method under test:
   * {@link CheckoutFormVariableExpression#shouldShowBillingInfoStage()}
   */
  @Test
  @DisplayName("Test shouldShowBillingInfoStage()")
  @Disabled("TODO: Complete this test")
  void testShouldShowBillingInfoStage() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3489 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.CheckoutFormVariableExpression checkoutFormVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CheckoutFormVariableExpression()).shouldShowBillingInfoStage();
  }

  /**
   * Test {@link CheckoutFormVariableExpression#shouldShowAllPaymentMethods()}.
   * <p>
   * Method under test:
   * {@link CheckoutFormVariableExpression#shouldShowAllPaymentMethods()}
   */
  @Test
  @DisplayName("Test shouldShowAllPaymentMethods()")
  @Disabled("TODO: Complete this test")
  void testShouldShowAllPaymentMethods() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3488 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.CheckoutFormVariableExpression checkoutFormVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new CheckoutFormVariableExpression()).shouldShowAllPaymentMethods();
  }
}
