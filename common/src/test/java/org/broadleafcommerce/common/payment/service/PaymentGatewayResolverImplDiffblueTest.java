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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class PaymentGatewayResolverImplDiffblueTest {
  /**
   * Test
   * {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@link PaymentGatewayType#PASSTHROUGH}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}
   */
  @Test
  public void testIsHandlerCompatible_whenPassthrough() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentGatewayResolverImpl()).isHandlerCompatible(PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test
   * {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}.
   * <ul>
   *   <li>When {@link PaymentGatewayType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}
   */
  @Test
  public void testIsHandlerCompatible_whenPaymentGatewayType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PaymentGatewayResolverImpl()).isHandlerCompatible(mock(PaymentGatewayType.class)));
  }

  /**
   * Test {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}
   */
  @Test
  public void testResolvePaymentGateway() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayResolverImpl paymentGatewayResolverImpl = new PaymentGatewayResolverImpl();

    // Act and Assert
    assertNull(paymentGatewayResolverImpl.resolvePaymentGateway(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}
   */
  @Test
  public void testResolvePaymentGateway2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentGatewayResolverImpl paymentGatewayResolverImpl = new PaymentGatewayResolverImpl();

    // Act and Assert
    assertNull(paymentGatewayResolverImpl.resolvePaymentGateway(new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class)))));
  }
}
