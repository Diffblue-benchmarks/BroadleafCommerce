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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {PaymentGatewayResolverImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayResolverImplDiffblueTest {
  @Autowired private PaymentGatewayResolverImpl paymentGatewayResolverImpl;

  /**
   * Test {@link PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}.
   *
   * <p>Method under test: {@link
   * PaymentGatewayResolverImpl#isHandlerCompatible(PaymentGatewayType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentGatewayResolverImpl.isHandlerCompatible(PaymentGatewayType)"})
  public void testIsHandlerCompatible() {
    // Arrange, Act and Assert
    assertTrue(paymentGatewayResolverImpl.isHandlerCompatible(PaymentGatewayType.PASSTHROUGH));
  }

  /**
   * Test {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}.
   *
   * <p>Method under test: {@link PaymentGatewayResolverImpl#resolvePaymentGateway(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentGatewayType PaymentGatewayResolverImpl.resolvePaymentGateway(WebRequest)"
  })
  public void testResolvePaymentGateway() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertNull(paymentGatewayResolverImpl.resolvePaymentGateway(new ServletWebRequest(request)));
  }
}
