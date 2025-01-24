package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableCandidateFulfillmentGroupOfferImplDiffblueTest {
  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#PromotableCandidateFulfillmentGroupOfferImpl(PromotableFulfillmentGroup, Offer)}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#PromotableCandidateFulfillmentGroupOfferImpl(PromotableFulfillmentGroup, Offer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableCandidateFulfillmentGroupOfferImpl() {
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
    new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl());

  }

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

  /**
   * Test {@link PromotableCandidateFulfillmentGroupOfferImpl#getBasePrice()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getBasePrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBasePrice() {
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
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).getBasePrice();
  }

  /**
   * Test {@link PromotableCandidateFulfillmentGroupOfferImpl#getBasePrice()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getBasePrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetBasePrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.getBasePrice(PromotableCandidateFulfillmentGroupOfferImpl.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(null,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).getBasePrice();
  }

  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#computeDiscountedAmount()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#computeDiscountedAmount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testComputeDiscountedAmount() {
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
        .computeDiscountedAmount();
  }

  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#computeDiscountedAmount()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#computeDiscountedAmount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testComputeDiscountedAmount2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.getBasePrice(PromotableCandidateFulfillmentGroupOfferImpl.java:57)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.computeDiscountedAmount(PromotableCandidateFulfillmentGroupOfferImpl.java:69)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(null,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()))
        .computeDiscountedAmount();
  }

  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDiscountedPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.getDiscountedPrice(PromotableCandidateFulfillmentGroupOfferImpl.java:88)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()))
        .getDiscountedPrice();
  }

  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedAmount()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedAmount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDiscountedAmount() {
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
        .getDiscountedAmount();
  }

  /**
   * Test
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedAmount()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getDiscountedAmount()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetDiscountedAmount2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.getBasePrice(PromotableCandidateFulfillmentGroupOfferImpl.java:57)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.computeDiscountedAmount(PromotableCandidateFulfillmentGroupOfferImpl.java:69)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl.getDiscountedAmount(PromotableCandidateFulfillmentGroupOfferImpl.java:93)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(null,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()))
        .getDiscountedAmount();
  }

  /**
   * Test {@link PromotableCandidateFulfillmentGroupOfferImpl#getPriority()}.
   * <p>
   * Method under test:
   * {@link PromotableCandidateFulfillmentGroupOfferImpl#getPriority()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPriority() {
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
    (new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl())).getPriority();
  }
}
