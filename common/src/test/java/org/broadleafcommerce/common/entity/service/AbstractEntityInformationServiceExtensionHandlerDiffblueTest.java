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
package org.broadleafcommerce.common.entity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.entity.dto.EntityInformationDto;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.site.domain.Catalog;
import org.broadleafcommerce.common.site.domain.Site;
import org.broadleafcommerce.common.site.domain.SiteImpl;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractEntityInformationServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractEntityInformationServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler;

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto() {
    // Arrange
    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto() {
    // Arrange
    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getTypeForSite(site, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test {@link AbstractEntityInformationServiceExtensionHandler#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link AbstractEntityInformationServiceExtensionHandler#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType AbstractEntityInformationServiceExtensionHandler.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.findAllCatalogs(erh));
  }

  /**
   * Test new {@link AbstractEntityInformationServiceExtensionHandler} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link AbstractEntityInformationServiceExtensionHandler}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractEntityInformationServiceExtensionHandler.<init>()"})
  public void testNewAbstractEntityInformationServiceExtensionHandler() {
    // Arrange and Act
    AbstractEntityInformationServiceExtensionHandler actualAbstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractEntityInformationServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractEntityInformationServiceExtensionHandler.isEnabled());
  }
}
