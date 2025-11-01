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
package org.broadleafcommerce.core.web.search;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

class SearchRequestWrapperDiffblueTest {
  /**
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull((new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"}))).getParameterValues("Parameter"));
  }

  /**
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues2() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();

    // Act and Assert
    assertNull((new SearchRequestWrapper(new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"}))).getParameterValues(null));
  }

  /**
   * Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  void testGetParameterValues3() {
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
   * Method under test:
   * {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}
   */
  @Test
  void testNewSearchRequestWrapper() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    XssRequestWrapper servletRequest2 = new XssRequestWrapper(servletRequest, new StandardReactiveWebEnvironment(),
        new String[]{"White List Param Names"});

    // Act and Assert
    assertSame(servletRequest2, (new SearchRequestWrapper(servletRequest2)).getRequest());
  }
}
