package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class MergeCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MergeCartResponse}
   *   <li>{@link MergeCartResponse#setAddedItems(List)}
   *   <li>{@link MergeCartResponse#setMerged(boolean)}
   *   <li>{@link MergeCartResponse#setOrder(Order)}
   *   <li>{@link MergeCartResponse#setRemovedItems(List)}
   *   <li>{@link MergeCartResponse#getAddedItems()}
   *   <li>{@link MergeCartResponse#getOrder()}
   *   <li>{@link MergeCartResponse#getRemovedItems()}
   *   <li>{@link MergeCartResponse#isMerged()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MergeCartResponse actualMergeCartResponse = new MergeCartResponse();
    ArrayList<OrderItem> addedItems = new ArrayList<>();
    actualMergeCartResponse.setAddedItems(addedItems);
    actualMergeCartResponse.setMerged(true);
    NullOrderImpl order = new NullOrderImpl();
    actualMergeCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualMergeCartResponse.setRemovedItems(removedItems);
    List<OrderItem> actualAddedItems = actualMergeCartResponse.getAddedItems();
    Order actualOrder = actualMergeCartResponse.getOrder();
    List<OrderItem> actualRemovedItems = actualMergeCartResponse.getRemovedItems();
    boolean actualIsMergedResult = actualMergeCartResponse.isMerged();

    // Assert that nothing has changed
    assertTrue(actualAddedItems.isEmpty());
    assertTrue(actualIsMergedResult);
    assertSame(addedItems, actualAddedItems);
    assertSame(removedItems, actualRemovedItems);
    assertSame(order, actualOrder);
  }
}
