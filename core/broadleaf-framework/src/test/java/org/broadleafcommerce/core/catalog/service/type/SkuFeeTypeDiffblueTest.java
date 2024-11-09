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
package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SkuFeeType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SkuFeeTypeDiffblueTest {
  @Autowired
  private SkuFeeType skuFeeType;

  /**
   * Test {@link SkuFeeType#getInstance(String)}.
   * <p>
   * Method under test: {@link SkuFeeType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    SkuFeeType actualInstance = SkuFeeType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeType#SkuFeeType()}
   *   <li>{@link SkuFeeType#getFriendlyType()}
   *   <li>{@link SkuFeeType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    SkuFeeType actualSkuFeeType = new SkuFeeType();
    String actualFriendlyType = actualSkuFeeType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualSkuFeeType.getType());
  }

  /**
   * Test {@link SkuFeeType#SkuFeeType(String, String)}.
   * <p>
   * Method under test: {@link SkuFeeType#SkuFeeType(String, String)}
   */
  @Test
  public void testNewSkuFeeType() {
    // Arrange and Act
    SkuFeeType actualSkuFeeType = new SkuFeeType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualSkuFeeType.getFriendlyType());
    assertEquals("Type", actualSkuFeeType.getType());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SkuFeeType skuFeeType = SkuFeeType.FULFILLMENT;
    SkuFeeType skuFeeType2 = SkuFeeType.FULFILLMENT;

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    int expectedHashCodeResult = skuFeeType.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SkuFeeType skuFeeType = new SkuFeeType("FULFILLMENT", "Friendly Type");
    SkuFeeType skuFeeType2 = SkuFeeType.FULFILLMENT;

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    int expectedHashCodeResult = skuFeeType.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SkuFeeType skuFeeType = new SkuFeeType();
    SkuFeeType skuFeeType2 = new SkuFeeType();

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType2);
    int expectedHashCodeResult = skuFeeType.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeType2.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}, and {@link SkuFeeType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SkuFeeType#equals(Object)}
   *   <li>{@link SkuFeeType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SkuFeeType skuFeeType = SkuFeeType.FULFILLMENT;

    // Act and Assert
    assertEquals(skuFeeType, skuFeeType);
    int expectedHashCodeResult = skuFeeType.hashCode();
    assertEquals(expectedHashCodeResult, skuFeeType.hashCode());
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SkuFeeType("Type", "Friendly Type"), SkuFeeType.FULFILLMENT);
    assertNotEquals(new SkuFeeType(), SkuFeeType.FULFILLMENT);
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SkuFeeType.FULFILLMENT, null);
  }

  /**
   * Test {@link SkuFeeType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SkuFeeType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SkuFeeType.FULFILLMENT, "Different type to SkuFeeType");
  }
}
