package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
class FulfillmentVariableExpressionDiffblueTest {
  @Autowired
  private FulfillmentVariableExpression fulfillmentVariableExpression;

  /**
   * Test {@link FulfillmentVariableExpression#getName()}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("fulfillment", (new FulfillmentVariableExpression()).getName());
  }

  /**
   * Test
   * {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getNumShippableFulfillmentGroups()}
   */
  @Test
  @DisplayName("Test getNumShippableFulfillmentGroups()")
  @Disabled("TODO: Complete this test")
  void testGetNumShippableFulfillmentGroups() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3509 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.FulfillmentVariableExpression fulfillmentVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentVariableExpression()).getNumShippableFulfillmentGroups();
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentOptions()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getFulfillmentOptions()}
   */
  @Test
  @DisplayName("Test getFulfillmentOptions()")
  @Disabled("TODO: Complete this test")
  void testGetFulfillmentOptions() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3507 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.FulfillmentVariableExpression fulfillmentVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentVariableExpression()).getFulfillmentOptions();
  }

  /**
   * Test {@link FulfillmentVariableExpression#getMultiShipOptions()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  @DisplayName("Test getMultiShipOptions()")
  void testGetMultiShipOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).getMultiShipOptions().isEmpty());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getMultiShipOptions()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getMultiShipOptions()}
   */
  @Test
  @DisplayName("Test getMultiShipOptions()")
  @Disabled("TODO: Complete this test")
  void testGetMultiShipOptions2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3508 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.FulfillmentVariableExpression fulfillmentVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentVariableExpression()).getMultiShipOptions();
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  @DisplayName("Test getFulfillmentEstimateResponse()")
  void testGetFulfillmentEstimateResponse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new FulfillmentVariableExpression()).getFulfillmentEstimateResponse());
  }

  /**
   * Test {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}.
   * <p>
   * Method under test:
   * {@link FulfillmentVariableExpression#getFulfillmentEstimateResponse()}
   */
  @Test
  @DisplayName("Test getFulfillmentEstimateResponse()")
  @Disabled("TODO: Complete this test")
  void testGetFulfillmentEstimateResponse2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3506 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.FulfillmentVariableExpression fulfillmentVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new FulfillmentVariableExpression()).getFulfillmentEstimateResponse();
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order)")
  @Disabled("TODO: Complete this test")
  void testIsNullOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3510 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.FulfillmentVariableExpression fulfillmentVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression2 = new FulfillmentVariableExpression();

    // Act
    fulfillmentVariableExpression2.isNullOrder(new NullOrderImpl());
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl (default constructor); then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertTrue(fulfillmentVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl; then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when 'null'; then return 'true'")
  void testIsNullOrder_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new FulfillmentVariableExpression()).isNullOrder(null));
  }

  /**
   * Test {@link FulfillmentVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FulfillmentVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when OrderImpl (default constructor); then return 'false'")
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentVariableExpression fulfillmentVariableExpression = new FulfillmentVariableExpression();

    // Act and Assert
    assertFalse(fulfillmentVariableExpression.isNullOrder(new OrderImpl()));
  }
}
