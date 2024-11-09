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
package org.broadleafcommerce.common.vendor.service.type;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.broadleafcommerce.common.util.BLCFieldUtils;
import org.junit.Test;

public class ContainerShapeTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ContainerShapeType#ContainerShapeType()}
   *   <li>{@link ContainerShapeType#getFriendlyType()}
   *   <li>{@link ContainerShapeType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ContainerShapeType actualContainerShapeType = new ContainerShapeType();
    String actualFriendlyType = actualContainerShapeType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualContainerShapeType.getType());
  }

  /**
   * Test {@link ContainerShapeType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ContainerShapeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ContainerShapeType(), BLCFieldUtils.NULL_FIELD);
  }
}
