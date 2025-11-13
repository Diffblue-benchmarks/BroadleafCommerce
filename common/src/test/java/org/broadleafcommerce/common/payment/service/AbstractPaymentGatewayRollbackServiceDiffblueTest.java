package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayRollbackServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayRollbackService#rollbackAuthorize(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayRollbackService#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayRollbackService.rollbackAuthorize(PaymentRequestDTO)"
  })
  public void testRollbackAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService =
        new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayRollbackService#rollbackCapture(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayRollbackService#rollbackCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayRollbackService.rollbackCapture(PaymentRequestDTO)"
  })
  public void testRollbackCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService =
        new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackCapture(new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayRollbackService#rollbackAuthorizeAndCapture(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayRollbackService#rollbackAuthorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayRollbackService.rollbackAuthorizeAndCapture(PaymentRequestDTO)"
  })
  public void testRollbackAuthorizeAndCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService =
        new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayRollbackService.rollbackAuthorizeAndCapture(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayRollbackService#rollbackRefund(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayRollbackService#rollbackRefund(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayRollbackService.rollbackRefund(PaymentRequestDTO)"
  })
  public void testRollbackRefund() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService =
        new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackRefund(new PaymentRequestDTO()));
  }
}
