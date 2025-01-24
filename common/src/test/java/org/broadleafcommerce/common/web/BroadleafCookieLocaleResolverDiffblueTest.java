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
package org.broadleafcommerce.common.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Locale;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {BroadleafCookieLocaleResolver.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class BroadleafCookieLocaleResolverDiffblueTest {
  @Autowired
  private BroadleafCookieLocaleResolver broadleafCookieLocaleResolver;

  @MockBean
  private LocaleService localeService;

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
   * Test
   * {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <p>
   * Method under test:
   * {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineDefaultLocale2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.web;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass35 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver broadleafCookieLocaleResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.locale.service.LocaleService localeService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    broadleafCookieLocaleResolver
        .determineDefaultLocale(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));
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

  /**
   * Test new {@link BroadleafCookieLocaleResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link BroadleafCookieLocaleResolver}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewBroadleafCookieLocaleResolver2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.common.web;
    //   @org.springframework.test.context.ContextConfiguration(classes = {org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver.class})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass34 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.common.web.BroadleafCookieLocaleResolver broadleafCookieLocaleResolver;
    //     @org.springframework.boot.test.mock.mockito.MockBean org.broadleafcommerce.common.locale.service.LocaleService localeService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    new BroadleafCookieLocaleResolver();
  }
}
