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
package org.broadleafcommerce.core.offer.service.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilities;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroup;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderAdjustment;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.dao.OrderItemDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetail;
import org.broadleafcommerce.core.order.domain.OrderItemPriceDetailImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@RunWith(MockitoJUnitRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderOfferProcessorImplDiffblueTest {
  @InjectMocks
  private OrderOfferProcessorImpl orderOfferProcessorImpl;

  @Mock
  private PromotableItemFactory promotableItemFactory;

  /**
   * Test {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}.
   * <ul>
   *   <li>Given {@link OfferDiscountType#FIX_PRICE}.</li>
   *   <li>Then calls {@link Offer#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.filterOrderLevelOffer(PromotableOrder, List, Offer)"})
  public void testFilterOrderLevelOffer_givenFix_price_thenCallsGetName() {
    // Arrange
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new OrderImpl(), promotableItemFactory, true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();
    Offer offer = mock(Offer.class);
    when(offer.getName()).thenReturn("Name");
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    // Act
    orderOfferProcessorImpl.filterOrderLevelOffer(promotableOrder, qualifiedOrderOffers, offer);

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getName();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}.
   * <ul>
   *   <li>Then calls {@link Offer#getApplyDiscountToSalePrice()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#filterOrderLevelOffer(PromotableOrder, List, Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.filterOrderLevelOffer(PromotableOrder, List, Offer)"})
  public void testFilterOrderLevelOffer_thenCallsGetApplyDiscountToSalePrice() {
    // Arrange
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new OrderImpl(), promotableItemFactory, true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();
    Offer offer = mock(Offer.class);
    when(offer.getQualifyingItemSubTotal()).thenReturn(new Money(10.0d));
    when(offer.getQualifyingItemCriteriaXref()).thenReturn(new HashSet<>());
    when(offer.getType()).thenReturn(OfferType.FULFILLMENT_GROUP);
    when(offer.getApplyDiscountToSalePrice()).thenReturn(true);
    when(offer.getOfferMatchRulesXref()).thenReturn(new HashMap<>());
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    orderOfferProcessorImpl.filterOrderLevelOffer(promotableOrder, qualifiedOrderOffers, offer);

    // Assert
    verify(offer).getApplyDiscountToSalePrice();
    verify(offer).getDiscountType();
    verify(offer).getOfferMatchRulesXref();
    verify(offer, atLeast(1)).getQualifyingItemCriteriaXref();
    verify(offer).getQualifyingItemSubTotal();
    verify(offer, atLeast(1)).getType();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List OrderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(List)"})
  public void testRemoveTrailingNotCombinableOrderOffers_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(orderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(new ArrayList<>()).isEmpty());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(new OrderImpl(), promotableItemFactory, true);

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers, promotableOrder);

    // Assert
    assertTrue(promotableOrder.getOrder() instanceof OrderImpl);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers_thenCallsGetCurrencyCode() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers,
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   *   <li>Then calls {@link Order#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers_whenOrderGetCurrencyReturnNull_thenCallsGetCurrency() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers,
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"})
  public void testCompareAndAdjustOrderAndItemOffers() {
    // Arrange
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateItemOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money());
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateItemOfferAdjustments();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"})
  public void testCompareAndAdjustOrderAndItemOffers2() {
    // Arrange
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateOrderOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money(10.0d));
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(new Money());

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateOrderOfferAdjustments();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"})
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    orderOfferProcessorImpl
        .compareAndAdjustOrderAndItemOffers(new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link Money#greaterThanOrEqual(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"})
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGreaterThanOrEqual() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThanOrEqual(Mockito.<Money>any())).thenReturn(true);
    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateItemOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money(10.0d));
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert
    verify(money).greaterThanOrEqual(isA(Money.class));
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateItemOfferAdjustments();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)"})
  public void testUpdateAdjustmentIfChangesDetected() {
    // Arrange
    OrderAdjustment adjustment = mock(OrderAdjustment.class);
    doNothing().when(adjustment).setFutureCredit(Mockito.<Boolean>any());
    when(adjustment.isFutureCredit()).thenReturn(true);
    doNothing().when(adjustment).setValue(Mockito.<Money>any());
    when(adjustment.getValue()).thenReturn(new Money());
    when(adjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderAdjustment promotableAdjustment = mock(PromotableOrderAdjustment.class);
    when(promotableAdjustment.isFutureCredit()).thenReturn(true);
    when(promotableAdjustment.getAdjustmentValue()).thenReturn(null);
    when(promotableAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    orderOfferProcessorImpl.updateAdjustmentIfChangesDetected(adjustment, promotableAdjustment);

    // Assert
    verify(adjustment).getOffer();
    verify(adjustment).getValue();
    verify(adjustment).setValue(isNull());
    verify(adjustment).isFutureCredit();
    verify(adjustment).setFutureCredit(eq(true));
    verify(promotableAdjustment, atLeast(1)).getAdjustmentValue();
    verify(promotableAdjustment).getOffer();
    verify(promotableAdjustment).isFutureCredit();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)"})
  public void testUpdateAdjustmentIfChangesDetected_givenFalse() {
    // Arrange
    OrderAdjustment adjustment = mock(OrderAdjustment.class);
    when(adjustment.isFutureCredit()).thenReturn(false);
    when(adjustment.getValue()).thenReturn(new Money());
    when(adjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderAdjustment promotableAdjustment = mock(PromotableOrderAdjustment.class);
    when(promotableAdjustment.getAdjustmentValue()).thenReturn(new Money());
    when(promotableAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    orderOfferProcessorImpl.updateAdjustmentIfChangesDetected(adjustment, promotableAdjustment);

    // Assert
    verify(adjustment).getOffer();
    verify(adjustment).getValue();
    verify(adjustment).isFutureCredit();
    verify(promotableAdjustment).getAdjustmentValue();
    verify(promotableAdjustment).getOffer();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <ul>
   *   <li>Given {@link Money}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)"})
  public void testUpdateAdjustmentIfChangesDetected_givenMoney() {
    // Arrange
    OrderAdjustment adjustment = mock(OrderAdjustment.class);
    doNothing().when(adjustment).setFutureCredit(Mockito.<Boolean>any());
    when(adjustment.isFutureCredit()).thenReturn(true);
    doNothing().when(adjustment).setValue(Mockito.<Money>any());
    when(adjustment.getValue()).thenReturn(mock(Money.class));
    when(adjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderAdjustment promotableAdjustment = mock(PromotableOrderAdjustment.class);
    when(promotableAdjustment.isFutureCredit()).thenReturn(true);
    when(promotableAdjustment.getAdjustmentValue()).thenReturn(new Money());
    when(promotableAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    orderOfferProcessorImpl.updateAdjustmentIfChangesDetected(adjustment, promotableAdjustment);

    // Assert
    verify(adjustment).getOffer();
    verify(adjustment).getValue();
    verify(adjustment).setValue(isA(Money.class));
    verify(adjustment).isFutureCredit();
    verify(adjustment).setFutureCredit(eq(true));
    verify(promotableAdjustment, atLeast(1)).getAdjustmentValue();
    verify(promotableAdjustment).getOffer();
    verify(promotableAdjustment).isFutureCredit();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)"})
  public void testUpdateAdjustmentIfChangesDetected_givenMoneyWithAmountIsTen() {
    // Arrange
    OrderAdjustment adjustment = mock(OrderAdjustment.class);
    doNothing().when(adjustment).setFutureCredit(Mockito.<Boolean>any());
    when(adjustment.isFutureCredit()).thenReturn(true);
    doNothing().when(adjustment).setValue(Mockito.<Money>any());
    when(adjustment.getValue()).thenReturn(new Money(10.0d));
    when(adjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderAdjustment promotableAdjustment = mock(PromotableOrderAdjustment.class);
    when(promotableAdjustment.isFutureCredit()).thenReturn(true);
    when(promotableAdjustment.getAdjustmentValue()).thenReturn(new Money());
    when(promotableAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    orderOfferProcessorImpl.updateAdjustmentIfChangesDetected(adjustment, promotableAdjustment);

    // Assert
    verify(adjustment).getOffer();
    verify(adjustment).getValue();
    verify(adjustment).setValue(isA(Money.class));
    verify(adjustment).isFutureCredit();
    verify(adjustment).setFutureCredit(eq(true));
    verify(promotableAdjustment, atLeast(1)).getAdjustmentValue();
    verify(promotableAdjustment).getOffer();
    verify(promotableAdjustment).isFutureCredit();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}.
   * <ul>
   *   <li>Then calls {@link OrderAdjustment#setFutureCredit(Boolean)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.updateAdjustmentIfChangesDetected(OrderAdjustment, PromotableOrderAdjustment)"})
  public void testUpdateAdjustmentIfChangesDetected_thenCallsSetFutureCredit() {
    // Arrange
    OrderAdjustment adjustment = mock(OrderAdjustment.class);
    doNothing().when(adjustment).setFutureCredit(Mockito.<Boolean>any());
    when(adjustment.isFutureCredit()).thenReturn(true);
    when(adjustment.getValue()).thenReturn(new Money());
    when(adjustment.getOffer()).thenReturn(new OfferImpl());
    PromotableOrderAdjustment promotableAdjustment = mock(PromotableOrderAdjustment.class);
    when(promotableAdjustment.isFutureCredit()).thenReturn(true);
    when(promotableAdjustment.getAdjustmentValue()).thenReturn(new Money());
    when(promotableAdjustment.getOffer()).thenReturn(new OfferImpl());

    // Act
    orderOfferProcessorImpl.updateAdjustmentIfChangesDetected(adjustment, promotableAdjustment);

    // Assert
    verify(adjustment).getOffer();
    verify(adjustment).getValue();
    verify(adjustment).isFutureCredit();
    verify(adjustment).setFutureCredit(eq(true));
    verify(promotableAdjustment).getAdjustmentValue();
    verify(promotableAdjustment).getOffer();
    verify(promotableAdjustment).isFutureCredit();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"})
  public void testProcessMatchingDetails_givenOne_thenCallsGetOrderItemPriceDetailAdjustments() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());

    // Act
    orderOfferProcessorImpl.processMatchingDetails(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}.
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailImpl} (default constructor) Quantity is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void OrderOfferProcessorImpl.processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"})
  public void testProcessMatchingDetails_thenOrderItemPriceDetailImplQuantityIsOne() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();

    // Act
    orderOfferProcessorImpl.processMatchingDetails(itemDetail,
        new PromotableOrderItemPriceDetailWrapper(new PromotableOrderItemPriceDetailImpl(
            new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true), 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String OrderOfferProcessorImpl.buildItemPriceDetailKey(OrderItemPriceDetail)"})
  public void testBuildItemPriceDetailKey_givenArrayList_thenCallsGetOrderItem() {
    // Arrange
    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getUseSalePrice()).thenReturn(true);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());
    when(itemDetail.getOrderItem()).thenReturn(new BundleOrderItemImpl());

    // Act
    orderOfferProcessorImpl.buildItemPriceDetailKey(itemDetail);

    // Assert
    verify(itemDetail).getOrderItem();
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getUseSalePrice();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"})
  public void testFgContainsFutureCreditAdjustment_givenMoney() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertFalse(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"})
  public void testFgContainsFutureCreditAdjustment_givenMoneyWithAmountIsTen() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money(10.0d));

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertTrue(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"})
  public void testFgContainsFutureCreditAdjustment_givenNullOrderImpl() {
    // Arrange
    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link Money#compareTo(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"})
  public void testFgContainsFutureCreditAdjustment_thenCallsCompareTo() {
    // Arrange
    Money money = mock(Money.class);
    when(money.compareTo(Mockito.<Money>any())).thenReturn(1);
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(money);

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult = orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(money).compareTo(isA(Money.class));
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertTrue(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());
    when(fg.getRetailFulfillmentPrice()).thenReturn(new Money());
    doNothing().when(fg).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(fg).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.</li>
   *   <li>Then calls {@link Money#subtract(Money)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(mock(Money.class));
    when(fg.getRetailFulfillmentPrice()).thenReturn(money);
    doNothing().when(fg).addFulfillmentGroupItem(Mockito.<FulfillmentGroupItem>any());
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.addFulfillmentGroupItem(new FulfillmentGroupItemImpl());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(fg).addFulfillmentGroupItem(isA(FulfillmentGroupItem.class));
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setRetailFulfillmentPrice(new Money());
    fg.setOrder(order);

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OrderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(PromotableOrder)"})
  public void testBuildPromotableFulfillmentGroupMap_thenReturnEmpty() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

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

    // Act and Assert
    assertTrue(orderOfferProcessorImpl
        .buildPromotableFulfillmentGroupMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .isEmpty());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Map OrderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(PromotableOrder)"})
  public void testBuildPromotableFulfillmentGroupMap_thenReturnSizeIsOne() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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

    // Act
    Map<Long, PromotableFulfillmentGroup> actualBuildPromotableFulfillmentGroupMapResult = orderOfferProcessorImpl
        .buildPromotableFulfillmentGroupMap(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    assertEquals(1, actualBuildPromotableFulfillmentGroupMapResult.size());
    PromotableFulfillmentGroup getResult = actualBuildPromotableFulfillmentGroupMapResult.get(null);
    assertTrue(getResult instanceof PromotableFulfillmentGroupImpl);
    FulfillmentGroup fulfillmentGroup = getResult.getFulfillmentGroup();
    assertTrue(fulfillmentGroup instanceof FulfillmentGroupImpl);
    assertTrue(getResult.getCandidateFulfillmentGroupAdjustments().isEmpty());
    assertTrue(getResult.getDiscountableOrderItems().isEmpty());
    assertTrue(((PromotableFulfillmentGroupImpl) getResult).candidateFulfillmentGroupAdjustments.isEmpty());
    assertSame(fulfillmentGroupImpl, fulfillmentGroup);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OrderOfferProcessorImpl#setOfferDao(OfferDao)}
   *   <li>{@link OrderOfferProcessorImpl#setOfferServiceUtilities(OfferServiceUtilities)}
   *   <li>{@link OrderOfferProcessorImpl#setOrderItemDao(OrderItemDao)}
   *   <li>{@link OrderOfferProcessorImpl#setPromotableItemFactory(PromotableItemFactory)}
   *   <li>{@link OrderOfferProcessorImpl#getOfferServiceUtilities()}
   *   <li>{@link OrderOfferProcessorImpl#getPromotableItemFactory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"OfferServiceUtilities OrderOfferProcessorImpl.getOfferServiceUtilities()",
      "PromotableItemFactory OrderOfferProcessorImpl.getPromotableItemFactory()",
      "void OrderOfferProcessorImpl.setOfferDao(OfferDao)",
      "void OrderOfferProcessorImpl.setOfferServiceUtilities(OfferServiceUtilities)",
      "void OrderOfferProcessorImpl.setOrderItemDao(OrderItemDao)",
      "void OrderOfferProcessorImpl.setPromotableItemFactory(PromotableItemFactory)"})
  public void testGettersAndSetters() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl = new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl.setOfferDao(new OfferDaoImpl());
    OfferServiceUtilitiesImpl offerServiceUtilities = new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(offerServiceUtilities);
    orderOfferProcessorImpl.setOrderItemDao(new OrderItemDaoImpl());
    PromotableItemFactoryImpl promotableItemFactory = new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setPromotableItemFactory(promotableItemFactory);
    OfferServiceUtilities actualOfferServiceUtilities = orderOfferProcessorImpl.getOfferServiceUtilities();
    PromotableItemFactory actualPromotableItemFactory = orderOfferProcessorImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(offerServiceUtilities, actualOfferServiceUtilities);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
