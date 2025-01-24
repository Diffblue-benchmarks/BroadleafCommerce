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

public class ItemOfferComparatorDiffblueTest {
  /**
   * Test
   * {@link ItemOfferComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   * with {@code PromotableCandidateItemOffer},
   * {@code PromotableCandidateItemOffer}.
   * <p>
   * Method under test:
   * {@link ItemOfferComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareWithPromotableCandidateItemOfferPromotableCandidateItemOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ItemOfferComparator itemOfferComparator = new ItemOfferComparator();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl p1 = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferComparator.compare(p1, new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link ItemOfferComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   * with {@code PromotableCandidateItemOffer},
   * {@code PromotableCandidateItemOffer}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferComparator#compare(PromotableCandidateItemOffer, PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCompareWithPromotableCandidateItemOfferPromotableCandidateItemOffer_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.ItemOfferComparator.compare(ItemOfferComparator.java:35)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    ItemOfferComparator itemOfferComparator = new ItemOfferComparator();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    itemOfferComparator.compare(null, new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test new {@link ItemOfferComparator} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ItemOfferComparator}
   */
  @Test
  public void testNewItemOfferComparator() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     ItemOfferComparator.INSTANCE

    // Arrange and Act
    new ItemOfferComparator();
  }
}
