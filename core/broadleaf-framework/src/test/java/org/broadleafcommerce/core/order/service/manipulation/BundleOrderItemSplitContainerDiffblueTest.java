package org.broadleafcommerce.core.order.service.manipulation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class BundleOrderItemSplitContainerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link BundleOrderItemSplitContainer}
   *   <li>{@link BundleOrderItemSplitContainer#setKey(BundleOrderItem)}
   *   <li>{@link BundleOrderItemSplitContainer#setSplitItems(List)}
   *   <li>{@link BundleOrderItemSplitContainer#getKey()}
   *   <li>{@link BundleOrderItemSplitContainer#getSplitItems()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BundleOrderItemSplitContainer.<init>()",
    "BundleOrderItem BundleOrderItemSplitContainer.getKey()",
    "List BundleOrderItemSplitContainer.getSplitItems()",
    "void BundleOrderItemSplitContainer.setKey(BundleOrderItem)",
    "void BundleOrderItemSplitContainer.setSplitItems(List)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    BundleOrderItemSplitContainer actualBundleOrderItemSplitContainer =
        new BundleOrderItemSplitContainer();
    BundleOrderItemImpl key = new BundleOrderItemImpl();
    actualBundleOrderItemSplitContainer.setKey(key);
    ArrayList<BundleOrderItem> splitItems = new ArrayList<>();
    actualBundleOrderItemSplitContainer.setSplitItems(splitItems);
    BundleOrderItem actualKey = actualBundleOrderItemSplitContainer.getKey();
    List<BundleOrderItem> actualSplitItems = actualBundleOrderItemSplitContainer.getSplitItems();

    // Assert
    assertTrue(actualSplitItems.isEmpty());
    assertSame(splitItems, actualSplitItems);
    assertSame(key, actualKey);
  }
}
