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
package org.broadleafcommerce.common.entity.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EntityInformationDtoDiffblueTest {
  /**
   * Test {@link EntityInformationDto#isProfileEntity()}.
   * <ul>
   *   <li>Given {@link EntityInformationDto} (default constructor) CatalogId is
   * one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationDto#isProfileEntity()}
   */
  @Test
  public void testIsProfileEntity_givenEntityInformationDtoCatalogIdIsOne_thenReturnTrue() {
    // Arrange
    EntityInformationDto entityInformationDto = new EntityInformationDto();
    entityInformationDto.setCatalogId(1L);
    entityInformationDto.setCatalogOwner(1L);
    entityInformationDto.setOwnerToCatalogRelationshipActive(true);
    entityInformationDto.setOwningSiteId(1L);
    entityInformationDto.setProfileId(1L);

    // Act and Assert
    assertTrue(entityInformationDto.isProfileEntity());
  }

  /**
   * Test {@link EntityInformationDto#isProfileEntity()}.
   * <ul>
   *   <li>Given {@link EntityInformationDto} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationDto#isProfileEntity()}
   */
  @Test
  public void testIsProfileEntity_givenEntityInformationDto_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityInformationDto()).isProfileEntity());
  }

  /**
   * Test {@link EntityInformationDto#isCatalogEntity()}.
   * <ul>
   *   <li>Given {@link EntityInformationDto} (default constructor) CatalogOwner is
   * one.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationDto#isCatalogEntity()}
   */
  @Test
  public void testIsCatalogEntity_givenEntityInformationDtoCatalogOwnerIsOne_thenReturnTrue() {
    // Arrange
    EntityInformationDto entityInformationDto = new EntityInformationDto();
    entityInformationDto.setCatalogOwner(1L);
    entityInformationDto.setOwnerToCatalogRelationshipActive(true);
    entityInformationDto.setOwningSiteId(1L);
    entityInformationDto.setProfileId(1L);
    entityInformationDto.setCatalogId(1L);

    // Act and Assert
    assertTrue(entityInformationDto.isCatalogEntity());
  }

  /**
   * Test {@link EntityInformationDto#isCatalogEntity()}.
   * <ul>
   *   <li>Given {@link EntityInformationDto} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInformationDto#isCatalogEntity()}
   */
  @Test
  public void testIsCatalogEntity_givenEntityInformationDto_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new EntityInformationDto()).isCatalogEntity());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityInformationDto}
   *   <li>{@link EntityInformationDto#setCatalogId(Long)}
   *   <li>{@link EntityInformationDto#setCatalogOwner(Long)}
   *   <li>{@link EntityInformationDto#setOwnerToCatalogRelationshipActive(Boolean)}
   *   <li>{@link EntityInformationDto#setOwningSiteId(Long)}
   *   <li>{@link EntityInformationDto#setProfileId(Long)}
   *   <li>{@link EntityInformationDto#getCatalogId()}
   *   <li>{@link EntityInformationDto#getCatalogOwner()}
   *   <li>{@link EntityInformationDto#getOwnerToCatalogRelationshipActive()}
   *   <li>{@link EntityInformationDto#getOwningSiteId()}
   *   <li>{@link EntityInformationDto#getProfileId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityInformationDto actualEntityInformationDto = new EntityInformationDto();
    actualEntityInformationDto.setCatalogId(1L);
    actualEntityInformationDto.setCatalogOwner(1L);
    actualEntityInformationDto.setOwnerToCatalogRelationshipActive(true);
    actualEntityInformationDto.setOwningSiteId(1L);
    actualEntityInformationDto.setProfileId(1L);
    Long actualCatalogId = actualEntityInformationDto.getCatalogId();
    Long actualCatalogOwner = actualEntityInformationDto.getCatalogOwner();
    Boolean actualOwnerToCatalogRelationshipActive = actualEntityInformationDto.getOwnerToCatalogRelationshipActive();
    Long actualOwningSiteId = actualEntityInformationDto.getOwningSiteId();
    Long actualProfileId = actualEntityInformationDto.getProfileId();

    // Assert that nothing has changed
    assertEquals(1L, actualCatalogId.longValue());
    assertEquals(1L, actualCatalogOwner.longValue());
    assertEquals(1L, actualOwningSiteId.longValue());
    assertEquals(1L, actualProfileId.longValue());
    assertTrue(actualOwnerToCatalogRelationshipActive);
  }
}
