/*-
 * #%L
 * BroadleafCommerce CMS Module
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

@ContextConfiguration(classes = {StructuredContentRuleType.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StructuredContentRuleTypeDiffblueTest {
  @Autowired
  private StructuredContentRuleType structuredContentRuleType;

  /**
   * Test getters and setters.
   * <p>
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
   * Test
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Product}.</li>
   *   <li>Then return Type is {@code Product}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}
   */
  @Test
  public void testNewStructuredContentRuleType_whenProduct_thenReturnTypeIsProduct() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType("Product",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStructuredContentRuleType.getFriendlyType());
    assertEquals("Product", actualStructuredContentRuleType.getType());
  }

  /**
   * Test
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link StructuredContentRuleType#StructuredContentRuleType(String, String)}
   */
  @Test
  public void testNewStructuredContentRuleType_whenType_thenReturnType() {
    // Arrange and Act
    StructuredContentRuleType actualStructuredContentRuleType = new StructuredContentRuleType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualStructuredContentRuleType.getFriendlyType());
    assertEquals("Type", actualStructuredContentRuleType.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code TypeType}.</li>
   *   <li>Then {@link StructuredContentRuleType#CUSTOMER} Type is
   * {@code TypeType}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenTypeType_thenCustomerTypeIsTypeType() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act
    structuredContentRuleType2.setType("TypeType");

    // Assert
    assertEquals("TypeType", structuredContentRuleType2.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#setType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then {@link StructuredContentRuleType#CUSTOMER} Type is
   * {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleType#setType(String)}
   */
  @Test
  public void testSetType_whenType_thenCustomerTypeIsType() {
    // Arrange
    StructuredContentRuleType structuredContentRuleType2 = StructuredContentRuleType.CUSTOMER;

    // Act
    structuredContentRuleType2.setType("Type");

    // Assert
    assertEquals("Type", structuredContentRuleType2.getType());
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}, and
   * {@link StructuredContentRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentRuleType#equals(Object)}, and
   * {@link StructuredContentRuleType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentRuleType#equals(Object)}, and
   * {@link StructuredContentRuleType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link StructuredContentRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.PRODUCT, StructuredContentRuleType.CUSTOMER);
    assertNotEquals(new StructuredContentRuleType(), StructuredContentRuleType.CUSTOMER);
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.CUSTOMER, null);
  }

  /**
   * Test {@link StructuredContentRuleType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link StructuredContentRuleType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(StructuredContentRuleType.CUSTOMER, "Different type to StructuredContentRuleType");
  }
}
