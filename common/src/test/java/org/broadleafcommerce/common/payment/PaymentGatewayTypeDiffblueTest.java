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

@ContextConfiguration(classes = {PaymentGatewayType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayTypeDiffblueTest {
  @Autowired
  private PaymentGatewayType paymentGatewayType;

  /**
   * Test {@link PaymentGatewayType#getInstance(String)}.
   * <p>
   * Method under test: {@link PaymentGatewayType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PaymentGatewayType actualInstance = PaymentGatewayType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentGatewayType#PaymentGatewayType()}
   *   <li>{@link PaymentGatewayType#getFriendlyType()}
   *   <li>{@link PaymentGatewayType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentGatewayType actualPaymentGatewayType = new PaymentGatewayType();
    String actualFriendlyType = actualPaymentGatewayType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentGatewayType.getType());
  }

  /**
   * Test {@link PaymentGatewayType#PaymentGatewayType(String, String)}.
   * <p>
   * Method under test:
   * {@link PaymentGatewayType#PaymentGatewayType(String, String)}
   */
  @Test
  public void testNewPaymentGatewayType() {
    // Arrange and Act
    PaymentGatewayType actualPaymentGatewayType = new PaymentGatewayType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentGatewayType.getFriendlyType());
    assertEquals("Type", actualPaymentGatewayType.getType());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and
   * {@link PaymentGatewayType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentGatewayType paymentGatewayType = PaymentGatewayType.PASSTHROUGH;
    PaymentGatewayType paymentGatewayType2 = PaymentGatewayType.PASSTHROUGH;

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    int expectedHashCodeResult = paymentGatewayType.hashCode();
    assertEquals(expectedHashCodeResult, paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and
   * {@link PaymentGatewayType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    PaymentGatewayType paymentGatewayType2 = new PaymentGatewayType();

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    int expectedHashCodeResult = paymentGatewayType.hashCode();
    assertEquals(expectedHashCodeResult, paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and
   * {@link PaymentGatewayType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType("Passthrough", "Friendly Type");
    PaymentGatewayType paymentGatewayType2 = PaymentGatewayType.PASSTHROUGH;

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    int expectedHashCodeResult = paymentGatewayType.hashCode();
    assertEquals(expectedHashCodeResult, paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and
   * {@link PaymentGatewayType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentGatewayType paymentGatewayType = PaymentGatewayType.PASSTHROUGH;

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType);
    int expectedHashCodeResult = paymentGatewayType.hashCode();
    assertEquals(expectedHashCodeResult, paymentGatewayType.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.TEMPORARY, PaymentGatewayType.PASSTHROUGH);
    assertNotEquals(new PaymentGatewayType(), PaymentGatewayType.PASSTHROUGH);
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.PASSTHROUGH, null);
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.PASSTHROUGH, "Different type to PaymentGatewayType");
  }
}
