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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WeightUnitOfMeasureType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WeightUnitOfMeasureTypeDiffblueTest {
  @Autowired
  private WeightUnitOfMeasureType weightUnitOfMeasureType;

  /**
   * Test {@link WeightUnitOfMeasureType#getInstance(String)}.
   * <p>
   * Method under test: {@link WeightUnitOfMeasureType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    WeightUnitOfMeasureType actualInstance = WeightUnitOfMeasureType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}
   *   <li>{@link WeightUnitOfMeasureType#getFriendlyType()}
   *   <li>{@link WeightUnitOfMeasureType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WeightUnitOfMeasureType actualWeightUnitOfMeasureType = new WeightUnitOfMeasureType();
    String actualFriendlyType = actualWeightUnitOfMeasureType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualWeightUnitOfMeasureType.getType());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)}.
   * <p>
   * Method under test:
   * {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)}
   */
  @Test
  public void testNewWeightUnitOfMeasureType() {
    // Arrange and Act
    WeightUnitOfMeasureType actualWeightUnitOfMeasureType = new WeightUnitOfMeasureType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWeightUnitOfMeasureType.getFriendlyType());
    assertEquals("Type", actualWeightUnitOfMeasureType.getType());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and
   * {@link WeightUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = WeightUnitOfMeasureType.KILOGRAMS;
    WeightUnitOfMeasureType weightUnitOfMeasureType2 = WeightUnitOfMeasureType.KILOGRAMS;

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    int expectedHashCodeResult = weightUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and
   * {@link WeightUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = new WeightUnitOfMeasureType();
    WeightUnitOfMeasureType weightUnitOfMeasureType2 = new WeightUnitOfMeasureType();

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    int expectedHashCodeResult = weightUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and
   * {@link WeightUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = new WeightUnitOfMeasureType("KILOGRAMS", "Friendly Type");
    WeightUnitOfMeasureType weightUnitOfMeasureType2 = WeightUnitOfMeasureType.KILOGRAMS;

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    int expectedHashCodeResult = weightUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and
   * {@link WeightUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = WeightUnitOfMeasureType.KILOGRAMS;

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType);
    int expectedHashCodeResult = weightUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, weightUnitOfMeasureType.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.POUNDS, WeightUnitOfMeasureType.KILOGRAMS);
    assertNotEquals(new WeightUnitOfMeasureType(), WeightUnitOfMeasureType.KILOGRAMS);
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.KILOGRAMS, null);
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.KILOGRAMS, "Different type to WeightUnitOfMeasureType");
  }
}
