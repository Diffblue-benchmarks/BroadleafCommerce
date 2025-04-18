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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderPaymentStatusServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderPaymentStatusServiceImplDiffblueTest {
  @Autowired
  private OrderPaymentStatusServiceImpl orderPaymentStatusServiceImpl;

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenMoney() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenMoneyAddReturnMoney2() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenMoneyGreaterThanReturnFalse() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl orderPayment = new OrderPaymentImpl();
    orderPayment.setOrder(new NullOrderImpl());

    // Act
    OrderPaymentStatus actualDetermineOrderPaymentStatusResult = orderPaymentStatusServiceImpl
        .determineOrderPaymentStatus(orderPayment);

    // Assert
    assertSame(actualDetermineOrderPaymentStatusResult.UNDETERMINED, actualDetermineOrderPaymentStatusResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_thenCallsGetSuccess() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}.
   * <ul>
   *   <li>Then return {@link OrderPaymentStatus#COMPLETE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineOrderPaymentStatus(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatusServiceImpl.determineOrderPaymentStatus(OrderPayment)"})
  public void testDetermineOrderPaymentStatus_thenReturnComplete() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"})
  public void testContainsSuccessfulType() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("42", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getType();
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"})
  public void testContainsSuccessfulType_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"})
  public void testContainsSuccessfulType_thenReturnTrue() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(true);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type"));

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertTrue(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"})
  public void testContainsSuccessfulType_whenNull() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualContainsSuccessfulTypeResult = orderPaymentStatusServiceImpl.containsSuccessfulType(payment, null);

    // Assert
    verify(transaction).getType();
    assertFalse(actualContainsSuccessfulTypeResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}.
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#containsSuccessfulType(OrderPayment, PaymentTransactionType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentStatusServiceImpl.containsSuccessfulType(OrderPayment, PaymentTransactionType)"})
  public void testContainsSuccessfulType_whenOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.containsSuccessfulType(payment,
        new PaymentTransactionType("Type", "Friendly Type")));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenArrayListAddPaymentTransactionImpl_thenReturnTrue() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoney() {
    // Arrange
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
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyAddReturnMoney_thenCallsAdd() {
    // Arrange
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
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineComplete(OrderPayment)"})
  public void testDetermineComplete_thenCallsGetSuccess() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenMoney() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money#Money()}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenReturnTrue() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#add(Money)} return {@link Money}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenMoneyAddReturnMoney_thenReturnTrue2() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code false}.</li>
   *   <li>Then calls {@link Money#add(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenMoneyGreaterThanReturnFalse_thenCallsAdd() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_givenNullOrderImpl() {
    // Arrange
    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determinePartiallyComplete(payment));
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_thenCallsGetSuccess() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePartiallyComplete(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePartiallyComplete(OrderPayment)"})
  public void testDeterminePartiallyComplete_thenCallsGetSuccess2() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_givenMoney_thenReturnFalse() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineFullyCaptured(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineFullyCaptured(OrderPayment)"})
  public void testDetermineFullyCaptured_thenCallsGetSuccess() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoney() {
    // Arrange
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
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_givenMoneyWithAmountIsTen() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineAuthorized(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineAuthorized(OrderPayment)"})
  public void testDetermineAuthorized_thenCallsGetSuccess() {
    // Arrange
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoney() {
    // Arrange
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
   *   <li>Given {@link Money} {@link Money#greaterThan(Money)} return {@code true}.</li>
   *   <li>Then calls {@link Money#greaterThan(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoneyGreaterThanReturnTrue_thenCallsGreaterThan() {
    // Arrange
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
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_givenMoneyWithAmountIsTen() {
    // Arrange
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
   *   <li>When {@link OrderPaymentImpl} (default constructor) Order is {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
   * <ul>
   *   <li>Then calls {@link PaymentTransactionImpl#getSuccess()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determinePending(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determinePending(OrderPayment)"})
  public void testDeterminePending_thenCallsGetSuccess() {
    // Arrange
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
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(transaction.getSuccess()).thenReturn(true);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed2() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(mock(PaymentTransactionType.class));
    when(transaction.getSuccess()).thenReturn(true);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Given {@link PaymentTransactionImpl} {@link PaymentTransactionImpl#getSuccess()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_givenPaymentTransactionImplGetSuccessReturnFalse() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getSuccess()).thenReturn(false);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(transaction).getSuccess();
    assertFalse(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_thenReturnTrue() {
    // Arrange
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getType()).thenReturn(new PaymentTransactionType("UNCONFIRMED", "Friendly Type"));
    when(transaction.getSuccess()).thenReturn(true);

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.addTransaction(transaction);

    // Act
    boolean actualDetermineUnconfirmedResult = orderPaymentStatusServiceImpl.determineUnconfirmed(payment);

    // Assert
    verify(transaction).getSuccess();
    verify(transaction).getType();
    assertTrue(actualDetermineUnconfirmedResult);
  }

  /**
   * Test {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}.
   * <ul>
   *   <li>When {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentStatusServiceImpl#determineUnconfirmed(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentStatusServiceImpl.determineUnconfirmed(OrderPayment)"})
  public void testDetermineUnconfirmed_whenOrderPaymentImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderPaymentStatusServiceImpl.determineUnconfirmed(new OrderPaymentImpl()));
  }
}
