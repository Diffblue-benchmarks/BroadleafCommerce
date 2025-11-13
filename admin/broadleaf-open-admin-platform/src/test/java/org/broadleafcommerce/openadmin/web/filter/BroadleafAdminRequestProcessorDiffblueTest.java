package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
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
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class BroadleafAdminRequestProcessorDiffblueTest {
  @Mock private AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;

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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext()));
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
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any()))
        .thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext()));
    verify(siteService).retrievePersistentSiteById(42L);
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
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext()));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).retrievePersistentSiteById(42L);
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
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any()))
        .thenThrow(new SecurityException());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class, () -> broadleafAdminRequestProcessor.prepareProfile(request, brc));
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link SecurityException#SecurityException()}.
   *   <li>Then calls {@link ServletWebRequest#getAttribute(String, int)}.
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
  public void testPrepareProfile_givenSecurityException_thenCallsGetAttribute() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);

    ServletWebRequest request = mock(ServletWebRequest.class);
    doThrow(new SecurityException()).when(request).removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request, new BroadleafRequestContext()));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).removeAttribute("blProfileId", 1);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) CurrentProfile is {@link
   *       SiteImpl} (default constructor).
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
  public void testPrepareProfile_thenBroadleafRequestContextCurrentProfileIsSiteImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    SiteImpl siteImpl = new SiteImpl();
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(siteImpl);
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.PROFILE_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareProfile(request2, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    assertSame(siteImpl, brc.getCurrentProfile());
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
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext()));
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
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafAdminRequestProcessor.prepareProfile(request2, new BroadleafRequestContext()));
    verify(siteService).retrievePersistentSiteById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareProfile(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link ServletWebRequest#ServletWebRequest(HttpServletRequest)} with request is
   *       {@link MockHttpServletRequest#MockHttpServletRequest()}.
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext()));
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
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    when(staleStateProtectionService.getStateVersionTokenParameter())
        .thenThrow(new SecurityException());

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext()));
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(42L);
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
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doThrow(new SecurityException())
        .when(staleStateProtectionService)
        .compareToken(Mockito.<String>any());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext()));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(siteService).findCatalogById(42L);
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
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any()))
        .thenThrow(new SecurityException());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request2, brc));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).findCatalogById(42L);
    verify(siteService).retrievePersistentSiteById(isNull());
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
  public void testPrepareCatalog5() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(adminRequestProcessorExtensionManager.retrieveCatalogs(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Catalog>>>any()))
        .thenThrow(new SecurityException());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request2, brc));
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminRequestProcessorExtensionManager)
        .retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code 42}.
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
  public void testPrepareCatalog_givenArrayOfStringWith42() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(adminRequestProcessorExtensionManager.overrideCurrentCatalog(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Catalog>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionManager.overrideCurrentProfile(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalogImpl);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("catalogEntityCatalogDiscriminatorId", "42");
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);
    brc.setNonPersistentSite(new SiteImpl());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request2, brc);

    // Assert
    verify(siteService).findCatalogById(42L);
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentCatalog(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentProfile(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertSame(catalogImpl, brc.getCurrentCatalog());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link Catalog} {@link Catalog#getId()} throw {@link
   *       SecurityException#SecurityException()}.
   *   <li>Then calls {@link Catalog#getId()}.
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
  public void testPrepareCatalog_givenCatalogGetIdThrowSecurityException_thenCallsGetId() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    Catalog catalog = mock(Catalog.class);
    when(catalog.getId()).thenThrow(new SecurityException());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalog);
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request2, brc));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(catalog).getId();
    verify(siteService).findCatalogById(42L);
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link WebRequest} {@link WebRequest#getAttribute(String, int)} return {@code
   *       false}.
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
  public void testPrepareCatalog_givenFalse_whenWebRequestGetAttributeReturnFalse() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);

    WebRequest request = mock(WebRequest.class);
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, brc);

    // Assert
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
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

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class, () -> broadleafAdminRequestProcessor.prepareCatalog(request, brc));
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).removeAttribute("blCatalogId", 1);
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link SiteImpl} {@link SiteImpl#getId()} throw {@link
   *       SecurityException#SecurityException()}.
   *   <li>Then calls {@link SiteImpl#getId()}.
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
  public void testPrepareCatalog_givenSiteImplGetIdThrowSecurityException_thenCallsGetId() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    SiteImpl siteImpl = mock(SiteImpl.class);
    when(siteImpl.getId()).thenThrow(new SecurityException());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getNonPersistentSite()).thenReturn(siteImpl);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class, () -> broadleafAdminRequestProcessor.prepareCatalog(request, brc));
    verify(siteImpl).getId();
    verify(brc, atLeast(1)).getNonPersistentSite();
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link SiteService} {@link SiteService#findCatalogById(Long)} return {@code null}.
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
  public void testPrepareCatalog_givenSiteServiceFindCatalogByIdReturnNull() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(null);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext()));
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
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
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareCatalog(request2, new BroadleafRequestContext()));
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given space.
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
  public void testPrepareCatalog_givenSpace_thenCallsGetParameter() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());

    WebRequest request = mock(WebRequest.class);
    when(request.getParameter(Mockito.<String>any())).thenReturn(" ");
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(false);

    SiteImpl siteImpl = mock(SiteImpl.class);
    when(siteImpl.getId()).thenThrow(new SecurityException());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getNonPersistentSite()).thenReturn(siteImpl);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class, () -> broadleafAdminRequestProcessor.prepareCatalog(request, brc));
    verify(siteImpl).getId();
    verify(brc, atLeast(1)).getNonPersistentSite();
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request, atLeast(1)).getParameter(Mockito.<String>any());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then {@link BroadleafRequestContext} (default constructor) CurrentCatalog {@link
   *       CatalogImpl}.
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
  public void testPrepareCatalog_thenBroadleafRequestContextCurrentCatalogCatalogImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);
    BroadleafRequestContext brc = new BroadleafRequestContext();

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request2, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).findCatalogById(42L);
    verify(securityVerifier).getPersistentAdminUser();
    Catalog currentCatalog = brc.getCurrentCatalog();
    assertTrue(currentCatalog instanceof CatalogImpl);
    assertEquals('N', currentCatalog.getArchived().charValue());
    assertNull(currentCatalog.getId());
    assertNull(currentCatalog.getName());
    assertNull(((CatalogImpl) currentCatalog).getMainEntityName());
    assertTrue(currentCatalog.getSiteXrefs().isEmpty());
    assertTrue(currentCatalog.getSites().isEmpty());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then BroadleafRequestContext is {@code true} CurrentCatalog is {@link CatalogImpl}
   *       (default constructor).
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
  public void testPrepareCatalog_thenBroadleafRequestContextIsTrueCurrentCatalogIsCatalogImpl() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(adminRequestProcessorExtensionManager.overrideCurrentCatalog(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Catalog>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionManager.overrideCurrentProfile(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    CatalogImpl catalogImpl = new CatalogImpl();
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(catalogImpl);
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    BroadleafRequestContext brc = BroadleafRequestContext.getBroadleafRequestContext(true);
    brc.setNonPersistentSite(new SiteImpl());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request2, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).findCatalogById(42L);
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentCatalog(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentProfile(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertSame(catalogImpl, brc.getCurrentCatalog());
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafRequestContext#setCurrentCatalog(Catalog)}.
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
  public void testPrepareCatalog_thenCallsSetCurrentCatalog() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(adminRequestProcessorExtensionManager.overrideCurrentCatalog(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Catalog>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionManager.overrideCurrentProfile(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setCurrentCatalog(Mockito.<Catalog>any());
    when(brc.getNonPersistentSite()).thenReturn(new SiteImpl());
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request2, brc);

    // Assert
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteService).findCatalogById(42L);
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(brc, atLeast(1)).getNonPersistentSite();
    verify(brc).setCurrentCatalog(isA(Catalog.class));
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentCatalog(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    verify(adminRequestProcessorExtensionManager)
        .overrideCurrentProfile(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafRequestContext#setCurrentCatalog(Catalog)}.
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
  public void testPrepareCatalog_thenCallsSetCurrentCatalog2() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(new AdminUserImpl());
    when(siteService.findCatalogById(Mockito.<Long>any())).thenReturn(new CatalogImpl());
    doNothing().when(staleStateProtectionService).compareToken(Mockito.<String>any());
    doNothing().when(staleStateProtectionService).invalidateState(anyBoolean());
    when(staleStateProtectionService.getStateVersionTokenParameter()).thenReturn("MD");

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.CATALOG_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    SiteImpl siteImpl = mock(SiteImpl.class);
    when(siteImpl.getId()).thenThrow(new SecurityException());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setCurrentCatalog(Mockito.<Catalog>any());
    when(brc.getNonPersistentSite()).thenReturn(siteImpl);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request2, brc));
    verify(staleStateProtectionService).compareToken(null);
    verify(staleStateProtectionService).getStateVersionTokenParameter();
    verify(staleStateProtectionService).invalidateState(true);
    verify(siteImpl).getId();
    verify(siteService).findCatalogById(42L);
    verify(brc, atLeast(1)).getNonPersistentSite();
    verify(brc).setCurrentCatalog(isA(Catalog.class));
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
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
    when(adminRequestProcessorExtensionManager.retrieveCatalogs(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Catalog>>>any()))
        .thenThrow(new IllegalArgumentException());
    when(siteService.retrievePersistentSiteById(Mockito.<Long>any())).thenReturn(new SiteImpl());
    MockHttpServletRequest request = new MockHttpServletRequest();
    ServletWebRequest request2 = new ServletWebRequest(request, new MockHttpServletResponse());

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    when(brc.getNonPersistentSite()).thenReturn(new SiteImpl());
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> broadleafAdminRequestProcessor.prepareCatalog(request2, brc));
    verify(siteService).retrievePersistentSiteById(isNull());
    verify(brc, atLeast(1)).getNonPersistentSite();
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(adminRequestProcessorExtensionManager)
        .retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, new BroadleafRequestContext());

    // Assert that nothing has changed
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareCatalog(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>When {@link WebRequest} {@link WebRequest#removeAttribute(String, int)} does nothing.
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
  public void testPrepareCatalog_whenWebRequestRemoveAttributeDoesNothing() {
    // Arrange
    when(securityVerifier.getPersistentAdminUser()).thenReturn(null);

    WebRequest request = mock(WebRequest.class);
    doNothing().when(request).removeAttribute(Mockito.<String>any(), anyInt());
    when(request.getAttribute(Mockito.<String>any(), anyInt())).thenReturn(true);

    BroadleafRequestContext brc = mock(BroadleafRequestContext.class);
    doNothing().when(brc).setNonPersistentSite(Mockito.<Site>any());
    brc.setNonPersistentSite(new SiteImpl());

    // Act
    broadleafAdminRequestProcessor.prepareCatalog(request, brc);

    // Assert
    verify(brc).setNonPersistentSite(isA(Site.class));
    verify(securityVerifier).getPersistentAdminUser();
    verify(request).getAttribute("blOkToUseSession", 0);
    verify(request).removeAttribute("blCatalogId", 1);
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request, new BroadleafRequestContext()));
    verify(sandBoxService).retrieveSandBoxesByType(isA(SandBoxType.class));
    verify(securityVerifier).getPersistentAdminUser();
  }

  /**
   * Test {@link BroadleafAdminRequestProcessor#prepareSandBox(WebRequest,
   * BroadleafRequestContext)}.
   *
   * <ul>
   *   <li>Given {@link BroadleafAdminRequestProcessor#SANDBOX_REQ_PARAM}.
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
  public void testPrepareSandBox_givenSandbox_req_param() {
    // Arrange
    AdminUser adminUser = mock(AdminUser.class);
    when(adminUser.getId()).thenThrow(new SecurityException());
    when(securityVerifier.getPersistentAdminUser()).thenReturn(adminUser);

    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter(BroadleafAdminRequestProcessor.SANDBOX_REQ_PARAM, "42");
    ServletWebRequest request2 = new ServletWebRequest(request);

    // Act and Assert
    assertThrows(
        SecurityException.class,
        () ->
            broadleafAdminRequestProcessor.prepareSandBox(request2, new BroadleafRequestContext()));
    verify(adminUser).getId();
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
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
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
}
