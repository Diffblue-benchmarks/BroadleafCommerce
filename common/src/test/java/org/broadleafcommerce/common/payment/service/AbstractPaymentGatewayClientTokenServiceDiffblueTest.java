package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayClientTokenServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayClientTokenService#generateClientToken(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayClientTokenService#generateClientToken(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayClientTokenService.generateClientToken(PaymentRequestDTO)"
  })
  public void testGenerateClientToken() {
    // Arrange
    AbstractPaymentGatewayClientTokenService abstractPaymentGatewayClientTokenService =
        new AbstractPaymentGatewayClientTokenService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayClientTokenService.generateClientToken(new PaymentRequestDTO()));
  }
}
