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
package org.broadleafcommerce.core.search.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {FieldEntity.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FieldEntityDiffblueTest {
  @Autowired
  private FieldEntity fieldEntity;

  /**
   * Test {@link FieldEntity#getInstance(String)}.
   * <p>
   * Method under test: {@link FieldEntity#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    FieldEntity actualInstance = FieldEntity.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    List<String> allLookupTypes = actualInstance.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", actualInstance.getType());
    assertTrue(actualInstance.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualInstance.additionalLookupTypes.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldEntity#FieldEntity()}
   *   <li>{@link FieldEntity#getFriendlyType()}
   *   <li>{@link FieldEntity#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FieldEntity actualFieldEntity = new FieldEntity();
    String actualFriendlyType = actualFieldEntity.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFieldEntity.getType());
    assertTrue(actualFieldEntity.additionalLookupTypes.isEmpty());
  }

  /**
   * Test {@link FieldEntity#FieldEntity(String, String)}.
   * <p>
   * Method under test: {@link FieldEntity#FieldEntity(String, String)}
   */
  @Test
  public void testNewFieldEntity() {
    // Arrange and Act
    FieldEntity actualFieldEntity = new FieldEntity("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualFieldEntity.getFriendlyType());
    List<String> allLookupTypes = actualFieldEntity.getAllLookupTypes();
    assertEquals(1, allLookupTypes.size());
    assertEquals("Type", allLookupTypes.get(0));
    assertEquals("Type", actualFieldEntity.getType());
    assertTrue(actualFieldEntity.getAdditionalLookupTypes().isEmpty());
    assertTrue(actualFieldEntity.additionalLookupTypes.isEmpty());
  }

  /**
   * Test {@link FieldEntity#getAdditionalLookupTypes()}.
   * <p>
   * Method under test: {@link FieldEntity#getAdditionalLookupTypes()}
   */
  @Test
  public void testGetAdditionalLookupTypes() {
    // Arrange
    FieldEntity fieldEntity = FieldEntity.CATEGORY;

    // Act and Assert
    assertEquals(fieldEntity.additionalLookupTypes, fieldEntity.getAdditionalLookupTypes());
  }

  /**
   * Test {@link FieldEntity#getAllLookupTypes()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldEntity#getAllLookupTypes()}
   */
  @Test
  public void testGetAllLookupTypes_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualAllLookupTypes = (new FieldEntity("Type", "Friendly Type")).getAllLookupTypes();

    // Assert
    assertEquals(1, actualAllLookupTypes.size());
    assertEquals("Type", actualAllLookupTypes.get(0));
  }

  /**
   * Test {@link FieldEntity#equals(Object)}, and {@link FieldEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldEntity#equals(Object)}
   *   <li>{@link FieldEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FieldEntity fieldEntity = FieldEntity.CATEGORY;
    FieldEntity fieldEntity2 = FieldEntity.CATEGORY;

    // Act and Assert
    assertEquals(fieldEntity, fieldEntity2);
    int expectedHashCodeResult = fieldEntity.hashCode();
    assertEquals(expectedHashCodeResult, fieldEntity2.hashCode());
  }

  /**
   * Test {@link FieldEntity#equals(Object)}, and {@link FieldEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldEntity#equals(Object)}
   *   <li>{@link FieldEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FieldEntity fieldEntity = new FieldEntity();
    FieldEntity fieldEntity2 = new FieldEntity();

    // Act and Assert
    assertEquals(fieldEntity, fieldEntity2);
    int expectedHashCodeResult = fieldEntity.hashCode();
    assertEquals(expectedHashCodeResult, fieldEntity2.hashCode());
  }

  /**
   * Test {@link FieldEntity#equals(Object)}, and {@link FieldEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldEntity#equals(Object)}
   *   <li>{@link FieldEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FieldEntity fieldEntity = new FieldEntity("CATEGORY", "Friendly Type");
    FieldEntity fieldEntity2 = FieldEntity.CATEGORY;

    // Act and Assert
    assertEquals(fieldEntity, fieldEntity2);
    int expectedHashCodeResult = fieldEntity.hashCode();
    assertEquals(expectedHashCodeResult, fieldEntity2.hashCode());
  }

  /**
   * Test {@link FieldEntity#equals(Object)}, and {@link FieldEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link FieldEntity#equals(Object)}
   *   <li>{@link FieldEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FieldEntity fieldEntity = FieldEntity.CATEGORY;

    // Act and Assert
    assertEquals(fieldEntity, fieldEntity);
    int expectedHashCodeResult = fieldEntity.hashCode();
    assertEquals(expectedHashCodeResult, fieldEntity.hashCode());
  }

  /**
   * Test {@link FieldEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldEntity.CUSTOMER, FieldEntity.CATEGORY);
    assertNotEquals(new FieldEntity(), FieldEntity.CATEGORY);
  }

  /**
   * Test {@link FieldEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldEntity.CATEGORY, null);
  }

  /**
   * Test {@link FieldEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link FieldEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FieldEntity.CATEGORY, "Different type to FieldEntity");
  }
}
