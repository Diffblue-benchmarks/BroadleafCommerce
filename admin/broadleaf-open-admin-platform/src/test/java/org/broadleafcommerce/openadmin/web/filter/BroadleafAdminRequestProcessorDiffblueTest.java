/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import org.broadleafcommerce.common.currency.domain.BroadleafRequestedCurrencyDto;
import org.broadleafcommerce.common.exception.SiteNotFoundException;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBoxType;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.common.util.DeployBehaviorUtil;
import org.broadleafcommerce.common.web.BroadleafCurrencyResolver;
import org.broadleafcommerce.common.web.BroadleafLocaleResolver;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.common.web.BroadleafSiteResolver;
import org.broadleafcommerce.common.web.BroadleafTimeZoneResolver;
import org.broadleafcommerce.common.web.DeployBehavior;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.server.security.service.AdminSecurityService;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafAdminRequestProcessorDiffblueTest {
  @Mock
  private AdminSecurityService adminSecurityService;

  @InjectMocks
  private BroadleafAdminRequestProcessor broadleafAdminRequestProcessor;

  @Mock
  private BroadleafCurrencyResolver broadleafCurrencyResolver;

  @Mock
  private BroadleafLocaleResolver broadleafLocaleResolver;

  @Mock
  private BroadleafSiteResolver broadleafSiteResolver;

  @Mock
  private BroadleafTimeZoneResolver broadleafTimeZoneResolver;

  @Mock
  private DeployBehaviorUtil deployBehaviorUtil;

  @Mock
  private Map<String, ExtensionManager<?>> map;

  @Mock
  private MessageSource messageSource;

  @Mock
  private SandBoxService sandBoxService;

  @Mock
  private SecurityVerifier securityVerifier;

  @Mock
  private SiteService siteService;

  @Mock
  private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link BroadleafAdminRequestProcessor#process(WebRequest)}.
   * <ul>
   *   <li>Given {@link Locale} {@link Locale#getJavaLocale()} return Default.</li>
   *   <li>Then calls {@link Locale#getJavaLocale()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#process(WebRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.process(WebRequest)"})
  public void testProcess_givenLocaleGetJavaLocaleReturnDefault_thenCallsGetJavaLocale() throws SiteNotFoundException {
    // Arrange
    when(broadleafTimeZoneResolver.resolveTimeZone(Mockito.<WebRequest>any()))
        .thenReturn(TimeZone.getTimeZone("America/Los_Angeles"));
    BroadleafRequestedCurrencyDto broadleafRequestedCurrencyDto = mock(BroadleafRequestedCurrencyDto.class);
    when(broadleafRequestedCurrencyDto.getCurrencyToUse()).thenThrow(new SiteNotFoundException("An error occurred"));
    when(broadleafCurrencyResolver.resolveCurrency(Mockito.<WebRequest>any()))
        .thenReturn(broadleafRequestedCurrencyDto);
    Mockito.<Set<Entry<String, ExtensionManager<?>>>>when(map.entrySet()).thenReturn(new HashSet<>());
    when(map.size()).thenReturn(3);
    Locale locale = mock(Locale.class);
    when(locale.getJavaLocale()).thenReturn(java.util.Locale.getDefault());
    when(locale.getLocaleCode()).thenReturn("en");
    when(broadleafLocaleResolver.resolveLocale(Mockito.<WebRequest>any())).thenReturn(locale);
    when(broadleafSiteResolver.resolveSite(Mockito.<WebRequest>any())).thenReturn(new SiteImpl());

    // Act and Assert
    assertThrows(SiteNotFoundException.class, () -> broadleafAdminRequestProcessor
        .process(new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))));
    verify(map).entrySet();
    verify(map).size();
    verify(broadleafRequestedCurrencyDto).getCurrencyToUse();
    verify(locale).getJavaLocale();
    verify(locale).getLocaleCode();
    verify(broadleafCurrencyResolver).resolveCurrency(isA(WebRequest.class));
    verify(broadleafLocaleResolver).resolveLocale(isA(WebRequest.class));
    verify(broadleafSiteResolver).resolveSite(isA(WebRequest.class));
    verify(broadleafTimeZoneResolver).resolveTimeZone(isA(WebRequest.class));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#getPersistentAdminUser()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_givenSecurityVerifierGetPersistentAdminUserReturnNull() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) CurrentProfile is {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_thenBroadleafRequestContextCurrentProfileIsSiteImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    SiteImpl siteImpl = new SiteImpl();
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(siteImpl);
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    WebRequest request = mock(WebRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(eq("42"));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(eq(true));
    verify(siteService).retrievePersistentSiteById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).setAttribute(eq("blProfileId"), isNull(), eq(1));
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertSame(siteImpl, brc.getCurrentProfile());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_thenThrowIllegalArgumentException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(null);
    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext()));
    verify(siteService).retrievePersistentSiteById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(eq("blProfileId"));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_thenThrowSecurityException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);
    WebRequest request = mock(WebRequest.class);
    doThrow(new SecurityException(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM)).when(request)
        .removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).removeAttribute(eq("blProfileId"), eq(1));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then throw {@link SiteNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_thenThrowSiteNotFoundException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SiteNotFoundException("An error occurred"));
    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(SiteNotFoundException.class,
        () -> broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext()));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).retrievePersistentSiteById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(eq("blProfileId"));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>When {@link ServletWebRequest#ServletWebRequest(HttpServletRequest)} with request is {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"})
  public void testPrepareProfile_whenServletWebRequestWithRequestIsMockHttpServletRequest() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link WebRequest} {@link RequestAttributes#getAttribute(String, int)} return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);
    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link SecurityException#SecurityException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_givenSecurityExceptionWithFoo_thenThrowSecurityException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);
    WebRequest request = mock(WebRequest.class);
    doThrow(new SecurityException("foo")).when(request).removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).removeAttribute(eq("blCatalogId"), eq(1));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link SecurityVerifier} {@link SecurityVerifier#getPersistentAdminUser()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_givenSecurityVerifierGetPersistentAdminUserReturnNull() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) CurrentCatalog is {@link CatalogImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_thenBroadleafRequestContextCurrentCatalogIsCatalogImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalogImpl);
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    WebRequest request = mock(WebRequest.class);
    doNothing().when(request).setAttribute(Mockito.<String>any(), Mockito.<Object>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(eq("42"));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(eq(true));
    verify(siteService).findCatalogById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute(eq("blOkToUseSession"), eq(0));
    verify(request).setAttribute(eq("blCatalogId"), isNull(), eq(1));
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
    assertSame(catalogImpl, brc.getCurrentCatalog());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_thenThrowIllegalArgumentException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(null);
    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext()));
    verify(siteService).findCatalogById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(eq("blCatalogId"));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then throw {@link SiteNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_thenThrowSiteNotFoundException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SiteNotFoundException("An error occurred"));
    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(SiteNotFoundException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext()));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(eq(42L));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(eq("blCatalogId"));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>When {@link ServletWebRequest#ServletWebRequest(HttpServletRequest)} with request is {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"})
  public void testPrepareCatalog_whenServletWebRequestWithRequestIsMockHttpServletRequest() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(deployBehaviorUtil.isProductionSandBoxMode())
        .thenThrow(new SecurityException(BroadleafAdminRequestProcessor.SANDBOX_REQ_PARAM));
    when(sandBoxService.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(sandBoxService).retrieveUserSandBoxForParent(isNull(), isNull());
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox2() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException("foo"));
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request = new ServletWebRequest(
        new JSCompatibilityRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest())));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then calls {@link AdminUser#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_givenArrayListAddSandBoxImpl_thenCallsGetId() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException("foo"));
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_givenArrayListAddSandBoxImpl_thenThrowIllegalStateException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(mock(AdminUser.class));

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(new SandBoxImpl());
    sandBoxList.add(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(sandBoxList);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Given {@link SandBoxService}.</li>
   *   <li>Then calls {@link WebRequest#getParameter(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_givenSandBoxService_thenCallsGetParameter() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException("foo"));
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(eq("blSandBoxId"));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) AdditionalProperties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_thenBroadleafRequestContextAdditionalPropertiesSizeIsOne() {
    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenReturn(true);
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxService.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(sandBoxImpl);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareSandBox(request, brc);

    // Assert
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(sandBoxService).retrieveUserSandBoxForParent(isNull(), isNull());
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(securityVerifier).getPersistentAdminUser();
    Map<String, Object> additionalProperties = brc.getAdditionalProperties();
    assertEquals(1, additionalProperties.size());
    Object getResult = additionalProperties.get("adminUser");
    assertTrue(getResult instanceof AdminUserImpl);
    assertEquals(DeployBehavior.CLONE_PARENT, brc.getDeployBehavior());
    assertFalse(brc.isProductionSandBox());
    assertSame(sandBoxImpl, brc.getSandBox());
    assertSame(adminUserImpl, getResult);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>Then calls {@link SandBoxService#createDefaultSandBox()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_thenCallsCreateDefaultSandBox() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException("foo"));
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}.
   * <ul>
   *   <li>When {@link ServletWebRequest#ServletWebRequest(HttpServletRequest)} with request is {@link MockHttpServletRequest#MockHttpServletRequest()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest, BroadleafRequestContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"})
  public void testPrepareSandBox_whenServletWebRequestWithRequestIsMockHttpServletRequest() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException("foo"));
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any())).thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }
}
