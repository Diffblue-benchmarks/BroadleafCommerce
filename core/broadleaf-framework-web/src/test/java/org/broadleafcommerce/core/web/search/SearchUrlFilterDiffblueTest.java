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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {SearchUrlFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class SearchUrlFilterDiffblueTest {
  @Autowired
  private SearchUrlFilter searchUrlFilter;

  /**
   * Test {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then throw ServletException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void SearchUrlFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_thenThrowServletException() throws IOException, ServletException {
    // Arrange
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
   * Test {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUrlFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void SearchUrlFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    searchUrlFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}.
   * <ul>
   *   <li>Then Parts return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchUrlFilter#wrapRequest(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test wrapRequest(HttpServletRequest); then Parts return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SearchRequestWrapper SearchUrlFilter.wrapRequest(HttpServletRequest)"})
  void testWrapRequest_thenPartsReturnList() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act
    SearchRequestWrapper actualWrapRequestResult = searchUrlFilter.wrapRequest(httpServletRequest);

    // Assert
    Collection<Part> parts = actualWrapRequestResult.getParts();
    assertTrue(parts instanceof List);
    ServletRequest request = actualWrapRequestResult.getRequest();
    assertTrue(request instanceof SearchRequestWrapper);
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
    assertNull(actualWrapRequestResult.getCookies());
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
    assertEquals(-1, actualWrapRequestResult.getContentLength());
    assertEquals(-1L, actualWrapRequestResult.getContentLengthLong());
    assertEquals(80, actualWrapRequestResult.getLocalPort());
    assertEquals(80, actualWrapRequestResult.getRemotePort());
    assertEquals(80, actualWrapRequestResult.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualWrapRequestResult.getDispatcherType());
    assertFalse(actualWrapRequestResult.isAsyncStarted());
    assertFalse(actualWrapRequestResult.isAsyncSupported());
    assertFalse(actualWrapRequestResult.isSecure());
    assertTrue(parts.isEmpty());
    assertTrue(actualWrapRequestResult.getParameterMap().isEmpty());
    assertTrue(actualWrapRequestResult.getTrailerFields().isEmpty());
    assertTrue(actualWrapRequestResult.isTrailerFieldsReady());
    assertSame(httpServletRequest, request);
  }

  /**
   * Test {@link SearchUrlFilter#getOrder()}.
   * <p>
   * Method under test: {@link SearchUrlFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int SearchUrlFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new SearchUrlFilter()).getOrder());
  }
}
