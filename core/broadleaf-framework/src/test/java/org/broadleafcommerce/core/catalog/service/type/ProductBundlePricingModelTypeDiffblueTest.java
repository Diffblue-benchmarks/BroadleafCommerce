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

@ContextConfiguration(classes = {ProductBundlePricingModelType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductBundlePricingModelTypeDiffblueTest {
  @Autowired
  private ProductBundlePricingModelType productBundlePricingModelType;

  /**
   * Test {@link ProductBundlePricingModelType#getInstance(String)}.
   * <p>
   * Method under test: {@link ProductBundlePricingModelType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ProductBundlePricingModelType actualInstance = ProductBundlePricingModelType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#ProductBundlePricingModelType()}
   *   <li>{@link ProductBundlePricingModelType#getFriendlyType()}
   *   <li>{@link ProductBundlePricingModelType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductBundlePricingModelType actualProductBundlePricingModelType = new ProductBundlePricingModelType();
    String actualFriendlyType = actualProductBundlePricingModelType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductBundlePricingModelType.getType());
  }

  /**
   * Test
   * {@link ProductBundlePricingModelType#ProductBundlePricingModelType(String, String)}.
   * <p>
   * Method under test:
   * {@link ProductBundlePricingModelType#ProductBundlePricingModelType(String, String)}
   */
  @Test
  public void testNewProductBundlePricingModelType() {
    // Arrange and Act
    ProductBundlePricingModelType actualProductBundlePricingModelType = new ProductBundlePricingModelType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualProductBundlePricingModelType.getFriendlyType());
    assertEquals("Type", actualProductBundlePricingModelType.getType());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and
   * {@link ProductBundlePricingModelType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType = ProductBundlePricingModelType.BUNDLE;
    ProductBundlePricingModelType productBundlePricingModelType2 = ProductBundlePricingModelType.BUNDLE;

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    int expectedHashCodeResult = productBundlePricingModelType.hashCode();
    assertEquals(expectedHashCodeResult, productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and
   * {@link ProductBundlePricingModelType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType = new ProductBundlePricingModelType();
    ProductBundlePricingModelType productBundlePricingModelType2 = new ProductBundlePricingModelType();

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    int expectedHashCodeResult = productBundlePricingModelType.hashCode();
    assertEquals(expectedHashCodeResult, productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and
   * {@link ProductBundlePricingModelType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType = new ProductBundlePricingModelType("BUNDLE",
        "Friendly Type");
    ProductBundlePricingModelType productBundlePricingModelType2 = ProductBundlePricingModelType.BUNDLE;

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType2);
    int expectedHashCodeResult = productBundlePricingModelType.hashCode();
    assertEquals(expectedHashCodeResult, productBundlePricingModelType2.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}, and
   * {@link ProductBundlePricingModelType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductBundlePricingModelType#equals(Object)}
   *   <li>{@link ProductBundlePricingModelType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductBundlePricingModelType productBundlePricingModelType = ProductBundlePricingModelType.BUNDLE;

    // Act and Assert
    assertEquals(productBundlePricingModelType, productBundlePricingModelType);
    int expectedHashCodeResult = productBundlePricingModelType.hashCode();
    assertEquals(expectedHashCodeResult, productBundlePricingModelType.hashCode());
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductBundlePricingModelType.ITEM_SUM, ProductBundlePricingModelType.BUNDLE);
    assertNotEquals(new ProductBundlePricingModelType(), ProductBundlePricingModelType.BUNDLE);
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductBundlePricingModelType.BUNDLE, null);
  }

  /**
   * Test {@link ProductBundlePricingModelType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductBundlePricingModelType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductBundlePricingModelType.BUNDLE, "Different type to ProductBundlePricingModelType");
  }
}
