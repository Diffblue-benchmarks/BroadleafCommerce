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
package org.broadleafcommerce.common.time;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DayOfWeekTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfWeekType#DayOfWeekType()}
   *   <li>{@link DayOfWeekType#getFriendlyType()}
   *   <li>{@link DayOfWeekType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DayOfWeekType actualDayOfWeekType = new DayOfWeekType();
    String actualFriendlyType = actualDayOfWeekType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDayOfWeekType.getType());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}, and
   * {@link DayOfWeekType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DayOfWeekType dayOfWeekType = DayOfWeekType.FRIDAY;
    DayOfWeekType dayOfWeekType2 = DayOfWeekType.FRIDAY;

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType2);
    int expectedHashCodeResult = dayOfWeekType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfWeekType2.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}, and
   * {@link DayOfWeekType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DayOfWeekType dayOfWeekType = new DayOfWeekType();
    DayOfWeekType dayOfWeekType2 = new DayOfWeekType();

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType2);
    int expectedHashCodeResult = dayOfWeekType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfWeekType2.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}, and
   * {@link DayOfWeekType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfWeekType#equals(Object)}
   *   <li>{@link DayOfWeekType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DayOfWeekType dayOfWeekType = DayOfWeekType.FRIDAY;

    // Act and Assert
    assertEquals(dayOfWeekType, dayOfWeekType);
    int expectedHashCodeResult = dayOfWeekType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfWeekType.hashCode());
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.MONDAY, DayOfWeekType.FRIDAY);
    assertNotEquals(new DayOfWeekType(), DayOfWeekType.FRIDAY);
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.FRIDAY, null);
  }

  /**
   * Test {@link DayOfWeekType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfWeekType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfWeekType.FRIDAY, "Different type to DayOfWeekType");
  }
}
