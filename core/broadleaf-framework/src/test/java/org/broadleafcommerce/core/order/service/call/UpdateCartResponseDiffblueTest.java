package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UpdateCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UpdateCartResponse}
   *   <li>{@link UpdateCartResponse#setOrder(Order)}
   *   <li>{@link UpdateCartResponse#setRemovedItems(List)}
   *   <li>{@link UpdateCartResponse#getOrder()}
   *   <li>{@link UpdateCartResponse#getRemovedItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UpdateCartResponse.<init>()",
    "Order UpdateCartResponse.getOrder()",
    "List UpdateCartResponse.getRemovedItems()",
    "void UpdateCartResponse.setOrder(Order)",
    "void UpdateCartResponse.setRemovedItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UpdateCartResponse actualUpdateCartResponse = new UpdateCartResponse();
    NullOrderImpl order = new NullOrderImpl();
    actualUpdateCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualUpdateCartResponse.setRemovedItems(removedItems);
    Order actualOrder = actualUpdateCartResponse.getOrder();

    // Assert
    assertSame(removedItems, actualUpdateCartResponse.getRemovedItems());
    assertSame(order, actualOrder);
  }
}
