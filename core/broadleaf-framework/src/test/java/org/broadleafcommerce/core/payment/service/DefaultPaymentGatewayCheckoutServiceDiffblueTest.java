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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.CheckoutService;
import org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl;
import org.broadleafcommerce.core.checkout.service.workflow.CheckoutResponse;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.domain.secure.Referenced;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultPaymentGatewayCheckoutServiceDiffblueTest {
  @Mock
  private CheckoutService checkoutService;

  @InjectMocks
  private DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;

  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private OrderService orderService;

  @Mock
  private PaymentResponseDTOToEntityService paymentResponseDTOToEntityService;

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(eq(42L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder2() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentService.create()).thenReturn(new OrderPaymentImpl());
    Order order = mock(Order.class);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder3() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(new PaymentTransactionImpl());
    when(orderPaymentService.create()).thenReturn(new OrderPaymentImpl());
    Order order = mock(Order.class);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenThrow(new IllegalArgumentException("IN_PROCESS"));
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder4() {
    // Arrange
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getFirstName()).thenThrow(new IllegalArgumentException("IN_PROCESS"));
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(eq(42L));
    verify(customerImpl).getFirstName();
    verify(customerImpl).isAnonymous();
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getEmailAddress()} return {@code 42 Main St}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenCustomerImplGetEmailAddressReturn42MainSt() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerImpl.getFirstName()).thenReturn("Jane");
    when(customerImpl.getLastName()).thenReturn("Doe");
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getFirstName();
    verify(customerImpl).getLastName();
    verify(customerImpl).isAnonymous();
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getEmailAddress()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenCustomerImplGetEmailAddressReturnEmptyString() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenReturn("");
    when(customerImpl.getFirstName()).thenReturn("Jane");
    when(customerImpl.getLastName()).thenReturn("Doe");
    doNothing().when(customerImpl).setEmailAddress(Mockito.<String>any());
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getFirstName();
    verify(customerImpl).getLastName();
    verify(customerImpl).isAnonymous();
    verify(customerImpl).setEmailAddress(isNull());
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CustomerImpl} {@link CustomerImpl#getEmailAddress()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenCustomerImplGetEmailAddressReturnNull() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenReturn(null);
    when(customerImpl.getFirstName()).thenReturn("Jane");
    when(customerImpl.getLastName()).thenReturn("Doe");
    doNothing().when(customerImpl).setEmailAddress(Mockito.<String>any());
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getFirstName();
    verify(customerImpl).getLastName();
    verify(customerImpl).isAnonymous();
    verify(customerImpl).setEmailAddress(isNull());
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link DefaultPaymentGatewayCheckoutService} (default constructor).</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenDefaultPaymentGatewayCheckoutService_whenNull() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PaymentResponseDTO} {@link PaymentResponseDTO#isValid()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenFalse_whenPaymentResponseDTOIsValidReturnFalse() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link Order} {@link Order#getStatus()} return {@link OrderStatus#ARCHIVED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenOrderGetStatusReturnArchived() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getStatus()).thenReturn(OrderStatus.ARCHIVED);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(eq(42L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long)} return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenOrderServiceFindOrderByIdReturnNullOrderImpl() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new NullOrderImpl());
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(eq(42L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long)} return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_givenOrderServiceFindOrderByIdReturnOrderImpl() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(new OrderImpl());
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
    verify(orderService).findOrderById(eq(42L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#addTransaction(PaymentTransaction)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_thenCallsAddTransaction() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    Order order = mock(Order.class);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentService#readPaymentById(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_thenCallsReadPaymentById() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(false);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(new OrderPaymentImpl());
    Order order = mock(Order.class);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(orderService).findOrderById(eq(42L));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).readPaymentById(isNull());
    verify(orderPaymentService, atLeast(1)).save(Mockito.<OrderPayment>any());
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link Order#setEmailAddress(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_thenCallsSetEmailAddress() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setFirstName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_thenCallsSetFirstName() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerImpl.getFirstName()).thenReturn(null);
    when(customerImpl.getLastName()).thenReturn("Doe");
    doNothing().when(customerImpl).setFirstName(Mockito.<String>any());
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getFirstName();
    verify(customerImpl).getLastName();
    verify(customerImpl).isAnonymous();
    verify(customerImpl).setFirstName(isNull());
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link CustomerImpl#setLastName(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultPaymentGatewayCheckoutService.applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testApplyPaymentToOrder_thenCallsSetLastName() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateBillingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<OrderPayment>any(), Mockito.<Address>any(),
            anyBoolean());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateShippingInfo(Mockito.<PaymentResponseDTO>any(), Mockito.<Order>any());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doNothing().when(orderPaymentImpl).addTransaction(Mockito.<PaymentTransaction>any());
    doNothing().when(orderPaymentImpl).setAmount(Mockito.<Money>any());
    doNothing().when(orderPaymentImpl).setOrder(Mockito.<Order>any());
    doNothing().when(orderPaymentImpl).setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    doNothing().when(orderPaymentImpl).setType(Mockito.<PaymentType>any());
    PaymentTransaction paymentTransaction = mock(PaymentTransaction.class);
    when(paymentTransaction.getSuccess()).thenReturn(true);
    doNothing().when(paymentTransaction).setAmount(Mockito.<Money>any());
    doNothing().when(paymentTransaction).setOrderPayment(Mockito.<OrderPayment>any());
    doNothing().when(paymentTransaction).setRawResponse(Mockito.<String>any());
    doNothing().when(paymentTransaction).setSuccess(Mockito.<Boolean>any());
    doNothing().when(paymentTransaction).setType(Mockito.<PaymentTransactionType>any());
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.createTransaction()).thenReturn(paymentTransaction);
    when(orderPaymentService.create()).thenReturn(orderPaymentImpl);
    CustomerImpl customerImpl = mock(CustomerImpl.class);
    when(customerImpl.getEmailAddress()).thenReturn("42 Main St");
    when(customerImpl.getFirstName()).thenReturn("Jane");
    when(customerImpl.getLastName()).thenReturn(null);
    doNothing().when(customerImpl).setLastName(Mockito.<String>any());
    when(customerImpl.isAnonymous()).thenReturn(true);
    Order order = mock(Order.class);
    doNothing().when(order).setEmailAddress(Mockito.<String>any());
    when(order.getEmailAddress()).thenReturn(null);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCustomer()).thenReturn(customerImpl);
    when(order.getStatus()).thenReturn(OrderStatus.CSR_OWNED);
    when(orderService.addPaymentToOrder(Mockito.<Order>any(), Mockito.<OrderPayment>any(), Mockito.<Referenced>any()))
        .thenReturn(new OrderPaymentImpl());
    when(orderService.findOrderById(Mockito.<Long>any())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isSuccessful()).thenReturn(true);
    when(responseDTO.getRawResponse()).thenReturn("Raw Response");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getAmount()).thenReturn(new Money());
    when(responseDTO.getPaymentGatewayType()).thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(responseDTO.getPaymentTransactionType()).thenReturn(new PaymentTransactionType("Type", "Friendly Type"));
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.getOrderId()).thenReturn("42");
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualApplyPaymentToOrderResult = defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getAmount();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getOrderId();
    verify(responseDTO).getPaymentGatewayType();
    verify(responseDTO).getPaymentTransactionType();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getRawResponse();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isSuccessful();
    verify(responseDTO).isValid();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getPayments();
    verify(order, atLeast(1)).getStatus();
    verify(order).setEmailAddress(isNull());
    verify(orderService).addPaymentToOrder(isA(Order.class), isA(OrderPayment.class), isNull());
    verify(orderService).findOrderById(eq(42L));
    verify(orderPaymentImpl).addTransaction(isA(PaymentTransaction.class));
    verify(orderPaymentImpl).setAmount(isA(Money.class));
    verify(orderPaymentImpl).setOrder(isA(Order.class));
    verify(orderPaymentImpl).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(orderPaymentImpl).setType(isA(PaymentType.class));
    verify(paymentTransaction).getSuccess();
    verify(paymentTransaction).setAmount(isA(Money.class));
    verify(paymentTransaction).setOrderPayment(isA(OrderPayment.class));
    verify(paymentTransaction).setRawResponse(eq("Raw Response"));
    verify(paymentTransaction).setSuccess(eq(true));
    verify(paymentTransaction).setType(isA(PaymentTransactionType.class));
    verify(orderPaymentService).create();
    verify(orderPaymentService).createTransaction();
    verify(orderPaymentService).save(isA(OrderPayment.class));
    verify(paymentResponseDTOToEntityService).populateBillingInfo(isA(PaymentResponseDTO.class),
        isA(OrderPayment.class), isNull(), eq(true));
    verify(paymentResponseDTOToEntityService).populateShippingInfo(isA(PaymentResponseDTO.class), isA(Order.class));
    verify(customerImpl).getEmailAddress();
    verify(customerImpl).getFirstName();
    verify(customerImpl).getLastName();
    verify(customerImpl).isAnonymous();
    verify(customerImpl).setLastName(isNull());
    assertNull(actualApplyPaymentToOrderResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"})
  public void testHandleUnsuccessfulTransaction() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenThrow(new IllegalArgumentException("foo"));
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(new OrderPaymentImpl()));
    verify(orderPaymentService).readPaymentById(isNull());
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"})
  public void testHandleUnsuccessfulTransaction2() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(new OrderPaymentImpl()));
    verify(orderPaymentService).readPaymentById(isNull());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentService#save(OrderPayment)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"})
  public void testHandleUnsuccessfulTransaction_thenCallsSave() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());

    // Act
    defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(new OrderPaymentImpl());

    // Assert
    verify(orderPaymentService).readPaymentById(isNull());
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#setArchived(Character)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(OrderPayment)"})
  public void testHandleUnsuccessfulTransaction_thenCallsSetArchived() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(orderPaymentImpl).setArchived(Mockito.<Character>any());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.handleUnsuccessfulTransaction(new OrderPaymentImpl()));
    verify(orderPaymentImpl).setArchived(eq('Y'));
    verify(orderPaymentService).readPaymentById(isNull());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenThrow(new IllegalArgumentException("foo"));
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentService).readPaymentById(eq(1L));
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   * <ul>
   *   <li>Given {@link OrderPaymentService} {@link OrderPaymentService#readPaymentById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_givenOrderPaymentServiceReadPaymentByIdReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentService).readPaymentById(eq(1L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   * <ul>
   *   <li>Given {@link OrderPaymentService} {@link OrderPaymentService#save(OrderPayment)} return {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_givenOrderPaymentServiceSaveReturnOrderPaymentImpl() {
    // Arrange
    when(orderPaymentService.save(Mockito.<OrderPayment>any())).thenReturn(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(new OrderPaymentImpl());

    // Act
    defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L);

    // Assert
    verify(orderPaymentService).readPaymentById(eq(1L));
    verify(orderPaymentService).save(isA(OrderPayment.class));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   * <ul>
   *   <li>Then calls {@link OrderPaymentImpl#setArchived(Character)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultPaymentGatewayCheckoutService.markPaymentAsInvalid(Long)"})
  public void testMarkPaymentAsInvalid_thenCallsSetArchived() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    doThrow(new IllegalArgumentException("foo")).when(orderPaymentImpl).setArchived(Mockito.<Character>any());
    when(orderPaymentService.readPaymentById(Mockito.<Long>any())).thenReturn(orderPaymentImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.markPaymentAsInvalid(1L));
    verify(orderPaymentImpl).setArchived(eq('Y'));
    verify(orderPaymentService).readPaymentById(eq(1L));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout() throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenThrow(new IllegalArgumentException("foo"));
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse).getOrder();
    verify(orderService).findOrderById(eq(1L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenAuditableCreatedByIsOne_thenReturn42() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

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
    orderImpl.setName("Order Number for Order ID: ");
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
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(orderImpl);
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act
    String actualInitiateCheckoutResult = defaultPaymentGatewayCheckoutService.initiateCheckout(1L);

    // Assert
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse, atLeast(1)).getOrder();
    verify(orderService).findOrderById(eq(1L), eq(true));
    assertEquals("42", actualInitiateCheckoutResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenOrderServiceFindOrderByIdReturnNull() throws Exception {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(orderService).findOrderById(eq(1L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_givenOrderServiceFindOrderByIdReturnNullOrderImpl() throws Exception {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new NullOrderImpl());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(orderService).findOrderById(eq(1L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <ul>
   *   <li>Then calls {@link OrderImpl#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_thenCallsGetId() throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(new NullOrderImpl());
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    OrderImpl orderImpl = mock(OrderImpl.class);
    when(orderImpl.getId()).thenThrow(new IllegalArgumentException("foo"));
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(orderImpl);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService.initiateCheckout(1L));
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse).getOrder();
    verify(orderImpl).getId();
    verify(orderService).findOrderById(eq(1L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.initiateCheckout(Long)"})
  public void testInitiateCheckout_thenReturnNull() throws Exception {
    // Arrange
    CheckoutResponse checkoutResponse = mock(CheckoutResponse.class);
    when(checkoutResponse.getOrder()).thenReturn(new NullOrderImpl());
    when(checkoutService.performCheckout(Mockito.<Order>any())).thenReturn(checkoutResponse);
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new OrderImpl());

    // Act
    String actualInitiateCheckoutResult = defaultPaymentGatewayCheckoutService.initiateCheckout(1L);

    // Assert
    verify(checkoutService).performCheckout(isA(Order.class));
    verify(checkoutResponse, atLeast(1)).getOrder();
    verify(orderService).findOrderById(eq(1L), eq(true));
    assertNull(actualInitiateCheckoutResult);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"})
  public void testLookupOrderNumberFromOrderId() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new IllegalArgumentException("An order with ID "));
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO).getOrderId();
    verify(orderService).findOrderById(eq(42L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   * <ul>
   *   <li>Given {@link OrderService} {@link OrderService#findOrderById(Long, boolean)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"})
  public void testLookupOrderNumberFromOrderId_givenOrderServiceFindOrderByIdReturnNull() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(null);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO, atLeast(1)).getOrderId();
    verify(orderService).findOrderById(eq(42L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   * <ul>
   *   <li>Then calls {@link Order#getOrderNumber()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"})
  public void testLookupOrderNumberFromOrderId_thenCallsGetOrderNumber() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderNumber()).thenThrow(new IllegalArgumentException("foo"));
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(order);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(responseDTO));
    verify(responseDTO).getOrderId();
    verify(order).getOrderNumber();
    verify(orderService).findOrderById(eq(42L), eq(true));
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DefaultPaymentGatewayCheckoutService.lookupOrderNumberFromOrderId(PaymentResponseDTO)"})
  public void testLookupOrderNumberFromOrderId_thenReturnNull() {
    // Arrange
    when(orderService.findOrderById(Mockito.<Long>any(), anyBoolean())).thenReturn(new NullOrderImpl());
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenReturn("42");

    // Act
    String actualLookupOrderNumberFromOrderIdResult = defaultPaymentGatewayCheckoutService
        .lookupOrderNumberFromOrderId(responseDTO);

    // Assert
    verify(responseDTO).getOrderId();
    verify(orderService).findOrderById(eq(42L), eq(true));
    assertNull(actualLookupOrderNumberFromOrderIdResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultPaymentGatewayCheckoutService#setUseBillingAddressFromGateway(boolean)}
   *   <li>{@link DefaultPaymentGatewayCheckoutService#isUseBillingAddressFromGateway()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway()",
      "void DefaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(boolean)"})
  public void testGettersAndSetters() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();

    // Act
    defaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(true);

    // Assert
    assertTrue(defaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway());
  }
}
