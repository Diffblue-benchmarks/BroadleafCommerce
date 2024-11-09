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
package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CustomerStateInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerStateInterceptor}
   *   <li>{@link CustomerStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CustomerStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CustomerStateInterceptor actualCustomerStateInterceptor = new CustomerStateInterceptor();
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.afterCompletion(request, new Exception("foo"));
    ServletWebRequest request2 = new ServletWebRequest(new MockHttpServletRequest());
    actualCustomerStateInterceptor.postHandle(request2, new ModelMap());

    // Assert that nothing has changed
    assertNull(actualCustomerStateInterceptor.customerStateProcessor);
  }
}
