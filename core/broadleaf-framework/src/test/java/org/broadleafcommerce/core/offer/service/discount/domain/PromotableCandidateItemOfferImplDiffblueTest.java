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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;

public class PromotableCandidateItemOfferImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setCandidateFixedTargetsMap(HashMap)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setCandidateQualifiersMap(HashMap)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setCandidateTargetsMap(HashMap)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setLegacyCandidateTargets(List)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setOriginalPrice(Money)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setPotentialSavings(Money)}
   *   <li>{@link PromotableCandidateItemOfferImpl#setPotentialSavingsQtyOne(Money)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setUseQtyOnlyTierCalculation(boolean)}
   *   <li>
   * {@link PromotableCandidateItemOfferImpl#setWeightedPercentSaved(BigDecimal)}
   *   <li>{@link PromotableCandidateItemOfferImpl#addUse()}
   *   <li>{@link PromotableCandidateItemOfferImpl#resetUses()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateFixedTargetsMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateQualifiersMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getCandidateTargetsMap()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getLegacyCandidateTargets()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getOffer()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getOriginalPrice()}
   *   <li>{@link PromotableCandidateItemOfferImpl#getUses()}
   *   <li>{@link PromotableCandidateItemOfferImpl#isUseQtyOnlyTierCalculation()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    PromotableCandidateItemOfferImpl promotableCandidateItemOfferImpl = new PromotableCandidateItemOfferImpl(
        promotableOrder, offer);
    HashMap<OfferPriceData, List<PromotableOrderItem>> candidateFixedTargetsMap = new HashMap<>();

    // Act
    promotableCandidateItemOfferImpl.setCandidateFixedTargetsMap(candidateFixedTargetsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap = new HashMap<>();
    promotableCandidateItemOfferImpl.setCandidateQualifiersMap(candidateItemsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap2 = new HashMap<>();
    promotableCandidateItemOfferImpl.setCandidateTargetsMap(candidateItemsMap2);
    ArrayList<PromotableOrderItem> candidateTargets = new ArrayList<>();
    promotableCandidateItemOfferImpl.setLegacyCandidateTargets(candidateTargets);
    Money originalPrice = new Money();
    promotableCandidateItemOfferImpl.setOriginalPrice(originalPrice);
    promotableCandidateItemOfferImpl.setPotentialSavings(new Money());
    promotableCandidateItemOfferImpl.setPotentialSavingsQtyOne(new Money());
    promotableCandidateItemOfferImpl.setUseQtyOnlyTierCalculation(true);
    promotableCandidateItemOfferImpl.setWeightedPercentSaved(new BigDecimal("2.3"));
    promotableCandidateItemOfferImpl.addUse();
    promotableCandidateItemOfferImpl.resetUses();
    HashMap<OfferPriceData, List<PromotableOrderItem>> actualCandidateFixedTargetsMap = promotableCandidateItemOfferImpl
        .getCandidateFixedTargetsMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap = promotableCandidateItemOfferImpl
        .getCandidateQualifiersMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateTargetsMap = promotableCandidateItemOfferImpl
        .getCandidateTargetsMap();
    List<PromotableOrderItem> actualLegacyCandidateTargets = promotableCandidateItemOfferImpl
        .getLegacyCandidateTargets();
    Offer actualOffer = promotableCandidateItemOfferImpl.getOffer();
    Money actualOriginalPrice = promotableCandidateItemOfferImpl.getOriginalPrice();
    int actualUses = promotableCandidateItemOfferImpl.getUses();
    boolean actualIsUseQtyOnlyTierCalculationResult = promotableCandidateItemOfferImpl.isUseQtyOnlyTierCalculation();

    // Assert that nothing has changed
    assertEquals(0, actualUses);
    assertTrue(actualLegacyCandidateTargets.isEmpty());
    assertTrue(actualIsUseQtyOnlyTierCalculationResult);
    assertSame(candidateTargets, actualLegacyCandidateTargets);
    assertSame(candidateFixedTargetsMap, actualCandidateFixedTargetsMap);
    assertSame(candidateItemsMap, actualCandidateQualifiersMap);
    assertSame(candidateItemsMap2, actualCandidateTargetsMap);
    assertSame(originalPrice, actualOriginalPrice);
    assertSame(offer, actualOffer);
  }
}
