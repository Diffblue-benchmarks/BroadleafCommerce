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
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@ContextConfiguration(classes = {BroadleafSiteServletConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafSiteServletConfigDiffblueTest {
  @Autowired
  private BroadleafSiteServletConfig broadleafSiteServletConfig;

  /**
   * Test {@link BroadleafSiteServletConfig#addInterceptors(InterceptorRegistry)}.
   * <p>
   * Method under test:
   * {@link BroadleafSiteServletConfig#addInterceptors(InterceptorRegistry)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddInterceptors() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.web.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2725 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig broadleafSiteServletConfig;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafSiteServletConfig.addInterceptors(new InterceptorRegistry());
  }

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
   * <p>
   * Method under test: {@link BroadleafSiteServletConfig#localeResolver()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLocaleResolver() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.web.config;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass2726 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.web.config.BroadleafSiteServletConfig broadleafSiteServletConfig;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafSiteServletConfig.localeResolver();
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
