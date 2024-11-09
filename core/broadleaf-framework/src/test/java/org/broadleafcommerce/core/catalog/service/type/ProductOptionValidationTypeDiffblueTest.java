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

@ContextConfiguration(classes = {ProductOptionValidationType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValidationTypeDiffblueTest {
  @Autowired
  private ProductOptionValidationType productOptionValidationType;

  /**
   * Test {@link ProductOptionValidationType#getInstance(String)}.
   * <p>
   * Method under test: {@link ProductOptionValidationType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionValidationType actualInstance = ProductOptionValidationType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationType#ProductOptionValidationType()}
   *   <li>{@link ProductOptionValidationType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType = new ProductOptionValidationType();
    String actualFriendlyType = actualProductOptionValidationType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionValidationType.getType());
  }

  /**
   * Test
   * {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationType#ProductOptionValidationType(String, String)}
   */
  @Test
  public void testNewProductOptionValidationType() {
    // Arrange and Act
    ProductOptionValidationType actualProductOptionValidationType = new ProductOptionValidationType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualProductOptionValidationType.getFriendlyType());
    assertEquals("Type", actualProductOptionValidationType.getType());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and
   * {@link ProductOptionValidationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = ProductOptionValidationType.REGEX;
    ProductOptionValidationType productOptionValidationType2 = ProductOptionValidationType.REGEX;

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    int expectedHashCodeResult = productOptionValidationType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and
   * {@link ProductOptionValidationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = new ProductOptionValidationType("REGEX", "Friendly Type");
    ProductOptionValidationType productOptionValidationType2 = ProductOptionValidationType.REGEX;

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    int expectedHashCodeResult = productOptionValidationType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and
   * {@link ProductOptionValidationType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = new ProductOptionValidationType();
    ProductOptionValidationType productOptionValidationType2 = new ProductOptionValidationType();

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType2);
    int expectedHashCodeResult = productOptionValidationType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}, and
   * {@link ProductOptionValidationType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationType#equals(Object)}
   *   <li>{@link ProductOptionValidationType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValidationType productOptionValidationType = ProductOptionValidationType.REGEX;

    // Act and Assert
    assertEquals(productOptionValidationType, productOptionValidationType);
    int expectedHashCodeResult = productOptionValidationType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationType.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProductOptionValidationType("Type", "Friendly Type"), ProductOptionValidationType.REGEX);
    assertNotEquals(new ProductOptionValidationType(), ProductOptionValidationType.REGEX);
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationType.REGEX, null);
  }

  /**
   * Test {@link ProductOptionValidationType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationType.REGEX, "Different type to ProductOptionValidationType");
  }
}
