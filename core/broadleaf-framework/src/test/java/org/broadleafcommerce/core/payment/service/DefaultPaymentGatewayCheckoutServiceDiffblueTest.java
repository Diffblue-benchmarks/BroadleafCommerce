/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl;
import org.junit.Test;

public class DefaultPaymentGatewayCheckoutServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testApplyPaymentToOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testApplyPaymentToOrder2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultPaymentGatewayCheckoutService#setUseBillingAddressFromGateway(boolean)}
   *   <li>
   * {@link DefaultPaymentGatewayCheckoutService#isUseBillingAddressFromGateway()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();

    // Act
    defaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(true);

    // Assert that nothing has changed
    assertTrue(defaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway());
  }
}
