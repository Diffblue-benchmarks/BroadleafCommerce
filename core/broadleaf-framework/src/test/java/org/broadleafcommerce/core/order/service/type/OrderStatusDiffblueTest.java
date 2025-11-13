package org.broadleafcommerce.core.order.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderStatusDiffblueTest {
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
   *   <li>{@link OrderStatus#OrderStatus()}
   *   <li>{@link OrderStatus#getFriendlyType()}
   *   <li>{@link OrderStatus#getType()}
   *   <li>{@link OrderStatus#isEditable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderStatus.<init>()",
    "void OrderStatus.<init>(String, String)",
    "void OrderStatus.<init>(String, String, boolean)",
    "String OrderStatus.getFriendlyType()",
    "String OrderStatus.getType()",
    "boolean OrderStatus.isEditable()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    OrderStatus actualOrderStatus = new OrderStatus();
    String actualFriendlyType = actualOrderStatus.getFriendlyType();
    String actualType = actualOrderStatus.getType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualType);
    assertFalse(actualOrderStatus.isEditable());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return Editable.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderStatus#OrderStatus(String, String, boolean)}
   *   <li>{@link OrderStatus#getFriendlyType()}
   *   <li>{@link OrderStatus#getType()}
   *   <li>{@link OrderStatus#isEditable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderStatus.<init>()",
    "void OrderStatus.<init>(String, String)",
    "void OrderStatus.<init>(String, String, boolean)",
    "String OrderStatus.getFriendlyType()",
    "String OrderStatus.getType()",
    "boolean OrderStatus.isEditable()"
  })
  public void testGettersAndSetters_whenTrue_thenReturnEditable() {
    // Arrange and Act
    OrderStatus actualOrderStatus = new OrderStatus("Type", "Friendly Type", true);
    String actualFriendlyType = actualOrderStatus.getFriendlyType();
    String actualType = actualOrderStatus.getType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualType);
    assertTrue(actualOrderStatus.isEditable());
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
   *   <li>{@link OrderStatus#OrderStatus(String, String)}
   *   <li>{@link OrderStatus#getFriendlyType()}
   *   <li>{@link OrderStatus#getType()}
   *   <li>{@link OrderStatus#isEditable()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderStatus.<init>()",
    "void OrderStatus.<init>(String, String)",
    "void OrderStatus.<init>(String, String, boolean)",
    "String OrderStatus.getFriendlyType()",
    "String OrderStatus.getType()",
    "boolean OrderStatus.isEditable()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    OrderStatus actualOrderStatus = new OrderStatus("Type", "Friendly Type");
    String actualFriendlyType = actualOrderStatus.getFriendlyType();
    String actualType = actualOrderStatus.getType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualType);
    assertFalse(actualOrderStatus.isEditable());
  }

  /**
   * Test {@link OrderStatus#equals(Object)}, and {@link OrderStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderStatus#equals(Object)}
   *   <li>{@link OrderStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderStatus orderStatus = OrderStatus.ARCHIVED;
    OrderStatus orderStatus2 = OrderStatus.ARCHIVED;

    // Act and Assert
    assertEquals(orderStatus, orderStatus2);
    assertEquals(orderStatus.hashCode(), orderStatus2.hashCode());
  }

  /**
   * Test {@link OrderStatus#equals(Object)}, and {@link OrderStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderStatus#equals(Object)}
   *   <li>{@link OrderStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderStatus orderStatus = OrderStatus.CANCELLED;
    OrderStatus orderStatus2 = new OrderStatus("CANCELLED", "CANCELLED");

    // Act and Assert
    assertEquals(orderStatus, orderStatus2);
    assertEquals(orderStatus.hashCode(), orderStatus2.hashCode());
  }

  /**
   * Test {@link OrderStatus#equals(Object)}, and {@link OrderStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderStatus#equals(Object)}
   *   <li>{@link OrderStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderStatus orderStatus = new OrderStatus();
    OrderStatus orderStatus2 = new OrderStatus();

    // Act and Assert
    assertEquals(orderStatus, orderStatus2);
    assertEquals(orderStatus.hashCode(), orderStatus2.hashCode());
  }

  /**
   * Test {@link OrderStatus#equals(Object)}, and {@link OrderStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderStatus#equals(Object)}
   *   <li>{@link OrderStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderStatus orderStatus = OrderStatus.ARCHIVED;

    // Act and Assert
    assertEquals(orderStatus, orderStatus);
    int expectedHashCodeResult = orderStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderStatus.hashCode());
  }

  /**
   * Test {@link OrderStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderStatus.CANCELLED, OrderStatus.ARCHIVED);
  }

  /**
   * Test {@link OrderStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderStatus(), OrderStatus.ARCHIVED);
  }

  /**
   * Test {@link OrderStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderStatus.ARCHIVED, null);
  }

  /**
   * Test {@link OrderStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderStatus.equals(Object)", "int OrderStatus.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderStatus.ARCHIVED, "Different type to OrderStatus");
  }
}
