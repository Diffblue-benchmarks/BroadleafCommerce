package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.type.OrderPaymentStatus;
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
public class OrderPaymentStatusServiceImplDiffblueTest {
  @Autowired
  private OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineOrderPaymentStatus() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2268 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determineOrderPaymentStatus(new OrderPaymentImpl());
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenArrayListAddPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money2).greaterThan(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenMoneyGreaterThanReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    orderPayment.setOrder(new NullOrderImpl());

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    assertSame(actualDetermineOrderPaymentStatusResult.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money2).greaterThan(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertSame(actualDetermineOrderPaymentStatusResult.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Then return {@link OrderPaymentStatus#COMPLETE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus_thenReturnComplete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(actualDetermineOrderPaymentStatusResult.COMPLETE, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContainsSuccessfulType() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2197 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    orderPaymentStatusServiceImpl2.containsSuccessfulType(payment, new PaymentTransactionType("Type", "Friendly Type"));
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType_givenArrayList_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType_whenOrderPaymentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type")));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineComplete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2236 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determineComplete(new OrderPaymentImpl());
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenArrayListAddPaymentTransactionImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertTrue(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenMoneyAddReturnMoney_thenCallsAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineComplete(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    boolean actualDetermineCompleteResult = orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeterminePartiallyComplete() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2284 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determinePartiallyComplete(new OrderPaymentImpl());
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenArrayListAddPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return
   * {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(Mockito.<Money>any());
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertTrue(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenReturnTrue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(Mockito.<Money>any());
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertTrue(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code false}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenMoneyGreaterThanReturnFalse_thenCallsAdd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePartiallyComplete(payment));
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(Mockito.<Money>any());
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertTrue(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete_thenCallsGetSuccess2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult = orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineFullyCaptured() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2252 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determineFullyCaptured(new OrderPaymentImpl());
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_givenArrayListAddPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDetermineFullyCapturedResult = orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDetermineFullyCapturedResult = orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineFullyCapturedResult = orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_givenMoney_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDetermineFullyCapturedResult = orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineFullyCapturedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineFullyCaptured(payment));
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDetermineFullyCapturedResult = orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    verify(paymentTransactionImpl).getSuccess();
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineAuthorized() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2220 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determineAuthorized(new OrderPaymentImpl());
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_givenArrayListAddPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDetermineAuthorizedResult = orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDetermineAuthorizedResult = orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDetermineAuthorizedResult = orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineAuthorizedResult = orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_givenNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineAuthorized(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDetermineAuthorizedResult = orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeterminePending() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determinePending(new OrderPaymentImpl());
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_givenArrayListAddPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_givenMoney() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(new Money());

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return
   * {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_givenMoneyWithAmountIsTen() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   *   <li>When {@link OrderPaymentImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_givenNullOrderImpl_whenOrderPaymentImplOrderIsNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePending(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending_thenCallsGetSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any())).thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any())).thenReturn(money);

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1)).getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactions();
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(mock(PaymentTransactionType.class));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactions();
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineUnconfirmed3() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2316 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl2 = new OrderPaymentStatusServiceImpl();

    // Act
    orderPaymentStatusServiceImpl2.determineUnconfirmed(new OrderPaymentImpl());
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl}
   * (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed_givenArrayListAddPaymentTransactionImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactions();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed_givenArrayList_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(new ArrayList<>());

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment).getTransactions();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl}
   * {@link PaymentTransactionImpl#getSuccess()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactions();
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(new PaymentTransactionType("UNCONFIRMED", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactions()).thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactions();
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertTrue(actualDetermineUnconfirmedResult);
  }

  /**
   * Test
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed_whenOrderPaymentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineUnconfirmed(new OrderPaymentImpl()));
  }
}
