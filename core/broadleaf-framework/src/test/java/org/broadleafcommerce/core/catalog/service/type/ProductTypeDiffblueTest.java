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
package org.broadleafcommerce.core.catalog.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductTypeDiffblueTest {
  @Autowired
  private ProductType productType;

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductType productType = ProductType.BUNDLE;
    ProductType productType2 = ProductType.BUNDLE;

    // Act and Assert
    assertEquals(productType, productType2);
    int expectedHashCodeResult = productType.hashCode();
    assertEquals(expectedHashCodeResult, productType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductType productType = new ProductType();
    ProductType productType2 = new ProductType();

    // Act and Assert
    assertEquals(productType, productType2);
    int expectedHashCodeResult = productType.hashCode();
    assertEquals(expectedHashCodeResult, productType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductType productType = new ProductType("org.broadleafcommerce.core.catalog.domain.ProductBundle",
        "Friendly Type");
    ProductType productType2 = ProductType.BUNDLE;

    // Act and Assert
    assertEquals(productType, productType2);
    int expectedHashCodeResult = productType.hashCode();
    assertEquals(expectedHashCodeResult, productType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductType#equals(Object)}
   *   <li>{@link ProductType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductType productType = ProductType.BUNDLE;

    // Act and Assert
    assertEquals(productType, productType);
    int expectedHashCodeResult = productType.hashCode();
    assertEquals(expectedHashCodeResult, productType.hashCode());
  }

  /**
   * Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.PRODUCT, ProductType.BUNDLE);
    assertNotEquals(new ProductType(), ProductType.BUNDLE);
  }

  /**
   * Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.BUNDLE, null);
  }

  /**
   * Method under test: {@link ProductType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductType.BUNDLE, "Different type to ProductType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProductType#ProductType()}
   *   <li>{@link ProductType#getFriendlyType()}
   *   <li>{@link ProductType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductType actualProductType = new ProductType();
    String actualFriendlyType = actualProductType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductType.getType());
  }

  /**
   * Method under test: {@link ProductType#ProductType(String, String)}
   */
  @Test
  public void testNewProductType() {
    // Arrange and Act
    ProductType actualProductType = new ProductType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualProductType.getFriendlyType());
    assertEquals("Type", actualProductType.getType());
  }
}
