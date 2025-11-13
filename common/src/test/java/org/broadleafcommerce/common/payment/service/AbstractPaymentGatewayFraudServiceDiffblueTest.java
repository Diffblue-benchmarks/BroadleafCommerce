package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayFraudServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayFraudService#requestPayerAuthentication(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayFraudService#requestPayerAuthentication(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayFraudService.requestPayerAuthentication(PaymentRequestDTO)"
  })
  public void testRequestPayerAuthentication() {
    // Arrange
    AbstractPaymentGatewayFraudService abstractPaymentGatewayFraudService =
        new AbstractPaymentGatewayFraudService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayFraudService.requestPayerAuthentication(new PaymentRequestDTO()));
  }
}
