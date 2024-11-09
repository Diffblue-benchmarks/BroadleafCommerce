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
   * Test {@link PaymentTransactionType#getInstance(String)}.
   * <p>
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
   * Test getters and setters.
   * <p>
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
   * Test {@link PaymentTransactionType#PaymentTransactionType(String, String)}.
   * <ul>
   *   <li>When {@code Capture}.</li>
   *   <li>Then return Type is {@code Capture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentTransactionType#PaymentTransactionType(String, String)}
   */
  @Test
  public void testNewPaymentTransactionType_whenCapture_thenReturnTypeIsCapture() {
    // Arrange and Act
    PaymentTransactionType actualPaymentTransactionType = new PaymentTransactionType("Capture", "Friendly Type");

    // Assert
    assertEquals("Capture", actualPaymentTransactionType.getType());
    assertEquals("Friendly Type", actualPaymentTransactionType.getFriendlyType());
  }

  /**
   * Test {@link PaymentTransactionType#PaymentTransactionType(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentTransactionType#PaymentTransactionType(String, String)}
   */
  @Test
  public void testNewPaymentTransactionType_whenType_thenReturnType() {
    // Arrange and Act
    PaymentTransactionType actualPaymentTransactionType = new PaymentTransactionType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentTransactionType.getFriendlyType());
    assertEquals("Type", actualPaymentTransactionType.getType());
  }

  /**
   * Test {@link PaymentTransactionType#equals(Object)}, and
   * {@link PaymentTransactionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentTransactionType#equals(Object)}, and
   * {@link PaymentTransactionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentTransactionType#equals(Object)}, and
   * {@link PaymentTransactionType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentTransactionType#equals(Object)}, and
   * {@link PaymentTransactionType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link PaymentTransactionType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE_AND_CAPTURE, PaymentTransactionType.AUTHORIZE);
    assertNotEquals(new PaymentTransactionType(), PaymentTransactionType.AUTHORIZE);
  }

  /**
   * Test {@link PaymentTransactionType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE, null);
  }

  /**
   * Test {@link PaymentTransactionType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentTransactionType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentTransactionType.AUTHORIZE, "Different type to PaymentTransactionType");
  }
}
