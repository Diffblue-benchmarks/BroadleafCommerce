package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentTypeDiffblueTest {
  /**
   * Test {@link PaymentType#getInstance(String)}.
   *
   * <p>Method under test: {@link PaymentType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentType PaymentType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    PaymentType actualInstance = PaymentType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertFalse(actualInstance.getIsFinalPayment());
    assertFalse(actualInstance.isCreditCardType());
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
   *   <li>{@link PaymentType#PaymentType()}
   *   <li>{@link PaymentType#getFriendlyType()}
   *   <li>{@link PaymentType#getIsFinalPayment()}
   *   <li>{@link PaymentType#getType()}
   *   <li>{@link PaymentType#isCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentType.<init>()",
    "void PaymentType.<init>(String, String)",
    "void PaymentType.<init>(String, String, boolean)",
    "void PaymentType.<init>(String, String, boolean, boolean)",
    "String PaymentType.getFriendlyType()",
    "boolean PaymentType.getIsFinalPayment()",
    "String PaymentType.getType()",
    "boolean PaymentType.isCreditCardType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
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
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return CreditCardType.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#PaymentType(String, String, boolean, boolean)}
   *   <li>{@link PaymentType#getFriendlyType()}
   *   <li>{@link PaymentType#getIsFinalPayment()}
   *   <li>{@link PaymentType#getType()}
   *   <li>{@link PaymentType#isCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentType.<init>()",
    "void PaymentType.<init>(String, String)",
    "void PaymentType.<init>(String, String, boolean)",
    "void PaymentType.<init>(String, String, boolean, boolean)",
    "String PaymentType.getFriendlyType()",
    "boolean PaymentType.getIsFinalPayment()",
    "String PaymentType.getType()",
    "boolean PaymentType.isCreditCardType()"
  })
  public void testGettersAndSetters_whenTrue_thenReturnCreditCardType() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type", true, true);
    String actualFriendlyType = actualPaymentType.getFriendlyType();
    boolean actualIsFinalPayment = actualPaymentType.getIsFinalPayment();
    String actualType = actualPaymentType.getType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualType);
    assertTrue(actualIsFinalPayment);
    assertTrue(actualPaymentType.isCreditCardType());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return IsFinalPayment.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#PaymentType(String, String, boolean)}
   *   <li>{@link PaymentType#getFriendlyType()}
   *   <li>{@link PaymentType#getIsFinalPayment()}
   *   <li>{@link PaymentType#getType()}
   *   <li>{@link PaymentType#isCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentType.<init>()",
    "void PaymentType.<init>(String, String)",
    "void PaymentType.<init>(String, String, boolean)",
    "void PaymentType.<init>(String, String, boolean, boolean)",
    "String PaymentType.getFriendlyType()",
    "boolean PaymentType.getIsFinalPayment()",
    "String PaymentType.getType()",
    "boolean PaymentType.isCreditCardType()"
  })
  public void testGettersAndSetters_whenTrue_thenReturnIsFinalPayment() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type", true);
    String actualFriendlyType = actualPaymentType.getFriendlyType();
    boolean actualIsFinalPayment = actualPaymentType.getIsFinalPayment();
    String actualType = actualPaymentType.getType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualType);
    assertFalse(actualPaymentType.isCreditCardType());
    assertTrue(actualIsFinalPayment);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then return not IsFinalPayment.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#PaymentType(String, String)}
   *   <li>{@link PaymentType#getFriendlyType()}
   *   <li>{@link PaymentType#getIsFinalPayment()}
   *   <li>{@link PaymentType#getType()}
   *   <li>{@link PaymentType#isCreditCardType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentType.<init>()",
    "void PaymentType.<init>(String, String)",
    "void PaymentType.<init>(String, String, boolean)",
    "void PaymentType.<init>(String, String, boolean, boolean)",
    "String PaymentType.getFriendlyType()",
    "boolean PaymentType.getIsFinalPayment()",
    "String PaymentType.getType()",
    "boolean PaymentType.isCreditCardType()"
  })
  public void testGettersAndSetters_whenType_thenReturnNotIsFinalPayment() {
    // Arrange and Act
    PaymentType actualPaymentType = new PaymentType("Type", "Friendly Type");
    String actualFriendlyType = actualPaymentType.getFriendlyType();
    boolean actualIsFinalPayment = actualPaymentType.getIsFinalPayment();
    String actualType = actualPaymentType.getType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualType);
    assertFalse(actualIsFinalPayment);
    assertFalse(actualPaymentType.isCreditCardType());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentType paymentType = PaymentType.APPLE_PAY;
    PaymentType paymentType2 = PaymentType.APPLE_PAY;

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    assertEquals(paymentType.hashCode(), paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentType paymentType = PaymentType.BANK_ACCOUNT;
    PaymentType paymentType2 = new PaymentType("BANK_ACCOUNT", "BANK_ACCOUNT");

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    assertEquals(paymentType.hashCode(), paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentType paymentType = new PaymentType();
    PaymentType paymentType2 = new PaymentType();

    // Act and Assert
    assertEquals(paymentType, paymentType2);
    assertEquals(paymentType.hashCode(), paymentType2.hashCode());
  }

  /**
   * Test {@link PaymentType#equals(Object)}, and {@link PaymentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentType#equals(Object)}
   *   <li>{@link PaymentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.BANK_ACCOUNT, PaymentType.APPLE_PAY);
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PaymentType(), PaymentType.APPLE_PAY);
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.APPLE_PAY, null);
  }

  /**
   * Test {@link PaymentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PaymentType.equals(Object)", "int PaymentType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentType.APPLE_PAY, "Different type to PaymentType");
  }
}
