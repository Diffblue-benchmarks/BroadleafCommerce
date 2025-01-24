package org.broadleafcommerce.core.order.domain.dto;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class OrderItemHolderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemHolder#OrderItemHolder(OrderItem)}
   *   <li>{@link OrderItemHolder#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemHolder#getOrderItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemHolder actualOrderItemHolder = new OrderItemHolder(new BundleOrderItemImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemHolder.setOrderItem(orderItem);

    // Assert that nothing has changed
    assertSame(orderItem, actualOrderItemHolder.getOrderItem());
  }
}
