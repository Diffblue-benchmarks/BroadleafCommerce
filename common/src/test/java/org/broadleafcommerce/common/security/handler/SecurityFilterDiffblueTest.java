package org.broadleafcommerce.common.security.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateServiceException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {SecurityFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SecurityFilterDiffblueTest {
  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  @Autowired private SecurityFilter securityFilter;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled())
        .thenThrow(new StaleStateServiceException("An error occurred"));
    MockHttpServletRequest request = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal2() throws IOException, ServletException {
    // Arrange
    when(exploitProtectionService.getCsrfTokenParameter())
        .thenThrow(new StaleStateServiceException("An error occurred"));

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal3() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal4() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new StaleStateServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal5() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new StaleStateServiceException("An error occurred"));
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal6() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new StaleStateServiceException("An error occurred"))
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            securityFilter.doFilterInternal(
                request, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal7() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.isEnabled()).thenReturn(false);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_givenServletException() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> securityFilter.doFilterInternal(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link StaleStateProtectionService#compareToken(String)}.
   * </ul>
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenCallsCompareToken()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is four hundred three.
   * </ul>
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenMockHttpServletResponseStatusIsFourHundredThree()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SecurityServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setMethod("POST");
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    securityFilter.doFilterInternal(request, response, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    assertEquals(403, response.getStatus());
    assertTrue(response.isCommitted());
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) Status is two hundred.
   * </ul>
   *
   * <p>Method under test: {@link SecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenMockHttpServletResponseStatusIsTwoHundred()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
    assertEquals(200, response.getStatus());
    assertFalse(response.isCommitted());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SecurityFilter#setExcludedRequestPatterns(List)}
   *   <li>{@link SecurityFilter#getExcludedRequestPatterns()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List SecurityFilter.getExcludedRequestPatterns()",
    "void SecurityFilter.setExcludedRequestPatterns(List)"
  })
  public void testGettersAndSetters() {
    // Arrange
    SecurityFilter securityFilter = new SecurityFilter();
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();

    // Act
    securityFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    List<String> actualExcludedRequestPatterns = securityFilter.getExcludedRequestPatterns();

    // Assert
    assertTrue(actualExcludedRequestPatterns.isEmpty());
    assertSame(excludedRequestPatterns, actualExcludedRequestPatterns);
  }
}
