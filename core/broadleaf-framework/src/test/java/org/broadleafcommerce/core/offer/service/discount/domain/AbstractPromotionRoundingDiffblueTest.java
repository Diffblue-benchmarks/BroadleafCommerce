package org.broadleafcommerce.core.offer.service.discount.domain;

import java.math.RoundingMode;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class AbstractPromotionRoundingDiffblueTest {
  /**
   * Test {@link AbstractPromotionRounding#setRoundingScale(int)}.
   * <p>
   * Method under test: {@link AbstractPromotionRounding#setRoundingScale(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetRoundingScale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).setRoundingScale(1);
  }

  /**
   * Test {@link AbstractPromotionRounding#setRoundingMode(RoundingMode)}.
   * <p>
   * Method under test:
   * {@link AbstractPromotionRounding#setRoundingMode(RoundingMode)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetRoundingMode() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()))
        .setRoundingMode(RoundingMode.UP);
  }

  /**
   * Test {@link AbstractPromotionRounding#getRoundingMode()}.
   * <p>
   * Method under test: {@link AbstractPromotionRounding#getRoundingMode()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRoundingMode() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).getRoundingMode();
  }

  /**
   * Test {@link AbstractPromotionRounding#getRoundingScale()}.
   * <p>
   * Method under test: {@link AbstractPromotionRounding#getRoundingScale()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetRoundingScale() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).getRoundingScale();
  }
}
