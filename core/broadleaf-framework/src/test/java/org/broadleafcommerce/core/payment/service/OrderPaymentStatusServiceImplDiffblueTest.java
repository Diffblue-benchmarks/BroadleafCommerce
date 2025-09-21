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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.type.OrderPaymentStatus;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderPaymentStatusServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPaymentStatusServiceImplDiffblueTest {
  @Autowired private OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus() {
    // Arrange
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus2() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus3() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(new PaymentTransactionType());
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus4() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(mock(PaymentTransactionType.class));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then return {@link OrderPaymentStatus#UNDETERMINED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney_thenReturnUndetermined() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.
   *   <li>Then return {@link OrderPaymentStatus#UNDETERMINED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney_thenReturnUndetermined2() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenMoneyGreaterThanReturnTrue() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    orderPayment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertSame(
        OrderPaymentStatus.UNDETERMINED,
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentStatusServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenOrderPaymentStatusServiceImpl() {
    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl =
        new OrderPaymentStatusServiceImpl();

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl2 = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl2.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(paymentTransactionImpl2.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList2 = new ArrayList<>();
    paymentTransactionList2.add(paymentTransactionImpl2);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList2);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl2).getSuccess();
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    verify(paymentTransactionImpl2).getType();
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl).getSuccess();
    assertSame(OrderPaymentStatus.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Then return {@link OrderPaymentStatus#COMPLETE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_thenReturnComplete() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.COMPLETE, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Then return {@link OrderPaymentStatus#FULLY_CAPTURED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_thenReturnFully_captured() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertSame(OrderPaymentStatus.FULLY_CAPTURED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   *
   * <ul>
   *   <li>Then return {@link OrderPaymentStatus#UNCONFIRMED}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"
  })
  public void testDetermineOrderPaymentStatus_thenReturnUnconfirmed() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("UNCONFIRMED", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPaymentImpl orderPayment = mock(OrderPaymentImpl.class);
    when(orderPayment.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPayment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(orderPayment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult =
        orderPaymentStatusServiceImpl.determineOrderPaymentStatus(orderPayment);

    // Assert
    verify(money2, atLeast(1)).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(orderPayment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(orderPayment, atLeast(1)).getTransactions();
    verify(orderPayment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertSame(OrderPaymentStatus.UNCONFIRMED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"
  })
  public void testContainsSuccessfulType_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    OrderPayment payment = mock(OrderPayment.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);

    // Act
    boolean actualContainsSuccessfulTypeResult =
        orderPaymentStatusServiceImpl.containsSuccessfulType(
            payment, new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"
  })
  public void testContainsSuccessfulType_thenReturnTrue() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPayment payment = mock(OrderPayment.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);

    // Act
    boolean actualContainsSuccessfulTypeResult =
        orderPaymentStatusServiceImpl.containsSuccessfulType(
            payment, new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}.
   *
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment,
   * PaymentTransactionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"
  })
  public void testContainsSuccessfulType_whenOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    boolean actualContainsSuccessfulTypeResult =
        orderPaymentStatusServiceImpl.containsSuccessfulType(
            payment, new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenArrayListAddPaymentTransactionImpl_thenReturnTrue() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertTrue(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoney() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyGreaterThanReturnFalse_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineComplete(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDetermineCompleteResult =
        orderPaymentStatusServiceImpl.determineComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDetermineCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoney() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenCallsAdd2() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then calls {@link Money#add(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoneyGreaterThanReturnTrue_thenCallsAdd() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoneyGreaterThanReturnTrue_thenReturnTrue() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);
    when(money.add(Mockito.<Money>any())).thenReturn(new Money());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money).add(isA(Money.class));
    verify(money, atLeast(1)).greaterThan(Mockito.<Money>any());
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertTrue(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePartiallyComplete(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"
  })
  public void testDeterminePartiallyComplete_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    Money money2 = mock(Money.class);
    when(money2.greaterThan(Mockito.<Money>any())).thenReturn(false);
    when(money2.add(Mockito.<Money>any())).thenReturn(money);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money2);

    // Act
    boolean actualDeterminePartiallyCompleteResult =
        orderPaymentStatusServiceImpl.determinePartiallyComplete(payment);

    // Assert
    verify(money2).add(isA(Money.class));
    verify(money).greaterThan(isA(Money.class));
    verify(money2, atLeast(1)).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDeterminePartiallyCompleteResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoney() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoneyGreaterThanReturnFalse_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoneyGreaterThanReturnTrue_thenReturnTrue() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertTrue(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineFullyCaptured(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineFullyCapturedResult =
        orderPaymentStatusServiceImpl.determineFullyCaptured(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualDetermineFullyCapturedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoney() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoneyGreaterThanReturnFalse_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineAuthorized(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDetermineAuthorizedResult =
        orderPaymentStatusServiceImpl.determineAuthorized(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDetermineAuthorizedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(isA(PaymentTransactionType.class));
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoney() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money());

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoneyGreaterThanReturnFalse_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.
   *   <li>Then calls {@link Money#greaterThan(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new ArrayList<>());
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(new Money(10.0d));

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   *   <li>When {@link OrderPaymentImpl} (default constructor) Order is {@link NullOrderImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenNullOrderImpl_whenOrderPaymentImplOrderIsNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePending(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_thenCallsGetSuccess() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(paymentTransactionImpl);

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(false);

    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getTransactionsForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(paymentTransactionList);
    when(payment.getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any()))
        .thenReturn(money);

    // Act
    boolean actualDeterminePendingResult = orderPaymentStatusServiceImpl.determinePending(payment);

    // Assert
    verify(money).greaterThan(isA(Money.class));
    verify(payment, atLeast(1))
        .getSuccessfulTransactionAmountForType(Mockito.<PaymentTransactionType>any());
    verify(payment, atLeast(1)).getTransactionsForType(Mockito.<PaymentTransactionType>any());
    verify(paymentTransactionImpl, atLeast(1)).getSuccess();
    assertFalse(actualDeterminePendingResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setTransactions(transactions);

    // Act
    boolean actualDetermineUnconfirmedResult =
        orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed2() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(new PaymentTransactionType());
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setTransactions(transactions);

    // Act
    boolean actualDetermineUnconfirmedResult =
        orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed3() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType()).thenReturn(mock(PaymentTransactionType.class));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setTransactions(transactions);

    // Act
    boolean actualDetermineUnconfirmedResult =
        orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed4() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getType())
        .thenReturn(new PaymentTransactionType("UNCONFIRMED", "Friendly Type"));
    when(paymentTransactionImpl.getSuccess()).thenReturn(true);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setTransactions(transactions);

    // Act
    boolean actualDetermineUnconfirmedResult =
        orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    verify(paymentTransactionImpl).getType();
    assertTrue(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentStatusServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_givenOrderPaymentStatusServiceImpl() {
    // Arrange
    OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl =
        new OrderPaymentStatusServiceImpl();

    PaymentTransactionImpl transaction = new PaymentTransactionImpl();
    transaction.setType(new PaymentTransactionType("UNCONFIRMED", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act and Assert
    assertTrue(orderPaymentStatusServiceImpl.determineUnconfirmed(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = mock(PaymentTransactionImpl.class);
    when(paymentTransactionImpl.getSuccess()).thenReturn(false);

    ArrayList<PaymentTransaction> transactions = new ArrayList<>();
    transactions.add(paymentTransactionImpl);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setTransactions(transactions);

    // Act
    boolean actualDetermineUnconfirmedResult =
        orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(paymentTransactionImpl).getSuccess();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   *
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_whenOrderPaymentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineUnconfirmed(new OrderPaymentImpl()));
  }
}
