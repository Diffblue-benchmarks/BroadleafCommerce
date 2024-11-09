/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.checkout.service.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.core.checkout.service.exception.CheckoutException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class OrderPaymentConfirmationStrategyImplDiffblueTest {
  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>When {@link PaymentTransactionImpl} (default constructor).</li>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  public void testConfirmTransaction_whenPaymentTransactionImpl_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmTransaction(tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  public void testConfirmPendingTransaction_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)}.
   * <ul>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)}
   */
  @Test
  public void testConfirmTransactionInternal_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class, () -> orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(tx,
        new DefaultProcessContextImpl<>(), true));
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  public void testOrderContainsMultipleFinalPayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult = orderPaymentConfirmationStrategyImpl
        .orderContainsMultipleFinalPayments(order);

    // Assert
    verify(order).getPayments();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentImpl).isFinalPayment();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  public void testOrderContainsMultipleFinalPayments2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(false);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult = orderPaymentConfirmationStrategyImpl
        .orderContainsMultipleFinalPayments(order);

    // Assert
    verify(order).getPayments();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentImpl).isFinalPayment();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link NullOrderImpl#getPayments()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  public void testOrderContainsMultipleFinalPayments_givenArrayList_thenCallsGetPayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult = orderPaymentConfirmationStrategyImpl
        .orderContainsMultipleFinalPayments(order);

    // Assert
    verify(order).getPayments();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  public void testOrderContainsMultipleFinalPayments_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertFalse(orderPaymentConfirmationStrategyImpl.orderContainsMultipleFinalPayments(order));
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#orderContainsMultipleFinalPayments(Order)}
   */
  @Test
  public void testOrderContainsMultipleFinalPayments_givenOrderPaymentImplIsActiveReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getPayments()).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsMultipleFinalPaymentsResult = orderPaymentConfirmationStrategyImpl
        .orderContainsMultipleFinalPayments(order);

    // Assert
    verify(order).getPayments();
    verify(orderPaymentImpl).isActive();
    assertFalse(actualOrderContainsMultipleFinalPaymentsResult);
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link PaymentTransactionImpl#getAdditionalFields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}
   */
  @Test
  public void testTransactionIsDetachedCreditRequest_givenHashMap_thenCallsGetAdditionalFields() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl transaction = mock(PaymentTransactionImpl.class);
    when(transaction.getAdditionalFields()).thenReturn(new HashMap<>());

    // Act
    boolean actualTransactionIsDetachedCreditRequestResult = orderPaymentConfirmationStrategyImpl
        .transactionIsDetachedCreditRequest(transaction);

    // Assert
    verify(transaction).getAdditionalFields();
    assertFalse(actualTransactionIsDetachedCreditRequestResult);
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}.
   * <ul>
   *   <li>When {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}
   */
  @Test
  public void testTransactionIsDetachedCreditRequest_whenPaymentTransactionImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();

    // Act and Assert
    assertFalse(orderPaymentConfirmationStrategyImpl.transactionIsDetachedCreditRequest(new PaymentTransactionImpl()));
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return ResponseMap Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  public void testConstructPendingTransaction_givenHashMap_thenReturnResponseMapEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    PaymentRequestDTO confirmationRequest = mock(PaymentRequestDTO.class);
    when(confirmationRequest.getAdditionalFields()).thenReturn(new HashMap<>());
    when(confirmationRequest.getTransactionTotal()).thenReturn("42");

    // Act
    PaymentResponseDTO actualConstructPendingTransactionResult = orderPaymentConfirmationStrategyImpl
        .constructPendingTransaction(paymentType, gatewayType, confirmationRequest);

    // Assert
    verify(confirmationRequest).getAdditionalFields();
    verify(confirmationRequest).getTransactionTotal();
    Money amount = actualConstructPendingTransactionResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentTransactionType paymentTransactionType = actualConstructPendingTransactionResult.getPaymentTransactionType();
    assertEquals("PENDING", paymentTransactionType.getType());
    assertEquals("Pending Authorize or Authorize and Capture", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConstructPendingTransactionResult.getRawResponse());
    assertNull(actualConstructPendingTransactionResult.getOrderId());
    assertNull(actualConstructPendingTransactionResult.getPaymentToken());
    assertNull(actualConstructPendingTransactionResult.getBillTo());
    assertNull(actualConstructPendingTransactionResult.getShipTo());
    assertNull(actualConstructPendingTransactionResult.getCreditCard());
    assertNull(actualConstructPendingTransactionResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getResponseMap().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Test
   * {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then return ResponseMap size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  public void testConstructPendingTransaction_thenReturnResponseMapSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    HashMap<String, Object> stringObjectMap = new HashMap<>();
    stringObjectMap.put("ThreadLocalManager.notify.orphans", "42");
    PaymentRequestDTO confirmationRequest = mock(PaymentRequestDTO.class);
    when(confirmationRequest.getAdditionalFields()).thenReturn(stringObjectMap);
    when(confirmationRequest.getTransactionTotal()).thenReturn("42");

    // Act
    PaymentResponseDTO actualConstructPendingTransactionResult = orderPaymentConfirmationStrategyImpl
        .constructPendingTransaction(paymentType, gatewayType, confirmationRequest);

    // Assert
    verify(confirmationRequest, atLeast(1)).getAdditionalFields();
    verify(confirmationRequest).getTransactionTotal();
    Map<String, String> responseMap = actualConstructPendingTransactionResult.getResponseMap();
    assertEquals(1, responseMap.size());
    assertEquals("42", responseMap.get("ThreadLocalManager.notify.orphans"));
    Money amount = actualConstructPendingTransactionResult.getAmount();
    Currency currency = amount.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    PaymentTransactionType paymentTransactionType = actualConstructPendingTransactionResult.getPaymentTransactionType();
    assertEquals("PENDING", paymentTransactionType.getType());
    assertEquals("Pending Authorize or Authorize and Capture", paymentTransactionType.getFriendlyType());
    assertEquals("£", currency.getSymbol());
    assertEquals(
        "org.broadleafcommerce.core.checkout.service.strategy.OrderPaymentConfirmationStrategyImpl: converting"
            + " UNCONFIRMED transaction into a PENDING payment",
        actualConstructPendingTransactionResult.getRawResponse());
    assertNull(actualConstructPendingTransactionResult.getOrderId());
    assertNull(actualConstructPendingTransactionResult.getPaymentToken());
    assertNull(actualConstructPendingTransactionResult.getBillTo());
    assertNull(actualConstructPendingTransactionResult.getShipTo());
    assertNull(actualConstructPendingTransactionResult.getCreditCard());
    assertNull(actualConstructPendingTransactionResult.getCustomer());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = amount.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("42.00");
    assertEquals(expectedAmount2, amount.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(amount, amount.abs());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
    assertSame(currency, zeroResult.getCurrency());
  }
}
