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
package org.broadleafcommerce.core.order.service.call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class FulfillmentGroupItemRequestDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FulfillmentGroupItemRequest}
   *   <li>{@link FulfillmentGroupItemRequest#setFulfillmentGroup(FulfillmentGroup)}
   *   <li>{@link FulfillmentGroupItemRequest#setOrder(Order)}
   *   <li>{@link FulfillmentGroupItemRequest#setOrderItem(OrderItem)}
   *   <li>{@link FulfillmentGroupItemRequest#setQuantity(int)}
   *   <li>{@link FulfillmentGroupItemRequest#getFulfillmentGroup()}
   *   <li>{@link FulfillmentGroupItemRequest#getOrder()}
   *   <li>{@link FulfillmentGroupItemRequest#getOrderItem()}
   *   <li>{@link FulfillmentGroupItemRequest#getQuantity()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    FulfillmentGroupItemRequest actualFulfillmentGroupItemRequest = new FulfillmentGroupItemRequest();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    actualFulfillmentGroupItemRequest.setFulfillmentGroup(fulfillmentGroup);
    NullOrderImpl order = new NullOrderImpl();
    actualFulfillmentGroupItemRequest.setOrder(order);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualFulfillmentGroupItemRequest.setOrderItem(orderItem);
    actualFulfillmentGroupItemRequest.setQuantity(1);
    FulfillmentGroup actualFulfillmentGroup = actualFulfillmentGroupItemRequest.getFulfillmentGroup();
    Order actualOrder = actualFulfillmentGroupItemRequest.getOrder();
    OrderItem actualOrderItem = actualFulfillmentGroupItemRequest.getOrderItem();

    // Assert that nothing has changed
    assertTrue(actualOrderItem instanceof BundleOrderItemImpl);
    assertEquals(1, actualFulfillmentGroupItemRequest.getQuantity());
    assertSame(orderItem, actualOrderItem);
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
    assertSame(order, actualOrder);
  }
}
