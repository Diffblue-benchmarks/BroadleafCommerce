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
package org.broadleafcommerce.core.web.geolocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class GeolocationRequestProcessorDiffblueTest {
  /**
   * Method under test:
   * {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  void testGetIPAddress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");

    // Act
    String actualIPAddress = geolocationRequestProcessor
        .getIPAddress(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("https://example.org/example", actualIPAddress);
  }

  /**
   * Method under test:
   * {@link GeolocationRequestProcessor#getIPAddress(ServletWebRequest)}
   */
  @Test
  void testGetIPAddress2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getRemoteAddr()).thenReturn("42 Main St");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("");

    // Act
    String actualIPAddress = geolocationRequestProcessor
        .getIPAddress(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Assert
    verify(servletRequest).getRemoteAddr();
    verify(servletRequest).getHeader(eq("X-FORWARDED-FOR"));
    assertEquals("42 Main St", actualIPAddress);
  }

  /**
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  void testGetRuleMapFromRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertTrue(geolocationRequestProcessor
        .getRuleMapFromRequest(new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))))
        .isEmpty());
  }

  /**
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  void testGetRuleMapFromRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();

    // Act and Assert
    assertTrue(
        geolocationRequestProcessor
            .getRuleMapFromRequest(
                new ServletWebRequest(new SearchRequestWrapper(new XssRequestWrapper(new MockHttpServletRequest(),
                    mock(Environment.class), new String[]{"White List Param Names"}))))
            .isEmpty());
  }

  /**
   * Method under test:
   * {@link GeolocationRequestProcessor#getRuleMapFromRequest(WebRequest)}
   */
  @Test
  void testGetRuleMapFromRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    GeolocationRequestProcessor geolocationRequestProcessor = new GeolocationRequestProcessor();
    WebRequest request = mock(WebRequest.class);
    HashMap<Object, Object> objectObjectMap = new HashMap<>();
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(objectObjectMap);

    // Act
    Map<String, Object> actualRuleMapFromRequest = geolocationRequestProcessor.getRuleMapFromRequest(request);

    // Assert
    verify(request).getAttribute(eq("blRuleMap"), eq(0));
    assertTrue(actualRuleMapFromRequest.isEmpty());
    assertSame(objectObjectMap, actualRuleMapFromRequest);
  }
}
