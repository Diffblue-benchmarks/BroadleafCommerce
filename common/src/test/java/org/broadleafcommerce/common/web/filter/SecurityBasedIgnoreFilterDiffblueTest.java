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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.EventObject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.broadleafcommerce.common.web.util.FileSystemResponseWrapper;
import org.broadleafcommerce.common.web.util.StatusExposingServletResponse;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class SecurityBasedIgnoreFilterDiffblueTest {
  /**
   * Test {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)} with
   * {@code event}.
   * <ul>
   *   <li>Then calls {@link EventObject#getSource()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityBasedIgnoreFilter#init(ContextRefreshedEvent)}
   */
  @Test
  public void testInitWithEvent_thenCallsGetSource() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityBasedIgnoreFilter securityBasedIgnoreFilter = new SecurityBasedIgnoreFilter();
    ContextRefreshedEvent event = mock(ContextRefreshedEvent.class);
    when(event.getSource()).thenThrow(new FactoryBeanNotInitializedException("Msg"));

    // Act
    securityBasedIgnoreFilter.init(event);

    // Assert that nothing has changed
    verify(event).getSource();
  }

  /**
   * Test
   * {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>Then throw {@link FactoryBeanNotInitializedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_thenThrowFactoryBeanNotInitializedException() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityBasedIgnoreFilter securityBasedIgnoreFilter = new SecurityBasedIgnoreFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doThrow(new FactoryBeanNotInitializedException("Msg")).when(filterChain)
        .doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act and Assert
    assertThrows(FactoryBeanNotInitializedException.class,
        () -> securityBasedIgnoreFilter.doFilter(request, response2, filterChain));
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test
   * {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}.
   * <ul>
   *   <li>When {@link FilterChain}
   * {@link FilterChain#doFilter(ServletRequest, ServletResponse)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SecurityBasedIgnoreFilter#doFilter(ServletRequest, ServletResponse, FilterChain)}
   */
  @Test
  public void testDoFilter_whenFilterChainDoFilterDoesNothing() throws IOException, ServletException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SecurityBasedIgnoreFilter securityBasedIgnoreFilter = new SecurityBasedIgnoreFilter();
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());
    MockHttpServletResponse response = new MockHttpServletResponse();
    StatusExposingServletResponse response2 = new StatusExposingServletResponse(
        new FileSystemResponseWrapper(response, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    FilterChain filterChain = mock(FilterChain.class);
    doNothing().when(filterChain).doFilter(Mockito.<ServletRequest>any(), Mockito.<ServletResponse>any());

    // Act
    securityBasedIgnoreFilter.doFilter(request, response2, filterChain);

    // Assert that nothing has changed
    verify(filterChain).doFilter(isA(ServletRequest.class), isA(ServletResponse.class));
  }

  /**
   * Test {@link SecurityBasedIgnoreFilter#getOrder()}.
   * <p>
   * Method under test: {@link SecurityBasedIgnoreFilter#getOrder()}
   */
  @Test
  public void testGetOrder() {
    // Arrange, Act and Assert
    assertEquals(-1000500, (new SecurityBasedIgnoreFilter()).getOrder());
  }
}
