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
package org.broadleafcommerce.common.web.security;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafAuthenticationSuccessRedirectStrategy.class})
@ExtendWith(SpringExtension.class)
class BroadleafAuthenticationSuccessRedirectStrategyDiffblueTest {
  @Autowired
  private BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy;

  /**
   * Test
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  void testSendRedirect() throws IOException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(0, session.getValueNames().length);
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  void testSendRedirect2() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("U://U");
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    verify(environment).addActiveProfile(eq("U://U"));
    verify(servletRequest).getParameter(eq("blcAjax"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  void testSendRedirect3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(servletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(servletRequest.getSession()).thenReturn(new MockHttpSession());
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    StandardEnvironment environment = mock(StandardEnvironment.class);
    doNothing().when(environment).addActiveProfile(Mockito.<String>any());
    environment.addActiveProfile("U://U");
    SearchRequestWrapper request = new SearchRequestWrapper(
        new XssRequestWrapper(servletRequest, environment, new String[]{"blcAjax"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    verify(servletRequest).getAttribute(eq("blOkToUseSession"));
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    verify(servletRequest).getSession();
    verify(environment).addActiveProfile(eq("U://U"));
    verify(servletRequest).getParameter(eq("blcAjax"));
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("https://example.org/example/redirect", response.getRedirectedUrl());
    assertArrayEquals(new String[]{"BLC_REDIRECT_URL"}, session.getValueNames());
  }

  /**
   * Test
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?blcAjax=true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}
   */
  @Test
  @DisplayName("Test updateLoginErrorUrlForAjax(String); then return 'https://example.org/example?blcAjax=true'")
  void testUpdateLoginErrorUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example?blcAjax=true",
        broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax("https://example.org/example"));
    assertEquals("https://example.org/example?&blcAjax=true",
        broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax("https://example.org/example?"));
  }

  /**
   * Test
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null?blcAjax=true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#updateLoginErrorUrlForAjax(String)}
   */
  @Test
  @DisplayName("Test updateLoginErrorUrlForAjax(String); when 'null'; then return 'null?blcAjax=true'")
  void testUpdateLoginErrorUrlForAjax_whenNull_thenReturnNullBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals("null?blcAjax=true", broadleafAuthenticationSuccessRedirectStrategy.updateLoginErrorUrlForAjax(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#setRedirectPath(String)}
   *   <li>
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#setRedirectStrategy(RedirectStrategy)}
   *   <li>{@link BroadleafAuthenticationSuccessRedirectStrategy#getRedirectPath()}
   *   <li>
   * {@link BroadleafAuthenticationSuccessRedirectStrategy#getRedirectStrategy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    BroadleafAuthenticationSuccessRedirectStrategy broadleafAuthenticationSuccessRedirectStrategy = new BroadleafAuthenticationSuccessRedirectStrategy();

    // Act
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectPath("Redirect Path");
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy = new BroadleafAuthenticationFailureRedirectStrategy();
    broadleafAuthenticationSuccessRedirectStrategy.setRedirectStrategy(redirectStrategy);
    String actualRedirectPath = broadleafAuthenticationSuccessRedirectStrategy.getRedirectPath();
    RedirectStrategy actualRedirectStrategy = broadleafAuthenticationSuccessRedirectStrategy.getRedirectStrategy();

    // Assert that nothing has changed
    assertTrue(actualRedirectStrategy instanceof BroadleafAuthenticationFailureRedirectStrategy);
    assertEquals("Redirect Path", actualRedirectPath);
    assertSame(redirectStrategy, actualRedirectStrategy);
  }
}
