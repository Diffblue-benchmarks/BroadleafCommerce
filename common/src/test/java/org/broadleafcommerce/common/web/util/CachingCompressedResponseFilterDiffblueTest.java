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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.DelegatingServletOutputStream;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class CachingCompressedResponseFilterDiffblueTest {
  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter.BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}
   */
  @Test
  public void testBroadleafSpringResourceConfigBlCacheAwareReponseHandler() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CacheAwareResponseHandler actualBlCacheAwareReponseHandlerResult = (new CachingCompressedResponseFilter.BroadleafSpringResourceConfig())
        .blCacheAwareReponseHandler(1);

    // Assert
    assertNull(actualBlCacheAwareReponseHandlerResult.getVaryByRequestHeaders());
    assertNull(actualBlCacheAwareReponseHandlerResult.getCacheControl());
    assertNull(actualBlCacheAwareReponseHandlerResult.getResourceHttpMessageConverter());
    assertNull(actualBlCacheAwareReponseHandlerResult.getResourceRegionHttpMessageConverter());
    assertNull(actualBlCacheAwareReponseHandlerResult.getContentNegotiationManager());
    assertNull(actualBlCacheAwareReponseHandlerResult.getUrlPathHelper());
    assertEquals(1, actualBlCacheAwareReponseHandlerResult.getCacheSeconds());
    assertFalse(actualBlCacheAwareReponseHandlerResult.isOptimizeLocations());
    assertFalse(actualBlCacheAwareReponseHandlerResult.isAlwaysMustRevalidate());
    assertFalse(actualBlCacheAwareReponseHandlerResult.isRequireSession());
    assertFalse(actualBlCacheAwareReponseHandlerResult.isUseExpiresHeader());
    assertTrue(actualBlCacheAwareReponseHandlerResult.getLocations().isEmpty());
    assertTrue(actualBlCacheAwareReponseHandlerResult.getResourceResolvers().isEmpty());
    assertTrue(actualBlCacheAwareReponseHandlerResult.getResourceTransformers().isEmpty());
    assertTrue(actualBlCacheAwareReponseHandlerResult.getMediaTypes().isEmpty());
    assertTrue(actualBlCacheAwareReponseHandlerResult.isUseLastModified());
    assertTrue(actualBlCacheAwareReponseHandlerResult.isUseCacheControlHeader());
    assertTrue(actualBlCacheAwareReponseHandlerResult.isUseCacheControlNoStore());
    assertArrayEquals(new String[]{"GET", "HEAD"}, actualBlCacheAwareReponseHandlerResult.getSupportedMethods());
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request, response2, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(Boolean.FALSE.toString());
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request2, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(request).getParameter(eq("gzip"));
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    response2.addDateHeader("Content-Encoding", 1L);
    StatusExposingServletResponse response3 = new StatusExposingServletResponse(response2);
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request, response3, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Method under test: {@link CachingCompressedResponseFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001200, (new CachingCompressedResponseFilter()).getOrder());
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  public void testGetMimeType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();

    // Act and Assert
    assertNull(cachingCompressedResponseFilter
        .getMimeType(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  public void testGetMimeType2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getRequestURI()).thenReturn("https://example.org/example");

    // Act
    String actualMimeType = cachingCompressedResponseFilter.getMimeType(request);

    // Assert
    verify(request).getRequestURI();
    assertNull(actualMimeType);
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testProcessDynamic() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    Paths.get(System.getProperty("java.io.tmpdir"), "").toFile();
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    ServletOutputStreamWrapper servletOutputStreamWrapper = new ServletOutputStreamWrapper(
        new ByteArrayOutputStream(1));
    when(response.getOutputStream()).thenReturn(servletOutputStreamWrapper);
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(eq(20));
    verify(response).addHeader(eq("Content-Encoding"), eq("gzip"));
    verify(response).getOutputStream();
    ServletOutputStream outputStream = response2.getOutputStream();
    assertTrue(outputStream instanceof ServletOutputStreamWrapper);
    assertSame(servletOutputStreamWrapper, outputStream);
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testProcessDynamic2() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    Paths.get(System.getProperty("java.io.tmpdir"), "").toFile();
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    ServletOutputStreamWrapper servletOutputStreamWrapper = new ServletOutputStreamWrapper(
        new ServletOutputStreamWrapper(new ByteArrayOutputStream(1)));
    when(response.getOutputStream()).thenReturn(servletOutputStreamWrapper);
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(eq(20));
    verify(response).addHeader(eq("Content-Encoding"), eq("gzip"));
    verify(response).getOutputStream();
    ServletOutputStream outputStream = response2.getOutputStream();
    assertTrue(outputStream instanceof ServletOutputStreamWrapper);
    assertSame(servletOutputStreamWrapper, outputStream);
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testProcessDynamic3() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    Paths.get(System.getProperty("java.io.tmpdir"), "").toFile();
    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    DelegatingServletOutputStream delegatingServletOutputStream = new DelegatingServletOutputStream(
        new ByteArrayOutputStream(1024));
    when(response.getOutputStream()).thenReturn(delegatingServletOutputStream);
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(eq(20));
    verify(response).addHeader(eq("Content-Encoding"), eq("gzip"));
    verify(response).getOutputStream();
    assertSame(delegatingServletOutputStream, response2.getOutputStream());
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)}
   */
  @Test
  public void testProcessStatic() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(cachingCompressedResponseFilter.processStatic(request,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        mock(FilterChain.class), "Mime Type"));
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(cachingCompressedResponseFilter.useGzipCompression(request,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression2() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(Boolean.FALSE.toString());
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualUseGzipCompressionResult = cachingCompressedResponseFilter.useGzipCompression(request2,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(request).getParameter(eq("gzip"));
    assertFalse(actualUseGzipCompressionResult);
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression3() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    IteratorEnumeration<String> iteratorEnumeration = mock(IteratorEnumeration.class);
    when(iteratorEnumeration.nextElement()).thenReturn("gzip");
    when(iteratorEnumeration.hasMoreElements()).thenReturn(true);
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getHeaders(Mockito.<String>any())).thenReturn(iteratorEnumeration);
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualUseGzipCompressionResult = cachingCompressedResponseFilter.useGzipCompression(request2,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(request).getHeaders(eq("Accept-Encoding"));
    verify(iteratorEnumeration).hasMoreElements();
    verify(iteratorEnumeration).nextElement();
    verify(request).getParameter(eq("gzip"));
    assertTrue(actualUseGzipCompressionResult);
  }

  /**
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression4() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        mock(DefaultMultipartHttpServletRequest.class));
    MockHttpServletResponse response = new MockHttpServletResponse();

    FileSystemResponseWrapper response2 = new FileSystemResponseWrapper(response,
        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());
    response2.addDateHeader("Content-Encoding", 1L);

    // Act and Assert
    assertFalse(
        cachingCompressedResponseFilter.useGzipCompression(request, new StatusExposingServletResponse(response2)));
  }
}
