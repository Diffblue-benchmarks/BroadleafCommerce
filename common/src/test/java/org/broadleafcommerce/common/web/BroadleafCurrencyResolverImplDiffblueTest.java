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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto;
import org.broadleafcommerce.common.currency.service.BroadleafCurrencyService;
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
public class BroadleafCurrencyResolverImplDiffblueTest {
  @InjectMocks private BroadleafCurrencyResolverImpl broadleafCurrencyResolverImpl;

  @Mock private BroadleafCurrencyService broadleafCurrencyService;

  /**
   * Test {@link BroadleafCurrencyResolverImpl#resolveCurrency(HttpServletRequest)} with {@code
   * HttpServletRequest}.
   *
   * <p>Method under test: {@link BroadleafCurrencyResolverImpl#resolveCurrency(HttpServletRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafRequestedCurrencyDto BroadleafCurrencyResolverImpl.resolveCurrency(HttpServletRequest)"
  })
  public void testResolveCurrencyWithHttpServletRequest() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = new BroadleafCurrencyImpl();
    when(broadleafCurrencyService.findDefaultBroadleafCurrency()).thenReturn(broadleafCurrencyImpl);
    HttpServletRequestWrapper request = new HttpServletRequestWrapper(new MockHttpServletRequest());

    // Act
    BroadleafRequestedCurrencyDto actualResolveCurrencyResult =
        broadleafCurrencyResolverImpl.resolveCurrency(request);

    // Assert
    verify(broadleafCurrencyService).findDefaultBroadleafCurrency();
    HttpSession session = request.getSession();
    assertTrue(session instanceof MockHttpSession);
    assertSame(broadleafCurrencyImpl, actualResolveCurrencyResult.getCurrencyToUse());
    assertSame(broadleafCurrencyImpl, actualResolveCurrencyResult.getRequestedCurrency());
    assertArrayEquals(new String[] {"blCurrency"}, session.getValueNames());
  }

  /**
   * Test {@link BroadleafCurrencyResolverImpl#resolveCurrency(WebRequest)} with {@code WebRequest}.
   *
   * <p>Method under test: {@link BroadleafCurrencyResolverImpl#resolveCurrency(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafRequestedCurrencyDto BroadleafCurrencyResolverImpl.resolveCurrency(WebRequest)"
  })
  public void testResolveCurrencyWithWebRequest() {
    // Arrange
    when(broadleafCurrencyService.findDefaultBroadleafCurrency())
        .thenReturn(new BroadleafCurrencyImpl());
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    BroadleafRequestedCurrencyDto actualResolveCurrencyResult =
        broadleafCurrencyResolverImpl.resolveCurrency(request);

    // Assert
    verify(broadleafCurrencyService).findDefaultBroadleafCurrency();
    BroadleafCurrency currencyToUse = actualResolveCurrencyResult.getCurrencyToUse();
    assertTrue(currencyToUse instanceof BroadleafCurrencyImpl);
    Object sessionMutex = request.getSessionMutex();
    assertTrue(sessionMutex instanceof MockHttpSession);
    assertNull(currencyToUse.getCurrencyCode());
    assertNull(currencyToUse.getFriendlyName());
    assertNull(((BroadleafCurrencyImpl) currencyToUse).getMainEntityName());
    assertNull(currencyToUse.getJavaCurrency());
    assertFalse(currencyToUse.getDefaultFlag());
    assertSame(currencyToUse, actualResolveCurrencyResult.getRequestedCurrency());
    assertArrayEquals(
        new String[] {"blCurrency"}, ((MockHttpSession) sessionMutex).getValueNames());
  }

  /**
   * Test {@link BroadleafCurrencyResolverImpl#resolveCurrency(WebRequest)} with {@code WebRequest}.
   *
   * <p>Method under test: {@link BroadleafCurrencyResolverImpl#resolveCurrency(WebRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "BroadleafRequestedCurrencyDto BroadleafCurrencyResolverImpl.resolveCurrency(WebRequest)"
  })
  public void testResolveCurrencyWithWebRequest2() {
    // Arrange
    when(broadleafCurrencyService.findCurrencyByCode(Mockito.<String>any()))
        .thenReturn(new BroadleafCurrencyImpl());
    when(broadleafCurrencyService.findDefaultBroadleafCurrency())
        .thenReturn(new BroadleafCurrencyImpl());

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(null);
    when(request.getHeader(Mockito.<String>any())).thenReturn("Header");
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());

    // Act
    BroadleafRequestedCurrencyDto actualResolveCurrencyResult =
        broadleafCurrencyResolverImpl.resolveCurrency(request);

    // Assert
    verify(broadleafCurrencyService).findCurrencyByCode("Header");
    verify(broadleafCurrencyService).findDefaultBroadleafCurrency();
    verify(request, atLeast(1)).getAttribute(Mockito.<String>any(), eq(0));
    verify(request).setAttribute(eq("blCurrency"), isA(Object.class), eq(1));
    verify(request, atLeast(1)).getHeader("blCurrencyCode");
    assertTrue(actualResolveCurrencyResult.getCurrencyToUse() instanceof BroadleafCurrencyImpl);
    BroadleafCurrency requestedCurrency = actualResolveCurrencyResult.getRequestedCurrency();
    assertTrue(requestedCurrency instanceof BroadleafCurrencyImpl);
    assertNull(requestedCurrency.getCurrencyCode());
    assertNull(requestedCurrency.getFriendlyName());
    assertNull(((BroadleafCurrencyImpl) requestedCurrency).getMainEntityName());
    assertNull(requestedCurrency.getJavaCurrency());
    assertFalse(requestedCurrency.getDefaultFlag());
  }
}
