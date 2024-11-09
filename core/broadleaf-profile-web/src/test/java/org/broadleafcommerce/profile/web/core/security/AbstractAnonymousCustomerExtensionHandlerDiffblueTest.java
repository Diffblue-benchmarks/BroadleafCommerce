/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.core.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class AbstractAnonymousCustomerExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractAnonymousCustomerExtensionHandler#getAnonymousCustomer(ExtensionResultHolder, WebRequest)}.
   * <p>
   * Method under test:
   * {@link AbstractAnonymousCustomerExtensionHandler#getAnonymousCustomer(ExtensionResultHolder, WebRequest)}
   */
  @Test
  @DisplayName("Test getAnonymousCustomer(ExtensionResultHolder, WebRequest)")
  void testGetAnonymousCustomer() {
    // Arrange
    AbstractAnonymousCustomerExtensionHandler abstractAnonymousCustomerExtensionHandler = new AbstractAnonymousCustomerExtensionHandler();

    ExtensionResultHolder<Customer> customerHolder = new ExtensionResultHolder<>();
    customerHolder.setResult(new CustomerImpl());
    customerHolder.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAnonymousCustomerExtensionHandler
        .getAnonymousCustomer(customerHolder, new ServletWebRequest(new MockHttpServletRequest())));
  }

  /**
   * Test new {@link AbstractAnonymousCustomerExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAnonymousCustomerExtensionHandler}
   */
  @Test
  @DisplayName("Test new AbstractAnonymousCustomerExtensionHandler (default constructor)")
  void testNewAbstractAnonymousCustomerExtensionHandler() {
    // Arrange and Act
    AbstractAnonymousCustomerExtensionHandler actualAbstractAnonymousCustomerExtensionHandler = new AbstractAnonymousCustomerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAnonymousCustomerExtensionHandler.getPriority());
    assertTrue(actualAbstractAnonymousCustomerExtensionHandler.isEnabled());
  }
}
