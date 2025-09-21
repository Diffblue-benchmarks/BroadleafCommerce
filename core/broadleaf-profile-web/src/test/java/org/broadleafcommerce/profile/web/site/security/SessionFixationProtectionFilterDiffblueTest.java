/*-
 * #%L
 * BroadleafCommerce Profile Web
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
package org.broadleafcommerce.profile.web.site.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.encryption.EncryptionModule;
import org.broadleafcommerce.common.security.util.CookieUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {SessionFixationProtectionFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class SessionFixationProtectionFilterDiffblueTest {
  @MockBean(name = "blCookieUtils")
  private CookieUtils cookieUtils;

  @MockBean(name = "blSessionFixationEncryptionModule")
  private EncryptionModule encryptionModule;

  @Autowired private SessionFixationProtectionFilter sessionFixationProtectionFilter;

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_givenNull() throws IOException, ServletException {
    // Arrange
    DefaultMultipartHttpServletRequest sRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(sRequest.isSecure()).thenReturn(true);
    when(sRequest.getSession(anyBoolean())).thenReturn(null);
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(sRequest).isSecure();
    verify(sRequest).getSession(false);
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); then throw ServletException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred"))
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilter(ServletRequest, ServletResponse, FilterChain); when MockHttpServletRequest(); then calls doFilter(ServletRequest, ServletResponse)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  void testDoFilter_whenMockHttpServletRequest_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest sRequest = new MockHttpServletRequest();
    MockHttpServletResponse sResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @DisplayName(
      "Test abortUser(HttpServletRequest, HttpServletResponse); then MockHttpServletResponse (default constructor) HeaderNames size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SessionFixationProtectionFilter.abortUser(HttpServletRequest, HttpServletResponse)"
  })
  void testAbortUser_thenMockHttpServletResponseHeaderNamesSizeIsOne() throws IOException {
    // Arrange
    doNothing()
        .when(cookieUtils)
        .invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    sessionFixationProtectionFilter.abortUser(request, response);

    // Assert
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }
}
