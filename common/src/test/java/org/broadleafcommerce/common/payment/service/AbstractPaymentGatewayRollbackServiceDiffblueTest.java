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

public class AbstractPaymentGatewayRollbackServiceDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewayRollbackService#rollbackAuthorize(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayRollbackService#rollbackAuthorize(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorize() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService = new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackAuthorize(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayRollbackService#rollbackCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayRollbackService#rollbackCapture(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService = new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackCapture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayRollbackService#rollbackAuthorizeAndCapture(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayRollbackService#rollbackAuthorizeAndCapture(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackAuthorizeAndCapture() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService = new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackAuthorizeAndCapture(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayRollbackService#rollbackRefund(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayRollbackService#rollbackRefund(PaymentRequestDTO)}
   */
  @Test
  public void testRollbackRefund() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayRollbackService abstractPaymentGatewayRollbackService = new AbstractPaymentGatewayRollbackService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayRollbackService.rollbackRefund(new PaymentRequestDTO()));
  }
}
