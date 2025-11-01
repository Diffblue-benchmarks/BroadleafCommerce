/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

public class EntityFormModifierDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData()}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>();
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData(int)}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>(
        1);
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierData#EntityFormModifierData(Collection)}
   *   <li>{@link EntityFormModifierData#setModifierType(String)}
   *   <li>{@link EntityFormModifierData#getModifierType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters3() {
    // Arrange and Act
    EntityFormModifierData<EntityFormModifierDataPoint> actualEntityFormModifierDataPointList = new EntityFormModifierData<>(
        new ArrayList<>());
    actualEntityFormModifierDataPointList.setModifierType("Modifier Type");

    // Assert that nothing has changed
    assertEquals("Modifier Type", actualEntityFormModifierDataPointList.getModifierType());
  }
}
