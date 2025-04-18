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
package org.broadleafcommerce.core.web.cookie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.security.util.GenericCookieUtilsImpl;
import org.broadleafcommerce.common.web.AbstractBroadleafWebRequestProcessor;
import org.broadleafcommerce.core.rule.RuleDTOConfig;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.support.StandardServletEnvironment;

@ContextConfiguration(classes = {CookieRuleFilter.class})
@WebAppConfiguration
@ExtendWith(SpringExtension.class)
class CookieRuleFilterDiffblueTest {
  @Autowired
  private CookieRuleFilter cookieRuleFilter;

  @MockBean
  private CookieRuleRequestProcessor cookieRuleRequestProcessor;

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored() throws IOException, ServletException {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl()));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    HttpSession session = httpServletRequest.getSession();
    assertTrue(session instanceof MockHttpSession);
    Environment environment = cookieRuleFilter.getEnvironment();
    assertTrue(environment instanceof StandardServletEnvironment);
    assertEquals(0, environment.getActiveProfiles().length);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME}, session.getValueNames());
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <p>
   * Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored2() throws IOException, ServletException {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();
    configs.add(new RuleDTOConfig(CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME,
        CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME));
    CookieRuleFilter cookieRuleFilter = new CookieRuleFilter(
        new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl()));
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    HttpSession session = httpServletRequest.getSession();
    assertTrue(session instanceof MockHttpSession);
    Environment environment = cookieRuleFilter.getEnvironment();
    assertTrue(environment instanceof StandardServletEnvironment);
    assertEquals(0, environment.getActiveProfiles().length);
    assertArrayEquals(new String[]{CookieRuleRequestProcessor.COOKIE_ATTRIBUTE_NAME}, session.getValueNames());
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link AbstractBroadleafWebRequestProcessor#postProcess(WebRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then calls postProcess(WebRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_thenCallsPostProcess() throws IOException, ServletException {
    // Arrange
    doNothing().when(cookieRuleRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(cookieRuleRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    cookieRuleFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieRuleRequestProcessor).postProcess(isA(WebRequest.class));
    verify(cookieRuleRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CookieRuleFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @DisplayName("Test doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain); then throw ServletException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void CookieRuleFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  void testDoFilterInternalUnlessIgnored_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    doNothing().when(cookieRuleRequestProcessor).postProcess(Mockito.<WebRequest>any());
    doNothing().when(cookieRuleRequestProcessor).process(Mockito.<WebRequest>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper httpServletRequest = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> cookieRuleFilter.doFilterInternalUnlessIgnored(httpServletRequest, httpServletResponse, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(cookieRuleRequestProcessor).postProcess(isA(WebRequest.class));
    verify(cookieRuleRequestProcessor).process(isA(WebRequest.class));
  }

  /**
   * Test {@link CookieRuleFilter#getOrder()}.
   * <p>
   * Method under test: {@link CookieRuleFilter#getOrder()}
   */
  @Test
  @DisplayName("Test getOrder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int CookieRuleFilter.getOrder()"})
  void testGetOrder() {
    // Arrange
    ArrayList<RuleDTOConfig> configs = new ArrayList<>();

    // Act and Assert
    assertEquals(1000000,
        (new CookieRuleFilter(new CookieRuleRequestProcessor(configs, new GenericCookieUtilsImpl()))).getOrder());
  }
}
