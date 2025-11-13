package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import com.googlecode.htmlcompressor.compressor.HtmlCompressor;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.util.HtmlMinifyFilter.CharResponseWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class HtmlMinifyFilterDiffblueTest {
  /**
   * Test CharResponseWrapper getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CharResponseWrapper#CharResponseWrapper(HtmlMinifyFilter, HttpServletResponse)}
   *   <li>{@link CharResponseWrapper#toString()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CharResponseWrapper.<init>(HtmlMinifyFilter, HttpServletResponse)",
    "String CharResponseWrapper.toString()"
  })
  public void testCharResponseWrapperGettersAndSetters() {
    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    CharResponseWrapper actualCharResponseWrapper =
        htmlMinifyFilter.new CharResponseWrapper(response);

    // Assert
    assertEquals("", actualCharResponseWrapper.toString());
    assertSame(response, actualCharResponseWrapper.getResponse());
  }

  /**
   * Test {@link HtmlMinifyFilter#getOrder()}.
   *
   * <p>Method under test: {@link HtmlMinifyFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int HtmlMinifyFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1001000, new HtmlMinifyFilter().getOrder());
  }

  /**
   * Test {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link HtmlMinifyFilter} (default constructor) init {@link
   *       MockFilterConfig#MockFilterConfig()}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HtmlMinifyFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_givenHtmlMinifyFilterInitMockFilterConfig_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    htmlMinifyFilter.init(new MockFilterConfig());
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    htmlMinifyFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link HtmlMinifyFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void HtmlMinifyFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_givenServletException_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    HtmlMinifyFilter htmlMinifyFilter = new HtmlMinifyFilter();
    MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            htmlMinifyFilter.doFilterInternal(
                httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   *
   * <ul>
   *   <li>When {@code /.}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HtmlMinifyFilter.isWidget(String)"})
  public void testIsWidget_whenSlashDot_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new HtmlMinifyFilter().isWidget("/."));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HtmlMinifyFilter.isWidget(String)"})
  public void testIsWidget_whenSlash_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new HtmlMinifyFilter().isWidget("/"));
  }

  /**
   * Test {@link HtmlMinifyFilter#isWidget(String)}.
   *
   * <ul>
   *   <li>When {@code Uri}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link HtmlMinifyFilter#isWidget(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean HtmlMinifyFilter.isWidget(String)"})
  public void testIsWidget_whenUri_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new HtmlMinifyFilter().isWidget("Uri"));
  }

  /**
   * Test {@link HtmlMinifyFilter#initFilterBean()}.
   *
   * <p>Method under test: {@link HtmlMinifyFilter#initFilterBean()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void HtmlMinifyFilter.initFilterBean()"})
  public void testInitFilterBean() {
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
}
