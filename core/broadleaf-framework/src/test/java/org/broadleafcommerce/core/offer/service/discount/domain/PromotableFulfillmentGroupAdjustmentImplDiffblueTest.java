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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;

public class PromotableFulfillmentGroupAdjustmentImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#PromotableFulfillmentGroupAdjustmentImpl(PromotableCandidateFulfillmentGroupOffer, PromotableFulfillmentGroup, Money, Money)}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getAdjustmentValue()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getPromotableCandidateFulfillmentGroupOffer()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getPromotableFulfillmentGroup()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getRetailAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getSaleAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();
    Money saleAdjustmentValue = new Money();

    // Act
    PromotableFulfillmentGroupAdjustmentImpl actualPromotableFulfillmentGroupAdjustmentImpl = new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3, retailAdjustmentValue, saleAdjustmentValue);
    Money actualAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getAdjustmentValue();
    PromotableCandidateFulfillmentGroupOffer actualPromotableCandidateFulfillmentGroupOffer = actualPromotableFulfillmentGroupAdjustmentImpl
        .getPromotableCandidateFulfillmentGroupOffer();
    PromotableFulfillmentGroup actualPromotableFulfillmentGroup = actualPromotableFulfillmentGroupAdjustmentImpl
        .getPromotableFulfillmentGroup();
    Money actualRetailAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getRetailAdjustmentValue();
    Money actualSaleAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getSaleAdjustmentValue();
    boolean actualIsAppliedToSalePriceResult = actualPromotableFulfillmentGroupAdjustmentImpl.isAppliedToSalePrice();

    // Assert
    assertNull(actualPromotableFulfillmentGroupAdjustmentImpl.getRoundingScale());
    assertNull(actualAdjustmentValue);
    assertFalse(actualIsAppliedToSalePriceResult);
    assertSame(retailAdjustmentValue, actualRetailAdjustmentValue);
    assertSame(saleAdjustmentValue, actualSaleAdjustmentValue);
    assertSame(promotableCandidateFulfillmentGroupOffer, actualPromotableCandidateFulfillmentGroupOffer);
    assertSame(fulfillmentGroup3, actualPromotableFulfillmentGroup);
  }
}
