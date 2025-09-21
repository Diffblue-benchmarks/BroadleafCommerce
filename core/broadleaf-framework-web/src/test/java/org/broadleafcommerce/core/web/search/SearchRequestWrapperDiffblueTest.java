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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;

class SearchRequestWrapperDiffblueTest {
  /**
   * Test {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}.
   *
   * <p>Method under test: {@link SearchRequestWrapper#SearchRequestWrapper(HttpServletRequest)}
   */
  @Test
  @DisplayName("Test new SearchRequestWrapper(HttpServletRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SearchRequestWrapper.<init>(HttpServletRequest)"})
  void testNewSearchRequestWrapper() {
    // Arrange
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper servletRequest2 = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertSame(servletRequest2, new SearchRequestWrapper(servletRequest2).getRequest());
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues() {
    // Arrange, Act and Assert
    assertNull(
        new SearchRequestWrapper(new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameterValues("Parameter"));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues2() {
    // Arrange
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    HttpServletRequestWrapper servletRequest = new HttpServletRequestWrapper(request);

    // Act and Assert
    assertNull(new SearchRequestWrapper(servletRequest).getParameterValues("Parameter"));
  }

  /**
   * Test {@link SearchRequestWrapper#getParameterValues(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SearchRequestWrapper#getParameterValues(String)}
   */
  @Test
  @DisplayName("Test getParameterValues(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String[] SearchRequestWrapper.getParameterValues(String)"})
  void testGetParameterValues_whenNull() {
    // Arrange, Act and Assert
    assertNull(
        new SearchRequestWrapper(new HttpServletRequestWrapper(new MockHttpServletRequest()))
            .getParameterValues(null));
  }
}
