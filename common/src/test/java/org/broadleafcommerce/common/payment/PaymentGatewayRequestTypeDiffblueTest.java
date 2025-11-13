package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentGatewayRequestTypeDiffblueTest {
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
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return {@code Friendly Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayRequestType#PaymentGatewayRequestType(String, String)}
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
    "void PaymentGatewayRequestType.<init>(String, String)",
    "String PaymentGatewayRequestType.getFriendlyType()",
    "String PaymentGatewayRequestType.getType()",
    "Map PaymentGatewayRequestType.getTypes()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    PaymentGatewayRequestType actualPaymentGatewayRequestType =
        new PaymentGatewayRequestType("Type", "Friendly Type");
    Map<String, PaymentGatewayRequestType> actualTypes = actualPaymentGatewayRequestType.getTypes();
    String actualFriendlyType = actualPaymentGatewayRequestType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualPaymentGatewayRequestType.getType());
    assertEquals(5, actualTypes.size());
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
