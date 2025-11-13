package org.broadleafcommerce.core.web.order.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CartStateServiceImplDiffblueTest {
  @InjectMocks private CartStateServiceImpl cartStateServiceImpl;

  @Mock private OrderPaymentService orderPaymentService;

  /**
   * Test {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}.
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  public void testCartHasPopulatedBillingAddress() {
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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  public void testCartHasPopulatedBillingAddress_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasPopulatedBillingAddress()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  public void testCartHasPopulatedBillingAddress_givenOrderPaymentImplIsActiveReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  public void testCartHasPopulatedBillingAddress_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasPopulatedBillingAddress()"})
  public void testCartHasPopulatedBillingAddress_thenReturnTrue() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  public void testCartHasCreditCardPaymentWithSameToken() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  public void testCartHasCreditCardPaymentWithSameToken2() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    ArrayList<PaymentTransaction> paymentTransactionList = new ArrayList<>();
    paymentTransactionList.add(new PaymentTransactionImpl());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenReturn(paymentTransactionList);
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
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  public void testCartHasCreditCardPaymentWithSameToken3() {
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
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CartStateServiceImpl#cartHasCreditCardPaymentWithSameToken(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  public void testCartHasCreditCardPaymentWithSameToken_thenCallsIsCreditCardType() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPaymentWithSameToken(String)"})
  public void testCartHasCreditCardPaymentWithSameToken_thenReturnFalse() {
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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getGatewayType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  public void testCartHasTemporaryCreditCard_givenOrderPaymentImplGetGatewayTypeReturnNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasTemporaryCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  public void testCartHasTemporaryCreditCard_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  public void testCartHasTemporaryCreditCard_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  public void testCartHasTemporaryCreditCard_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasTemporaryCreditCard()"})
  public void testCartHasTemporaryCreditCard_thenReturnFalse() {
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
   * Test {@link CartStateServiceImpl#cartHasCreditCardPayment()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  public void testCartHasCreditCardPayment_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasCreditCardPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  public void testCartHasCreditCardPayment_givenOrderPaymentImplIsActiveReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  public void testCartHasCreditCardPayment_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasCreditCardPayment()"})
  public void testCartHasCreditCardPayment_thenReturnTrue() {
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  public void testCartHasThirdPartyPayment_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
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
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  public void testCartHasThirdPartyPayment_givenOrderPaymentImplIsActiveReturnFalse() {
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
   *   <li>Then calls {@link OrderPaymentImpl#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  public void testCartHasThirdPartyPayment_thenCallsGetType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
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
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasThirdPartyPayment()"})
  public void testCartHasThirdPartyPayment_thenReturnFalse() {
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
   * Test {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getGatewayType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  public void testCartHasUnconfirmedCreditCard_givenOrderPaymentImplGetGatewayTypeReturnNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  public void testCartHasUnconfirmedCreditCard_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#cartHasUnconfirmedCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  public void testCartHasUnconfirmedCreditCard_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  public void testCartHasUnconfirmedCreditCard_thenReturnFalse() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CartStateServiceImpl.cartHasUnconfirmedCreditCard()"})
  public void testCartHasUnconfirmedCreditCard_thenReturnTrue() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getGatewayType()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  public void testGetUnconfirmedCCFromCart_givenOrderPaymentImplGetGatewayTypeReturnNull() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(null);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link CartStateServiceImpl#getUnconfirmedCCFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  public void testGetUnconfirmedCCFromCart_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  public void testGetUnconfirmedCCFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  public void testGetUnconfirmedCCFromCart_thenCallsIsCreditCardType() {
    // Arrange
    PaymentType paymentType = mock(PaymentType.class);
    when(paymentType.isCreditCardType()).thenReturn(true);

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getGatewayType()).thenReturn(new PaymentGatewayType());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPayment CartStateServiceImpl.getUnconfirmedCCFromCart()"})
  public void testGetUnconfirmedCCFromCart_thenReturnNull() {
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
