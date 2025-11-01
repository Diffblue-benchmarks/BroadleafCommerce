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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableItemFactoryImplDiffblueTest {
  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  public void testCreatePromotableOrder() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    order.setCurrency(currency);
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

    // Act
    PromotableOrder actualCreatePromotableOrderResult = promotableItemFactoryImpl.createPromotableOrder(order, true);

    // Assert
    PromotableItemFactory promotableItemFactory = ((PromotableOrderImpl) actualCreatePromotableOrderResult).itemFactory;
    assertTrue(promotableItemFactory instanceof PromotableItemFactoryImpl);
    PromotableOfferUtility promotableOfferUtility = ((PromotableItemFactoryImpl) promotableItemFactory).promotableOfferUtility;
    assertTrue(promotableOfferUtility instanceof PromotableOfferUtilityImpl);
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    assertNull(((PromotableItemFactoryImpl) promotableItemFactory).itemOfferPercentRoundingScale);
    assertNull(((PromotableItemFactoryImpl) promotableItemFactory).itemOfferPercentRoundingModeStr);
    assertNull(((PromotableItemFactoryImpl) promotableItemFactory).itemOfferPercentRoundingMode);
    assertFalse(actualCreatePromotableOrderResult.isHasOrderAdjustments());
    assertFalse(actualCreatePromotableOrderResult.isTotalitarianFgOfferApplied());
    assertFalse(actualCreatePromotableOrderResult.isTotalitarianItemOfferApplied());
    assertFalse(actualCreatePromotableOrderResult.isTotalitarianOfferApplied());
    assertFalse(actualCreatePromotableOrderResult.isTotalitarianOrderOfferApplied());
    assertFalse(((PromotableOrderImpl) actualCreatePromotableOrderResult).isNotCombinableOrderOfferApplied());
    assertFalse(((PromotableItemFactoryImpl) promotableItemFactory).useQtyOnlyTierCalculation);
    assertFalse(((PromotableOrderImpl) actualCreatePromotableOrderResult).currentSortParam);
    List<PromotableOrderItem> allOrderItems = actualCreatePromotableOrderResult.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getCandidateOrderAdjustments().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getDiscountableOrderItems().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getFulfillmentGroups().isEmpty());
    assertTrue(((PromotableOrderImpl) actualCreatePromotableOrderResult).discountableOrderItems.isEmpty());
    assertTrue(((PromotableOrderImpl) actualCreatePromotableOrderResult).fulfillmentGroups.isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getExtraDataMap().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.isIncludeOrderAndItemAdjustments());
    assertSame(currency, actualCreatePromotableOrderResult.getOrderCurrency());
    assertSame(order, actualCreatePromotableOrderResult.getOrder());
    assertSame(allOrderItems, ((PromotableOrderImpl) actualCreatePromotableOrderResult).allOrderItems);
    assertSame(promotableItemFactoryImpl.promotableOfferUtility, promotableOfferUtility);
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("-2.30");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00");
    Money zeroResult = adjustmentValue.zero();
    assertEquals(expectedAmount2, zeroResult.getAmount());
    BigDecimal expectedAmount3 = new BigDecimal("2.30");
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount3, absResult.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertEquals(absResult.abs(), absResult.abs());
    Money zeroResult2 = zeroResult.zero();
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
    assertSame(currency, absResult.getCurrency());
    assertSame(currency, zeroResult.getCurrency());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    Money absResult2 = absResult.abs();
    assertEquals(absResult2, absResult2);
    assertEquals(absResult2, absResult.zero());
    assertEquals(absResult2, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
    assertSame(currency, absResult.getCurrency());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(new OfferDiscountType());
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(order.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(840, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00000");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(money, adjustmentValue.abs());
    assertEquals(money, adjustmentValue.zero());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.setScale(anyInt(), anyInt())).thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(null);
    Money money = new Money();
    when(order.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order);

    // Assert
    verify(internalNumber).setScale(eq(2), eq(6));
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(money, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    Money money2 = new Money();
    when(money.subtract(Mockito.<Money>any())).thenReturn(money2);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(order.calculateSubtotalWithAdjustments()).thenReturn(money);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(840, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00000");
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(money2, adjustmentValue.abs());
    assertEquals(money2, adjustmentValue.zero());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(order.calculateSubtotalWithAdjustments()).thenReturn(money2);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).getAmount();
    verify(money).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment11() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment12() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment13() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment14() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment15() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(new OfferDiscountType());
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment16() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment17() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    ArrayList<OrderAdjustment> expectedPromotableOrderItemList = new ArrayList<>();
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrencyImpl, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(826, currency.getNumericCode());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    assertEquals(expectedPromotableOrderItemList, order2.allOrderItems);
    Money absResult2 = absResult.abs();
    assertEquals(absResult2, absResult2);
    assertEquals(absResult2, absResult.zero());
    assertEquals(absResult2, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
    assertSame(currency, absResult.getCurrency());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment18() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).isIncludeOrderAndItemAdjustments();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment19() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.setScale(anyInt(), anyInt())).thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, adjustmentValue);

    // Assert
    verify(internalNumber).setScale(eq(2), eq(6));
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).isIncludeOrderAndItemAdjustments();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment20() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.subtract(Mockito.<Money>any())).thenReturn(new Money());
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(order.calculateSubtotalWithAdjustments()).thenReturn(money);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).isIncludeOrderAndItemAdjustments();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustment21() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOffer promotableCandidateOrderOffer = mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    when(money.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);
    PromotableOrder order = mock(PromotableOrder.class);
    when(order.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(order.calculateSubtotalWithAdjustments()).thenReturn(money2);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(money).getAmount();
    verify(money).lessThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).isIncludeOrderAndItemAdjustments();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertEquals(2, ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingScale());
    assertEquals(RoundingMode.HALF_EVEN,
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).getRoundingMode());
    assertTrue(actualCreatePromotableOrderAdjustmentResult.isFutureCredit());
    assertTrue(((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult).isRoundOfferValues());
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }
}
