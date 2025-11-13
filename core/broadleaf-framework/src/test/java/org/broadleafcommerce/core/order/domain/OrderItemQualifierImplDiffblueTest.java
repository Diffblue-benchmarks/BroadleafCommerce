package org.broadleafcommerce.core.order.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderItemQualifierImplDiffblueTest {
  @Autowired private OrderItemQualifierImpl orderItemQualifierImpl;

  /**
   * Test {@link OrderItemQualifierImpl#getOffer()}.
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#getOffer()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.broadleafcommerce.core.offer.domain.Offer OrderItemQualifierImpl.getOffer()"
  })
  public void testGetOffer() {
    // Arrange, Act and Assert
    assertNull(orderItemQualifierImpl.getOffer());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link
   * OrderItemQualifierImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    assertEquals(orderItemQualifierImpl.hashCode(), orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link
   * OrderItemQualifierImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(null);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(null);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    assertEquals(orderItemQualifierImpl.hashCode(), orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link
   * OrderItemQualifierImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(null);
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(null);
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    assertEquals(orderItemQualifierImpl.hashCode(), orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link
   * OrderItemQualifierImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(null);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(null);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
    assertEquals(orderItemQualifierImpl.hashCode(), orderItemQualifierImpl2.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}, and {@link
   * OrderItemQualifierImpl#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemQualifierImpl#equals(Object)}
   *   <li>{@link OrderItemQualifierImpl#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertEquals(orderItemQualifierImpl, orderItemQualifierImpl);
    int expectedHashCodeResult = orderItemQualifierImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderItemQualifierImpl.hashCode());
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(2L);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(null);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new DiscreteOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(null);
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(0L);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(null);

    OrderItemQualifierImpl orderItemQualifierImpl2 = new OrderItemQualifierImpl();
    orderItemQualifierImpl2.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl2.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl2.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, orderItemQualifierImpl2);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, null);
  }

  /**
   * Test {@link OrderItemQualifierImpl#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderItemQualifierImpl#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderItemQualifierImpl.equals(Object)",
    "int OrderItemQualifierImpl.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderItemQualifierImpl orderItemQualifierImpl = new OrderItemQualifierImpl();
    orderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    orderItemQualifierImpl.setOrderItem(new BundleOrderItemImpl());
    orderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);

    // Act and Assert
    assertNotEquals(orderItemQualifierImpl, "Different type to OrderItemQualifierImpl");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemQualifierImpl}
   *   <li>{@link OrderItemQualifierImpl#setId(Long)}
   *   <li>{@link OrderItemQualifierImpl#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemQualifierImpl#setQuantity(Long)}
   *   <li>{@link OrderItemQualifierImpl#getId()}
   *   <li>{@link OrderItemQualifierImpl#getOrderItem()}
   *   <li>{@link OrderItemQualifierImpl#getQuantity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemQualifierImpl.<init>()",
    "Long OrderItemQualifierImpl.getId()",
    "OrderItem OrderItemQualifierImpl.getOrderItem()",
    "Long OrderItemQualifierImpl.getQuantity()",
    "void OrderItemQualifierImpl.setId(Long)",
    "void OrderItemQualifierImpl.setOrderItem(OrderItem)",
    "void OrderItemQualifierImpl.setQuantity(Long)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemQualifierImpl actualOrderItemQualifierImpl = new OrderItemQualifierImpl();
    actualOrderItemQualifierImpl.setId(OrderItemQualifierImpl.serialVersionUID);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemQualifierImpl.setOrderItem(orderItem);
    actualOrderItemQualifierImpl.setQuantity(OrderItemQualifierImpl.serialVersionUID);
    Long actualId = actualOrderItemQualifierImpl.getId();
    OrderItem actualOrderItem = actualOrderItemQualifierImpl.getOrderItem();
    Long actualQuantity = actualOrderItemQualifierImpl.getQuantity();

    // Assert
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualId.longValue());
    assertEquals(OrderItemQualifierImpl.serialVersionUID, actualQuantity.longValue());
    assertSame(orderItem, actualOrderItem);
  }
}
