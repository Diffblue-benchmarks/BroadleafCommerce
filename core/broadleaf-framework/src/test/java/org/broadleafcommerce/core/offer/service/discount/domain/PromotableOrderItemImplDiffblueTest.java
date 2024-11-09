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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;

public class PromotableOrderItemImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotableOrderItemImpl#getExtraDataMap()}
   *   <li>{@link PromotableOrderItemImpl#getOrderItem()}
   *   <li>{@link PromotableOrderItemImpl#getPromotableOrderItemPriceDetails()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItemImpl = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    Map<String, Object> actualExtraDataMap = promotableOrderItemImpl.getExtraDataMap();
    OrderItem actualOrderItem = promotableOrderItemImpl.getOrderItem();

    // Assert
    assertTrue(promotableOrderItemImpl.getPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(actualExtraDataMap.isEmpty());
    assertSame(promotableOrderItemImpl.orderItem, actualOrderItem);
  }
}
