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

public class ReconstructCartResponseDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ReconstructCartResponse}
   *   <li>{@link ReconstructCartResponse#setOrder(Order)}
   *   <li>{@link ReconstructCartResponse#setRemovedItems(List)}
   *   <li>{@link ReconstructCartResponse#getOrder()}
   *   <li>{@link ReconstructCartResponse#getRemovedItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ReconstructCartResponse.<init>()",
    "Order ReconstructCartResponse.getOrder()",
    "List ReconstructCartResponse.getRemovedItems()",
    "void ReconstructCartResponse.setOrder(Order)",
    "void ReconstructCartResponse.setRemovedItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ReconstructCartResponse actualReconstructCartResponse = new ReconstructCartResponse();
    NullOrderImpl order = new NullOrderImpl();
    actualReconstructCartResponse.setOrder(order);
    ArrayList<OrderItem> removedItems = new ArrayList<>();
    actualReconstructCartResponse.setRemovedItems(removedItems);
    Order actualOrder = actualReconstructCartResponse.getOrder();

    // Assert
    assertSame(removedItems, actualReconstructCartResponse.getRemovedItems());
    assertSame(order, actualOrder);
  }
}
