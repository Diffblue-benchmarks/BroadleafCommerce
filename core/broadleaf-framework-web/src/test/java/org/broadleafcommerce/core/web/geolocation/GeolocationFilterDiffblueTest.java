/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.geolocation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {GeolocationFilter.class})
@ExtendWith(SpringExtension.class)
@WebAppConfiguration
class GeolocationFilterDiffblueTest {
  @Autowired private GeolocationFilter geolocationFilter;

  @MockBean(name = "blGeolocationRequestProcessor")
  private GeolocationRequestProcessor geolocationRequestProcessor;

  /**
   * Test {@link GeolocationFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link ServletException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * GeolocationFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then throw ServletException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GeolocationFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(geolocationRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(geolocationRequestProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        ServletException.class,
        () ->
            geolocationFilter.doFilterInternalUnlessIgnored(
                httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(geolocationRequestProcessor).postProcess(isA(WebRequest.class));
    verify(geolocationRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link GeolocationFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>When {@link FilterChain} {@link FilterChain#doFilter(ServletRequest, ServletResponse)}
   *       does nothing.
   * </ul>
   *
   * <p>Method under test: {@link
   * GeolocationFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse,
   * FilterChain)}
   */
  @Test
  @DisplayName(
      "Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); when FilterChain doFilter(ServletRequest, ServletResponse) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void GeolocationFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  void testDoFilterInternalUnlessIgnored_whenFilterChainDoFilterDoesNothing()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(geolocationRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(geolocationRequestProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    geolocationFilter.doFilterInternalUnlessIgnored(
        httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(geolocationRequestProcessor).postProcess(isA(WebRequest.class));
    verify(geolocationRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link GeolocationFilter#getOrder()}.
   *
   * <p>Method under test: {@link GeolocationFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int GeolocationFilter.getOrder()"})
  void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, new GeolocationFilter().getOrder());
  }
}
