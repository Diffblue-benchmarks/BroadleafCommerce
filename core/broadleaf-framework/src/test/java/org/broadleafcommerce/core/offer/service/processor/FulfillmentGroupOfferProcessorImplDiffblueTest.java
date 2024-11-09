/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.FulfillmentGroupOfferPotential;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class FulfillmentGroupOfferProcessorImplDiffblueTest {
  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order2);

    // Assert
    assertTrue(order2.getOrder() instanceof OrderImpl);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_givenNull_whenOrderGetCurrencyReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#getFulfillmentPrice()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  public void testCalculateFulfillmentGroupTotal_thenCallsGetFulfillmentPrice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getFulfillmentPrice()).thenReturn(new Money());
    when(fulfillmentGroupImpl.getShippingOverride()).thenReturn(true);

    ArrayList<FulfillmentGroup> fulfillmentGroupList = new ArrayList<>();
    fulfillmentGroupList.add(fulfillmentGroupImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(fulfillmentGroupList);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(fulfillmentGroupImpl).getFulfillmentPrice();
    verify(fulfillmentGroupImpl).getShippingOverride();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();

    // Act and Assert
    assertFalse(fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true), true));
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    PromotableOrder order = mock(PromotableOrder.class);
    doNothing().when(order).removeAllCandidateFulfillmentOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateFulfillmentOfferAdjustments();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setName("currency.default");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrder()).thenReturn(orderImpl);
    doNothing().when(order).removeAllCandidateItemOfferAdjustments();
    doNothing().when(order).removeAllCandidateOrderOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money(10.0d));
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order, atLeast(1)).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrder();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateItemOfferAdjustments();
    verify(order).removeAllCandidateOrderOfferAdjustments();
    assertTrue(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrencyImpl#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true),
            true);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#setSubTotal(Money)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)}
   */
  @Test
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsSetSubTotal() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());
    NullOrderImpl nullOrderImpl = mock(NullOrderImpl.class);
    doNothing().when(nullOrderImpl).setSubTotal(Mockito.<Money>any());
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrder()).thenReturn(nullOrderImpl);
    doNothing().when(order).removeAllCandidateItemOfferAdjustments();
    doNothing().when(order).removeAllCandidateOrderOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money(10.0d));
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order, atLeast(1)).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order).getOrder();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateItemOfferAdjustments();
    verify(order).removeAllCandidateOrderOfferAdjustments();
    verify(nullOrderImpl).setSubTotal(isA(Money.class));
    assertTrue(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isTotalitarianOffer()).thenReturn(true);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(true);
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(offerImpl);
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(offerImpl).isTotalitarianOffer();
    verify(fulfillmentGroupOfferPotential, atLeast(1)).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(-1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isCombinableWithOtherOffers()).thenReturn(false);
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(offerImpl);
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(offerImpl).isCombinableWithOtherOffers();
    verify(fulfillmentGroupOfferPotential).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(1, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    FulfillmentGroupOfferPotential getResult = actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(0);
    assertTrue(getResult.getOffer() instanceof OfferImpl);
    assertEquals(-1, getResult.getPriority());
    Money totalSavings = getResult.getTotalSavings();
    assertEquals(totalSavings, totalSavings.abs());
    assertEquals(totalSavings, totalSavings.zero());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = mock(FulfillmentGroupOfferPotential.class);
    when(fulfillmentGroupOfferPotential.getOffer()).thenReturn(new OfferImpl());
    doNothing().when(fulfillmentGroupOfferPotential).setOffer(Mockito.<Offer>any());
    doNothing().when(fulfillmentGroupOfferPotential).setPriority(anyInt());
    doNothing().when(fulfillmentGroupOfferPotential).setTotalSavings(Mockito.<Money>any());
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    verify(fulfillmentGroupOfferPotential, atLeast(1)).getOffer();
    verify(fulfillmentGroupOfferPotential).setOffer(isA(Offer.class));
    verify(fulfillmentGroupOfferPotential).setPriority(eq(0));
    verify(fulfillmentGroupOfferPotential).setTotalSavings(isA(Money.class));
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult);
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act and Assert
    assertTrue(fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
        .isEmpty());
  }

  /**
   * Test
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl = new FulfillmentGroupOfferProcessorImpl(
        mock(PromotableOfferUtilityImpl.class));

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(0);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential2 = new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential2.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential2.setPriority(-1);
    fulfillmentGroupOfferPotential2.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential2);
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential> actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult = fulfillmentGroupOfferProcessorImpl
        .removeTrailingNotCombinableFulfillmentGroupOffers(candidateOffers);

    // Assert
    assertEquals(2, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.size());
    assertSame(fulfillmentGroupOfferPotential, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult.get(1));
  }
}
