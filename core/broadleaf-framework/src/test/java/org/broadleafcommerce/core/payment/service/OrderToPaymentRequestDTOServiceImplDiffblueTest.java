package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl.NameResponse;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderToPaymentRequestDTOServiceImplDiffblueTest {
  @Autowired
  private OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and
   * {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#hashCode()}
   * </ul>
   */
  @Test
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and
   * {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#hashCode()}
   * </ul>
   */
  @Test
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = mock(
        OrderToPaymentRequestDTOServiceImpl.class).new NameResponse();
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and
   * {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#hashCode()}
   * </ul>
   */
  @Test
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setFirstName("Jane");

    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and
   * {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#hashCode()}
   * </ul>
   */
  @Test
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setLastName("Doe");

    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and
   * {@link NameResponse#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#hashCode()}
   * </ul>
   */
  @Test
  public void testNameResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), 1);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();

    OrderToPaymentRequestDTOServiceImpl.NameResponse nameResponse2 = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), null);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#equals(Object)}
   */
  @Test
  public void testNameResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals((new OrderToPaymentRequestDTOServiceImpl()).new NameResponse(), "Different type to NameResponse");
  }

  /**
   * Test NameResponse getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#NameResponse(OrderToPaymentRequestDTOServiceImpl)}
   *   <li>
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#setFirstName(String)}
   *   <li>
   * {@link OrderToPaymentRequestDTOServiceImpl.NameResponse#setLastName(String)}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#toString()}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#getFirstName()}
   *   <li>{@link OrderToPaymentRequestDTOServiceImpl.NameResponse#getLastName()}
   * </ul>
   */
  @Test
  public void testNameResponseGettersAndSetters() {
    // Arrange and Act
    OrderToPaymentRequestDTOServiceImpl.NameResponse actualNameResponse = (new OrderToPaymentRequestDTOServiceImpl()).new NameResponse();
    actualNameResponse.setFirstName("Jane");
    actualNameResponse.setLastName("Doe");
    String actualToStringResult = actualNameResponse.toString();
    String actualFirstName = actualNameResponse.getFirstName();

    // Assert that nothing has changed
    assertEquals("Doe", actualNameResponse.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("OrderToPaymentRequestDTOServiceImpl.NameResponse(firstName=Jane, lastName=Doe)",
        actualToStringResult);
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslateOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2572 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.translateOrder(new NullOrderImpl());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  public void testTranslateOrder_whenNullOrderImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();

    // Act and Assert
    assertNull(orderToPaymentRequestDTOServiceImpl.translateOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  public void testTranslateOrder_whenNullOrderImpl_thenReturnNull2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderToPaymentRequestDTOServiceImpl()).translateOrder(mock(NullOrderImpl.class)));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  public void testTranslateOrder_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderToPaymentRequestDTOServiceImpl()).translateOrder(null));
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   * with {@code transactionAmount}, {@code paymentTransaction}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransaction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2585 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    Money transactionAmount = new Money();

    // Act
    orderToPaymentRequestDTOServiceImpl2.translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   * with {@code transactionAmount}, {@code paymentTransaction},
   * {@code autoCalculateFinalPaymentTotals}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#translatePaymentTransaction(Money, PaymentTransaction, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testTranslatePaymentTransactionWithTransactionAmountPaymentTransactionAutoCalculateFinalPaymentTotals() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2609 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    Money transactionAmount = new Money();

    // Act
    orderToPaymentRequestDTOServiceImpl2.translatePaymentTransaction(transactionAmount, new PaymentTransactionImpl(),
        true);
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRefreshTransaction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2554 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.refreshTransaction(new PaymentTransactionImpl());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateTotals() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2528 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateTotals(order, new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_givenPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO}
   * {@link PaymentRequestDTO#shippingTotal(String)} return
   * {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_givenPaymentRequestDTOShippingTotalReturnPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.shippingTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).shippingTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link PaymentRequestDTO}
   * {@link PaymentRequestDTO#taxTotal(String)} return {@link PaymentRequestDTO}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_givenPaymentRequestDTOTaxTotalReturnPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.taxTotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO paymentRequestDTO2 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO2.shippingTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO2);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO2).shippingTotal(eq("0.00"));
    verify(paymentRequestDTO).taxTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderCurrencyCode(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_thenCallsOrderCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.orderCurrencyCode(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());
    PaymentRequestDTO paymentRequestDTO2 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO2.taxTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);
    PaymentRequestDTO paymentRequestDTO3 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO3.shippingTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO2);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO3);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).orderCurrencyCode(isNull());
    verify(paymentRequestDTO3).shippingTotal(eq("0.00"));
    verify(paymentRequestDTO2).taxTotal(eq("0.00"));
    verify(requestDTO).transactionTotal(eq("0.00"));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl}
   * {@link NullOrderImpl#getTotalAfterAppliedPayments()} return
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_whenNullOrderImplGetTotalAfterAppliedPaymentsReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(mock(Money.class));
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTaxTotal());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalShipping()}
   * return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_whenNullOrderImplGetTotalShippingReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(mock(Money.class));
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalTax()} return
   * {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_whenNullOrderImplGetTotalTaxReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(mock(Money.class));
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).</li>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) ShippingTotal is
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateTotals_whenPaymentRequestDTO_thenPaymentRequestDTOShippingTotalIs000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order, PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order, PaymentRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateCustomerInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2450 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateCustomerInfo(order, new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateShipTo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2502 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateShipTo(order, new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getFulfillmentGroups()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateShipTo_givenArrayList_thenCallsGetFulfillmentGroups() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateShipTo(order, new PaymentRequestDTO());

    // Assert
    verify(order).getFulfillmentGroups();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateBillTo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2424 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateBillTo(order, new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return
   * {@code false}.</li>
   *   <li>Then calls {@link OrderPaymentImpl#isActive()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateBillTo_givenOrderPaymentImplIsActiveReturnFalse_thenCallsIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(orderPaymentList);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateBillTo(order, new PaymentRequestDTO());

    // Assert
    verify(order).getPayments();
    verify(orderPaymentImpl).isActive();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getPayments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateBillTo(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateBillTo_thenCallsGetPayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(new ArrayList<>());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateBillTo(order, new PaymentRequestDTO());

    // Assert
    verify(order).getPayments();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateAddressInfo() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2369 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    AddressDTO<PaymentRequestDTO> dto = new AddressDTO<>();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateAddressInfo(dto, new AddressImpl());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#getName(Address)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#getName(Address)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetName() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2332 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.getName(new AddressImpl());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateDefaultLineItemsAndSubtotal() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2476 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl2 = new OrderToPaymentRequestDTOServiceImpl();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl2.populateDefaultLineItemsAndSubtotal(order, new PaymentRequestDTO());
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateDefaultLineItemsAndSubtotal_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(mock(Money.class));

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, new PaymentRequestDTO());

    // Assert
    verify(order, atLeast(1)).getSubTotal();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderSubtotal(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateDefaultLineItemsAndSubtotal_thenCallsOrderSubtotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.orderSubtotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, requestDTO);

    // Assert
    verify(requestDTO).orderSubtotal(eq("0.00"));
    verify(order, atLeast(1)).getSubTotal();
  }

  /**
   * Test
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) OrderSubtotal is
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)}
   */
  @Test
  public void testPopulateDefaultLineItemsAndSubtotal_thenPaymentRequestDTOOrderSubtotalIs000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl = new OrderToPaymentRequestDTOServiceImpl();
    Order order = mock(Order.class);
    when(order.getSubTotal()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, requestDTO);

    // Assert
    verify(order, atLeast(1)).getSubTotal();
    assertEquals("0.00", requestDTO.getOrderSubtotal());
  }
}
