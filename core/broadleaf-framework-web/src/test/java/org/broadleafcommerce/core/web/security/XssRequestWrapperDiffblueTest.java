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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class XssRequestWrapperDiffblueTest {
  /**
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues("Parameter"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
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
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues3() {
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
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues4() {
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
   * Method under test: {@link XssRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameterValues(null));
  }

  /**
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  void testCheckWhitelist() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertFalse((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).checkWhitelist("Parameter"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  void testCheckWhitelist2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));

    // Act and Assert
    assertFalse((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).checkWhitelist("Parameter"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#checkWhitelist(String)}
   */
  @Test
  void testCheckWhitelist3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertTrue((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(), new String[]{"Parameter"}))
        .checkWhitelist("Parameter"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter("Parameter"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter2() {
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
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter3() {
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
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter4() {
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
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter5() {
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
   * Method under test: {@link XssRequestWrapper#getParameter(String)}
   */
  @Test
  void testGetParameter6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SessionlessHttpServletRequestWrapper servletRequest = mock(SessionlessHttpServletRequestWrapper.class);

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).getParameter(null));
  }

  /**
   * Method under test: {@link XssRequestWrapper#stripXss(String, String)}
   */
  @Test
  void testStripXss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).stripXss("42", "BroadleafHttpParameterValue"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  void testCustomStripXss() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss("42"));
  }

  /**
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  void testCustomStripXss2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertNull((new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss(null));
  }

  /**
   * Method under test: {@link XssRequestWrapper#customStripXss(String)}
   */
  @Test
  void testCustomStripXss3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(mock(DefaultMultipartHttpServletRequest.class));

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).customStripXss("42"));
  }

  /**
   * Method under test:
   * {@link XssRequestWrapper#stripXssWithESAPI(String, String)}
   */
  @Test
  void testStripXssWithESAPI() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SearchRequestWrapper servletRequest = new SearchRequestWrapper(new MockHttpServletRequest());

    // Act and Assert
    assertEquals("42", (new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"})).stripXssWithESAPI("42", "BroadleafHttpParameterValue"));
  }
}
