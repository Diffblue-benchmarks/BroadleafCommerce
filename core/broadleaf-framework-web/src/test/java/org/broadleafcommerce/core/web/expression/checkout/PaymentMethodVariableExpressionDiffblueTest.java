package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentType;
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
class PaymentMethodVariableExpressionDiffblueTest {
  @Autowired
  private PaymentMethodVariableExpression paymentMethodVariableExpression;

  /**
   * Test {@link PaymentMethodVariableExpression#getName()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paymentMethod", (new PaymentMethodVariableExpression()).getName());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}
   */
  @Test
  @DisplayName("Test getPaymentRequestDTO()")
  void testGetPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new PaymentMethodVariableExpression()).getPaymentRequestDTO());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}
   */
  @Test
  @DisplayName("Test getPaymentRequestDTO()")
  @Disabled("TODO: Complete this test")
  void testGetPaymentRequestDTO2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3571 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getPaymentRequestDTO();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
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
    //   public class DiffblueFakeClass3572 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression2 = new PaymentMethodVariableExpression();

    // Act
    paymentMethodVariableExpression2.isNullOrder(new NullOrderImpl());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl (default constructor); then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression = new PaymentMethodVariableExpression();

    // Act and Assert
    assertTrue(paymentMethodVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl; then return 'true'")
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentMethodVariableExpression()).isNullOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when 'null'; then return 'true'")
  void testIsNullOrder_whenNull_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentMethodVariableExpression()).isNullOrder(null));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when OrderImpl (default constructor); then return 'false'")
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression = new PaymentMethodVariableExpression();

    // Act and Assert
    assertFalse(paymentMethodVariableExpression.isNullOrder(new OrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartContainsThirdPartyPayment()")
  @Disabled("TODO: Complete this test")
  void testCartContainsThirdPartyPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3524 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).cartContainsThirdPartyPayment();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartContainsCreditCardPayment()")
  @Disabled("TODO: Complete this test")
  void testCartContainsCreditCardPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3522 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).cartContainsCreditCardPayment();
  }

  /**
   * Test
   * {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartContainsTemporaryCreditCard()")
  @Disabled("TODO: Complete this test")
  void testCartContainsTemporaryCreditCard() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3523 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).cartContainsTemporaryCreditCard();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order)")
  @Disabled("TODO: Complete this test")
  void testOrderContainsCODPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3584 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression2 = new PaymentMethodVariableExpression();

    // Act
    paymentMethodVariableExpression2.orderContainsCODPayment(new NullOrderImpl());
  }

  /**
   * Test
   * {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order)")
  @Disabled("TODO: Complete this test")
  void testOrderContainsCreditCardPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3596 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression2 = new PaymentMethodVariableExpression();

    // Act
    paymentMethodVariableExpression2.orderContainsCreditCardPayment(new NullOrderImpl());
  }

  /**
   * Test
   * {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order)")
  @Disabled("TODO: Complete this test")
  void testOrderContainsThirdPartyPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3629 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression2 = new PaymentMethodVariableExpression();

    // Act
    paymentMethodVariableExpression2.orderContainsThirdPartyPayment(new NullOrderImpl());
  }

  /**
   * Test
   * {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType)")
  @Disabled("TODO: Complete this test")
  void testOrderContainsPaymentOfType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3608 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression2 = new PaymentMethodVariableExpression();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    paymentMethodVariableExpression2.orderContainsPaymentOfType(order, new PaymentType("Type", "Friendly Type"));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}
   */
  @Test
  @DisplayName("Test getExpirationMonthOptions()")
  void testGetExpirationMonthOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    List<String> actualExpirationMonthOptions = (new PaymentMethodVariableExpression()).getExpirationMonthOptions();

    // Assert
    assertEquals(12, actualExpirationMonthOptions.size());
    assertEquals("01 - January", actualExpirationMonthOptions.get(0));
    assertEquals("02 - February", actualExpirationMonthOptions.get(1));
    assertEquals("03 - March", actualExpirationMonthOptions.get(2));
    assertEquals("04 - April", actualExpirationMonthOptions.get(3));
    assertEquals("05 - May", actualExpirationMonthOptions.get(4));
    assertEquals("06 - June", actualExpirationMonthOptions.get(5));
    assertEquals("07 - July", actualExpirationMonthOptions.get(6));
    assertEquals("08 - August", actualExpirationMonthOptions.get(7));
    assertEquals("09 - September", actualExpirationMonthOptions.get(8));
    assertEquals("10 - October", actualExpirationMonthOptions.get(9));
    assertEquals("11 - November", actualExpirationMonthOptions.get(10));
    assertEquals("12 - December", actualExpirationMonthOptions.get(11));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}
   */
  @Test
  @DisplayName("Test getExpirationMonthOptions()")
  @Disabled("TODO: Complete this test")
  void testGetExpirationMonthOptions2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3568 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getExpirationMonthOptions();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationYearOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationYearOptions()}
   */
  @Test
  @DisplayName("Test getExpirationYearOptions()")
  void testGetExpirationYearOptions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10, (new PaymentMethodVariableExpression()).getExpirationYearOptions().size());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationYearOptions()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getExpirationYearOptions()}
   */
  @Test
  @DisplayName("Test getExpirationYearOptions()")
  @Disabled("TODO: Complete this test")
  void testGetExpirationYearOptions2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3569 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getExpirationYearOptions();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart()")
  @Disabled("TODO: Complete this test")
  void testGetCreditCardTypeFromCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3567 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getCreditCardTypeFromCart();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart()")
  @Disabled("TODO: Complete this test")
  void testGetCreditCardLastFourFromCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3566 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getCreditCardLastFourFromCart();
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart()")
  @Disabled("TODO: Complete this test")
  void testGetCreditCardExpDateFromCart() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3565 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getCreditCardExpDateFromCart();
  }

  /**
   * Test
   * {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String)")
  @Disabled("TODO: Complete this test")
  void testGetCartOrderPaymentProperty() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3525 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getCartOrderPaymentProperty("Property Name");
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentProcessingError()}.
   * <p>
   * Method under test:
   * {@link PaymentMethodVariableExpression#getPaymentProcessingError()}
   */
  @Test
  @DisplayName("Test getPaymentProcessingError()")
  @Disabled("TODO: Complete this test")
  void testGetPaymentProcessingError() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.expression.checkout;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3570 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.expression.checkout.PaymentMethodVariableExpression paymentMethodVariableExpression;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PaymentMethodVariableExpression()).getPaymentProcessingError();
  }
}
