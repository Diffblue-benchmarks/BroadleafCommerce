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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class BroadleafCookieLocaleResolverDiffblueTest {
  @InjectMocks
  private BroadleafCookieLocaleResolver broadleafCookieLocaleResolver;

  @Mock
  private LocaleService localeService;

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"})
  public void testDetermineDefaultLocale() {
    // Arrange
    Locale defaultLocale = Locale.getDefault();
    broadleafCookieLocaleResolver.setDefaultLocale(defaultLocale);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Locale actualDetermineDefaultLocaleResult = broadleafCookieLocaleResolver.determineDefaultLocale(request);

    // Assert
    Locale locale = defaultLocale.ENGLISH;
    assertSame(locale, request.getLocale());
    assertSame(locale, actualDetermineDefaultLocaleResult);
  }

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <p>
   * Method under test: {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"})
  public void testDetermineDefaultLocale2() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Locale actualDetermineDefaultLocaleResult = broadleafCookieLocaleResolver.determineDefaultLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    Locale locale = actualDetermineDefaultLocaleResult.ENGLISH;
    assertSame(locale, request.getLocale());
    assertSame(locale, actualDetermineDefaultLocaleResult);
  }

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <ul>
   *   <li>Then calls {@link LocaleImpl#getJavaLocale()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"})
  public void testDetermineDefaultLocale_thenCallsGetJavaLocale() {
    // Arrange
    LocaleImpl localeImpl = mock(LocaleImpl.class);
    Locale resultDefault = Locale.getDefault();
    when(localeImpl.getJavaLocale()).thenReturn(resultDefault);
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);
    SessionlessHttpServletRequestWrapper request = new SessionlessHttpServletRequestWrapper(
        new MockHttpServletRequest());

    // Act
    Locale actualDetermineDefaultLocaleResult = broadleafCookieLocaleResolver.determineDefaultLocale(request);

    // Assert
    verify(localeImpl).getJavaLocale();
    verify(localeService).findDefaultLocale();
    Locale locale = resultDefault.ENGLISH;
    assertSame(locale, request.getLocale());
    assertSame(locale, actualDetermineDefaultLocaleResult);
  }

  /**
   * Test {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafCookieLocaleResolver#determineDefaultLocale(HttpServletRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Locale BroadleafCookieLocaleResolver.determineDefaultLocale(HttpServletRequest)"})
  public void testDetermineDefaultLocale_thenReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(new LocaleImpl());

    // Act
    Locale actualDetermineDefaultLocaleResult = broadleafCookieLocaleResolver
        .determineDefaultLocale(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()));

    // Assert
    verify(localeService).findDefaultLocale();
    assertNull(actualDetermineDefaultLocaleResult);
  }

  /**
   * Test new {@link BroadleafCookieLocaleResolver} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link BroadleafCookieLocaleResolver}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafCookieLocaleResolver.<init>()"})
  public void testNewBroadleafCookieLocaleResolver() {
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
