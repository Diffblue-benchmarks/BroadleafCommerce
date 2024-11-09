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

public class HourOfDayTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HourOfDayType#HourOfDayType()}
   *   <li>{@link HourOfDayType#getFriendlyType()}
   *   <li>{@link HourOfDayType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    HourOfDayType actualHourOfDayType = new HourOfDayType();
    String actualFriendlyType = actualHourOfDayType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualHourOfDayType.getType());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}, and
   * {@link HourOfDayType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HourOfDayType hourOfDayType = HourOfDayType.EIGHT;
    HourOfDayType hourOfDayType2 = HourOfDayType.EIGHT;

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType2);
    int expectedHashCodeResult = hourOfDayType.hashCode();
    assertEquals(expectedHashCodeResult, hourOfDayType2.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}, and
   * {@link HourOfDayType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HourOfDayType hourOfDayType = new HourOfDayType();
    HourOfDayType hourOfDayType2 = new HourOfDayType();

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType2);
    int expectedHashCodeResult = hourOfDayType.hashCode();
    assertEquals(expectedHashCodeResult, hourOfDayType2.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}, and
   * {@link HourOfDayType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HourOfDayType#equals(Object)}
   *   <li>{@link HourOfDayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HourOfDayType hourOfDayType = HourOfDayType.EIGHT;

    // Act and Assert
    assertEquals(hourOfDayType, hourOfDayType);
    int expectedHashCodeResult = hourOfDayType.hashCode();
    assertEquals(expectedHashCodeResult, hourOfDayType.hashCode());
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHTEEN, HourOfDayType.EIGHT);
    assertNotEquals(new HourOfDayType(), HourOfDayType.EIGHT);
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHT, null);
  }

  /**
   * Test {@link HourOfDayType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HourOfDayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(HourOfDayType.EIGHT, "Different type to HourOfDayType");
  }
}
