/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {LocalRedirectStrategy.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class LocalRedirectStrategyDiffblueTest {
  @Autowired private LocalRedirectStrategy localRedirectStrategy;

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect() throws IOException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(
        "https://example.org/example", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect2() throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "/");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("/", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect3() throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "http://");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("http://", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect4() throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "/");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("/", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect5() throws IOException {
    // Arrange
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "http://");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect6() throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("example.org/example", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect7() throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(true);

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath("Context Path");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    localRedirectStrategy.sendRedirect(request, response, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals("example", ((MockHttpServletResponse) response3).getRedirectedUrl());
    assertEquals(302, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Given {@code 8080}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getServerName()}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_given8080_thenCallsGetServerName() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act and Assert
    assertThrows(
        MalformedURLException.class,
        () ->
            localRedirectStrategy.sendRedirect(
                request3,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                "https://example.org/example"));
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getContextPath();
    verify(request).getParameter("successUrl");
  }

  /**
   * Test {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse,
   * String)}.
   *
   * <ul>
   *   <li>Then calls {@link FileSystemResponseWrapper#encodeRedirectURL(String)}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest,
   * HttpServletResponse, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalRedirectStrategy.sendRedirect(HttpServletRequest, HttpServletResponse, String)"
  })
  public void testSendRedirect_thenCallsEncodeRedirectURL() throws IOException {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setEnforcePortMatch(false);
    localRedirectStrategy.setContextRelative(false);

    MockServletContext servletContext = mock(MockServletContext.class);
    doNothing().when(servletContext).addInitParameter(Mockito.<String>any(), Mockito.<String>any());
    servletContext.addInitParameter("Name", "42");

    MockHttpServletRequest request = new MockHttpServletRequest(servletContext);
    request.setContextPath("");

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.encodeRedirectURL(Mockito.<String>any()))
        .thenReturn("https://example.org/example");
    doThrow(new MalformedURLException()).when(response).sendRedirect(Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);

    // Act and Assert
    assertThrows(
        MalformedURLException.class,
        () ->
            localRedirectStrategy.sendRedirect(
                request, new HttpServletResponseWrapper(response2), "/"));
    verify(response).encodeRedirectURL("/");
    verify(response).sendRedirect("https://example.org/example");
    verify(servletContext).addInitParameter("Name", "42");
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code e.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnEOrgExample() {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "e.org/example",
        localRedirectStrategy.calculateRedirectUrl("http://", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnExample() {
    // Arrange
    LocalRedirectStrategy localRedirectStrategy = new LocalRedirectStrategy();
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "example",
        localRedirectStrategy.calculateRedirectUrl("Context Path", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code http://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttp() {
    // Arrange
    localRedirectStrategy.setContextRelative(false);

    // Act and Assert
    assertEquals(
        "http://",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "http://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl(
            "https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample2() {
    // Arrange
    localRedirectStrategy.setContextRelative(false);

    // Act and Assert
    assertEquals(
        "https://example.org/example://",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample3() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl("http://", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code ://}.
   *   <li>Then return {@code ://}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenColonSlashSlash_thenReturnColonSlashSlash() {
    // Arrange
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals(
        "://", localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code Context Path}.
   *   <li>Then return {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenContextPath_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals(
        "https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl("Context Path", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String LocalRedirectStrategy.calculateRedirectUrl(String, String)"})
  public void testCalculateRedirectUrl_whenSlash_thenReturnEmptyString() {
    // Arrange
    localRedirectStrategy.setContextRelative(true);

    // Act and Assert
    assertEquals("", localRedirectStrategy.calculateRedirectUrl("/", "http://"));
  }
}
