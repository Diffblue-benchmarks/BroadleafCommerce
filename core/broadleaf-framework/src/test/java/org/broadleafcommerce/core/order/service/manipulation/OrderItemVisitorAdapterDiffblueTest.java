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

import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DynamicPriceDiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DynamicPriceDiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.junit.Test;

public class OrderItemVisitorAdapterDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderItemVisitorAdapter}
   *   <li>{@link OrderItemVisitorAdapter#visit(BundleOrderItem)}
   *   <li>{@link OrderItemVisitorAdapter#visit(DiscreteOrderItem)}
   *   <li>{@link OrderItemVisitorAdapter#visit(DynamicPriceDiscreteOrderItem)}
   *   <li>{@link OrderItemVisitorAdapter#visit(GiftWrapOrderItem)}
   *   <li>{@link OrderItemVisitorAdapter#visit(OrderItem)}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws PricingException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   There are no fields that could be asserted on.

    // Arrange and Act
    OrderItemVisitorAdapter actualOrderItemVisitorAdapter = new OrderItemVisitorAdapter();
    actualOrderItemVisitorAdapter.visit((BundleOrderItem) new BundleOrderItemImpl());
    actualOrderItemVisitorAdapter.visit((DiscreteOrderItem) new DiscreteOrderItemImpl());
    actualOrderItemVisitorAdapter.visit((DynamicPriceDiscreteOrderItem) new DynamicPriceDiscreteOrderItemImpl());
    actualOrderItemVisitorAdapter.visit((GiftWrapOrderItem) new GiftWrapOrderItemImpl());
    actualOrderItemVisitorAdapter.visit((OrderItem) new BundleOrderItemImpl());
  }
}
