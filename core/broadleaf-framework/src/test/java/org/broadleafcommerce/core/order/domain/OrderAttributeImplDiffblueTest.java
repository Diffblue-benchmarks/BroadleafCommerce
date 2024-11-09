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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.Test;

public class OrderAttributeImplDiffblueTest {
  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl2);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(mock(Order.class));
    orderAttributeImpl.setValue("42");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl2);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}, and
   * {@link OrderAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAttributeImpl#equals(Object)}
   *   <li>{@link OrderAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(orderAttributeImpl, orderAttributeImpl);
    int expectedHashCodeResult = orderAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAttributeImpl.hashCode());
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("Value");

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, orderAttributeImpl2);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue(null);

    OrderAttributeImpl orderAttributeImpl2 = new OrderAttributeImpl();
    orderAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl2.setName("Name");
    orderAttributeImpl2.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, orderAttributeImpl2);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, null);
  }

  /**
   * Test {@link OrderAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAttributeImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderAttributeImpl orderAttributeImpl = new OrderAttributeImpl();
    orderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderAttributeImpl.setName("Name");
    orderAttributeImpl.setOrder(NullOrderFactoryImpl.NULL_ORDER);
    orderAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderAttributeImpl, "Different type to OrderAttributeImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderAttributeImpl}
   *   <li>{@link OrderAttributeImpl#setId(Long)}
   *   <li>{@link OrderAttributeImpl#setName(String)}
   *   <li>{@link OrderAttributeImpl#setOrder(Order)}
   *   <li>{@link OrderAttributeImpl#setValue(String)}
   *   <li>{@link OrderAttributeImpl#getId()}
   *   <li>{@link OrderAttributeImpl#getName()}
   *   <li>{@link OrderAttributeImpl#getOrder()}
   *   <li>{@link OrderAttributeImpl#getValue()}
   *   <li>{@link OrderAttributeImpl#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderAttributeImpl actualOrderAttributeImpl = new OrderAttributeImpl();
    actualOrderAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualOrderAttributeImpl.setName("Name");
    Order order = NullOrderFactoryImpl.NULL_ORDER;
    actualOrderAttributeImpl.setOrder(order);
    actualOrderAttributeImpl.setValue("42");
    Long actualId = actualOrderAttributeImpl.getId();
    String actualName = actualOrderAttributeImpl.getName();
    Order actualOrder = actualOrderAttributeImpl.getOrder();
    String actualValue = actualOrderAttributeImpl.getValue();

    // Assert that nothing has changed
    assertEquals("42", actualValue);
    assertEquals("42", actualOrderAttributeImpl.toString());
    assertEquals("Name", actualName);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(order, actualOrder);
  }
}
