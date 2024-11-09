/*-
 * #%L
 * BroadleafCommerce Framework
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
   * Test {@link FieldType#isMultiValued(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#BOOLEAN}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued_whenBoolean_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FieldType.isMultiValued(FieldType.BOOLEAN));
  }

  /**
   * Test {@link FieldType#isMultiValued(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#BOOLEANS}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued_whenBooleans_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FieldType.isMultiValued(FieldType.BOOLEANS));
  }

  /**
   * Test {@link FieldType#isMultiValued(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#FieldType(String, String)} with type is {@code bs}
   * and friendlyType is {@code b}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued_whenFieldTypeWithTypeIsBsAndFriendlyTypeIsB_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(FieldType.isMultiValued(new FieldType("bs", "b")));
  }

  /**
   * Test {@link FieldType#isMultiValued(FieldType)}.
   * <ul>
   *   <li>When {@link FieldType#FieldType()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued_whenFieldType_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FieldType.isMultiValued(new FieldType()));
  }

  /**
   * Test {@link FieldType#isMultiValued(FieldType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#isMultiValued(FieldType)}
   */
  @Test
  public void testIsMultiValued_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(FieldType.isMultiValued(null));
  }

  /**
   * Test {@link FieldType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test {@link FieldType#FieldType(String, String)}.
   * <p>
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

  /**
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldType#equals(Object)}, and {@link FieldType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link FieldType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEANS, FieldType.BOOLEAN);
    assertNotEquals(new FieldType(), FieldType.BOOLEAN);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, null);
  }

  /**
   * Test {@link FieldType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldType.BOOLEAN, "Different type to FieldType");
  }
}
