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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class BroadleafCookieLocaleResolverDiffblueTest {
  /**
   * Test
   * {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  public void testDetermineDefaultLocale() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafCookieLocaleResolver broadleafCookieLocaleResolver = new BroadleafCookieLocaleResolver();
    broadleafCookieLocaleResolver.setDefaultLocale(Locale.getDefault());
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Locale actualDetermineDefaultLocaleResult = broadleafCookieLocaleResolver.determineDefaultLocale(request);

    // Assert
    ServletRequest request2 = request.getRequest();
    assertTrue(request2 instanceof MockHttpServletRequest);
    Locale locale = actualDetermineDefaultLocaleResult.ENGLISH;
    assertSame(locale, request2.getLocale());
    assertSame(locale, request.getLocale());
    assertSame(actualDetermineDefaultLocaleResult.UK, actualDetermineDefaultLocaleResult);
  }

  /**
   * Test new {@link BroadleafCookieLocaleResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafCookieLocaleResolver}
   */
  @Test
  public void testNewBroadleafCookieLocaleResolver() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BroadleafCookieLocaleResolver actualBroadleafCookieLocaleResolver = new BroadleafCookieLocaleResolver();

    // Assert
    assertEquals("/", actualBroadleafCookieLocaleResolver.getCookiePath());
    assertEquals("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        actualBroadleafCookieLocaleResolver.getCookieName());
    assertNull(actualBroadleafCookieLocaleResolver.getCookieMaxAge());
    assertNull(actualBroadleafCookieLocaleResolver.getCookieDomain());
    assertFalse(actualBroadleafCookieLocaleResolver.isCookieHttpOnly());
    assertFalse(actualBroadleafCookieLocaleResolver.isCookieSecure());
    assertTrue(actualBroadleafCookieLocaleResolver.isLanguageTagCompliant());
    assertTrue(actualBroadleafCookieLocaleResolver.isRejectInvalidCookies());
  }
}
