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
package org.broadleafcommerce.core.web.search;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

class SearchRequestWrapperDiffblueTest {
  /**
   * Test {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test new SearchRequestWrapper(HttpServletRequest)")
  void testNewSearchRequestWrapper() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    // Act and Assert
    assertSame(servletRequest2, (new SearchRequestWrapper(servletRequest2)).getRequest());
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   * <p>
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  void testGetParameterValues() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(
        new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
            new String[]{"White List Param Names"})));

    // Act and Assert
    assertNull((new SearchRequestWrapper(new XssRequestWrapper(servletRequest2, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"}))).getParameterValues("Parameter"));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); when 'null'; then return 'null'")
  void testGetParameterValues_whenNull_thenReturnNull() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull((new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"}))).getParameterValues(null));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   * <ul>
   *   <li>When {@code Parameter}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); when 'Parameter'; then return 'null'")
  void testGetParameterValues_whenParameter_thenReturnNull() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull((new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"}))).getParameterValues("Parameter"));
  }
}
