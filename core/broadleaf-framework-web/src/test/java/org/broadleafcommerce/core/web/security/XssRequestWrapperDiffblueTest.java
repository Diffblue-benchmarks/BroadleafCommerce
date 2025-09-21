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
package org.broadleafcommerce.core.web.security;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.servlet.DispatcherType;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.Part;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;

class XssRequestWrapperDiffblueTest {
  /**
   * Test {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest, Environment, String[])}.
   *
   * <p>Method under test: {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest,
   * Environment, String[])}
   */
  @Test
  @DisplayName("Test new XssRequestWrapper(HttpServletRequest, Environment, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void XssRequestWrapper.<init>(HttpServletRequest, Environment, String[])"})
  void testNewXssRequestWrapper() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    // Act
    XssRequestWrapper actualXssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Assert
    Collection<Part> parts = actualXssRequestWrapper.getParts();
    assertTrue(parts instanceof List);
    ServletRequest request = actualXssRequestWrapper.getRequest();
    assertTrue(request instanceof HttpServletRequestWrapper);
    assertTrue(actualXssRequestWrapper.environment instanceof StandardReactiveWebEnvironment);
    assertTrue(actualXssRequestWrapper.getSession() instanceof MockHttpSession);
    assertTrue(actualXssRequestWrapper.getServletContext() instanceof MockServletContext);
    assertEquals("", actualXssRequestWrapper.getContextPath());
    assertEquals("", actualXssRequestWrapper.getMethod());
    assertEquals("", actualXssRequestWrapper.getRequestURI());
    assertEquals("", actualXssRequestWrapper.getServletPath());
    assertEquals("HTTP/1.1", actualXssRequestWrapper.getProtocol());
    assertEquals("http", actualXssRequestWrapper.getScheme());
    assertEquals("localhost", actualXssRequestWrapper.getLocalName());
    assertEquals("localhost", actualXssRequestWrapper.getRemoteHost());
    assertEquals("localhost", actualXssRequestWrapper.getServerName());
    assertNull(actualXssRequestWrapper.getCharacterEncoding());
    assertNull(actualXssRequestWrapper.getContentType());
    assertNull(actualXssRequestWrapper.getAuthType());
    assertNull(actualXssRequestWrapper.getPathInfo());
    assertNull(actualXssRequestWrapper.getPathTranslated());
    assertNull(actualXssRequestWrapper.getQueryString());
    assertNull(actualXssRequestWrapper.getRemoteUser());
    assertNull(actualXssRequestWrapper.getRequestedSessionId());
    assertNull(actualXssRequestWrapper.getUserPrincipal());
    assertNull(actualXssRequestWrapper.getAsyncContext());
    assertNull(actualXssRequestWrapper.getCookies());
    assertEquals(-1, actualXssRequestWrapper.getContentLength());
    assertEquals(-1L, actualXssRequestWrapper.getContentLengthLong());
    assertEquals(80, actualXssRequestWrapper.getLocalPort());
    assertEquals(80, actualXssRequestWrapper.getRemotePort());
    assertEquals(80, actualXssRequestWrapper.getServerPort());
    assertEquals(DispatcherType.REQUEST, actualXssRequestWrapper.getDispatcherType());
    assertFalse(actualXssRequestWrapper.isAsyncStarted());
    assertFalse(actualXssRequestWrapper.isAsyncSupported());
    assertFalse(actualXssRequestWrapper.isSecure());
    assertFalse(actualXssRequestWrapper.customStripXssEnabled);
    assertTrue(parts.isEmpty());
    assertTrue(actualXssRequestWrapper.getParameterMap().isEmpty());
    assertTrue(actualXssRequestWrapper.getTrailerFields().isEmpty());
    assertTrue(actualXssRequestWrapper.isTrailerFieldsReady());
    assertSame(servletRequest, request);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper servletRequest3 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    String[] whiteListParamNames2 = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest3, new StandardReactiveWebEnvironment(), whiteListParamNames2);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameterValues("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest =
        mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameterValues(Mockito.<String>any())).thenReturn(new String[] {"42"});
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames = new String[] {"Parameter"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act
    String[] actualParameterValues = xssRequestWrapper.getParameterValues("Parameter");

    // Assert
    verify(servletRequest).getParameterValues("Parameter");
    assertArrayEquals(new String[] {"42"}, actualParameterValues);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then return array of {@link String} with {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); then return array of String with '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues_thenReturnArrayOfStringWith42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest =
        mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameterValues(Mockito.<String>any())).thenReturn(new String[] {"42"});
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act
    String[] actualParameterValues = xssRequestWrapper.getParameterValues("Parameter");

    // Assert
    verify(servletRequest).getParameterValues("Parameter");
    assertArrayEquals(new String[] {"42"}, actualParameterValues);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameterValues("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] XssRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    SearchRequestWrapper request =
        new SearchRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class));
    HttpServletRequestWrapper servletRequest = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameterValues(null));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @DisplayName("Test checkWhitelist(String); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean XssRequestWrapper.checkWhitelist(String)"})
  void testCheckWhitelist_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertFalse(xssRequestWrapper.checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @DisplayName("Test checkWhitelist(String); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean XssRequestWrapper.checkWhitelist(String)"})
  void testCheckWhitelist_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest,
            new StandardReactiveWebEnvironment(),
            new String[] {"White List Param Names", "Parameter"});

    // Act and Assert
    assertTrue(xssRequestWrapper.checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    SearchRequestWrapper request = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest servletRequest = new SecurityWrapperRequest(request);
    SearchRequestWrapper request2 = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request2);
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Given {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)} with
   *       servletRequest is {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest,
   *       Environment, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName(
      "Test getParameter(String); given SearchRequestWrapper(HttpServletRequest) with servletRequest is XssRequestWrapper(HttpServletRequest, Environment, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter_givenSearchRequestWrapperWithServletRequestIsXssRequestWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper servletRequest3 =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    String[] whiteListParamNames2 = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest3, new StandardReactiveWebEnvironment(), whiteListParamNames2);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Given {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)} with
   *       servletRequest is {@link XssRequestWrapper#XssRequestWrapper(HttpServletRequest,
   *       Environment, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName(
      "Test getParameter(String); given SearchRequestWrapper(HttpServletRequest) with servletRequest is XssRequestWrapper(HttpServletRequest, Environment, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter_givenSearchRequestWrapperWithServletRequestIsXssRequestWrapper2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    SecurityWrapperRequest servletRequest3 = new SecurityWrapperRequest(request);
    SearchRequestWrapper request2 = new SearchRequestWrapper(servletRequest3);
    HttpServletRequestWrapper servletRequest4 = new HttpServletRequestWrapper(request2);
    String[] whiteListParamNames2 = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest4, new StandardReactiveWebEnvironment(), whiteListParamNames2);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.getParameter(String)"})
  void testGetParameter_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.getParameter(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXss(String, String)} with {@code value}, {@code
   * esapiInputType}.
   *
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#stripXss(String, String)}
   */
  @Test
  @DisplayName(
      "Test stripXss(String, String) with 'value', 'esapiInputType'; when 'BroadleafHttpParameterValue'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.stripXss(String, String)"})
  void testStripXssWithValueEsapiInputType_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.stripXss("42", "BroadleafHttpParameterValue"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @DisplayName("Test customStripXss(String); when '42'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.customStripXss(String)"})
  void testCustomStripXss_when42_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.customStripXss("42"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @DisplayName("Test customStripXss(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.customStripXss(String)"})
  void testCustomStripXss_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertNull(xssRequestWrapper.customStripXss(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXssWithESAPI(String, String)}.
   *
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link XssRequestWrapper#stripXssWithESAPI(String, String)}
   */
  @Test
  @DisplayName(
      "Test stripXssWithESAPI(String, String); when 'BroadleafHttpParameterValue'; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String XssRequestWrapper.stripXssWithESAPI(String, String)"})
  void testStripXssWithESAPI_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper xssRequestWrapper =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);

    // Act and Assert
    assertEquals("42", xssRequestWrapper.stripXssWithESAPI("42", "BroadleafHttpParameterValue"));
  }
}
