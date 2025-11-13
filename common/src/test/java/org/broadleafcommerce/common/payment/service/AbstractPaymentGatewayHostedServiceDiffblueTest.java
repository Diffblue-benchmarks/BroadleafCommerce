package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayHostedServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayHostedService#requestHostedEndpoint(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayHostedService#requestHostedEndpoint(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayHostedService.requestHostedEndpoint(PaymentRequestDTO)"
  })
  public void testRequestHostedEndpoint() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayHostedService abstractPaymentGatewayHostedService =
        new AbstractPaymentGatewayHostedService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayHostedService.requestHostedEndpoint(new PaymentRequestDTO()));
  }
}
