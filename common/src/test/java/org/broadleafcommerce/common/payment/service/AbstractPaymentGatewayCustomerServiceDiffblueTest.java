package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayCustomerServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayCustomerService#createGatewayCustomer(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayCustomerService#createGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayCustomerService.createGatewayCustomer(PaymentRequestDTO)"
  })
  public void testCreateGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService =
        new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.createGatewayCustomer(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayCustomerService#updateGatewayCustomer(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayCustomerService#updateGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayCustomerService.updateGatewayCustomer(PaymentRequestDTO)"
  })
  public void testUpdateGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService =
        new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.updateGatewayCustomer(new PaymentRequestDTO()));
  }

  /**
   * Test {@link AbstractPaymentGatewayCustomerService#deleteGatewayCustomer(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayCustomerService#deleteGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayCustomerService.deleteGatewayCustomer(PaymentRequestDTO)"
  })
  public void testDeleteGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService =
        new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.deleteGatewayCustomer(new PaymentRequestDTO()));
  }
}
