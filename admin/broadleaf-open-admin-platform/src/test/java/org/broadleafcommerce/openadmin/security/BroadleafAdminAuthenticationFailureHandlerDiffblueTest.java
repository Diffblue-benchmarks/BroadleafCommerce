/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.security;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.security.LocalRedirectStrategy;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.AuthenticationException;

public class BroadleafAdminAuthenticationFailureHandlerDiffblueTest {
  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

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
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure2() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[] {"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure3() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    SecurityWrapperResponse response =
        new SecurityWrapperResponse(new MockHttpServletResponse(), "Mode");

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request3, response, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    HttpSession session = request3.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response2).getErrorMessage());
    assertEquals(0, session.getValueNames().length);
    assertTrue(response2.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure4() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    SecurityWrapperResponse response = new SecurityWrapperResponse(new MockHttpServletResponse());

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request3, response, new AccountExpiredException("Msg"));

    // Assert
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    HttpSession session = request3.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("Unauthorized", ((MockHttpServletResponse) response2).getErrorMessage());
    assertEquals(0, session.getValueNames().length);
    assertTrue(response2.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure5() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    broadleafAdminAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[] {"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_given42_thenMockHttpServletResponseRedirectedUrlIs42()
      throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request2, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request2.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("42", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[] {"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }

  /**
   * Test {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminAuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   * HttpServletResponse, AuthenticationException)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)"
  })
  public void testOnAuthenticationFailure_givenSpace() throws IOException, ServletException {
    // Arrange
    BroadleafAdminAuthenticationFailureHandler broadleafAdminAuthenticationFailureHandler =
        new BroadleafAdminAuthenticationFailureHandler("https://example.org/example");
    broadleafAdminAuthenticationFailureHandler.setRedirectStrategy(new LocalRedirectStrategy());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("failureUrl", " ");
    request.addParameter("failureUrl", "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminAuthenticationFailureHandler.onAuthenticationFailure(
        request2, response, new AccountExpiredException("Msg"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request2.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertArrayEquals(new String[] {"SPRING_SECURITY_LAST_EXCEPTION"}, session.getValueNames());
  }
}
