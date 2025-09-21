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
package org.broadleafcommerce.site.common.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
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
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(classes = {EstablishSessionFilter.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EstablishSessionFilterDiffblueTest {
  @Autowired private EstablishSessionFilter establishSessionFilter;

  /**
   * Test {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <p>Method under test: {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EstablishSessionFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilterUnlessIgnored() throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    establishSessionFilter.doFilterUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EstablishSessionFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilterUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new IOException())
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        IOException.class,
        () -> establishSessionFilter.doFilterUnlessIgnored(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest, ServletResponse,
   * FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link EstablishSessionFilter#doFilterUnlessIgnored(ServletRequest,
   * ServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EstablishSessionFilter.doFilterUnlessIgnored(ServletRequest, ServletResponse, FilterChain)"
  })
  public void testDoFilterUnlessIgnored_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    ServletRequestWrapper request2 = new ServletRequestWrapper(request);
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
        () -> establishSessionFilter.doFilterUnlessIgnored(request2, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EstablishSessionFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EstablishSessionFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_givenFalse() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualIsIgnoredResult =
        establishSessionFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EstablishSessionFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EstablishSessionFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_givenTrue() {
    // Arrange
    DefaultMultipartHttpServletRequest httpServletRequest =
        mock(DefaultMultipartHttpServletRequest.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualIsIgnoredResult =
        establishSessionFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    verify(httpServletRequest).getAttribute("blUriIsFilterIgnored");
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link EstablishSessionFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EstablishSessionFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EstablishSessionFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_thenReturnFalse() {
    // Arrange
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    boolean actualIsIgnoredResult =
        establishSessionFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse())));

    // Assert
    assertFalse(actualIsIgnoredResult);
  }

  /**
   * Test {@link EstablishSessionFilter#getOrder()}.
   *
   * <p>Method under test: {@link EstablishSessionFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int EstablishSessionFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-10000, establishSessionFilter.getOrder());
  }
}
