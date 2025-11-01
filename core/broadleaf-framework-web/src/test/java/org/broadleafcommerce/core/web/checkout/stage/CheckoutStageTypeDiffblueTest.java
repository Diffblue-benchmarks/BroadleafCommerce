/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.checkout.stage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class CheckoutStageTypeDiffblueTest {
  /**
   * Method under test: {@link CheckoutStageType#getInstance(String)}
   */
  @Test
  void testGetInstance() {
    // Arrange and Act
    CheckoutStageType actualInstance = CheckoutStageType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutStageType checkoutStageType = CheckoutStageType.PAYMENT_INFO;
    CheckoutStageType checkoutStageType2 = CheckoutStageType.PAYMENT_INFO;

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    int expectedHashCodeResult = checkoutStageType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutStageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutStageType checkoutStageType = new CheckoutStageType();
    CheckoutStageType checkoutStageType2 = new CheckoutStageType();

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    int expectedHashCodeResult = checkoutStageType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutStageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutStageType checkoutStageType = new CheckoutStageType("PAYMENT_INFO", "Friendly Type", 1);
    CheckoutStageType checkoutStageType2 = CheckoutStageType.PAYMENT_INFO;

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    int expectedHashCodeResult = checkoutStageType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutStageType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutStageType checkoutStageType = CheckoutStageType.PAYMENT_INFO;

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType);
    int expectedHashCodeResult = checkoutStageType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutStageType.hashCode());
  }

  /**
   * Method under test: {@link CheckoutStageType#compareTo(CheckoutStageType)}
   */
  @Test
  void testCompareTo() {
    // Arrange, Act and Assert
    assertEquals(0, CheckoutStageType.PAYMENT_INFO.compareTo(CheckoutStageType.PAYMENT_INFO));
  }

  /**
   * Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.REVIEW, CheckoutStageType.PAYMENT_INFO);
    assertNotEquals(new CheckoutStageType(), CheckoutStageType.PAYMENT_INFO);
  }

  /**
   * Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.PAYMENT_INFO, null);
  }

  /**
   * Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.PAYMENT_INFO, "Different type to CheckoutStageType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutStageType#CheckoutStageType()}
   *   <li>{@link CheckoutStageType#setOrder(int)}
   *   <li>{@link CheckoutStageType#getFriendlyType()}
   *   <li>{@link CheckoutStageType#getOrder()}
   *   <li>{@link CheckoutStageType#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CheckoutStageType actualCheckoutStageType = new CheckoutStageType();
    actualCheckoutStageType.setOrder(1);
    actualCheckoutStageType.getFriendlyType();
    int actualOrder = actualCheckoutStageType.getOrder();
    actualCheckoutStageType.getType();

    // Assert that nothing has changed
    assertEquals(1, actualOrder);
  }

  /**
   * Method under test:
   * {@link CheckoutStageType#CheckoutStageType(String, String, int)}
   */
  @Test
  void testNewCheckoutStageType() {
    // Arrange and Act
    CheckoutStageType actualCheckoutStageType = new CheckoutStageType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualCheckoutStageType.getFriendlyType());
    assertEquals("Type", actualCheckoutStageType.getType());
    assertEquals(1, actualCheckoutStageType.getOrder());
  }
}
