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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {ThemeUrlEncodingFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class ThemeUrlEncodingFilterDiffblueTest {
  @MockBean(name = "blThemeResolver")
  private BroadleafThemeResolver broadleafThemeResolver;

  @Autowired private ThemeUrlEncodingFilter themeUrlEncodingFilter;

  /**
   * Test {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link ServletException#ServletException(String)} with message is {@code An error
   *       occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThemeUrlEncodingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_givenServletExceptionWithMessageIsAnErrorOccurred()
      throws IOException, ServletException {
    // Arrange
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
        () -> themeUrlEncodingFilter.doFilter(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThemeUrlEncodingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_whenFilterChainDoFilterDoesNothing_thenCallsDoFilter()
      throws IOException, ServletException {
    // Arrange
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
    themeUrlEncodingFilter.doFilter(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThemeUrlEncodingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_whenNull_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange, Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            themeUrlEncodingFilter.doFilter(
                null,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
  }

  /**
   * Test {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link ThemeUrlEncodingFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThemeUrlEncodingFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilter_whenNull_thenThrowServletException2()
      throws IOException, ServletException {
    // Arrange, Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            themeUrlEncodingFilter.doFilter(
                new HttpServletRequestWrapper(
                    new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
                null,
                mock(FilterChain.class)));
  }
}
