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
package org.broadleafcommerce.core.web;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.View;

class WrappingViewResolverDiffblueTest {
  /**
   * Test {@link WrappingViewResolver#resolveViewName(String, Locale)}.
   * <p>
   * Method under test:
   * {@link WrappingViewResolver#resolveViewName(String, Locale)}
   */
  @Test
  @DisplayName("Test resolveViewName(String, Locale)")
  void testResolveViewName() throws Exception {
    // Arrange
    View view = mock(View.class);
    doNothing().when(view)
        .render(Mockito.<Map<String, Object>>any(), Mockito.<HttpServletRequest>any(),
            Mockito.<HttpServletResponse>any());
    WrappingViewResolver wrappingViewResolver = new WrappingViewResolver(view);

    // Act
    View actualResolveViewNameResult = wrappingViewResolver.resolveViewName("Arg0", Locale.getDefault());
    HashMap<String, Object> model = new HashMap<>();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();
    actualResolveViewNameResult.render(model, request, response);

    // Assert
    verify(view).render(isA(Map.class), isA(HttpServletRequest.class), isA(HttpServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertTrue(headerNames.isEmpty());
  }
}
