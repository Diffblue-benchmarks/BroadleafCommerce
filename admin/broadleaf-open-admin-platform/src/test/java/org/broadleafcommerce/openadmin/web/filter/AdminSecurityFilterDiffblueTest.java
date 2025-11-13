package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
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
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {AdminSecurityFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AdminSecurityFilterDiffblueTest {
  @Autowired private AdminSecurityFilter adminSecurityFilter;

  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenThrow(new StaleStateServiceException());
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal2() throws IOException, ServletException {
    // Arrange
    when(exploitProtectionService.getCsrfTokenParameter())
        .thenThrow(new StaleStateServiceException());

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal3() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new StaleStateServiceException())
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal4() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal5() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new StaleStateServiceException());
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal6() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[] {}, baseResponse.getContentAsByteArray());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal7() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new StaleStateServiceException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals(
        "Stale State Detected\norg.broadleafcommerce.common.security.service.StaleStateServiceException\n",
        baseResponse.getContentAsString());
    assertEquals(409, baseResponse.getStatus());
    assertEquals(94, baseResponse.getContentAsByteArray().length);
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal8() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.isEnabled()).thenReturn(false);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[] {}, baseResponse.getContentAsByteArray());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_givenServletException() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException())
        .when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () -> adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then {@link MockHttpServletResponse} (default constructor) ContentAsString is empty
   *       string.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenMockHttpServletResponseContentAsStringIsEmptyString()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminSecurityFilter.doFilterInternal(baseRequest, baseResponse, chain);

    // Assert that nothing has changed
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
    assertEquals("", baseResponse.getContentAsString());
    assertEquals(200, baseResponse.getStatus());
    assertArrayEquals(new byte[] {}, baseResponse.getContentAsByteArray());
  }

  /**
   * Test {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link SessionAuthenticationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSecurityFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AdminSecurityFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenThrowSessionAuthenticationException()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new SessionAuthenticationException("POST"))
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest();
    baseRequest.setMethod("POST");

    // Act and Assert
    assertThrows(
        SessionAuthenticationException.class,
        () ->
            adminSecurityFilter.doFilterInternal(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).isEnabled();
  }
}
