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
package org.broadleafcommerce.common.security.handler;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.security.service.ExploitProtectionService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
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
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SecurityFilterDiffblueTest {
  @MockBean(name = "blExploitProtectionService")
  private ExploitProtectionService exploitProtectionService;

  @Autowired
  private SecurityFilter securityFilter;

  @MockBean(name = "blStaleStateProtectionService")
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code blStaleStateProtectionService}
   * {@link StaleStateProtectionService#isEnabled()} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_givenBlStaleStateProtectionServiceIsEnabledReturnFalse()
      throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(false);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityFilter.doFilterInternal(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilterInternal_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    when(staleStateProtectionService.isEnabled()).thenReturn(true);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class, () -> securityFilter.doFilterInternal(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(staleStateProtectionService).isEnabled();
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SecurityFilter#setExcludedRequestPatterns(List)}
   *   <li>{@link SecurityFilter#getExcludedRequestPatterns()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SecurityFilter securityFilter = new SecurityFilter();
    ArrayList<String> excludedRequestPatterns = new ArrayList<>();

    // Act
    securityFilter.setExcludedRequestPatterns(excludedRequestPatterns);
    List<String> actualExcludedRequestPatterns = securityFilter.getExcludedRequestPatterns();

    // Assert that nothing has changed
    assertTrue(actualExcludedRequestPatterns.isEmpty());
    assertSame(excludedRequestPatterns, actualExcludedRequestPatterns);
  }
}
