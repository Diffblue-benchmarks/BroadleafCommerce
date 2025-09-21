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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class IgnorableOpenEntityManagerInViewFilterDiffblueTest {
  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IgnorableOpenEntityManagerInViewFilter#doFilterInternal(HttpServletRequest,
   * HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void IgnorableOpenEntityManagerInViewFilter.doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)"
  })
  public void testDoFilterInternal_thenThrowIllegalStateException()
      throws IOException, ServletException {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter =
        new IgnorableOpenEntityManagerInViewFilter();
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            ignorableOpenEntityManagerInViewFilter.doFilterInternal(
                request,
                new HttpServletResponseWrapper(
                    new StatusExposingServletResponse(new MockHttpServletResponse())),
                mock(FilterChain.class)));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest,
   * HttpServletResponse)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * IgnorableOpenEntityManagerInViewFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean IgnorableOpenEntityManagerInViewFilter.isIgnored(HttpServletRequest, HttpServletResponse)"
  })
  public void testIsIgnored_thenReturnFalse() {
    // Arrange
    IgnorableOpenEntityManagerInViewFilter ignorableOpenEntityManagerInViewFilter =
        new IgnorableOpenEntityManagerInViewFilter();
    HttpServletRequestWrapper httpServletRequest =
        new HttpServletRequestWrapper(
            new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertFalse(
        ignorableOpenEntityManagerInViewFilter.isIgnored(
            httpServletRequest,
            new HttpServletResponseWrapper(
                new StatusExposingServletResponse(new MockHttpServletResponse()))));
  }

  /**
   * Test {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}.
   *
   * <p>Method under test: {@link IgnorableOpenEntityManagerInViewFilter#getOrder()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int IgnorableOpenEntityManagerInViewFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(
        FilterOrdered.PRE_SECURITY_HIGH, new IgnorableOpenEntityManagerInViewFilter().getOrder());
  }
}
