package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayTransactionConfirmationServiceDiffblueTest {
  /**
   * Test {@link
   * AbstractPaymentGatewayTransactionConfirmationService#confirmTransaction(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransactionConfirmationService#confirmTransaction(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayTransactionConfirmationService.confirmTransaction(PaymentRequestDTO)"
  })
  public void testConfirmTransaction() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionConfirmationService
        abstractPaymentGatewayTransactionConfirmationService =
            new AbstractPaymentGatewayTransactionConfirmationService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransactionConfirmationService.confirmTransaction(
                new PaymentRequestDTO()));
  }
}
