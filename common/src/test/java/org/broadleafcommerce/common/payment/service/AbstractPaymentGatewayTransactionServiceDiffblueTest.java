/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.junit.Test;

public class AbstractPaymentGatewayTransactionServiceDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#authorize(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#authorize(PaymentRequestDTO)}
   */
  @Test
  public void testAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.authorize(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#capture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#capture(PaymentRequestDTO)}
   */
  @Test
  public void testCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.capture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#authorizeAndCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#authorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  public void testAuthorizeAndCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.authorizeAndCapture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#reverseAuthorize(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#reverseAuthorize(PaymentRequestDTO)}
   */
  @Test
  public void testReverseAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.reverseAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#refund(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#refund(PaymentRequestDTO)}
   */
  @Test
  public void testRefund() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.refund(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayTransactionService#voidPayment(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayTransactionService#voidPayment(PaymentRequestDTO)}
   */
  @Test
  public void testVoidPayment() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayTransactionService abstractPaymentGatewayTransactionService = new AbstractPaymentGatewayTransactionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayTransactionService.voidPayment(new PaymentRequestDTO()));
  }
}
