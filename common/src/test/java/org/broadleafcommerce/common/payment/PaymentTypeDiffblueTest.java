/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentTypeDiffblueTest {
  @Autowired
  private PaymentType paymentType;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentType#PaymentType()}
   *   <li>{@link PaymentType#getFriendlyType()}
   *   <li>{@link PaymentType#getIsFinalPayment()}
   *   <li>{@link PaymentType#getType()}
   *   <li>{@link PaymentType#isCreditCardType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType();
    String actualFriendlyType = actualPaymentType.getFriendlyType();
    boolean actualIsFinalPayment = actualPaymentType.getIsFinalPayment();
    String actualType = actualPaymentType.getType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualType);
    assertFalse(actualIsFinalPayment);
    assertFalse(actualPaymentType.isCreditCardType());
  }

  /**
   * Test {@link PaymentType#PaymentType(String, String)}.
   * <p>
   * Method under test: {@link PaymentType#PaymentType(String, String)}
   */
  @Test
  public void testNewPaymentType() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentType.getFriendlyType());
    assertEquals("Type", actualPaymentType.getType());
    assertFalse(actualPaymentType.getIsFinalPayment());
    assertFalse(actualPaymentType.isCreditCardType());
  }

  /**
   * Test {@link PaymentType#PaymentType(String, String, boolean)}.
   * <p>
   * Method under test: {@link PaymentType#PaymentType(String, String, boolean)}
   */
  @Test
  public void testNewPaymentType2() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type", true);

    // Assert
    assertEquals("Friendly Type", actualPaymentType.getFriendlyType());
    assertEquals("Type", actualPaymentType.getType());
    assertFalse(actualPaymentType.isCreditCardType());
    assertTrue(actualPaymentType.getIsFinalPayment());
  }

  /**
   * Test {@link PaymentType#PaymentType(String, String, boolean, boolean)}.
   * <p>
   * Method under test:
   * {@link PaymentType#PaymentType(String, String, boolean, boolean)}
   */
  @Test
  public void testNewPaymentType3() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type", true, true);

    // Assert
    assertEquals("Friendly Type", actualPaymentType.getFriendlyType());
    assertEquals("Type", actualPaymentType.getType());
    assertTrue(actualPaymentType.getIsFinalPayment());
    assertTrue(actualPaymentType.isCreditCardType());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentType paymentType = PaymentType.APPLE_PAY;
    PaymentType paymentType2 = PaymentType.APPLE_PAY;

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    int expectedHashCodeResult = paymentType.hashCode();
    assertEquals(expectedHashCodeResult, paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentType paymentType = PaymentType.BANK_ACCOUNT;
    PaymentType paymentType2 = new PaymentType("BANK_ACCOUNT", "BANK_ACCOUNT");

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    int expectedHashCodeResult = paymentType.hashCode();
    assertEquals(expectedHashCodeResult, paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentType paymentType = new PaymentType();
    PaymentType paymentType2 = new PaymentType();

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    int expectedHashCodeResult = paymentType.hashCode();
    assertEquals(expectedHashCodeResult, paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentType paymentType = PaymentType.APPLE_PAY;

    // Act and Assert
    assertEquals(paymentType, paymentType);
    int expectedHashCodeResult = paymentType.hashCode();
    assertEquals(expectedHashCodeResult, paymentType.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.BANK_ACCOUNT, PaymentType.APPLE_PAY);
    assertNotEquals(new PaymentType(), PaymentType.APPLE_PAY);
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.APPLE_PAY, null);
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.APPLE_PAY, "Different type to PaymentType");
  }
}
