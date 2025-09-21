/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
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
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

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
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
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
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter2() throws IOException, ServletException {
    // Arrange
    when(exploitProtectionService.getCsrfTokenParameter())
        .thenThrow(new SessionAuthenticationException("POST"));
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockMultipartHttpServletRequest()));

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
  public void testDoFilter3() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SessionAuthenticationException("POST"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockMultipartHttpServletRequest()));

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
  public void testDoFilter4() throws IOException, ServletException, ServiceException {
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
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockMultipartHttpServletRequest()));

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
  public void testDoFilter5() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new ServletException("An error occurred"))
        .when(authenticationFailureHandler)
        .onAuthenticationFailure(
            Mockito.<HttpServletRequest>any(),
            Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockMultipartHttpServletRequest()));

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
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter6() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new SessionAuthenticationException("POST"))
        .when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    adminCsrfFilter.setExcludedRequestPatterns(new ArrayList<>());

    MockHttpServletRequest baseRequest = new MockHttpServletRequest(new MockServletContext());
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
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenArrayListAddFoo()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");

    ArrayList<String> excludedRequestPatterns = new ArrayList<>();
    excludedRequestPatterns.add("foo");
    adminCsrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest(new MockServletContext());
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
    adminCsrfFilter.setExcludedRequestPatterns(excludedRequestPatterns);

    MockHttpServletRequest baseRequest = new MockHttpServletRequest(new MockServletContext());
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
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockMultipartHttpServletRequest()));
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
   *   <li>Given {@link ServletException#ServletException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenServletExceptionWithMessageIsAnErrorOccurred()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper baseRequest =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();

    FilterChain chain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred"))
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
   *   <li>Given {@link SessionAuthenticationException#SessionAuthenticationException(String)} with
   *       msg is {@code POST}.
   *   <li>Then calls {@link DefaultMultipartHttpServletRequest#getMethod()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenSessionAuthenticationExceptionWithMsgIsPost_thenCallsGetMethod()
      throws IOException, ServletException {
    // Arrange
    DefaultMultipartHttpServletRequest request = mock(DefaultMultipartHttpServletRequest.class);
    when(request.getMethod()).thenThrow(new SessionAuthenticationException("POST"));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper baseRequest = new HttpServletRequestWrapper(request2);

    // Act and Assert
    assertThrows(
        SessionAuthenticationException.class,
        () ->
            adminCsrfFilter.doFilter(
                baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(request).getMethod();
  }
}
