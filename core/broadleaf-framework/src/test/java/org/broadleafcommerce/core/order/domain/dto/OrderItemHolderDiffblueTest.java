package org.broadleafcommerce.core.order.domain.dto;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemHolderDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderItemHolder#OrderItemHolder(OrderItem)}
   *   <li>{@link OrderItemHolder#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemHolder#getOrderItem()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemHolder.<init>(OrderItem)",
    "OrderItem OrderItemHolder.getOrderItem()",
    "void OrderItemHolder.setOrderItem(OrderItem)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemHolder actualOrderItemHolder = new OrderItemHolder(new BundleOrderItemImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemHolder.setOrderItem(orderItem);

    // Assert
    assertSame(orderItem, actualOrderItemHolder.getOrderItem());
  }
}
