package org.broadleafcommerce.core.web.expression.checkout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentMethodVariableExpressionDiffblueTest {
  @Mock private CartStateService cartStateService;

  @Mock private OrderPaymentService orderPaymentService;

  @InjectMocks private PaymentMethodVariableExpression paymentMethodVariableExpression;

  /**
   * Test {@link PaymentMethodVariableExpression#getName()}.
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getName()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("paymentMethod", new PaymentMethodVariableExpression().getName());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}.
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getPaymentRequestDTO()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentRequestDTO PaymentMethodVariableExpression.getPaymentRequestDTO()"
  })
  public void testGetPaymentRequestDTO() {
    // Arrange, Act and Assert
    assertNull(new PaymentMethodVariableExpression().getPaymentRequestDTO());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenNullOrderImpl_thenReturnTrue() {
    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression =
        new PaymentMethodVariableExpression();

    // Act and Assert
    assertTrue(paymentMethodVariableExpression.isNullOrder(new NullOrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new PaymentMethodVariableExpression().isNullOrder(null));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#isNullOrder(Order)}.
   *
   * <ul>
   *   <li>When {@link OrderImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#isNullOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.isNullOrder(Order)"})
  public void testIsNullOrder_whenOrderImpl_thenReturnFalse() {
    // Arrange
    PaymentMethodVariableExpression paymentMethodVariableExpression =
        new PaymentMethodVariableExpression();

    // Act and Assert
    assertFalse(paymentMethodVariableExpression.isNullOrder(new OrderImpl()));
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsThirdPartyPayment()"})
  public void testCartContainsThirdPartyPayment_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(false);

    // Act
    boolean actualCartContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.cartContainsThirdPartyPayment();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    assertFalse(actualCartContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsThirdPartyPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsThirdPartyPayment()"})
  public void testCartContainsThirdPartyPayment_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasThirdPartyPayment()).thenReturn(true);

    // Act
    boolean actualCartContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.cartContainsThirdPartyPayment();

    // Assert
    verify(cartStateService).cartHasThirdPartyPayment();
    assertTrue(actualCartContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsCreditCardPayment()"})
  public void testCartContainsCreditCardPayment_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasCreditCardPayment()).thenReturn(false);

    // Act
    boolean actualCartContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.cartContainsCreditCardPayment();

    // Assert
    verify(cartStateService).cartHasCreditCardPayment();
    assertFalse(actualCartContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsCreditCardPayment()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsCreditCardPayment()"})
  public void testCartContainsCreditCardPayment_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasCreditCardPayment()).thenReturn(true);

    // Act
    boolean actualCartContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.cartContainsCreditCardPayment();

    // Assert
    verify(cartStateService).cartHasCreditCardPayment();
    assertTrue(actualCartContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsTemporaryCreditCard()"})
  public void testCartContainsTemporaryCreditCard_thenReturnFalse() {
    // Arrange
    when(cartStateService.cartHasTemporaryCreditCard()).thenReturn(false);

    // Act
    boolean actualCartContainsTemporaryCreditCardResult =
        paymentMethodVariableExpression.cartContainsTemporaryCreditCard();

    // Assert
    verify(cartStateService).cartHasTemporaryCreditCard();
    assertFalse(actualCartContainsTemporaryCreditCardResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#cartContainsTemporaryCreditCard()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.cartContainsTemporaryCreditCard()"})
  public void testCartContainsTemporaryCreditCard_thenReturnTrue() {
    // Arrange
    when(cartStateService.cartHasTemporaryCreditCard()).thenReturn(true);

    // Act
    boolean actualCartContainsTemporaryCreditCardResult =
        paymentMethodVariableExpression.cartContainsTemporaryCreditCard();

    // Assert
    verify(cartStateService).cartHasTemporaryCreditCard();
    assertTrue(actualCartContainsTemporaryCreditCardResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  public void testOrderContainsCODPayment_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult =
        paymentMethodVariableExpression.orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  public void testOrderContainsCODPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult =
        paymentMethodVariableExpression.orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  public void testOrderContainsCODPayment_givenOrderPaymentImplIsActiveReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCODPaymentResult =
        paymentMethodVariableExpression.orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsCODPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentMethodVariableExpression.orderContainsCODPayment(Order)"})
  public void testOrderContainsCODPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsCODPaymentResult =
        paymentMethodVariableExpression.orderContainsCODPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCODPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"
  })
  public void testOrderContainsCreditCardPayment_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"
  })
  public void testOrderContainsCreditCardPayment_givenOrderPaymentImplIsActiveReturnFalse() {
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
    boolean actualOrderContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"
  })
  public void testOrderContainsCreditCardPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsCreditCardPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsCreditCardPayment(Order)"
  })
  public void testOrderContainsCreditCardPayment_thenReturnTrue() {
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
    boolean actualOrderContainsCreditCardPaymentResult =
        paymentMethodVariableExpression.orderContainsCreditCardPayment(new NullOrderImpl());

    // Assert
    verify(paymentType).isCreditCardType();
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsCreditCardPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"
  })
  public void testOrderContainsThirdPartyPayment_givenArrayListAddOrderPaymentImpl() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"
  })
  public void testOrderContainsThirdPartyPayment_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"
  })
  public void testOrderContainsThirdPartyPayment_givenOrderPaymentImplIsActiveReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#orderContainsThirdPartyPayment(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsThirdPartyPayment(Order)"
  })
  public void testOrderContainsThirdPartyPayment_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    boolean actualOrderContainsThirdPartyPaymentResult =
        paymentMethodVariableExpression.orderContainsThirdPartyPayment(new NullOrderImpl());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsThirdPartyPaymentResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(order, new PaymentType());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link OrderPaymentImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_givenArrayListAddOrderPaymentImpl_thenReturnFalse() {
    // Arrange
    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(new OrderPaymentImpl());
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(order, new PaymentType());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(order, new PaymentType());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_thenReturnTrue() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(order, new PaymentType());

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_thenReturnTrue2() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType("Type", "Friendly Type"));

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(
            order, new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertTrue(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>When {@link PaymentType}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_whenPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(
            new NullOrderImpl(), mock(PaymentType.class));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code
   *       Friendly Type}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_whenPaymentTypeWithTypeAndFriendlyType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(true);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(
            order, new PaymentType("Type", "Friendly Type"));

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order, PaymentType)}.
   *
   * <ul>
   *   <li>When {@link PaymentType#PaymentType()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#orderContainsPaymentOfType(Order,
   * PaymentType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentMethodVariableExpression.orderContainsPaymentOfType(Order, PaymentType)"
  })
  public void testOrderContainsPaymentOfType_whenPaymentType_thenReturnFalse() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    boolean actualOrderContainsPaymentOfTypeResult =
        paymentMethodVariableExpression.orderContainsPaymentOfType(order, new PaymentType());

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isA(Order.class));
    assertFalse(actualOrderContainsPaymentOfTypeResult);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}.
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getExpirationMonthOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaymentMethodVariableExpression.getExpirationMonthOptions()"})
  public void testGetExpirationMonthOptions() {
    // Arrange and Act
    List<String> actualExpirationMonthOptions =
        new PaymentMethodVariableExpression().getExpirationMonthOptions();

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
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getExpirationYearOptions()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List PaymentMethodVariableExpression.getExpirationYearOptions()"})
  public void testGetExpirationYearOptions() {
    // Arrange, Act and Assert
    assertEquals(10, new PaymentMethodVariableExpression().getExpirationYearOptions().size());
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  public void testGetCreditCardTypeFromCart_givenArrayListAddPaymentTransactionImpl() {
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
    String actualCreditCardTypeFromCart =
        paymentMethodVariableExpression.getCreditCardTypeFromCart();

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
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  public void testGetCreditCardTypeFromCart_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart =
        paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  public void testGetCreditCardTypeFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardTypeFromCart =
        paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  public void testGetCreditCardTypeFromCart_thenCallsIsCreditCardType() {
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
    String actualCreditCardTypeFromCart =
        paymentMethodVariableExpression.getCreditCardTypeFromCart();

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardTypeFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardTypeFromCart()"})
  public void testGetCreditCardTypeFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardTypeFromCart =
        paymentMethodVariableExpression.getCreditCardTypeFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardTypeFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  public void testGetCreditCardLastFourFromCart_givenArrayListAddPaymentTransactionImpl() {
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
    String actualCreditCardLastFourFromCart =
        paymentMethodVariableExpression.getCreditCardLastFourFromCart();

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
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  public void testGetCreditCardLastFourFromCart_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart =
        paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  public void testGetCreditCardLastFourFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardLastFourFromCart =
        paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  public void testGetCreditCardLastFourFromCart_thenCallsIsCreditCardType() {
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
    String actualCreditCardLastFourFromCart =
        paymentMethodVariableExpression.getCreditCardLastFourFromCart();

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardLastFourFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardLastFourFromCart()"})
  public void testGetCreditCardLastFourFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardLastFourFromCart =
        paymentMethodVariableExpression.getCreditCardLastFourFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardLastFourFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  public void testGetCreditCardExpDateFromCart_givenArrayListAddPaymentTransactionImpl() {
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
    String actualCreditCardExpDateFromCart =
        paymentMethodVariableExpression.getCreditCardExpDateFromCart();

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
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  public void testGetCreditCardExpDateFromCart_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart =
        paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  public void testGetCreditCardExpDateFromCart_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCreditCardExpDateFromCart =
        paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  public void testGetCreditCardExpDateFromCart_thenCallsIsCreditCardType() {
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
    String actualCreditCardExpDateFromCart =
        paymentMethodVariableExpression.getCreditCardExpDateFromCart();

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link PaymentMethodVariableExpression#getCreditCardExpDateFromCart()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCreditCardExpDateFromCart()"})
  public void testGetCreditCardExpDateFromCart_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    String actualCreditCardExpDateFromCart =
        paymentMethodVariableExpression.getCreditCardExpDateFromCart();

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCreditCardExpDateFromCart);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link PaymentTransactionImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  public void testGetCartOrderPaymentProperty_givenArrayListAddPaymentTransactionImpl() {
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
    String actualCartOrderPaymentProperty =
        paymentMethodVariableExpression.getCartOrderPaymentProperty("Property Name");

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
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#getType()} return {@link
   *       PaymentType#PaymentType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  public void testGetCartOrderPaymentProperty_givenOrderPaymentImplGetTypeReturnPaymentType() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getType()).thenReturn(new PaymentType());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty =
        paymentMethodVariableExpression.getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).getType();
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   *
   * <ul>
   *   <li>Given {@link OrderPaymentImpl} {@link OrderPaymentImpl#isActive()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  public void testGetCartOrderPaymentProperty_givenOrderPaymentImplIsActiveReturnFalse() {
    // Arrange
    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.isActive()).thenReturn(false);

    ArrayList<OrderPayment> orderPaymentList = new ArrayList<>();
    orderPaymentList.add(orderPaymentImpl);
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(orderPaymentList);

    // Act
    String actualCartOrderPaymentProperty =
        paymentMethodVariableExpression.getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentImpl).isActive();
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }

  /**
   * Test {@link PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentType#isCreditCardType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  public void testGetCartOrderPaymentProperty_thenCallsIsCreditCardType() {
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
    String actualCartOrderPaymentProperty =
        paymentMethodVariableExpression.getCartOrderPaymentProperty("Property Name");

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
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentMethodVariableExpression#getCartOrderPaymentProperty(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String PaymentMethodVariableExpression.getCartOrderPaymentProperty(String)"})
  public void testGetCartOrderPaymentProperty_thenReturnNull() {
    // Arrange
    when(orderPaymentService.readPaymentsForOrder(Mockito.<Order>any()))
        .thenReturn(new ArrayList<>());

    // Act
    String actualCartOrderPaymentProperty =
        paymentMethodVariableExpression.getCartOrderPaymentProperty("Property Name");

    // Assert
    verify(orderPaymentService).readPaymentsForOrder(isNull());
    assertNull(actualCartOrderPaymentProperty);
  }
}
