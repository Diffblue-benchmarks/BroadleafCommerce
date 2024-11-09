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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.broadleafcommerce.core.offer.service.discount.PromotionDiscount;
import org.broadleafcommerce.core.offer.service.discount.PromotionQualifier;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;

public class PromotableOrderItemPriceDetailImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableOrderItemPriceDetailImpl#PromotableOrderItemPriceDetailImpl(PromotableOrderItem, int)}
   *   <li>
   * {@link PromotableOrderItemPriceDetailImpl#setAdjustmentsFinalized(boolean)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotableOrderItem()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionDiscounts()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionQualifiers()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getQuantity()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#isAdjustmentsFinalized()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#useSaleAdjustments()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItem = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderItemPriceDetailImpl actualPromotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        promotableOrderItem, 1);
    actualPromotableOrderItemPriceDetailImpl.setAdjustmentsFinalized(true);
    actualPromotableOrderItemPriceDetailImpl.setQuantity(1);
    PromotableOrderItem actualPromotableOrderItem = actualPromotableOrderItemPriceDetailImpl.getPromotableOrderItem();
    List<PromotionDiscount> actualPromotionDiscounts = actualPromotableOrderItemPriceDetailImpl.getPromotionDiscounts();
    List<PromotionQualifier> actualPromotionQualifiers = actualPromotableOrderItemPriceDetailImpl
        .getPromotionQualifiers();
    int actualQuantity = actualPromotableOrderItemPriceDetailImpl.getQuantity();
    boolean actualIsAdjustmentsFinalizedResult = actualPromotableOrderItemPriceDetailImpl.isAdjustmentsFinalized();

    // Assert that nothing has changed
    assertEquals(1, actualQuantity);
    assertFalse(actualPromotableOrderItemPriceDetailImpl.useSaleAdjustments());
    assertTrue(actualPromotionDiscounts.isEmpty());
    assertTrue(actualPromotionQualifiers.isEmpty());
    assertTrue(actualPromotableOrderItemPriceDetailImpl.promotableOrderItemPriceDetailAdjustments.isEmpty());
    assertTrue(actualIsAdjustmentsFinalizedResult);
    assertSame(promotableOrderItem, actualPromotableOrderItem);
  }
}
