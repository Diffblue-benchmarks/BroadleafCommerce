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
package org.broadleafcommerce.core.order.domain.dto;

import static org.junit.Assert.assertSame;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class OrderItemHolderDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderItemHolder#OrderItemHolder(OrderItem)}
   *   <li>{@link OrderItemHolder#setOrderItem(OrderItem)}
   *   <li>{@link OrderItemHolder#getOrderItem()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OrderItemHolder actualOrderItemHolder = new OrderItemHolder(new BundleOrderItemImpl());
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    actualOrderItemHolder.setOrderItem(orderItem);

    // Assert that nothing has changed
    assertSame(orderItem, actualOrderItemHolder.getOrderItem());
  }
}
