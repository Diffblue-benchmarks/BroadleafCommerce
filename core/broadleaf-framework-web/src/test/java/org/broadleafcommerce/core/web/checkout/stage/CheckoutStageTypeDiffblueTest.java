package org.broadleafcommerce.core.web.checkout.stage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutStageTypeDiffblueTest {
  /**
   * Test {@link CheckoutStageType#getInstance(String)}.
   *
   * <p>Method under test: {@link CheckoutStageType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckoutStageType CheckoutStageType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    CheckoutStageType actualInstance = CheckoutStageType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertEquals(1, actualInstance.getOrder());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutStageType#CheckoutStageType()}
   *   <li>{@link CheckoutStageType#setOrder(int)}
   *   <li>{@link CheckoutStageType#getFriendlyType()}
   *   <li>{@link CheckoutStageType#getOrder()}
   *   <li>{@link CheckoutStageType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutStageType.<init>()",
    "String CheckoutStageType.getFriendlyType()",
    "int CheckoutStageType.getOrder()",
    "String CheckoutStageType.getType()",
    "void CheckoutStageType.setOrder(int)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CheckoutStageType actualCheckoutStageType = new CheckoutStageType();
    actualCheckoutStageType.setOrder(1);
    String actualFriendlyType = actualCheckoutStageType.getFriendlyType();
    int actualOrder = actualCheckoutStageType.getOrder();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutStageType.getType());
    assertEquals(1, actualOrder);
  }

  /**
   * Test {@link CheckoutStageType#CheckoutStageType(String, String, int)}.
   *
   * <p>Method under test: {@link CheckoutStageType#CheckoutStageType(String, String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CheckoutStageType.<init>(String, String, int)"})
  public void testNewCheckoutStageType() {
    // Arrange and Act
    CheckoutStageType actualCheckoutStageType = new CheckoutStageType("Type", "Friendly Type", 1);

    // Assert
    assertEquals("Friendly Type", actualCheckoutStageType.getFriendlyType());
    assertEquals("Type", actualCheckoutStageType.getType());
    assertEquals(1, actualCheckoutStageType.getOrder());
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}, and {@link CheckoutStageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutStageType checkoutStageType = CheckoutStageType.PAYMENT_INFO;
    CheckoutStageType checkoutStageType2 = CheckoutStageType.PAYMENT_INFO;

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    assertEquals(checkoutStageType.hashCode(), checkoutStageType2.hashCode());
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}, and {@link CheckoutStageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutStageType checkoutStageType = CheckoutStageType.REVIEW;
    CheckoutStageType checkoutStageType2 = new CheckoutStageType("REVIEW", "REVIEW", 1);

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    assertEquals(checkoutStageType.hashCode(), checkoutStageType2.hashCode());
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}, and {@link CheckoutStageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutStageType checkoutStageType = new CheckoutStageType();
    CheckoutStageType checkoutStageType2 = new CheckoutStageType();

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType2);
    assertEquals(checkoutStageType.hashCode(), checkoutStageType2.hashCode());
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}, and {@link CheckoutStageType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutStageType#equals(Object)}
   *   <li>{@link CheckoutStageType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutStageType checkoutStageType = CheckoutStageType.PAYMENT_INFO;

    // Act and Assert
    assertEquals(checkoutStageType, checkoutStageType);
    int expectedHashCodeResult = checkoutStageType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutStageType.hashCode());
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.REVIEW, CheckoutStageType.PAYMENT_INFO);
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new CheckoutStageType(), CheckoutStageType.PAYMENT_INFO);
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.PAYMENT_INFO, null);
  }

  /**
   * Test {@link CheckoutStageType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutStageType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutStageType.equals(Object)",
    "int CheckoutStageType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutStageType.PAYMENT_INFO, "Different type to CheckoutStageType");
  }

  /**
   * Test {@link CheckoutStageType#compareTo(CheckoutStageType)} with {@code CheckoutStageType}.
   *
   * <ul>
   *   <li>When {@link CheckoutStageType#PAYMENT_INFO}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutStageType#compareTo(CheckoutStageType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int CheckoutStageType.compareTo(CheckoutStageType)"})
  public void testCompareToWithCheckoutStageType_whenPayment_info_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, CheckoutStageType.PAYMENT_INFO.compareTo(CheckoutStageType.PAYMENT_INFO));
  }
}
