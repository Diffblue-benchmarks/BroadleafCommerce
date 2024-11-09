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

@ContextConfiguration(classes = {PaymentDeclineType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentDeclineTypeDiffblueTest {
  @Autowired
  private PaymentDeclineType paymentDeclineType;

  /**
   * Test {@link PaymentDeclineType#getInstance(String)}.
   * <p>
   * Method under test: {@link PaymentDeclineType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PaymentDeclineType actualInstance = PaymentDeclineType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentDeclineType#PaymentDeclineType()}
   *   <li>{@link PaymentDeclineType#getFriendlyType()}
   *   <li>{@link PaymentDeclineType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentDeclineType actualPaymentDeclineType = new PaymentDeclineType();
    String actualFriendlyType = actualPaymentDeclineType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentDeclineType.getType());
  }

  /**
   * Test {@link PaymentDeclineType#PaymentDeclineType(String, String)}.
   * <p>
   * Method under test:
   * {@link PaymentDeclineType#PaymentDeclineType(String, String)}
   */
  @Test
  public void testNewPaymentDeclineType() {
    // Arrange and Act
    PaymentDeclineType actualPaymentDeclineType = new PaymentDeclineType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentDeclineType.getFriendlyType());
    assertEquals("Type", actualPaymentDeclineType.getType());
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}, and
   * {@link PaymentDeclineType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentDeclineType#equals(Object)}
   *   <li>{@link PaymentDeclineType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentDeclineType paymentDeclineType = PaymentDeclineType.HARD;
    PaymentDeclineType paymentDeclineType2 = PaymentDeclineType.HARD;

    // Act and Assert
    assertEquals(paymentDeclineType, paymentDeclineType2);
    int expectedHashCodeResult = paymentDeclineType.hashCode();
    assertEquals(expectedHashCodeResult, paymentDeclineType2.hashCode());
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}, and
   * {@link PaymentDeclineType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentDeclineType#equals(Object)}
   *   <li>{@link PaymentDeclineType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentDeclineType paymentDeclineType = new PaymentDeclineType();
    PaymentDeclineType paymentDeclineType2 = new PaymentDeclineType();

    // Act and Assert
    assertEquals(paymentDeclineType, paymentDeclineType2);
    int expectedHashCodeResult = paymentDeclineType.hashCode();
    assertEquals(expectedHashCodeResult, paymentDeclineType2.hashCode());
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}, and
   * {@link PaymentDeclineType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentDeclineType#equals(Object)}
   *   <li>{@link PaymentDeclineType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentDeclineType paymentDeclineType = new PaymentDeclineType("HARD", "Friendly Type");
    PaymentDeclineType paymentDeclineType2 = PaymentDeclineType.HARD;

    // Act and Assert
    assertEquals(paymentDeclineType, paymentDeclineType2);
    int expectedHashCodeResult = paymentDeclineType.hashCode();
    assertEquals(expectedHashCodeResult, paymentDeclineType2.hashCode());
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}, and
   * {@link PaymentDeclineType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentDeclineType#equals(Object)}
   *   <li>{@link PaymentDeclineType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentDeclineType paymentDeclineType = PaymentDeclineType.HARD;

    // Act and Assert
    assertEquals(paymentDeclineType, paymentDeclineType);
    int expectedHashCodeResult = paymentDeclineType.hashCode();
    assertEquals(expectedHashCodeResult, paymentDeclineType.hashCode());
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentDeclineType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentDeclineType.SOFT, PaymentDeclineType.HARD);
    assertNotEquals(new PaymentDeclineType(), PaymentDeclineType.HARD);
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentDeclineType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentDeclineType.HARD, null);
  }

  /**
   * Test {@link PaymentDeclineType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentDeclineType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentDeclineType.HARD, "Different type to PaymentDeclineType");
  }
}
