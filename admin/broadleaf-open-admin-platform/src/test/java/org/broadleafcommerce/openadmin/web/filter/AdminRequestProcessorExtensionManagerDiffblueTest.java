package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {AdminRequestProcessorExtensionManager.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminRequestProcessorExtensionManagerDiffblueTest {
  @Autowired private AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"
  })
  public void testRetrieveProfiles() {
    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(
        new AdminRequestProcessorExtensionManager());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"
  })
  public void testRetrieveProfiles2() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveProfiles(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Site>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult =
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .retrieveProfiles(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"
  })
  public void testRetrieveProfiles3() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveProfiles(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Site>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult =
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .retrieveProfiles(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"
  })
  public void testRetrieveProfiles4() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult =
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"
  })
  public void testRetrieveProfiles_givenAdminRequestProcessorExtensionManager() {
    // Arrange
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"
  })
  public void testRetrieveCatalogs() {
    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(
        new AdminRequestProcessorExtensionManager());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"
  })
  public void testRetrieveCatalogs2() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveCatalogs(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Catalog>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult =
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"
  })
  public void testRetrieveCatalogs3() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveCatalogs(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Set<Catalog>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult =
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"
  })
  public void testRetrieveCatalogs4() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult =
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"
  })
  public void testRetrieveCatalogs_givenAdminRequestProcessorExtensionManager() {
    // Arrange
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog() {
    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(
        new AdminRequestProcessorExtensionManager());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog2() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentCatalog(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Catalog>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult =
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .overrideCurrentCatalog(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog3() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentCatalog(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Catalog>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult =
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .overrideCurrentCatalog(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog4() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult =
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog_givenAdminRequestProcessorExtensionManager() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@code priority}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentCatalog_givenPriority() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("priority", "42");
    ServletWebRequest request2 = new ServletWebRequest(request);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(
            request2, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentProfile() {
    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(
        new AdminRequestProcessorExtensionManager());
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentProfile2() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentProfile(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult =
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .overrideCurrentProfile(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentProfile3() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentProfile(
            Mockito.<WebRequest>any(),
            Mockito.<Site>any(),
            Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult =
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler)
        .overrideCurrentProfile(
            isA(WebRequest.class), isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentProfile4() {
    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler =
        mock(AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager =
        new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult =
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}.
   *
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site,
   * ExtensionResultHolder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"
  })
  public void testOverrideCurrentProfile_givenAdminRequestProcessorExtensionManager() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new MockHttpServletRequest());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(
        ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#isEnabled()}.
   *
   * <p>Method under test: {@link AdminRequestProcessorExtensionManager#isEnabled()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AdminRequestProcessorExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue(new AdminRequestProcessorExtensionManager().isEnabled());
  }
}
