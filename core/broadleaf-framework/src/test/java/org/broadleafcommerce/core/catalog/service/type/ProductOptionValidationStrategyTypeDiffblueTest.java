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
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.core.spec.order.service.workflow.add.ValidateAddRequestActivitySkuSpec;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {ProductOptionValidationStrategyType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductOptionValidationStrategyTypeDiffblueTest {
  @Autowired
  private ProductOptionValidationStrategyType productOptionValidationStrategyType;

  /**
   * Test {@link ProductOptionValidationStrategyType#getInstance(String)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationStrategyType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualInstance = ProductOptionValidationStrategyType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getRank().intValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ProductOptionValidationStrategyType#ProductOptionValidationStrategyType()}
   *   <li>{@link ProductOptionValidationStrategyType#getFriendlyType()}
   *   <li>{@link ProductOptionValidationStrategyType#getRank()}
   *   <li>{@link ProductOptionValidationStrategyType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType = new ProductOptionValidationStrategyType();
    String actualFriendlyType = actualProductOptionValidationStrategyType.getFriendlyType();
    Integer actualRank = actualProductOptionValidationStrategyType.getRank();

    // Assert
    assertNull(actualRank);
    assertNull(actualFriendlyType);
    assertNull(actualProductOptionValidationStrategyType.getType());
  }

  /**
   * Test
   * {@link ProductOptionValidationStrategyType#ProductOptionValidationStrategyType(String, Integer, String)}.
   * <p>
   * Method under test:
   * {@link ProductOptionValidationStrategyType#ProductOptionValidationStrategyType(String, Integer, String)}
   */
  @Test
  public void testNewProductOptionValidationStrategyType() {
    // Arrange and Act
    ProductOptionValidationStrategyType actualProductOptionValidationStrategyType = new ProductOptionValidationStrategyType(
        "Type", 1, "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualProductOptionValidationStrategyType.getFriendlyType());
    assertEquals("Type", actualProductOptionValidationStrategyType.getType());
    assertEquals(1, actualProductOptionValidationStrategyType.getRank().intValue());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and
   * {@link ProductOptionValidationStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = ProductOptionValidationStrategyType.ADD_ITEM;
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 = ProductOptionValidationStrategyType.ADD_ITEM;

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    int expectedHashCodeResult = productOptionValidationStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and
   * {@link ProductOptionValidationStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = ProductOptionValidationStrategyType.NONE;
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 = new ProductOptionValidationStrategyType(
        "NONE", 1, "NONE");

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    int expectedHashCodeResult = productOptionValidationStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and
   * {@link ProductOptionValidationStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = new ProductOptionValidationStrategyType();
    ProductOptionValidationStrategyType productOptionValidationStrategyType2 = new ProductOptionValidationStrategyType();

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType2);
    int expectedHashCodeResult = productOptionValidationStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationStrategyType2.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}, and
   * {@link ProductOptionValidationStrategyType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProductOptionValidationStrategyType#equals(Object)}
   *   <li>{@link ProductOptionValidationStrategyType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProductOptionValidationStrategyType productOptionValidationStrategyType = ProductOptionValidationStrategyType.ADD_ITEM;

    // Act and Assert
    assertEquals(productOptionValidationStrategyType, productOptionValidationStrategyType);
    int expectedHashCodeResult = productOptionValidationStrategyType.hashCode();
    assertEquals(expectedHashCodeResult, productOptionValidationStrategyType.hashCode());
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationStrategyType.NONE, ProductOptionValidationStrategyType.ADD_ITEM);
    assertNotEquals(new ProductOptionValidationStrategyType(), ProductOptionValidationStrategyType.ADD_ITEM);
    assertNotEquals(ProductOptionValidationStrategyType.NONE,
        mock(ValidateAddRequestActivitySkuSpec.CustomValidationStrategyType.class));
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationStrategyType.ADD_ITEM, null);
  }

  /**
   * Test {@link ProductOptionValidationStrategyType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProductOptionValidationStrategyType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ProductOptionValidationStrategyType.ADD_ITEM,
        "Different type to ProductOptionValidationStrategyType");
  }
}
