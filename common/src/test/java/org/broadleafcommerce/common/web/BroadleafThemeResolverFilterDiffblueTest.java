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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
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
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.web.exception.HaltFilterChainException;
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
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafThemeResolverFilter.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class BroadleafThemeResolverFilterDiffblueTest {
  @MockBean(name = "blThemeProcessor")
  private BroadleafThemeProcessor broadleafThemeProcessor;

  @Autowired private BroadleafThemeResolverFilter broadleafThemeResolverFilter;

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafThemeProcessor)
        .postProcess(Mockito.<WebRequest>any());
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(broadleafThemeProcessor)
        .process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
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
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, response.getStatus());
    assertEquals(200, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored3() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(200, response.getStatus());
    assertEquals(200, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(200, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored4() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new SiteNotFoundException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
    ServletResponse response2 = response.getResponse();
    assertTrue(response2 instanceof StatusExposingServletResponse);
    ServletResponse response3 = ((StatusExposingServletResponse) response2).getResponse();
    assertTrue(response3 instanceof MockHttpServletResponse);
    assertEquals(404, response.getStatus());
    assertEquals(404, ((StatusExposingServletResponse) response2).getStatus());
    assertEquals(404, ((MockHttpServletResponse) response3).getStatus());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code blcadmin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenBlcadmin()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath(null);
    request.setRequestURI("blcadmin");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@link IOException#IOException()}.
   *   <li>Then throw {@link IOException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenIOException_thenThrowIOException()
      throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafThemeProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafThemeProcessor).process(Mockito.<WebRequest>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
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
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafThemeProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafThemeProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenOrgBroadleafcommerceAdmin()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath(null);
    request.setRequestURI("org.broadleafcommerce.admin");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenOrgBroadleafcommerceAdmin2()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath(null);
    request.setRequestURI("org.broadleafcommerce.admin");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new HaltFilterChainException("An error occurred"))
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Given {@code .service}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_givenService()
      throws IOException, ServletException {
    // Arrange
    BroadleafThemeResolverFilter broadleafThemeResolverFilter = new BroadleafThemeResolverFilter();

    MockHttpServletRequest request = new MockHttpServletRequest(new MockServletContext());
    request.setContextPath(null);
    request.setRequestURI(".service");
    HttpServletResponseWrapper response =
        new HttpServletResponseWrapper(
            new StatusExposingServletResponse(new MockHttpServletResponse()));

    FilterChain filterChain = mock(FilterChain.class);
    doNothing()
        .when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then calls {@link SessionlessHttpServletRequestWrapper#getRequestURI()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafThemeResolverFilter#doFilterInternalUnlessIgnored(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafThemeResolverFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternalUnlessIgnored_thenCallsGetRequestURI()
      throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getRequestURI()).thenThrow(new HaltFilterChainException("An error occurred"));
    SessionlessHttpServletRequestWrapper request2 =
        new SessionlessHttpServletRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);

    // Act and Assert
    assertThrows(
        HaltFilterChainException.class,
        () ->
            broadleafThemeResolverFilter.doFilterInternalUnlessIgnored(
                request3,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
    verify(request).getRequestURI();
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "org.broadleafcommerce.admin",
            true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "https://example.org/example",
            true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenBlcadmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "blcadmin",
            true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String, boolean)}
   * with {@code request}, {@code requestURI}, {@code ignoreSessionCheck}.
   *
   * <ul>
   *   <li>When {@code .service}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String, boolean)"
  })
  public void testShouldProcessURLWithRequestRequestURIIgnoreSessionCheck_whenService() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            ".service",
            true));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "https://example.org/example"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code blcadmin}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenBlcadmin_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "blcadmin"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code org.broadleafcommerce.admin}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenOrgBroadleafcommerceAdmin() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            "org.broadleafcommerce.admin"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest, String)} with
   * {@code request}, {@code requestURI}.
   *
   * <ul>
   *   <li>When {@code .service}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldProcessURL(HttpServletRequest,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafThemeResolverFilter.shouldProcessURL(HttpServletRequest, String)"
  })
  public void testShouldProcessURLWithRequestRequestURI_whenService_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        broadleafThemeResolverFilter.shouldProcessURL(
            new HttpServletRequestWrapper(
                new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())),
            ".service"));
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#getIgnoreSuffixes()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set BroadleafThemeResolverFilter.getIgnoreSuffixes()"})
  public void testGetIgnoreSuffixes() {
    // Arrange, Act and Assert
    assertEquals(44, broadleafThemeResolverFilter.getIgnoreSuffixes().size());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#shouldNotFilterErrorDispatch()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BroadleafThemeResolverFilter.shouldNotFilterErrorDispatch()"})
  public void testShouldNotFilterErrorDispatch() {
    // Arrange, Act and Assert
    assertFalse(broadleafThemeResolverFilter.shouldNotFilterErrorDispatch());
  }

  /**
   * Test {@link BroadleafThemeResolverFilter#getOrder()}.
   *
   * <p>Method under test: {@link BroadleafThemeResolverFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int BroadleafThemeResolverFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(10100, broadleafThemeResolverFilter.getOrder());
  }
}
