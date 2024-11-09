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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EntityFormModifierDataPointDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link EntityFormModifierDataPoint}
   *   <li>{@link EntityFormModifierDataPoint#setKey(Object)}
   *   <li>{@link EntityFormModifierDataPoint#setValue(Object)}
   *   <li>{@link EntityFormModifierDataPoint#getKey()}
   *   <li>{@link EntityFormModifierDataPoint#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityFormModifierDataPoint actualEntityFormModifierDataPoint = new EntityFormModifierDataPoint();
    actualEntityFormModifierDataPoint.setKey("Key");
    actualEntityFormModifierDataPoint.setValue("Value");
    Object actualKey = actualEntityFormModifierDataPoint.getKey();

    // Assert that nothing has changed
    assertEquals("Key", actualKey);
    assertEquals("Value", actualEntityFormModifierDataPoint.getValue());
  }
}
