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
package org.broadleafcommerce.common.config.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SystemPropertyFieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SystemPropertyFieldTypeDiffblueTest {
  @Autowired
  private SystemPropertyFieldType systemPropertyFieldType;

  /**
   * Test {@link SystemPropertyFieldType#getInstance(String)}.
   * <p>
   * Method under test: {@link SystemPropertyFieldType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SystemPropertyFieldType actualInstance = SystemPropertyFieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyFieldType#SystemPropertyFieldType()}
   *   <li>{@link SystemPropertyFieldType#getFriendlyType()}
   *   <li>{@link SystemPropertyFieldType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SystemPropertyFieldType actualSystemPropertyFieldType = new SystemPropertyFieldType();
    String actualFriendlyType = actualSystemPropertyFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSystemPropertyFieldType.getType());
  }

  /**
   * Test {@link SystemPropertyFieldType#SystemPropertyFieldType(String, String)}.
   * <p>
   * Method under test:
   * {@link SystemPropertyFieldType#SystemPropertyFieldType(String, String)}
   */
  @Test
  public void testNewSystemPropertyFieldType() {
    // Arrange and Act
    SystemPropertyFieldType actualSystemPropertyFieldType = new SystemPropertyFieldType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSystemPropertyFieldType.getFriendlyType());
    assertEquals("Type", actualSystemPropertyFieldType.getType());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and
   * {@link SystemPropertyFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = SystemPropertyFieldType.BOOLEAN_TYPE;
    SystemPropertyFieldType systemPropertyFieldType2 = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    int expectedHashCodeResult = systemPropertyFieldType.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and
   * {@link SystemPropertyFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = new SystemPropertyFieldType();
    SystemPropertyFieldType systemPropertyFieldType2 = new SystemPropertyFieldType();

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    int expectedHashCodeResult = systemPropertyFieldType.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and
   * {@link SystemPropertyFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = new SystemPropertyFieldType("BOOLEAN_TYPE", "Friendly Type");
    SystemPropertyFieldType systemPropertyFieldType2 = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType2);
    int expectedHashCodeResult = systemPropertyFieldType.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyFieldType2.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}, and
   * {@link SystemPropertyFieldType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemPropertyFieldType#equals(Object)}
   *   <li>{@link SystemPropertyFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemPropertyFieldType systemPropertyFieldType = SystemPropertyFieldType.BOOLEAN_TYPE;

    // Act and Assert
    assertEquals(systemPropertyFieldType, systemPropertyFieldType);
    int expectedHashCodeResult = systemPropertyFieldType.hashCode();
    assertEquals(expectedHashCodeResult, systemPropertyFieldType.hashCode());
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemPropertyFieldType.DOUBLE_TYPE, SystemPropertyFieldType.BOOLEAN_TYPE);
    assertNotEquals(new SystemPropertyFieldType(), SystemPropertyFieldType.BOOLEAN_TYPE);
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemPropertyFieldType.BOOLEAN_TYPE, null);
  }

  /**
   * Test {@link SystemPropertyFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemPropertyFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SystemPropertyFieldType.BOOLEAN_TYPE, "Different type to SystemPropertyFieldType");
  }
}
