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

public class MonthTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MonthType#MonthType()}
   *   <li>{@link MonthType#getFriendlyType()}
   *   <li>{@link MonthType#getType()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MonthType.<init>()", "String MonthType.getFriendlyType()", "String MonthType.getType()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    MonthType actualMonthType = new MonthType();
    String actualFriendlyType = actualMonthType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualMonthType.getType());
  }

  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MonthType monthType = MonthType.APRIL;
    MonthType monthType2 = MonthType.APRIL;

    // Act and Assert
    assertEquals(monthType, monthType2);
    int expectedHashCodeResult = monthType.hashCode();
    assertEquals(expectedHashCodeResult, monthType2.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MonthType monthType = new MonthType();
    MonthType monthType2 = new MonthType();

    // Act and Assert
    assertEquals(monthType, monthType2);
    int expectedHashCodeResult = monthType.hashCode();
    assertEquals(expectedHashCodeResult, monthType2.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}, and {@link MonthType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MonthType#equals(Object)}
   *   <li>{@link MonthType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MonthType monthType = MonthType.APRIL;

    // Act and Assert
    assertEquals(monthType, monthType);
    int expectedHashCodeResult = monthType.hashCode();
    assertEquals(expectedHashCodeResult, monthType.hashCode());
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.AUGUST, MonthType.APRIL);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new MonthType(), MonthType.APRIL);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.APRIL, null);
  }

  /**
   * Test {@link MonthType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MonthType.equals(Object)", "int MonthType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.APRIL, "Different type to MonthType");
  }
}
