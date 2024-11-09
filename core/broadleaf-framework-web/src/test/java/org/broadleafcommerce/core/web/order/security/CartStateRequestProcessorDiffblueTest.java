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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

class CartStateRequestProcessorDiffblueTest {
  /**
   * Test
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#updateCartRequestAttributes(WebRequest, Order)}
   */
  @Test
  @DisplayName("Test updateCartRequestAttributes(WebRequest, Order); given HashMap(); then calls getAttribute(String, int)")
  void testUpdateCartRequestAttributes_givenHashMap_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(new HashMap<>());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    cartStateRequestProcessor.updateCartRequestAttributes(request, new NullOrderImpl());

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), eq(0));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  void testGetOverrideCart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull(cartStateRequestProcessor
        .getOverrideCart(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest)")
  void testGetOverrideCart2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();

    // Act and Assert
    assertNull(cartStateRequestProcessor.getOverrideCart(
        new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
            mock(Environment.class), new String[]{"White List Param Names"})))));
  }

  /**
   * Test {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link RequestAttributes#getAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CartStateRequestProcessor#getOverrideCart(WebRequest)}
   */
  @Test
  @DisplayName("Test getOverrideCart(WebRequest); given 'false'; then calls getAttribute(String, int)")
  void testGetOverrideCart_givenFalse_thenCallsGetAttribute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CartStateRequestProcessor cartStateRequestProcessor = new CartStateRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    Order actualOverrideCart = cartStateRequestProcessor.getOverrideCart(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    assertNull(actualOverrideCart);
  }
}
