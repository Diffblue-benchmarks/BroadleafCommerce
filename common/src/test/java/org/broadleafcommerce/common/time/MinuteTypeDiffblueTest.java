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
package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MinuteTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MinuteType minuteType = MinuteType.EIGHT;
    MinuteType minuteType2 = MinuteType.EIGHT;

    // Act and Assert
    assertEquals(minuteType, minuteType2);
    int expectedHashCodeResult = minuteType.hashCode();
    assertEquals(expectedHashCodeResult, minuteType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MinuteType minuteType = new MinuteType();
    MinuteType minuteType2 = new MinuteType();

    // Act and Assert
    assertEquals(minuteType, minuteType2);
    int expectedHashCodeResult = minuteType.hashCode();
    assertEquals(expectedHashCodeResult, minuteType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MinuteType#equals(Object)}
   *   <li>{@link MinuteType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MinuteType minuteType = MinuteType.EIGHT;

    // Act and Assert
    assertEquals(minuteType, minuteType);
    int expectedHashCodeResult = minuteType.hashCode();
    assertEquals(expectedHashCodeResult, minuteType.hashCode());
  }

  /**
   * Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHTEEN, MinuteType.EIGHT);
    assertNotEquals(new MinuteType(), MinuteType.EIGHT);
  }

  /**
   * Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHT, null);
  }

  /**
   * Method under test: {@link MinuteType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MinuteType.EIGHT, "Different type to MinuteType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MinuteType#MinuteType()}
   *   <li>{@link MinuteType#getFriendlyType()}
   *   <li>{@link MinuteType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MinuteType actualMinuteType = new MinuteType();
    String actualFriendlyType = actualMinuteType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualMinuteType.getType());
  }
}
