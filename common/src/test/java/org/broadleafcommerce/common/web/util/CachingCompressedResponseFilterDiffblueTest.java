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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.CachingCompressedResponseFilter.BroadleafSpringResourceConfig;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class CachingCompressedResponseFilterDiffblueTest {
  /**
   * Test BroadleafSpringResourceConfig
   * {@link BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}.
   * <p>
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
   * Test
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
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
   * Test
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code Content-Encoding}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_givenContentEncoding() throws IOException, ServletException {
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
   * Test
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.</li>
   *   <li>Then calls
   * {@link DefaultMultipartHttpServletRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_givenFalseToString_thenCallsGetParameter()
      throws IOException, ServletException {
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
   * Test {@link CachingCompressedResponseFilter#getOrder()}.
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001200, (new CachingCompressedResponseFilter()).getOrder());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}.
   * <p>
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
   * Test {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   *   <li>Then calls {@link HttpServletRequestWrapper#getRequestURI()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  public void testGetMimeType_givenHttpsExampleOrgExample_thenCallsGetRequestURI() {
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
   * Test
   * {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)}
   */
  @Test
  public void testProcessStatic_thenReturnFalse() throws IOException, ServletException {
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
   * Test
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <p>
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
   * Test
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code Content-Encoding}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression_givenContentEncoding() throws IOException {
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

  /**
   * Test
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression_givenFalseToString() throws IOException {
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
   * Test
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testUseGzipCompression_thenReturnTrue() throws IOException {
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
}
