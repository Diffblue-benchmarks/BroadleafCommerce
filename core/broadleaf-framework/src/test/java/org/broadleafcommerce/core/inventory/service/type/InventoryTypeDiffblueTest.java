/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.inventory.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class InventoryTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#InventoryType()}
   *   <li>{@link InventoryType#getFriendlyType()}
   *   <li>{@link InventoryType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    InventoryType actualInventoryType = new InventoryType();
    String actualFriendlyType = actualInventoryType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualInventoryType.getType());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;
    InventoryType inventoryType2 = InventoryType.ALWAYS_AVAILABLE;

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InventoryType inventoryType = new InventoryType();
    InventoryType inventoryType2 = new InventoryType();

    // Act and Assert
    assertEquals(inventoryType, inventoryType2);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType2.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}, and
   * {@link InventoryType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link InventoryType#equals(Object)}
   *   <li>{@link InventoryType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InventoryType inventoryType = InventoryType.ALWAYS_AVAILABLE;

    // Act and Assert
    assertEquals(inventoryType, inventoryType);
    int expectedHashCodeResult = inventoryType.hashCode();
    assertEquals(expectedHashCodeResult, inventoryType.hashCode());
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.CHECK_QUANTITY, InventoryType.ALWAYS_AVAILABLE);
    assertNotEquals(new InventoryType(), InventoryType.ALWAYS_AVAILABLE);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, null);
  }

  /**
   * Test {@link InventoryType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link InventoryType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InventoryType.ALWAYS_AVAILABLE, "Different type to InventoryType");
  }
}
