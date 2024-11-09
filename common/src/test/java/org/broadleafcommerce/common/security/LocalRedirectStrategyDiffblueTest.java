/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Set;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {LocalRedirectStrategy.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LocalRedirectStrategyDiffblueTest {
  @Autowired
  private LocalRedirectStrategy localRedirectStrategy;

  /**
   * Test
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testSendRedirect() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    localRedirectStrategy.sendRedirect(request, response2, "https://example.org/example");

    // Assert
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof MockHttpServletResponse);
    assertEquals("https://example.org/example", ((MockHttpServletResponse) response4).getRedirectedUrl());
    assertEquals(302, ((FileSystemResponseWrapper) response3).getStatus());
    assertEquals(302, ((MockHttpServletResponse) response4).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response3.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response2.isCommitted());
  }

  /**
   * Test
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testSendRedirect2() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    localRedirectStrategy.sendRedirect(request2, response2, "/");

    // Assert
    verify(request).getContextPath();
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof MockHttpServletResponse);
    assertEquals("https://example.org/example/", ((MockHttpServletResponse) response4).getRedirectedUrl());
    assertEquals(302, ((FileSystemResponseWrapper) response3).getStatus());
    assertEquals(302, ((MockHttpServletResponse) response4).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response3.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response2.isCommitted());
  }

  /**
   * Test
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testSendRedirect3() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    localRedirectStrategy.sendRedirect(request2, response2, "http://");

    // Assert
    verify(request).getContextPath();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    Collection<String> headerNames = response2.getHeaderNames();
    assertEquals(1, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response3 = response2.getResponse();
    assertTrue(response3 instanceof FileSystemResponseWrapper);
    ServletResponse response4 = ((FileSystemResponseWrapper) response3).getResponse();
    assertTrue(response4 instanceof MockHttpServletResponse);
    assertEquals("http://", ((MockHttpServletResponse) response4).getRedirectedUrl());
    assertEquals(302, ((FileSystemResponseWrapper) response3).getStatus());
    assertEquals(302, ((MockHttpServletResponse) response4).getStatus());
    assertTrue(headerNames.contains("Location"));
    assertTrue(response3.isCommitted());
    assertTrue(response4.isCommitted());
    assertTrue(response2.isCommitted());
  }

  /**
   * Test
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}.
   * <ul>
   *   <li>Given {@code 8080}.</li>
   *   <li>Then throw {@link MalformedURLException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#sendRedirect(HttpServletRequest, HttpServletResponse, String)}
   */
  @Test
  public void testSendRedirect_given8080_thenThrowMalformedURLException() throws IOException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getServerPort()).thenReturn(8080);
    when(request.getServerName()).thenReturn("Server Name");
    when(request.getContextPath()).thenReturn("https://example.org/example");
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(MalformedURLException.class,
        () -> localRedirectStrategy
            .sendRedirect(request2,
                new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
                    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
                "https://example.org/example"));
    verify(request).getServerName();
    verify(request).getServerPort();
    verify(request).getContextPath();
    verify(request).getParameter(eq("successUrl"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   * <ul>
   *   <li>Then return {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  public void testCalculateRedirectUrl_thenReturnHttpsExampleOrgExample() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "https://example.org/example"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code http://}.</li>
   *   <li>Then return {@code http://}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  public void testCalculateRedirectUrl_whenHttp_thenReturnHttp() {
    // Arrange, Act and Assert
    assertEquals("http://", localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "http://"));
  }

  /**
   * Test {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}.
   * <ul>
   *   <li>When {@code Url}.</li>
   *   <li>Then return {@code https://example.org/exampleUrl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LocalRedirectStrategy#calculateRedirectUrl(String, String)}
   */
  @Test
  public void testCalculateRedirectUrl_whenUrl_thenReturnHttpsExampleOrgExampleUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/exampleUrl",
        localRedirectStrategy.calculateRedirectUrl("https://example.org/example", "Url"));
  }
}
