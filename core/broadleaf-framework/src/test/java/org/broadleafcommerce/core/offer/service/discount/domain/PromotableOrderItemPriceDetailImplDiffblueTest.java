package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.discount.PromotionDiscount;
import org.broadleafcommerce.core.offer.service.discount.PromotionQualifier;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Ignore;
import org.junit.Test;

public class PromotableOrderItemPriceDetailImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PromotableOrderItemPriceDetailImpl#PromotableOrderItemPriceDetailImpl(PromotableOrderItem, int)}
   *   <li>
   * {@link PromotableOrderItemPriceDetailImpl#setAdjustmentsFinalized(boolean)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#setQuantity(int)}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotableOrderItem()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionDiscounts()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getPromotionQualifiers()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#getQuantity()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#isAdjustmentsFinalized()}
   *   <li>{@link PromotableOrderItemPriceDetailImpl#useSaleAdjustments()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemImpl promotableOrderItem = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderItemPriceDetailImpl actualPromotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        promotableOrderItem, 1);
    actualPromotableOrderItemPriceDetailImpl.setAdjustmentsFinalized(true);
    actualPromotableOrderItemPriceDetailImpl.setQuantity(1);
    PromotableOrderItem actualPromotableOrderItem = actualPromotableOrderItemPriceDetailImpl.getPromotableOrderItem();
    List<PromotionDiscount> actualPromotionDiscounts = actualPromotableOrderItemPriceDetailImpl.getPromotionDiscounts();
    List<PromotionQualifier> actualPromotionQualifiers = actualPromotableOrderItemPriceDetailImpl
        .getPromotionQualifiers();
    int actualQuantity = actualPromotableOrderItemPriceDetailImpl.getQuantity();
    boolean actualIsAdjustmentsFinalizedResult = actualPromotableOrderItemPriceDetailImpl.isAdjustmentsFinalized();

    // Assert that nothing has changed
    assertEquals(1, actualQuantity);
    assertFalse(actualPromotableOrderItemPriceDetailImpl.useSaleAdjustments());
    assertTrue(actualPromotionDiscounts.isEmpty());
    assertTrue(actualPromotionQualifiers.isEmpty());
    assertTrue(actualPromotableOrderItemPriceDetailImpl.promotableOrderItemPriceDetailAdjustments.isEmpty());
    assertTrue(actualIsAdjustmentsFinalizedResult);
    assertSame(promotableOrderItem, actualPromotableOrderItem);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCandidateItemPriceDetailAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl.getCurrency(OrderItemPriceDetailAdjustmentImpl.java:213)
    //       at org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl.getValue(OrderItemPriceDetailAdjustmentImpl.java:222)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailAdjustmentImpl.<init>(PromotableOrderItemPriceDetailAdjustmentImpl.java:53)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    promotableOrderItemPriceDetailImpl.addCandidateItemPriceDetailAdjustment(
        new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment, new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(mock(PromotableOrderItem.class), 1))));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCandidateItemPriceDetailAdjustment_whenNull() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1))
            .addCandidateItemPriceDetailAdjustment(null);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#getCandidateItemAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#getCandidateItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCandidateItemAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).getCandidateItemAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#hasNonCombinableAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#hasNonCombinableAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasNonCombinableAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).hasNonCombinableAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#hasOrderItemAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#hasOrderItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasOrderItemAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).hasOrderItemAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#isTotalitarianOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarianOfferApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).isTotalitarianOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#isNonCombinableOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#isNonCombinableOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsNonCombinableOfferApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).isNonCombinableOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateSaleAdjustmentUnitPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateSaleAdjustmentUnitPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateSaleAdjustmentUnitPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateSaleAdjustmentUnitPrice();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateSaleAdjustmentUnitPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateSaleAdjustmentUnitPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateSaleAdjustmentUnitPrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateSaleAdjustmentUnitPrice(PromotableOrderItemPriceDetailImpl.java:108)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateSaleAdjustmentUnitPrice();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateRetailAdjustmentUnitPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateRetailAdjustmentUnitPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateRetailAdjustmentUnitPrice() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1))
            .calculateRetailAdjustmentUnitPrice();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateRetailAdjustmentUnitPrice()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateRetailAdjustmentUnitPrice()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateRetailAdjustmentUnitPrice2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateRetailAdjustmentUnitPrice(PromotableOrderItemPriceDetailImpl.java:119)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1))
            .calculateRetailAdjustmentUnitPrice();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#buildPreciseMoneyFromAdjustment(Money, Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#buildPreciseMoneyFromAdjustment(Money, Money)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildPreciseMoneyFromAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    Money original = new Money();

    // Act
    promotableOrderItemPriceDetailImpl.buildPreciseMoneyFromAdjustment(original, new Money());
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#chooseSaleOrRetailAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.chooseSaleOrRetailAdjustments(PromotableOrderItemPriceDetailImpl.java:144)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#chooseSaleOrRetailAdjustments()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#removeAllAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#removeAllAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).removeAllAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#removeAllAdjustments()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#removeAllAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).removeAllAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#finalizeAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#finalizeAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).finalizeAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#removeRetailOnlyAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#removeRetailOnlyAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveRetailOnlyAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).removeRetailOnlyAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#removeZeroDollarAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#removeZeroDollarAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveZeroDollarAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).removeZeroDollarAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsTarget() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailImpl
        .getQuantityAvailableToBeUsedAsTarget(new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#lookupOrCreatePromotionQualifier(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#lookupOrCreatePromotionQualifier(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupOrCreatePromotionQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailImpl
        .lookupOrCreatePromotionQualifier(new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#lookupOrCreatePromotionDiscount(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#lookupOrCreatePromotionDiscount(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupOrCreatePromotionDiscount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailImpl
        .lookupOrCreatePromotionDiscount(new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder2,
        new OfferImpl());

    // Act
    promotableOrderItemPriceDetailImpl.addPromotionQualifier(itemOffer, new OfferItemCriteriaImpl(), 2);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionDiscount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder2,
        new OfferImpl());

    // Act
    promotableOrderItemPriceDetailImpl.addPromotionDiscount(itemOffer, new OfferItemCriteriaImpl(), 3);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#finalizeQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#finalizeQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).finalizeQuantities();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#clearAllNonFinalizedQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#clearAllNonFinalizedQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearAllNonFinalizedQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).clearAllNonFinalizedQuantities();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableOrderItemPriceDetailImpl promotableOrderItemPriceDetailImpl = new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
        1);
    NullOrderImpl order2 = new NullOrderImpl();
    PromotableOrderImpl promotableOrder2 = new PromotableOrderImpl(order2,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailImpl.getQuantityAvailableToBeUsedAsQualifier(
        new PromotableCandidateItemOfferImpl(promotableOrder2, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateItemUnitPriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateItemUnitPriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateItemUnitPriceWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1))
            .calculateItemUnitPriceWithAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateItemUnitPriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateItemUnitPriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateItemUnitPriceWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateItemUnitPriceWithAdjustments(PromotableOrderItemPriceDetailImpl.java:463)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1))
            .calculateItemUnitPriceWithAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateAdjustmentsUnitValue()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateAdjustmentsUnitValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateAdjustmentsUnitValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateAdjustmentsUnitValue(PromotableOrderItemPriceDetailImpl.java:481)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateAdjustmentsUnitValue();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateAdjustmentsUnitValue()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateAdjustmentsUnitValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateAdjustmentsUnitValue_givenAuditableCreatedByIsOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateAdjustmentsUnitValue();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#buildDetailKey()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#buildDetailKey()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDetailKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).buildDetailKey();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#buildDetailKey()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#buildDetailKey()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDetailKey2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.buildDetailKey(PromotableOrderItemPriceDetailImpl.java:502)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailImpl(null, 1)).buildDetailKey();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#getFinalizedTotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#getFinalizedTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedTotalWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).getFinalizedTotalWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#getFinalizedTotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#getFinalizedTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedTotalWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.order.domain.BundleOrderItemImpl.getRetailPrice(BundleOrderItemImpl.java:258)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getRetailPriceBeforeAdjustments(PromotableOrderItemImpl.java:135)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.chooseSaleOrRetailAdjustments(PromotableOrderItemPriceDetailImpl.java:144)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.getFinalizedTotalWithAdjustments(PromotableOrderItemPriceDetailImpl.java:507)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).getFinalizedTotalWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateAdjustmentsUnitValue(PromotableOrderItemPriceDetailImpl.java:481)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateTotalAdjustmentValue(PromotableOrderItemPriceDetailImpl.java:513)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateTotalAdjustmentValue();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailImpl#calculateTotalAdjustmentValue()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue_givenAuditableCreatedByIsOne() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).calculateTotalAdjustmentValue();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#shallowCopy()}.
   * <p>
   * Method under test: {@link PromotableOrderItemPriceDetailImpl#shallowCopy()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShallowCopy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false), 1)).shallowCopy();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#shallowCopy()}.
   * <p>
   * Method under test: {@link PromotableOrderItemPriceDetailImpl#shallowCopy()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShallowCopy2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Trying to createNewDetail when adjustments have already been included.
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.createNewDetail(PromotableOrderItemImpl.java:248)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.shallowCopy(PromotableOrderItemPriceDetailImpl.java:518)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).shallowCopy();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#copyWithFinalizedData()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#copyWithFinalizedData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyWithFinalizedData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false), 1)).copyWithFinalizedData();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#copyWithFinalizedData()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#copyWithFinalizedData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyWithFinalizedData2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Trying to createNewDetail when adjustments have already been included.
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.createNewDetail(PromotableOrderItemImpl.java:248)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.copyWithFinalizedData(PromotableOrderItemPriceDetailImpl.java:524)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).copyWithFinalizedData();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#split(int, Long, boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#split(int, Long, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSplit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false), 1)).split(3, 1L, true);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#split(int, Long, boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#split(int, Long, boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSplit2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.RuntimeException: Trying to createNewDetail when adjustments have already been included.
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.createNewDetail(PromotableOrderItemImpl.java:248)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.split(PromotableOrderItemPriceDetailImpl.java:555)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).split(3, 1L, true);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailImpl#splitIfNecessary()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailImpl#splitIfNecessary()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSplitIfNecessary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    (new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)).splitIfNecessary();
  }
}
