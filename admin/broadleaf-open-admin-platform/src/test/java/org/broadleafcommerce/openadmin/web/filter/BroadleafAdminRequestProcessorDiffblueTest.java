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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.sandbox.domain.SandBox;
import org.broadleafcommerce.common.sandbox.domain.SandBoxImpl;
import org.broadleafcommerce.common.sandbox.domain.SandBoxType;
import org.broadleafcommerce.common.sandbox.service.SandBoxService;
import org.broadleafcommerce.common.security.service.StaleStateProtectionService;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.site.service.SiteService;
import org.broadleafcommerce.common.util.DeployBehaviorUtil;
import org.broadleafcommerce.common.web.BroadleafRequestContext;
import org.broadleafcommerce.common.web.DeployBehavior;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUser;
import org.broadleafcommerce.openadmin.server.security.domain.AdminUserImpl;
import org.broadleafcommerce.openadmin.server.security.remote.SecurityVerifier;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafAdminRequestProcessorDiffblueTest {
  @InjectMocks private BroadleafAdminRequestProcessor broadleafAdminRequestProcessor;

  @Mock private DeployBehaviorUtil deployBehaviorUtil;

  @Mock private SandBoxService sandBoxService;

  @Mock private SecurityVerifier securityVerifier;

  @Mock private SiteService siteService;

  @Mock private StaleStateProtectionService staleStateProtectionService;

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new SecurityException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    ServletWebRequest request4 = new ServletWebRequest(request3);

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request4, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile3() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile4() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then BroadleafRequestContext is {@code true} CurrentProfile is {@link SiteImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_thenBroadleafRequestContextIsTrueCurrentProfileIsSiteImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    SiteImpl siteImpl = new SiteImpl();
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(siteImpl);
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));
    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);

    // Act
    broadleafAdminRequestProcessor.prepareProfile(new ServletWebRequest(request2), brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    Site currentProfile = brc.getCurrentProfile();
    assertTrue(currentProfile instanceof SiteImpl);
    assertSame(siteImpl, currentProfile);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link StaleStateProtectionService#compareToken(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_thenCallsCompareToken() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    doThrow(new SecurityException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link WebRequest#removeAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_thenCallsRemoveAttribute() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);

    WebRequest request = mock(WebRequest.class);
    doThrow(new SecurityException()).when(request).removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(
                request, BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).removeAttribute("blProfileId", 1);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_thenThrowIllegalArgumentException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).
   *   <li>Then calls {@link SecurityVerifier#getPersistentAdminUser()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_whenBroadleafRequestContext_thenCallsGetPersistentAdminUser() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link WebRequest} {@link WebRequest#getParameter(String)} return {@code 42}.
   *   <li>Then calls {@link WebRequest#getParameter(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareProfile(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareProfile_whenWebRequestGetParameterReturn42_thenCallsGetParameter() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    doThrow(new SecurityException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(
                request, BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).compareToken("42");
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new SecurityException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    ServletWebRequest request4 = new ServletWebRequest(request3);

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request4, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog3() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog4() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link SecurityException#SecurityException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_givenSecurityException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);

    WebRequest request = mock(WebRequest.class);
    doThrow(new SecurityException()).when(request).removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                request, BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).removeAttribute("blCatalogId", 1);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link SiteService} {@link SiteService#findCatalogById(Long)} throw {@link
   *       SecurityException#SecurityException()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_givenSiteServiceFindCatalogByIdThrowSecurityException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link StaleStateProtectionService#compareToken(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_thenCallsCompareToken() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doThrow(new SecurityException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link StaleStateProtectionService#invalidateState(boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_thenCallsInvalidateState() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalogImpl);
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));
    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(new ServletWebRequest(request2), brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    Catalog currentCatalog = brc.getCurrentCatalog();
    assertTrue(currentCatalog instanceof CatalogImpl);
    assertSame(catalogImpl, currentCatalog);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_thenThrowIllegalArgumentException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    HttpServletRequestWrapper request2 =
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(request));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                new ServletWebRequest(request2),
                BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link BroadleafRequestContext} (default constructor).
   *   <li>Then calls {@link SecurityVerifier#getPersistentAdminUser()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_whenBroadleafRequestContext_thenCallsGetPersistentAdminUser() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link WebRequest} {@link WebRequest#getParameter(String)} return {@code 42}.
   *   <li>Then calls {@link WebRequest#getParameter(String)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareCatalog(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareCatalog_whenWebRequestGetParameterReturn42_thenCallsGetParameter() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doThrow(new SecurityException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(
                request, BroadleafRequestContext.getBroadleafRequestContext(true)));
    verify(staleStateProtectionService).compareToken("42");
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenThrow(new SecurityException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenThrow(new SecurityException());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox3() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(sandBoxService.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenThrow(new SecurityException());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(sandBoxService).retrieveUserSandBoxForParent(isNull(), isNull());
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox4() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenThrow(new SecurityException());
    when(sandBoxService.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(sandBoxService).retrieveUserSandBoxForParent(isNull(), isNull());
    verify(deployBehaviorUtil).isProductionSandBoxMode();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox5() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    JSCompatibilityRequestWrapper request2 = new JSCompatibilityRequestWrapper(request);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    ServletWebRequest request4 = new ServletWebRequest(request3);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request4, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox6() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    ServletWebRequest request =
        new ServletWebRequest(new HttpServletRequestWrapper(new MockHttpServletRequest()));

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link WebRequest} {@link WebRequest#getParameter(String)} return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_given42_whenWebRequestGetParameterReturn42() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn("42");

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(request, atLeast(1)).getParameter("blSandBoxId");
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link AdminUser} {@link AdminUser#getId()} throw {@link
   *       SecurityException#SecurityException()}.
   *   <li>Then calls {@link AdminUser#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_givenAdminUserGetIdThrowSecurityException_thenCallsGetId() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).
   *   <li>Then calls {@link AdminUser#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_givenArrayListAddSandBoxImpl_thenCallsGetId() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SandBoxImpl} (default constructor).
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_givenArrayListAddSandBoxImpl_thenThrowIllegalStateException() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(mock(AdminUser.class));

    ArrayList<SandBox> sandBoxList = new ArrayList<>();
    sandBoxList.add(new SandBoxImpl());
    sandBoxList.add(new SandBoxImpl());
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(sandBoxList);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given space.
   *   <li>Then calls {@link WebRequest#getAttribute(String, int)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_givenSpace_thenCallsGetAttribute() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(" ");
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).createDefaultSandBox();
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(adminUser).getId();
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).getParameter("blSandBoxId");
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) AdditionalProperties size is
   *       one.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafAdminRequestProcessor.prepareSandBox(WebRequest, BroadleafRequestContext)"
  })
  public void testPrepareSandBox_thenBroadleafRequestContextAdditionalPropertiesSizeIsOne() {
    // Arrange
    AdminUserImpl adminUserImpl = new AdminUserImpl();
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUserImpl);
    when(deployBehaviorUtil.isProductionSandBoxMode()).thenReturn(true);
    SandBoxImpl sandBoxImpl = new SandBoxImpl();
    when(sandBoxService.retrieveUserSandBoxForParent(Mockito.<Long>any(), Mockito.<Long>any()))
        .thenReturn(sandBoxImpl);
    when(sandBoxService.retrieveSandBoxesByType(Mockito.<SandBoxType>any()))
        .thenReturn(new ArrayList<>());
    when(sandBoxService.createDefaultSandBox()).thenReturn(new SandBoxImpl());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(
            new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    ServletWebRequest request2 = new ServletWebRequest(request);
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareSandBox(request2, brc);

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
}
