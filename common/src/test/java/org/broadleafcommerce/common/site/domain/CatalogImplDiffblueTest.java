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
   * Test getters and setters.
   * <p>
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
   * Test {@link CatalogImpl#getName()}.
   * <p>
   * Method under test: {@link CatalogImpl#getName()}
   */
  @Test
  public void testGetName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogImpl()).getName());
  }

  /**
   * Test {@link CatalogImpl#getSites()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteCatalogXrefImpl}
   * (default constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites_givenArrayListAddSiteCatalogXrefImpl_thenReturnArrayList() {
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
   * Test {@link CatalogImpl#getSites()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteImpl} (default
   * constructor).</li>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites_givenArrayListAddSiteImpl_thenReturnArrayList() {
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
   * Test {@link CatalogImpl#getSites()}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor).</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites_givenCatalogImpl_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogImpl()).getSites().isEmpty());
  }

  /**
   * Test {@link CatalogImpl#getSites()}.
   * <ul>
   *   <li>Given {@link SiteCatalogXrefImpl} {@link SiteCatalogXrefImpl#getSite()}
   * return {@link SiteImpl} (default constructor).</li>
   *   <li>Then calls {@link SiteCatalogXrefImpl#getSite()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#getSites()}
   */
  @Test
  public void testGetSites_givenSiteCatalogXrefImplGetSiteReturnSiteImpl_thenCallsGetSite() {
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
   * Test {@link CatalogImpl#clone()}.
   * <p>
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
   * Test {@link CatalogImpl#compareTo(Catalog)} with {@code Catalog}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor) Name is
   * {@code Name}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#compareTo(Catalog)}
   */
  @Test
  public void testCompareToWithCatalog_givenCatalogImplNameIsName_thenReturnZero() {
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
   * Test {@link CatalogImpl#getMainEntityName()}.
   * <p>
   * Method under test: {@link CatalogImpl#getMainEntityName()}
   */
  @Test
  public void testGetMainEntityName() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new CatalogImpl()).getMainEntityName());
  }

  /**
   * Test {@link CatalogImpl#getArchived()}.
   * <p>
   * Method under test: {@link CatalogImpl#getArchived()}
   */
  @Test
  public void testGetArchived() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertEquals('N', (new CatalogImpl()).getArchived().charValue());
  }

  /**
   * Test {@link CatalogImpl#setArchived(Character)}.
   * <p>
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
   * Test {@link CatalogImpl#isActive()}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor) Archived is
   * {@code Y}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#isActive()}
   */
  @Test
  public void testIsActive_givenCatalogImplArchivedIsY_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CatalogImpl catalogImpl = new CatalogImpl();
    catalogImpl.setArchived('Y');

    // Act and Assert
    assertFalse(catalogImpl.isActive());
  }

  /**
   * Test {@link CatalogImpl#isActive()}.
   * <ul>
   *   <li>Given {@link CatalogImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CatalogImpl#isActive()}
   */
  @Test
  public void testIsActive_givenCatalogImpl_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new CatalogImpl()).isActive());
  }

  /**
   * Test {@link CatalogImpl#equals(Object)}, and {@link CatalogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}, and {@link CatalogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}, and {@link CatalogImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}, and {@link CatalogImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link CatalogImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test new {@link CatalogImpl} (default constructor).
   * <p>
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
