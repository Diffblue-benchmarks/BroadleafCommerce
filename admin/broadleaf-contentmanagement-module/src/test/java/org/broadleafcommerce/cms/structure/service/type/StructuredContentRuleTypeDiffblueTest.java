/*-
 * #%L
 * BroadleafCommerce CMS Module
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
package org.broadleafcommerce.cms.structure.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {StructuredContentRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class StructuredContentRuleTypeDiffblueTest {
  @Autowired
  private StructuredContentRuleType structuredContentRuleType;

  /**
   * Method under test: {@link StructuredContentRuleType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    StructuredContentRuleType actualInstance = StructuredContentRuleType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  public void testSetType() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act
    structuredContentRuleType2.setType("Type");

    // Assert
    assertEquals("Type", structuredContentRuleType2.getType());
  }

  /**
   * Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  public void testSetType2() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act
    structuredContentRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", structuredContentRuleType2.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = StructuredContentRuleType.CUSTOMER;
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    int expectedHashCodeResult = structuredContentRuleType.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = new StructuredContentRuleType();
    StructuredContentRuleType structuredContentRuleType2 = new StructuredContentRuleType();

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    int expectedHashCodeResult = structuredContentRuleType.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = new StructuredContentRuleType("CUSTOMER", "Friendly Type");
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType2);
    int expectedHashCodeResult = structuredContentRuleType.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleType#equals(Object)}
   *   <li>{@link StructuredContentRuleType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType = StructuredContentRuleType.CUSTOMER;

    // Act and Assert
    assertEquals(structuredContentRuleType, structuredContentRuleType);
    int expectedHashCodeResult = structuredContentRuleType.hashCode();
    assertEquals(expectedHashCodeResult, structuredContentRuleType.hashCode());
  }

  /**
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.PRODUCT, StructuredContentRuleType.CUSTOMER);
    assertNotEquals(new StructuredContentRuleType(), StructuredContentRuleType.CUSTOMER);
  }

  /**
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.CUSTOMER, null);
  }

  /**
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.CUSTOMER, "Different type to StructuredContentRuleType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StructuredContentRuleType#StructuredContentRuleType()}
   *   <li>{@link StructuredContentRuleType#getFriendlyType()}
   *   <li>{@link StructuredContentRuleType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType();
    String actualFriendlyType = actualStructuredContentRuleType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualStructuredContentRuleType.getType());
  }

  /**
   * Method under test:
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}
   */
  @Test
  public void testNewStructuredContentRuleType() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStructuredContentRuleType.getFriendlyType());
    assertEquals("Type", actualStructuredContentRuleType.getType());
  }

  /**
   * Method under test:
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}
   */
  @Test
  public void testNewStructuredContentRuleType2() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType("Product",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStructuredContentRuleType.getFriendlyType());
    assertEquals("Product", actualStructuredContentRuleType.getType());
  }
}
