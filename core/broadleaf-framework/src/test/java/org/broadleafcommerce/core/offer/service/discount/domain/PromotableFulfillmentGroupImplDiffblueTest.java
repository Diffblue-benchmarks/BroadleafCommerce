package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableFulfillmentGroupImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableFulfillmentGroupImpl#PromotableFulfillmentGroupImpl(FulfillmentGroup, PromotableOrder, PromotableItemFactory)}
   *   <li>{@link PromotableFulfillmentGroupImpl#getFulfillmentGroup()}
   * </ul>
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGettersAndSetters() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableFulfillmentGroupImpl actualPromotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(
        fulfillmentGroup, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    FulfillmentGroup actualFulfillmentGroup = actualPromotableFulfillmentGroupImpl.getFulfillmentGroup();

    // Assert
    boolean actualIsEmptyResult = actualPromotableFulfillmentGroupImpl.candidateFulfillmentGroupAdjustments.isEmpty();
    boolean actualIsEmptyResult2 = ((PromotableOrderImpl) actualPromotableFulfillmentGroupImpl.promotableOrder).discountableOrderItems
        .isEmpty();
    assertTrue(actualIsEmptyResult);
    assertTrue(actualIsEmptyResult2);
    assertTrue(
        ((PromotableOrderImpl) actualPromotableFulfillmentGroupImpl.promotableOrder).fulfillmentGroups.isEmpty());
    assertSame(fulfillmentGroup, actualFulfillmentGroup);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#updateRuleVariables(Map)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#updateRuleVariables(Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateRuleVariables() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    promotableFulfillmentGroupImpl.updateRuleVariables(new HashMap<>());
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    order.setSubTotal(new Money());
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act and Assert
    PromotableOrder promotableOrder2 = promotableFulfillmentGroupImpl.promotableOrder;
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertTrue(promotableFulfillmentGroupImpl.getDiscountableOrderItems().isEmpty());
    assertSame(promotableOrder.allOrderItems, ((PromotableOrderImpl) promotableOrder2).allOrderItems);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getSalePriceBeforeAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getSalePriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePriceBeforeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).getSalePriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#getSalePriceBeforeAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getSalePriceBeforeAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetSalePriceBeforeAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.getSalePriceBeforeAdjustments(PromotableFulfillmentGroupImpl.java:97)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(null, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).getSalePriceBeforeAdjustments();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#calculateSaleAdjustmentPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculateSaleAdjustmentPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateSaleAdjustmentPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculateSaleAdjustmentPrice();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#calculateSaleAdjustmentPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculateSaleAdjustmentPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateSaleAdjustmentPrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.getSalePriceBeforeAdjustments(PromotableFulfillmentGroupImpl.java:97)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.calculateSaleAdjustmentPrice(PromotableFulfillmentGroupImpl.java:106)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(null, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculateSaleAdjustmentPrice();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#calculateRetailAdjustmentPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculateRetailAdjustmentPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateRetailAdjustmentPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculateRetailAdjustmentPrice();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#calculateRetailAdjustmentPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculateRetailAdjustmentPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateRetailAdjustmentPrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.calculateRetailAdjustmentPrice(PromotableFulfillmentGroupImpl.java:114)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(null, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculateRetailAdjustmentPrice();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#chooseSaleOrRetailAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.chooseSaleOrRetailAdjustments(PromotableFulfillmentGroupImpl.java:131)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#chooseSaleOrRetailAdjustments()}.
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments_givenFulfillmentGroupImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#finalizeAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#finalizeAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).finalizeAdjustments(true);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#removeRetailOnlyAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#removeRetailOnlyAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveRetailOnlyAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).removeRetailOnlyAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#removeZeroDollarAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#removeZeroDollarAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveZeroDollarAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).removeZeroDollarAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#removeZeroDollarAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#removeZeroDollarAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveZeroDollarAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.removeZeroDollarAdjustments(PromotableFulfillmentGroupImpl.java:176)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup3 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder3 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup4 = new PromotableFulfillmentGroupImpl(fulfillmentGroup3,
        promotableOrder3, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    promotableFulfillmentGroupImpl.addCandidateFulfillmentGroupAdjustment(new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup4, new Money(), null));

    // Act
    promotableFulfillmentGroupImpl.removeZeroDollarAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#getFinalizedPriceWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getFinalizedPriceWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedPriceWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    fulfillmentGroup.setOrder(new NullOrderImpl());
    fulfillmentGroup.setRetailFulfillmentPrice(new Money());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).getFinalizedPriceWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#getFinalizedPriceWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getFinalizedPriceWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedPriceWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.chooseSaleOrRetailAdjustments(PromotableFulfillmentGroupImpl.java:131)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.getFinalizedPriceWithAdjustments(PromotableFulfillmentGroupImpl.java:189)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).getFinalizedPriceWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithoutAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePriceWithoutAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculatePriceWithoutAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithoutAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePriceWithoutAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.calculatePriceWithoutAdjustments(PromotableFulfillmentGroupImpl.java:195)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(null, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculatePriceWithoutAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#addCandidateFulfillmentGroupAdjustment(PromotableFulfillmentGroupAdjustment)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#addCandidateFulfillmentGroupAdjustment(PromotableFulfillmentGroupAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCandidateFulfillmentGroupAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    PromotableCandidateFulfillmentGroupOfferImpl promotableCandidateFulfillmentGroupOffer = new PromotableCandidateFulfillmentGroupOfferImpl(
        promotableFulfillmentGroup, new OfferImpl());

    FulfillmentGroupImpl fulfillmentGroup3 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder3 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl fulfillmentGroup4 = new PromotableFulfillmentGroupImpl(fulfillmentGroup3,
        promotableOrder3, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    Money retailAdjustmentValue = new Money();

    // Act
    promotableFulfillmentGroupImpl.addCandidateFulfillmentGroupAdjustment(new PromotableFulfillmentGroupAdjustmentImpl(
        promotableCandidateFulfillmentGroupOffer, fulfillmentGroup4, retailAdjustmentValue, new Money()));
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#getCandidateFulfillmentGroupAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#getCandidateFulfillmentGroupAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCandidateFulfillmentGroupAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).getCandidateFulfillmentGroupAdjustments();
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#canApplyOffer(PromotableCandidateFulfillmentGroupOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#canApplyOffer(PromotableCandidateFulfillmentGroupOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCanApplyOffer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl = new PromotableFulfillmentGroupImpl(fulfillmentGroup,
        promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    FulfillmentGroupImpl fulfillmentGroup2 = new FulfillmentGroupImpl();
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroup = new PromotableFulfillmentGroupImpl(fulfillmentGroup2,
        promotableOrder2, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    // Act
    promotableFulfillmentGroupImpl
        .canApplyOffer(new PromotableCandidateFulfillmentGroupOfferImpl(promotableFulfillmentGroup, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePriceWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculatePriceWithAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#calculatePriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculatePriceWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.getSalePriceBeforeAdjustments(PromotableFulfillmentGroupImpl.java:97)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.calculateSaleAdjustmentPrice(PromotableFulfillmentGroupImpl.java:106)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl.calculatePriceWithAdjustments(PromotableFulfillmentGroupImpl.java:231)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(null, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).calculatePriceWithAdjustments(true);
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#isTotalitarianOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarianOfferApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).isTotalitarianOfferApplied();
  }

  /**
   * Test {@link PromotableFulfillmentGroupImpl#removeAllCandidateAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableFulfillmentGroupImpl#removeAllCandidateAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllCandidateAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableFulfillmentGroupImpl(fulfillmentGroup, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()))).removeAllCandidateAdjustments();
  }
}
