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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.broadleafcommerce.common.util.dao.DynamicDaoHelperImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityInformationServiceExtensionManager.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityInformationServiceExtensionManagerDiffblueTest {
  @Autowired
  private EntityInformationServiceExtensionManager entityInformationServiceExtensionManager;

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).updateEntityInformationDto(isA(EntityInformationDto.class),
        isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).updateEntityInformationDto(isA(EntityInformationDto.class),
        isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateEntityInformationDto_givenEntityInformationServiceExtensionManager() {
    // Arrange
    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Then calls {@link EntityInformationDto#setCatalogId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
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
    ExtensionResultStatusType actualUpdateEntityInformationDtoResult = entityInformationServiceExtensionManager
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
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto() {
    // Arrange
    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto3() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler)
        .updateBasicEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .updateBasicEntityInformationDto(Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler)
        .updateBasicEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto6() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    EntityInformationDto dto = new EntityInformationDto();
    dto.setCatalogId(1L);
    dto.setCatalogOwner(1L);
    dto.setOwnerToCatalogRelationshipActive(true);
    dto.setOwningSiteId(1L);
    dto.setProfileId(1L);

    // Act
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
        .updateBasicEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualUpdateBasicEntityInformationDtoResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>Then calls {@link EntityInformationDto#setCatalogId(Long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
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
    ExtensionResultStatusType actualUpdateBasicEntityInformationDtoResult = entityInformationServiceExtensionManager
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
   * Test {@link EntityInformationServiceExtensionManager#isEnabled()}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#isEnabled()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityInformationServiceExtensionManager.isEnabled()"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertTrue((new EntityInformationServiceExtensionManager()).isEnabled());
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getBaseProfileIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getBaseProfileIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getBaseProfileIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualBaseProfileIdForSite = entityInformationServiceExtensionManager
        .getBaseProfileIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualBaseProfileIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite_givenEntityInformationServiceExtensionManager() {
    // Arrange
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite_whenNull() {
    // Arrange
    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getBaseProfileIdForSite(null, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getParentSiteForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getParentSiteForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Site>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getParentSiteForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualParentSiteForProfile = entityInformationServiceExtensionManager
        .getParentSiteForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualParentSiteForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile_givenEntityInformationServiceExtensionManager() {
    // Arrange
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile_whenNull() {
    // Arrange
    ExtensionResultHolder<Site> erh = new ExtensionResultHolder<>();
    erh.setResult(new SiteImpl());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getParentSiteForProfile(null, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getOkayToUseSiteDiscriminator(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getOkayToUseSiteDiscriminator(Mockito.<Object>any(),
        Mockito.<ExtensionResultHolder<Boolean>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getOkayToUseSiteDiscriminator(isA(Object.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualOkayToUseSiteDiscriminator = entityInformationServiceExtensionManager
        .getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator_givenEntityInformationServiceExtensionManager() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link DynamicDaoHelperImpl#LOCK_OBJECT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator_whenLock_object() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(DynamicDaoHelperImpl.LOCK_OBJECT, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityInformationServiceExtensionManager.findAllCatalogs(erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityInformationServiceExtensionManager.findAllCatalogs(erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .findAllCatalogs(Mockito.<ExtensionResultHolder<List<Catalog>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).findAllCatalogs(isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler
        .findAllCatalogs(Mockito.<ExtensionResultHolder<List<Catalog>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).findAllCatalogs(isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);

    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs_givenEntityInformationServiceExtensionManager() {
    // Arrange
    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityInformationServiceExtensionManager.findAllCatalogs(erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <ul>
   *   <li>Then calls {@link ExtensionResultHolder#setResult(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs_thenCallsSetResult() {
    // Arrange
    ExtensionResultHolder<List<Catalog>> erh = mock(ExtensionResultHolder.class);
    doNothing().when(erh).setResult(Mockito.<List<Catalog>>any());
    doNothing().when(erh).setThrowable(Mockito.<Throwable>any());
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualFindAllCatalogsResult = entityInformationServiceExtensionManager
        .findAllCatalogs(erh);

    // Assert
    verify(erh).setResult(isA(List.class));
    verify(erh).setThrowable(isA(Throwable.class));
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualFindAllCatalogsResult);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getDefaultCatalogIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getDefaultCatalogIdForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Long>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getDefaultCatalogIdForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualDefaultCatalogIdForSite = entityInformationServiceExtensionManager
        .getDefaultCatalogIdForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualDefaultCatalogIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite_givenEntityInformationServiceExtensionManager() {
    // Arrange
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite_whenNull() {
    // Arrange
    ExtensionResultHolder<Long> erh = new ExtensionResultHolder<>();
    erh.setResult(1L);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(null, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Long>>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getChildSiteIdsForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getChildSiteIdsForProfile(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<Set<Long>>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getChildSiteIdsForProfile(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualChildSiteIdsForProfile = entityInformationServiceExtensionManager
        .getChildSiteIdsForProfile(profile, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualChildSiteIdsForProfile);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile_givenEntityInformationServiceExtensionManager() {
    // Arrange
    SiteImpl profile = new SiteImpl();

    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(profile, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile_whenNull() {
    // Arrange
    ExtensionResultHolder<Set<Long>> erh = new ExtensionResultHolder<>();
    erh.setResult(new HashSet<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getChildSiteIdsForProfile(null, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new AbstractEntityInformationServiceExtensionHandler());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite2() {
    // Arrange
    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(new EntityInformationServiceExtensionManager());
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite3() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getTypeForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getTypeForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTypeForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite4() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.getTypeForSite(Mockito.<Site>any(),
        Mockito.<ExtensionResultHolder<String>>any())).thenReturn(ExtensionResultStatusType.HANDLED_STOP);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(true);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).getTypeForSite(isA(Site.class),
        isA(ExtensionResultHolder.class));
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.HANDLED, actualTypeForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite5() {
    // Arrange
    AbstractEntityInformationServiceExtensionHandler abstractEntityInformationServiceExtensionHandler = mock(
        AbstractEntityInformationServiceExtensionHandler.class);
    when(abstractEntityInformationServiceExtensionHandler.isEnabled()).thenReturn(false);

    EntityInformationServiceExtensionManager entityInformationServiceExtensionManager = new EntityInformationServiceExtensionManager();
    entityInformationServiceExtensionManager.registerHandler(abstractEntityInformationServiceExtensionHandler);
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act
    ExtensionResultStatusType actualTypeForSite = entityInformationServiceExtensionManager.getTypeForSite(site, erh);

    // Assert
    verify(abstractEntityInformationServiceExtensionHandler).isEnabled();
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, actualTypeForSite);
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite_givenEntityInformationServiceExtensionManager() {
    // Arrange
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>Given {@link EntityInformationServiceExtensionManager}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite_givenEntityInformationServiceExtensionManager_whenNull() {
    // Arrange
    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(null, erh));
  }
}
