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
package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemAttributeImplDiffblueTest {
  @Autowired
  private OrderItemAttributeImpl orderItemAttributeImpl;

  /**
   * Test {@link OrderItemAttributeImpl#getValue()}.
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#getValue()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderItemAttributeImpl.getValue()"})
  public void testGetValue() {
    // Arrange, Act and Assert
    assertNull((new OrderItemAttributeImpl()).getValue());
  }

  /**
   * Test {@link OrderItemAttributeImpl#clone()}.
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#clone()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OrderItemAttribute OrderItemAttributeImpl.clone()"})
  public void testClone() {
    // Arrange and Act
    OrderItemAttribute actualCloneResult = (new OrderItemAttributeImpl()).clone();

    // Assert
    assertTrue(actualCloneResult instanceof OrderItemAttributeImpl);
    assertNull(actualCloneResult.getId());
    assertNull(actualCloneResult.toString());
    assertNull(actualCloneResult.getName());
    assertNull(actualCloneResult.getValue());
    assertNull(actualCloneResult.getOrderItem());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}, and {@link OrderItemAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAttributeImpl#equals(Object)}
   *   <li>{@link OrderItemAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
    int expectedHashCodeResult = orderItemAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAttributeImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}, and {@link OrderItemAttributeImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemAttributeImpl#equals(Object)}
   *   <li>{@link OrderItemAttributeImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertEquals(orderItemAttributeImpl, orderItemAttributeImpl);
    int expectedHashCodeResult = orderItemAttributeImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemAttributeImpl.hashCode());
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("Value");

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue(null);

    OrderItemAttributeImpl orderItemAttributeImpl2 = new OrderItemAttributeImpl();
    orderItemAttributeImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl2.setName("Name");
    orderItemAttributeImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl2.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, orderItemAttributeImpl2);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, null);
  }

  /**
   * Test {@link OrderItemAttributeImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderItemAttributeImpl#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderItemAttributeImpl.equals(Object)", "int OrderItemAttributeImpl.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemAttributeImpl orderItemAttributeImpl = new OrderItemAttributeImpl();
    orderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemAttributeImpl.setName("Name");
    orderItemAttributeImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemAttributeImpl.setValue("42");

    // Act and Assert
    assertNotEquals(orderItemAttributeImpl, "Different type to OrderItemAttributeImpl");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemAttributeImpl}
   *   <li>{@link OrderItemAttributeImpl#setId(Long)}
   *   <li>{@link OrderItemAttributeImpl#setName(String)}
   *   <li>{@link OrderItemAttributeImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemAttributeImpl#setValue(String)}
   *   <li>{@link OrderItemAttributeImpl#getId()}
   *   <li>{@link OrderItemAttributeImpl#getName()}
   *   <li>{@link OrderItemAttributeImpl#getOrderItem()}
   *   <li>{@link OrderItemAttributeImpl#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderItemAttributeImpl.<init>()", "Long OrderItemAttributeImpl.getId()",
      "String OrderItemAttributeImpl.getName()", "OrderItem OrderItemAttributeImpl.getOrderItem()",
      "void OrderItemAttributeImpl.setId(Long)", "void OrderItemAttributeImpl.setName(String)",
      "void OrderItemAttributeImpl.setOrderItem(OrderItem)", "void OrderItemAttributeImpl.setValue(String)",
      "String OrderItemAttributeImpl.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemAttributeImpl actualOrderItemAttributeImpl = new OrderItemAttributeImpl();
    actualOrderItemAttributeImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    actualOrderItemAttributeImpl.setName("Name");
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemAttributeImpl.setOrderItem(orderItem);
    actualOrderItemAttributeImpl.setValue("42");
    Long actualId = actualOrderItemAttributeImpl.getId();
    String actualName = actualOrderItemAttributeImpl.getName();
    OrderItem actualOrderItem = actualOrderItemAttributeImpl.getOrderItem();
    String actualToStringResult = actualOrderItemAttributeImpl.toString();

    // Assert
    assertEquals("42", actualOrderItemAttributeImpl.getValue());
    assertEquals("42", actualToStringResult);
    assertEquals("Name", actualName);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
