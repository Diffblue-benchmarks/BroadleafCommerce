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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafThemeResolverFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafThemeResolverFilterDiffblueTest {
  @MockBean(name = "blThemeProcessor")
  private BroadleafThemeProcessor broadleafThemeProcessor;

  @Autowired private BroadleafThemeResolverFilter broadleafThemeResolverFilter;

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafThemeProcessor)
        .postProcess(Mockito.<WebRequest>any());
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafThemeProcessor)
        .process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new SiteNotFoundException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    assertEquals(404, response.getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code blcadmin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenBlcadmin()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("Request");
    request.setRequestURI("blcadmin");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenOrgBroadleafcommerceAdmin()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("Request");
    request.setRequestURI("org.broadleafcommerce.admin");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code .service}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenService()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("Request");
    request.setRequestURI(".service");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenMockHttpServletResponseStatusIsTwoHundred()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenMockHttpServletResponseStatusIsTwoHundred2()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    assertEquals(200, response.getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link HaltFilterChainException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenThrowHaltFilterChainException()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockMultipartHttpServletRequest request =
        new MockMultipartHttpServletRequest(new MockServletContext());
    request.setContextPath("Request");
    request.setRequestURI("org.broadleafcommerce.admin");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), "org.broadleafcommerce.admin", true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example", true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenBlcadmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), "blcadmin", true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code .service}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenService() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), ".service", true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(new MockHttpServletRequest(), "blcadmin"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new MockHttpServletRequest(), "org.broadleafcommerce.admin"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code .service}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(new MockHttpServletRequest(), ".service"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BroadleafThemeResolverFilter.getIgnoreSuffixes()"})
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafThemeResolverFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafThemeResolverFilter.shouldNotFilterErrorDispatch()"})
  public void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(broadleafThemeResolverFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getOrder()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafThemeResolverFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10100, broadleafThemeResolverFilter.getOrder());
  }
}
