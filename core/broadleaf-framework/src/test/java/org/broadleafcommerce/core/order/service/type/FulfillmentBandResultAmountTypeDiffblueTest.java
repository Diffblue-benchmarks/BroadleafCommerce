package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentBandResultAmountTypeDiffblueTest {
  /**
   * Test {@link FulfillmentBandResultAmountType#getInstance(String)}.
   *
   * <p>Method under test: {@link FulfillmentBandResultAmountType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "FulfillmentBandResultAmountType FulfillmentBandResultAmountType.getInstance(String)"
  })
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualInstance =
        FulfillmentBandResultAmountType.getInstance("Type");

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
   *   <li>{@link FulfillmentBandResultAmountType#FulfillmentBandResultAmountType()}
   *   <li>{@link FulfillmentBandResultAmountType#getFriendlyType()}
   *   <li>{@link FulfillmentBandResultAmountType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentBandResultAmountType.<init>()",
    "void FulfillmentBandResultAmountType.<init>(String, String)",
    "String FulfillmentBandResultAmountType.getFriendlyType()",
    "String FulfillmentBandResultAmountType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualFulfillmentBandResultAmountType =
        new FulfillmentBandResultAmountType();
    String actualFriendlyType = actualFulfillmentBandResultAmountType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentBandResultAmountType.getType());
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
   *   <li>{@link FulfillmentBandResultAmountType#FulfillmentBandResultAmountType(String, String)}
   *   <li>{@link FulfillmentBandResultAmountType#getFriendlyType()}
   *   <li>{@link FulfillmentBandResultAmountType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentBandResultAmountType.<init>()",
    "void FulfillmentBandResultAmountType.<init>(String, String)",
    "String FulfillmentBandResultAmountType.getFriendlyType()",
    "String FulfillmentBandResultAmountType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    FulfillmentBandResultAmountType actualFulfillmentBandResultAmountType =
        new FulfillmentBandResultAmountType("Type", "Friendly Type");
    String actualFriendlyType = actualFulfillmentBandResultAmountType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualFulfillmentBandResultAmountType.getType());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and {@link
   * FulfillmentBandResultAmountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType =
        FulfillmentBandResultAmountType.PERCENTAGE;
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 =
        FulfillmentBandResultAmountType.PERCENTAGE;

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    assertEquals(
        fulfillmentBandResultAmountType.hashCode(), fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and {@link
   * FulfillmentBandResultAmountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType =
        FulfillmentBandResultAmountType.RATE;
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 =
        new FulfillmentBandResultAmountType("RATE", "RATE");

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    assertEquals(
        fulfillmentBandResultAmountType.hashCode(), fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and {@link
   * FulfillmentBandResultAmountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType =
        new FulfillmentBandResultAmountType();
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType2 =
        new FulfillmentBandResultAmountType();

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType2);
    assertEquals(
        fulfillmentBandResultAmountType.hashCode(), fulfillmentBandResultAmountType2.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}, and {@link
   * FulfillmentBandResultAmountType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentBandResultAmountType#equals(Object)}
   *   <li>{@link FulfillmentBandResultAmountType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentBandResultAmountType fulfillmentBandResultAmountType =
        FulfillmentBandResultAmountType.PERCENTAGE;

    // Act and Assert
    assertEquals(fulfillmentBandResultAmountType, fulfillmentBandResultAmountType);
    int expectedHashCodeResult = fulfillmentBandResultAmountType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentBandResultAmountType.hashCode());
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        FulfillmentBandResultAmountType.RATE, FulfillmentBandResultAmountType.PERCENTAGE);
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(
        new FulfillmentBandResultAmountType(), FulfillmentBandResultAmountType.PERCENTAGE);
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentBandResultAmountType.PERCENTAGE, null);
  }

  /**
   * Test {@link FulfillmentBandResultAmountType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentBandResultAmountType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentBandResultAmountType.equals(Object)",
    "int FulfillmentBandResultAmountType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        FulfillmentBandResultAmountType.PERCENTAGE,
        "Different type to FulfillmentBandResultAmountType");
  }
}
