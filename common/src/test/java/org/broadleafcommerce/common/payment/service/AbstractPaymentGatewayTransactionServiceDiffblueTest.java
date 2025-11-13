package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayTransactionServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayTransactionService#authorize(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#authorize(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.authorize(PaymentRequestDTO)"
  })
  public void testAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.authorize(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayTransactionService#capture(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#capture(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.capture(PaymentRequestDTO)"
  })
  public void testCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.capture(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayTransactionService#authorizeAndCapture(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#authorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.authorizeAndCapture(PaymentRequestDTO)"
  })
  public void testAuthorizeAndCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransactionService.authorizeAndCapture(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayTransactionService#reverseAuthorize(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#reverseAuthorize(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.reverseAuthorize(PaymentRequestDTO)"
  })
  public void testReverseAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.reverseAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayTransactionService#refund(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#refund(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.refund(PaymentRequestDTO)"
  })
  public void testRefund() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.refund(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayTransactionService#voidPayment(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionService#voidPayment(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionService.voidPayment(PaymentRequestDTO)"
  })
  public void testVoidPayment() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService =
        new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.voidPayment(new PaymentRequestDTO()));
  }
}
