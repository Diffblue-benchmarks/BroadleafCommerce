package org.broadleafcommerce.core.payment.service.type;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderPaymentStatusDiffblueTest {
  /**
   * Test {@link OrderPaymentStatus#getInstance(String)}.
   *
   * <p>Method under test: {@link OrderPaymentStatus#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderPaymentStatus OrderPaymentStatus.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OrderPaymentStatus actualInstance = OrderPaymentStatus.getInstance("Type");

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
   *   <li>{@link OrderPaymentStatus#OrderPaymentStatus()}
   *   <li>{@link OrderPaymentStatus#getFriendlyType()}
   *   <li>{@link OrderPaymentStatus#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentStatus.<init>()",
    "void OrderPaymentStatus.<init>(String, String)",
    "String OrderPaymentStatus.getFriendlyType()",
    "String OrderPaymentStatus.getType()"
  })
  public void testGettersAndSetters_thenReturnFriendlyTypeIsNull() {
    // Arrange and Act
    OrderPaymentStatus actualOrderPaymentStatus = new OrderPaymentStatus();
    String actualFriendlyType = actualOrderPaymentStatus.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOrderPaymentStatus.getType());
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
   *   <li>{@link OrderPaymentStatus#OrderPaymentStatus(String, String)}
   *   <li>{@link OrderPaymentStatus#getFriendlyType()}
   *   <li>{@link OrderPaymentStatus#getType()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderPaymentStatus.<init>()",
    "void OrderPaymentStatus.<init>(String, String)",
    "String OrderPaymentStatus.getFriendlyType()",
    "String OrderPaymentStatus.getType()"
  })
  public void testGettersAndSetters_whenType_thenReturnFriendlyType() {
    // Arrange and Act
    OrderPaymentStatus actualOrderPaymentStatus = new OrderPaymentStatus("Type", "Friendly Type");
    String actualFriendlyType = actualOrderPaymentStatus.getFriendlyType();

    // Assert
    assertEquals("Friendly Type", actualFriendlyType);
    assertEquals("Type", actualOrderPaymentStatus.getType());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and {@link OrderPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.AUTHORIZED;
    OrderPaymentStatus orderPaymentStatus2 = OrderPaymentStatus.AUTHORIZED;

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    assertEquals(orderPaymentStatus.hashCode(), orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and {@link OrderPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.COMPLETE;
    OrderPaymentStatus orderPaymentStatus2 = new OrderPaymentStatus("Complete", "Complete");

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    assertEquals(orderPaymentStatus.hashCode(), orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and {@link OrderPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = new OrderPaymentStatus();
    OrderPaymentStatus orderPaymentStatus2 = new OrderPaymentStatus();

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus2);
    assertEquals(orderPaymentStatus.hashCode(), orderPaymentStatus2.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}, and {@link OrderPaymentStatus#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderPaymentStatus#equals(Object)}
   *   <li>{@link OrderPaymentStatus#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderPaymentStatus orderPaymentStatus = OrderPaymentStatus.AUTHORIZED;

    // Act and Assert
    assertEquals(orderPaymentStatus, orderPaymentStatus);
    int expectedHashCodeResult = orderPaymentStatus.hashCode();
    assertEquals(expectedHashCodeResult, orderPaymentStatus.hashCode());
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.COMPLETE, OrderPaymentStatus.AUTHORIZED);
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderPaymentStatus(), OrderPaymentStatus.AUTHORIZED);
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.AUTHORIZED, null);
  }

  /**
   * Test {@link OrderPaymentStatus#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderPaymentStatus#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderPaymentStatus.equals(Object)",
    "int OrderPaymentStatus.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderPaymentStatus.AUTHORIZED, "Different type to OrderPaymentStatus");
  }
}
