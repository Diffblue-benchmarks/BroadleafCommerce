package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemTypeDiffblueTest {
  /**
   * Test {@link OrderItemType#getInstance(String)}.
   *
   * <p>Method under test: {@link OrderItemType#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderItemType OrderItemType.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OrderItemType actualInstance = OrderItemType.getInstance("Type");

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
   *   <li>{@link OrderItemType#OrderItemType()}
   *   <li>{@link OrderItemType#getFriendlyType()}
   *   <li>{@link OrderItemType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemType.<init>()",
    "void OrderItemType.<init>(String, String)",
    "String OrderItemType.getFriendlyType()",
    "String OrderItemType.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    OrderItemType actualOrderItemType = new OrderItemType();
    String actualFriendlyType = actualOrderItemType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOrderItemType.getType());
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
   *   <li>{@link OrderItemType#OrderItemType(String, String)}
   *   <li>{@link OrderItemType#getFriendlyType()}
   *   <li>{@link OrderItemType#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemType.<init>()",
    "void OrderItemType.<init>(String, String)",
    "String OrderItemType.getFriendlyType()",
    "String OrderItemType.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    OrderItemType actualOrderItemType = new OrderItemType("Type", "Friendly Type");
    String actualFriendlyType = actualOrderItemType.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualOrderItemType.getType());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and {@link OrderItemType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemType orderItemType = OrderItemType.BASIC;
    OrderItemType orderItemType2 = OrderItemType.BASIC;

    // Act and Assert
    assertEquals(orderItemType, orderItemType2);
    assertEquals(orderItemType.hashCode(), orderItemType2.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and {@link OrderItemType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemType orderItemType = OrderItemType.BUNDLE;
    OrderItemType orderItemType2 =
        new OrderItemType(
            "org.broadleafcommerce.core.order.domain.BundleOrderItem",
            "org.broadleafcommerce.core.order.domain.BundleOrderItem");

    // Act and Assert
    assertEquals(orderItemType, orderItemType2);
    assertEquals(orderItemType.hashCode(), orderItemType2.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and {@link OrderItemType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemType orderItemType = new OrderItemType();
    OrderItemType orderItemType2 = new OrderItemType();

    // Act and Assert
    assertEquals(orderItemType, orderItemType2);
    assertEquals(orderItemType.hashCode(), orderItemType2.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and {@link OrderItemType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemType orderItemType = OrderItemType.BASIC;

    // Act and Assert
    assertEquals(orderItemType, orderItemType);
    int expectedHashCodeResult = orderItemType.hashCode();
    assertEquals(expectedHashCodeResult, orderItemType.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BUNDLE, OrderItemType.BASIC);
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderItemType(), OrderItemType.BASIC);
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BASIC, null);
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderItemType.equals(Object)", "int OrderItemType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BASIC, "Different type to OrderItemType");
  }
}
