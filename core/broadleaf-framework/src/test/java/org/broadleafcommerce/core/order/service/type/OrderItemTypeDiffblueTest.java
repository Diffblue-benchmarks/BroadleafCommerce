/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {OrderItemType.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemTypeDiffblueTest {
  @Autowired
  private OrderItemType orderItemType;

  /**
   * Test {@link OrderItemType#getInstance(String)}.
   * <p>
   * Method under test: {@link OrderItemType#getInstance(String)}
   */
  @Test
  public void testGetInstance() {
    // Arrange and Act
    OrderItemType actualInstance = OrderItemType.getInstance("Type");

    // Assert
    assertEquals("Friendly Type", actualInstance.getFriendlyType());
    assertEquals("Type", actualInstance.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemType#OrderItemType()}
   *   <li>{@link OrderItemType#getFriendlyType()}
   *   <li>{@link OrderItemType#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemType actualOrderItemType = new OrderItemType();
    String actualFriendlyType = actualOrderItemType.getFriendlyType();

    // Assert
    assertNull(actualFriendlyType);
    assertNull(actualOrderItemType.getType());
  }

  /**
   * Test {@link OrderItemType#OrderItemType(String, String)}.
   * <p>
   * Method under test: {@link OrderItemType#OrderItemType(String, String)}
   */
  @Test
  public void testNewOrderItemType() {
    // Arrange and Act
    OrderItemType actualOrderItemType = new OrderItemType("Type", "Friendly Type");

    // Assert
    assertEquals("Friendly Type", actualOrderItemType.getFriendlyType());
    assertEquals("Type", actualOrderItemType.getType());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and
   * {@link OrderItemType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemType orderItemType = OrderItemType.BASIC;
    OrderItemType orderItemType2 = OrderItemType.BASIC;

    // Act and Assert
    assertEquals(orderItemType, orderItemType2);
    int expectedHashCodeResult = orderItemType.hashCode();
    assertEquals(expectedHashCodeResult, orderItemType2.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and
   * {@link OrderItemType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemType orderItemType = new OrderItemType();
    OrderItemType orderItemType2 = new OrderItemType();

    // Act and Assert
    assertEquals(orderItemType, orderItemType2);
    int expectedHashCodeResult = orderItemType.hashCode();
    assertEquals(expectedHashCodeResult, orderItemType2.hashCode());
  }

  /**
   * Test {@link OrderItemType#equals(Object)}, and
   * {@link OrderItemType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemType#equals(Object)}
   *   <li>{@link OrderItemType#hashCode()}
   * </ul>
   */
  @Test
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BUNDLE, OrderItemType.BASIC);
    assertNotEquals(new OrderItemType(), OrderItemType.BASIC);
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BASIC, null);
  }

  /**
   * Test {@link OrderItemType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemType#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(OrderItemType.BASIC, "Different type to OrderItemType");
  }
}
