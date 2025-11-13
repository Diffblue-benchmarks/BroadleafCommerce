package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentLogEventTypeDiffblueTest {
  /**
   * Test {@link PaymentLogEventType#getInstance(String)}.
   *
   * <p>Method under test: {@link PaymentLogEventType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentLogEventType PaymentLogEventType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    PaymentLogEventType actualInstance = PaymentLogEventType.getInstance("Type");

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
   *   <li>{@link PaymentLogEventType#PaymentLogEventType()}
   *   <li>{@link PaymentLogEventType#getFriendlyType()}
   *   <li>{@link PaymentLogEventType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentLogEventType.<init>()",
    "void PaymentLogEventType.<init>(String, String)",
    "String PaymentLogEventType.getFriendlyType()",
    "String PaymentLogEventType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    PaymentLogEventType actualPaymentLogEventType = new PaymentLogEventType();
    String actualFriendlyType = actualPaymentLogEventType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentLogEventType.getType());
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
   *   <li>{@link PaymentLogEventType#PaymentLogEventType(String, String)}
   *   <li>{@link PaymentLogEventType#getFriendlyType()}
   *   <li>{@link PaymentLogEventType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentLogEventType.<init>()",
    "void PaymentLogEventType.<init>(String, String)",
    "String PaymentLogEventType.getFriendlyType()",
    "String PaymentLogEventType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    PaymentLogEventType actualPaymentLogEventType =
        new PaymentLogEventType("Type", "Friendly Type");
    String actualFriendlyType = actualPaymentLogEventType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualPaymentLogEventType.getType());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and {@link PaymentLogEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentLogEventType paymentLogEventType = PaymentLogEventType.FINISHED;
    PaymentLogEventType paymentLogEventType2 = PaymentLogEventType.FINISHED;

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    assertEquals(paymentLogEventType.hashCode(), paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and {@link PaymentLogEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentLogEventType paymentLogEventType = PaymentLogEventType.START;
    PaymentLogEventType paymentLogEventType2 = new PaymentLogEventType("START", "START");

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    assertEquals(paymentLogEventType.hashCode(), paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and {@link PaymentLogEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentLogEventType paymentLogEventType = new PaymentLogEventType();
    PaymentLogEventType paymentLogEventType2 = new PaymentLogEventType();

    // Act and Assert
    assertEquals(paymentLogEventType, paymentLogEventType2);
    assertEquals(paymentLogEventType.hashCode(), paymentLogEventType2.hashCode());
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}, and {@link PaymentLogEventType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentLogEventType#equals(Object)}
   *   <li>{@link PaymentLogEventType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.START, PaymentLogEventType.FINISHED);
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PaymentLogEventType(), PaymentLogEventType.FINISHED);
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.FINISHED, null);
  }

  /**
   * Test {@link PaymentLogEventType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentLogEventType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentLogEventType.equals(Object)",
    "int PaymentLogEventType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentLogEventType.FINISHED, "Different type to PaymentLogEventType");
  }
}
