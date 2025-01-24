package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class UpdateCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateCartResponse}
   *   <li>{@link UpdateCartResponse#setOrder(Order)}
   *   <li>{@link UpdateCartResponse#setRemovedItems(List)}
   *   <li>{@link UpdateCartResponse#getOrder()}
   *   <li>{@link UpdateCartResponse#getRemovedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UpdateCartResponse actualUpdateCartResponse = new UpdateCartResponse();
    NullOrderImpl order = new NullOrderImpl();
    actualUpdateCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualUpdateCartResponse.setRemovedItems(removedItems);
    Order actualOrder = actualUpdateCartResponse.getOrder();

    // Assert that nothing has changed
    assertSame(removedItems, actualUpdateCartResponse.getRemovedItems());
    assertSame(order, actualOrder);
  }
}
