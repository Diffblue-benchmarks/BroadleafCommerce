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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

public class NullBroadleafSiteResolverDiffblueTest {
  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)} with
   * {@code HttpServletRequest}.
   * <p>
   * Method under test:
   * {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)}
   */
  @Test
  public void testResolveSiteWithHttpServletRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(
        nullBroadleafSiteResolver.resolveSite(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)} with
   * {@code HttpServletRequest}.
   * <p>
   * Method under test:
   * {@link NullBroadleafSiteResolver#resolveSite(HttpServletRequest)}
   */
  @Test
  public void testResolveSiteWithHttpServletRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(nullBroadleafSiteResolver
        .resolveSite(new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class))));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest)} with
   * {@code WebRequest}.
   * <p>
   * Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest)}
   */
  @Test
  public void testResolveSiteWithWebRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(nullBroadleafSiteResolver
        .resolveSite(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest)} with
   * {@code WebRequest}.
   * <p>
   * Method under test: {@link NullBroadleafSiteResolver#resolveSite(WebRequest)}
   */
  @Test
  public void testResolveSiteWithWebRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(nullBroadleafSiteResolver.resolveSite(new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class)))));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)} with
   * {@code WebRequest}, {@code boolean}.
   * <p>
   * Method under test:
   * {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)}
   */
  @Test
  public void testResolveSiteWithWebRequestBoolean() throws SiteNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(nullBroadleafSiteResolver.resolveSite(
        new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())), true));
  }

  /**
   * Test {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)} with
   * {@code WebRequest}, {@code boolean}.
   * <p>
   * Method under test:
   * {@link NullBroadleafSiteResolver#resolveSite(WebRequest, boolean)}
   */
  @Test
  public void testResolveSiteWithWebRequestBoolean2() throws SiteNotFoundException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NullBroadleafSiteResolver nullBroadleafSiteResolver = new NullBroadleafSiteResolver();

    // Act and Assert
    assertNull(nullBroadleafSiteResolver.resolveSite(new ServletWebRequest(
        new SessionlessHttpServletRequestWrapper(mock(SessionlessHttpServletRequestWrapper.class))), true));
  }
}
