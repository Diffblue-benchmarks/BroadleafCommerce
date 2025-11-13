package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PaymentGatewayTypeDiffblueTest {
  /**
   * Test {@link PaymentGatewayType#getInstance(String)}.
   *
   * <p>Method under test: {@link PaymentGatewayType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PaymentGatewayType PaymentGatewayType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    PaymentGatewayType actualInstance = PaymentGatewayType.getInstance("Type");

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
   *   <li>{@link PaymentGatewayType#PaymentGatewayType()}
   *   <li>{@link PaymentGatewayType#getFriendlyType()}
   *   <li>{@link PaymentGatewayType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentGatewayType.<init>()",
    "void PaymentGatewayType.<init>(String, String)",
    "String PaymentGatewayType.getFriendlyType()",
    "String PaymentGatewayType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    PaymentGatewayType actualPaymentGatewayType = new PaymentGatewayType();
    String actualFriendlyType = actualPaymentGatewayType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualPaymentGatewayType.getType());
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
   *   <li>{@link PaymentGatewayType#PaymentGatewayType(String, String)}
   *   <li>{@link PaymentGatewayType#getFriendlyType()}
   *   <li>{@link PaymentGatewayType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentGatewayType.<init>()",
    "void PaymentGatewayType.<init>(String, String)",
    "String PaymentGatewayType.getFriendlyType()",
    "String PaymentGatewayType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    PaymentGatewayType actualPaymentGatewayType = new PaymentGatewayType("Type", "Friendly Type");
    String actualFriendlyType = actualPaymentGatewayType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualPaymentGatewayType.getType());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and {@link PaymentGatewayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PaymentGatewayType paymentGatewayType = PaymentGatewayType.PASSTHROUGH;
    PaymentGatewayType paymentGatewayType2 = PaymentGatewayType.PASSTHROUGH;

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    assertEquals(paymentGatewayType.hashCode(), paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and {@link PaymentGatewayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PaymentGatewayType paymentGatewayType = PaymentGatewayType.TEMPORARY;
    PaymentGatewayType paymentGatewayType2 = new PaymentGatewayType("Temporary", "Temporary");

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    assertEquals(paymentGatewayType.hashCode(), paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and {@link PaymentGatewayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    PaymentGatewayType paymentGatewayType = new PaymentGatewayType();
    PaymentGatewayType paymentGatewayType2 = new PaymentGatewayType();

    // Act and Assert
    assertEquals(paymentGatewayType, paymentGatewayType2);
    assertEquals(paymentGatewayType.hashCode(), paymentGatewayType2.hashCode());
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}, and {@link PaymentGatewayType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PaymentGatewayType#equals(Object)}
   *   <li>{@link PaymentGatewayType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.TEMPORARY, PaymentGatewayType.PASSTHROUGH);
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new PaymentGatewayType(), PaymentGatewayType.PASSTHROUGH);
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.PASSTHROUGH, null);
  }

  /**
   * Test {@link PaymentGatewayType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PaymentGatewayType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean PaymentGatewayType.equals(Object)",
    "int PaymentGatewayType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(PaymentGatewayType.PASSTHROUGH, "Different type to PaymentGatewayType");
  }
}
