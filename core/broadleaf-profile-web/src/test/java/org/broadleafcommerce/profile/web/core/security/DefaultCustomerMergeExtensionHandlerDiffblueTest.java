/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class DefaultCustomerMergeExtensionHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultCustomerMergeExtensionHandler#merge(ExtensionResultHolder, WebRequest, Customer)}
   */
  @Test
  void testMerge() {
    // Arrange
    DefaultCustomerMergeExtensionHandler defaultCustomerMergeExtensionHandler = new DefaultCustomerMergeExtensionHandler();

    ExtensionResultHolder<Customer> customerHolder = new ExtensionResultHolder<>();
    customerHolder.setResult(new CustomerImpl());
    customerHolder.setThrowable(new Throwable());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        defaultCustomerMergeExtensionHandler.merge(customerHolder, request, new CustomerImpl()));
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link DefaultCustomerMergeExtensionHandler}
   */
  @Test
  void testNewDefaultCustomerMergeExtensionHandler() {
    // Arrange and Act
    DefaultCustomerMergeExtensionHandler actualDefaultCustomerMergeExtensionHandler = new DefaultCustomerMergeExtensionHandler();

    // Assert
    assertEquals(0, actualDefaultCustomerMergeExtensionHandler.getPriority());
    assertTrue(actualDefaultCustomerMergeExtensionHandler.isEnabled());
  }
}
