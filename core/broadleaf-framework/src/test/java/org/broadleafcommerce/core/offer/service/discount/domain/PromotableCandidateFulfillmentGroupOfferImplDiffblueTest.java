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
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;

public class PromotableCandidateFulfillmentGroupOfferImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#setCandidateQualifiersMap(HashMap)}
   *   <li>
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getCandidateQualifiersMap()}
   *   <li>
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getFulfillmentGroup()}
   *   <li>{@link PromotableCandidateFulfillmentGroupOfferImpl#getOffer()}
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

    OfferImpl offer = new OfferImpl();
    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOfferImpl = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, offer);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap = new HashMap<>();

    // Act
    promotableCandidateFulfillmentGroupOfferImpl.setCandidateQualifiersMap(candidateItemsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap = promotableCandidateFulfillmentGroupOfferImpl
        .getCandidateQualifiersMap();
    PromotableFulfillmentGroup actualFulfillmentGroup = promotableCandidateFulfillmentGroupOfferImpl
        .getFulfillmentGroup();

    // Assert that nothing has changed
    assertSame(candidateItemsMap, actualCandidateQualifiersMap);
    assertSame(offer, promotableCandidateFulfillmentGroupOfferImpl.getOffer());
    assertSame(promotableFulfillmentGroup, actualFulfillmentGroup);
  }
}
