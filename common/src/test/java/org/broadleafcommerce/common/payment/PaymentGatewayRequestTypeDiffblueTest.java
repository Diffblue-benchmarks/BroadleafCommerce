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
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentGatewayRequestType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentGatewayRequestTypeDiffblueTest {
  @Autowired private PaymentGatewayRequestType paymentGatewayRequestType;

  /**
   * Test {@link PaymentGatewayRequestType#getInstance(String)}.
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentGatewayRequestType PaymentGatewayRequestType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    PaymentGatewayRequestType actualInstance = PaymentGatewayRequestType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#PaymentGatewayRequestType()}
   *   <li>{@link PaymentGatewayRequestType#getTypes()}
   *   <li>{@link PaymentGatewayRequestType#getFriendlyType()}
   *   <li>{@link PaymentGatewayRequestType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentGatewayRequestType.<init>()",
    "String PaymentGatewayRequestType.getFriendlyType()",
    "String PaymentGatewayRequestType.getType()",
    "Map PaymentGatewayRequestType.getTypes()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    PaymentGatewayRequestType actualPaymentGatewayRequestType = new PaymentGatewayRequestType();
    Map<String, PaymentGatewayRequestType> actualTypes = actualPaymentGatewayRequestType.getTypes();
    String actualFriendlyType = actualPaymentGatewayRequestType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentGatewayRequestType.getType());
    assertEquals(4, actualTypes.size());
    assertSame(
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR,
        actualTypes.get("CREATE_CUSTOMER_PAYMENT_TR"));
    assertSame(
        PaymentGatewayRequestType.DETACHED_CREDIT_REFUND,
        actualTypes.get("DETACHED_CREDIT_REFUND"));
    assertSame(
        PaymentGatewayRequestType.MANUAL_AUTHORIZATION, actualTypes.get("MANUAL_AUTHORIZATION"));
    assertSame(
        PaymentGatewayRequestType.UPDATE_CUSTOMER_PAYMENT_TR,
        actualTypes.get("UPDATE_CUSTOMER_PAYMENT_TR"));
  }

  /**
   * Test {@link PaymentGatewayRequestType#PaymentGatewayRequestType(String, String)}.
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#PaymentGatewayRequestType(String,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PaymentGatewayRequestType.<init>(String, String)"})
  public void testNewPaymentGatewayRequestType() {
    // Arrange and Act
    PaymentGatewayRequestType actualPaymentGatewayRequestType =
        new PaymentGatewayRequestType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualPaymentGatewayRequestType.getFriendlyType());
    assertEquals("Type", actualPaymentGatewayRequestType.getType());
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}, and {@link
   * PaymentGatewayRequestType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#equals(Object)}
   *   <li>{@link PaymentGatewayRequestType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentGatewayRequestType paymentGatewayRequestType =
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR;
    PaymentGatewayRequestType paymentGatewayRequestType2 =
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR;

    // Act and Assert
    assertEquals(paymentGatewayRequestType, paymentGatewayRequestType2);
    assertEquals(paymentGatewayRequestType.hashCode(), paymentGatewayRequestType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}, and {@link
   * PaymentGatewayRequestType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#equals(Object)}
   *   <li>{@link PaymentGatewayRequestType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentGatewayRequestType paymentGatewayRequestType =
        PaymentGatewayRequestType.DETACHED_CREDIT_REFUND;
    PaymentGatewayRequestType paymentGatewayRequestType2 =
        new PaymentGatewayRequestType("DETACHED_CREDIT_REFUND", "DETACHED_CREDIT_REFUND");

    // Act and Assert
    assertEquals(paymentGatewayRequestType, paymentGatewayRequestType2);
    assertEquals(paymentGatewayRequestType.hashCode(), paymentGatewayRequestType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}, and {@link
   * PaymentGatewayRequestType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#equals(Object)}
   *   <li>{@link PaymentGatewayRequestType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentGatewayRequestType paymentGatewayRequestType = new PaymentGatewayRequestType();
    PaymentGatewayRequestType paymentGatewayRequestType2 = new PaymentGatewayRequestType();

    // Act and Assert
    assertEquals(paymentGatewayRequestType, paymentGatewayRequestType2);
    assertEquals(paymentGatewayRequestType.hashCode(), paymentGatewayRequestType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}, and {@link
   * PaymentGatewayRequestType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#equals(Object)}
   *   <li>{@link PaymentGatewayRequestType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentGatewayRequestType paymentGatewayRequestType =
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR;

    // Act and Assert
    assertEquals(paymentGatewayRequestType, paymentGatewayRequestType);
    int expectedHashCodeResult = paymentGatewayRequestType.hashCode();
    assertEquals(expectedHashCodeResult, paymentGatewayRequestType.hashCode());
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        PaymentGatewayRequestType.DETACHED_CREDIT_REFUND,
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR);
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PaymentGatewayRequestType(), PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR);
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR, null);
  }

  /**
   * Test {@link PaymentGatewayRequestType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayRequestType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayRequestType.equals(Object)",
    "int PaymentGatewayRequestType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        PaymentGatewayRequestType.CREATE_CUSTOMER_PAYMENT_TR,
        "Different type to PaymentGatewayRequestType");
  }
}
