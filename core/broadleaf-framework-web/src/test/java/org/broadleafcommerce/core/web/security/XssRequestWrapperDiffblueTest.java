/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.security;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class XssRequestWrapperDiffblueTest {
  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  void testGetParameterValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  void testGetParameterValues2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(
        new HttpServletRequestWrapper(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest2, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  void testGetParameterValues3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameterValues(Mockito.<String>any())).thenReturn(new String[]{"42"});

    // Act
    String[] actualParameterValues = (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"Parameter"})).getParameterValues("Parameter");

    // Assert
    verify(servletRequest).getParameterValues(eq("Parameter"));
    assertArrayEquals(new String[]{"42"}, actualParameterValues);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   * <ul>
   *   <li>Then return array of {@link String} with {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); then return array of String with '42'")
  void testGetParameterValues_thenReturnArrayOfStringWith42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameterValues(Mockito.<String>any())).thenReturn(new String[]{"42"});

    // Act
    String[] actualParameterValues = (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues("Parameter");

    // Assert
    verify(servletRequest).getParameterValues(eq("Parameter"));
    assertArrayEquals(new String[]{"42"}, actualParameterValues);
  }

  /**
   * Test {@link XssRequestWrapper#getParameterValues(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); when 'null'")
  void testGetParameterValues_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues(null));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @DisplayName("Test checkWhitelist(String)")
  void testCheckWhitelist() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));

    // Act and Assert
    assertFalse((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @DisplayName("Test checkWhitelist(String); then return 'false'")
  void testCheckWhitelist_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertFalse((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#checkWhitelist(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  @DisplayName("Test checkWhitelist(String); then return 'true'")
  void testCheckWhitelist_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertTrue((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"Parameter"}))
        .checkWhitelist("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String)")
  void testGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String)")
  void testGetParameter2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    String actualParameter = (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"Parameter"})).getParameter("Parameter");

    // Assert
    verify(servletRequest).getParameter(eq("Parameter"));
    assertEquals("Parameter", actualParameter);
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>Given
   * {@link HttpServletRequestWrapper#HttpServletRequestWrapper(HttpServletRequest)}
   * with request is
   * {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); given HttpServletRequestWrapper(HttpServletRequest) with request is SearchRequestWrapper(HttpServletRequest)")
  void testGetParameter_givenHttpServletRequestWrapperWithRequestIsSearchRequestWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper servletRequest2 = new SearchRequestWrapper(
        new HttpServletRequestWrapper(new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
            new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}))));

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest2, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>Given
   * {@link SecurityWrapperRequest#SecurityWrapperRequest(HttpServletRequest)}
   * with request is
   * {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); given SecurityWrapperRequest(HttpServletRequest) with request is SearchRequestWrapper(HttpServletRequest)")
  void testGetParameter_givenSecurityWrapperRequestWithRequestIsSearchRequestWrapper() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SecurityWrapperRequest servletRequest2 = new SecurityWrapperRequest(new SearchRequestWrapper(new XssRequestWrapper(
        servletRequest, new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"})));

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest2, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter("Parameter"));
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>Then return {@code Parameter}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); then return 'Parameter'")
  void testGetParameter_thenReturnParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);
    when(servletRequest.getParameter(Mockito.<String>any())).thenReturn("Parameter");

    // Act
    String actualParameter = (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter("Parameter");

    // Assert
    verify(servletRequest).getParameter(eq("Parameter"));
    assertEquals("Parameter", actualParameter);
  }

  /**
   * Test {@link XssRequestWrapper#getParameter(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  @DisplayName("Test getParameter(String); when 'null'")
  void testGetParameter_whenNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXss(String, String)} with {@code value},
   * {@code esapiInputType}.
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#stripXss(String, String)}
   */
  @Test
  @DisplayName("Test stripXss(String, String) with 'value', 'esapiInputType'; when 'BroadleafHttpParameterValue'; then return '42'")
  void testStripXssWithValueEsapiInputType_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).stripXss("42", "BroadleafHttpParameterValue"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   * <p>
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @DisplayName("Test customStripXss(String)")
  void testCustomStripXss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss("42"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @DisplayName("Test customStripXss(String); then return '42'")
  void testCustomStripXss_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss("42"));
  }

  /**
   * Test {@link XssRequestWrapper#customStripXss(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  @DisplayName("Test customStripXss(String); when 'null'; then return 'null'")
  void testCustomStripXss_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss(null));
  }

  /**
   * Test {@link XssRequestWrapper#stripXssWithESAPI(String, String)}.
   * <ul>
   *   <li>When {@code BroadleafHttpParameterValue}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link XssRequestWrapper#stripXssWithESAPI(String, String)}
   */
  @Test
  @DisplayName("Test stripXssWithESAPI(String, String); when 'BroadleafHttpParameterValue'; then return '42'")
  void testStripXssWithESAPI_whenBroadleafHttpParameterValue_thenReturn42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).stripXssWithESAPI("42", "BroadleafHttpParameterValue"));
  }
}
