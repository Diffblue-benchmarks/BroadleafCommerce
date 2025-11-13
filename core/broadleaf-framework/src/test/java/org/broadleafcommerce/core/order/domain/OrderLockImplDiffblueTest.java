package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderLockImplDiffblueTest {
  @Autowired private OrderLockImpl orderLockImpl;

  /**
   * Test {@link OrderLockImpl#getOrderId()}.
   *
   * <p>Method under test: {@link OrderLockImpl#getOrderId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Long OrderLockImpl.getOrderId()"})
  public void testGetOrderId() {
    // Arrange, Act and Assert
    assertNull(orderLockImpl.getOrderId());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and {@link OrderLockPk#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    assertEquals(orderLockPk.hashCode(), orderLockPk2.hashCode());
  }

  /**
   * Test OrderLockPk {@link OrderLockPk#equals(Object)}, and {@link OrderLockPk#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderLockPk#equals(Object)}
   *   <li>{@link OrderLockPk#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockPk#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderLockPk}
   *   <li>{@link OrderLockPk#setKey(String)}
   *   <li>{@link OrderLockPk#setOrderId(Long)}
   *   <li>{@link OrderLockPk#getKey()}
   *   <li>{@link OrderLockPk#getOrderId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderLockPk.<init>()",
    "String OrderLockPk.getKey()",
    "Long OrderLockPk.getOrderId()",
    "void OrderLockPk.setKey(String)",
    "void OrderLockPk.setOrderId(Long)"
  })
  public void testOrderLockPkGettersAndSetters() {
    // Arrange and Act
    OrderLockPk actualOrderLockPk = new OrderLockPk();
    actualOrderLockPk.setKey("Key");
    actualOrderLockPk.setOrderId(OrderItemQualifierImpl.serialVersionUID);
    String actualKey = actualOrderLockPk.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals(
        OrderItemQualifierImpl.serialVersionUID, actualOrderLockPk.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#setOrderId(Long)}.
   *
   * <p>Method under test: {@link OrderLockImpl#setOrderId(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderLockImpl.setOrderId(Long)"})
  public void testSetOrderId() {
    // Arrange and Act
    orderLockImpl.setOrderId(OrderItemQualifierImpl.serialVersionUID);

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, orderLockImpl.getOrderId().longValue());
    assertEquals(
        OrderItemQualifierImpl.serialVersionUID,
        orderLockImpl.orderLockPK.getOrderId().longValue());
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   *
   * <ul>
   *   <li>Given {@link OrderLockImpl} Locked is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderLockImpl.getLocked()"})
  public void testGetLocked_givenOrderLockImplLockedIsTrue_thenReturnTrue() {
    // Arrange
    orderLockImpl.setLocked(true);

    // Act and Assert
    assertTrue(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#getLocked()}.
   *
   * <ul>
   *   <li>Given {@link OrderLockImpl}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockImpl#getLocked()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Boolean OrderLockImpl.getLocked()"})
  public void testGetLocked_givenOrderLockImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then {@link OrderLockImpl} {@link OrderLockImpl#locked} charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_whenFalse_thenOrderLockImplLockedCharValueIsN() {
    // Arrange and Act
    orderLockImpl.setLocked(false);

    // Assert that nothing has changed
    assertEquals('N', orderLockImpl.locked.charValue());
    assertFalse(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link OrderLockImpl} {@link OrderLockImpl#locked} charValue is {@code N}.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_whenNull_thenOrderLockImplLockedCharValueIsN() {
    // Arrange and Act
    orderLockImpl.setLocked(null);

    // Assert that nothing has changed
    assertEquals('N', orderLockImpl.locked.charValue());
    assertFalse(orderLockImpl.getLocked());
  }

  /**
   * Test {@link OrderLockImpl#setLocked(Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then {@link OrderLockImpl} {@link OrderLockImpl#locked} charValue is {@code Y}.
   * </ul>
   *
   * <p>Method under test: {@link OrderLockImpl#setLocked(Boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderLockImpl.setLocked(Boolean)"})
  public void testSetLocked_whenTrue_thenOrderLockImplLockedCharValueIsY() {
    // Arrange and Act
    orderLockImpl.setLocked(true);

    // Assert
    assertEquals('Y', orderLockImpl.locked.charValue());
    assertTrue(orderLockImpl.getLocked());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderLockImpl#setLastUpdated(Long)}
   *   <li>{@link OrderLockImpl#getLastUpdated()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long OrderLockImpl.getLastUpdated()",
    "void OrderLockImpl.setLastUpdated(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderLockImpl orderLockImpl = new OrderLockImpl();

    // Act
    orderLockImpl.setLastUpdated(OrderItemQualifierImpl.serialVersionUID);

    // Assert
    assertEquals(
        OrderItemQualifierImpl.serialVersionUID, orderLockImpl.getLastUpdated().longValue());
  }

  /**
   * Test {@link OrderLockImpl#getKey()}.
   *
   * <p>Method under test: {@link OrderLockImpl#getKey()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String OrderLockImpl.getKey()"})
  public void testGetKey() {
    // Arrange, Act and Assert
    assertNull(orderLockImpl.getKey());
  }

  /**
   * Test {@link OrderLockImpl#setKey(String)}.
   *
   * <p>Method under test: {@link OrderLockImpl#setKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderLockImpl.setKey(String)"})
  public void testSetKey() {
    // Arrange and Act
    orderLockImpl.setKey("Node Key");

    // Assert
    assertEquals("Node Key", orderLockImpl.getKey());
    assertEquals("Node Key", orderLockImpl.orderLockPK.getKey());
  }

  /**
   * Test new {@link OrderLockImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link OrderLockImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
