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

public class AbstractPaymentGatewayCustomerServiceDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewayCustomerService#createGatewayCustomer(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCustomerService#createGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  public void testCreateGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService = new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.createGatewayCustomer(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayCustomerService#updateGatewayCustomer(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCustomerService#updateGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  public void testUpdateGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService = new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.updateGatewayCustomer(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayCustomerService#deleteGatewayCustomer(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCustomerService#deleteGatewayCustomer(PaymentRequestDTO)}
   */
  @Test
  public void testDeleteGatewayCustomer() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCustomerService abstractPaymentGatewayCustomerService = new AbstractPaymentGatewayCustomerService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCustomerService.deleteGatewayCustomer(new PaymentRequestDTO()));
  }
}