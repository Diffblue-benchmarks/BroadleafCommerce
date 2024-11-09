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
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOServiceImpl.NameResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class OrderToPaymentRequestDTOServiceImplDiffblueTest {
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
