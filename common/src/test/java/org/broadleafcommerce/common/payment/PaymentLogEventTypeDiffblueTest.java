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

@ContextConfiguration(classes = {PaymentLogEventType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentLogEventTypeDiffblueTest {
  @Autowired
  private PaymentLogEventType paymentLogEventType;

  /**
   * Test {@link PaymentLogEventType#getInstance(String)}.
   * <p>
   * Method under test: {@link PaymentLogEventType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PaymentLogEventType actualInstance = PaymentLogEventType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogEventType#PaymentLogEventType()}
   *   <li>{@link PaymentLogEventType#getFriendlyType()}
   *   <li>{@link PaymentLogEventType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentLogEventType actualPaymentLogEventType = new PaymentLogEventType();
    String actualFriendlyType = actualPaymentLogEventType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentLogEventType.getType());
  }

  /**
   * Test {@link PaymentLogEventType#PaymentLogEventType(String, String)}.
   * <p>
   * Method under test:
   * {@link PaymentLogEventType#PaymentLogEventType(String, String)}
   */
  @Test
  public void testNewPaymentLogEventType() {
    // Arrange and Act
    PaymentLogEventType actualPaymentLogEventType = new PaymentLogEventType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentLogEventType.getFriendlyType());
    assertEquals("Type", actualPaymentLogEventType.getType());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and
   * {@link PaymentLogEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentLogEventType paymentLogEventType = PaymentLogEventType.FINISHED;
    PaymentLogEventType paymentLogEventType2 = PaymentLogEventType.FINISHED;

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    int expectedHashCodeResult = paymentLogEventType.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and
   * {@link PaymentLogEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentLogEventType paymentLogEventType = new PaymentLogEventType();
    PaymentLogEventType paymentLogEventType2 = new PaymentLogEventType();

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    int expectedHashCodeResult = paymentLogEventType.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and
   * {@link PaymentLogEventType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentLogEventType paymentLogEventType = new PaymentLogEventType("FINISHED", "Friendly Type");
    PaymentLogEventType paymentLogEventType2 = PaymentLogEventType.FINISHED;

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    int expectedHashCodeResult = paymentLogEventType.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and
   * {@link PaymentLogEventType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentLogEventType paymentLogEventType = PaymentLogEventType.FINISHED;

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType);
    int expectedHashCodeResult = paymentLogEventType.hashCode();
    assertEquals(expectedHashCodeResult, paymentLogEventType.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.START, PaymentLogEventType.FINISHED);
    assertNotEquals(new PaymentLogEventType(), PaymentLogEventType.FINISHED);
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.FINISHED, null);
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.FINISHED, "Different type to PaymentLogEventType");
  }
}
