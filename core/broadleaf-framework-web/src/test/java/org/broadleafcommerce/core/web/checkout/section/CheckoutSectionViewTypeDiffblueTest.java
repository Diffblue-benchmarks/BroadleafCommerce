package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutSectionViewTypeDiffblueTest {
  /**
   * Test {@link CheckoutSectionViewType#getInstance(String)}.
   *
   * <p>Method under test: {@link CheckoutSectionViewType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckoutSectionViewType CheckoutSectionViewType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    CheckoutSectionViewType actualInstance = CheckoutSectionViewType.getInstance("Type");

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
   *   <li>{@link CheckoutSectionViewType#CheckoutSectionViewType()}
   *   <li>{@link CheckoutSectionViewType#getFriendlyType()}
   *   <li>{@link CheckoutSectionViewType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutSectionViewType.<init>()",
    "void CheckoutSectionViewType.<init>(String, String)",
    "String CheckoutSectionViewType.getFriendlyType()",
    "String CheckoutSectionViewType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    CheckoutSectionViewType actualCheckoutSectionViewType = new CheckoutSectionViewType();
    String actualFriendlyType = actualCheckoutSectionViewType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutSectionViewType.getType());
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
   *   <li>{@link CheckoutSectionViewType#CheckoutSectionViewType(String, String)}
   *   <li>{@link CheckoutSectionViewType#getFriendlyType()}
   *   <li>{@link CheckoutSectionViewType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutSectionViewType.<init>()",
    "void CheckoutSectionViewType.<init>(String, String)",
    "String CheckoutSectionViewType.getFriendlyType()",
    "String CheckoutSectionViewType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    CheckoutSectionViewType actualCheckoutSectionViewType =
        new CheckoutSectionViewType("Type", "Friendly Type");
    String actualFriendlyType = actualCheckoutSectionViewType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualCheckoutSectionViewType.getType());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and {@link
   * CheckoutSectionViewType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = CheckoutSectionViewType.BILLING_INFO;
    CheckoutSectionViewType checkoutSectionViewType2 = CheckoutSectionViewType.BILLING_INFO;

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    assertEquals(checkoutSectionViewType.hashCode(), checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and {@link
   * CheckoutSectionViewType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = CheckoutSectionViewType.ORDER_INFO;
    CheckoutSectionViewType checkoutSectionViewType2 =
        new CheckoutSectionViewType("ORDER_INFO", "ORDER_INFO");

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    assertEquals(checkoutSectionViewType.hashCode(), checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and {@link
   * CheckoutSectionViewType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = new CheckoutSectionViewType();
    CheckoutSectionViewType checkoutSectionViewType2 = new CheckoutSectionViewType();

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType2);
    assertEquals(checkoutSectionViewType.hashCode(), checkoutSectionViewType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}, and {@link
   * CheckoutSectionViewType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionViewType#equals(Object)}
   *   <li>{@link CheckoutSectionViewType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutSectionViewType checkoutSectionViewType = CheckoutSectionViewType.BILLING_INFO;

    // Act and Assert
    assertEquals(checkoutSectionViewType, checkoutSectionViewType);
    int expectedHashCodeResult = checkoutSectionViewType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionViewType.hashCode());
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionViewType.ORDER_INFO, CheckoutSectionViewType.BILLING_INFO);
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new CheckoutSectionViewType(), CheckoutSectionViewType.BILLING_INFO);
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionViewType.BILLING_INFO, null);
  }

  /**
   * Test {@link CheckoutSectionViewType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionViewType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionViewType.equals(Object)",
    "int CheckoutSectionViewType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        CheckoutSectionViewType.BILLING_INFO, "Different type to CheckoutSectionViewType");
  }
}
