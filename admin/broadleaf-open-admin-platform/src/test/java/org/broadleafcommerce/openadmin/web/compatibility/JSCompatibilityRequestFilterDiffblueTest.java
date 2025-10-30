/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.compatibility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {JSCompatibilityRequestFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class JSCompatibilityRequestFilterDiffblueTest {
  @Autowired
  private JSCompatibilityRequestFilter jSCompatibilityRequestFilter;

  /**
   * Test {@link JSCompatibilityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then calls {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void JSCompatibilityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    jSCompatibilityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain);

    // Assert
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link JSCompatibilityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link ServletException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSCompatibilityRequestFilter#doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void JSCompatibilityRequestFilter.doFilterInternalUnlessIgnored(HttpServletRequest, HttpServletResponse, FilterChain)"})
  public void testDoFilterInternalUnlessIgnored_thenThrowServletException() throws IOException, ServletException {
    // Arrange
    JSCompatibilityRequestWrapper request = new JSCompatibilityRequestWrapper(new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new ServletException("An error occurred")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(ServletException.class,
        () -> jSCompatibilityRequestFilter.doFilterInternalUnlessIgnored(request, response, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link JSCompatibilityRequestFilter#getOrder()}.
   * <p>
   * Method under test: {@link JSCompatibilityRequestFilter#getOrder()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JSCompatibilityRequestFilter.getOrder()"})
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(1000000, (new JSCompatibilityRequestFilter()).getOrder());
  }
}
