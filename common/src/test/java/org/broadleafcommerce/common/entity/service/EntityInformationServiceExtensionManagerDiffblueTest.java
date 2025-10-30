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
   * Test {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateEntityInformationDto(EntityInformationDto, Object)"})
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
        entityInformationServiceExtensionManager.updateEntityInformationDto(dto, BLCFieldUtils.NULL_FIELD));
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
   * Test {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}.
   * <ul>
   *   <li>When {@link EntityInformationDto} (default constructor) CatalogId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#updateBasicEntityInformationDto(EntityInformationDto, Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.updateBasicEntityInformationDto(EntityInformationDto, Object)"})
  public void testUpdateBasicEntityInformationDto_whenEntityInformationDtoCatalogIdIsOne() {
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
   * Test {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getBaseProfileIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getBaseProfileIdForSite(Site, ExtensionResultHolder)"})
  public void testGetBaseProfileIdForSite_whenSiteImpl() {
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
   * Test {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getParentSiteForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getParentSiteForProfile(Site, ExtensionResultHolder)"})
  public void testGetParentSiteForProfile_whenSiteImpl() {
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
   * Test {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link BLCFieldUtils#NULL_FIELD}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(Object, ExtensionResultHolder)"})
  public void testGetOkayToUseSiteDiscriminator_whenNull_field() {
    // Arrange
    ExtensionResultHolder<Boolean> erh = new ExtensionResultHolder<>();
    erh.setResult(true);
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD, erh));
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
   * Test {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link ExtensionResultHolder} (default constructor) Result is {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#findAllCatalogs(ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.findAllCatalogs(ExtensionResultHolder)"})
  public void testFindAllCatalogs_whenExtensionResultHolderResultIsArrayList() {
    // Arrange
    ExtensionResultHolder<List<Catalog>> erh = new ExtensionResultHolder<>();
    erh.setResult(new ArrayList<>());
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED, entityInformationServiceExtensionManager.findAllCatalogs(erh));
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
   * Test {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getDefaultCatalogIdForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getDefaultCatalogIdForSite(Site, ExtensionResultHolder)"})
  public void testGetDefaultCatalogIdForSite_whenSiteImpl() {
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
   * Test {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getChildSiteIdsForProfile(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getChildSiteIdsForProfile(Site, ExtensionResultHolder)"})
  public void testGetChildSiteIdsForProfile_whenSiteImpl() {
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
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite_whenNull() {
    // Arrange
    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(null, erh));
  }

  /**
   * Test {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}.
   * <ul>
   *   <li>When {@link SiteImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationServiceExtensionManager#getTypeForSite(Site, ExtensionResultHolder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "ExtensionResultStatusType EntityInformationServiceExtensionManager.getTypeForSite(Site, ExtensionResultHolder)"})
  public void testGetTypeForSite_whenSiteImpl() {
    // Arrange
    SiteImpl site = new SiteImpl();

    ExtensionResultHolder<String> erh = new ExtensionResultHolder<>();
    erh.setResult("Result");
    erh.setThrowable(new Throwable());

    // Act and Assert
    assertEquals(ExtensionResultStatusType.NOT_HANDLED,
        entityInformationServiceExtensionManager.getTypeForSite(site, erh));
  }
}
