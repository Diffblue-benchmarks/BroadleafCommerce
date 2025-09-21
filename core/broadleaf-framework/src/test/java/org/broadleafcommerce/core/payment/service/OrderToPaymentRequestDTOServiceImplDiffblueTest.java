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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.common.payment.PaymentTransactionType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.persistence.PostLoaderDao;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl.NameResponse;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OrderToPaymentRequestDTOServiceImplDiffblueTest {
  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private OrderToPaymentRequestDTOServiceImpl orderToPaymentRequestDTOServiceImpl;

  @Mock private PaymentRequestDTOService paymentRequestDTOService;

  @Mock private PostLoaderDao postLoaderDao;

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    NameResponse nameResponse2 = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    assertEquals(nameResponse.hashCode(), nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse.setFirstName("Jane");

    NameResponse nameResponse2 = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    assertEquals(nameResponse.hashCode(), nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse.setLastName("Doe");

    NameResponse nameResponse2 = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertEquals(nameResponse, nameResponse2);
    assertEquals(nameResponse.hashCode(), nameResponse2.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}, and {@link NameResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameResponse#equals(Object)}
   *   <li>{@link NameResponse#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();

    // Act and Assert
    assertEquals(nameResponse, nameResponse);
    int expectedHashCodeResult = nameResponse.hashCode();
    assertEquals(expectedHashCodeResult, nameResponse.hashCode());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderToPaymentRequestDTOServiceImpl().new NameResponse(), 1);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, new OrderToPaymentRequestDTOServiceImpl().new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, new OrderToPaymentRequestDTOServiceImpl().new NameResponse());
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();

    NameResponse nameResponse2 = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NameResponse nameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();

    NameResponse nameResponse2 = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    nameResponse2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(nameResponse, nameResponse2);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderToPaymentRequestDTOServiceImpl().new NameResponse(), null);
  }

  /**
   * Test NameResponse {@link NameResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameResponse#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NameResponse.equals(Object)", "int NameResponse.hashCode()"})
  public void testNameResponseEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new OrderToPaymentRequestDTOServiceImpl().new NameResponse(),
        "Different type to NameResponse");
  }

  /**
   * Test NameResponse getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameResponse#NameResponse(OrderToPaymentRequestDTOServiceImpl)}
   *   <li>{@link NameResponse#setFirstName(String)}
   *   <li>{@link NameResponse#setLastName(String)}
   *   <li>{@link NameResponse#toString()}
   *   <li>{@link NameResponse#getFirstName()}
   *   <li>{@link NameResponse#getLastName()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NameResponse.<init>(OrderToPaymentRequestDTOServiceImpl)",
    "String NameResponse.getFirstName()",
    "String NameResponse.getLastName()",
    "void NameResponse.setFirstName(String)",
    "void NameResponse.setLastName(String)",
    "String NameResponse.toString()"
  })
  public void testNameResponseGettersAndSetters() {
    // Arrange and Act
    NameResponse actualNameResponse = new OrderToPaymentRequestDTOServiceImpl().new NameResponse();
    actualNameResponse.setFirstName("Jane");
    actualNameResponse.setLastName("Doe");
    String actualToStringResult = actualNameResponse.toString();
    String actualFirstName = actualNameResponse.getFirstName();

    // Assert
    assertEquals("Doe", actualNameResponse.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals(
        "OrderToPaymentRequestDTOServiceImpl.NameResponse(firstName=Jane, lastName=Doe)",
        actualToStringResult);
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("0.00", actualTranslateOrderResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslateOrderResult.getShippingTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTaxTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_givenArrayListAddOrderPaymentImpl() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(orderPaymentList);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("0.00", actualTranslateOrderResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslateOrderResult.getShippingTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTaxTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return OrderSubtotal is {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_givenArrayList_thenReturnOrderSubtotalIs000() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("0.00", actualTranslateOrderResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslateOrderResult.getShippingTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTaxTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return OrderSubtotal is {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_givenArrayList_thenReturnOrderSubtotalIs0002() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("0.00", actualTranslateOrderResult.getOrderSubtotal());
    assertEquals("0.00", actualTranslateOrderResult.getShippingTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTaxTotal());
    assertEquals("0.00", actualTranslateOrderResult.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>Then return OrderSubtotal is {@link OrderToPaymentRequestDTOServiceImpl#ZERO_TOTAL}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_thenReturnOrderSubtotalIsZero_total() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    OrderImpl order = new OrderImpl();
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isNull(), isNull());
    assertEquals(
        OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslateOrderResult.getOrderSubtotal());
    assertEquals(
        OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslateOrderResult.getShippingTotal());
    assertEquals(
        OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, actualTranslateOrderResult.getTaxTotal());
    assertEquals(
        OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL,
        actualTranslateOrderResult.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenNullOrderImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderToPaymentRequestDTOServiceImpl.translateOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(orderToPaymentRequestDTOServiceImpl.translateOrder(null));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} {@link OrderImpl#getSubTotal()} return {@link Money}.
   *   <li>Then return OrderId is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenOrderImplGetSubTotalReturnMoney_thenReturnOrderIdIs1() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(mock(Money.class));
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("1", actualTranslateOrderResult.getOrderId());
    assertNull(actualTranslateOrderResult.getOrderCurrencyCode());
    assertNull(actualTranslateOrderResult.getOrderDescription());
    assertNull(actualTranslateOrderResult.getGatewayRequestType());
    assertNull(actualTranslateOrderResult.getPaymentType());
    assertNull(actualTranslateOrderResult.getBillTo());
    assertNull(actualTranslateOrderResult.getShipTo());
    assertNull(actualTranslateOrderResult.getCreditCard());
    assertNull(actualTranslateOrderResult.getCustomer());
    assertNull(actualTranslateOrderResult.getSubscription());
    assertTrue(actualTranslateOrderResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslateOrderResult.getGiftCards().isEmpty());
    assertTrue(actualTranslateOrderResult.getLineItems().isEmpty());
    assertTrue(actualTranslateOrderResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslateOrderResult.isCompleteCheckoutOnCallback());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTotalAfterAppliedPayments()} return {@link
   *       Money}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenOrderImplGetTotalAfterAppliedPaymentsReturnMoney() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(mock(Money.class));
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("1", actualTranslateOrderResult.getOrderId());
    assertNull(actualTranslateOrderResult.getOrderCurrencyCode());
    assertNull(actualTranslateOrderResult.getOrderDescription());
    assertNull(actualTranslateOrderResult.getGatewayRequestType());
    assertNull(actualTranslateOrderResult.getPaymentType());
    assertNull(actualTranslateOrderResult.getBillTo());
    assertNull(actualTranslateOrderResult.getShipTo());
    assertNull(actualTranslateOrderResult.getCreditCard());
    assertNull(actualTranslateOrderResult.getCustomer());
    assertNull(actualTranslateOrderResult.getSubscription());
    assertTrue(actualTranslateOrderResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslateOrderResult.getGiftCards().isEmpty());
    assertTrue(actualTranslateOrderResult.getLineItems().isEmpty());
    assertTrue(actualTranslateOrderResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslateOrderResult.isCompleteCheckoutOnCallback());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTotalShipping()} return {@link Money}.
   *   <li>Then return OrderId is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenOrderImplGetTotalShippingReturnMoney_thenReturnOrderIdIs1() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(mock(Money.class));
    when(order.getTotalTax()).thenReturn(new Money());
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("1", actualTranslateOrderResult.getOrderId());
    assertNull(actualTranslateOrderResult.getOrderCurrencyCode());
    assertNull(actualTranslateOrderResult.getOrderDescription());
    assertNull(actualTranslateOrderResult.getGatewayRequestType());
    assertNull(actualTranslateOrderResult.getPaymentType());
    assertNull(actualTranslateOrderResult.getBillTo());
    assertNull(actualTranslateOrderResult.getShipTo());
    assertNull(actualTranslateOrderResult.getCreditCard());
    assertNull(actualTranslateOrderResult.getCustomer());
    assertNull(actualTranslateOrderResult.getSubscription());
    assertTrue(actualTranslateOrderResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslateOrderResult.getGiftCards().isEmpty());
    assertTrue(actualTranslateOrderResult.getLineItems().isEmpty());
    assertTrue(actualTranslateOrderResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslateOrderResult.isCompleteCheckoutOnCallback());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} {@link OrderImpl#getTotalTax()} return {@link Money}.
   *   <li>Then return OrderId is {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#translateOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentRequestDTO OrderToPaymentRequestDTOServiceImpl.translateOrder(Order)"})
  public void testTranslateOrder_whenOrderImplGetTotalTaxReturnMoney_thenReturnOrderIdIs1() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(new FulfillmentGroupImpl());

    OrderImpl order = mock(OrderImpl.class);
    when(order.getSubTotal()).thenReturn(new Money());
    when(order.getId()).thenReturn(1L);
    when(order.getEmailAddress()).thenReturn("42 Main St");
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getPayments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(mock(Money.class));
    when(order.getCustomer()).thenReturn(new CustomerImpl());
    doNothing().when(order).setId(Mockito.<Long>any());
    order.setId(1L);

    // Act
    PaymentRequestDTO actualTranslateOrderResult =
        orderToPaymentRequestDTOServiceImpl.translateOrder(order);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order).getCustomer();
    verify(order).getEmailAddress();
    verify(order).getFulfillmentGroups();
    verify(order).getId();
    verify(order).getPayments();
    verify(order, atLeast(1)).getSubTotal();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    verify(order).setId(1L);
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isA(Customer.class), eq("42 Main St"));
    assertEquals("1", actualTranslateOrderResult.getOrderId());
    assertNull(actualTranslateOrderResult.getOrderCurrencyCode());
    assertNull(actualTranslateOrderResult.getOrderDescription());
    assertNull(actualTranslateOrderResult.getGatewayRequestType());
    assertNull(actualTranslateOrderResult.getPaymentType());
    assertNull(actualTranslateOrderResult.getBillTo());
    assertNull(actualTranslateOrderResult.getShipTo());
    assertNull(actualTranslateOrderResult.getCreditCard());
    assertNull(actualTranslateOrderResult.getCustomer());
    assertNull(actualTranslateOrderResult.getSubscription());
    assertTrue(actualTranslateOrderResult.getCustomerCredits().isEmpty());
    assertTrue(actualTranslateOrderResult.getGiftCards().isEmpty());
    assertTrue(actualTranslateOrderResult.getLineItems().isEmpty());
    assertTrue(actualTranslateOrderResult.getAdditionalFields().isEmpty());
    assertTrue(actualTranslateOrderResult.isCompleteCheckoutOnCallback());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}.
   *
   * <ul>
   *   <li>Then return {@link PaymentTransactionImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderToPaymentRequestDTOServiceImpl#refreshTransaction(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentTransaction OrderToPaymentRequestDTOServiceImpl.refreshTransaction(PaymentTransaction)"
  })
  public void testRefreshTransaction_thenReturnPaymentTransactionImpl() {
    // Arrange
    PaymentTransactionImpl paymentTransactionImpl = new PaymentTransactionImpl();
    paymentTransactionImpl.setAdditionalFields(new HashMap<>());
    paymentTransactionImpl.setAmount(new Money());
    paymentTransactionImpl.setCustomerIpAddress("42 Main St");
    paymentTransactionImpl.setDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    paymentTransactionImpl.setId(1L);
    paymentTransactionImpl.setOrderPayment(new OrderPaymentImpl());
    paymentTransactionImpl.setParentTransaction(new PaymentTransactionImpl());
    paymentTransactionImpl.setRawResponse("Raw Response");
    paymentTransactionImpl.setSaveToken(true);
    paymentTransactionImpl.setSuccess(true);
    paymentTransactionImpl.setType(new PaymentTransactionType("Type", "Friendly Type"));
    when(postLoaderDao.find(Mockito.<Class<PaymentTransactionImpl>>any(), Mockito.<Object>any()))
        .thenReturn(paymentTransactionImpl);

    // Act
    PaymentTransaction actualRefreshTransactionResult =
        orderToPaymentRequestDTOServiceImpl.refreshTransaction(new PaymentTransactionImpl());

    // Assert
    verify(postLoaderDao).find(isA(Class.class), isNull());
    assertSame(paymentTransactionImpl, actualRefreshTransactionResult);
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link Money}.
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalShipping()} return {@link Money}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_givenMoney_whenNullOrderImplGetTotalShippingReturnMoney() {
    // Arrange
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
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link Money}.
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalTax()} return {@link Money}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_givenMoney_whenNullOrderImplGetTotalTaxReturnMoney() {
    // Arrange
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
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_givenPaymentRequestDTO() {
    // Arrange
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
    verify(requestDTO).transactionTotal("0.00");
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} {@link PaymentRequestDTO#shippingTotal(String)} return
   *       {@link PaymentRequestDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_givenPaymentRequestDTOShippingTotalReturnPaymentRequestDTO() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());

    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.shippingTotal(Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).shippingTotal("0.00");
    verify(requestDTO).transactionTotal("0.00");
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Given {@link PaymentRequestDTO} {@link PaymentRequestDTO#taxTotal(String)} return {@link
   *       PaymentRequestDTO} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_givenPaymentRequestDTOTaxTotalReturnPaymentRequestDTO() {
    // Arrange
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
    verify(paymentRequestDTO2).shippingTotal("0.00");
    verify(paymentRequestDTO).taxTotal("0.00");
    verify(requestDTO).transactionTotal("0.00");
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderCurrencyCode(String)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_thenCallsOrderCurrencyCode() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());

    PaymentRequestDTO paymentRequestDTO = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO.orderCurrencyCode(Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());

    PaymentRequestDTO paymentRequestDTO2 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO2.taxTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO);

    PaymentRequestDTO paymentRequestDTO3 = mock(PaymentRequestDTO.class);
    when(paymentRequestDTO3.shippingTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO2);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.transactionTotal(Mockito.<String>any())).thenReturn(paymentRequestDTO3);

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(paymentRequestDTO).orderCurrencyCode(null);
    verify(paymentRequestDTO3).shippingTotal("0.00");
    verify(paymentRequestDTO2).taxTotal("0.00");
    verify(requestDTO).transactionTotal("0.00");
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) ShippingTotal is {@link
   *       OrderToPaymentRequestDTOServiceImpl#ZERO_TOTAL}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_thenPaymentRequestDTOShippingTotalIsZero_total() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(null);
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, requestDTO.getShippingTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) TaxTotal is {@link
   *       OrderToPaymentRequestDTOServiceImpl#ZERO_TOTAL}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_thenPaymentRequestDTOTaxTotalIsZero_total() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(new Money());
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(null);
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTransactionTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, requestDTO.getTaxTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then {@link PaymentRequestDTO} (default constructor) TransactionTotal is {@link
   *       OrderToPaymentRequestDTOServiceImpl#ZERO_TOTAL}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_thenPaymentRequestDTOTransactionTotalIsZero_total() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getCurrency()).thenReturn(new BroadleafCurrencyImpl());
    when(order.getTotalAfterAppliedPayments()).thenReturn(null);
    when(order.getTotalShipping()).thenReturn(new Money());
    when(order.getTotalTax()).thenReturn(new Money());
    PaymentRequestDTO requestDTO = new PaymentRequestDTO();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateTotals(order, requestDTO);

    // Assert
    verify(order).getCurrency();
    verify(order).getTotalAfterAppliedPayments();
    verify(order, atLeast(1)).getTotalShipping();
    verify(order, atLeast(1)).getTotalTax();
    assertEquals("0.00", requestDTO.getShippingTotal());
    assertEquals("0.00", requestDTO.getTaxTotal());
    assertEquals(OrderToPaymentRequestDTOServiceImpl.ZERO_TOTAL, requestDTO.getTransactionTotal());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} {@link NullOrderImpl#getTotalAfterAppliedPayments()} return
   *       {@link Money}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_whenNullOrderImplGetTotalAfterAppliedPaymentsReturnMoney() {
    // Arrange
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
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order, PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link PaymentRequestDTO} (default constructor).
   *   <li>Then {@link PaymentRequestDTO} (default constructor) ShippingTotal is {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateTotals(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateTotals(Order, PaymentRequestDTO)"
  })
  public void testPopulateTotals_whenPaymentRequestDTO_thenPaymentRequestDTOShippingTotalIs000() {
    // Arrange
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
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order,
   * PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then calls {@link PaymentRequestDTOService#populateCustomerInfo(PaymentRequestDTO,
   *       Customer, String)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateCustomerInfo(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateCustomerInfo(Order, PaymentRequestDTO)"
  })
  public void testPopulateCustomerInfo_whenNullOrderImpl_thenCallsPopulateCustomerInfo() {
    // Arrange
    when(paymentRequestDTOService.populateCustomerInfo(
            Mockito.<PaymentRequestDTO>any(), Mockito.<Customer>any(), Mockito.<String>any()))
        .thenReturn(new PaymentRequestDTO());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    orderToPaymentRequestDTOServiceImpl.populateCustomerInfo(order, new PaymentRequestDTO());

    // Assert
    verify(paymentRequestDTOService)
        .populateCustomerInfo(isA(PaymentRequestDTO.class), isNull(), isNull());
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateShipTo(Order, PaymentRequestDTO)"
  })
  public void testPopulateShipTo() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateShipTo(order, new PaymentRequestDTO());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order, PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link OrderToPaymentRequestDTOServiceImpl#populateShipTo(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateShipTo(Order, PaymentRequestDTO)"
  })
  public void testPopulateShipTo2() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateShipTo(order, new PaymentRequestDTO());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order,
   * PaymentRequestDTO)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentRequestDTO#orderSubtotal(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderToPaymentRequestDTOServiceImpl#populateDefaultLineItemsAndSubtotal(Order,
   * PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(Order, PaymentRequestDTO)"
  })
  public void testPopulateDefaultLineItemsAndSubtotal_thenCallsOrderSubtotal() {
    // Arrange
    OrderImpl order = new OrderImpl();

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.orderSubtotal(Mockito.<String>any())).thenReturn(new PaymentRequestDTO());

    // Act
    orderToPaymentRequestDTOServiceImpl.populateDefaultLineItemsAndSubtotal(order, requestDTO);

    // Assert
    verify(requestDTO).orderSubtotal("0");
  }
}
