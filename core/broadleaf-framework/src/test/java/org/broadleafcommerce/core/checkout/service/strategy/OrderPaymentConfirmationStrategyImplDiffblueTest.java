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
package org.broadleafcommerce.core.checkout.service.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.config.service.SystemPropertiesService;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationService;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfigurationServiceProvider;
import org.broadleafcommerce.common.payment.service.PaymentGatewayTransactionConfirmationService;
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
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.payment.service.SecureOrderPaymentService;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderPaymentConfirmationStrategyImplDiffblueTest {
  @InjectMocks
  private OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl;

  @Mock
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @Mock
  private PaymentGatewayConfigurationServiceProvider paymentGatewayConfigurationServiceProvider;

  @Mock
  private SecureOrderPaymentService secureOrderPaymentService;

  @Mock
  private SystemPropertiesService systemPropertiesService;

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmTransaction_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmTransaction(tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmPendingTransaction() throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(Mockito.<Money>any(),
        Mockito.<PaymentTransaction>any(), anyBoolean())).thenReturn(new PaymentRequestDTO());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentGatewayTransactionConfirmationService paymentGatewayTransactionConfirmationService = mock(
        PaymentGatewayTransactionConfirmationService.class);
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    when(paymentGatewayTransactionConfirmationService.confirmTransaction(Mockito.<PaymentRequestDTO>any()))
        .thenReturn(paymentResponseDTO);
    PaymentGatewayConfigurationService paymentGatewayConfigurationService = mock(
        PaymentGatewayConfigurationService.class);
    when(paymentGatewayConfigurationService.getTransactionConfirmationService())
        .thenReturn(paymentGatewayTransactionConfirmationService);
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(Mockito.<PaymentGatewayType>any()))
        .thenReturn(paymentGatewayConfigurationService);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmPendingTransactionResult = orderPaymentConfirmationStrategyImpl
        .confirmPendingTransaction(tx, new DefaultProcessContextImpl<>());

    // Assert
    verify(paymentGatewayConfigurationService).getTransactionConfirmationService();
    verify(paymentGatewayConfigurationServiceProvider).getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(paymentGatewayTransactionConfirmationService).confirmTransaction(isA(PaymentRequestDTO.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService).populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class),
        eq(true));
    assertSame(paymentResponseDTO, actualConfirmPendingTransactionResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#translatePaymentTransaction(Money, PaymentTransaction)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmPendingTransaction_thenCallsTranslatePaymentTransaction()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    doNothing().when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(Mockito.<Money>any(),
        Mockito.<PaymentTransaction>any())).thenReturn(new PaymentRequestDTO());
    PaymentGatewayTransactionConfirmationService paymentGatewayTransactionConfirmationService = mock(
        PaymentGatewayTransactionConfirmationService.class);
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO paymentResponseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    when(paymentGatewayTransactionConfirmationService.confirmTransaction(Mockito.<PaymentRequestDTO>any()))
        .thenReturn(paymentResponseDTO);
    PaymentGatewayConfigurationService paymentGatewayConfigurationService = mock(
        PaymentGatewayConfigurationService.class);
    when(paymentGatewayConfigurationService.getTransactionConfirmationService())
        .thenReturn(paymentGatewayTransactionConfirmationService);
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(Mockito.<PaymentGatewayType>any()))
        .thenReturn(paymentGatewayConfigurationService);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(false);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act
    PaymentResponseDTO actualConfirmPendingTransactionResult = orderPaymentConfirmationStrategyImpl
        .confirmPendingTransaction(tx, new DefaultProcessContextImpl<>());

    // Assert
    verify(paymentGatewayConfigurationService).getTransactionConfirmationService();
    verify(paymentGatewayConfigurationServiceProvider).getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(paymentGatewayTransactionConfirmationService).confirmTransaction(isA(PaymentRequestDTO.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService).populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).translatePaymentTransaction(isA(Money.class),
        isA(PaymentTransaction.class));
    assertSame(paymentResponseDTO, actualConfirmPendingTransactionResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmPendingTransaction_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(tx, new DefaultProcessContextImpl<>()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link PaymentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmPendingTransaction_thenThrowPaymentException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(Mockito.<Money>any(),
        Mockito.<PaymentTransaction>any(), anyBoolean())).thenReturn(new PaymentRequestDTO());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentGatewayTransactionConfirmationService paymentGatewayTransactionConfirmationService = mock(
        PaymentGatewayTransactionConfirmationService.class);
    when(paymentGatewayTransactionConfirmationService.confirmTransaction(Mockito.<PaymentRequestDTO>any()))
        .thenThrow(new PaymentException("An error occurred"));
    PaymentGatewayConfigurationService paymentGatewayConfigurationService = mock(
        PaymentGatewayConfigurationService.class);
    when(paymentGatewayConfigurationService.getTransactionConfirmationService())
        .thenReturn(paymentGatewayTransactionConfirmationService);
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(Mockito.<PaymentGatewayType>any()))
        .thenReturn(paymentGatewayConfigurationService);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(PaymentException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(tx, new DefaultProcessContextImpl<>()));
    verify(paymentGatewayConfigurationService).getTransactionConfirmationService();
    verify(paymentGatewayConfigurationServiceProvider).getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(paymentGatewayTransactionConfirmationService).confirmTransaction(isA(PaymentRequestDTO.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService).populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class),
        eq(true));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmPendingTransaction(PaymentTransaction, ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmPendingTransaction(PaymentTransaction, ProcessContext)"})
  public void testConfirmPendingTransaction_thenThrowWorkflowException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    when(orderToPaymentRequestDTOService.translatePaymentTransaction(Mockito.<Money>any(),
        Mockito.<PaymentTransaction>any(), anyBoolean())).thenReturn(new PaymentRequestDTO());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    doNothing().when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    when(paymentGatewayConfigurationServiceProvider.getGatewayConfigurationService(Mockito.<PaymentGatewayType>any()))
        .thenReturn(mock(PaymentGatewayConfigurationService.class));
    when(secureOrderPaymentService.findSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any()))
        .thenThrow(new WorkflowException("An error occurred"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(14L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(14L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getReferenceNumber()).thenReturn("42");
    when(orderPaymentImpl.isFinalPayment()).thenReturn(true);
    when(orderPaymentImpl.getAmount()).thenReturn(new Money());
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type", true, true));
    when(orderPaymentImpl.getOrder()).thenReturn(orderImpl);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    PaymentTransactionImpl tx = mock(PaymentTransactionImpl.class);
    when(tx.getOrderPayment()).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(WorkflowException.class,
        () -> orderPaymentConfirmationStrategyImpl.confirmPendingTransaction(tx, new DefaultProcessContextImpl<>()));
    verify(paymentGatewayConfigurationServiceProvider).getGatewayConfigurationService(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).getAmount();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl, atLeast(1)).getOrder();
    verify(orderPaymentImpl, atLeast(1)).getReferenceNumber();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isFinalPayment();
    verify(tx, atLeast(1)).getOrderPayment();
    verify(orderToPaymentRequestDTOService).populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
    verify(orderToPaymentRequestDTOService).translatePaymentTransaction(isA(Money.class), isA(PaymentTransaction.class),
        eq(true));
    verify(secureOrderPaymentService).findSecurePaymentInfo(eq("42"), isA(PaymentType.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)}.
   * <ul>
   *   <li>Then throw {@link CheckoutException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.confirmTransactionInternal(PaymentTransaction, ProcessContext, boolean)"})
  public void testConfirmTransactionInternal_thenThrowCheckoutException()
      throws PaymentException, CheckoutException, WorkflowException {
    // Arrange
    OrderPaymentConfirmationStrategyImpl orderPaymentConfirmationStrategyImpl = new OrderPaymentConfirmationStrategyImpl();
    PaymentTransactionImpl tx = new PaymentTransactionImpl();

    // Act and Assert
    assertThrows(CheckoutException.class, () -> orderPaymentConfirmationStrategyImpl.confirmTransactionInternal(tx,
        new DefaultProcessContextImpl<>(), true));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#transactionIsDetachedCreditRequest(PaymentTransaction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean OrderPaymentConfirmationStrategyImpl.transactionIsDetachedCreditRequest(PaymentTransaction)"})
  public void testTransactionIsDetachedCreditRequest_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderPaymentConfirmationStrategyImpl.transactionIsDetachedCreditRequest(new PaymentTransactionImpl()));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then return ResponseMap Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)"})
  public void testConstructPendingTransaction_givenHashMap_thenReturnResponseMapEmpty() {
    // Arrange
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
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getResponseMap().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}.
   * <ul>
   *   <li>Then return ResponseMap size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PaymentResponseDTO OrderPaymentConfirmationStrategyImpl.constructPendingTransaction(PaymentType, PaymentGatewayType, PaymentRequestDTO)"})
  public void testConstructPendingTransaction_thenReturnResponseMapSizeIsOne() {
    // Arrange
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
    Map<String, String> responseMap = actualConstructPendingTransactionResult.getResponseMap();
    assertEquals(1, responseMap.size());
    assertTrue(actualConstructPendingTransactionResult.getCustomerCredits().isEmpty());
    assertTrue(actualConstructPendingTransactionResult.getGiftCards().isEmpty());
    assertTrue(responseMap.containsKey("ThreadLocalManager.notify.orphans"));
    assertTrue(actualConstructPendingTransactionResult.isCompleteCheckoutOnCallback());
    assertTrue(actualConstructPendingTransactionResult.isSuccessful());
    assertTrue(actualConstructPendingTransactionResult.isValid());
    assertSame(gatewayType, actualConstructPendingTransactionResult.getPaymentGatewayType());
    assertSame(paymentType, actualConstructPendingTransactionResult.getPaymentType());
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO, OrderPayment)}.
   * <ul>
   *   <li>Then throw {@link WorkflowException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#populateCreditCardOnRequest(PaymentRequestDTO, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(PaymentRequestDTO, OrderPayment)"})
  public void testPopulateCreditCardOnRequest_thenThrowWorkflowException() throws WorkflowException {
    // Arrange
    when(secureOrderPaymentService.findSecurePaymentInfo(Mockito.<String>any(), Mockito.<PaymentType>any()))
        .thenThrow(new WorkflowException("An error occurred"));
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();
    OrderPaymentImpl payment = mock(OrderPaymentImpl.class);
    when(payment.getReferenceNumber()).thenReturn("42");

    // Act and Assert
    assertThrows(WorkflowException.class,
        () -> orderPaymentConfirmationStrategyImpl.populateCreditCardOnRequest(requestDTO, payment));
    verify(payment, atLeast(1)).getReferenceNumber();
    verify(secureOrderPaymentService).findSecurePaymentInfo(eq("42"), isA(PaymentType.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateBillingAddressOnRequest(PaymentRequestDTO, OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateBillTo(Order, PaymentRequestDTO)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#populateBillingAddressOnRequest(PaymentRequestDTO, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderPaymentConfirmationStrategyImpl.populateBillingAddressOnRequest(PaymentRequestDTO, OrderPayment)"})
  public void testPopulateBillingAddressOnRequest_thenCallsPopulateBillTo() {
    // Arrange
    doNothing().when(orderToPaymentRequestDTOService)
        .populateBillTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setId(1L);
    payment.setOrder(new NullOrderImpl());
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setBillingAddress(new AddressImpl());

    // Act
    orderPaymentConfirmationStrategyImpl.populateBillingAddressOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService).populateBillTo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateCustomerOnRequest(PaymentRequestDTO, OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateCustomerInfo(Order, PaymentRequestDTO)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#populateCustomerOnRequest(PaymentRequestDTO, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderPaymentConfirmationStrategyImpl.populateCustomerOnRequest(PaymentRequestDTO, OrderPayment)"})
  public void testPopulateCustomerOnRequest_thenCallsPopulateCustomerInfo() {
    // Arrange
    doNothing().when(orderToPaymentRequestDTOService)
        .populateCustomerInfo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

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
    order.setTotalTax(new Money());
    order.setCustomer(new CustomerImpl());

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setOrder(order);

    // Act
    orderPaymentConfirmationStrategyImpl.populateCustomerOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService).populateCustomerInfo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#populateShippingAddressOnRequest(PaymentRequestDTO, OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link OrderToPaymentRequestDTOService#populateShipTo(Order, PaymentRequestDTO)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#populateShippingAddressOnRequest(PaymentRequestDTO, OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderPaymentConfirmationStrategyImpl.populateShippingAddressOnRequest(PaymentRequestDTO, OrderPayment)"})
  public void testPopulateShippingAddressOnRequest_thenCallsPopulateShipTo() {
    // Arrange
    doNothing().when(orderToPaymentRequestDTOService)
        .populateShipTo(Mockito.<Order>any(), Mockito.<PaymentRequestDTO>any());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    OrderPaymentImpl payment = new OrderPaymentImpl();
    payment.setAmount(new Money());
    payment.setBillingAddress(new AddressImpl());
    payment.setId(1L);
    payment.setPaymentGatewayType(new PaymentGatewayType("Type", "Friendly Type"));
    payment.setReferenceNumber("42");
    payment.setTransactions(new ArrayList<>());
    payment.setType(new PaymentType("Type", "Friendly Type"));
    payment.setOrder(new NullOrderImpl());

    // Act
    orderPaymentConfirmationStrategyImpl.populateShippingAddressOnRequest(requestDTO, payment);

    // Assert
    verify(orderToPaymentRequestDTOService).populateShipTo(isA(Order.class), isA(PaymentRequestDTO.class));
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentConfirmationStrategyImpl.constructExpirationDate(Integer, Integer)"})
  public void testConstructExpirationDate_thenReturn42() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("42");

    // Act
    String actualConstructExpirationDateResult = orderPaymentConfirmationStrategyImpl.constructExpirationDate(1, 1);

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("gateway.config.global.expDateFormat"));
    assertEquals("42", actualConstructExpirationDateResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}.
   * <ul>
   *   <li>Then return {@code 01/01}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#constructExpirationDate(Integer, Integer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentConfirmationStrategyImpl.constructExpirationDate(Integer, Integer)"})
  public void testConstructExpirationDate_thenReturn0101() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("");

    // Act
    String actualConstructExpirationDateResult = orderPaymentConfirmationStrategyImpl.constructExpirationDate(1, 1);

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("gateway.config.global.expDateFormat"));
    assertEquals("01/01", actualConstructExpirationDateResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}.
   * <ul>
   *   <li>Then return {@code MM/YY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat()"})
  public void testGetGatewayExpirationDateFormat_thenReturnMmYy() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("");

    // Act
    String actualGatewayExpirationDateFormat = orderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("gateway.config.global.expDateFormat"));
    assertEquals("MM/YY", actualGatewayExpirationDateFormat);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}.
   * <ul>
   *   <li>Then return {@code Resolve System Property}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#getGatewayExpirationDateFormat()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat()"})
  public void testGetGatewayExpirationDateFormat_thenReturnResolveSystemProperty() {
    // Arrange
    when(systemPropertiesService.resolveSystemProperty(Mockito.<String>any())).thenReturn("Resolve System Property");

    // Act
    String actualGatewayExpirationDateFormat = orderPaymentConfirmationStrategyImpl.getGatewayExpirationDateFormat();

    // Assert
    verify(systemPropertiesService).resolveSystemProperty(eq("gateway.config.global.expDateFormat"));
    assertEquals("Resolve System Property", actualGatewayExpirationDateFormat);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation()"})
  public void testEnablePendingPaymentsOnCheckoutConfirmation_thenReturnFalse() {
    // Arrange
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualEnablePendingPaymentsOnCheckoutConfirmationResult = orderPaymentConfirmationStrategyImpl
        .enablePendingPaymentsOnCheckoutConfirmation();

    // Assert
    verify(systemPropertiesService).resolveBooleanSystemProperty(eq("gateway.config.global.enablePendingPayments"));
    assertFalse(actualEnablePendingPaymentsOnCheckoutConfirmationResult);
  }

  /**
   * Test {@link OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderPaymentConfirmationStrategyImpl#enablePendingPaymentsOnCheckoutConfirmation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderPaymentConfirmationStrategyImpl.enablePendingPaymentsOnCheckoutConfirmation()"})
  public void testEnablePendingPaymentsOnCheckoutConfirmation_thenReturnTrue() {
    // Arrange
    when(systemPropertiesService.resolveBooleanSystemProperty(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualEnablePendingPaymentsOnCheckoutConfirmationResult = orderPaymentConfirmationStrategyImpl
        .enablePendingPaymentsOnCheckoutConfirmation();

    // Assert
    verify(systemPropertiesService).resolveBooleanSystemProperty(eq("gateway.config.global.enablePendingPayments"));
    assertTrue(actualEnablePendingPaymentsOnCheckoutConfirmationResult);
  }
}
