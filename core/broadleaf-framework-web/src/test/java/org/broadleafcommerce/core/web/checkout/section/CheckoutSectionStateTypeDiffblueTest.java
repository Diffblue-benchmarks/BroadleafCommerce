/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CheckoutSectionStateTypeDiffblueTest {
  /**
   * Test {@link CheckoutSectionStateType#getInstance(String)}.
   * <p>
   * Method under test: {@link CheckoutSectionStateType#getInstance(String)}
   */
  @Test
  @DisplayName("Test getInstance(String)")
  void testGetInstance() {
    // Arrange and Act
    CheckoutSectionStateType actualInstance = CheckoutSectionStateType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#CheckoutSectionStateType()}
   *   <li>{@link CheckoutSectionStateType#getFriendlyType()}
   *   <li>{@link CheckoutSectionStateType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType = new CheckoutSectionStateType();
    String actualFriendlyType = actualCheckoutSectionStateType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutSectionStateType.getType());
  }

  /**
   * Test
   * {@link CheckoutSectionStateType#CheckoutSectionStateType(String, String)}.
   * <p>
   * Method under test:
   * {@link CheckoutSectionStateType#CheckoutSectionStateType(String, String)}
   */
  @Test
  @DisplayName("Test new CheckoutSectionStateType(String, String)")
  void testNewCheckoutSectionStateType() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType = new CheckoutSectionStateType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCheckoutSectionStateType.getFriendlyType());
    assertEquals("Type", actualCheckoutSectionStateType.getType());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}, and
   * {@link CheckoutSectionStateType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link CheckoutSectionStateType#equals(Object)}, and
   * {@link CheckoutSectionStateType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link CheckoutSectionStateType#equals(Object)}, and
   * {@link CheckoutSectionStateType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link CheckoutSectionStateType#equals(Object)}, and
   * {@link CheckoutSectionStateType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType.hashCode());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.INACTIVE, CheckoutSectionStateType.FORM);
    assertNotEquals(new CheckoutSectionStateType(), CheckoutSectionStateType.FORM);
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, null);
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, "Different type to CheckoutSectionStateType");
  }
}
