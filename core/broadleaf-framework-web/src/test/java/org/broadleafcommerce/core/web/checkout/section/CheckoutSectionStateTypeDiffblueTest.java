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
package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class CheckoutSectionStateTypeDiffblueTest {
  /**
   * Method under test: {@link CheckoutSectionStateType#getInstance(String)}
   */
  @Test
  void testGetInstance() {
    // Arrange and Act
    CheckoutSectionStateType actualInstance = CheckoutSectionStateType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.FORM;
    CheckoutSectionStateType checkoutSectionStateType2 = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = new CheckoutSectionStateType();
    CheckoutSectionStateType checkoutSectionStateType2 = new CheckoutSectionStateType();

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = new CheckoutSectionStateType("FORM", "Friendly Type");
    CheckoutSectionStateType checkoutSectionStateType2 = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType.hashCode());
  }

  /**
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.INACTIVE, CheckoutSectionStateType.FORM);
    assertNotEquals(new CheckoutSectionStateType(), CheckoutSectionStateType.FORM);
  }

  /**
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, null);
  }

  /**
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, "Different type to CheckoutSectionStateType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#CheckoutSectionStateType()}
   *   <li>{@link CheckoutSectionStateType#getFriendlyType()}
   *   <li>{@link CheckoutSectionStateType#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType = new CheckoutSectionStateType();
    String actualFriendlyType = actualCheckoutSectionStateType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutSectionStateType.getType());
  }

  /**
   * Method under test:
   * {@link CheckoutSectionStateType#CheckoutSectionStateType(String, String)}
   */
  @Test
  void testNewCheckoutSectionStateType() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType = new CheckoutSectionStateType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCheckoutSectionStateType.getFriendlyType());
    assertEquals("Type", actualCheckoutSectionStateType.getType());
  }
}
