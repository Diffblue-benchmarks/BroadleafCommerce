/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
import org.junit.Test;
import org.mockito.Mockito;

public class OrderPaymentStatusServiceImplDiffblueTest {
  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus7() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  public void testDetermineOrderPaymentStatus8() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type")));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  public void testContainsSuccessfulType4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineComplete(payment));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  public void testDetermineComplete7() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePartiallyComplete(payment));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete7() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete8() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  public void testDeterminePartiallyComplete9() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineFullyCaptured(payment));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  public void testDetermineFullyCaptured6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineAuthorized(payment));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  public void testDetermineAuthorized6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePending(payment));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  public void testDeterminePending6() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl = new OrderPaymentStatusServiceImpl();

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineUnconfirmed(new OrderPaymentImpl()));
  }

  /**
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed2() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed3() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed4() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed5() {
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
   * Method under test:
   * {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  public void testDetermineUnconfirmed6() {
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
}
