package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.web.exception.HaltFilterChainException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafRequestFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafRequestFilterDiffblueTest {
  @Autowired private BroadleafRequestFilter broadleafRequestFilter;

  @MockBean(name = "blRequestProcessor")
  private BroadleafRequestProcessor broadleafRequestProcessor;

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new SiteNotFoundException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("org.broadleafcommerce.admin");
    request.addParameter("org.broadleafcommerce.admin", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenEmptyString()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setQueryString("");
    request.addParameter("org.broadleafcommerce.admin", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenOrgBroadleafcommerceAdmin()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("org.broadleafcommerce.admin", "42");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link HaltFilterChainException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenThrowHaltFilterChainException()
      throws IOException, ServletException {
    // Arrange
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafRequestProcessor)
        .postProcess(Mockito.<WebRequest>any());
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafRequestProcessor)
        .process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafRequestFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "org.broadleafcommerce.admin", false));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_givenFalse() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualShouldProcessURLResult =
        broadleafRequestFilter.shouldProcessURL(request, "https://example.org/example", false);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_givenTrue() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualShouldProcessURLResult =
        broadleafRequestFilter.shouldProcessURL(request, "https://example.org/example", false);

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example", false));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenBlcadmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafRequestFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin", false));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code .service}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenService() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafRequestFilter.shouldProcessURL(new MockHttpServletRequest(), ".service", false));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String, boolean)} with
   * {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example", true));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_givenFalse() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualShouldProcessURLResult =
        broadleafRequestFilter.shouldProcessURL(request, "https://example.org/example");

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_givenTrue() {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualShouldProcessURLResult =
        broadleafRequestFilter.shouldProcessURL(request, "https://example.org/example");

    // Assert
    verify(request).getAttribute("blOkToUseSession");
    assertTrue(actualShouldProcessURLResult);
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin"));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafRequestFilter.shouldProcessURL(
            new MockHttpServletRequest(), "org.broadleafcommerce.admin"));
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest, String)} with {@code
   * request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code .service}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldProcessURL(HttpServletRequest, String)"})
  public void testShouldProcessURLWithRequestRequestURI_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafRequestFilter.shouldProcessURL(new MockHttpServletRequest(), ".service"));
  }

  /**
   * Test {@link BroadleafRequestFilter#getIgnoreSuffixes()}.
   *
   * <p>Method under test: {@link BroadleafRequestFilter#getIgnoreSuffixes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BroadleafRequestFilter.getIgnoreSuffixes()"})
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafRequestFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link BroadleafRequestFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafRequestFilter.shouldNotFilterErrorDispatch()"})
  public void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(broadleafRequestFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafRequestFilter#getOrder()}.
   *
   * <p>Method under test: {@link BroadleafRequestFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafRequestFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-10000, broadleafRequestFilter.getOrder());
  }
}
