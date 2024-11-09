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

@ContextConfiguration(classes = {PaymentAdditionalFieldType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentAdditionalFieldTypeDiffblueTest {
  @Autowired
  private PaymentAdditionalFieldType paymentAdditionalFieldType;

  /**
   * Test {@link PaymentAdditionalFieldType#getInstance(String)}.
   * <p>
   * Method under test: {@link PaymentAdditionalFieldType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    PaymentAdditionalFieldType actualInstance = PaymentAdditionalFieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#PaymentAdditionalFieldType()}
   *   <li>{@link PaymentAdditionalFieldType#getFriendlyType()}
   *   <li>{@link PaymentAdditionalFieldType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentAdditionalFieldType actualPaymentAdditionalFieldType = new PaymentAdditionalFieldType();
    String actualFriendlyType = actualPaymentAdditionalFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentAdditionalFieldType.getType());
  }

  /**
   * Test
   * {@link PaymentAdditionalFieldType#PaymentAdditionalFieldType(String, String)}.
   * <p>
   * Method under test:
   * {@link PaymentAdditionalFieldType#PaymentAdditionalFieldType(String, String)}
   */
  @Test
  public void testNewPaymentAdditionalFieldType() {
    // Arrange and Act
    PaymentAdditionalFieldType actualPaymentAdditionalFieldType = new PaymentAdditionalFieldType("Type",
        "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentAdditionalFieldType.getFriendlyType());
    assertEquals("Type", actualPaymentAdditionalFieldType.getType());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and
   * {@link PaymentAdditionalFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;
    PaymentAdditionalFieldType paymentAdditionalFieldType2 = PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    int expectedHashCodeResult = paymentAdditionalFieldType.hashCode();
    assertEquals(expectedHashCodeResult, paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and
   * {@link PaymentAdditionalFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = PaymentAdditionalFieldType.ACCOUNT_TYPE;
    PaymentAdditionalFieldType paymentAdditionalFieldType2 = new PaymentAdditionalFieldType("ACCOUNT_TYPE",
        "ACCOUNT_TYPE");

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    int expectedHashCodeResult = paymentAdditionalFieldType.hashCode();
    assertEquals(expectedHashCodeResult, paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and
   * {@link PaymentAdditionalFieldType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = new PaymentAdditionalFieldType();
    PaymentAdditionalFieldType paymentAdditionalFieldType2 = new PaymentAdditionalFieldType();

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    int expectedHashCodeResult = paymentAdditionalFieldType.hashCode();
    assertEquals(expectedHashCodeResult, paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and
   * {@link PaymentAdditionalFieldType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType);
    int expectedHashCodeResult = paymentAdditionalFieldType.hashCode();
    assertEquals(expectedHashCodeResult, paymentAdditionalFieldType.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentAdditionalFieldType.ACCOUNT_TYPE, PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM);
    assertNotEquals(new PaymentAdditionalFieldType(), PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM);
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM, null);
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM, "Different type to PaymentAdditionalFieldType");
  }
}
