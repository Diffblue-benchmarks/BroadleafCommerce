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

@ContextConfiguration(classes = {DimensionUnitOfMeasureType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DimensionUnitOfMeasureTypeDiffblueTest {
  @Autowired
  private DimensionUnitOfMeasureType dimensionUnitOfMeasureType;

  /**
   * Test {@link DimensionUnitOfMeasureType#getInstance(String)}.
   * <p>
   * Method under test: {@link DimensionUnitOfMeasureType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualInstance = DimensionUnitOfMeasureType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType()}
   *   <li>{@link DimensionUnitOfMeasureType#getFriendlyType()}
   *   <li>{@link DimensionUnitOfMeasureType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasureType = new DimensionUnitOfMeasureType();
    String actualFriendlyType = actualDimensionUnitOfMeasureType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDimensionUnitOfMeasureType.getType());
  }

  /**
   * Test
   * {@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType(String, String)}.
   * <ul>
   *   <li>When {@code Feet}.</li>
   *   <li>Then return Type is {@code Feet}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType(String, String)}
   */
  @Test
  public void testNewDimensionUnitOfMeasureType_whenFeet_thenReturnTypeIsFeet() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasureType = new DimensionUnitOfMeasureType("Feet",
        "Friendly Type");

    // Assert
    assertEquals("Feet", actualDimensionUnitOfMeasureType.getType());
    assertEquals("Friendly Type", actualDimensionUnitOfMeasureType.getFriendlyType());
  }

  /**
   * Test
   * {@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DimensionUnitOfMeasureType#DimensionUnitOfMeasureType(String, String)}
   */
  @Test
  public void testNewDimensionUnitOfMeasureType_whenType_thenReturnType() {
    // Arrange and Act
    DimensionUnitOfMeasureType actualDimensionUnitOfMeasureType = new DimensionUnitOfMeasureType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualDimensionUnitOfMeasureType.getFriendlyType());
    assertEquals("Type", actualDimensionUnitOfMeasureType.getType());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and
   * {@link DimensionUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = DimensionUnitOfMeasureType.CENTIMETERS;
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 = DimensionUnitOfMeasureType.CENTIMETERS;

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    int expectedHashCodeResult = dimensionUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and
   * {@link DimensionUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = new DimensionUnitOfMeasureType();
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 = new DimensionUnitOfMeasureType();

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    int expectedHashCodeResult = dimensionUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and
   * {@link DimensionUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = new DimensionUnitOfMeasureType("CENTIMETERS",
        "Friendly Type");
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType2 = DimensionUnitOfMeasureType.CENTIMETERS;

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType2);
    int expectedHashCodeResult = dimensionUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, dimensionUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}, and
   * {@link DimensionUnitOfMeasureType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DimensionUnitOfMeasureType#equals(Object)}
   *   <li>{@link DimensionUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DimensionUnitOfMeasureType dimensionUnitOfMeasureType = DimensionUnitOfMeasureType.CENTIMETERS;

    // Act and Assert
    assertEquals(dimensionUnitOfMeasureType, dimensionUnitOfMeasureType);
    int expectedHashCodeResult = dimensionUnitOfMeasureType.hashCode();
    assertEquals(expectedHashCodeResult, dimensionUnitOfMeasureType.hashCode());
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DimensionUnitOfMeasureType.FEET, DimensionUnitOfMeasureType.CENTIMETERS);
    assertNotEquals(new DimensionUnitOfMeasureType(), DimensionUnitOfMeasureType.CENTIMETERS);
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DimensionUnitOfMeasureType.CENTIMETERS, null);
  }

  /**
   * Test {@link DimensionUnitOfMeasureType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DimensionUnitOfMeasureType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DimensionUnitOfMeasureType.CENTIMETERS, "Different type to DimensionUnitOfMeasureType");
  }
}
