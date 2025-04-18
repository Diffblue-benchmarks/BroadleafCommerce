/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteria;
import org.broadleafcommerce.core.offer.domain.OfferItemCriteriaImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

public class PromotableOrderItemPriceDetailWrapperDiffblueTest {
  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#PromotableOrderItemPriceDetailWrapper(PromotableOrderItemPriceDetail)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#PromotableOrderItemPriceDetailWrapper(PromotableOrderItemPriceDetail)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testNewPromotableOrderItemPriceDetailWrapper() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(), null, true);

    PromotableOrderItemImpl promotableOrderItem = new PromotableOrderItemImpl(orderItem, promotableOrder,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderItemPriceDetailWrapper actualPromotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1));

    // Assert
    boolean actualIsEmptyResult = actualPromotableOrderItemPriceDetailWrapper.getCandidateItemAdjustments().isEmpty();
    assertEquals(1, actualPromotableOrderItemPriceDetailWrapper.getQuantity());
    assertFalse(actualPromotableOrderItemPriceDetailWrapper.hasNonCombinableAdjustments());
    assertFalse(actualPromotableOrderItemPriceDetailWrapper.isNonCombinableOfferApplied());
    assertFalse(actualPromotableOrderItemPriceDetailWrapper.isTotalitarianOfferApplied());
    assertTrue(actualIsEmptyResult);
    assertTrue(actualPromotableOrderItemPriceDetailWrapper.getPromotionDiscounts().isEmpty());
    assertTrue(actualPromotableOrderItemPriceDetailWrapper.getPromotionQualifiers().isEmpty());
    assertTrue(actualPromotableOrderItemPriceDetailWrapper.isAdjustmentsFinalized());
    assertSame(promotableOrderItem, actualPromotableOrderItemPriceDetailWrapper.getPromotableOrderItem());
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCandidateItemPriceDetailAdjustment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
        new BundleOrderItemImpl(), mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)))
            .addCandidateItemPriceDetailAdjustment(null);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addCandidateItemPriceDetailAdjustment(PromotableOrderItemPriceDetailAdjustment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddCandidateItemPriceDetailAdjustment2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));
    OrderItemPriceDetailAdjustmentImpl itemAdjustment = new OrderItemPriceDetailAdjustmentImpl();

    // Act
    promotableOrderItemPriceDetailWrapper.addCandidateItemPriceDetailAdjustment(
        new PromotableOrderItemPriceDetailAdjustmentImpl(itemAdjustment, new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(mock(PromotableOrderItem.class), 1))));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getCandidateItemAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getCandidateItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCandidateItemAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).getCandidateItemAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getCandidateItemAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getCandidateItemAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetCandidateItemAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getCandidateItemAdjustments(PromotableOrderItemPriceDetailWrapper.java:46)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).getCandidateItemAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#hasNonCombinableAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#hasNonCombinableAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasNonCombinableAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).hasNonCombinableAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#hasNonCombinableAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#hasNonCombinableAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHasNonCombinableAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.hasNonCombinableAdjustments(PromotableOrderItemPriceDetailWrapper.java:50)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).hasNonCombinableAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isTotalitarianOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarianOfferApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).isTotalitarianOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isTotalitarianOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsTotalitarianOfferApplied2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.isTotalitarianOfferApplied(PromotableOrderItemPriceDetailWrapper.java:54)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).isTotalitarianOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#isNonCombinableOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isNonCombinableOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsNonCombinableOfferApplied() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).isNonCombinableOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#isNonCombinableOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isNonCombinableOfferApplied()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsNonCombinableOfferApplied2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.isNonCombinableOfferApplied(PromotableOrderItemPriceDetailWrapper.java:58)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).isNonCombinableOfferApplied();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#chooseSaleOrRetailAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#chooseSaleOrRetailAdjustments()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#chooseSaleOrRetailAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testChooseSaleOrRetailAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, mock(PromotableOrder.class), mock(PromotableItemFactory.class), true),
        1))).chooseSaleOrRetailAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#removeAllAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#removeAllAdjustments()}
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

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).removeAllAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#removeAllAdjustments()}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#removeAllAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRemoveAllAdjustments_givenBundleOrderItemImplOrderIsNullOrderImpl() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, mock(PromotableOrder.class), mock(PromotableItemFactory.class), true),
        1))).removeAllAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotionDiscounts()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotionDiscounts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotionDiscounts() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).getPromotionDiscounts();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotionDiscounts()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotionDiscounts()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotionDiscounts2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getPromotionDiscounts(PromotableOrderItemPriceDetailWrapper.java:70)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).getPromotionDiscounts();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotionQualifiers()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotionQualifiers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotionQualifiers() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).getPromotionQualifiers();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotionQualifiers()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotionQualifiers()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotionQualifiers2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getPromotionQualifiers(PromotableOrderItemPriceDetailWrapper.java:74)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).getPromotionQualifiers();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getQuantity()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantity()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).getQuantity();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getQuantity()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantity()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantity2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getQuantity(PromotableOrderItemPriceDetailWrapper.java:78)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).getQuantity();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#setQuantity(int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#setQuantity(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetQuantity() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).setQuantity(1);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#setQuantity(int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#setQuantity(int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetQuantity2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.setQuantity(PromotableOrderItemPriceDetailWrapper.java:82)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).setQuantity(1);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotableOrderItem()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotableOrderItem()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotableOrderItem() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).getPromotableOrderItem();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#getPromotableOrderItem()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getPromotableOrderItem()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetPromotableOrderItem2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getPromotableOrderItem(PromotableOrderItemPriceDetailWrapper.java:86)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).getPromotableOrderItem();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailWrapper.getQuantityAvailableToBeUsedAsQualifier(
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsQualifier(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsQualifier2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getQuantityAvailableToBeUsedAsQualifier(PromotableOrderItemPriceDetailWrapper.java:90)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        null);
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailWrapper.getQuantityAvailableToBeUsedAsQualifier(
        new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsTarget() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailWrapper
        .getQuantityAvailableToBeUsedAsTarget(new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getQuantityAvailableToBeUsedAsTarget(PromotableCandidateItemOffer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetQuantityAvailableToBeUsedAsTarget2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.getQuantityAvailableToBeUsedAsTarget(PromotableOrderItemPriceDetailWrapper.java:94)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        null);
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderItemPriceDetailWrapper
        .getQuantityAvailableToBeUsedAsTarget(new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl()));
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionQualifier() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    promotableOrderItemPriceDetailWrapper.addPromotionQualifier(itemOffer, new OfferItemCriteriaImpl(), 2);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionQualifier(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionQualifier2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.addPromotionQualifier(PromotableOrderItemPriceDetailWrapper.java:98)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        null);
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    promotableOrderItemPriceDetailWrapper.addPromotionQualifier(itemOffer, new OfferItemCriteriaImpl(), 2);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionDiscount() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1));
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    promotableOrderItemPriceDetailWrapper.addPromotionDiscount(itemOffer, new OfferItemCriteriaImpl(), 3);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#addPromotionDiscount(PromotableCandidateItemOffer, OfferItemCriteria, int)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testAddPromotionDiscount2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.addPromotionDiscount(PromotableOrderItemPriceDetailWrapper.java:102)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper = new PromotableOrderItemPriceDetailWrapper(
        null);
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableCandidateItemOfferImpl itemOffer = new PromotableCandidateItemOfferImpl(promotableOrder, new OfferImpl());

    // Act
    promotableOrderItemPriceDetailWrapper.addPromotionDiscount(itemOffer, new OfferItemCriteriaImpl(), 3);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#calculateItemUnitPriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#calculateItemUnitPriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateItemUnitPriceWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, mock(PromotableOrder.class), mock(PromotableItemFactory.class), true),
        1))).calculateItemUnitPriceWithAdjustments(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#calculateItemUnitPriceWithAdjustments(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#calculateItemUnitPriceWithAdjustments(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateItemUnitPriceWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
        new BundleOrderItemImpl(), mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)))
            .calculateItemUnitPriceWithAdjustments(true);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#finalizeQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#finalizeQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).finalizeQuantities();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#finalizeQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#finalizeQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testFinalizeQuantities2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.finalizeQuantities(PromotableOrderItemPriceDetailWrapper.java:110)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).finalizeQuantities();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#clearAllNonFinalizedQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#clearAllNonFinalizedQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearAllNonFinalizedQuantities() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
        new BundleOrderItemImpl(), mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)))
            .clearAllNonFinalizedQuantities();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#clearAllNonFinalizedQuantities()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#clearAllNonFinalizedQuantities()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testClearAllNonFinalizedQuantities2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.clearAllNonFinalizedQuantities(PromotableOrderItemPriceDetailWrapper.java:114)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).clearAllNonFinalizedQuantities();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#buildDetailKey()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#buildDetailKey()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testBuildDetailKey() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).buildDetailKey();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#buildDetailKey()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#buildDetailKey()}
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
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.buildDetailKey(PromotableOrderItemPriceDetailWrapper.java:118)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(null, 1))).buildDetailKey();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getFinalizedTotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getFinalizedTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedTotalWithAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, mock(PromotableOrder.class), mock(PromotableItemFactory.class), true),
        1))).getFinalizedTotalWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#getFinalizedTotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#getFinalizedTotalWithAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testGetFinalizedTotalWithAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
        new BundleOrderItemImpl(), mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1)))
            .getFinalizedTotalWithAdjustments();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#calculateTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue() {
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

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(orderItem, mock(PromotableOrder.class), mock(PromotableItemFactory.class), true),
        1))).calculateTotalAdjustmentValue();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#calculateTotalAdjustmentValue()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#calculateTotalAdjustmentValue()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCalculateTotalAdjustmentValue2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl.getCurrency(PromotableOrderItemImpl.java:164)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateAdjustmentsUnitValue(PromotableOrderItemPriceDetailImpl.java:481)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl.calculateTotalAdjustmentValue(PromotableOrderItemPriceDetailImpl.java:513)
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.calculateTotalAdjustmentValue(PromotableOrderItemPriceDetailWrapper.java:126)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).calculateTotalAdjustmentValue();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#splitIfNecessary()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#splitIfNecessary()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSplitIfNecessary() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).splitIfNecessary();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#splitIfNecessary()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#splitIfNecessary()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSplitIfNecessary2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.splitIfNecessary(PromotableOrderItemPriceDetailWrapper.java:130)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).splitIfNecessary();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#useSaleAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#useSaleAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseSaleAdjustments() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).useSaleAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#useSaleAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#useSaleAdjustments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUseSaleAdjustments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.useSaleAdjustments(PromotableOrderItemPriceDetailWrapper.java:134)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).useSaleAdjustments();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#isAdjustmentsFinalized()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isAdjustmentsFinalized()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAdjustmentsFinalized() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).isAdjustmentsFinalized();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#isAdjustmentsFinalized()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#isAdjustmentsFinalized()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testIsAdjustmentsFinalized2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.isAdjustmentsFinalized(PromotableOrderItemPriceDetailWrapper.java:138)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).isAdjustmentsFinalized();
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#setAdjustmentsFinalized(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#setAdjustmentsFinalized(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAdjustmentsFinalized() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).setAdjustmentsFinalized(true);
  }

  /**
   * Test
   * {@link PromotableOrderItemPriceDetailWrapper#setAdjustmentsFinalized(boolean)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#setAdjustmentsFinalized(boolean)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testSetAdjustmentsFinalized2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Diffblue Cover tried to run the arrange/act section, but the method under
    //   test threw
    //   java.lang.NullPointerException
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.setAdjustmentsFinalized(PromotableOrderItemPriceDetailWrapper.java:142)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(null)).setAdjustmentsFinalized(true);
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#shallowCopy()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#shallowCopy()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShallowCopy() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableItemFactory itemFactory = mock(PromotableItemFactory.class);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    when(itemFactory.createPromotableOrderItemPriceDetail(Mockito.<PromotableOrderItem>any(), anyInt())).thenReturn(
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
            orderItem, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)));

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(new BundleOrderItemImpl(), mock(PromotableOrder.class), itemFactory, false), 1)))
            .shallowCopy();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#shallowCopy()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#shallowCopy()}
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
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.shallowCopy(PromotableOrderItemPriceDetailWrapper.java:147)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).shallowCopy();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#copyWithFinalizedData()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#copyWithFinalizedData()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCopyWithFinalizedData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    PromotableItemFactory itemFactory = mock(PromotableItemFactory.class);
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new NullOrderImpl(),
        mock(PromotableItemFactory.class), true);

    when(itemFactory.createPromotableOrderItemPriceDetail(Mockito.<PromotableOrderItem>any(), anyInt())).thenReturn(
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(
            orderItem, promotableOrder, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), 1)));

    // Act
    (new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
        new PromotableOrderItemImpl(new BundleOrderItemImpl(), mock(PromotableOrder.class), itemFactory, false), 1)))
            .copyWithFinalizedData();
  }

  /**
   * Test {@link PromotableOrderItemPriceDetailWrapper#copyWithFinalizedData()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderItemPriceDetailWrapper#copyWithFinalizedData()}
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
    //       at org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper.copyWithFinalizedData(PromotableOrderItemPriceDetailWrapper.java:152)
    //   See https://diff.blue/R013 to resolve this issue.

    // Arrange and Act
    (new PromotableOrderItemPriceDetailWrapper(
        new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(new BundleOrderItemImpl(),
            mock(PromotableOrder.class), mock(PromotableItemFactory.class), true), 1))).copyWithFinalizedData();
  }
}
