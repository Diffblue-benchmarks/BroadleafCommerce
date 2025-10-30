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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-common-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class SiteCatalogXrefImplDiffblueTest {
  @Autowired
  private SiteCatalogXrefImpl siteCatalogXrefImpl;

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Catalog SiteCatalogXrefImpl.getCatalog()", "Long SiteCatalogXrefImpl.getId()",
      "Site SiteCatalogXrefImpl.getSite()", "void SiteCatalogXrefImpl.setCatalog(Catalog)",
      "void SiteCatalogXrefImpl.setId(Long)", "void SiteCatalogXrefImpl.setSite(Site)"})
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

    // Assert
    assertEquals(1L, actualId.longValue());
    assertSame(catalog, actualCatalog);
    assertSame(site, actualSite);
  }

  /**
   * Test {@link SiteCatalogXrefImpl#getMainEntityName()}.
   * <ul>
   *   <li>Given {@link CatalogImpl} {@link CatalogImpl#getName()} return {@code Name}.</li>
   *   <li>Then return {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SiteCatalogXrefImpl#getMainEntityName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteCatalogXrefImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenCatalogImplGetNameReturnName_thenReturnName() {
    // Arrange
    CatalogImpl catalog = mock(CatalogImpl.class);
    when(catalog.getName()).thenReturn("Name");

    SiteCatalogXrefImpl siteCatalogXrefImpl2 = new SiteCatalogXrefImpl();
    siteCatalogXrefImpl2.setCatalog(catalog);

    // Act
    String actualMainEntityName = siteCatalogXrefImpl2.getMainEntityName();

    // Assert
    verify(catalog).getName();
    assertEquals("Name", actualMainEntityName);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SiteCatalogXrefImpl.getMainEntityName()"})
  public void testGetMainEntityName_givenSiteCatalogXrefImpl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new SiteCatalogXrefImpl()).getMainEntityName());
  }

  /**
   * Test new {@link SiteCatalogXrefImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link SiteCatalogXrefImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SiteCatalogXrefImpl.<init>()"})
  public void testNewSiteCatalogXrefImpl() {
    // Arrange and Act
    SiteCatalogXrefImpl actualSiteCatalogXrefImpl = new SiteCatalogXrefImpl();

    // Assert
    assertTrue(actualSiteCatalogXrefImpl.getCatalog() instanceof CatalogImpl);
    assertTrue(actualSiteCatalogXrefImpl.getSite() instanceof SiteImpl);
    assertNull(actualSiteCatalogXrefImpl.getId());
    assertNull(actualSiteCatalogXrefImpl.getMainEntityName());
  }
}
