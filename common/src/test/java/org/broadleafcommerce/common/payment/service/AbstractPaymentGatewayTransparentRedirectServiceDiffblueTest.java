package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AbstractPaymentGatewayTransparentRedirectServiceDiffblueTest {
  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#createAuthorizeForm(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#createAuthorizeForm(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO AbstractPaymentGatewayTransparentRedirectService.createAuthorizeForm(PaymentRequestDTO)"
  })
  public void testCreateAuthorizeForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService.createAuthorizeForm(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#createAuthorizeAndCaptureForm(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#createAuthorizeAndCaptureForm(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO AbstractPaymentGatewayTransparentRedirectService.createAuthorizeAndCaptureForm(PaymentRequestDTO)"
  })
  public void testCreateAuthorizeAndCaptureForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService.createAuthorizeAndCaptureForm(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#createCustomerPaymentTokenForm(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#createCustomerPaymentTokenForm(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO AbstractPaymentGatewayTransparentRedirectService.createCustomerPaymentTokenForm(PaymentRequestDTO)"
  })
  public void testCreateCustomerPaymentTokenForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService.createCustomerPaymentTokenForm(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#updateCustomerPaymentTokenForm(PaymentRequestDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#updateCustomerPaymentTokenForm(PaymentRequestDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentResponseDTO AbstractPaymentGatewayTransparentRedirectService.updateCustomerPaymentTokenForm(PaymentRequestDTO)"
  })
  public void testUpdateCustomerPaymentTokenForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService.updateCustomerPaymentTokenForm(
                new PaymentRequestDTO()));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AbstractPaymentGatewayTransparentRedirectService.getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)"
  })
  public void testGetCreateCustomerPaymentTokenReturnURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService
                .getCreateCustomerPaymentTokenReturnURLFieldKey(
                    new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AbstractPaymentGatewayTransparentRedirectService.getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)"
  })
  public void testGetCreateCustomerPaymentTokenCancelURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService
                .getCreateCustomerPaymentTokenCancelURLFieldKey(
                    new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AbstractPaymentGatewayTransparentRedirectService.getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)"
  })
  public void testGetUpdateCustomerPaymentTokenReturnURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService
                .getUpdateCustomerPaymentTokenReturnURLFieldKey(
                    new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Test {@link
   * AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String AbstractPaymentGatewayTransparentRedirectService.getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)"
  })
  public void testGetUpdateCustomerPaymentTokenCancelURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService
        abstractPaymentGatewayTransparentRedirectService =
            new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayTransparentRedirectService
                .getUpdateCustomerPaymentTokenCancelURLFieldKey(
                    new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }
}
