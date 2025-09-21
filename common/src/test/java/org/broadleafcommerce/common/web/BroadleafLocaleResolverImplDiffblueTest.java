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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.locale.service.LocaleService;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafLocaleResolverImplDiffblueTest {
  @InjectMocks private BroadleafLocaleResolverImpl broadleafLocaleResolverImpl;

  @Mock private LocaleService localeService;

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(HttpServletRequest)"})
  public void testResolveLocaleWithHttpServletRequest() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertSame(localeImpl, actualResolveLocaleResult);
    assertArrayEquals(new String[] {"blLocale"}, session.getValueNames());
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Then calls {@link SessionlessHttpServletRequestWrapper#getAttribute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(HttpServletRequest)"})
  public void testResolveLocaleWithHttpServletRequest_thenCallsGetAttribute() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findLocaleByCode(Mockito.<String>any())).thenReturn(localeImpl);

    SessionlessHttpServletRequestWrapper request = mock(SessionlessHttpServletRequestWrapper.class);
    when(request.getAttribute(Mockito.<String>any())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("https://example.org/example");
    when(request.getSession(anyBoolean())).thenReturn(new MockHttpSession());
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any());
    verify(request, atLeast(1)).setAttribute(Mockito.<String>any(), Mockito.<Object>any());
    verify(request, atLeast(1)).getHeader("blLocaleCode");
    verify(localeService).findLocaleByCode("https://example.org/example");
    verify(request, atLeast(1)).getSession(anyBoolean());
    assertSame(localeImpl, actualResolveLocaleResult);
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(HttpServletRequest)"})
  public void testResolveLocaleWithHttpServletRequest_thenReturnNull() {
    // Arrange
    when(localeService.findDefaultLocale()).thenReturn(null);
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertNull(actualResolveLocaleResult);
    assertEquals(0, session.getValueNames().length);
  }

  /**
   * Test {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)} with {@code WebRequest}.
   *
   * <p>Method under test: {@link BroadleafLocaleResolverImpl#resolveLocale(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Locale BroadleafLocaleResolverImpl.resolveLocale(WebRequest)"})
  public void testResolveLocaleWithWebRequest() {
    // Arrange
    LocaleImpl localeImpl = new LocaleImpl();
    when(localeService.findDefaultLocale()).thenReturn(localeImpl);
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    Locale actualResolveLocaleResult = broadleafLocaleResolverImpl.resolveLocale(request);

    // Assert
    verify(localeService).findDefaultLocale();
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertSame(localeImpl, actualResolveLocaleResult);
    assertArrayEquals(new String[] {"blLocale"}, ((MockHttpSession) sessionMutex).getValueNames());
  }
}
