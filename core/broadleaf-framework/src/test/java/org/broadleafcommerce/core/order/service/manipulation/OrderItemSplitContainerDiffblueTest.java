package org.broadleafcommerce.core.order.service.manipulation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class OrderItemSplitContainerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemSplitContainer}
   *   <li>{@link OrderItemSplitContainer#setKey(OrderItem)}
   *   <li>{@link OrderItemSplitContainer#setSplitItems(List)}
   *   <li>{@link OrderItemSplitContainer#getKey()}
   *   <li>{@link OrderItemSplitContainer#getSplitItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderItemSplitContainer.<init>()",
    "OrderItem OrderItemSplitContainer.getKey()",
    "List OrderItemSplitContainer.getSplitItems()",
    "void OrderItemSplitContainer.setKey(OrderItem)",
    "void OrderItemSplitContainer.setSplitItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemSplitContainer actualOrderItemSplitContainer = new OrderItemSplitContainer();
    BundleOrderItemImpl key = new BundleOrderItemImpl();
    actualOrderItemSplitContainer.setKey(key);
    ArrayList<PromotableOrderItem> splitItems = new ArrayList<>();
    actualOrderItemSplitContainer.setSplitItems(splitItems);
    OrderItem actualKey = actualOrderItemSplitContainer.getKey();
    List<PromotableOrderItem> actualSplitItems = actualOrderItemSplitContainer.getSplitItems();

    // Assert
    assertTrue(actualSplitItems.isEmpty());
    assertSame(splitItems, actualSplitItems);
    assertSame(key, actualKey);
  }
}
