package org.broadleafcommerce.core.web.checkout.section;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CheckoutSectionStateTypeDiffblueTest {
  /**
   * Test {@link CheckoutSectionStateType#getInstance(String)}.
   *
   * <p>Method under test: {@link CheckoutSectionStateType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CheckoutSectionStateType CheckoutSectionStateType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    CheckoutSectionStateType actualInstance = CheckoutSectionStateType.getInstance("Type");

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
   *   <li>{@link CheckoutSectionStateType#CheckoutSectionStateType()}
   *   <li>{@link CheckoutSectionStateType#getFriendlyType()}
   *   <li>{@link CheckoutSectionStateType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutSectionStateType.<init>()",
    "void CheckoutSectionStateType.<init>(String, String)",
    "String CheckoutSectionStateType.getFriendlyType()",
    "String CheckoutSectionStateType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType = new CheckoutSectionStateType();
    String actualFriendlyType = actualCheckoutSectionStateType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCheckoutSectionStateType.getType());
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
   *   <li>{@link CheckoutSectionStateType#CheckoutSectionStateType(String, String)}
   *   <li>{@link CheckoutSectionStateType#getFriendlyType()}
   *   <li>{@link CheckoutSectionStateType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CheckoutSectionStateType.<init>()",
    "void CheckoutSectionStateType.<init>(String, String)",
    "String CheckoutSectionStateType.getFriendlyType()",
    "String CheckoutSectionStateType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    CheckoutSectionStateType actualCheckoutSectionStateType =
        new CheckoutSectionStateType("Type", "Friendly Type");
    String actualFriendlyType = actualCheckoutSectionStateType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualCheckoutSectionStateType.getType());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}, and {@link
   * CheckoutSectionStateType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.FORM;
    CheckoutSectionStateType checkoutSectionStateType2 = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    assertEquals(checkoutSectionStateType.hashCode(), checkoutSectionStateType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}, and {@link
   * CheckoutSectionStateType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.INACTIVE;
    CheckoutSectionStateType checkoutSectionStateType2 =
        new CheckoutSectionStateType("INACTIVE", "INACTIVE");

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    assertEquals(checkoutSectionStateType.hashCode(), checkoutSectionStateType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}, and {@link
   * CheckoutSectionStateType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = new CheckoutSectionStateType();
    CheckoutSectionStateType checkoutSectionStateType2 = new CheckoutSectionStateType();

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType2);
    assertEquals(checkoutSectionStateType.hashCode(), checkoutSectionStateType2.hashCode());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}, and {@link
   * CheckoutSectionStateType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CheckoutSectionStateType#equals(Object)}
   *   <li>{@link CheckoutSectionStateType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CheckoutSectionStateType checkoutSectionStateType = CheckoutSectionStateType.FORM;

    // Act and Assert
    assertEquals(checkoutSectionStateType, checkoutSectionStateType);
    int expectedHashCodeResult = checkoutSectionStateType.hashCode();
    assertEquals(expectedHashCodeResult, checkoutSectionStateType.hashCode());
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.INACTIVE, CheckoutSectionStateType.FORM);
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new CheckoutSectionStateType(), CheckoutSectionStateType.FORM);
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, null);
  }

  /**
   * Test {@link CheckoutSectionStateType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CheckoutSectionStateType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CheckoutSectionStateType.equals(Object)",
    "int CheckoutSectionStateType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CheckoutSectionStateType.FORM, "Different type to CheckoutSectionStateType");
  }
}
