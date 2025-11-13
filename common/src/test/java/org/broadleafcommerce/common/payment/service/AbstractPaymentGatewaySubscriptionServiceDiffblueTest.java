package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewaySubscriptionServiceDiffblueTest {
  /**
   * Test {@link
   * AbstractPaymentGatewaySubscriptionService#createGatewaySubscription(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewaySubscriptionService#createGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewaySubscriptionService.createGatewaySubscription(PaymentRequestDTO)"
  })
  public void testCreateGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService =
        new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewaySubscriptionService.createGatewaySubscription(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewaySubscriptionService#updateGatewaySubscription(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewaySubscriptionService#updateGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewaySubscriptionService.updateGatewaySubscription(PaymentRequestDTO)"
  })
  public void testUpdateGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService =
        new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewaySubscriptionService.updateGatewaySubscription(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewaySubscriptionService#cancelGatewaySubscription(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewaySubscriptionService#cancelGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewaySubscriptionService.cancelGatewaySubscription(PaymentRequestDTO)"
  })
  public void testCancelGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService =
        new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewaySubscriptionService.cancelGatewaySubscription(
                new PaymentRequestDTO()));
  }
}
