/*-
 * #%L
 * BroadleafCommerce Framework
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
package org.broadleafcommerce.core.search.domain.solr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldTypeDiffblueTest {
  @Autowired
  private FieldType fieldType;

  /**
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued() {
    // Arrange, Act and Assert
    assertFalse(FieldType.isMultiValued(FieldType.BOOLEAN));
    assertTrue(FieldType.isMultiValued(FieldType.BOOLEANS));
    assertFalse(FieldType.isMultiValued(new FieldType()));
    assertFalse(FieldType.isMultiValued(null));
    assertTrue(FieldType.isMultiValued(new FieldType("bs", "b")));
  }

  /**
   * Method under test: {@link FieldType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    FieldType actualInstance = FieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;
    FieldType fieldType2 = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEANS;
    FieldType fieldType2 = new FieldType("bs", "bs");

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FieldType fieldType = new FieldType();
    FieldType fieldType2 = new FieldType();

    // Act and Assert
    assertEquals(fieldType, fieldType2);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldType#equals(Object)}
   *   <li>{@link FieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldType fieldType = FieldType.BOOLEAN;

    // Act and Assert
    assertEquals(fieldType, fieldType);
    int expectedHashCodeResult = fieldType.hashCode();
    assertEquals(expectedHashCodeResult, fieldType.hashCode());
  }

  /**
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEANS, FieldType.BOOLEAN);
    assertNotEquals(new FieldType(), FieldType.BOOLEAN);
  }

  /**
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, null);
  }

  /**
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, "Different type to FieldType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link FieldType#FieldType()}
   *   <li>{@link FieldType#getFriendlyType()}
   *   <li>{@link FieldType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType();
    String actualFriendlyType = actualFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFieldType.getType());
  }

  /**
   * Method under test: {@link FieldType#FieldType(String, String)}
   */
  @Test
  public void testNewFieldType() {
    // Arrange and Act
    FieldType actualFieldType = new FieldType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFieldType.getFriendlyType());
    assertEquals("Type", actualFieldType.getType());
  }
}
