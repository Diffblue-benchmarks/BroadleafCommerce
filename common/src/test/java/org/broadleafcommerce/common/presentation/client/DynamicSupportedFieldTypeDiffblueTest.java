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
package org.broadleafcommerce.common.presentation.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {DynamicSupportedFieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DynamicSupportedFieldTypeDiffblueTest {
  @Autowired
  private DynamicSupportedFieldType dynamicSupportedFieldType;

  /**
   * Test {@link DynamicSupportedFieldType#getInstance(String)}.
   * <p>
   * Method under test: {@link DynamicSupportedFieldType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange, Act and Assert
    assertNull(DynamicSupportedFieldType.getInstance("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#DynamicSupportedFieldType()}
   *   <li>{@link DynamicSupportedFieldType#getFriendlyType()}
   *   <li>{@link DynamicSupportedFieldType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DynamicSupportedFieldType actualDynamicSupportedFieldType = new DynamicSupportedFieldType();
    String actualFriendlyType = actualDynamicSupportedFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualDynamicSupportedFieldType.getType());
  }

  /**
   * Test
   * {@link DynamicSupportedFieldType#DynamicSupportedFieldType(String, String)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DynamicSupportedFieldType#DynamicSupportedFieldType(String, String)}
   */
  @Test
  public void testNewDynamicSupportedFieldType_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> new DynamicSupportedFieldType("ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Category",
            "Friendly Type"));

  }

  /**
   * Test {@link DynamicSupportedFieldType#getTypes()}.
   * <p>
   * Method under test: {@link DynamicSupportedFieldType#getTypes()}
   */
  @Test
  public void testGetTypes() {
    // Arrange and Act
    List<DynamicSupportedFieldType> actualTypes = DynamicSupportedFieldType.getTypes();

    // Assert
    assertEquals(8, actualTypes.size());
    DynamicSupportedFieldType getResult = actualTypes.get(6);
    assertEquals("ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Category", getResult.getType());
    DynamicSupportedFieldType getResult2 = actualTypes.get(5);
    assertEquals("ADDITIONAL_FOREIGN_KEY|org.broadleafcommerce.core.catalog.domain.Product", getResult2.getType());
    DynamicSupportedFieldType getResult3 = actualTypes.get(4);
    assertEquals("ASSET_LOOKUP", getResult3.getType());
    DynamicSupportedFieldType getResult4 = actualTypes.get(3);
    assertEquals("COLOR", getResult4.getType());
    assertEquals("Category Lookup", getResult.getFriendlyType());
    assertEquals("Color", getResult4.getFriendlyType());
    DynamicSupportedFieldType getResult5 = actualTypes.get(7);
    assertEquals("DATE", getResult5.getType());
    assertEquals("Date", getResult5.getFriendlyType());
    DynamicSupportedFieldType getResult6 = actualTypes.get(1);
    assertEquals("HTML", getResult6.getType());
    assertEquals("Image", getResult3.getFriendlyType());
    DynamicSupportedFieldType getResult7 = actualTypes.get(2);
    assertEquals("MONEY", getResult7.getType());
    assertEquals("Money", getResult7.getFriendlyType());
    assertEquals("Product Lookup", getResult2.getFriendlyType());
    assertEquals("Rich Text", getResult6.getFriendlyType());
    DynamicSupportedFieldType getResult8 = actualTypes.get(0);
    assertEquals("STRING", getResult8.getType());
    assertEquals("String", getResult8.getFriendlyType());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and
   * {@link DynamicSupportedFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = DynamicSupportedFieldType.ASSET_LOOKUP;
    DynamicSupportedFieldType dynamicSupportedFieldType2 = DynamicSupportedFieldType.ASSET_LOOKUP;

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType2);
    int expectedHashCodeResult = dynamicSupportedFieldType.hashCode();
    assertEquals(expectedHashCodeResult, dynamicSupportedFieldType2.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and
   * {@link DynamicSupportedFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = new DynamicSupportedFieldType();
    DynamicSupportedFieldType dynamicSupportedFieldType2 = new DynamicSupportedFieldType();

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType2);
    int expectedHashCodeResult = dynamicSupportedFieldType.hashCode();
    assertEquals(expectedHashCodeResult, dynamicSupportedFieldType2.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}, and
   * {@link DynamicSupportedFieldType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DynamicSupportedFieldType#equals(Object)}
   *   <li>{@link DynamicSupportedFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DynamicSupportedFieldType dynamicSupportedFieldType = DynamicSupportedFieldType.ASSET_LOOKUP;

    // Act and Assert
    assertEquals(dynamicSupportedFieldType, dynamicSupportedFieldType);
    int expectedHashCodeResult = dynamicSupportedFieldType.hashCode();
    assertEquals(expectedHashCodeResult, dynamicSupportedFieldType.hashCode());
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DynamicSupportedFieldType.CATEGORY_LOOKUP, DynamicSupportedFieldType.ASSET_LOOKUP);
    assertNotEquals(new DynamicSupportedFieldType(), DynamicSupportedFieldType.ASSET_LOOKUP);
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DynamicSupportedFieldType.ASSET_LOOKUP, null);
  }

  /**
   * Test {@link DynamicSupportedFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DynamicSupportedFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(DynamicSupportedFieldType.ASSET_LOOKUP, "Different type to DynamicSupportedFieldType");
  }
}
