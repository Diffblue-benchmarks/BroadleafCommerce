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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.web.BroadleafRequestFilter;
import org.broadleafcommerce.common.web.BroadleafRequestProcessor;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
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
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {BroadleafRequestFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractIgnorableOncePerRequestFilterDiffblueTest {
  @Autowired
  private AbstractIgnorableOncePerRequestFilter abstractIgnorableOncePerRequestFilter;

  @MockBean(name = "blRequestProcessor")
  private BroadleafRequestProcessor broadleafRequestProcessor;

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor).</li>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractIgnorableOncePerRequestFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_givenBroadleafRequestFilter_thenThrowServletException()
      throws IOException, ServletException {
    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(request);
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
    verify(request).getAttribute(eq("blUriIsFilterIgnored"));
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractIgnorableOncePerRequestFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_givenHttpsExampleOrgExample() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(httpServletRequest.getRequestURI()).thenReturn("https://example.org/example");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableOncePerRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest, atLeast(1)).getAttribute(Mockito.<String>any());
    verify(httpServletRequest).getRequestURI();
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code org.broadleafcommerce.admin}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractIgnorableOncePerRequestFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_givenOrgBroadleafcommerceAdmin() throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(false);
    when(httpServletRequest.getRequestURI()).thenReturn("org.broadleafcommerce.admin");
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableOncePerRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    verify(httpServletRequest).getRequestURI();
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractIgnorableOncePerRequestFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_givenTrue() throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableOncePerRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link BroadleafRequestProcessor#postProcess(WebRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void AbstractIgnorableOncePerRequestFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternal_thenCallsPostProcess() throws IOException, ServletException {
    // Arrange
    doNothing().when(broadleafRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(broadleafRequestProcessor).process(Mockito.<WebRequest>any());
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse httpServletResponse = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableOncePerRequestFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(broadleafRequestProcessor).postProcess(isA(WebRequest.class));
    verify(broadleafRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@link BroadleafRequestFilter} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AbstractIgnorableOncePerRequestFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  public void testIsIgnored_givenBroadleafRequestFilter() throws IOException {
    // Arrange
    BroadleafRequestFilter broadleafRequestFilter = new BroadleafRequestFilter();
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new HttpServletRequestWrapper(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(broadleafRequestFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AbstractIgnorableOncePerRequestFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  public void testIsIgnored_givenTrue_thenReturnTrue() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(httpServletRequest.getAttribute(Mockito.<String>any())).thenReturn(true);
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act
    boolean actualIsIgnoredResult = abstractIgnorableOncePerRequestFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())));

    // Assert
    verify(httpServletRequest).getAttribute(eq("blUriIsFilterIgnored"));
    assertTrue(actualIsIgnoredResult);
  }

  /**
   * Test {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractIgnorableOncePerRequestFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AbstractIgnorableOncePerRequestFilter.isIgnored(HttpServletRequest, HttpServletResponse)"})
  public void testIsIgnored_thenReturnFalse() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(abstractIgnorableOncePerRequestFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }
}
