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
package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CartStateInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CartStateInterceptor}
   *   <li>{@link CartStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CartStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CartStateInterceptor actualCartStateInterceptor = new CartStateInterceptor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    ServletWebRequest request = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
    actualCartStateInterceptor.afterCompletion(request, new Exception("foo"));
    MockHttpServletRequest servletRequest2 = new MockHttpServletRequest();
    ServletWebRequest request2 = new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest2,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));
    actualCartStateInterceptor.postHandle(request2, new ModelMap());

    // Assert that nothing has changed
    assertNull(actualCartStateInterceptor.cartStateProcessor);
  }
}
