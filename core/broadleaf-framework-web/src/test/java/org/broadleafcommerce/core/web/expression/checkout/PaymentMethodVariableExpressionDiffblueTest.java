/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.payment.service.OrderToPaymentRequestDTOService;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PaymentMethodVariableExpressionDiffblueTest {
  @Mock
  private CartStateService cartStateService;

  @Mock
  private OrderPaymentService orderPaymentService;

  @Mock
  private OrderToPaymentRequestDTOService orderToPaymentRequestDTOService;

  @InjectMocks
  private PaymentMethodVariableExpression paymentMethodVariableExpression;

  /**
   * Test {@link PaymentMethodVariableExpression#getName()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paymentMethod", (new PaymentMethodVariableExpression()).getName());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}
   */
  @Test
  @DisplayName("Test getPaymentRequestDTO()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.broadleafcommerce.common.payment.dto.PaymentRequestDTO PaymentMethodVariableExpression.getPaymentRequestDTO()"})
  void testGetPaymentRequestDTO() {
    // Arrange, Act and Assert
    assertNull(paymentMethodVariableExpression.getPaymentRequestDTO());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when NullOrderImpl (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(paymentMethodVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(paymentMethodVariableExpression.isNullOrder(null));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @DisplayName("Test isNullOrder(Order); when OrderImpl (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(paymentMethodVariableExpression.isNullOrder(new OrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartContainsThirdPartyPayment(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsThirdPartyPayment()"})
  void testCartContainsThirdPartyPayment_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(false);

    // Act
    boolean actualCartContainsThirdPartyPaymentResult = paymentMethodVariableExpression.cartContainsThirdPartyPayment();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    assertFalse(actualCartContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartContainsThirdPartyPayment(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsThirdPartyPayment()"})
  void testCartContainsThirdPartyPayment_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(true);

    // Act
    boolean actualCartContainsThirdPartyPaymentResult = paymentMethodVariableExpression.cartContainsThirdPartyPayment();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    assertTrue(actualCartContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartContainsCreditCardPayment(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsCreditCardPayment()"})
  void testCartContainsCreditCardPayment_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasCreditCardPayment()).thenReturn(false);

    // Act
    boolean actualCartContainsCreditCardPaymentResult = paymentMethodVariableExpression.cartContainsCreditCardPayment();

    // Assert
    verify(cartStateService).cartHasCreditCardPayment();
    assertFalse(actualCartContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartContainsCreditCardPayment(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsCreditCardPayment()"})
  void testCartContainsCreditCardPayment_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasCreditCardPayment()).thenReturn(true);

    // Act
    boolean actualCartContainsCreditCardPaymentResult = paymentMethodVariableExpression.cartContainsCreditCardPayment();

    // Assert
    verify(cartStateService).cartHasCreditCardPayment();
    assertTrue(actualCartContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartContainsTemporaryCreditCard(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsTemporaryCreditCard()"})
  void testCartContainsTemporaryCreditCard_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasTemporaryCreditCard()).thenReturn(false);

    // Act
    boolean actualCartContainsTemporaryCreditCardResult = paymentMethodVariableExpression
        .cartContainsTemporaryCreditCard();

    // Assert
    verify(cartStateService).cartHasTemporaryCreditCard();
    assertFalse(actualCartContainsTemporaryCreditCardResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartContainsTemporaryCreditCard(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsTemporaryCreditCard()"})
  void testCartContainsTemporaryCreditCard_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasTemporaryCreditCard()).thenReturn(true);

    // Act
    boolean actualCartContainsTemporaryCreditCardResult = paymentMethodVariableExpression
        .cartContainsTemporaryCreditCard();

    // Assert
    verify(cartStateService).cartHasTemporaryCreditCard();
    assertTrue(actualCartContainsTemporaryCreditCardResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order); given ArrayList() add OrderPaymentImpl (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  void testOrderContainsCODPayment_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult = paymentMethodVariableExpression
        .orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  void testOrderContainsCODPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult = paymentMethodVariableExpression
        .orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order); given OrderPaymentImpl isActive() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  void testOrderContainsCODPayment_givenOrderPaymentImplIsActiveReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult = paymentMethodVariableExpression
        .orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  void testOrderContainsCODPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsCODPaymentResult = paymentMethodVariableExpression
        .orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCODPayment(Order); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  void testOrderContainsCODPayment_thenReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("COD", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult = paymentMethodVariableExpression
        .orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"})
  void testOrderContainsCreditCardPayment() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCreditCardPaymentResult = paymentMethodVariableExpression
        .orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"})
  void testOrderContainsCreditCardPayment2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type", true, true));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCreditCardPaymentResult = paymentMethodVariableExpression
        .orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"})
  void testOrderContainsCreditCardPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCreditCardPaymentResult = paymentMethodVariableExpression
        .orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order); then calls isCreditCardType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"})
  void testOrderContainsCreditCardPayment_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCreditCardPaymentResult = paymentMethodVariableExpression
        .orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsCreditCardPayment(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"})
  void testOrderContainsCreditCardPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsCreditCardPaymentResult = paymentMethodVariableExpression
        .orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order); given ArrayList() add OrderPaymentImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"})
  void testOrderContainsThirdPartyPayment_givenArrayListAddOrderPaymentImpl() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult = paymentMethodVariableExpression
        .orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"})
  void testOrderContainsThirdPartyPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult = paymentMethodVariableExpression
        .orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order); given OrderPaymentImpl isActive() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"})
  void testOrderContainsThirdPartyPayment_givenOrderPaymentImplIsActiveReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult = paymentMethodVariableExpression
        .orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"})
  void testOrderContainsThirdPartyPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult = paymentMethodVariableExpression
        .orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @DisplayName("Test orderContainsThirdPartyPayment(Order); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"})
  void testOrderContainsThirdPartyPayment_thenReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("THIRD_PARTY_ACCOUNT", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult = paymentMethodVariableExpression
        .orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("42", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); given ArrayList() add OrderPaymentImpl (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link PaymentType#PaymentType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); given OrderPaymentImpl getType() return PaymentType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_thenReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); when PaymentType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_whenPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression.orderContainsPaymentOfType(order,
        new PaymentType());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   * <ul>
   *   <li>When {@link PaymentType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}
   */
  @Test
  @DisplayName("Test orderContainsPaymentOfType(Order, PaymentType); when PaymentType")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"})
  void testOrderContainsPaymentOfType_whenPaymentType2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsPaymentOfTypeResult = paymentMethodVariableExpression
        .orderContainsPaymentOfType(new NullOrderImpl(), mock(PaymentType.class));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}
   */
  @Test
  @DisplayName("Test getExpirationMonthOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PaymentMethodVariableExpression.getExpirationMonthOptions()"})
  void testGetExpirationMonthOptions() {
    // Arrange and Act
    List<String> actualExpirationMonthOptions = paymentMethodVariableExpression.getExpirationMonthOptions();

    // Assert
    assertEquals(12, actualExpirationMonthOptions.size());
    assertEquals("01 - January", actualExpirationMonthOptions.get(0));
    assertEquals("02 - February", actualExpirationMonthOptions.get(1));
    assertEquals("03 - March", actualExpirationMonthOptions.get(2));
    assertEquals("04 - April", actualExpirationMonthOptions.get(3));
    assertEquals("05 - May", actualExpirationMonthOptions.get(4));
    assertEquals("06 - June", actualExpirationMonthOptions.get(5));
    assertEquals("07 - July", actualExpirationMonthOptions.get(6));
    assertEquals("08 - August", actualExpirationMonthOptions.get(7));
    assertEquals("09 - September", actualExpirationMonthOptions.get(8));
    assertEquals("10 - October", actualExpirationMonthOptions.get(9));
    assertEquals("11 - November", actualExpirationMonthOptions.get(10));
    assertEquals("12 - December", actualExpirationMonthOptions.get(11));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationYearOptions()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getExpirationYearOptions()}
   */
  @Test
  @DisplayName("Test getExpirationYearOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List PaymentMethodVariableExpression.getExpirationYearOptions()"})
  void testGetExpirationYearOptions() {
    // Arrange, Act and Assert
    assertEquals(10, paymentMethodVariableExpression.getExpirationYearOptions().size());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart(); given ArrayList() add PaymentTransactionImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart(); then calls isCreditCardType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardTypeFromCart(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  void testGetCreditCardTypeFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardTypeFromCart = paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart(); given ArrayList() add PaymentTransactionImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart(); then calls isCreditCardType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardLastFourFromCart(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  void testGetCreditCardLastFourFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardLastFourFromCart = paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart(); given ArrayList() add PaymentTransactionImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart(); then calls isCreditCardType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @DisplayName("Test getCreditCardExpDateFromCart(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  void testGetCreditCardExpDateFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardExpDateFromCart = paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String); given ArrayList() add PaymentTransactionImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty_givenArrayListAddPaymentTransactionImpl() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
    when(orderPaymentImpl.getType()).thenReturn(
        new PaymentType("ThreadLocalManager.notify.orphans", "ThreadLocalManager.notify.orphans", true, true));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String); given OrderPaymentImpl isActive() return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String); then calls isCreditCardType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @DisplayName("Test getCartOrderPaymentProperty(String); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  void testGetCartOrderPaymentProperty_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any())).thenReturn(new ArrayList<>());

    // Act
    String actualCartOrderPaymentProperty = paymentMethodVariableExpression
        .getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }
}
