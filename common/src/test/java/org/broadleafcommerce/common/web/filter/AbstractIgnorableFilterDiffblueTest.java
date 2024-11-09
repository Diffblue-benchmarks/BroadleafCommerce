/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.web.filter;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.api.common.web.filter.StatelessSessionFilter;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@ContextConfiguration(classes = {StatelessSessionFilter.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractIgnorableFilterDiffblueTest {
  @Autowired
  private AbstractIgnorableFilter abstractIgnorableFilter;

  /**
   * Test
   * {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <p>
   * Method under test:
   * {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter() throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableFilter.doFilter(request, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link ServletRequestWrapper#getAttribute(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_givenTrue_thenCallsGetAttribute() throws IOException, ServletException {
    // Arrange
    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(true);
    SessionlessHttpServletRequestWrapper request2 = new SessionlessHttpServletRequestWrapper(request);
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    abstractIgnorableFilter.doFilter(request2, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
    verify(request).getAttribute(eq("blUriIsFilterIgnored"));
  }

  /**
   * Test
   * {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractIgnorableFilter#isIgnored(HttpServletRequest, HttpServletResponse)}
   */
  @Test
  public void testIsIgnored_thenReturnFalse() throws IOException {
    // Arrange
    SessionlessHttpServletRequestWrapper httpServletRequest = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();

    // Act and Assert
    assertFalse(abstractIgnorableFilter.isIgnored(httpServletRequest,
        new StatusExposingServletResponse(new FileSystemResponseWrapper(response,
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()))));
  }
}
