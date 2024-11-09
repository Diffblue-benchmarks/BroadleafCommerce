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
package org.broadleafcommerce.common.entity.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AbstractEntityInformationServiceExtensionHandler.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractEntityInformationServiceExtensionHandlerDiffblueTest {
  @Autowired
  private AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler;

  /**
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Then calls {@link EntityInformationDto#setCatalogId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto_thenCallsSetCatalogId() {
    // Arrange
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = abstractEntityInformationServiceExtensionHandler
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateEntityInformationDto_whenEntityInformationDtoCatalogIdIsOne() {
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Then calls {@link EntityInformationDto#setCatalogId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto_thenCallsSetCatalogId() {
    // Arrange
    EntityInformationDto dto = mock(EntityInformationDto.class);
    doNothing().when(dto).setCatalogId(Mockito.<Long>any());
    doNothing().when(dto).setCatalogOwner(Mockito.<Long>any());
    doNothing().when(dto).setOwnerToCatalogRelationshipActive(Mockito.<Boolean>any());
    doNothing().when(dto).setOwningSiteId(Mockito.<Long>any());
    doNothing().when(dto).setProfileId(Mockito.<Long>any());
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(dto).setCatalogId(eq(1L));
    verify(dto).setCatalogOwner(eq(1L));
    verify(dto).setOwnerToCatalogRelationshipActive(eq(true));
    verify(dto).setOwningSiteId(eq(1L));
    verify(dto).setProfileId(eq(1L));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  public void testUpdateBasicEntityInformationDto_whenEntityInformationDtoCatalogIdIsOne() {
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator_thenCallsSetResult() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<Boolean>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = abstractEntityInformationServiceExtensionHandler
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(erh).setResult(eq(true));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  public void testGetOkayToUseSiteDiscriminator_whenExtensionResultHolderResultIsTrue() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
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
   * Test
   * {@link AbstractEntityInformationServiceExtensionHandler#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test:
   * {@link AbstractEntityInformationServiceExtensionHandler#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
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
   * Test new {@link AbstractEntityInformationServiceExtensionHandler} (default
   * constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AbstractEntityInformationServiceExtensionHandler}
   */
  @Test
  public void testNewAbstractEntityInformationServiceExtensionHandler() {
    // Arrange and Act
    AbstractEntityInformationServiceExtensionHandler actualAbstractEntityInformationServiceExtensionHandler = new AbstractEntityInformationServiceExtensionHandler();

    // Assert
    assertEquals(0, actualAbstractEntityInformationServiceExtensionHandler.getPriority());
    assertTrue(actualAbstractEntityInformationServiceExtensionHandler.isEnabled());
  }
}
