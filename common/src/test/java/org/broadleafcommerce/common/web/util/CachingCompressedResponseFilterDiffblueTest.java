package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.util.CachingCompressedResponseFilter.BroadleafSpringResourceConfig;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CachingCompressedResponseFilterDiffblueTest {
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
   *   <li>Given {@code gzip}.
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
  public void testDoFilterInternalUnlessIgnored_givenGzip() throws IOException, ServletException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("gzip", Boolean.FALSE.toString());
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.doFilterInternalUnlessIgnored(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
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
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
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
  public void testDoFilterInternalUnlessIgnored_whenMockHttpServletRequest()
      throws IOException, ServletException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
   * <p>Method under test: {@link CachingCompressedResponseFilter#getMimeType(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String CachingCompressedResponseFilter.getMimeType(HttpServletRequest)"})
  public void testGetMimeType() {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();

    // Act and Assert
    assertNull(cachingCompressedResponseFilter.getMimeType(new MockHttpServletRequest()));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
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
  public void testProcessDynamic_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

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
   * Test {@link CachingCompressedResponseFilter#processDynamic(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) HeaderNames size is two.
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
  public void testProcessDynamic_thenMockHttpServletResponseHeaderNamesSizeIsTwo()
      throws IOException, ServletException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cachingCompressedResponseFilter.processDynamic(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    Collection<String> headerNames = response.getHeaderNames();
    assertEquals(2, headerNames.size());
    assertTrue(headerNames instanceof Set);
    assertEquals(
        "\u001f\b\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0003\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000",
        response.getContentAsString());
    assertEquals(20, response.getContentLength());
    assertEquals(20L, response.getContentLengthLong());
    assertTrue(headerNames.contains("Content-Encoding"));
    assertTrue(headerNames.contains("Content-Length"));
    assertTrue(response.isCommitted());
    assertArrayEquals(
        new byte[] {31, -117, '\b', 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        response.getContentAsByteArray());
  }

  /**
   * Test {@link CachingCompressedResponseFilter#processStatic(HttpServletRequest,
   * HttpServletResponse, FilterChain, String)}.
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
  public void testProcessStatic() throws IOException, ServletException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        cachingCompressedResponseFilter.processStatic(
            request, new MockHttpServletResponse(), mock(FilterChain.class), "text/plain"));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code gzip}.
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
  public void testUseGzipCompression_givenGzip() throws MalformedURLException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("gzip", Boolean.FALSE.toString());

    // Act and Assert
    assertFalse(
        cachingCompressedResponseFilter.useGzipCompression(request, new MockHttpServletResponse()));
  }

  /**
   * Test {@link CachingCompressedResponseFilter#useGzipCompression(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
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
  public void testUseGzipCompression_whenMockHttpServletRequest() throws MalformedURLException {
    // Arrange
    CachingCompressedResponseFilter cachingCompressedResponseFilter =
        new CachingCompressedResponseFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertFalse(
        cachingCompressedResponseFilter.useGzipCompression(request, new MockHttpServletResponse()));
  }
}
