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

public class DayOfMonthTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DayOfMonthType dayOfMonthType = DayOfMonthType.EIGHT;
    DayOfMonthType dayOfMonthType2 = DayOfMonthType.EIGHT;

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType2);
    int expectedHashCodeResult = dayOfMonthType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfMonthType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DayOfMonthType dayOfMonthType = new DayOfMonthType();
    DayOfMonthType dayOfMonthType2 = new DayOfMonthType();

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType2);
    int expectedHashCodeResult = dayOfMonthType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfMonthType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DayOfMonthType dayOfMonthType = DayOfMonthType.EIGHT;

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType);
    int expectedHashCodeResult = dayOfMonthType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfMonthType.hashCode());
  }

  /**
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHTEEN, DayOfMonthType.EIGHT);
    assertNotEquals(new DayOfMonthType(), DayOfMonthType.EIGHT);
  }

  /**
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, null);
  }

  /**
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, "Different type to DayOfMonthType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#DayOfMonthType()}
   *   <li>{@link DayOfMonthType#getFriendlyType()}
   *   <li>{@link DayOfMonthType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DayOfMonthType actualDayOfMonthType = new DayOfMonthType();
    String actualFriendlyType = actualDayOfMonthType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDayOfMonthType.getType());
  }
}
