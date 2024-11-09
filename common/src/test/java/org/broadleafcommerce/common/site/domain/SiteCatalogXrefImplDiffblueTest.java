/*-
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.common.site.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.persistence.ArchiveStatus;
import org.junit.Test;

public class SiteCatalogXrefImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SiteCatalogXrefImpl#setCatalog(Catalog)}
   *   <li>{@link SiteCatalogXrefImpl#setId(Long)}
   *   <li>{@link SiteCatalogXrefImpl#setSite(Site)}
   *   <li>{@link SiteCatalogXrefImpl#getCatalog()}
   *   <li>{@link SiteCatalogXrefImpl#getId()}
   *   <li>{@link SiteCatalogXrefImpl#getSite()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    SiteCatalogXrefImpl siteCatalogXrefImpl = new SiteCatalogXrefImpl();
    CatalogImpl catalog = new CatalogImpl();

    // Act
    siteCatalogXrefImpl.setCatalog(catalog);
    siteCatalogXrefImpl.setId(1L);
    SiteImpl site = new SiteImpl();
    siteCatalogXrefImpl.setSite(site);
    Catalog actualCatalog = siteCatalogXrefImpl.getCatalog();
    Long actualId = siteCatalogXrefImpl.getId();
    Site actualSite = siteCatalogXrefImpl.getSite();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertSame(catalog, actualCatalog);
    assertSame(site, actualSite);
  }

  /**
   * Test {@link SiteCatalogXrefImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CatalogImpl} {@link CatalogImpl#getName()} return
   * {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteCatalogXrefImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenCatalogImplGetNameReturnName_thenReturnName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalog = mock(CatalogImpl.class);
    when(catalog.getName()).thenReturn("Name");

    SiteCatalogXrefImpl siteCatalogXrefImpl = new SiteCatalogXrefImpl();
    siteCatalogXrefImpl.setCatalog(catalog);

    // Act
    String actualMainEntityName = siteCatalogXrefImpl.getMainEntityName();

    // Assert
    verify(catalog).getName();
    assertEquals("Name", actualMainEntityName);
  }

  /**
   * Test {@link SiteCatalogXrefImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SiteCatalogXrefImpl} (default constructor) Site is
   * {@link SiteImpl}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteCatalogXrefImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSiteCatalogXrefImplSiteIsSiteImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteCatalogXrefImpl siteCatalogXrefImpl = new SiteCatalogXrefImpl();
    siteCatalogXrefImpl.setSite(mock(SiteImpl.class));

    // Act and Assert
    assertNull(siteCatalogXrefImpl.getMainEntityName());
  }

  /**
   * Test {@link SiteCatalogXrefImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link SiteCatalogXrefImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteCatalogXrefImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName_givenSiteCatalogXrefImpl_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SiteCatalogXrefImpl()).getMainEntityName());
  }

  /**
   * Test new {@link SiteCatalogXrefImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link SiteCatalogXrefImpl}
   */
  @Test
  public void testNewSiteCatalogXrefImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    SiteCatalogXrefImpl actualSiteCatalogXrefImpl = new SiteCatalogXrefImpl();

    // Assert
    Catalog catalog = actualSiteCatalogXrefImpl.getCatalog();
    assertTrue(catalog instanceof CatalogImpl);
    Site site = actualSiteCatalogXrefImpl.getSite();
    assertTrue(site instanceof SiteImpl);
    ArchiveStatus archiveStatus = ((CatalogImpl) catalog).archiveStatus;
    assertEquals('N', archiveStatus.getArchived().charValue());
    assertEquals('N', catalog.getArchived().charValue());
    assertEquals('N', site.getArchived().charValue());
    assertNull(catalog.getId());
    assertNull(site.getId());
    assertNull(actualSiteCatalogXrefImpl.getId());
    assertNull(catalog.getName());
    assertNull(((CatalogImpl) catalog).getMainEntityName());
    assertNull(site.getName());
    assertNull(site.getSiteIdentifierType());
    assertNull(site.getSiteIdentifierValue());
    assertNull(actualSiteCatalogXrefImpl.getMainEntityName());
    assertNull(((SiteImpl) site).getMainEntityName());
    assertNull(((CatalogImpl) catalog).name);
    assertNull(((SiteImpl) site).name);
    assertNull(site.getDefaultLocale());
    assertNull(site.getSiteResolutionType());
    assertFalse(site.isTemplateSite());
    assertFalse(((SiteImpl) site).deactivated);
    assertTrue(catalog.getSiteXrefs().isEmpty());
    assertTrue(catalog.getSites().isEmpty());
    assertTrue(site.getCatalogs().isEmpty());
    assertTrue(((CatalogImpl) catalog).sites.isEmpty());
    assertEquals(archiveStatus, site.getArchiveStatus());
  }
}
