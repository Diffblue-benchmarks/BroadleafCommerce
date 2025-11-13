package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PromotableFulfillmentGroupAdjustmentImplDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link
   *       PromotableFulfillmentGroupAdjustmentImpl#PromotableFulfillmentGroupAdjustmentImpl(PromotableCandidateFulfillmentGroupOffer,
   *       PromotableFulfillmentGroup, Money, Money)}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getAdjustmentValue()}
   *   <li>{@link
   *       PromotableFulfillmentGroupAdjustmentImpl#getPromotableCandidateFulfillmentGroupOffer()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getPromotableFulfillmentGroup()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getRetailAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getSaleAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#isAppliedToSalePrice()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableFulfillmentGroupAdjustmentImpl.<init>(PromotableCandidateFulfillmentGroupOffer, PromotableFulfillmentGroup, Money, Money)",
    "Money PromotableFulfillmentGroupAdjustmentImpl.getAdjustmentValue()",
    "PromotableCandidateFulfillmentGroupOffer PromotableFulfillmentGroupAdjustmentImpl.getPromotableCandidateFulfillmentGroupOffer()",
    "PromotableFulfillmentGroup PromotableFulfillmentGroupAdjustmentImpl.getPromotableFulfillmentGroup()",
    "Money PromotableFulfillmentGroupAdjustmentImpl.getRetailAdjustmentValue()",
    "Money PromotableFulfillmentGroupAdjustmentImpl.getSaleAdjustmentValue()",
    "boolean PromotableFulfillmentGroupAdjustmentImpl.isAppliedToSalePrice()"
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
    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer =
        new PromotableCandidateFulfillmentGroupOfferImpl(
            promotableFulfillmentGroup, new OfferImpl());
    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 =
        new PromotableOrderImpl(
            order2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup2,
            promotableOrder2,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    Money retailAdjustmentValue = new Money();
    Money saleAdjustmentValue = new Money();

    // Act
    PromotableFulfillmentGroupAdjustmentImpl actualPromotableFulfillmentGroupAdjustmentImpl =
        new PromotableFulfillmentGroupAdjustmentImpl(
            promotableCandidateFulfillmentGroupOffer,
            fulfillmentGroup3,
            retailAdjustmentValue,
            saleAdjustmentValue);
    Money actualAdjustmentValue =
        actualPromotableFulfillmentGroupAdjustmentImpl.getAdjustmentValue();
    PromotableCandidateFulfillmentGroupOffer actualPromotableCandidateFulfillmentGroupOffer =
        actualPromotableFulfillmentGroupAdjustmentImpl
            .getPromotableCandidateFulfillmentGroupOffer();
    PromotableFulfillmentGroup actualPromotableFulfillmentGroup =
        actualPromotableFulfillmentGroupAdjustmentImpl.getPromotableFulfillmentGroup();
    Money actualRetailAdjustmentValue =
        actualPromotableFulfillmentGroupAdjustmentImpl.getRetailAdjustmentValue();
    Money actualSaleAdjustmentValue =
        actualPromotableFulfillmentGroupAdjustmentImpl.getSaleAdjustmentValue();
    boolean actualIsAppliedToSalePriceResult =
        actualPromotableFulfillmentGroupAdjustmentImpl.isAppliedToSalePrice();

    // Assert
    assertNull(actualPromotableFulfillmentGroupAdjustmentImpl.getRoundingScale());
    assertNull(actualAdjustmentValue);
    assertFalse(actualIsAppliedToSalePriceResult);
    assertSame(retailAdjustmentValue, actualRetailAdjustmentValue);
    assertSame(saleAdjustmentValue, actualSaleAdjustmentValue);
    assertSame(
        promotableCandidateFulfillmentGroupOffer, actualPromotableCandidateFulfillmentGroupOffer);
    assertSame(fulfillmentGroup3, actualPromotableFulfillmentGroup);
  }
}
