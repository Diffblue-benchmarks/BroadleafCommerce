/*-
 * #%L
 * BroadleafCommerce Common Libraries
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
package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentTransactionType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentTransactionTypeDiffblueTest {
  @Autowired
  private PaymentTransactionType paymentTransactionType;

  /**
   * Method under test: {@link PaymentTransactionType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PaymentTransactionType actualInstance = PaymentTransactionType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionType#equals(Object)}
   *   <li>{@link PaymentTransactionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentTransactionType paymentTransactionType = PaymentTransactionType.AUTHORIZE;
    PaymentTransactionType paymentTransactionType2 = PaymentTransactionType.AUTHORIZE;

    // Act and Assert
    assertEquals(paymentTransactionType, paymentTransactionType2);
    int expectedHashCodeResult = paymentTransactionType.hashCode();
    assertEquals(expectedHashCodeResult, paymentTransactionType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionType#equals(Object)}
   *   <li>{@link PaymentTransactionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentTransactionType paymentTransactionType = new PaymentTransactionType();
    PaymentTransactionType paymentTransactionType2 = new PaymentTransactionType();

    // Act and Assert
    assertEquals(paymentTransactionType, paymentTransactionType2);
    int expectedHashCodeResult = paymentTransactionType.hashCode();
    assertEquals(expectedHashCodeResult, paymentTransactionType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionType#equals(Object)}
   *   <li>{@link PaymentTransactionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentTransactionType paymentTransactionType = new PaymentTransactionType("AUTHORIZE", "Friendly Type");
    PaymentTransactionType paymentTransactionType2 = PaymentTransactionType.AUTHORIZE;

    // Act and Assert
    assertEquals(paymentTransactionType, paymentTransactionType2);
    int expectedHashCodeResult = paymentTransactionType.hashCode();
    assertEquals(expectedHashCodeResult, paymentTransactionType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionType#equals(Object)}
   *   <li>{@link PaymentTransactionType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentTransactionType paymentTransactionType = PaymentTransactionType.AUTHORIZE;

    // Act and Assert
    assertEquals(paymentTransactionType, paymentTransactionType);
    int expectedHashCodeResult = paymentTransactionType.hashCode();
    assertEquals(expectedHashCodeResult, paymentTransactionType.hashCode());
  }

  /**
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE_AND_CAPTURE, PaymentTransactionType.AUTHORIZE);
    assertNotEquals(new PaymentTransactionType(), PaymentTransactionType.AUTHORIZE);
  }

  /**
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE, null);
  }

  /**
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE, "Different type to PaymentTransactionType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentTransactionType#PaymentTransactionType()}
   *   <li>{@link PaymentTransactionType#getFriendlyType()}
   *   <li>{@link PaymentTransactionType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentTransactionType actualPaymentTransactionType = new PaymentTransactionType();
    String actualFriendlyType = actualPaymentTransactionType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentTransactionType.getType());
  }

  /**
   * Method under test:
   * {@link PaymentTransactionType#PaymentTransactionType(String, String)}
   */
  @Test
  public void testNewPaymentTransactionType() {
    // Arrange and Act
    PaymentTransactionType actualPaymentTransactionType = new PaymentTransactionType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentTransactionType.getFriendlyType());
    assertEquals("Type", actualPaymentTransactionType.getType());
  }

  /**
   * Method under test:
   * {@link PaymentTransactionType#PaymentTransactionType(String, String)}
   */
  @Test
  public void testNewPaymentTransactionType2() {
    // Arrange and Act
    PaymentTransactionType actualPaymentTransactionType = new PaymentTransactionType("Capture", "Friendly Type");

    // Assert
    assertEquals("Capture", actualPaymentTransactionType.getType());
    assertEquals("Friendly Type", actualPaymentTransactionType.getFriendlyType());
  }
}
