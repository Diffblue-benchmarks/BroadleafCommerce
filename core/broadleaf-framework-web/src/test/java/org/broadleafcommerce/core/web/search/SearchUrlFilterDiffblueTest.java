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
import java.util.Locale;
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
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
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
   * Test
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then throw ServletException")
  void testDoFilterInternalUnlessIgnored_thenThrowServletException() throws IOException, ServletException {
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
   * Test
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing() throws IOException, ServletException {
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
   * Test {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Then return Reader is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test wrapRequest(HttpServletRequest); then return Reader is 'null'")
  void testWrapRequest_thenReturnReaderIsNull() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    SearchRequestWrapper servletRequest = mock(SearchRequestWrapper.class);
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
    assertNull(actualWrapRequestResult.getReader());
    assertNull(actualWrapRequestResult.getLocalAddr());
    assertNull(actualWrapRequestResult.getLocalName());
    assertNull(actualWrapRequestResult.getProtocol());
    assertNull(actualWrapRequestResult.getRemoteAddr());
    assertNull(actualWrapRequestResult.getRemoteHost());
    assertNull(actualWrapRequestResult.getScheme());
    assertNull(actualWrapRequestResult.getServerName());
    assertNull(actualWrapRequestResult.getContextPath());
    assertNull(actualWrapRequestResult.getMethod());
    assertNull(actualWrapRequestResult.getRequestURI());
    assertNull(actualWrapRequestResult.getServletPath());
    assertNull(actualWrapRequestResult.getRequestURL());
    assertNull(actualWrapRequestResult.getAttributeNames());
    assertNull(actualWrapRequestResult.getParameterNames());
    assertNull(actualWrapRequestResult.getHeaderNames());
    assertNull(actualWrapRequestResult.getLocales());
    assertNull(actualWrapRequestResult.getLocale());
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
    assertFalse(actualWrapRequestResult.isTrailerFieldsReady());
    assertSame(httpServletRequest, actualWrapRequestResult.getRequest());
  }

  /**
   * Test {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Then Session return {@link MockHttpSession}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test wrapRequest(HttpServletRequest); then Session return MockHttpSession")
  void testWrapRequest_thenSessionReturnMockHttpSession() throws MissingResourceException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchUrlFilter searchUrlFilter = new SearchUrlFilter();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
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
    assertNull(servletContext.getRequestCharacterEncoding());
    assertNull(servletContext.getResponseCharacterEncoding());
    assertNull(sessionCookieConfig.getComment());
    assertNull(sessionCookieConfig.getDomain());
    assertNull(sessionCookieConfig.getName());
    assertNull(sessionCookieConfig.getPath());
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
    assertFalse(sessionCookieConfig.isHttpOnly());
    assertFalse(sessionCookieConfig.isSecure());
    assertFalse(((MockHttpSession) session).isInvalid());
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
    assertSame(servletContext, session.getServletContext());
  }

  /**
   * Test {@link SearchUrlFilter#getOrder()}.
   * <p>
   * Method under test: {@link SearchUrlFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new SearchUrlFilter()).getOrder());
  }
}
