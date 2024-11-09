/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order.security.extension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

class AbstractAuthSuccessHandlerExtensionHandlerDiffblueTest {
  /**
   * Test
   * {@link AbstractAuthSuccessHandlerExtensionHandler#preMergeCartExecution(HttpServletRequest, HttpServletResponse, Authentication)}.
   * <p>
   * Method under test:
   * {@link AbstractAuthSuccessHandlerExtensionHandler#preMergeCartExecution(HttpServletRequest, HttpServletResponse, Authentication)}
   */
  @Test
  @DisplayName("Test preMergeCartExecution(HttpServletRequest, HttpServletResponse, Authentication)")
  void testPreMergeCartExecution() {
    // Arrange
    AbstractAuthSuccessHandlerExtensionHandler abstractAuthSuccessHandlerExtensionHandler = new AbstractAuthSuccessHandlerExtensionHandler();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractAuthSuccessHandlerExtensionHandler
        .preMergeCartExecution(request, response, new TestingAuthenticationToken("Principal", "Credentials")));
  }

  /**
   * Test new {@link AbstractAuthSuccessHandlerExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractAuthSuccessHandlerExtensionHandler}
   */
  @Test
  @DisplayName("Test new AbstractAuthSuccessHandlerExtensionHandler (default constructor)")
  void testNewAbstractAuthSuccessHandlerExtensionHandler() {
    // Arrange and Act
    AbstractAuthSuccessHandlerExtensionHandler actualAbstractAuthSuccessHandlerExtensionHandler = new AbstractAuthSuccessHandlerExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractAuthSuccessHandlerExtensionHandler.getPriority());
    assertTrue(actualAbstractAuthSuccessHandlerExtensionHandler.isEnabled());
  }
}
