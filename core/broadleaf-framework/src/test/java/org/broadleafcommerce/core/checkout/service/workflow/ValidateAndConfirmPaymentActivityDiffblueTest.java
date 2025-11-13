package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.checkout.service.workflow.ValidateAndConfirmPaymentActivity.ResponseTransactionPair;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.domain.PaymentTransaction;
import org.broadleafcommerce.core.payment.domain.PaymentTransactionImpl;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ValidateAndConfirmPaymentActivityDiffblueTest {
  /**
   * Test {@link ValidateAndConfirmPaymentActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAndConfirmPaymentActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAndConfirmPaymentActivity.execute(ProcessContext)"})
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity =
        new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler());

    OrderPaymentImpl orderPaymentImpl = mock(OrderPaymentImpl.class);
    when(orderPaymentImpl.getTransactions()).thenThrow(new IllegalArgumentException());
    when(orderPaymentImpl.isActive()).thenReturn(true);

    ArrayList<OrderPayment> payments = new ArrayList<>();
    payments.add(orderPaymentImpl);

    OrderImpl order = new OrderImpl();
    order.setPayments(payments);
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAndConfirmPaymentActivity.execute(context));
    verify(orderPaymentImpl).getTransactions();
    verify(orderPaymentImpl).isActive();
  }

  /**
   * Test ResponseTransactionPair getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity,
   *       PaymentResponseDTO, Long)}
   *   <li>{@link ResponseTransactionPair#getResponseDTO()}
   *   <li>{@link ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity)",
    "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)",
    "PaymentResponseDTO ResponseTransactionPair.getResponseDTO()",
    "Long ResponseTransactionPair.getTransactionId()"
  })
  public void testResponseTransactionPairGettersAndSetters() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity =
        new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act
    ResponseTransactionPair actualResponseTransactionPair =
        validateAndConfirmPaymentActivity.new ResponseTransactionPair(responseDTO, 1L);
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertEquals(1L, actualResponseTransactionPair.getTransactionId().longValue());
    assertSame(responseDTO, actualResponseDTO);
  }

  /**
   * Test ResponseTransactionPair getters and setters.
   *
   * <ul>
   *   <li>Then return TransactionId is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       ResponseTransactionPair#ResponseTransactionPair(ValidateAndConfirmPaymentActivity)}
   *   <li>{@link ResponseTransactionPair#getResponseDTO()}
   *   <li>{@link ResponseTransactionPair#getTransactionId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity)",
    "void ResponseTransactionPair.<init>(ValidateAndConfirmPaymentActivity, PaymentResponseDTO, Long)",
    "PaymentResponseDTO ResponseTransactionPair.getResponseDTO()",
    "Long ResponseTransactionPair.getTransactionId()"
  })
  public void testResponseTransactionPairGettersAndSetters_thenReturnTransactionIdIsNull() {
    // Arrange and Act
    ResponseTransactionPair actualResponseTransactionPair =
        new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())
        .new ResponseTransactionPair();
    PaymentResponseDTO actualResponseDTO = actualResponseTransactionPair.getResponseDTO();

    // Assert
    assertNull(actualResponseTransactionPair.getTransactionId());
    assertNull(actualResponseDTO);
  }

  /**
   * Test {@link
   * ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}.
   *
   * <p>Method under test: {@link
   * ValidateAndConfirmPaymentActivity#shouldRollbackFailedTransaction(ResponseTransactionPair)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(ResponseTransactionPair)"
  })
  public void testShouldRollbackFailedTransaction() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity =
        new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertFalse(
        validateAndConfirmPaymentActivity.shouldRollbackFailedTransaction(
            new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler())
            .new ResponseTransactionPair()));
  }

  /**
   * Test {@link ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateAndConfirmPaymentActivity#createCustomerPaymentToken(PaymentTransaction)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.profile.core.domain.CustomerPayment ValidateAndConfirmPaymentActivity.createCustomerPaymentToken(PaymentTransaction)"
  })
  public void testCreateCustomerPaymentToken_thenReturnNull() {
    // Arrange
    ValidateAndConfirmPaymentActivity validateAndConfirmPaymentActivity =
        new ValidateAndConfirmPaymentActivity(new ConfirmPaymentsRollbackHandler());

    // Act and Assert
    assertNull(
        validateAndConfirmPaymentActivity.createCustomerPaymentToken(new PaymentTransactionImpl()));
  }
}
