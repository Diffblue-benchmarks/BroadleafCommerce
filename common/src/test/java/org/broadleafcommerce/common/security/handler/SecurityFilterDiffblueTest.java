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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.exception.SecurityServiceException;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateServiceException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

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
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, response.getStatus());
    assertEquals(200, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(response3.isCommitted());
    assertFalse(response.isCommitted());
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
  public void testDoFilterInternal3() throws IOException, ServletException {
    // Arrange
    when(exploitProtectionService.getCsrfTokenParameter())
        .thenThrow(new StaleStateServiceException("An error occurred"));
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
    doThrow(new SecurityServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    // Act
    securityFilter.doFilterInternal(request, response, mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(null);
    verify(exploitProtectionService).getCsrfTokenParameter();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(403, response.getStatus());
    assertEquals(403, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(403, ((MockHttpServletResponse) response3).getStatus());
    assertTrue(response2.isCommitted());
    assertTrue(response3.isCommitted());
    assertTrue(response.isCommitted());
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
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
  public void testDoFilterInternal6() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new StaleStateServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
  public void testDoFilterInternal7() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new StaleStateServiceException("An error occurred"));
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
  public void testDoFilterInternal8() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

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
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, response.getStatus());
    assertEquals(200, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(response3.isCommitted());
    assertFalse(response.isCommitted());
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
  public void testDoFilterInternal9() throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new StaleStateServiceException("An error occurred"))
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockMultipartHttpServletRequest()));

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            securityFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
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
  public void testDoFilterInternal10() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(false);

    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenReturn("https://example.org/example");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(request).getMethod();
    verify(staleStateProtectionService).isEnabled();
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, response.getStatus());
    assertEquals(200, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
    assertFalse(response2.isCommitted());
    assertFalse(response3.isCommitted());
    assertFalse(response.isCommitted());
  }

  /**
   * Test {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException(String)} with message is {@code An error
   *       occurred}.
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
  public void testDoFilterInternal_givenServletExceptionWithMessageIsAnErrorOccurred()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred"))
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
   *   <li>Given {@link StaleStateServiceException#StaleStateServiceException(String)} with message
   *       is {@code An error occurred}.
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
  public void testDoFilterInternal_givenStaleStateServiceExceptionWithMessageIsAnErrorOccurred()
      throws IOException, ServletException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new StaleStateServiceException("An error occurred"));
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act and Assert
    assertThrows(
        StaleStateServiceException.class,
        () ->
            securityFilter.doFilterInternal(
                request3,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
    verify(request).getMethod();
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
