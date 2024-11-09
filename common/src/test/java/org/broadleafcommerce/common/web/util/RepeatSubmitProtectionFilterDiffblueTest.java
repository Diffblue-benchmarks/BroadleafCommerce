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
package org.broadleafcommerce.common.web.util;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class RepeatSubmitProtectionFilterDiffblueTest {
  /**
   * Test
   * {@link RepeatSubmitProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link IOException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatSubmitProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_thenThrowIOException() throws IOException, ServletException {
    // Arrange
    RepeatSubmitProtectionFilter repeatSubmitProtectionFilter = new RepeatSubmitProtectionFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doThrow(new IOException("ThreadLocalManager.notify.orphans")).when(chain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(IOException.class, () -> repeatSubmitProtectionFilter.doFilter(request, response2, chain));
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link RepeatSubmitProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   *   <li>Then calls
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link RepeatSubmitProtectionFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_whenFilterChainDoFilterDoesNothing_thenCallsDoFilter() throws IOException, ServletException {
    // Arrange
    RepeatSubmitProtectionFilter repeatSubmitProtectionFilter = new RepeatSubmitProtectionFilter();
    MockHttpServletRequest request = new MockHttpServletRequest();
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain chain = mock(FilterChain.class);
    doNothing().when(chain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    repeatSubmitProtectionFilter.doFilter(request, response2, chain);

    // Assert
    verify(chain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }
}
