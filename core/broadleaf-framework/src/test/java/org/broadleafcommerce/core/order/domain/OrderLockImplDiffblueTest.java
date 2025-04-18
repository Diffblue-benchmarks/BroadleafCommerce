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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.OrderLockImpl.OrderLockPk;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderLockImplDiffblueTest {
  @Autowired
  private OrderLockImpl orderLockImpl;

  /**
   * Test {@link OrderLockImpl#getOrderId()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getOrderId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderLockImpl.getOrderId()"})
  public void testGetOrderId() {
    // Arrange, Act and Assert
    assertNull((new OrderLockImpl()).getOrderId());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and {@link OrderLockPk#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderLockPk.equals(Object)", "int OrderLockPk.hashCode()"})
  public void testOrderLockPkEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderLockPk orderLockPk = new OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    OrderLockPk orderLockPk2 = new OrderLockPk();
    orderLockPk2.setKey("Key");
    orderLockPk2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderLockPk, orderLockPk2);
    int expectedHashCodeResult = orderLockPk.hashCode();
    assertEquals(expectedHashCodeResult, orderLockPk2.hashCode());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and {@link OrderLockPk#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderLockPk.equals(Object)", "int OrderLockPk.hashCode()"})
  public void testOrderLockPkEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderLockPk orderLockPk = new OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderLockPk, orderLockPk);
    int expectedHashCodeResult = orderLockPk.hashCode();
    assertEquals(expectedHashCodeResult, orderLockPk.hashCode());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderLockPk.equals(Object)", "int OrderLockPk.hashCode()"})
  public void testOrderLockPkEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderLockPk orderLockPk = new OrderLockPk();
    orderLockPk.setKey(null);
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    OrderLockPk orderLockPk2 = new OrderLockPk();
    orderLockPk2.setKey("Key");
    orderLockPk2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, orderLockPk2);
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderLockPk.equals(Object)", "int OrderLockPk.hashCode()"})
  public void testOrderLockPkEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderLockPk orderLockPk = new OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, null);
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderLockPk.equals(Object)", "int OrderLockPk.hashCode()"})
  public void testOrderLockPkEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderLockPk orderLockPk = new OrderLockPk();
    orderLockPk.setKey("Key");
    orderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderLockPk, "Different type to OrderLockPk");
  }

  /**
   * Test OrderLockPk getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderLockPk}
   *   <li>{@link OrderLockPk#setKey(String)}
   *   <li>{@link OrderLockPk#setOrderId(Long)}
   *   <li>{@link OrderLockPk#getKey()}
   *   <li>{@link OrderLockPk#getOrderId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockPk.<init>()", "String OrderLockPk.getKey()", "Long OrderLockPk.getOrderId()",
      "void OrderLockPk.setKey(String)", "void OrderLockPk.setOrderId(Long)"})
  public void testOrderLockPkGettersAndSetters() {
    // Arrange and Act
    OrderLockPk actualOrderLockPk = new OrderLockPk();
    actualOrderLockPk.setKey("Key");
    actualOrderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);
    String actualKey = actualOrderLockPk.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualOrderLockPk.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#setOrderId(Long)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setOrderId(Long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.setOrderId(Long)"})
  public void testSetOrderId() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();

    // Act
    orderLockImpl2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl2.getOrderId().longValue());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl2.orderLockPK.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor) Key is {@code Node Key}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderLockImpl.getLocked()"})
  public void testGetLocked_givenOrderLockImplKeyIsNodeKey_thenReturnTrue() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();
    orderLockImpl2.setKey("Node Key");
    orderLockImpl2.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl2.setOrderId(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl2.setLocked(true);

    // Act and Assert
    assertTrue(orderLockImpl2.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Boolean OrderLockImpl.getLocked()"})
  public void testGetLocked_givenOrderLockImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new OrderLockImpl()).getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor) Key is {@code Node Key}.</li>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_givenOrderLockImplKeyIsNodeKey_whenNull() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();
    orderLockImpl2.setKey("Node Key");
    orderLockImpl2.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);
    orderLockImpl2.setLocked(true);
    orderLockImpl2.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Act
    orderLockImpl2.setLocked(null);

    // Assert
    assertEquals('N', orderLockImpl2.locked.charValue());
    assertFalse(orderLockImpl2.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>When {@code false}.</li>
   *   <li>Then {@link OrderLockImpl} (default constructor) {@link OrderLockImpl#locked} charValue is {@code N}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_givenOrderLockImpl_whenFalse_thenOrderLockImplLockedCharValueIsN() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();

    // Act
    orderLockImpl2.setLocked(false);

    // Assert that nothing has changed
    assertEquals('N', orderLockImpl2.locked.charValue());
    assertFalse(orderLockImpl2.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   * <ul>
   *   <li>Given {@link OrderLockImpl} (default constructor).</li>
   *   <li>When {@code true}.</li>
   *   <li>Then {@link OrderLockImpl} (default constructor) {@link OrderLockImpl#locked} charValue is {@code Y}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_givenOrderLockImpl_whenTrue_thenOrderLockImplLockedCharValueIsY() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();

    // Act
    orderLockImpl2.setLocked(true);

    // Assert
    assertEquals('Y', orderLockImpl2.locked.charValue());
    assertTrue(orderLockImpl2.getLocked());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderLockImpl#setLastUpdated(Long)}
   *   <li>{@link OrderLockImpl#getLastUpdated()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long OrderLockImpl.getLastUpdated()", "void OrderLockImpl.setLastUpdated(Long)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl.getLastUpdated().longValue());
  }

  /**
   * Test {@link OrderLockImpl#getKey()}.
   * <p>
   * Method under test: {@link OrderLockImpl#getKey()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String OrderLockImpl.getKey()"})
  public void testGetKey() {
    // Arrange, Act and Assert
    assertNull((new OrderLockImpl()).getKey());
  }

  /**
   * Test {@link OrderLockImpl#setKey(String)}.
   * <p>
   * Method under test: {@link OrderLockImpl#setKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.setKey(String)"})
  public void testSetKey() {
    // Arrange
    OrderLockImpl orderLockImpl2 = new OrderLockImpl();

    // Act
    orderLockImpl2.setKey("Node Key");

    // Assert
    assertEquals("Node Key", orderLockImpl2.getKey());
    assertEquals("Node Key", orderLockImpl2.orderLockPK.getKey());
  }

  /**
   * Test new {@link OrderLockImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderLockImpl}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderLockImpl.<init>()"})
  public void testNewOrderLockImpl() {
    // Arrange and Act
    OrderLockImpl actualOrderLockImpl = new OrderLockImpl();

    // Assert
    assertEquals('N', actualOrderLockImpl.locked.charValue());
    assertNull(actualOrderLockImpl.getLastUpdated());
    assertNull(actualOrderLockImpl.getOrderId());
    OrderLockPk orderLockPk = actualOrderLockImpl.orderLockPK;
    assertNull(orderLockPk.getOrderId());
    assertNull(actualOrderLockImpl.getKey());
    assertNull(orderLockPk.getKey());
    assertFalse(actualOrderLockImpl.getLocked());
  }
}
