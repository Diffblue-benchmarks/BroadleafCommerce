/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderStatus.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatusDiffblueTest {
  @Autowired private OrderStatus orderStatus;

  /**
   * Test {@link OrderStatus#getInstance(String)}.
   *
   * <p>Method under test: {@link OrderStatus#getInstance(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OrderStatus OrderStatus.getInstance(String)"})
  public void testGetInstance() {
    // Arrange and Act
    OrderStatus actualInstance = OrderStatus.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
    assertFalse(actualInstance.isEditable());
  }

  /**
   * Test getters and setters.
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
    "String OrderStatus.getFriendlyType()",
    "String OrderStatus.getType()",
    "boolean OrderStatus.isEditable()"
  })
  public void testGettersAndSetters() {
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
   * Test {@link OrderStatus#OrderStatus(String, String)}.
   *
   * <p>Method under test: {@link OrderStatus#OrderStatus(String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderStatus.<init>(String, String)"})
  public void testNewOrderStatus() {
    // Arrange and Act
    OrderStatus actualOrderStatus = new OrderStatus("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOrderStatus.getFriendlyType());
    assertEquals("Type", actualOrderStatus.getType());
    assertFalse(actualOrderStatus.isEditable());
  }

  /**
   * Test {@link OrderStatus#OrderStatus(String, String, boolean)}.
   *
   * <p>Method under test: {@link OrderStatus#OrderStatus(String, String, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderStatus.<init>(String, String, boolean)"})
  public void testNewOrderStatus2() {
    // Arrange and Act
    OrderStatus actualOrderStatus = new OrderStatus("Type", "Friendly Type", true);

    // Assert
    assertEquals("Friendly Type", actualOrderStatus.getFriendlyType());
    assertEquals("Type", actualOrderStatus.getType());
    assertTrue(actualOrderStatus.isEditable());
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
