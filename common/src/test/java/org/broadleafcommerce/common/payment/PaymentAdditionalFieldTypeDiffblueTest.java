package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentAdditionalFieldTypeDiffblueTest {
  /**
   * Test {@link PaymentAdditionalFieldType#getInstance(String)}.
   *
   * <p>Method under test: {@link PaymentAdditionalFieldType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentAdditionalFieldType PaymentAdditionalFieldType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    PaymentAdditionalFieldType actualInstance = PaymentAdditionalFieldType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return FriendlyType is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#PaymentAdditionalFieldType()}
   *   <li>{@link PaymentAdditionalFieldType#getFriendlyType()}
   *   <li>{@link PaymentAdditionalFieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentAdditionalFieldType.<init>()",
    "void PaymentAdditionalFieldType.<init>(String, String)",
    "String PaymentAdditionalFieldType.getFriendlyType()",
    "String PaymentAdditionalFieldType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    PaymentAdditionalFieldType actualPaymentAdditionalFieldType = new PaymentAdditionalFieldType();
    String actualFriendlyType = actualPaymentAdditionalFieldType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentAdditionalFieldType.getType());
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
   *   <li>{@link PaymentAdditionalFieldType#PaymentAdditionalFieldType(String, String)}
   *   <li>{@link PaymentAdditionalFieldType#getFriendlyType()}
   *   <li>{@link PaymentAdditionalFieldType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentAdditionalFieldType.<init>()",
    "void PaymentAdditionalFieldType.<init>(String, String)",
    "String PaymentAdditionalFieldType.getFriendlyType()",
    "String PaymentAdditionalFieldType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    PaymentAdditionalFieldType actualPaymentAdditionalFieldType =
        new PaymentAdditionalFieldType("Type", "Friendly Type");
    String actualFriendlyType = actualPaymentAdditionalFieldType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualPaymentAdditionalFieldType.getType());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and {@link
   * PaymentAdditionalFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType =
        PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;
    PaymentAdditionalFieldType paymentAdditionalFieldType2 =
        PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    assertEquals(paymentAdditionalFieldType.hashCode(), paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and {@link
   * PaymentAdditionalFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = PaymentAdditionalFieldType.ACCOUNT_TYPE;
    PaymentAdditionalFieldType paymentAdditionalFieldType2 =
        new PaymentAdditionalFieldType("ACCOUNT_TYPE", "ACCOUNT_TYPE");

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    assertEquals(paymentAdditionalFieldType.hashCode(), paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and {@link
   * PaymentAdditionalFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType = new PaymentAdditionalFieldType();
    PaymentAdditionalFieldType paymentAdditionalFieldType2 = new PaymentAdditionalFieldType();

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType2);
    assertEquals(paymentAdditionalFieldType.hashCode(), paymentAdditionalFieldType2.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}, and {@link
   * PaymentAdditionalFieldType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentAdditionalFieldType#equals(Object)}
   *   <li>{@link PaymentAdditionalFieldType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PaymentAdditionalFieldType paymentAdditionalFieldType =
        PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM;

    // Act and Assert
    assertEquals(paymentAdditionalFieldType, paymentAdditionalFieldType);
    int expectedHashCodeResult = paymentAdditionalFieldType.hashCode();
    assertEquals(expectedHashCodeResult, paymentAdditionalFieldType.hashCode());
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        PaymentAdditionalFieldType.ACCOUNT_TYPE, PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM);
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new PaymentAdditionalFieldType(), PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM);
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM, null);
  }

  /**
   * Test {@link PaymentAdditionalFieldType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentAdditionalFieldType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentAdditionalFieldType.equals(Object)",
    "int PaymentAdditionalFieldType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        PaymentAdditionalFieldType.ACCOUNT_CREDIT_NUM,
        "Different type to PaymentAdditionalFieldType");
  }
}
