package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotableCandidateFulfillmentGroupOfferImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PromotableCandidateFulfillmentGroupOfferImpl#setCandidateQualifiersMap(HashMap)}
   *   <li>{@link PromotableCandidateFulfillmentGroupOfferImpl#getCandidateQualifiersMap()}
   *   <li>{@link PromotableCandidateFulfillmentGroupOfferImpl#getFulfillmentGroup()}
   *   <li>{@link PromotableCandidateFulfillmentGroupOfferImpl#getOffer()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "HashMap PromotableCandidateFulfillmentGroupOfferImpl.getCandidateQualifiersMap()",
    "PromotableFulfillmentGroup PromotableCandidateFulfillmentGroupOfferImpl.getFulfillmentGroup()",
    "org.broadleafcommerce.core.offer.domain.Offer PromotableCandidateFulfillmentGroupOfferImpl.getOffer()",
    "void PromotableCandidateFulfillmentGroupOfferImpl.setCandidateQualifiersMap(HashMap)"
  })
  public void testGettersAndSetters() {
    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    OfferImpl offer = new OfferImpl();

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOfferImpl =
        new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, offer);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> candidateItemsMap = new HashMap<>();

    // Act
    promotableCandidateFulfillmentGroupOfferImpl.setCandidateQualifiersMap(candidateItemsMap);
    HashMap<OfferItemCriteria, List<PromotableOrderItem>> actualCandidateQualifiersMap =
        promotableCandidateFulfillmentGroupOfferImpl.getCandidateQualifiersMap();
    PromotableFulfillmentGroup actualFulfillmentGroup =
        promotableCandidateFulfillmentGroupOfferImpl.getFulfillmentGroup();

    // Assert
    assertSame(candidateItemsMap, actualCandidateQualifiersMap);
    assertSame(offer, promotableCandidateFulfillmentGroupOfferImpl.getOffer());
    assertSame(promotableFulfillmentGroup, actualFulfillmentGroup);
  }
}
