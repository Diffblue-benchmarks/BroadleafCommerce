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

class CheckoutSectionViewTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionViewType#CheckoutSectionViewType()}
   *   <li>{@link CheckoutSectionViewType#getFriendlyType()}
   *   <li>{@link CheckoutSectionViewType#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    CheckoutSectionViewType actualCheckoutSectionViewType = new CheckoutSectionViewType();
    String actualFriendlyType = actualCheckoutSectionViewType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutSectionViewType.getType());
  }

  /**
   * Test {@link CheckoutSectionViewType#CheckoutSectionViewType(String, String)}.
   * <p>
   * Method under test:
   * {@link CheckoutSectionViewType#CheckoutSectionViewType(String, String)}
   */
  @Test
  @DisplayName("Test new CheckoutSectionViewType(String, String)")
  void testNewCheckoutSectionViewType() {
    // Arrange and Act
    CheckoutSectionViewType actualCheckoutSectionViewType = new CheckoutSectionViewType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualCheckoutSectionViewType.getFriendlyType());
    assertEquals("Type", actualCheckoutSectionViewType.getType());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and
   * {@link CheckoutSectionViewType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = CheckoutSectionViewType.BILLING_INFO;
    CheckoutSectionViewType checkoutSectionViewType2 = CheckoutSectionViewType.BILLING_INFO;

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    int expectedHashCodeResult = checkoutSectionViewType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and
   * {@link CheckoutSectionViewType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = new CheckoutSectionViewType();
    CheckoutSectionViewType checkoutSectionViewType2 = new CheckoutSectionViewType();

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    int expectedHashCodeResult = checkoutSectionViewType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and
   * {@link CheckoutSectionViewType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = new CheckoutSectionViewType("BILLING_INFO", "Friendly Type");
    CheckoutSectionViewType checkoutSectionViewType2 = CheckoutSectionViewType.BILLING_INFO;

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    int expectedHashCodeResult = checkoutSectionViewType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and
   * {@link CheckoutSectionViewType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = CheckoutSectionViewType.BILLING_INFO;

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType);
    int expectedHashCodeResult = checkoutSectionViewType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionViewType.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionViewType.ORDER_INFO, CheckoutSectionViewType.BILLING_INFO);
    assertNotEquals(new CheckoutSectionViewType(), CheckoutSectionViewType.BILLING_INFO);
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionViewType.BILLING_INFO, null);
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionViewType.BILLING_INFO, "Different type to CheckoutSectionViewType");
  }
}
