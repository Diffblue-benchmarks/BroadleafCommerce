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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ThemeUrlEncodingFilterDiffblueTest {
  /**
   * Test
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThemeUrlEncodingFilter themeUrlEncodingFilter = new ThemeUrlEncodingFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act and Assert
    assertThrows(ServletException.class, () -> themeUrlEncodingFilter.doFilter(request, null, mock(FilterChain.class)));
  }

  /**
   * Test
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link ServletException#ServletException(String)} with message is
   * {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_givenServletExceptionWithMessageIsAnErrorOccurred() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThemeUrlEncodingFilter themeUrlEncodingFilter = new ThemeUrlEncodingFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class, () -> themeUrlEncodingFilter.doFilter(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_whenFilterChainDoFilterDoesNothing_thenCallsDoFilter() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThemeUrlEncodingFilter themeUrlEncodingFilter = new ThemeUrlEncodingFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    themeUrlEncodingFilter.doFilter(request, response2, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_whenNull_thenThrowServletException() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ThemeUrlEncodingFilter themeUrlEncodingFilter = new ThemeUrlEncodingFilter();
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertThrows(ServletException.class, () -> themeUrlEncodingFilter.doFilter(null, new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())),
        mock(FilterChain.class)));
  }
}
