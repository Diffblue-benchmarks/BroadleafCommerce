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

@ContextConfiguration(classes = {ProductOptionType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionTypeDiffblueTest {
  @Autowired
  private ProductOptionType productOptionType;

  /**
   * Test {@link ProductOptionType#getInstance(String)}.
   * <p>
   * Method under test: {@link ProductOptionType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionType actualInstance = ProductOptionType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionType#ProductOptionType()}
   *   <li>{@link ProductOptionType#getFriendlyType()}
   *   <li>{@link ProductOptionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionType actualProductOptionType = new ProductOptionType();
    String actualFriendlyType = actualProductOptionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionType.getType());
  }

  /**
   * Test {@link ProductOptionType#ProductOptionType(String, String)}.
   * <ul>
   *   <li>When {@code Color}.</li>
   *   <li>Then return Type is {@code Color}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionType#ProductOptionType(String, String)}
   */
  @Test
  public void testNewProductOptionType_whenColor_thenReturnTypeIsColor() {
    // Arrange and Act
    ProductOptionType actualProductOptionType = new ProductOptionType("Color", "Friendly Type");

    // Assert
    assertEquals("Color", actualProductOptionType.getType());
    assertEquals("Friendly Type", actualProductOptionType.getFriendlyType());
  }

  /**
   * Test {@link ProductOptionType#ProductOptionType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ProductOptionType#ProductOptionType(String, String)}
   */
  @Test
  public void testNewProductOptionType_whenType_thenReturnType() {
    // Arrange and Act
    ProductOptionType actualProductOptionType = new ProductOptionType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualProductOptionType.getFriendlyType());
    assertEquals("Type", actualProductOptionType.getType());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and
   * {@link ProductOptionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionType productOptionType = ProductOptionType.BOOLEAN;
    ProductOptionType productOptionType2 = ProductOptionType.BOOLEAN;

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    int expectedHashCodeResult = productOptionType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and
   * {@link ProductOptionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionType productOptionType = new ProductOptionType();
    ProductOptionType productOptionType2 = new ProductOptionType();

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    int expectedHashCodeResult = productOptionType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and
   * {@link ProductOptionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionType productOptionType = new ProductOptionType("BOOLEAN", "Friendly Type");
    ProductOptionType productOptionType2 = ProductOptionType.BOOLEAN;

    // Act and Assert
    assertEquals(productOptionType, productOptionType2);
    int expectedHashCodeResult = productOptionType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionType2.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}, and
   * {@link ProductOptionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionType#equals(Object)}
   *   <li>{@link ProductOptionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionType productOptionType = ProductOptionType.BOOLEAN;

    // Act and Assert
    assertEquals(productOptionType, productOptionType);
    int expectedHashCodeResult = productOptionType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionType.hashCode());
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.COLOR, ProductOptionType.BOOLEAN);
    assertNotEquals(new ProductOptionType(), ProductOptionType.BOOLEAN);
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.BOOLEAN, null);
  }

  /**
   * Test {@link ProductOptionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionType.BOOLEAN, "Different type to ProductOptionType");
  }
}
