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
package org.broadleafcommerce.common.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {TargetModeType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TargetModeTypeDiffblueTest {
  @Autowired
  private TargetModeType targetModeType;

  /**
   * Test {@link TargetModeType#getInstance(String)}.
   * <p>
   * Method under test: {@link TargetModeType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    TargetModeType actualInstance = TargetModeType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TargetModeType#TargetModeType()}
   *   <li>{@link TargetModeType#getTypes()}
   *   <li>{@link TargetModeType#getFriendlyType()}
   *   <li>{@link TargetModeType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TargetModeType actualTargetModeType = new TargetModeType();
    Map<String, TargetModeType> actualTypes = actualTargetModeType.getTypes();
    String actualFriendlyType = actualTargetModeType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualTargetModeType.getType());
    assertEquals(3, actualTypes.size());
  }

  /**
   * Test {@link TargetModeType#TargetModeType(String, String)}.
   * <p>
   * Method under test: {@link TargetModeType#TargetModeType(String, String)}
   */
  @Test
  public void testNewTargetModeType() {
    // Arrange and Act
    TargetModeType actualTargetModeType = new TargetModeType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualTargetModeType.getFriendlyType());
    assertEquals("Type", actualTargetModeType.getType());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and
   * {@link TargetModeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TargetModeType targetModeType = TargetModeType.PRODUCTION;
    TargetModeType targetModeType2 = TargetModeType.PRODUCTION;

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    int expectedHashCodeResult = targetModeType.hashCode();
    assertEquals(expectedHashCodeResult, targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and
   * {@link TargetModeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TargetModeType targetModeType = new TargetModeType();
    TargetModeType targetModeType2 = new TargetModeType();

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    int expectedHashCodeResult = targetModeType.hashCode();
    assertEquals(expectedHashCodeResult, targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and
   * {@link TargetModeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TargetModeType targetModeType = new TargetModeType("production", "Friendly Type");
    TargetModeType targetModeType2 = TargetModeType.PRODUCTION;

    // Act and Assert
    assertEquals(targetModeType, targetModeType2);
    int expectedHashCodeResult = targetModeType.hashCode();
    assertEquals(expectedHashCodeResult, targetModeType2.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}, and
   * {@link TargetModeType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TargetModeType#equals(Object)}
   *   <li>{@link TargetModeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TargetModeType targetModeType = TargetModeType.PRODUCTION;

    // Act and Assert
    assertEquals(targetModeType, targetModeType);
    int expectedHashCodeResult = targetModeType.hashCode();
    assertEquals(expectedHashCodeResult, targetModeType.hashCode());
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.SANDBOX, TargetModeType.PRODUCTION);
    assertNotEquals(new TargetModeType(), TargetModeType.PRODUCTION);
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.PRODUCTION, null);
  }

  /**
   * Test {@link TargetModeType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TargetModeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(TargetModeType.PRODUCTION, "Different type to TargetModeType");
  }
}
