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
package org.broadleafcommerce.common.web.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
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
import org.springframework.security.web.RedirectStrategy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BroadleafAuthenticationFailureRedirectStrategy.class})
@ExtendWith(SpringExtension.class)
class BroadleafAuthenticationFailureRedirectStrategyDiffblueTest {
  @Autowired
  private BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy;

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"})
  void testSendRedirect() throws IOException {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"})
  void testSendRedirect2() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    verify(servletRequest).getParameter(eq("blcAjax"));
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"})
  void testSendRedirect3() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    verify(servletRequest).getParameter(eq("blcAjax"));
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"})
  void testSendRedirect4() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn(Boolean.TRUE.toString());
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, null);

    // Assert
    verify(servletRequest).getParameter(eq("blcAjax"));
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/examplenull?blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@code XMLHttpRequest}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  @DisplayName("Test sendRedirect(HttpServletRequest, HttpServletResponse, String); given 'XMLHttpRequest'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void BroadleafAuthenticationFailureRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"})
  void testSendRedirect_givenXMLHttpRequest() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");
    when(servletRequest.getContextPath()).thenReturn("https://example.org/example");
    when(servletRequest.getHeader(Mockito.<String>any())).thenReturn("XMLHttpRequest");
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    verify(servletRequest).getParameter(eq("blcAjax"));
    verify(servletRequest).getContextPath();
    verify(servletRequest).getHeader(eq("X-Requested-With"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("https://example.org/example?blcAjax=true", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?blcAjax=true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @DisplayName("Test updateUrlForAjax(String); then return 'https://example.org/example?blcAjax=true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"})
  void testUpdateUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example?blcAjax=true",
        broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax("https://example.org/example"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example?&blcAjax=true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @DisplayName("Test updateUrlForAjax(String); then return 'https://example.org/example?&blcAjax=true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"})
  void testUpdateUrlForAjax_thenReturnHttpsExampleOrgExampleBlcAjaxTrue2() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example?&blcAjax=true",
        broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax("https://example.org/example?"));
  }

  /**
   * Test {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null?blcAjax=true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAuthenticationFailureRedirectStrategy#updateUrlForAjax(String)}
   */
  @Test
  @DisplayName("Test updateUrlForAjax(String); when 'null'; then return 'null?blcAjax=true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BroadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(String)"})
  void testUpdateUrlForAjax_whenNull_thenReturnNullBlcAjaxTrue() {
    // Arrange, Act and Assert
    assertEquals("null?blcAjax=true", broadleafAuthenticationFailureRedirectStrategy.updateUrlForAjax(null));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BroadleafAuthenticationFailureRedirectStrategy#setRedirectStrategy(RedirectStrategy)}
   *   <li>{@link BroadleafAuthenticationFailureRedirectStrategy#getRedirectStrategy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"RedirectStrategy BroadleafAuthenticationFailureRedirectStrategy.getRedirectStrategy()",
      "void BroadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(RedirectStrategy)"})
  void testGettersAndSetters() {
    // Arrange
    BroadleafAuthenticationFailureRedirectStrategy broadleafAuthenticationFailureRedirectStrategy = new BroadleafAuthenticationFailureRedirectStrategy();
    BroadleafAuthenticationFailureRedirectStrategy redirectStrategy = new BroadleafAuthenticationFailureRedirectStrategy();

    // Act
    broadleafAuthenticationFailureRedirectStrategy.setRedirectStrategy(redirectStrategy);
    RedirectStrategy actualRedirectStrategy = broadleafAuthenticationFailureRedirectStrategy.getRedirectStrategy();

    // Assert
    assertTrue(actualRedirectStrategy instanceof BroadleafAuthenticationFailureRedirectStrategy);
    assertSame(redirectStrategy, actualRedirectStrategy);
  }
}
