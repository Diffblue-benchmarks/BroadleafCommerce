package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertThrows;
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
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AdminCsrfFilterDiffblueTest {
  @InjectMocks private AdminCsrfFilter adminCsrfFilter;

  @Mock private AuthenticationFailureHandler authenticationFailureHandler;

  @Mock private ExploitProtectionService exploitProtectionService;

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    when(exploitProtectionService.getCsrfTokenParameter())
        .thenThrow(new SessionAuthenticationException("POST"));

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        SessionAuthenticationException.class,
        () ->
            adminCsrfFilter.doFilter(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter2() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SessionAuthenticationException("POST"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        SessionAuthenticationException.class,
        () ->
            adminCsrfFilter.doFilter(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter3() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new ServletException())
        .when(authenticationFailureHandler)
        .onAuthenticationFailure(
            Mockito.<HttpServletRequest>any(),
            Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            adminCsrfFilter.doFilter(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(authenticationFailureHandler)
        .onAuthenticationFailure(
            isA(HttpServletRequest.class),
            isA(HttpServletResponse.class),
            isA(AuthenticationException.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link AdminCsrfFilter} (default constructor) ExcludedRequestPatterns is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenAdminCsrfFilterExcludedRequestPatternsIsArrayList()
      throws IOException, ServletException {
    // Arrange
    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    adminCsrfFilter.setExcludedRequestPatterns(new ArrayList<>());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link AdminCsrfFilter} (default constructor).
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenAdminCsrfFilter_whenMockHttpServletRequest_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code not blank}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenArrayListAddNotBlank_whenMockHttpServletRequest()
      throws IOException, ServletException {
    // Arrange
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("not blank");

    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    adminCsrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code /**}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenArrayListAddSlashAsteriskAsterisk()
      throws IOException, ServletException {
    // Arrange
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("/**");

    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    adminCsrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);

    MockMultipartHttpServletRequest baseRequest =
        new MockMultipartHttpServletRequest(new MockServletContext());
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given Bean Name{blExploitProtectionService} {@link
   *       ExploitProtectionService#compareToken(String)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenBeanNameBlExploitProtectionServiceCompareTokenDoesNothing()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       throw {@link ServletException#ServletException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenServletException_whenFilterChainDoFilterThrowServletException()
      throws IOException, ServletException {
    // Arrange
    AdminCsrfFilter adminCsrfFilter = new AdminCsrfFilter();
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class, () -> adminCsrfFilter.doFilter(baseRequest, baseResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link
   *       AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest,
   *       HttpServletResponse, AuthenticationException)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_thenCallsOnAuthenticationFailure()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing()
        .when(authenticationFailureHandler)
        .onAuthenticationFailure(
            Mockito.<HttpServletRequest>any(),
            Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act
    adminCsrfFilter.doFilter(baseRequest, new MockHttpServletResponse(), mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(authenticationFailureHandler)
        .onAuthenticationFailure(
            isA(HttpServletRequest.class),
            isA(HttpServletResponse.class),
            isA(AuthenticationException.class));
  }
}
