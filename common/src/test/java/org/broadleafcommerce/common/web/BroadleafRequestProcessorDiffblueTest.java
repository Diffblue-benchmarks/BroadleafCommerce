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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.TimeZone;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.domain.ThemeDTO;
import org.broadleafcommerce.common.util.DeployBehaviorUtil;
import org.broadleafcommerce.common.web.exception.HaltFilterChainException;
import org.broadleafcommerce.common.web.filter.SessionlessHttpServletRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafRequestProcessorDiffblueTest {
  @InjectMocks
  private BroadleafRequestProcessor broadleafRequestProcessor;

  @Mock
  private SandBoxService sandBoxService;

  @Mock
  private BaseUrlResolver baseUrlResolver;

  @Mock
  private BroadleafCurrencyResolver broadleafCurrencyResolver;

  @Mock
  private BroadleafLocaleResolver broadleafLocaleResolver;

  @Mock
  private BroadleafSandBoxResolver broadleafSandBoxResolver;

  @Mock
  private BroadleafSiteResolver broadleafSiteResolver;

  @Mock
  private BroadleafThemeResolver broadleafThemeResolver;

  @Mock
  private BroadleafTimeZoneResolver broadleafTimeZoneResolver;

  @Mock
  private DeployBehaviorUtil deployBehaviorUtil;

  @Mock
  private Map<String, ExtensionManager> map;

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafCurrencyImpl currencyToUse = new BroadleafCurrencyImpl();
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(new BroadleafRequestedCurrencyDto(currencyToUse, new BroadleafCurrencyImpl()));
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenReturn(true);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(new LocaleImpl());
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any()))
        .thenReturn(new SandBoxImpl());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(broadleafThemeResolver.resolveTheme(Mockito.<WebRequest>any())).thenReturn(new ThemeDTO("Name", "Path"));

    // Act
    broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(map).entrySet();
    verify(map).size();
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess2() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafCurrencyImpl currencyToUse = new BroadleafCurrencyImpl();
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(new BroadleafRequestedCurrencyDto(currencyToUse, new BroadleafCurrencyImpl()));
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenReturn(true);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(new LocaleImpl());
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any()))
        .thenReturn(new SandBoxImpl());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(broadleafThemeResolver.resolveTheme(Mockito.<WebRequest>any()))
        .thenThrow(new RuntimeException("ThreadLocalManager.notify.orphans"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link BroadleafCurrencyResolver} {@link BroadleafCurrencyResolver#resolveCurrency(WebRequest)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_givenBroadleafCurrencyResolverResolveCurrencyReturnNull() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any())).thenReturn(null);
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenReturn(true);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(new LocaleImpl());
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any()))
        .thenReturn(new SandBoxImpl());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());
    when(broadleafThemeResolver.resolveTheme(Mockito.<WebRequest>any())).thenReturn(new ThemeDTO("Name", "Path"));

    // Act
    broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest())));

    // Assert
    verify(map).entrySet();
    verify(map).size();
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafThemeResolver).resolveTheme(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link BroadleafSandBoxResolver} {@link BroadleafSandBoxResolver#resolveSandBox(WebRequest, Site)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_givenBroadleafSandBoxResolverResolveSandBoxReturnNull() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafRequestedCurrencyDto broadleafRequestedCurrencyDto = mock(BroadleafRequestedCurrencyDto.class);
    when(broadleafRequestedCurrencyDto.getCurrencyToUse()).thenThrow(new HaltFilterChainException("An error occurred"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(broadleafRequestedCurrencyDto);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any())).thenReturn(null);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    // Act and Assert
    assertThrows(HaltFilterChainException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(broadleafRequestedCurrencyDto).getCurrencyToUse();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link BroadleafSiteResolver} {@link BroadleafSiteResolver#resolveSite(WebRequest)} return {@code null}.</li>
   *   <li>Then calls {@link SandBox#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_givenBroadleafSiteResolverResolveSiteReturnNull_thenCallsGetId()
      throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(mock(BroadleafRequestedCurrencyDto.class));
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getId()).thenThrow(new RuntimeException("foo"));
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any())).thenReturn(sandBox);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(sandBox).getId();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), (Site) isNull());
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@code https://example.org/example}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_givenHttpsExampleOrgExample() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(mock(BroadleafRequestedCurrencyDto.class));
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getId()).thenThrow(new RuntimeException("foo"));
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any())).thenReturn(sandBox);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("https://example.org/example", "https://example.org/example");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(request))));
    verify(map).entrySet();
    verify(map).size();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(sandBox).getId();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link SandBox} {@link SandBox#getId()} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then calls {@link SandBox#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_givenSandBoxGetIdThrowRuntimeExceptionWithFoo_thenCallsGetId() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(mock(BroadleafRequestedCurrencyDto.class));
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    SandBox sandBox = mock(SandBox.class);
    when(sandBox.getId()).thenThrow(new RuntimeException("foo"));
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any())).thenReturn(sandBox);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(sandBox).getId();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Then throw {@link HaltFilterChainException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_thenThrowHaltFilterChainException() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafRequestedCurrencyDto broadleafRequestedCurrencyDto = mock(BroadleafRequestedCurrencyDto.class);
    when(broadleafRequestedCurrencyDto.getCurrencyToUse()).thenThrow(new HaltFilterChainException("An error occurred"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(broadleafRequestedCurrencyDto);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(new LocaleImpl());
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any()))
        .thenReturn(new SandBoxImpl());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    // Act and Assert
    assertThrows(HaltFilterChainException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(broadleafRequestedCurrencyDto).getCurrencyToUse();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Then throw {@link HaltFilterChainException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.process(WebRequest)"})
  public void testProcess_thenThrowHaltFilterChainException2() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafRequestedCurrencyDto broadleafRequestedCurrencyDto = mock(BroadleafRequestedCurrencyDto.class);
    when(broadleafRequestedCurrencyDto.getCurrencyToUse()).thenThrow(new HaltFilterChainException("An error occurred"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(broadleafRequestedCurrencyDto);
    when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    when(broadleafSandBoxResolver.resolveSandBox(Mockito.<WebRequest>any(), Mockito.<Site>any()))
        .thenReturn(new SandBoxImpl());
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    // Act and Assert
    assertThrows(HaltFilterChainException.class, () -> broadleafRequestProcessor
        .process(new ServletWebRequest(new SessionlessHttpServletRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(broadleafRequestedCurrencyDto).getCurrencyToUse();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSandBoxResolver).resolveSandBox(isA(WebRequest.class), isA(Site.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafRequestProcessor#isUrlValid(String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isUrlValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isUrlValid(String)"})
  public void testIsUrlValid_thenReturnFalse() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    boolean actualIsUrlValidResult = broadleafRequestProcessor.isUrlValid("https://example.org/example");

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertFalse(actualIsUrlValidResult);
  }

  /**
   * Test {@link BroadleafRequestProcessor#isUrlValid(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isUrlValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isUrlValid(String)"})
  public void testIsUrlValid_thenThrowRuntimeException() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenThrow(new RuntimeException("/"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor.isUrlValid("https://example.org/example"));
    verify(baseUrlResolver).getSiteBaseUrl();
  }

  /**
   * Test {@link BroadleafRequestProcessor#isUrlValid(String)}.
   * <ul>
   *   <li>When {@code https://example.org/example/}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isUrlValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isUrlValid(String)"})
  public void testIsUrlValid_whenHttpsExampleOrgExample_thenReturnTrue() {
    // Arrange
    when(baseUrlResolver.getSiteBaseUrl()).thenReturn("https://example.org/example");

    // Act
    boolean actualIsUrlValidResult = broadleafRequestProcessor.isUrlValid("https://example.org/example/");

    // Assert
    verify(baseUrlResolver).getSiteBaseUrl();
    assertTrue(actualIsUrlValidResult);
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>Given {@link SandBoxService} {@link SandBoxService#retrieveSandBoxById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isSandboxIdValid(String)"})
  public void testIsSandboxIdValid_givenSandBoxServiceRetrieveSandBoxByIdReturnNull() {
    // Arrange
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any())).thenReturn(null);

    // Act
    boolean actualIsSandboxIdValidResult = broadleafRequestProcessor.isSandboxIdValid("42");

    // Assert
    verify(sandBoxService).retrieveSandBoxById(eq(42L));
    assertFalse(actualIsSandboxIdValidResult);
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isSandboxIdValid(String)"})
  public void testIsSandboxIdValid_thenReturnTrue() {
    // Arrange
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any())).thenReturn(new SandBoxImpl());

    // Act
    boolean actualIsSandboxIdValidResult = broadleafRequestProcessor.isSandboxIdValid("42");

    // Assert
    verify(sandBoxService).retrieveSandBoxById(eq(42L));
    assertTrue(actualIsSandboxIdValidResult);
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isSandboxIdValid(String)"})
  public void testIsSandboxIdValid_thenThrowRuntimeException() {
    // Arrange
    when(sandBoxService.retrieveSandBoxById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> broadleafRequestProcessor.isSandboxIdValid("42"));
    verify(sandBoxService).retrieveSandBoxById(eq(42L));
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isSandboxIdValid(String)"})
  public void testIsSandboxIdValid_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafRequestProcessor.isSandboxIdValid(""));
  }

  /**
   * Test {@link BroadleafRequestProcessor#isSandboxIdValid(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#isSandboxIdValid(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BroadleafRequestProcessor.isSandboxIdValid(String)"})
  public void testIsSandboxIdValid_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(broadleafRequestProcessor.isSandboxIdValid(null));
  }

  /**
   * Test {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest} {@link RequestAttributes#getAttribute(String, int)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.clearBroadleafSessionAttrs(WebRequest)"})
  public void testClearBroadleafSessionAttrs_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    broadleafRequestProcessor.clearBroadleafSessionAttrs(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
  }

  /**
   * Test {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link RequestAttributes#removeAttribute(String, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafRequestProcessor#clearBroadleafSessionAttrs(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafRequestProcessor.clearBroadleafSessionAttrs(WebRequest)"})
  public void testClearBroadleafSessionAttrs_givenTrue_thenCallsRemoveAttribute() {
    // Arrange
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());

    // Act
    broadleafRequestProcessor.clearBroadleafSessionAttrs(request);

    // Assert
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request, atLeast(1)).removeAttribute(Mockito.<String>any(), eq(1));
  }
}
