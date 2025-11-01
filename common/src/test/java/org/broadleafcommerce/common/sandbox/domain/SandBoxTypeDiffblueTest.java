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
package org.broadleafcommerce.common.sandbox.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SandBoxTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SandBoxType sandBoxType = SandBoxType.APPROVAL;
    SandBoxType sandBoxType2 = SandBoxType.APPROVAL;

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType2);
    int expectedHashCodeResult = sandBoxType.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SandBoxType sandBoxType = new SandBoxType();
    SandBoxType sandBoxType2 = new SandBoxType();

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType2);
    int expectedHashCodeResult = sandBoxType.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxType#equals(Object)}
   *   <li>{@link SandBoxType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SandBoxType sandBoxType = SandBoxType.APPROVAL;

    // Act and Assert
    assertEquals(sandBoxType, sandBoxType);
    int expectedHashCodeResult = sandBoxType.hashCode();
    assertEquals(expectedHashCodeResult, sandBoxType.hashCode());
  }

  /**
   * Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.DEFAULT, SandBoxType.APPROVAL);
    assertNotEquals(new SandBoxType(), SandBoxType.APPROVAL);
  }

  /**
   * Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.APPROVAL, null);
  }

  /**
   * Method under test: {@link SandBoxType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SandBoxType.APPROVAL, "Different type to SandBoxType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SandBoxType#SandBoxType()}
   *   <li>{@link SandBoxType#getFriendlyType()}
   *   <li>{@link SandBoxType#getPriority()}
   *   <li>{@link SandBoxType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SandBoxType actualSandBoxType = new SandBoxType();
    String actualFriendlyType = actualSandBoxType.getFriendlyType();
    Integer actualPriority = actualSandBoxType.getPriority();

    // Assert
    assertNull(actualPriority);
    assertNull(actualFriendlyType);
    assertNull(actualSandBoxType.getType());
  }
}
