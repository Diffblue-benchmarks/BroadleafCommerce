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
package org.broadleafcommerce.core.web.order.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CartStateServiceImplDiffblueTest {
  @InjectMocks private CartStateServiceImpl cartStateServiceImpl;

  @Mock private OrderPaymentService orderPaymentService;

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress3() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress4() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl2);
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName(
      "Test cartHasPopulatedBillingAddress(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @DisplayName("Test cartHasPopulatedBillingAddress(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  void testCartHasPopulatedBillingAddress_thenReturnTrue() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasPopulatedBillingAddressResult =
        cartStateServiceImpl.cartHasPopulatedBillingAddress();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getBillingAddress();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasPopulatedBillingAddressResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    PaymentType paymentType = new PaymentType("Type", "Friendly Type", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken3() {
    // Arrange
    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
    PaymentType paymentType = new PaymentType("Type", "Friendly Type", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken4() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken5() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl2 = new OrderPaymentImpl();
    orderPaymentImpl2.setType(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl2);
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String); then calls isCreditCardType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(new ArrayList<>());
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPaymentWithSameToken(String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  void testCartHasCreditCardPaymentWithSameToken_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasCreditCardPaymentWithSameTokenResult =
        cartStateServiceImpl.cartHasCreditCardPaymentWithSameToken("ABC123");

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentWithSameTokenResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    PaymentType paymentType = new PaymentType("Temporary", "Temporary", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName(
      "Test cartHasTemporaryCreditCard(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard(); then calls isCreditCardType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasTemporaryCreditCard(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  void testCartHasTemporaryCreditCard_thenReturnTrue() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Temporary", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasTemporaryCreditCardResult =
        cartStateServiceImpl.cartHasTemporaryCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasTemporaryCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  void testCartHasCreditCardPayment() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentResult = cartStateServiceImpl.cartHasCreditCardPayment();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  void testCartHasCreditCardPayment2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    PaymentType paymentType = new PaymentType("Type", "Friendly Type", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentResult = cartStateServiceImpl.cartHasCreditCardPayment();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasCreditCardPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  void testCartHasCreditCardPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentResult = cartStateServiceImpl.cartHasCreditCardPayment();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  void testCartHasCreditCardPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasCreditCardPaymentResult = cartStateServiceImpl.cartHasCreditCardPayment();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasCreditCardPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @DisplayName("Test cartHasCreditCardPayment(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  void testCartHasCreditCardPayment_thenReturnTrue() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasCreditCardPaymentResult = cartStateServiceImpl.cartHasCreditCardPayment();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasCreditCardPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName(
      "Test cartHasThirdPartyPayment(); given ArrayList() add OrderPaymentImpl (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment(); given OrderPaymentImpl getType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment_givenOrderPaymentImplGetTypeReturnNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(null);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @DisplayName("Test cartHasThirdPartyPayment(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  void testCartHasThirdPartyPayment_thenReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    PaymentType paymentType = new PaymentType("THIRD_PARTY_ACCOUNT", "THIRD_PARTY_ACCOUNT", true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasThirdPartyPaymentResult = cartStateServiceImpl.cartHasThirdPartyPayment();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasThirdPartyPaymentResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    PaymentType paymentType = new PaymentType("Temporary", "Temporary", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard3() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Temporary", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName(
      "Test cartHasUnconfirmedCreditCard(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertFalse(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @DisplayName("Test cartHasUnconfirmedCreditCard(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  void testCartHasUnconfirmedCreditCard_thenReturnTrue() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualCartHasUnconfirmedCreditCardResult =
        cartStateServiceImpl.cartHasUnconfirmedCreditCard();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertTrue(actualCartHasUnconfirmedCreditCardResult);
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    OrderPayment actualUnconfirmedCCFromCart = cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualUnconfirmedCCFromCart);
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    PaymentType paymentType = new PaymentType("Temporary", "Temporary", true, true);
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart3() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Temporary", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    OrderPayment actualUnconfirmedCCFromCart = cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualUnconfirmedCCFromCart);
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getGatewayType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName(
      "Test getUnconfirmedCCFromCart(); given OrderPaymentImpl getGatewayType() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart_givenOrderPaymentImplGetGatewayTypeReturnNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    OrderPayment actualUnconfirmedCCFromCart = cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualUnconfirmedCCFromCart);
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart(); given OrderPaymentImpl isActive() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    OrderPayment actualUnconfirmedCCFromCart = cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualUnconfirmedCCFromCart);
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart(); then calls isCreditCardType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType())
        .thenReturn(new PaymentGatewayType("Type", "Friendly Type"));
    when(orderPaymentImpl.getType()).thenReturn(paymentType);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getGatewayType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
  }

  /**
   * Test {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @DisplayName("Test getUnconfirmedCCFromCart(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  void testGetUnconfirmedCCFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    OrderPayment actualUnconfirmedCCFromCart = cartStateServiceImpl.getUnconfirmedCCFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualUnconfirmedCCFromCart);
  }
}
