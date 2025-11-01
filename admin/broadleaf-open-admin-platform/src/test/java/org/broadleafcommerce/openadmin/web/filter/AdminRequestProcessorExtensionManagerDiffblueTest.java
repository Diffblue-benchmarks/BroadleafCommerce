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
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

public class AdminRequestProcessorExtensionManagerDiffblueTest {
  /**
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles2() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles3() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles4() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles5() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveProfiles6() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs2() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs3() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs4() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs5() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  public void testRetrieveCatalogs6() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog2() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog3() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog5() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentCatalog6() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile2() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile3() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile5() {
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
   * Method under test:
   * {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  public void testOverrideCurrentProfile6() {
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
   * Method under test: {@link AdminRequestProcessorExtensionManager#isEnabled()}
   */
  @Test
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new AdminRequestProcessorExtensionManager()).isEnabled());
  }
}
