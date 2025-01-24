package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class ReconstructCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ReconstructCartResponse}
   *   <li>{@link ReconstructCartResponse#setOrder(Order)}
   *   <li>{@link ReconstructCartResponse#setRemovedItems(List)}
   *   <li>{@link ReconstructCartResponse#getOrder()}
   *   <li>{@link ReconstructCartResponse#getRemovedItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ReconstructCartResponse actualReconstructCartResponse = new ReconstructCartResponse();
    NullOrderImpl order = new NullOrderImpl();
    actualReconstructCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualReconstructCartResponse.setRemovedItems(removedItems);
    Order actualOrder = actualReconstructCartResponse.getOrder();

    // Assert that nothing has changed
    assertSame(removedItems, actualReconstructCartResponse.getRemovedItems());
    assertSame(order, actualOrder);
  }
}
