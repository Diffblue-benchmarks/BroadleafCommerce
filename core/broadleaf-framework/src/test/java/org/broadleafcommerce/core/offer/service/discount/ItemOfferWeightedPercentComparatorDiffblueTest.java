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
package org.broadleafcommerce.core.offer.service.discount;

import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class ItemOfferWeightedPercentComparatorDiffblueTest {
  /**
   * Test
   * {@link ItemOfferWeightedPercentComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   * with {@code PromotableCandidateItemOffer},
   * {@code PromotableCandidateItemOffer}.
   * <p>
   * Method under test:
   * {@link ItemOfferWeightedPercentComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareWithPromotableCandidateItemOfferPromotableCandidateItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ItemOfferWeightedPercentComparator itemOfferWeightedPercentComparator = new ItemOfferWeightedPercentComparator();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl p1 = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferWeightedPercentComparator.compare(p1,
        new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test new {@link ItemOfferWeightedPercentComparator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ItemOfferWeightedPercentComparator}
   */
  @Test
  public void testNewItemOfferWeightedPercentComparator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     ItemOfferWeightedPercentComparator.INSTANCE

    // Arrange and Act
    new ItemOfferWeightedPercentComparator();
  }
}
