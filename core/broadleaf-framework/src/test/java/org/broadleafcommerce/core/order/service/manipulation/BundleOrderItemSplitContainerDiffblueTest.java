/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.core.order.service.manipulation;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BundleOrderItemSplitContainer}
   *   <li>{@link BundleOrderItemSplitContainer#setKey(BundleOrderItem)}
   *   <li>{@link BundleOrderItemSplitContainer#setSplitItems(List)}
   *   <li>{@link BundleOrderItemSplitContainer#getKey()}
   *   <li>{@link BundleOrderItemSplitContainer#getSplitItems()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BundleOrderItemSplitContainer.<init>()",
      "BundleOrderItem BundleOrderItemSplitContainer.getKey()", "List BundleOrderItemSplitContainer.getSplitItems()",
      "void BundleOrderItemSplitContainer.setKey(BundleOrderItem)",
      "void BundleOrderItemSplitContainer.setSplitItems(List)"})
  public void testGettersAndSetters() {
    // Arrange and Act
    BundleOrderItemSplitContainer actualBundleOrderItemSplitContainer = new BundleOrderItemSplitContainer();
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
