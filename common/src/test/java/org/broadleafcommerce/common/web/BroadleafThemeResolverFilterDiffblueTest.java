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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.exception.HaltFilterChainException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class BroadleafThemeResolverFilterDiffblueTest {
  /**
   * Test
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code blcadmin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_givenBlcadmin() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);
    request.setRequestURI("blcadmin");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_givenOrgBroadleafcommerceAdmin() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);
    request.setRequestURI("org.broadleafcommerce.admin");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code .service}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_givenService() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);
    request.setRequestURI(".service");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link HaltFilterChainException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternalUnlessIgnored_thenThrowHaltFilterChainException()
      throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.setContextPath(null);
    request.setRequestURI("org.broadleafcommerce.admin");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(HaltFilterChainException.class,
        () -> broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertTrue(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin", true));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertTrue(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)),
        "https://example.org/example", true));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertTrue(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example", true));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenBlcadmin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin", true));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   * <ul>
   *   <li>When {@code .service}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenService() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service", true));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertTrue(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "https://example.org/example"));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code blcadmin}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenBlcadmin_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "blcadmin"));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter.shouldProcessURL(
        new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), "org.broadleafcommerce.admin"));
  }

  /**
   * Test
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   * with {@code request}, {@code requestURI}.
   * <ul>
   *   <li>When {@code .service}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)}
   */
  @Test
  public void testShouldProcessURLWithRequestRequestURI_whenService_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter
        .shouldProcessURL(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()), ".service"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}.
   * <p>
   * Method under test: {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();
    broadleafThemeResolverFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(44, broadleafThemeResolverFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}.
   * <ul>
   *   <li>Given {@link BroadleafThemeResolverFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}
   */
  @Test
  public void testGetIgnoreSuffixes_givenBroadleafThemeResolverFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(44, (new BroadleafThemeResolverFilter()).getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}.
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();
    broadleafThemeResolverFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertFalse(broadleafThemeResolverFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}.
   * <ul>
   *   <li>Given {@link BroadleafThemeResolverFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  public void testShouldNotFilterErrorDispatch_givenBroadleafThemeResolverFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new BroadleafThemeResolverFilter()).shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafThemeResolverFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafThemeResolverFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafThemeResolverFilter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals(10100, (new BroadleafThemeResolverFilter()).getOrder());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getOrder()}.
   * <ul>
   *   <li>Given {@link BroadleafThemeResolverFilter} (default constructor)
   * Environment is {@link StandardEnvironment}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafThemeResolverFilter#getOrder()}
   */
  @Test
  public void testGetOrder_givenBroadleafThemeResolverFilterEnvironmentIsStandardEnvironment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();
    broadleafThemeResolverFilter.setEnvironment(mock(StandardEnvironment.class));

    // Act and Assert
    assertEquals(10100, broadleafThemeResolverFilter.getOrder());
  }
}
