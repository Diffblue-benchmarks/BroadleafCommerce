package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableFulfillmentGroupAdjustmentImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#PromotableFulfillmentGroupAdjustmentImpl(PromotableCandidateFulfillmentGroupOffer, PromotableFulfillmentGroup, Money, Money)}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getAdjustmentValue()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getPromotableCandidateFulfillmentGroupOffer()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getPromotableFulfillmentGroup()}
   *   <li>
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getRetailAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#getSaleAdjustmentValue()}
   *   <li>{@link PromotableFulfillmentGroupAdjustmentImpl#isAppliedToSalePrice()}
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

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();
    Money saleAdjustmentValue = new Money();

    // Act
    PromotableFulfillmentGroupAdjustmentImpl actualPromotableFulfillmentGroupAdjustmentImpl = new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3, retailAdjustmentValue, saleAdjustmentValue);
    Money actualAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getAdjustmentValue();
    PromotableCandidateFulfillmentGroupOffer actualPromotableCandidateFulfillmentGroupOffer = actualPromotableFulfillmentGroupAdjustmentImpl
        .getPromotableCandidateFulfillmentGroupOffer();
    PromotableFulfillmentGroup actualPromotableFulfillmentGroup = actualPromotableFulfillmentGroupAdjustmentImpl
        .getPromotableFulfillmentGroup();
    Money actualRetailAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getRetailAdjustmentValue();
    Money actualSaleAdjustmentValue = actualPromotableFulfillmentGroupAdjustmentImpl.getSaleAdjustmentValue();
    boolean actualIsAppliedToSalePriceResult = actualPromotableFulfillmentGroupAdjustmentImpl.isAppliedToSalePrice();

    // Assert
    assertNull(actualPromotableFulfillmentGroupAdjustmentImpl.getRoundingScale());
    assertNull(actualAdjustmentValue);
    assertFalse(actualIsAppliedToSalePriceResult);
    assertSame(retailAdjustmentValue, actualRetailAdjustmentValue);
    assertSame(saleAdjustmentValue, actualSaleAdjustmentValue);
    assertSame(promotableCandidateFulfillmentGroupOffer, actualPromotableCandidateFulfillmentGroupOffer);
    assertSame(fulfillmentGroup3, actualPromotableFulfillmentGroup);
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getOffer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3,
        retailAdjustmentValue, new Money())).getOffer();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#getOffer()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getOffer()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetOffer2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.getOffer(PromotableFulfillmentGroupAdjustmentImpl.java:51)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(null, fulfillmentGroup2, retailAdjustmentValue, new Money()))
        .getOffer();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupAdjustmentImpl#computeAdjustmentValue(Money)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#computeAdjustmentValue(Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testComputeAdjustmentValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.getCurrency(PromotableFulfillmentGroupAdjustmentImpl.java:108)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.computeAdjustmentValue(PromotableFulfillmentGroupAdjustmentImpl.java:57)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();
    PromotableFulfillmentGroupAdjustmentImpl promotableFulfillmentGroupAdjustmentImpl = new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3, retailAdjustmentValue, new Money());

    // Act
    promotableFulfillmentGroupAdjustmentImpl.computeAdjustmentValue(new Money());
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupAdjustmentImpl#computeAdjustmentValue(Money)}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#computeAdjustmentValue(Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testComputeAdjustmentValue_givenFulfillmentGroupImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    FulfillmentGroupImpl fulfillmentGroup3 = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup3,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    Money retailAdjustmentValue = new Money();
    PromotableFulfillmentGroupAdjustmentImpl promotableFulfillmentGroupAdjustmentImpl = new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup2, retailAdjustmentValue, new Money());

    // Act
    promotableFulfillmentGroupAdjustmentImpl.computeAdjustmentValue(new Money());
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#getCurrency()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getCurrency()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.getCurrency(PromotableFulfillmentGroupAdjustmentImpl.java:108)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3,
        retailAdjustmentValue, new Money())).getCurrency();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#getCurrency()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#getCurrency()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCurrency_givenFulfillmentGroupImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    FulfillmentGroupImpl fulfillmentGroup3 = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup3,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup2,
        retailAdjustmentValue, new Money())).getCurrency();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#isCombinable()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#isCombinable()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCombinable() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3,
        retailAdjustmentValue, new Money())).isCombinable();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#isCombinable()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#isCombinable()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsCombinable2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.getOffer(PromotableFulfillmentGroupAdjustmentImpl.java:51)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.isCombinable(PromotableFulfillmentGroupAdjustmentImpl.java:113)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(null, fulfillmentGroup2, retailAdjustmentValue, new Money()))
        .isCombinable();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#isTotalitarian()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#isTotalitarian()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarian() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3,
        retailAdjustmentValue, new Money())).isTotalitarian();
  }

  /**
   * Test {@link PromotableFulfillmentGroupAdjustmentImpl#isTotalitarian()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#isTotalitarian()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarian2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.getOffer(PromotableFulfillmentGroupAdjustmentImpl.java:51)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupAdjustmentImpl.isTotalitarian(PromotableFulfillmentGroupAdjustmentImpl.java:119)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup2 = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(null, fulfillmentGroup2, retailAdjustmentValue, new Money()))
        .isTotalitarian();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupAdjustmentImpl#finalizeAdjustment(boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupAdjustmentImpl#finalizeAdjustment(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeAdjustment_whenTrue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup3 = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    (new PromotableFulfillmentGroupAdjustmentImpl(promotableCandidateFulfillmentGroupOffer, fulfillmentGroup3,
        retailAdjustmentValue, new Money())).finalizeAdjustment(true);
  }
}
