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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.dao.OfferDao;
import org.broadleafcommerce.core.offer.dao.OfferDaoImpl;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderAdjustmentImpl;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustment;
import org.broadleafcommerce.core.offer.domain.OrderItemPriceDetailAdjustmentImpl;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilities;
import org.broadleafcommerce.core.offer.service.OfferServiceUtilitiesImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroup;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.order.dao.OrderItemDao;
import org.broadleafcommerce.core.order.dao.OrderItemDaoImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
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

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class OrderOfferProcessorImplDiffblueTest {
  @InjectMocks private OrderOfferProcessorImpl orderOfferProcessorImpl;

  @Mock private PromotableItemFactory promotableItemFactory;

  /**
   * Test {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(List)"})
  public void testRemoveTrailingNotCombinableOrderOffers_givenNull_thenReturnArrayList() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> candidateOffers = new ArrayList<>();
    candidateOffers.add(null);

    // Act
    List<PromotableCandidateOrderOffer> actualRemoveTrailingNotCombinableOrderOffersResult =
        orderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(candidateOffers);

    // Assert
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableOrderOffersResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#removeTrailingNotCombinableOrderOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OrderOfferProcessorImpl.removeTrailingNotCombinableOrderOffers(List)"})
  public void testRemoveTrailingNotCombinableOrderOffers_whenArrayList_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        orderOfferProcessorImpl
            .removeTrailingNotCombinableOrderOffers(new ArrayList<>())
            .isEmpty());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(new OrderImpl(), promotableItemFactory, true);

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers, promotableOrder);

    // Assert
    assertTrue(promotableOrder.getOrder() instanceof OrderImpl);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers2() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("NullOrder does not support any modification operations.");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(null);
    when(promotableOrder.getOrder()).thenReturn(orderImpl);

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers, promotableOrder);

    // Assert
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrder();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link PromotableOrder#calculateSubtotalWithAdjustments()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers_thenCallsCalculateSubtotalWithAdjustments() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("NullOrder does not support any modification operations.");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());

    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    when(promotableOrder.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    when(promotableOrder.getOrder()).thenReturn(orderImpl);

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(orderOffers, promotableOrder);

    // Assert
    verify(promotableOrder).calculateSubtotalWithAdjustments();
    verify(promotableOrder).getOrder();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.applyAllOrderOffers(List, PromotableOrder)"})
  public void testApplyAllOrderOffers_thenCallsGetCurrencyCode() {
    // Arrange
    ArrayList<PromotableCandidateOrderOffer> orderOffers = new ArrayList<>();

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());

    // Act
    orderOfferProcessorImpl.applyAllOrderOffers(
        orderOffers, new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#applyAllOrderOffers(List, PromotableOrder)}.
   *
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.
   *   <li>Then calls {@link Order#getCurrency()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#applyAllOrderOffers(List,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
    orderOfferProcessorImpl.applyAllOrderOffers(
        orderOffers, new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order).setSubTotal(isA(Money.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"
  })
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
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"
  })
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
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"
  })
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link Money#greaterThanOrEqual(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#compareAndAdjustOrderAndItemOffers(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(PromotableOrder)"
  })
  public void testCompareAndAdjustOrderAndItemOffers_thenCallsGreaterThanOrEqual() {
    // Arrange
    Money money = mock(Money.class);
    when(money.greaterThanOrEqual(Mockito.<Money>any())).thenReturn(false);

    PromotableOrder promotableOrder = mock(PromotableOrder.class);
    doNothing().when(promotableOrder).removeAllCandidateOrderOfferAdjustments();
    when(promotableOrder.calculateItemAdjustmentTotal()).thenReturn(new Money(10.0d));
    when(promotableOrder.calculateOrderAdjustmentTotal()).thenReturn(money);

    // Act
    orderOfferProcessorImpl.compareAndAdjustOrderAndItemOffers(promotableOrder);

    // Assert
    verify(money).greaterThanOrEqual(isA(Money.class));
    verify(promotableOrder).calculateItemAdjustmentTotal();
    verify(promotableOrder).calculateOrderAdjustmentTotal();
    verify(promotableOrder).removeAllCandidateOrderOfferAdjustments();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#synchronizeOrderAdjustments(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getOrderAdjustments()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#synchronizeOrderAdjustments(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.synchronizeOrderAdjustments(PromotableOrder)"})
  public void testSynchronizeOrderAdjustments_thenCallsGetOrderAdjustments() {
    // Arrange
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    orderAdjustmentList.add(new OrderAdjustmentImpl());

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);

    // Act
    orderOfferProcessorImpl.synchronizeOrderAdjustments(
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(order, atLeast(1)).getOrderAdjustments();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail,
   * PromotableOrderItemPriceDetail)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItemPriceDetailAdjustments()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail,
   * PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"
  })
  public void testProcessMatchingDetails_givenOne_thenCallsGetOrderItemPriceDetailAdjustments() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(
        new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));

    OrderItemPriceDetailImpl itemDetail = mock(OrderItemPriceDetailImpl.class);
    when(itemDetail.getQuantity()).thenReturn(1);
    when(itemDetail.getOrderItemPriceDetailAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderItemImpl promotableOrderItem =
        new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true);

    // Act
    orderOfferProcessorImpl.processMatchingDetails(
        itemDetail,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1)));

    // Assert
    verify(itemDetail).getOrderItemPriceDetailAdjustments();
    verify(itemDetail).getQuantity();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail,
   * PromotableOrderItemPriceDetail)}.
   *
   * <ul>
   *   <li>Then {@link OrderItemPriceDetailImpl} (default constructor) Quantity is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#processMatchingDetails(OrderItemPriceDetail,
   * PromotableOrderItemPriceDetail)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderOfferProcessorImpl.processMatchingDetails(OrderItemPriceDetail, PromotableOrderItemPriceDetail)"
  })
  public void testProcessMatchingDetails_thenOrderItemPriceDetailImplQuantityIsOne() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(
        new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl()));
    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();
    PromotableOrderItemImpl promotableOrderItem =
        new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true);

    // Act
    orderOfferProcessorImpl.processMatchingDetails(
        itemDetail,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1)));

    // Assert
    assertEquals(1, itemDetail.getQuantity());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link OrderItemPriceDetailImpl#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String OrderOfferProcessorImpl.buildItemPriceDetailKey(OrderItemPriceDetail)"
  })
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
   * Test {@link OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}.
   *
   * <ul>
   *   <li>Then calls {@link OrderItemPriceDetailAdjustmentImpl#getOffer()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#buildItemPriceDetailKey(OrderItemPriceDetail)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String OrderOfferProcessorImpl.buildItemPriceDetailKey(OrderItemPriceDetail)"
  })
  public void testBuildItemPriceDetailKey_thenCallsGetOffer() {
    // Arrange
    OrderItemPriceDetailAdjustmentImpl orderItemPriceDetailAdjustmentImpl =
        mock(OrderItemPriceDetailAdjustmentImpl.class);
    when(orderItemPriceDetailAdjustmentImpl.getOffer()).thenReturn(new OfferImpl());

    ArrayList<OrderItemPriceDetailAdjustment> orderItemPriceDetailAdjustments = new ArrayList<>();
    orderItemPriceDetailAdjustments.add(orderItemPriceDetailAdjustmentImpl);

    OrderItemPriceDetailImpl itemDetail = new OrderItemPriceDetailImpl();
    itemDetail.setId(1L);
    itemDetail.setOrderItem(new BundleOrderItemImpl());
    itemDetail.setQuantity(1);
    itemDetail.setUseSalePrice(true);
    itemDetail.setOrderItemAdjustments(orderItemPriceDetailAdjustments);

    // Act
    orderOfferProcessorImpl.buildItemPriceDetailKey(itemDetail);

    // Assert
    verify(orderItemPriceDetailAdjustmentImpl).getOffer();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"
  })
  public void testFgContainsFutureCreditAdjustment_givenMoney() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult =
        orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertFalse(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"
  })
  public void testFgContainsFutureCreditAdjustment_givenMoneyWithAmountIsTen_thenReturnTrue() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(new Money(10.0d));

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult =
        orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertTrue(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"
  })
  public void testFgContainsFutureCreditAdjustment_givenNullOrderImpl() {
    // Arrange
    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setOrder(new NullOrderImpl());

    // Act and Assert
    assertFalse(orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link Money#compareTo(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"
  })
  public void testFgContainsFutureCreditAdjustment_thenCallsCompareTo() {
    // Arrange
    Money money = mock(Money.class);
    when(money.compareTo(Mockito.<Money>any())).thenReturn(0);

    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    when(fg.getFutureCreditFulfillmentGroupAdjustmentsValue()).thenReturn(money);

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult =
        orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(money).compareTo(isA(Money.class));
    verify(fg).getFutureCreditFulfillmentGroupAdjustmentsValue();
    assertFalse(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#fgContainsFutureCreditAdjustment(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderOfferProcessorImpl.fgContainsFutureCreditAdjustment(FulfillmentGroup)"
  })
  public void testFgContainsFutureCreditAdjustment_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setOrder(order);

    // Act
    boolean actualFgContainsFutureCreditAdjustmentResult =
        orderOfferProcessorImpl.fgContainsFutureCreditAdjustment(fg);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    assertFalse(actualFgContainsFutureCreditAdjustmentResult);
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice() {
    // Arrange
    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(new Money());
    when(fg.getRetailFulfillmentPrice()).thenReturn(new Money());
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Given {@link Money} {@link Money#subtract(Money)} return {@link Money#Money()}.
   *   <li>Then calls {@link Money#subtract(Money)}.
   * </ul>
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice_givenMoneySubtractReturnMoney_thenCallsSubtract() {
    // Arrange
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());

    FulfillmentGroupImpl fg = mock(FulfillmentGroupImpl.class);
    doNothing().when(fg).setFulfillmentPrice(Mockito.<Money>any());
    when(fg.getFulfillmentGroupAdjustmentsValue()).thenReturn(mock(Money.class));
    when(fg.getRetailFulfillmentPrice()).thenReturn(money);
    doNothing().when(fg).setOrder(Mockito.<Order>any());
    fg.setOrder(mock(Order.class));

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(money).subtract(isA(Money.class));
    verify(fg).getFulfillmentGroupAdjustmentsValue();
    verify(fg).getRetailFulfillmentPrice();
    verify(fg).setFulfillmentPrice(isA(Money.class));
    verify(fg).setOrder(isA(Order.class));
  }

  /**
   * Test {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link OrderOfferProcessorImpl#syncFulfillmentPrice(FulfillmentGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OrderOfferProcessorImpl.syncFulfillmentPrice(FulfillmentGroup)"})
  public void testSyncFulfillmentPrice_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getCurrency()).thenReturn(broadleafCurrency);

    FulfillmentGroupImpl fg = new FulfillmentGroupImpl();
    fg.setRetailFulfillmentPrice(new Money());
    fg.setOrder(order);

    // Act
    orderOfferProcessorImpl.syncFulfillmentPrice(fg);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map OrderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(PromotableOrder)"
  })
  public void testBuildPromotableFulfillmentGroupMap_thenReturnEmpty() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertTrue(orderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(order2).isEmpty());
  }

  /**
   * Test {@link OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OrderOfferProcessorImpl#buildPromotableFulfillmentGroupMap(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map OrderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(PromotableOrder)"
  })
  public void testBuildPromotableFulfillmentGroupMap_thenReturnSizeIsOne() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    Map<Long, PromotableFulfillmentGroup> actualBuildPromotableFulfillmentGroupMapResult =
        orderOfferProcessorImpl.buildPromotableFulfillmentGroupMap(order2);

    // Assert
    assertEquals(1, actualBuildPromotableFulfillmentGroupMapResult.size());
    PromotableFulfillmentGroup getResult = actualBuildPromotableFulfillmentGroupMapResult.get(null);
    assertTrue(getResult instanceof PromotableFulfillmentGroupImpl);
    FulfillmentGroup fulfillmentGroup = getResult.getFulfillmentGroup();
    assertTrue(fulfillmentGroup instanceof FulfillmentGroupImpl);
    assertTrue(getResult.getCandidateFulfillmentGroupAdjustments().isEmpty());
    assertTrue(getResult.getDiscountableOrderItems().isEmpty());
    assertTrue(
        ((PromotableFulfillmentGroupImpl) getResult)
            .candidateFulfillmentGroupAdjustments.isEmpty());
    assertSame(fulfillmentGroupImpl, fulfillmentGroup);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OfferServiceUtilities OrderOfferProcessorImpl.getOfferServiceUtilities()",
    "PromotableItemFactory OrderOfferProcessorImpl.getPromotableItemFactory()",
    "void OrderOfferProcessorImpl.setOfferDao(OfferDao)",
    "void OrderOfferProcessorImpl.setOfferServiceUtilities(OfferServiceUtilities)",
    "void OrderOfferProcessorImpl.setOrderItemDao(OrderItemDao)",
    "void OrderOfferProcessorImpl.setPromotableItemFactory(PromotableItemFactory)"
  })
  public void testGettersAndSetters() {
    // Arrange
    OrderOfferProcessorImpl orderOfferProcessorImpl =
        new OrderOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act
    orderOfferProcessorImpl.setOfferDao(new OfferDaoImpl());
    OfferServiceUtilitiesImpl offerServiceUtilities =
        new OfferServiceUtilitiesImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setOfferServiceUtilities(offerServiceUtilities);
    orderOfferProcessorImpl.setOrderItemDao(new OrderItemDaoImpl());
    PromotableItemFactoryImpl promotableItemFactory =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());
    orderOfferProcessorImpl.setPromotableItemFactory(promotableItemFactory);
    OfferServiceUtilities actualOfferServiceUtilities =
        orderOfferProcessorImpl.getOfferServiceUtilities();
    PromotableItemFactory actualPromotableItemFactory =
        orderOfferProcessorImpl.getPromotableItemFactory();

    // Assert
    assertTrue(actualPromotableItemFactory instanceof PromotableItemFactoryImpl);
    assertSame(offerServiceUtilities, actualOfferServiceUtilities);
    assertSame(promotableItemFactory, actualPromotableItemFactory);
  }
}
