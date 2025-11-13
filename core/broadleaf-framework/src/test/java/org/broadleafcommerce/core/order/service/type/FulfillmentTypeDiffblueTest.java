package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FulfillmentTypeDiffblueTest {
  /**
   * Test {@link FulfillmentType#getInstance(String)}.
   *
   * <p>Method under test: {@link FulfillmentType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"FulfillmentType FulfillmentType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    FulfillmentType actualInstance = FulfillmentType.getInstance("Type");

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
   *   <li>{@link FulfillmentType#FulfillmentType()}
   *   <li>{@link FulfillmentType#getFriendlyType()}
   *   <li>{@link FulfillmentType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentType.<init>()",
    "void FulfillmentType.<init>(String, String)",
    "String FulfillmentType.getFriendlyType()",
    "String FulfillmentType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    FulfillmentType actualFulfillmentType = new FulfillmentType();
    String actualFriendlyType = actualFulfillmentType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualFulfillmentType.getType());
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
   *   <li>{@link FulfillmentType#FulfillmentType(String, String)}
   *   <li>{@link FulfillmentType#getFriendlyType()}
   *   <li>{@link FulfillmentType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentType.<init>()",
    "void FulfillmentType.<init>(String, String)",
    "String FulfillmentType.getFriendlyType()",
    "String FulfillmentType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    FulfillmentType actualFulfillmentType = new FulfillmentType("Type", "Friendly Type");
    String actualFriendlyType = actualFulfillmentType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualFulfillmentType.getType());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and {@link FulfillmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;
    FulfillmentType fulfillmentType2 = FulfillmentType.DIGITAL;

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    assertEquals(fulfillmentType.hashCode(), fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and {@link FulfillmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    FulfillmentType fulfillmentType = FulfillmentType.GIFT_CARD;
    FulfillmentType fulfillmentType2 = new FulfillmentType("GIFT_CARD", "GIFT_CARD");

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    assertEquals(fulfillmentType.hashCode(), fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and {@link FulfillmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    FulfillmentType fulfillmentType = new FulfillmentType();
    FulfillmentType fulfillmentType2 = new FulfillmentType();

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType2);
    assertEquals(fulfillmentType.hashCode(), fulfillmentType2.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}, and {@link FulfillmentType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link FulfillmentType#equals(Object)}
   *   <li>{@link FulfillmentType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    FulfillmentType fulfillmentType = FulfillmentType.DIGITAL;

    // Act and Assert
    assertEquals(fulfillmentType, fulfillmentType);
    int expectedHashCodeResult = fulfillmentType.hashCode();
    assertEquals(expectedHashCodeResult, fulfillmentType.hashCode());
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.GIFT_CARD, FulfillmentType.DIGITAL);
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new FulfillmentType(), FulfillmentType.DIGITAL);
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.DIGITAL, null);
  }

  /**
   * Test {@link FulfillmentType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link FulfillmentType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean FulfillmentType.equals(Object)", "int FulfillmentType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(FulfillmentType.DIGITAL, "Different type to FulfillmentType");
  }
}
