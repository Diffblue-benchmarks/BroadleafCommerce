package org.broadleafcommerce.core.order.service.manipulation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.junit.Test;

public class BundleOrderItemSplitContainerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BundleOrderItemSplitContainer}
   *   <li>{@link BundleOrderItemSplitContainer#setKey(BundleOrderItem)}
   *   <li>{@link BundleOrderItemSplitContainer#setSplitItems(List)}
   *   <li>{@link BundleOrderItemSplitContainer#getKey()}
   *   <li>{@link BundleOrderItemSplitContainer#getSplitItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    BundleOrderItemSplitContainer actualBundleOrderItemSplitContainer = new BundleOrderItemSplitContainer();
    BundleOrderItemImpl key = new BundleOrderItemImpl();
    actualBundleOrderItemSplitContainer.setKey(key);
    ArrayList<BundleOrderItem> splitItems = new ArrayList<>();
    actualBundleOrderItemSplitContainer.setSplitItems(splitItems);
    BundleOrderItem actualKey = actualBundleOrderItemSplitContainer.getKey();
    List<BundleOrderItem> actualSplitItems = actualBundleOrderItemSplitContainer.getSplitItems();

    // Assert that nothing has changed
    assertTrue(actualSplitItems.isEmpty());
    assertSame(splitItems, actualSplitItems);
    assertSame(key, actualKey);
  }
}
