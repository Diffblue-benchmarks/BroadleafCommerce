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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.BroadleafRequestFilter;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class AbstractIgnorableOncePerRequestFilterDiffblueTest {
  /**
   * Test
   * {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenTrue_thenCallsDoFilter() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
  }

  /**
   * Test
   * {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenThrowServletException() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> broadleafRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
  }

  /**
   * Test
   * {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_givenTrue_thenReturnTrue() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsIgnoredResult = broadleafRequestFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test
   * {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_thenReturnFalse() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(broadleafRequestFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }
}
