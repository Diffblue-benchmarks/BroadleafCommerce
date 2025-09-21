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
package org.broadleafcommerce.common.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {WeightUnitOfMeasureType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class WeightUnitOfMeasureTypeDiffblueTest {
  @Autowired private WeightUnitOfMeasureType weightUnitOfMeasureType;

  /**
   * Test {@link WeightUnitOfMeasureType#getInstance(String)}.
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"WeightUnitOfMeasureType WeightUnitOfMeasureType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    WeightUnitOfMeasureType actualInstance = WeightUnitOfMeasureType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#WeightUnitOfMeasureType()}
   *   <li>{@link WeightUnitOfMeasureType#getFriendlyType()}
   *   <li>{@link WeightUnitOfMeasureType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WeightUnitOfMeasureType.<init>()",
    "String WeightUnitOfMeasureType.getFriendlyType()",
    "String WeightUnitOfMeasureType.getType()"
  })
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
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#WeightUnitOfMeasureType(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void WeightUnitOfMeasureType.<init>(String, String)"})
  public void testNewWeightUnitOfMeasureType() {
    // Arrange and Act
    WeightUnitOfMeasureType actualWeightUnitOfMeasureType =
        new WeightUnitOfMeasureType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualWeightUnitOfMeasureType.getFriendlyType());
    assertEquals("Type", actualWeightUnitOfMeasureType.getType());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and {@link
   * WeightUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = WeightUnitOfMeasureType.KILOGRAMS;
    WeightUnitOfMeasureType weightUnitOfMeasureType2 = WeightUnitOfMeasureType.KILOGRAMS;

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    assertEquals(weightUnitOfMeasureType.hashCode(), weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and {@link
   * WeightUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = WeightUnitOfMeasureType.POUNDS;
    WeightUnitOfMeasureType weightUnitOfMeasureType2 =
        new WeightUnitOfMeasureType("POUNDS", "POUNDS");

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    assertEquals(weightUnitOfMeasureType.hashCode(), weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and {@link
   * WeightUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    WeightUnitOfMeasureType weightUnitOfMeasureType = new WeightUnitOfMeasureType();
    WeightUnitOfMeasureType weightUnitOfMeasureType2 = new WeightUnitOfMeasureType();

    // Act and Assert
    assertEquals(weightUnitOfMeasureType, weightUnitOfMeasureType2);
    assertEquals(weightUnitOfMeasureType.hashCode(), weightUnitOfMeasureType2.hashCode());
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}, and {@link
   * WeightUnitOfMeasureType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WeightUnitOfMeasureType#equals(Object)}
   *   <li>{@link WeightUnitOfMeasureType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.POUNDS, WeightUnitOfMeasureType.KILOGRAMS);
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new WeightUnitOfMeasureType(), WeightUnitOfMeasureType.KILOGRAMS);
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.KILOGRAMS, null);
  }

  /**
   * Test {@link WeightUnitOfMeasureType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WeightUnitOfMeasureType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean WeightUnitOfMeasureType.equals(Object)",
    "int WeightUnitOfMeasureType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(WeightUnitOfMeasureType.KILOGRAMS, "Different type to WeightUnitOfMeasureType");
  }
}
