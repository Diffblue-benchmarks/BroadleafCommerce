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
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {MonthType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MonthTypeDiffblueTest {
  @Autowired
  private MonthType monthType;

  /**
   * Test {@link MonthType#getInstance(String)}.
   * <p>
   * Method under test: {@link MonthType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    MonthType actualInstance = MonthType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

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
  public void testGettersAndSetters() {
    // Arrange and Act
    MonthType actualMonthType = new MonthType();
    String actualFriendlyType = actualMonthType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualMonthType.getType());
  }

  /**
   * Test {@link MonthType#MonthType(String, String)}.
   * <ul>
   *   <li>When {@code Cannot add the type: (}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#MonthType(String, String)}
   */
  @Test
  public void testNewMonthType_whenCannotAddTheType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new MonthType("Cannot add the type: (", "Friendly Type"));

  }

  /**
   * Test {@link MonthType#MonthType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MonthType#MonthType(String, String)}
   */
  @Test
  public void testNewMonthType_whenType() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new MonthType("Type", "Friendly Type"));

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
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.AUGUST, MonthType.APRIL);
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
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(MonthType.APRIL, "Different type to MonthType");
  }
}
