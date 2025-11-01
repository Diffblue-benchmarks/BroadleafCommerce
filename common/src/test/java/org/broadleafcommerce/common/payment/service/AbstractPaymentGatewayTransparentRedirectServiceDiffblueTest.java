/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.payment.service;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;

public class AbstractPaymentGatewayTransparentRedirectServiceDiffblueTest {
  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#createAuthorizeForm(PaymentRequestDTO)}
   */
  @Test
  public void testCreateAuthorizeForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.createAuthorizeForm(new PaymentRequestDTO()));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#createAuthorizeAndCaptureForm(PaymentRequestDTO)}
   */
  @Test
  public void testCreateAuthorizeAndCaptureForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.createAuthorizeAndCaptureForm(new PaymentRequestDTO()));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#createCustomerPaymentTokenForm(PaymentRequestDTO)}
   */
  @Test
  public void testCreateCustomerPaymentTokenForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.createCustomerPaymentTokenForm(new PaymentRequestDTO()));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#updateCustomerPaymentTokenForm(PaymentRequestDTO)}
   */
  @Test
  public void testUpdateCustomerPaymentTokenForm() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.updateCustomerPaymentTokenForm(new PaymentRequestDTO()));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  public void testGetCreateCustomerPaymentTokenReturnURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.getCreateCustomerPaymentTokenReturnURLFieldKey(
            new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#getCreateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  public void testGetCreateCustomerPaymentTokenCancelURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.getCreateCustomerPaymentTokenCancelURLFieldKey(
            new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenReturnURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  public void testGetUpdateCustomerPaymentTokenReturnURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.getUpdateCustomerPaymentTokenReturnURLFieldKey(
            new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }

  /**
   * Method under test:
   * {@link AbstractPaymentGatewayTransparentRedirectService#getUpdateCustomerPaymentTokenCancelURLFieldKey(PaymentResponseDTO)}
   */
  @Test
  public void testGetUpdateCustomerPaymentTokenCancelURLFieldKey() {
    // Arrange
    AbstractPaymentGatewayTransparentRedirectService abstractPaymentGatewayTransparentRedirectService = new AbstractPaymentGatewayTransparentRedirectService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransparentRedirectService.getUpdateCustomerPaymentTokenCancelURLFieldKey(
            new PaymentResponseDTO(PaymentType.APPLE_PAY, PaymentGatewayType.PASSTHROUGH)));
  }
}
