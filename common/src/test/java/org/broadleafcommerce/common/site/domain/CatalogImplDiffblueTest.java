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
package org.broadleafcommerce.common.site.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CatalogImplDiffblueTest {
  /**
   * Method under test: {@link CatalogImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogImpl()).getName());
  }

  /**
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogImpl()).getSites().isEmpty());
  }

  /**
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<SiteCatalogXref> siteXrefs = new ArrayList<>();
    siteXrefs.add(new SiteCatalogXrefImpl());

    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    ArrayList<Site> sites = new ArrayList<>();
    catalogImpl.setSites(sites);
    catalogImpl.setSiteXrefs(siteXrefs);

    // Act and Assert
    assertEquals(sites, catalogImpl.getSites());
  }

  /**
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Site> sites = new ArrayList<>();
    sites.add(new SiteImpl());

    ArrayList<SiteCatalogXref> siteXrefs = new ArrayList<>();
    siteXrefs.add(new SiteCatalogXrefImpl());

    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSites(sites);
    catalogImpl.setSiteXrefs(siteXrefs);

    // Act and Assert
    assertEquals(sites, catalogImpl.getSites());
  }

  /**
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SiteCatalogXrefImpl siteCatalogXrefImpl = mock(SiteCatalogXrefImpl.class);
    when(siteCatalogXrefImpl.getSite()).thenReturn(new SiteImpl());

    ArrayList<SiteCatalogXref> siteXrefs = new ArrayList<>();
    siteXrefs.add(siteCatalogXrefImpl);

    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    ArrayList<Site> sites = new ArrayList<>();
    catalogImpl.setSites(sites);
    catalogImpl.setSiteXrefs(siteXrefs);

    // Act
    List<Site> actualSites = catalogImpl.getSites();

    // Assert
    verify(siteCatalogXrefImpl).getSite();
    assertEquals(sites, actualSites);
  }

  /**
   * Method under test: {@link CatalogImpl#clone()}
   */
  @Test
  public void testClone() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();

    // Act
    Catalog actualCloneResult = catalogImpl.clone();

    // Assert
    assertTrue(actualCloneResult instanceof CatalogImpl);
    assertEquals(catalogImpl, actualCloneResult);
  }

  /**
   * Method under test: {@link CatalogImpl#compareTo(Catalog)}
   */
  @Test
  public void testCompareTo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setName("Name");
    Catalog other = mock(Catalog.class);
    when(other.getName()).thenReturn("Name");

    // Act
    int actualCompareToResult = catalogImpl.compareTo(other);

    // Assert
    verify(other).getName();
    assertEquals(0, actualCompareToResult);
  }

  /**
   * Method under test: {@link CatalogImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogImpl()).getMainEntityName());
  }

  /**
   * Method under test: {@link CatalogImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new CatalogImpl()).getArchived().charValue());
  }

  /**
   * Method under test: {@link CatalogImpl#setArchived(Character)}
   */
  @Test
  public void testSetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();

    // Act
    catalogImpl.setArchived('A');

    // Assert
    assertEquals('A', catalogImpl.archiveStatus.getArchived().charValue());
    assertEquals('A', catalogImpl.getArchived().charValue());
  }

  /**
   * Method under test: {@link CatalogImpl#isActive()}
   */
  @Test
  public void testIsActive() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogImpl()).isActive());
  }

  /**
   * Method under test: {@link CatalogImpl#isActive()}
   */
  @Test
  public void testIsActive2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setArchived('Y');

    // Act and Assert
    assertFalse(catalogImpl.isActive());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogImpl#equals(Object)}
   *   <li>{@link CatalogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(1L);
    catalogImpl2.setName("Name");
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertEquals(catalogImpl, catalogImpl2);
    int expectedHashCodeResult = catalogImpl.hashCode();
    assertEquals(expectedHashCodeResult, catalogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogImpl#equals(Object)}
   *   <li>{@link CatalogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(null);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(null);
    catalogImpl2.setName("Name");
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertEquals(catalogImpl, catalogImpl2);
    int expectedHashCodeResult = catalogImpl.hashCode();
    assertEquals(expectedHashCodeResult, catalogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogImpl#equals(Object)}
   *   <li>{@link CatalogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName(null);
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(1L);
    catalogImpl2.setName(null);
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertEquals(catalogImpl, catalogImpl2);
    int expectedHashCodeResult = catalogImpl.hashCode();
    assertEquals(expectedHashCodeResult, catalogImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogImpl#equals(Object)}
   *   <li>{@link CatalogImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    // Act and Assert
    assertEquals(catalogImpl, catalogImpl);
    int expectedHashCodeResult = catalogImpl.hashCode();
    assertEquals(expectedHashCodeResult, catalogImpl.hashCode());
  }

  /**
   * Method under test: {@link CatalogImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(2L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(1L);
    catalogImpl2.setName("Name");
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(catalogImpl, catalogImpl2);
  }

  /**
   * Method under test: {@link CatalogImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(null);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(1L);
    catalogImpl2.setName("Name");
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(catalogImpl, catalogImpl2);
  }

  /**
   * Method under test: {@link CatalogImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName(null);
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    CatalogImpl catalogImpl2 = new CatalogImpl();
    catalogImpl2.setId(1L);
    catalogImpl2.setName("Name");
    catalogImpl2.setSiteXrefs(new ArrayList<>());
    catalogImpl2.setSites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(catalogImpl, catalogImpl2);
  }

  /**
   * Method under test: {@link CatalogImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(catalogImpl, null);
  }

  /**
   * Method under test: {@link CatalogImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    catalogImpl.setSiteXrefs(new ArrayList<>());
    catalogImpl.setSites(new ArrayList<>());

    // Act and Assert
    assertNotEquals(catalogImpl, "Different type to CatalogImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CatalogImpl#setId(Long)}
   *   <li>{@link CatalogImpl#setName(String)}
   *   <li>{@link CatalogImpl#setSiteXrefs(List)}
   *   <li>{@link CatalogImpl#setSites(List)}
   *   <li>{@link CatalogImpl#getId()}
   *   <li>{@link CatalogImpl#getSiteXrefs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();

    // Act
    catalogImpl.setId(1L);
    catalogImpl.setName("Name");
    ArrayList<SiteCatalogXref> siteXrefs = new ArrayList<>();
    catalogImpl.setSiteXrefs(siteXrefs);
    catalogImpl.setSites(new ArrayList<>());
    Long actualId = catalogImpl.getId();
    List<SiteCatalogXref> actualSiteXrefs = catalogImpl.getSiteXrefs();

    // Assert that nothing has changed
    assertEquals(1L, actualId.longValue());
    assertTrue(actualSiteXrefs.isEmpty());
    assertSame(siteXrefs, actualSiteXrefs);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link CatalogImpl}
   */
  @Test
  public void testNewCatalogImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    CatalogImpl actualCatalogImpl = new CatalogImpl();

    // Assert
    assertEquals('N', actualCatalogImpl.archiveStatus.getArchived().charValue());
    assertEquals('N', actualCatalogImpl.getArchived().charValue());
    assertNull(actualCatalogImpl.getId());
    assertNull(actualCatalogImpl.getMainEntityName());
    assertNull(actualCatalogImpl.getName());
    assertNull(actualCatalogImpl.name);
    assertTrue(actualCatalogImpl.getSiteXrefs().isEmpty());
    assertTrue(actualCatalogImpl.getSites().isEmpty());
    assertTrue(actualCatalogImpl.sites.isEmpty());
  }
}
