package org.broadleafcommerce.openadmin.web.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

@ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml",
    "/bl-open-admin-applicationContext-entity.xml", "/bl-open-admin-contentClient-applicationContext.xml",
    "/bl-open-admin-contentCreator-applicationContext.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml",
    "/blc-config/admin/framework/bl-open-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminRequestProcessorExtensionManagerDiffblueTest {
  @Autowired
  private AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(new AdminRequestProcessorExtensionManager());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveProfiles(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Site>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult = adminRequestProcessorExtensionManager
        .retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).retrieveProfiles(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveProfiles(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Site>>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult = adminRequestProcessorExtensionManager
        .retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).retrieveProfiles(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveProfilesResult = adminRequestProcessorExtensionManager
        .retrieveProfiles(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRetrieveProfilesResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveProfiles5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1777 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager2 = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    adminRequestProcessorExtensionManager2.retrieveProfiles(currentSite, result);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles_givenAdminRequestProcessorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles_givenAdminRequestProcessorExtensionManager_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = mock(SiteImpl.class);

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(new AdminRequestProcessorExtensionManager());
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveCatalogs(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Catalog>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult = adminRequestProcessorExtensionManager
        .retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.retrieveCatalogs(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Catalog>>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult = adminRequestProcessorExtensionManager
        .retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).retrieveCatalogs(isA(Site.class), isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualRetrieveCatalogsResult = adminRequestProcessorExtensionManager
        .retrieveCatalogs(currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualRetrieveCatalogsResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRetrieveCatalogs5() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1718 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager2 = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act
    adminRequestProcessorExtensionManager2.retrieveCatalogs(currentSite, result);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs_givenAdminRequestProcessorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   *   <li>When {@link SiteImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs_givenAdminRequestProcessorExtensionManager_whenSiteImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    SiteImpl currentSite = mock(SiteImpl.class);

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(
        new JSCompatibilityRequestWrapper(mock(DefaultMultipartHttpServletRequest.class)));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(new AdminRequestProcessorExtensionManager());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentCatalog(Mockito.<WebRequest>any(), Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Catalog>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult = adminRequestProcessorExtensionManager
        .overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).overrideCurrentCatalog(isA(WebRequest.class), isA(Site.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentCatalog(Mockito.<WebRequest>any(), Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Catalog>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult = adminRequestProcessorExtensionManager
        .overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).overrideCurrentCatalog(isA(WebRequest.class), isA(Site.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentCatalogResult = adminRequestProcessorExtensionManager
        .overrideCurrentCatalog(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOverrideCurrentCatalogResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideCurrentCatalog6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1352 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager2 = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act
    adminRequestProcessorExtensionManager2.overrideCurrentCatalog(request, currentSite, result);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog_givenAdminRequestProcessorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(
        new JSCompatibilityRequestWrapper(mock(DefaultMultipartHttpServletRequest.class)));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(new AdminRequestProcessorExtensionManager());
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result));
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentProfile(Mockito.<WebRequest>any(), Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult = adminRequestProcessorExtensionManager
        .overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).overrideCurrentProfile(isA(WebRequest.class), isA(Site.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.overrideCurrentProfile(Mockito.<WebRequest>any(), Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(true);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult = adminRequestProcessorExtensionManager
        .overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    verify(adminRequestProcessorExtensionHandler).overrideCurrentProfile(isA(WebRequest.class), isA(Site.class),
        isA(ExtensionResultHolder.class));
    assertEquals(ExtensionResultStatusType.HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionHandler adminRequestProcessorExtensionHandler = mock(
        AdminRequestProcessorExtensionHandler.class);
    when(adminRequestProcessorExtensionHandler.isEnabled()).thenReturn(false);

    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    adminRequestProcessorExtensionManager.registerHandler(adminRequestProcessorExtensionHandler);
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOverrideCurrentProfileResult = adminRequestProcessorExtensionManager
        .overrideCurrentProfile(request, currentSite, result);

    // Assert
    verify(adminRequestProcessorExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOverrideCurrentProfileResult);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testOverrideCurrentProfile6() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.openadmin.web.filter;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/applicationContext-servlet-open-admin.xml","/bl-open-admin-applicationContext-entity.xml","/bl-open-admin-contentClient-applicationContext.xml","/bl-open-admin-contentCreator-applicationContext.xml","/blc-config/admin/framework/bl-open-admin-applicationContext-servlet.xml","/blc-config/admin/framework/bl-open-admin-applicationContext.xml","/blc-config/site/framework/bl-openadmin-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1533 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.openadmin.web.filter.AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager2 = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act
    adminRequestProcessorExtensionManager2.overrideCurrentProfile(request, currentSite, result);
  }

  /**
   * Test
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link AdminRequestProcessorExtensionManager} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile_givenAdminRequestProcessorExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager = new AdminRequestProcessorExtensionManager();
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Site> result = new ExtensionResultHolder<>();
    result.setResult(new SiteImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentProfile(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new AdminRequestProcessorExtensionManager()).isEnabled());
  }
}
