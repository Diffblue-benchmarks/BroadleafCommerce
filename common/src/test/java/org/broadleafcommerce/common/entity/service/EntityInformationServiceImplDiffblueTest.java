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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {EntityInformationServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityInformationServiceImplDiffblueTest {
  @MockBean(name = "blEntityInformationServiceExtensionManager")
  private EntityInformationServiceExtensionManager entityInformationServiceExtensionManager;

  @Autowired private EntityInformationServiceImpl entityInformationServiceImpl;

  /**
   * Test {@link EntityInformationServiceImpl#buildEntityInformationForObject(Object)}.
   *
   * <p>Method under test: {@link
   * EntityInformationServiceImpl#buildEntityInformationForObject(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInformationDto EntityInformationServiceImpl.buildEntityInformationForObject(Object)"
  })
  public void testBuildEntityInformationForObject() {
    // Arrange
    when(entityInformationServiceExtensionManager.updateEntityInformationDto(
            Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    EntityInformationDto actualBuildEntityInformationForObjectResult =
        entityInformationServiceImpl.buildEntityInformationForObject(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityInformationServiceExtensionManager)
        .updateEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    assertNull(actualBuildEntityInformationForObjectResult.getOwnerToCatalogRelationshipActive());
    assertNull(actualBuildEntityInformationForObjectResult.getCatalogId());
    assertNull(actualBuildEntityInformationForObjectResult.getCatalogOwner());
    assertNull(actualBuildEntityInformationForObjectResult.getOwningSiteId());
    assertNull(actualBuildEntityInformationForObjectResult.getProfileId());
    assertFalse(actualBuildEntityInformationForObjectResult.isCatalogEntity());
    assertFalse(actualBuildEntityInformationForObjectResult.isProfileEntity());
  }

  /**
   * Test {@link EntityInformationServiceImpl#buildBasicEntityInformationForObject(Object)}.
   *
   * <p>Method under test: {@link
   * EntityInformationServiceImpl#buildBasicEntityInformationForObject(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInformationDto EntityInformationServiceImpl.buildBasicEntityInformationForObject(Object)"
  })
  public void testBuildBasicEntityInformationForObject() {
    // Arrange
    when(entityInformationServiceExtensionManager.updateBasicEntityInformationDto(
            Mockito.<EntityInformationDto>any(), Mockito.<Object>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    EntityInformationDto actualBuildBasicEntityInformationForObjectResult =
        entityInformationServiceImpl.buildBasicEntityInformationForObject(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityInformationServiceExtensionManager)
        .updateBasicEntityInformationDto(isA(EntityInformationDto.class), isA(Object.class));
    assertNull(
        actualBuildBasicEntityInformationForObjectResult.getOwnerToCatalogRelationshipActive());
    assertNull(actualBuildBasicEntityInformationForObjectResult.getCatalogId());
    assertNull(actualBuildBasicEntityInformationForObjectResult.getCatalogOwner());
    assertNull(actualBuildBasicEntityInformationForObjectResult.getOwningSiteId());
    assertNull(actualBuildBasicEntityInformationForObjectResult.getProfileId());
    assertFalse(actualBuildBasicEntityInformationForObjectResult.isCatalogEntity());
    assertFalse(actualBuildBasicEntityInformationForObjectResult.isProfileEntity());
  }

  /**
   * Test {@link EntityInformationServiceImpl#getBaseProfileIdForSite(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getBaseProfileIdForSite(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long EntityInformationServiceImpl.getBaseProfileIdForSite(Site)"})
  public void testGetBaseProfileIdForSite() {
    // Arrange
    when(entityInformationServiceExtensionManager.getBaseProfileIdForSite(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    Long actualBaseProfileIdForSite =
        entityInformationServiceImpl.getBaseProfileIdForSite(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager)
        .getBaseProfileIdForSite(isA(Site.class), isA(ExtensionResultHolder.class));
    assertNull(actualBaseProfileIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getTypeForSite(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getTypeForSite(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityInformationServiceImpl.getTypeForSite(Site)"})
  public void testGetTypeForSite() {
    // Arrange
    when(entityInformationServiceExtensionManager.getTypeForSite(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<String>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    String actualTypeForSite = entityInformationServiceImpl.getTypeForSite(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager)
        .getTypeForSite(isA(Site.class), isA(ExtensionResultHolder.class));
    assertNull(actualTypeForSite);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getChildSiteIdsForProfile(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getChildSiteIdsForProfile(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityInformationServiceImpl.getChildSiteIdsForProfile(Site)"})
  public void testGetChildSiteIdsForProfile() {
    // Arrange
    when(entityInformationServiceExtensionManager.getProxy())
        .thenReturn(new AbstractEntityInformationServiceExtensionHandler());

    // Act
    Set<Long> actualChildSiteIdsForProfile =
        entityInformationServiceImpl.getChildSiteIdsForProfile(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager).getProxy();
    assertNull(actualChildSiteIdsForProfile);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getChildSiteIdsForProfile(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getChildSiteIdsForProfile(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Set EntityInformationServiceImpl.getChildSiteIdsForProfile(Site)"})
  public void testGetChildSiteIdsForProfile2() {
    // Arrange
    when(entityInformationServiceExtensionManager.getProxy())
        .thenReturn(new EntityInformationServiceExtensionManager());

    // Act
    Set<Long> actualChildSiteIdsForProfile =
        entityInformationServiceImpl.getChildSiteIdsForProfile(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager).getProxy();
    assertNull(actualChildSiteIdsForProfile);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getParentSiteForProfile(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getParentSiteForProfile(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Site EntityInformationServiceImpl.getParentSiteForProfile(Site)"})
  public void testGetParentSiteForProfile() {
    // Arrange
    when(entityInformationServiceExtensionManager.getParentSiteForProfile(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Site>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    Site actualParentSiteForProfile =
        entityInformationServiceImpl.getParentSiteForProfile(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager)
        .getParentSiteForProfile(isA(Site.class), isA(ExtensionResultHolder.class));
    assertNull(actualParentSiteForProfile);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getOkayToUseSiteDiscriminator(Object)}.
   *
   * <p>Method under test: {@link
   * EntityInformationServiceImpl#getOkayToUseSiteDiscriminator(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityInformationServiceImpl.getOkayToUseSiteDiscriminator(Object)"})
  public void testGetOkayToUseSiteDiscriminator() {
    // Arrange
    when(entityInformationServiceExtensionManager.getOkayToUseSiteDiscriminator(
            Mockito.<Object>any(), Mockito.<ExtensionResultHolder<Boolean>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    boolean actualOkayToUseSiteDiscriminator =
        entityInformationServiceImpl.getOkayToUseSiteDiscriminator(BLCFieldUtils.NULL_FIELD);

    // Assert
    verify(entityInformationServiceExtensionManager)
        .getOkayToUseSiteDiscriminator(isA(Object.class), isA(ExtensionResultHolder.class));
    assertFalse(actualOkayToUseSiteDiscriminator);
  }

  /**
   * Test {@link EntityInformationServiceImpl#getDefaultCatalogIdForSite(Site)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#getDefaultCatalogIdForSite(Site)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long EntityInformationServiceImpl.getDefaultCatalogIdForSite(Site)"})
  public void testGetDefaultCatalogIdForSite() {
    // Arrange
    when(entityInformationServiceExtensionManager.getDefaultCatalogIdForSite(
            Mockito.<Site>any(), Mockito.<ExtensionResultHolder<Long>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    Long actualDefaultCatalogIdForSite =
        entityInformationServiceImpl.getDefaultCatalogIdForSite(new SiteImpl());

    // Assert
    verify(entityInformationServiceExtensionManager)
        .getDefaultCatalogIdForSite(isA(Site.class), isA(ExtensionResultHolder.class));
    assertNull(actualDefaultCatalogIdForSite);
  }

  /**
   * Test {@link EntityInformationServiceImpl#findAllCatalogs()}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#findAllCatalogs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List EntityInformationServiceImpl.findAllCatalogs()"})
  public void testFindAllCatalogs() {
    // Arrange
    when(entityInformationServiceExtensionManager.findAllCatalogs(
            Mockito.<ExtensionResultHolder<List<Catalog>>>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);

    // Act
    List<Catalog> actualFindAllCatalogsResult = entityInformationServiceImpl.findAllCatalogs();

    // Assert
    verify(entityInformationServiceExtensionManager)
        .findAllCatalogs(isA(ExtensionResultHolder.class));
    assertNull(actualFindAllCatalogsResult);
  }

  /**
   * Test {@link EntityInformationServiceImpl#createEntityInformationDto(Object)}.
   *
   * <p>Method under test: {@link EntityInformationServiceImpl#createEntityInformationDto(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityInformationDto EntityInformationServiceImpl.createEntityInformationDto(Object)"
  })
  public void testCreateEntityInformationDto() {
    // Arrange and Act
    EntityInformationDto actualCreateEntityInformationDtoResult =
        entityInformationServiceImpl.createEntityInformationDto(BLCFieldUtils.NULL_FIELD);

    // Assert
    assertNull(actualCreateEntityInformationDtoResult.getOwnerToCatalogRelationshipActive());
    assertNull(actualCreateEntityInformationDtoResult.getCatalogId());
    assertNull(actualCreateEntityInformationDtoResult.getCatalogOwner());
    assertNull(actualCreateEntityInformationDtoResult.getOwningSiteId());
    assertNull(actualCreateEntityInformationDtoResult.getProfileId());
    assertFalse(actualCreateEntityInformationDtoResult.isCatalogEntity());
    assertFalse(actualCreateEntityInformationDtoResult.isProfileEntity());
  }
}
