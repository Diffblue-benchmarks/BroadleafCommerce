/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.order.security;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CartStateInterceptorDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CartStateInterceptor}
   *   <li>{@link CartStateInterceptor#afterCompletion(WebRequest, Exception)}
   *   <li>{@link CartStateInterceptor#postHandle(WebRequest, ModelMap)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CartStateInterceptor.<init>()",
    "void CartStateInterceptor.afterCompletion(WebRequest, Exception)",
    "void CartStateInterceptor.postHandle(WebRequest, ModelMap)"
  })
  void testGettersAndSetters() throws Exception {
    // Arrange and Act
    CartStateInterceptor actualCartStateInterceptor = new CartStateInterceptor();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);
    actualCartStateInterceptor.afterCompletion(request2, new Exception());
    HttpServletRequestWrapper request3 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request4 = new ServletWebRequest(request3);
    actualCartStateInterceptor.postHandle(request4, new ModelMap());

    // Assert
    assertNull(actualCartStateInterceptor.cartStateProcessor);
  }
}
