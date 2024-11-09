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
package org.broadleafcommerce.common.web.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

public class BroadleafSiteServletConfigDiffblueTest {
  /**
   * Test {@link BroadleafSiteServletConfig#addInterceptors(InterceptorRegistry)}.
   * <ul>
   *   <li>Then calls
   * {@link InterceptorRegistry#addInterceptor(HandlerInterceptor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafSiteServletConfig#addInterceptors(InterceptorRegistry)}
   */
  @Test
  public void testAddInterceptors_thenCallsAddInterceptor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafSiteServletConfig broadleafSiteServletConfig = new BroadleafSiteServletConfig();
    InterceptorRegistry registry = mock(InterceptorRegistry.class);
    when(registry.addInterceptor(Mockito.<HandlerInterceptor>any()))
        .thenReturn(new InterceptorRegistration(new UserRoleAuthorizationInterceptor()));

    // Act
    broadleafSiteServletConfig.addInterceptors(registry);

    // Assert
    verify(registry).addInterceptor(isA(HandlerInterceptor.class));
  }

  /**
   * Test {@link BroadleafSiteServletConfig#localeResolver()}.
   * <ul>
   *   <li>Given {@link BroadleafSiteServletConfig} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSiteServletConfig#localeResolver()}
   */
  @Test
  public void testLocaleResolver_givenBroadleafSiteServletConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    LocaleResolver actualLocaleResolverResult = (new BroadleafSiteServletConfig()).localeResolver();

    // Assert
    assertTrue(actualLocaleResolverResult instanceof BroadleafCookieLocaleResolver);
    assertEquals("/", ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookiePath());
    assertEquals("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieName());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieMaxAge());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieDomain());
    assertFalse(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieSecure());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isLanguageTagCompliant());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isRejectInvalidCookies());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieHttpOnly());
  }

  /**
   * Test {@link BroadleafSiteServletConfig#localeResolver()}.
   * <ul>
   *   <li>Then calls
   * {@link InterceptorRegistry#addInterceptor(HandlerInterceptor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafSiteServletConfig#localeResolver()}
   */
  @Test
  public void testLocaleResolver_thenCallsAddInterceptor() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InterceptorRegistry registry = mock(InterceptorRegistry.class);
    when(registry.addInterceptor(Mockito.<HandlerInterceptor>any()))
        .thenReturn(new InterceptorRegistration(new UserRoleAuthorizationInterceptor()));

    BroadleafSiteServletConfig broadleafSiteServletConfig = new BroadleafSiteServletConfig();
    broadleafSiteServletConfig.addInterceptors(registry);

    // Act
    LocaleResolver actualLocaleResolverResult = broadleafSiteServletConfig.localeResolver();

    // Assert
    verify(registry).addInterceptor(isA(HandlerInterceptor.class));
    assertTrue(actualLocaleResolverResult instanceof BroadleafCookieLocaleResolver);
    assertEquals("/", ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookiePath());
    assertEquals("org.springframework.web.servlet.i18n.CookieLocaleResolver.LOCALE",
        ((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieName());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieMaxAge());
    assertNull(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).getCookieDomain());
    assertFalse(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieSecure());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isLanguageTagCompliant());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isRejectInvalidCookies());
    assertTrue(((BroadleafCookieLocaleResolver) actualLocaleResolverResult).isCookieHttpOnly());
  }
}
