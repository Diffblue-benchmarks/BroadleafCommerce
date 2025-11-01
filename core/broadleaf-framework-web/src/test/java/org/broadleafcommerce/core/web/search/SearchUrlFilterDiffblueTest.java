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
package org.broadleafcommerce.core.web.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.mock.web.MockSessionCookieConfig;

class SearchUrlFilterDiffblueTest {
  /**
   * Method under test:
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    searchUrlFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test:
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> searchUrlFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  void testWrapRequest() throws IOException, MissingResourceException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
    Collection<Part> parts = actualWrapRequestResult.getParts();
    assertTrue(parts instanceof List);
    HttpSession session = actualWrapRequestResult.getSession();
    assertTrue(session instanceof MockHttpSession);
    ServletContext servletContext = actualWrapRequestResult.getServletContext();
    assertTrue(servletContext instanceof MockServletContext);
    SessionCookieConfig sessionCookieConfig = servletContext.getSessionCookieConfig();
    assertTrue(sessionCookieConfig instanceof MockSessionCookieConfig);
    Locale locale = actualWrapRequestResult.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    assertEquals("", servletContext.getContextPath());
    assertEquals("", actualWrapRequestResult.getContextPath());
    assertEquals("", actualWrapRequestResult.getMethod());
    assertEquals("", actualWrapRequestResult.getRequestURI());
    assertEquals("", actualWrapRequestResult.getServletPath());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("HTTP/1.1", actualWrapRequestResult.getProtocol());
    assertEquals("MockServletContext", servletContext.getServerInfo());
    assertEquals("MockServletContext", servletContext.getServletContextName());
    assertEquals("default", ((MockServletContext) servletContext).getDefaultServletName());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("http", actualWrapRequestResult.getScheme());
    assertEquals("http://localhost", actualWrapRequestResult.getRequestURL().toString());
    assertEquals("localhost", actualWrapRequestResult.getLocalName());
    assertEquals("localhost", actualWrapRequestResult.getRemoteHost());
    assertEquals("localhost", actualWrapRequestResult.getServerName());
    assertNull(actualWrapRequestResult.getCookies());
    assertNull(servletContext.getRequestCharacterEncoding());
    assertNull(servletContext.getResponseCharacterEncoding());
    assertNull(actualWrapRequestResult.getCharacterEncoding());
    assertNull(actualWrapRequestResult.getContentType());
    assertNull(sessionCookieConfig.getComment());
    assertNull(sessionCookieConfig.getDomain());
    assertNull(sessionCookieConfig.getName());
    assertNull(sessionCookieConfig.getPath());
    assertNull(actualWrapRequestResult.getAuthType());
    assertNull(actualWrapRequestResult.getPathInfo());
    assertNull(actualWrapRequestResult.getPathTranslated());
    assertNull(actualWrapRequestResult.getQueryString());
    assertNull(actualWrapRequestResult.getRemoteUser());
    assertNull(actualWrapRequestResult.getRequestedSessionId());
    assertNull(actualWrapRequestResult.getUserPrincipal());
    assertNull(actualWrapRequestResult.getAsyncContext());
    assertEquals(-1, actualWrapRequestResult.getContentLength());
    assertEquals(-1, sessionCookieConfig.getMaxAge());
    assertEquals(-1L, actualWrapRequestResult.getContentLengthLong());
    assertEquals(0, servletContext.getSessionTimeout());
    assertEquals(0, session.getMaxInactiveInterval());
    assertEquals(0, session.getValueNames().length);
    assertEquals(1, servletContext.getEffectiveMinorVersion());
    assertEquals(1, servletContext.getMinorVersion());
    Set<SessionTrackingMode> defaultSessionTrackingModes = servletContext.getDefaultSessionTrackingModes();
    assertEquals(3, defaultSessionTrackingModes.size());
    assertEquals(3, servletContext.getEffectiveMajorVersion());
    assertEquals(3, servletContext.getMajorVersion());
    assertEquals(80, actualWrapRequestResult.getLocalPort());
    assertEquals(80, actualWrapRequestResult.getRemotePort());
    assertEquals(80, actualWrapRequestResult.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualWrapRequestResult.getDispatcherType());
    assertFalse(locale.hasExtensions());
    assertFalse(actualWrapRequestResult.isAsyncStarted());
    assertFalse(actualWrapRequestResult.isAsyncSupported());
    assertFalse(actualWrapRequestResult.isSecure());
    assertFalse(sessionCookieConfig.isHttpOnly());
    assertFalse(sessionCookieConfig.isSecure());
    assertFalse(((MockHttpSession) session).isInvalid());
    assertTrue(parts.isEmpty());
    assertTrue(actualWrapRequestResult.getParameterMap().isEmpty());
    Map<String, String> trailerFields = actualWrapRequestResult.getTrailerFields();
    assertTrue(trailerFields.isEmpty());
    assertTrue(defaultSessionTrackingModes.contains(SessionTrackingMode.COOKIE));
    assertTrue(defaultSessionTrackingModes.contains(SessionTrackingMode.SSL));
    assertTrue(defaultSessionTrackingModes.contains(SessionTrackingMode.URL));
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertTrue(((MockServletContext) servletContext).getDeclaredRoles().isEmpty());
    assertTrue(actualWrapRequestResult.isTrailerFieldsReady());
    assertSame(httpServletRequest, actualWrapRequestResult.getRequest());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(defaultSessionTrackingModes, servletContext.getEffectiveSessionTrackingModes());
    assertSame(trailerFields, servletContext.getFilterRegistrations());
    assertSame(trailerFields, servletContext.getServletRegistrations());
    assertSame(servletContext, session.getServletContext());
  }

  /**
   * Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  void testWrapRequest2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    SearchRequestWrapper servletRequest = mock(SearchRequestWrapper.class);
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
    Collection<Part> parts = actualWrapRequestResult.getParts();
    assertTrue(parts instanceof List);
    assertNull(actualWrapRequestResult.getCookies());
    assertNull(actualWrapRequestResult.getReader());
    assertNull(actualWrapRequestResult.getCharacterEncoding());
    assertNull(actualWrapRequestResult.getContentType());
    assertNull(actualWrapRequestResult.getLocalAddr());
    assertNull(actualWrapRequestResult.getLocalName());
    assertNull(actualWrapRequestResult.getProtocol());
    assertNull(actualWrapRequestResult.getRemoteAddr());
    assertNull(actualWrapRequestResult.getRemoteHost());
    assertNull(actualWrapRequestResult.getScheme());
    assertNull(actualWrapRequestResult.getServerName());
    assertNull(actualWrapRequestResult.getAuthType());
    assertNull(actualWrapRequestResult.getContextPath());
    assertNull(actualWrapRequestResult.getMethod());
    assertNull(actualWrapRequestResult.getPathInfo());
    assertNull(actualWrapRequestResult.getPathTranslated());
    assertNull(actualWrapRequestResult.getQueryString());
    assertNull(actualWrapRequestResult.getRemoteUser());
    assertNull(actualWrapRequestResult.getRequestURI());
    assertNull(actualWrapRequestResult.getRequestedSessionId());
    assertNull(actualWrapRequestResult.getServletPath());
    assertNull(actualWrapRequestResult.getRequestURL());
    assertNull(actualWrapRequestResult.getUserPrincipal());
    assertNull(actualWrapRequestResult.getAttributeNames());
    assertNull(actualWrapRequestResult.getParameterNames());
    assertNull(actualWrapRequestResult.getHeaderNames());
    assertNull(actualWrapRequestResult.getLocales());
    assertNull(actualWrapRequestResult.getLocale());
    assertNull(actualWrapRequestResult.getAsyncContext());
    assertNull(actualWrapRequestResult.getDispatcherType());
    assertNull(actualWrapRequestResult.getServletContext());
    assertNull(actualWrapRequestResult.getInputStream());
    assertNull(actualWrapRequestResult.getHttpServletMapping());
    assertNull(actualWrapRequestResult.getSession());
    assertEquals(0, actualWrapRequestResult.getContentLength());
    assertEquals(0, actualWrapRequestResult.getLocalPort());
    assertEquals(0, actualWrapRequestResult.getRemotePort());
    assertEquals(0, actualWrapRequestResult.getServerPort());
    assertEquals(0L, actualWrapRequestResult.getContentLengthLong());
    assertFalse(actualWrapRequestResult.isAsyncStarted());
    assertFalse(actualWrapRequestResult.isAsyncSupported());
    assertFalse(actualWrapRequestResult.isSecure());
    assertFalse(actualWrapRequestResult.isTrailerFieldsReady());
    assertTrue(parts.isEmpty());
    assertTrue(actualWrapRequestResult.getParameterMap().isEmpty());
    assertTrue(actualWrapRequestResult.getTrailerFields().isEmpty());
    assertSame(httpServletRequest, actualWrapRequestResult.getRequest());
  }

  /**
   * Method under test: {@link SearchUrlFilter#getOrder()}
   */
  @Test
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new SearchUrlFilter()).getOrder());
  }
}
