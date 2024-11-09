/*-
 * #%L
 * BroadleafCommerce Open Admin Platform
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
package org.broadleafcommerce.openadmin.server.security.service;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class EntityFormModifierConfigurationDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFormModifierConfiguration#EntityFormModifierConfiguration()}
   *   <li>{@link EntityFormModifierConfiguration#setData(List)}
   *   <li>{@link EntityFormModifierConfiguration#setModifier(List)}
   *   <li>{@link EntityFormModifierConfiguration#getData()}
   *   <li>{@link EntityFormModifierConfiguration#getModifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierConfiguration actualEntityFormModifierConfiguration = new EntityFormModifierConfiguration();
    ArrayList<EntityFormModifierData<EntityFormModifierDataPoint>> data = new ArrayList<>();
    actualEntityFormModifierConfiguration.setData(data);
    ArrayList<EntityFormModifier> modifier = new ArrayList<>();
    actualEntityFormModifierConfiguration.setModifier(modifier);
    List<EntityFormModifierData<EntityFormModifierDataPoint>> actualData = actualEntityFormModifierConfiguration
        .getData();
    List<EntityFormModifier> actualModifier = actualEntityFormModifierConfiguration.getModifier();

    // Assert that nothing has changed
    assertTrue(actualData.isEmpty());
    assertTrue(actualModifier.isEmpty());
    assertSame(data, actualData);
    assertSame(modifier, actualModifier);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityFormModifierConfiguration#EntityFormModifierConfiguration(List, List)}
   *   <li>{@link EntityFormModifierConfiguration#setData(List)}
   *   <li>{@link EntityFormModifierConfiguration#setModifier(List)}
   *   <li>{@link EntityFormModifierConfiguration#getData()}
   *   <li>{@link EntityFormModifierConfiguration#getModifier()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenArrayList() {
    // Arrange
    ArrayList<EntityFormModifier> modifier = new ArrayList<>();

    // Act
    EntityFormModifierConfiguration actualEntityFormModifierConfiguration = new EntityFormModifierConfiguration(
        modifier, new ArrayList<>());
    ArrayList<EntityFormModifierData<EntityFormModifierDataPoint>> data = new ArrayList<>();
    actualEntityFormModifierConfiguration.setData(data);
    ArrayList<EntityFormModifier> modifier2 = new ArrayList<>();
    actualEntityFormModifierConfiguration.setModifier(modifier2);
    List<EntityFormModifierData<EntityFormModifierDataPoint>> actualData = actualEntityFormModifierConfiguration
        .getData();
    List<EntityFormModifier> actualModifier = actualEntityFormModifierConfiguration.getModifier();

    // Assert that nothing has changed
    assertTrue(actualData.isEmpty());
    assertTrue(actualModifier.isEmpty());
    assertSame(data, actualData);
    assertSame(modifier2, actualModifier);
  }
}
