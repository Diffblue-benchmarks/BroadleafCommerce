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
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.CachingCompressedResponseFilter.BroadleafSpringResourceConfig;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class CachingCompressedResponseFilterDiffblueTest {
  @InjectMocks private CachingCompressedResponseFilter cachingCompressedResponseFilter;

  /**
   * Test BroadleafSpringResourceConfig {@link
   * BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}.
   *
   * <p>Method under test: {@link BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CacheAwareResponseHandler BroadleafSpringResourceConfig.blCacheAwareReponseHandler(int)"
  })
  public void testBroadleafSpringResourceConfigBlCacheAwareReponseHandler() {
    // Arrange and Act
    CacheAwareResponseHandler actualBlCacheAwareReponseHandlerResult =
        new BroadleafSpringResourceConfig().blCacheAwareReponseHandler(1);

    // Assert
    assertNull(actualBlCacheAwareReponseHandlerResult.getVaryByRequestHeaders());
    assertNull(actualBlCacheAwareReponseHandlerResult.getCacheControl());
    assertNull(actualBlCacheAwareReponseHandlerResult.getResourceHttpMessageConverter());
    assertNull(actualBlCacheAwareReponseHandlerResult.getResourceRegionHttpMessageConverter());
    assertNull(actualBlCacheAwareReponseHandlerResult.getContentNegotiationManager());
    assertNull(actualBlCacheAwareReponseHandlerResult.getUrlPathHelper());
    assertEquals(1, actualBlCacheAwareReponseHandlerResult.getCacheSeconds());
    assertEquals(2, actualBlCacheAwareReponseHandlerResult.getSupportedMethods().length);
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
  }

  /**
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(
                request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link FileSystemResponseWrapper#containsHeader(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenTrue_thenCallsContainsHeader()
      throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper request =
        new SessionlessHttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.containsHeader(Mockito.<String>any())).thenReturn(true);
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request2, response3, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).containsHeader("Content-Encoding");
  }

  /**
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#getOrder()}.
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CachingCompressedResponseFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001200, new CachingCompressedResponseFilter().getOrder());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CachingCompressedResponseFilter.getMimeType(HttpServletRequest)"})
  public void testGetMimeType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        cachingCompressedResponseFilter.getMimeType(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testProcessDynamic() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(
        "\u001f\b\u0000\u0000\u0000\u0000\u0000\u0000ÿ\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        ((MockHttpServletResponse) response3).getContentAsString());
    assertEquals(20, ((MockHttpServletResponse) response3).getContentLength());
    assertEquals(20L, ((MockHttpServletResponse) response3).getContentLengthLong());
    assertTrue(headerNames.contains("Content-Encoding"));
    assertTrue(headerNames.contains("Content-Length"));
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
    assertArrayEquals(
        new byte[] {31, -117, '\b', 0, 0, 0, 0, 0, 0, -1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        ((MockHttpServletResponse) response3).getContentAsByteArray());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testProcessDynamic2() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.getOutputStream())
        .thenReturn(new ServletOutputStreamWrapper(new ByteArrayOutputStream()));
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response3, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(20);
    verify(response).addHeader("Content-Encoding", "gzip");
    verify(response).getOutputStream();
    Collection<String> headerNames = response3.getHeaderNames();
    assertTrue(headerNames instanceof List);
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof StatusExposingServletResponse);
    assertFalse(response4.isCommitted());
    assertFalse(response3.isCommitted());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testProcessDynamic3() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.getOutputStream())
        .thenReturn(
            new ServletOutputStreamWrapper(
                new ServletOutputStreamWrapper(new ByteArrayOutputStream())));
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response3, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(20);
    verify(response).addHeader("Content-Encoding", "gzip");
    verify(response).getOutputStream();
    Collection<String> headerNames = response3.getHeaderNames();
    assertTrue(headerNames instanceof List);
    ServletResponse response4 = response3.getResponse();
    assertTrue(response4 instanceof StatusExposingServletResponse);
    assertFalse(response4.isCommitted());
    assertFalse(response3.isCommitted());
    assertTrue(headerNames.isEmpty());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FileSystemResponseWrapper} {@link
   *       FileSystemResponseWrapper#getOutputStream()} throw {@link IOException#IOException()}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testProcessDynamic_whenFileSystemResponseWrapperGetOutputStreamThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.getOutputStream()).thenThrow(new IOException());
    doNothing().when(response).setContentLength(anyInt());
    doNothing().when(response).addHeader(Mockito.<String>any(), Mockito.<String>any());
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);
    HttpServletResponseWrapper response3 = new HttpServletResponseWrapper(response2);

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> cachingCompressedResponseFilter.processDynamic(request, response3, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(response).setContentLength(20);
    verify(response).addHeader("Content-Encoding", "gzip");
    verify(response).getOutputStream();
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       throw {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CachingCompressedResponseFilter.processDynamic(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testProcessDynamic_whenFilterChainDoFilterThrowIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> cachingCompressedResponseFilter.processDynamic(request, response, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest,
   * HttpServletResponse, FilterChain, String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest,
   * HttpServletResponse, FilterChain, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CachingCompressedResponseFilter.processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)"
  })
  public void testProcessStatic_givenRuntimeException_thenThrowRuntimeException()
      throws IOException, ServletException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getRequestURI()).thenThrow(new RuntimeException());
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cachingCompressedResponseFilter.processStatic(
                request2,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class),
                "text/plain"));
    verify(request, atLeast(1)).getRequestURI();
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest,
   * HttpServletResponse, FilterChain, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest,
   * HttpServletResponse, FilterChain, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CachingCompressedResponseFilter.processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)"
  })
  public void testProcessStatic_thenReturnFalse() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(
        cachingCompressedResponseFilter.processStatic(
            request,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())),
            mock(FilterChain.class),
            "text/plain"));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link FileSystemResponseWrapper#containsHeader(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"
  })
  public void testUseGzipCompression_givenTrue_thenCallsContainsHeader()
      throws MalformedURLException {
    // Arrange
    SessionlessHttpServletRequestWrapper request =
        new SessionlessHttpServletRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));
    HttpServletRequestWrapper request2 = new HttpServletRequestWrapper(request);

    FileSystemResponseWrapper response = mock(FileSystemResponseWrapper.class);
    when(response.containsHeader(Mockito.<String>any())).thenReturn(true);
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(response);

    // Act
    boolean actualUseGzipCompressionResult =
        cachingCompressedResponseFilter.useGzipCompression(
            request2, new HttpServletResponseWrapper(response2));

    // Assert
    verify(response).containsHeader("Content-Encoding");
    assertFalse(actualUseGzipCompressionResult);
  }

  /**
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"
  })
  public void testUseGzipCompression_thenReturnFalse() throws MalformedURLException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualUseGzipCompressionResult =
        cachingCompressedResponseFilter.useGzipCompression(
            request,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    assertFalse(actualUseGzipCompressionResult);
  }
}
