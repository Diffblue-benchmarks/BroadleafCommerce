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

public class AbstractPaymentGatewayCreditCardServiceDiffblueTest {
  /**
   * Test
   * {@link AbstractPaymentGatewayCreditCardService#createGatewayCreditCard(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCreditCardService#createGatewayCreditCard(PaymentRequestDTO)}
   */
  @Test
  public void testCreateGatewayCreditCard() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCreditCardService abstractPaymentGatewayCreditCardService = new AbstractPaymentGatewayCreditCardService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCreditCardService.createGatewayCreditCard(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayCreditCardService#updateGatewayCreditCard(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCreditCardService#updateGatewayCreditCard(PaymentRequestDTO)}
   */
  @Test
  public void testUpdateGatewayCreditCard() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCreditCardService abstractPaymentGatewayCreditCardService = new AbstractPaymentGatewayCreditCardService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCreditCardService.updateGatewayCreditCard(new PaymentRequestDTO()));
  }

  /**
   * Test
   * {@link AbstractPaymentGatewayCreditCardService#deleteGatewayCreditCard(PaymentRequestDTO)}.
   * <p>
   * Method under test:
   * {@link AbstractPaymentGatewayCreditCardService#deleteGatewayCreditCard(PaymentRequestDTO)}
   */
  @Test
  public void testDeleteGatewayCreditCard() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayCreditCardService abstractPaymentGatewayCreditCardService = new AbstractPaymentGatewayCreditCardService();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> abstractPaymentGatewayCreditCardService.deleteGatewayCreditCard(new PaymentRequestDTO()));
  }
}
