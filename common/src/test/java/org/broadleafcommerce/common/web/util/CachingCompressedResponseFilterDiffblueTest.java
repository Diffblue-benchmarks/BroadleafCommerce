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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.iterators.IteratorEnumeration;
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
  @InjectMocks
  private BroadleafSpringResourceConfig broadleafSpringResourceConfig;

  /**
   * Test BroadleafSpringResourceConfig {@link BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}.
   * <p>
   * Method under test: {@link BroadleafSpringResourceConfig#blCacheAwareReponseHandler(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CacheAwareResponseHandler BroadleafSpringResourceConfig.blCacheAwareReponseHandler(int)"})
  public void testBroadleafSpringResourceConfigBlCacheAwareReponseHandler() {
    // Arrange and Act
    CacheAwareResponseHandler actualBlCacheAwareReponseHandlerResult = broadleafSpringResourceConfig
        .blCacheAwareReponseHandler(1);

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
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
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

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code Content-Encoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_givenContentEncoding() throws IOException, ServletException {
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

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.</li>
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void CachingCompressedResponseFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_givenFalseToString_thenCallsGetParameter()
      throws IOException, ServletException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CachingCompressedResponseFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001200, (new CachingCompressedResponseFilter()).getOrder());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String CachingCompressedResponseFilter.getMimeType(HttpServletRequest)"})
  public void testGetMimeType_thenReturnNull() {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter = new CachingCompressedResponseFilter();

    // Act and Assert
    assertNull(cachingCompressedResponseFilter
        .getMimeType(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CachingCompressedResponseFilter.processStatic(HttpServletRequest, HttpServletResponse, FilterChain, String)"})
  public void testProcessStatic_thenReturnFalse() throws IOException, ServletException {
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
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"})
  public void testUseGzipCompression() throws IOException {
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
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code Content-Encoding}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"})
  public void testUseGzipCompression_givenContentEncoding() throws IOException {
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
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link Boolean#FALSE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"})
  public void testUseGzipCompression_givenFalseToString() throws IOException {
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
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean CachingCompressedResponseFilter.useGzipCompression(HttpServletRequest, HttpServletResponse)"})
  public void testUseGzipCompression_thenReturnTrue() throws IOException {
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
