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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;

public class AbstractPaymentGatewayWebResponseServiceDiffblueTest {
  /**
   * Test {@link AbstractPaymentGatewayWebResponseService#translateWebResponse(HttpServletRequest)}.
   *
   * <p>Method under test: {@link
   * AbstractPaymentGatewayWebResponseService#translateWebResponse(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.common.payment.dto.PaymentResponseDTO AbstractPaymentGatewayWebResponseService.translateWebResponse(HttpServletRequest)"
  })
  public void testTranslateWebResponse() throws PaymentException {
    // Arrange
    AbstractPaymentGatewayWebResponseService abstractPaymentGatewayWebResponseService =
        new AbstractPaymentGatewayWebResponseService();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            abstractPaymentGatewayWebResponseService.translateWebResponse(
                new HttpServletRequestWrapper(
                    new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }
}
