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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@RunWith(MockitoJUnitRunner.class)
public class AdminCsrfFilterDiffblueTest {
  @InjectMocks
  private AdminCsrfFilter adminCsrfFilter;

  @Mock
  private ExploitProtectionService exploitProtectionService;

  @Mock
  private AuthenticationFailureHandler authenticationFailureHandler;

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper baseRequest = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
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
   * <ul>
   *   <li>Given {@code blExploitProtectionService} {@link ExploitProtectionService#compareToken(String)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_givenBlExploitProtectionServiceCompareTokenDoesNothing()
      throws IOException, ServletException, ServiceException {
    // Arrange
    doNothing().when(exploitProtectionService).compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();
    MockHttpServletResponse baseResponse = new MockHttpServletResponse();
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    adminCsrfFilter.doFilter(baseRequest, baseResponse, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link AuthenticationFailureHandler#onAuthenticationFailure(HttpServletRequest, HttpServletResponse, AuthenticationException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_thenCallsOnAuthenticationFailure() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doNothing().when(authenticationFailureHandler)
        .onAuthenticationFailure(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();

    // Act
    adminCsrfFilter.doFilter(baseRequest, new MockHttpServletResponse(), mock(FilterChain.class));

    // Assert
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(authenticationFailureHandler).onAuthenticationFailure(isA(HttpServletRequest.class),
        isA(HttpServletResponse.class), isA(AuthenticationException.class));
  }

  /**
   * Test {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminCsrfFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AdminCsrfFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"})
  public void testDoFilter_thenThrowServletException() throws IOException, ServletException, ServiceException {
    // Arrange
    doThrow(new ServiceException("An error occurred")).when(exploitProtectionService)
        .compareToken(Mockito.<String>any());
    when(exploitProtectionService.getCsrfTokenParameter()).thenReturn("ABC123");
    doThrow(new ServletException("An error occurred")).when(authenticationFailureHandler)
        .onAuthenticationFailure(Mockito.<HttpServletRequest>any(), Mockito.<HttpServletResponse>any(),
            Mockito.<AuthenticationException>any());
    MockMultipartHttpServletRequest baseRequest = new MockMultipartHttpServletRequest();

    // Act and Assert
    assertThrows(ServletException.class,
        () -> adminCsrfFilter.doFilter(baseRequest, new MockHttpServletResponse(), mock(FilterChain.class)));
    verify(exploitProtectionService).compareToken(isNull());
    verify(exploitProtectionService).getCsrfTokenParameter();
    verify(authenticationFailureHandler).onAuthenticationFailure(isA(HttpServletRequest.class),
        isA(HttpServletResponse.class), isA(AuthenticationException.class));
  }
}
