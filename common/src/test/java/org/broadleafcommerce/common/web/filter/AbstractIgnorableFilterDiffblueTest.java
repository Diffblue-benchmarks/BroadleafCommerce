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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {StatelessSessionFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AbstractIgnorableFilterDiffblueTest {
  @Autowired private AbstractIgnorableFilter abstractIgnorableFilter;

  /**
   * Test {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse,
   * FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AbstractIgnorableFilter.doFilter(ServletRequest, ServletResponse, FilterChain)"
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

    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableFilter.doFilter(request, response, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractIgnorableFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_givenTrue_thenReturnTrue() {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest =
        mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult =
        abstractIgnorableFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    verify(httpServletRequest).getAttribute("blUriIsFilterIgnored");
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractIgnorableFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_thenReturnFalse() {
    // Arrange
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualIsIgnoredResult =
        abstractIgnorableFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    assertFalse(actualIsIgnoredResult);
  }
}
