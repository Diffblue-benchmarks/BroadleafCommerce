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
package org.broadleafcommerce.site.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
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
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class EstablishSessionFilterDiffblueTest {
  /**
   * Test
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterUnlessIgnored_givenIOExceptionWithFoo_thenThrowIOException()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException("foo")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class,
        () -> establishSessionFilter.doFilterUnlessIgnored(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterUnlessIgnored_thenThrowServletException() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    ServletRequestWrapper request = new ServletRequestWrapper(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> establishSessionFilter.doFilterUnlessIgnored(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterUnlessIgnored_whenFilterChainDoFilterDoesNothing_thenCallsDoFilter()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    establishSessionFilter.doFilterUnlessIgnored(request, response2, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_givenFalse() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsIgnoredResult = establishSessionFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_givenTrue() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    DefaultMultipartHttpServletRequest httpServletRequest = mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsIgnoredResult = establishSessionFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_thenReturnFalse() throws IOException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(establishSessionFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }

  /**
   * Test {@link EstablishSessionFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link EstablishSessionFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EstablishSessionFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenEstablishSessionFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(-10000, (new EstablishSessionFilter()).getOrder());
  }

  /**
   * Test {@link EstablishSessionFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link EstablishSessionFilter} (default constructor) Environment is
   * {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EstablishSessionFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenEstablishSessionFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EstablishSessionFilter establishSessionFilter = new EstablishSessionFilter();
    establishSessionFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(-10000, establishSessionFilter.getOrder());
  }
}
