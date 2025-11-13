package org.broadleafcommerce.common.web.form;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BroadleafFormTypeDiffblueTest {
  /**
   * Test {@link BroadleafFormType#getInstance(String)}.
   *
   * <p>Method under test: {@link BroadleafFormType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BroadleafFormType BroadleafFormType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    BroadleafFormType actualInstance = BroadleafFormType.getInstance("Type");

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
   *   <li>{@link BroadleafFormType#BroadleafFormType()}
   *   <li>{@link BroadleafFormType#getFriendlyType()}
   *   <li>{@link BroadleafFormType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFormType.<init>()",
    "void BroadleafFormType.<init>(String, String)",
    "String BroadleafFormType.getFriendlyType()",
    "String BroadleafFormType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    BroadleafFormType actualBroadleafFormType = new BroadleafFormType();
    String actualFriendlyType = actualBroadleafFormType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualBroadleafFormType.getType());
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
   *   <li>{@link BroadleafFormType#BroadleafFormType(String, String)}
   *   <li>{@link BroadleafFormType#getFriendlyType()}
   *   <li>{@link BroadleafFormType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafFormType.<init>()",
    "void BroadleafFormType.<init>(String, String)",
    "String BroadleafFormType.getFriendlyType()",
    "String BroadleafFormType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    BroadleafFormType actualBroadleafFormType = new BroadleafFormType("Type", "Friendly Type");
    String actualFriendlyType = actualBroadleafFormType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualBroadleafFormType.getType());
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}, and {@link BroadleafFormType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BroadleafFormType broadleafFormType = BroadleafFormType.BILLING_FORM;
    BroadleafFormType broadleafFormType2 = BroadleafFormType.BILLING_FORM;

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    assertEquals(broadleafFormType.hashCode(), broadleafFormType2.hashCode());
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}, and {@link BroadleafFormType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BroadleafFormType broadleafFormType = BroadleafFormType.CUSTOMER_ADDRESS_FORM;
    BroadleafFormType broadleafFormType2 =
        new BroadleafFormType("CUSTOMER_ADDRESS_FORM", "CUSTOMER_ADDRESS_FORM");

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    assertEquals(broadleafFormType.hashCode(), broadleafFormType2.hashCode());
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}, and {@link BroadleafFormType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BroadleafFormType broadleafFormType = new BroadleafFormType();
    BroadleafFormType broadleafFormType2 = new BroadleafFormType();

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType2);
    assertEquals(broadleafFormType.hashCode(), broadleafFormType2.hashCode());
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}, and {@link BroadleafFormType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link BroadleafFormType#equals(Object)}
   *   <li>{@link BroadleafFormType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BroadleafFormType broadleafFormType = BroadleafFormType.BILLING_FORM;

    // Act and Assert
    assertEquals(broadleafFormType, broadleafFormType);
    int expectedHashCodeResult = broadleafFormType.hashCode();
    assertEquals(expectedHashCodeResult, broadleafFormType.hashCode());
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.CUSTOMER_ADDRESS_FORM, BroadleafFormType.BILLING_FORM);
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new BroadleafFormType(), BroadleafFormType.BILLING_FORM);
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.BILLING_FORM, null);
  }

  /**
   * Test {@link BroadleafFormType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafFormType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BroadleafFormType.equals(Object)",
    "int BroadleafFormType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(BroadleafFormType.BILLING_FORM, "Different type to BroadleafFormType");
  }
}
