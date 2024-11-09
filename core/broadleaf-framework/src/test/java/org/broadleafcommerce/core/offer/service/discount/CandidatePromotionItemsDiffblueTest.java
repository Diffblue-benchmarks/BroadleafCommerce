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
package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.junit.Test;

public class CandidatePromotionItemsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CandidatePromotionItems}
   *   <li>{@link CandidatePromotionItems#setMatchedQualifier(boolean)}
   *   <li>{@link CandidatePromotionItems#setMatchedTarget(boolean)}
   *   <li>{@link CandidatePromotionItems#getCandidateFixedTargetsMap()}
   *   <li>{@link CandidatePromotionItems#getCandidateQualifiersMap()}
   *   <li>{@link CandidatePromotionItems#getCandidateTargetsMap()}
   *   <li>{@link CandidatePromotionItems#isMatchedQualifier()}
   *   <li>{@link CandidatePromotionItems#isMatchedTarget()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidatePromotionItems actualCandidatePromotionItems = new CandidatePromotionItems();
    actualCandidatePromotionItems.setMatchedQualifier(true);
    actualCandidatePromotionItems.setMatchedTarget(true);
    HashMap<OfferPriceData, List<PromotableOrderItem>> actualCandidateFixedTargetsMap = actualCandidatePromotionItems
        .getCandidateFixedTargetsMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap = actualCandidatePromotionItems
        .getCandidateQualifiersMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateTargetsMap = actualCandidatePromotionItems
        .getCandidateTargetsMap();
    boolean actualIsMatchedQualifierResult = actualCandidatePromotionItems.isMatchedQualifier();
    boolean actualIsMatchedTargetResult = actualCandidatePromotionItems.isMatchedTarget();

    // Assert that nothing has changed
    assertTrue(actualCandidateFixedTargetsMap.isEmpty());
    assertTrue(actualCandidateQualifiersMap.isEmpty());
    assertTrue(actualCandidateTargetsMap.isEmpty());
    assertTrue(actualIsMatchedQualifierResult);
    assertTrue(actualIsMatchedTargetResult);
  }
}
