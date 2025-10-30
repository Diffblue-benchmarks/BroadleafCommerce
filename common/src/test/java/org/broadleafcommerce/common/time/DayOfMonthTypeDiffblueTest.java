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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DayOfMonthTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#DayOfMonthType()}
   *   <li>{@link DayOfMonthType#getFriendlyType()}
   *   <li>{@link DayOfMonthType#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DayOfMonthType.<init>()", "String DayOfMonthType.getFriendlyType()",
      "String DayOfMonthType.getType()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    DayOfMonthType actualDayOfMonthType = new DayOfMonthType();
    String actualFriendlyType = actualDayOfMonthType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDayOfMonthType.getType());
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
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
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
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
   * Test {@link DayOfMonthType#equals(Object)}, and {@link DayOfMonthType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DayOfMonthType#equals(Object)}
   *   <li>{@link DayOfMonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DayOfMonthType dayOfMonthType = DayOfMonthType.EIGHT;

    // Act and Assert
    assertEquals(dayOfMonthType, dayOfMonthType);
    int expectedHashCodeResult = dayOfMonthType.hashCode();
    assertEquals(expectedHashCodeResult, dayOfMonthType.hashCode());
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHTEEN, DayOfMonthType.EIGHT);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new DayOfMonthType(), DayOfMonthType.EIGHT);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, null);
  }

  /**
   * Test {@link DayOfMonthType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DayOfMonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DayOfMonthType.equals(Object)", "int DayOfMonthType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DayOfMonthType.EIGHT, "Different type to DayOfMonthType");
  }
}
