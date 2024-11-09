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

public class AbstractPaymentGatewaySubscriptionServiceDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewaySubscriptionService#createGatewaySubscription(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewaySubscriptionService#createGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  public void testCreateGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService = new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewaySubscriptionService.createGatewaySubscription(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewaySubscriptionService#updateGatewaySubscription(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewaySubscriptionService#updateGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  public void testUpdateGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService = new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewaySubscriptionService.updateGatewaySubscription(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewaySubscriptionService#cancelGatewaySubscription(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewaySubscriptionService#cancelGatewaySubscription(PaymentRequestDTO)}
   */
  @Test
  public void testCancelGatewaySubscription() throws PaymentException {
    // Arrange
    AbstractPaymentGatewaySubscriptionService abstractPaymentGatewaySubscriptionService = new AbstractPaymentGatewaySubscriptionService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewaySubscriptionService.cancelGatewaySubscription(new PaymentRequestDTO()));
  }
}
