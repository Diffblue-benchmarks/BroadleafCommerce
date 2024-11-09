/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;

public class BroadleafAdminAuthenticationFailureHandlerDiffblueTest {
  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler = new BroadleafAdminAuthenticationFailureHandler();
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("Unauthorized", response.getErrorMessage());
    assertNull(response.getRedirectedUrl());
    assertEquals(0, session.getValueNames().length);
    assertEquals(401, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames
   * size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}
   */
  @Test
  public void testOnAuthenticationFailure_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler = new BroadleafAdminAuthenticationFailureHandler(
        "https://example.org/example");
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(request, response,
        new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertNull(response.getErrorMessage());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[]{"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }
}
