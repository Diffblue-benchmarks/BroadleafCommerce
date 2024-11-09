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
package org.broadleafcommerce.openadmin.server.security.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PermissionTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#PermissionType()}
   *   <li>{@link PermissionType#getFriendlyType()}
   *   <li>{@link PermissionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PermissionType actualPermissionType = new PermissionType();
    String actualFriendlyType = actualPermissionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPermissionType.getType());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;
    PermissionType permissionType2 = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PermissionType permissionType = new PermissionType();
    PermissionType permissionType2 = new PermissionType();

    // Act and Assert
    assertEquals(permissionType, permissionType2);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType2.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}, and
   * {@link PermissionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PermissionType#equals(Object)}
   *   <li>{@link PermissionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PermissionType permissionType = PermissionType.ALL;

    // Act and Assert
    assertEquals(permissionType, permissionType);
    int expectedHashCodeResult = permissionType.hashCode();
    assertEquals(expectedHashCodeResult, permissionType.hashCode());
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.CREATE, PermissionType.ALL);
    assertNotEquals(new PermissionType(), PermissionType.ALL);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, null);
  }

  /**
   * Test {@link PermissionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PermissionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PermissionType.ALL, "Different type to PermissionType");
  }
}
