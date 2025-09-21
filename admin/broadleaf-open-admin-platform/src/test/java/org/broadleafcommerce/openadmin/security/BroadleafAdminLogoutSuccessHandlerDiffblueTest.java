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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.owasp.esapi.filters.SecurityWrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {BroadleafAdminLogoutSuccessHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafAdminLogoutSuccessHandlerDiffblueTest {
  @Autowired private BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler;

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest request2 = new SecurityWrapperRequest(request);
    JSCompatibilityRequestWrapper request3 = new JSCompatibilityRequestWrapper(request2);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request4, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess2() throws IOException, ServletException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("https://example.org/example");
    when(request.getSession()).thenReturn(new MockHttpSession());
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    SecurityWrapperResponse response =
        new SecurityWrapperResponse(new MockHttpServletResponse(), "Mode");

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request3, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getQueryString();
    verify(request).getSession();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof MockHttpServletResponse);
    HttpSession session = request3.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals("HTTP error code: 403", ((MockHttpServletResponse) response2).getErrorMessage());
    assertTrue(response2.isCommitted());
    assertTrue(response.isCommitted());
    assertTrue(((MockHttpSession) session).isInvalid());
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess3() throws IOException, ServletException {
    // Arrange
    BroadleafAdminLogoutSuccessHandler broadleafAdminLogoutSuccessHandler =
        new BroadleafAdminLogoutSuccessHandler();

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getScheme()).thenReturn("Scheme");
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getQueryString()).thenReturn("https://example.org/example");
    when(request.getSession()).thenReturn(new MockHttpSession());
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);
    SecurityWrapperResponse response =
        new SecurityWrapperResponse(
            new SecurityWrapperResponse(new MockHttpServletResponse(), "Mode"), "Mode");

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request2, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    verify(request).getScheme();
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getQueryString();
    verify(request).getSession();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof SecurityWrapperResponse);
    ServletResponse response3 = ((SecurityWrapperResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    HttpSession session = request2.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertEquals(
        "HTTP error code&#x3a; 403", ((MockHttpServletResponse) response3).getErrorMessage());
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
    assertTrue(((MockHttpSession) session).isInvalid());
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_givenEmptyString() throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setQueryString("");

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(false);

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Given {@code Request}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) RedirectedUrl is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_givenRequest_thenMockHttpServletResponseRedirectedUrlIsNull()
      throws IOException, ServletException {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setQueryString("Request");

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(false);

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertNull(response.getRedirectedUrl());
    assertEquals(403, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_givenTrue_thenMockHttpServletResponseStatusIsTwoHundred()
      throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request =
        new JSCompatibilityRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    MockHttpServletResponse response = new MockHttpServletResponse();
    response.setCommitted(true);

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request2, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert that nothing has changed
    Collection<String> headerNames = response.getHeaderNames();
    assertTrue(headerNames instanceof Set);
    assertEquals(200, response.getStatus());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest,
   * HttpServletResponse, Authentication)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafAdminLogoutSuccessHandler#onLogoutSuccess(HttpServletRequest, HttpServletResponse,
   * Authentication)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminLogoutSuccessHandler.onLogoutSuccess(HttpServletRequest, HttpServletResponse, Authentication)"
  })
  public void testOnLogoutSuccess_thenMockHttpServletResponseHeaderNamesSizeIsOne()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    broadleafAdminLogoutSuccessHandler.onLogoutSuccess(
        request, response, new TestingAuthenticationToken("Principal", "Credentials"));

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals("/", response.getRedirectedUrl());
    assertEquals(302, response.getStatus());
    assertTrue(headerNames.contains("Location"));
  }
}
