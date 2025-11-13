package org.broadleafcommerce.core.offer.service.discount;

import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferPriceData;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CandidatePromotionItemsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CandidatePromotionItems.<init>()",
    "HashMap CandidatePromotionItems.getCandidateFixedTargetsMap()",
    "HashMap CandidatePromotionItems.getCandidateQualifiersMap()",
    "HashMap CandidatePromotionItems.getCandidateTargetsMap()",
    "boolean CandidatePromotionItems.isMatchedQualifier()",
    "boolean CandidatePromotionItems.isMatchedTarget()",
    "void CandidatePromotionItems.setMatchedQualifier(boolean)",
    "void CandidatePromotionItems.setMatchedTarget(boolean)"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    CandidatePromotionItems actualCandidatePromotionItems = new CandidatePromotionItems();
    actualCandidatePromotionItems.setMatchedQualifier(true);
    actualCandidatePromotionItems.setMatchedTarget(true);
    HashMap<OfferPriceData, List<PromotableOrderItem>> actualCandidateFixedTargetsMap =
        actualCandidatePromotionItems.getCandidateFixedTargetsMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap =
        actualCandidatePromotionItems.getCandidateQualifiersMap();
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateTargetsMap =
        actualCandidatePromotionItems.getCandidateTargetsMap();
    boolean actualIsMatchedQualifierResult = actualCandidatePromotionItems.isMatchedQualifier();
    boolean actualIsMatchedTargetResult = actualCandidatePromotionItems.isMatchedTarget();

    // Assert
    assertTrue(actualCandidateFixedTargetsMap.isEmpty());
    assertTrue(actualCandidateQualifiersMap.isEmpty());
    assertTrue(actualCandidateTargetsMap.isEmpty());
    assertTrue(actualIsMatchedQualifierResult);
    assertTrue(actualIsMatchedTargetResult);
  }
}
