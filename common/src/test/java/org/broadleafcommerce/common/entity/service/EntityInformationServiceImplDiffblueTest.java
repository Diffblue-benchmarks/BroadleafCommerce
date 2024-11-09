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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.entity.dto.EntityInformationDto;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class EntityInformationServiceImplDiffblueTest {
  /**
   * Test {@link EntityInformationServiceImpl#createEntityInformationDto(Object)}.
   * <p>
   * Method under test:
   * {@link EntityInformationServiceImpl#createEntityInformationDto(Object)}
   */
  @Test
  public void testCreateEntityInformationDto() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    EntityInformationDto actualCreateEntityInformationDtoResult = (new EntityInformationServiceImpl())
        .createEntityInformationDto(BLCFieldUtils.NULL_FIELD);

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
