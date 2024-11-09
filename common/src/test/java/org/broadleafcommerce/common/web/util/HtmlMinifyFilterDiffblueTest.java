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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class HtmlMinifyFilterDiffblueTest {
  /**
   * Test CharResponseWrapper getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link HtmlMinifyFilter.CharResponseWrapper#CharResponseWrapper(HtmlMinifyFilter, HttpServletResponse)}
   *   <li>{@link HtmlMinifyFilter.CharResponseWrapper#toString()}
   * </ul>
   */
  @Test
  public void testCharResponseWrapperGettersAndSetters() throws IOException {
    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Act
    HtmlMinifyFilter.CharResponseWrapper actualCharResponseWrapper = htmlMinifyFilter.new CharResponseWrapper(
        response2);

    // Assert
    assertEquals("", actualCharResponseWrapper.toString());
    assertSame(response2, actualCharResponseWrapper.getResponse());
  }

  /**
   * Test {@link HtmlMinifyFilter#getOrder()}.
   * <p>
   * Method under test: {@link HtmlMinifyFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001000, (new HtmlMinifyFilter()).getOrder());
  }

  /**
   * Test
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code .html}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenHtml() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getRequestURI()).thenReturn(".html");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> htmlMinifyFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getRequestURI();
  }

  /**
   * Test
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenHttpsExampleOrgExample() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getRequestURI()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> htmlMinifyFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getRequestURI();
  }

  /**
   * Test
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code /}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenSlash() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getRequestURI()).thenReturn("/");
    MockHttpServletResponse response = new MockHttpServletResponse();
    new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> htmlMinifyFilter.doFilterInternal(httpServletRequest, null, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isNull());
    verify(httpServletRequest).getRequestURI();
  }

  /**
   * Test
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_whenFilterChainDoFilterDoesNothing() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getRequestURI()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    htmlMinifyFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getRequestURI();
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor) Environment is
   * {@link StandardEnvironment}.</li>
   *   <li>When {@code Uri}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  public void testIsWidget_givenHtmlMinifyFilterEnvironmentIsStandardEnvironment_whenUri() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    htmlMinifyFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(htmlMinifyFilter.isWidget("Uri"));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor).</li>
   *   <li>When {@code /.}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  public void testIsWidget_givenHtmlMinifyFilter_whenSlashDot_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new HtmlMinifyFilter()).isWidget("/."));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor).</li>
   *   <li>When {@code /}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  public void testIsWidget_givenHtmlMinifyFilter_whenSlash_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new HtmlMinifyFilter()).isWidget("/"));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor).</li>
   *   <li>When {@code Uri}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  public void testIsWidget_givenHtmlMinifyFilter_whenUri_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new HtmlMinifyFilter()).isWidget("Uri"));
  }

  /**
   * Test {@link HtmlMinifyFilter#initFilterBean()}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#initFilterBean()}
   */
  @Test
  public void testInitFilterBean_givenHtmlMinifyFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();

    // Act
    htmlMinifyFilter.initFilterBean();

    // Assert
    HtmlCompressor htmlCompressor = htmlMinifyFilter.compressor;
    assertNull(htmlCompressor.getCssCompressor());
    assertNull(htmlCompressor.getJavaScriptCompressor());
    assertNull(htmlCompressor.getStatistics());
    assertNull(htmlCompressor.getRemoveSurroundingSpaces());
    assertNull(htmlCompressor.getPreservePatterns());
    assertNull(htmlCompressor.getYuiErrorReporter());
    assertEquals(-1, htmlCompressor.getYuiCssLineBreak());
    assertEquals(-1, htmlCompressor.getYuiJsLineBreak());
    assertFalse(htmlCompressor.isGenerateStatistics());
    assertFalse(htmlCompressor.isPreserveLineBreaks());
    assertFalse(htmlCompressor.isRemoveFormAttributes());
    assertFalse(htmlCompressor.isRemoveHttpProtocol());
    assertFalse(htmlCompressor.isRemoveHttpsProtocol());
    assertFalse(htmlCompressor.isRemoveInputAttributes());
    assertFalse(htmlCompressor.isRemoveIntertagSpaces());
    assertFalse(htmlCompressor.isRemoveJavaScriptProtocol());
    assertFalse(htmlCompressor.isRemoveLinkAttributes());
    assertFalse(htmlCompressor.isRemoveQuotes());
    assertFalse(htmlCompressor.isRemoveScriptAttributes());
    assertFalse(htmlCompressor.isRemoveStyleAttributes());
    assertFalse(htmlCompressor.isSimpleBooleanAttributes());
    assertFalse(htmlCompressor.isSimpleDoctype());
    assertFalse(htmlCompressor.isYuiJsDisableOptimizations());
    assertFalse(htmlCompressor.isYuiJsNoMunge());
    assertFalse(htmlCompressor.isYuiJsPreserveAllSemiColons());
    assertTrue(htmlCompressor.isCompressCss());
    assertTrue(htmlCompressor.isCompressJavaScript());
    assertTrue(htmlCompressor.isEnabled());
    assertTrue(htmlCompressor.isRemoveComments());
    assertTrue(htmlCompressor.isRemoveMultiSpaces());
  }

  /**
   * Test {@link HtmlMinifyFilter#initFilterBean()}.
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor) Environment is
   * {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link HtmlMinifyFilter#initFilterBean()}
   */
  @Test
  public void testInitFilterBean_givenHtmlMinifyFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    htmlMinifyFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act
    htmlMinifyFilter.initFilterBean();

    // Assert
    HtmlCompressor htmlCompressor = htmlMinifyFilter.compressor;
    assertNull(htmlCompressor.getCssCompressor());
    assertNull(htmlCompressor.getJavaScriptCompressor());
    assertNull(htmlCompressor.getStatistics());
    assertNull(htmlCompressor.getRemoveSurroundingSpaces());
    assertNull(htmlCompressor.getPreservePatterns());
    assertNull(htmlCompressor.getYuiErrorReporter());
    assertEquals(-1, htmlCompressor.getYuiCssLineBreak());
    assertEquals(-1, htmlCompressor.getYuiJsLineBreak());
    assertFalse(htmlCompressor.isGenerateStatistics());
    assertFalse(htmlCompressor.isPreserveLineBreaks());
    assertFalse(htmlCompressor.isRemoveFormAttributes());
    assertFalse(htmlCompressor.isRemoveHttpProtocol());
    assertFalse(htmlCompressor.isRemoveHttpsProtocol());
    assertFalse(htmlCompressor.isRemoveInputAttributes());
    assertFalse(htmlCompressor.isRemoveIntertagSpaces());
    assertFalse(htmlCompressor.isRemoveJavaScriptProtocol());
    assertFalse(htmlCompressor.isRemoveLinkAttributes());
    assertFalse(htmlCompressor.isRemoveQuotes());
    assertFalse(htmlCompressor.isRemoveScriptAttributes());
    assertFalse(htmlCompressor.isRemoveStyleAttributes());
    assertFalse(htmlCompressor.isSimpleBooleanAttributes());
    assertFalse(htmlCompressor.isSimpleDoctype());
    assertFalse(htmlCompressor.isYuiJsDisableOptimizations());
    assertFalse(htmlCompressor.isYuiJsNoMunge());
    assertFalse(htmlCompressor.isYuiJsPreserveAllSemiColons());
    assertTrue(htmlCompressor.isCompressCss());
    assertTrue(htmlCompressor.isCompressJavaScript());
    assertTrue(htmlCompressor.isEnabled());
    assertTrue(htmlCompressor.isRemoveComments());
    assertTrue(htmlCompressor.isRemoveMultiSpaces());
  }
}
