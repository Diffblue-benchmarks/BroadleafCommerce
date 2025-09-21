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
package org.broadleafcommerce.core.web.security;

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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

@ExtendWith(MockitoExtension.class)
class XssFilterDiffblueTest {
  @InjectMocks private XssFilter xssFilter;

  /**
   * Test {@link XssFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link XssFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); given IOException(); then throw IOException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XssFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            xssFilter.doFilterInternalUnlessIgnored(
                httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link XssFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link XssFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void XssFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    xssFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link XssFilter#wrapRequest(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then Parts return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link XssFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test wrapRequest(HttpServletRequest); then Parts return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"XssRequestWrapper XssFilter.wrapRequest(HttpServletRequest)"})
  void testWrapRequest_thenPartsReturnList() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));

    // Act
    XssRequestWrapper actualWrapRequestResult = xssFilter.wrapRequest(httpServletRequest);

    // Assert
    Collection<Part> parts = actualWrapRequestResult.getParts();
    assertTrue(parts instanceof List);
    ServletRequest request = actualWrapRequestResult.getRequest();
    assertTrue(request instanceof HttpServletRequestWrapper);
    assertTrue(actualWrapRequestResult.getSession() instanceof MockHttpSession);
    assertTrue(actualWrapRequestResult.getServletContext() instanceof MockServletContext);
    assertEquals("", actualWrapRequestResult.getContextPath());
    assertEquals("", actualWrapRequestResult.getMethod());
    assertEquals("", actualWrapRequestResult.getRequestURI());
    assertEquals("", actualWrapRequestResult.getServletPath());
    assertEquals("HTTP/1.1", actualWrapRequestResult.getProtocol());
    assertEquals("http", actualWrapRequestResult.getScheme());
    assertEquals("localhost", actualWrapRequestResult.getLocalName());
    assertEquals("localhost", actualWrapRequestResult.getRemoteHost());
    assertEquals("localhost", actualWrapRequestResult.getServerName());
    assertNull(actualWrapRequestResult.getCharacterEncoding());
    assertNull(actualWrapRequestResult.getContentType());
    assertNull(actualWrapRequestResult.getAuthType());
    assertNull(actualWrapRequestResult.getPathInfo());
    assertNull(actualWrapRequestResult.getPathTranslated());
    assertNull(actualWrapRequestResult.getQueryString());
    assertNull(actualWrapRequestResult.getRemoteUser());
    assertNull(actualWrapRequestResult.getRequestedSessionId());
    assertNull(actualWrapRequestResult.getUserPrincipal());
    assertNull(actualWrapRequestResult.getAsyncContext());
    assertNull(actualWrapRequestResult.getCookies());
    assertNull(actualWrapRequestResult.environment);
    assertEquals(-1, actualWrapRequestResult.getContentLength());
    assertEquals(-1L, actualWrapRequestResult.getContentLengthLong());
    assertEquals(80, actualWrapRequestResult.getLocalPort());
    assertEquals(80, actualWrapRequestResult.getRemotePort());
    assertEquals(80, actualWrapRequestResult.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualWrapRequestResult.getDispatcherType());
    assertFalse(actualWrapRequestResult.isAsyncStarted());
    assertFalse(actualWrapRequestResult.isAsyncSupported());
    assertFalse(actualWrapRequestResult.isSecure());
    assertFalse(actualWrapRequestResult.customStripXssEnabled);
    assertTrue(parts.isEmpty());
    assertTrue(actualWrapRequestResult.getParameterMap().isEmpty());
    assertTrue(actualWrapRequestResult.getTrailerFields().isEmpty());
    assertTrue(actualWrapRequestResult.isTrailerFieldsReady());
    assertSame(httpServletRequest, request);
  }

  /**
   * Test {@link XssFilter#getOrder()}.
   *
   * <p>Method under test: {@link XssFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int XssFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10000, xssFilter.getOrder());
  }
}
