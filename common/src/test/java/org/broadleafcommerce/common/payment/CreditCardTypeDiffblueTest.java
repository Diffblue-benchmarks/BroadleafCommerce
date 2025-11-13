package org.broadleafcommerce.common.payment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CreditCardTypeDiffblueTest {
  /**
   * Test {@link CreditCardType#getInstance(String)}.
   *
   * <p>Method under test: {@link CreditCardType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"CreditCardType CreditCardType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    CreditCardType actualInstance = CreditCardType.getInstance("Type");

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
   *   <li>{@link CreditCardType#CreditCardType()}
   *   <li>{@link CreditCardType#getFriendlyType()}
   *   <li>{@link CreditCardType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardType.<init>()",
    "void CreditCardType.<init>(String, String)",
    "String CreditCardType.getFriendlyType()",
    "String CreditCardType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    CreditCardType actualCreditCardType = new CreditCardType();
    String actualFriendlyType = actualCreditCardType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualCreditCardType.getType());
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
   *   <li>{@link CreditCardType#CreditCardType(String, String)}
   *   <li>{@link CreditCardType#getFriendlyType()}
   *   <li>{@link CreditCardType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CreditCardType.<init>()",
    "void CreditCardType.<init>(String, String)",
    "String CreditCardType.getFriendlyType()",
    "String CreditCardType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    CreditCardType actualCreditCardType = new CreditCardType("Type", "Friendly Type");
    String actualFriendlyType = actualCreditCardType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualCreditCardType.getType());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and {@link CreditCardType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.AMEX;
    CreditCardType creditCardType2 = CreditCardType.AMEX;

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    assertEquals(creditCardType.hashCode(), creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and {@link CreditCardType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.DINERSCLUB_CARTEBLANCHE;
    CreditCardType creditCardType2 =
        new CreditCardType("DINERSCLUB_CARTEBLANCHE", "DINERSCLUB_CARTEBLANCHE");

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    assertEquals(creditCardType.hashCode(), creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and {@link CreditCardType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CreditCardType creditCardType = new CreditCardType();
    CreditCardType creditCardType2 = new CreditCardType();

    // Act and Assert
    assertEquals(creditCardType, creditCardType2);
    assertEquals(creditCardType.hashCode(), creditCardType2.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}, and {@link CreditCardType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CreditCardType#equals(Object)}
   *   <li>{@link CreditCardType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CreditCardType creditCardType = CreditCardType.AMEX;

    // Act and Assert
    assertEquals(creditCardType, creditCardType);
    int expectedHashCodeResult = creditCardType.hashCode();
    assertEquals(expectedHashCodeResult, creditCardType.hashCode());
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.DINERSCLUB_CARTEBLANCHE, CreditCardType.AMEX);
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new CreditCardType(), CreditCardType.AMEX);
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.AMEX, null);
  }

  /**
   * Test {@link CreditCardType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CreditCardType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CreditCardType.equals(Object)", "int CreditCardType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CreditCardType.AMEX, "Different type to CreditCardType");
  }
}
