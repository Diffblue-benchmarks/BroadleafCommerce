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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequestWrapper;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.CatalogImpl;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.openadmin.web.compatibility.JSCompatibilityRequestWrapper;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ContextConfiguration(classes = {AdminRequestProcessorExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class AdminRequestProcessorExtensionManagerDiffblueTest {
  @Autowired
  private AdminRequestProcessorExtensionManager adminRequestProcessorExtensionManager;

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"})
  public void testRetrieveProfiles_whenNull() {
    // Arrange
    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(null, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#retrieveProfiles(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveProfiles(Site, ExtensionResultHolder)"})
  public void testRetrieveProfiles_whenSiteImpl() {
    // Arrange
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Site>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveProfiles(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"})
  public void testRetrieveCatalogs_whenNull() {
    // Arrange
    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(null, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#retrieveCatalogs(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.retrieveCatalogs(Site, ExtensionResultHolder)"})
  public void testRetrieveCatalogs_whenSiteImpl() {
    // Arrange
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Set<Catalog>> result = new ExtensionResultHolder<>();
    result.setResult(new HashSet<>());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.retrieveCatalogs(currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"})
  public void testOverrideCurrentCatalog() {
    // Arrange
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
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentCatalog(WebRequest, Site, ExtensionResultHolder)"})
  public void testOverrideCurrentCatalog2() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))));
    SiteImpl currentSite = new SiteImpl();

    ExtensionResultHolder<Catalog> result = new ExtensionResultHolder<>();
    result.setResult(new CatalogImpl());
    result.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        adminRequestProcessorExtensionManager.overrideCurrentCatalog(request, currentSite, result));
  }

  /**
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"})
  public void testOverrideCurrentProfile() {
    // Arrange
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
   * Test {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AdminRequestProcessorExtensionManager#overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AdminRequestProcessorExtensionManager.overrideCurrentProfile(WebRequest, Site, ExtensionResultHolder)"})
  public void testOverrideCurrentProfile2() {
    // Arrange
    ServletWebRequest request = new ServletWebRequest(new JSCompatibilityRequestWrapper(
        new HttpServletRequestWrapper(new JSCompatibilityRequestWrapper(new MockHttpServletRequest()))));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminRequestProcessorExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new AdminRequestProcessorExtensionManager()).isEnabled());
  }
}
