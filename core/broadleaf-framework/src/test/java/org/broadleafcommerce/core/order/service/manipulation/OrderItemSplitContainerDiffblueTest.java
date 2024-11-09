/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class OrderItemSplitContainerDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemSplitContainer}
   *   <li>{@link OrderItemSplitContainer#setKey(OrderItem)}
   *   <li>{@link OrderItemSplitContainer#setSplitItems(List)}
   *   <li>{@link OrderItemSplitContainer#getKey()}
   *   <li>{@link OrderItemSplitContainer#getSplitItems()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemSplitContainer actualOrderItemSplitContainer = new OrderItemSplitContainer();
    BundleOrderItemImpl key = new BundleOrderItemImpl();
    actualOrderItemSplitContainer.setKey(key);
    ArrayList<PromotableOrderItem> splitItems = new ArrayList<>();
    actualOrderItemSplitContainer.setSplitItems(splitItems);
    OrderItem actualKey = actualOrderItemSplitContainer.getKey();
    List<PromotableOrderItem> actualSplitItems = actualOrderItemSplitContainer.getSplitItems();

    // Assert that nothing has changed
    assertTrue(actualSplitItems.isEmpty());
    assertSame(splitItems, actualSplitItems);
    assertSame(key, actualKey);
  }
}
