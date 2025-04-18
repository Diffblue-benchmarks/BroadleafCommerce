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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
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
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {SessionFixationProtectionFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class SessionFixationProtectionFilterDiffblueTest {
  @MockBean(name = "blCookieUtils")
  private CookieUtils cookieUtils;

  @MockBean(name = "blSessionFixationEncryptionModule")
  private EncryptionModule encryptionModule;

  @Autowired
  private SessionFixationProtectionFilter sessionFixationProtectionFilter;

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter() throws IOException, ServletException {
    // Arrange
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Attribute");
    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");
    DefaultMultipartHttpServletRequest sRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(sRequest.isSecure()).thenReturn(true);
    when(sRequest.getSession(anyBoolean())).thenReturn(mockHttpSession);
    HttpServletResponseWrapper sResponse = new HttpServletResponseWrapper(new MockHttpServletResponse());
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(sRequest).isSecure();
    verify(sRequest).getSession(eq(false));
    verify(encryptionModule).decrypt(eq("42"));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("ActiveID"));
    verify(mockHttpSession).getAttribute(eq("SFP-ActiveID"));
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    Collection<String> headerNames = sResponse.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    ServletResponse response = sResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals(200, sResponse.getStatus());
    assertEquals(200, ((MockHttpServletResponse) response).getStatus());
    assertFalse(response.isCommitted());
    assertFalse(sResponse.isCommitted());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given Bean Name{blCookieUtils}.</li>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); given Bean Name{blCookieUtils}; when MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_givenBeanNameBlCookieUtils_whenMockHttpServletRequest() throws IOException, ServletException {
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
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_givenFalse() throws IOException, ServletException {
    // Arrange
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");
    DefaultMultipartHttpServletRequest sRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(sRequest.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(sRequest.isSecure()).thenReturn(true);
    when(sRequest.getSession(anyBoolean())).thenReturn(mockHttpSession);
    HttpServletResponseWrapper sResponse = new HttpServletResponseWrapper(new MockHttpServletResponse());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, mock(FilterChain.class));

    // Assert
    verify(sRequest).getAttribute(eq("blOkToUseSession"));
    verify(sRequest).isSecure();
    verify(sRequest).getSession(eq(false));
    verify(encryptionModule).decrypt(eq("42"));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("ActiveID"));
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    verify(mockHttpSession).getAttribute(eq("SFP-ActiveID"));
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    Collection<String> headerNames = sResponse.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response = sResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals("/", ((MockHttpServletResponse) response).getRedirectedUrl());
    assertEquals(302, sResponse.getStatus());
    assertEquals(302, ((MockHttpServletResponse) response).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
    assertTrue(sResponse.isCommitted());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest} {@link ServletRequestWrapper#getAttribute(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); when DefaultMultipartHttpServletRequest getAttribute(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_whenDefaultMultipartHttpServletRequestGetAttributeReturnNull()
      throws IOException, ServletException {
    // Arrange
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");
    DefaultMultipartHttpServletRequest sRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(sRequest.getAttribute(Mockito.<String>any())).thenReturn(null);
    when(sRequest.getSession()).thenReturn(new MockHttpSession());
    when(sRequest.isSecure()).thenReturn(true);
    when(sRequest.getSession(anyBoolean())).thenReturn(mockHttpSession);
    HttpServletResponseWrapper sResponse = new HttpServletResponseWrapper(new MockHttpServletResponse());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, mock(FilterChain.class));

    // Assert
    verify(sRequest).getAttribute(eq("blOkToUseSession"));
    verify(sRequest).isSecure();
    verify(sRequest).getSession();
    verify(sRequest).getSession(eq(false));
    verify(encryptionModule).decrypt(eq("42"));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("ActiveID"));
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    verify(mockHttpSession).getAttribute(eq("SFP-ActiveID"));
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    Collection<String> headerNames = sResponse.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response = sResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals("/", ((MockHttpServletResponse) response).getRedirectedUrl());
    assertEquals(302, sResponse.getStatus());
    assertEquals(302, ((MockHttpServletResponse) response).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
    assertTrue(sResponse.isCommitted());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest} {@link ServletRequestWrapper#getAttribute(String)} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); when DefaultMultipartHttpServletRequest getAttribute(String) return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_whenDefaultMultipartHttpServletRequestGetAttributeReturnTrue()
      throws IOException, ServletException {
    // Arrange
    when(cookieUtils.getCookieValue(Mockito.<HttpServletRequest>any(), Mockito.<String>any())).thenReturn("42");
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    when(encryptionModule.decrypt(Mockito.<String>any())).thenReturn("Decrypt");
    MockHttpSession mockHttpSession = mock(MockHttpSession.class);
    when(mockHttpSession.getAttribute(Mockito.<String>any())).thenReturn("Attribute");
    doNothing().when(mockHttpSession).putValue(Mockito.<String>any(), Mockito.<Object>any());
    mockHttpSession.putValue("Name", "Value");
    DefaultMultipartHttpServletRequest sRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(sRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(sRequest.getSession()).thenReturn(new MockHttpSession());
    when(sRequest.isSecure()).thenReturn(true);
    when(sRequest.getSession(anyBoolean())).thenReturn(mockHttpSession);
    HttpServletResponseWrapper sResponse = new HttpServletResponseWrapper(new MockHttpServletResponse());

    // Act
    sessionFixationProtectionFilter.doFilter(sRequest, sResponse, mock(FilterChain.class));

    // Assert
    verify(sRequest).getAttribute(eq("blOkToUseSession"));
    verify(sRequest).isSecure();
    verify(sRequest).getSession();
    verify(sRequest).getSession(eq(false));
    verify(encryptionModule).decrypt(eq("42"));
    verify(cookieUtils).getCookieValue(isA(HttpServletRequest.class), eq("ActiveID"));
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    verify(mockHttpSession).getAttribute(eq("SFP-ActiveID"));
    verify(mockHttpSession).putValue(eq("Name"), isA(Object.class));
    Collection<String> headerNames = sResponse.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response = sResponse.getResponse();
    assertTrue(response instanceof MockHttpServletResponse);
    assertEquals("/", ((MockHttpServletResponse) response).getRedirectedUrl());
    assertEquals(302, sResponse.getStatus());
    assertEquals(302, ((MockHttpServletResponse) response).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
    assertTrue(sResponse.isCommitted());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link DefaultMultipartHttpServletRequest} {@link HttpServletRequestWrapper#getSession(boolean)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilter(ServletRequest, ServletResponse, FilterChain); when DefaultMultipartHttpServletRequest getSession(boolean) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  void testDoFilter_whenDefaultMultipartHttpServletRequestGetSessionReturnNull() throws IOException, ServletException {
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
    verify(sRequest).getSession(eq(false));
  }

  /**
   * Test {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link MockHttpServletRequest} {@link MockHttpServletRequest#getAttribute(String)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test abortUser(HttpServletRequest, HttpServletResponse); given 'false'; when MockHttpServletRequest getAttribute(String) return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.abortUser(HttpServletRequest, HttpServletResponse)"})
  void testAbortUser_givenFalse_whenMockHttpServletRequestGetAttributeReturnFalse() throws IOException {
    // Arrange
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    sessionFixationProtectionFilter.abortUser(request, response);

    // Assert
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getAttribute(eq("blOkToUseSession"));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link MockHttpServletRequest#getSession()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test abortUser(HttpServletRequest, HttpServletResponse); given 'true'; then calls getSession()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.abortUser(HttpServletRequest, HttpServletResponse)"})
  void testAbortUser_givenTrue_thenCallsGetSession() throws IOException {
    // Arrange
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
    MockHttpServletRequest request = mock(MockHttpServletRequest.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    when(request.getSession()).thenReturn(new MockHttpSession());
    doNothing().when(request).addParameter(Mockito.<String>any(), Mockito.<String>any());
    request.addParameter("https://example.org/example", "https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    sessionFixationProtectionFilter.abortUser(request, response);

    // Assert
    verify(cookieUtils).invalidateCookie(isA(HttpServletResponse.class), eq("ActiveID"));
    verify(request).addParameter(eq("https://example.org/example"), eq("https://example.org/example"));
    verify(request).getAttribute(eq("blOkToUseSession"));
    verify(request).getSession();
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionFixationProtectionFilter#abortUser(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @DisplayName("Test abortUser(HttpServletRequest, HttpServletResponse); when MockHttpServletRequest()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionFixationProtectionFilter.abortUser(HttpServletRequest, HttpServletResponse)"})
  void testAbortUser_whenMockHttpServletRequest() throws IOException {
    // Arrange
    doNothing().when(cookieUtils).invalidateCookie(Mockito.<HttpServletResponse>any(), Mockito.<String>any());
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
