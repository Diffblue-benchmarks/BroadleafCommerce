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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;

public class PromotableItemFactoryImplDiffblueTest {
  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>Then {@link PromotableOrderImpl#itemFactory} return
   * {@link PromotableItemFactoryImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  public void testCreatePromotableOrder_thenItemFactoryReturnPromotableItemFactoryImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        mock(PromotableOfferUtilityImpl.class));

    // Act
    PromotableOrder actualCreatePromotableOrderResult = promotableItemFactoryImpl
        .createPromotableOrder(new NullOrderImpl(), true);

    // Assert
    PromotableItemFactory promotableItemFactory = ((PromotableOrderImpl) actualCreatePromotableOrderResult).itemFactory;
    assertTrue(promotableItemFactory instanceof PromotableItemFactoryImpl);
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
    assertSame(promotableItemFactoryImpl.promotableOfferUtility,
        ((PromotableItemFactoryImpl) promotableItemFactory).promotableOfferUtility);
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>Then return AllOrderItems Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  public void testCreatePromotableOrder_thenReturnAllOrderItemsEmpty() {
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
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    assertTrue(actualCreatePromotableOrderResult.getAllOrderItems().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getFulfillmentGroups().isEmpty());
    assertSame(currency, actualCreatePromotableOrderResult.getOrderCurrency());
    assertSame(order, actualCreatePromotableOrderResult.getOrder());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return not IncludeOrderAndItemAdjustments.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  public void testCreatePromotableOrder_whenFalse_thenReturnNotIncludeOrderAndItemAdjustments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());

    // Act
    PromotableOrder actualCreatePromotableOrderResult = promotableItemFactoryImpl
        .createPromotableOrder(new NullOrderImpl(), false);

    // Assert
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualCreatePromotableOrderResult.isIncludeOrderAndItemAdjustments());
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  public void testCreatePromotableOrder_whenNullOrderImpl_thenOrderReturnNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());

    // Act
    PromotableOrder actualCreatePromotableOrderResult = promotableItemFactoryImpl
        .createPromotableOrder(new NullOrderImpl(), true);

    // Assert
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder2() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    BigDecimal expectedAmount = new BigDecimal("-2.30");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00");
    Money zeroResult = adjustmentValue.zero();
    assertEquals(expectedAmount2, zeroResult.getAmount());
    BigDecimal expectedAmount3 = new BigDecimal("2.30");
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount3, absResult.getAmount());
    Money zeroResult2 = zeroResult.zero();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertEquals(zeroResult2, absResult6.abs().zero());
    assertEquals(zeroResult2, absResult6.zero());
    assertEquals(zeroResult2, absResult5.zero());
    assertEquals(zeroResult2, absResult4.zero());
    assertEquals(zeroResult2, absResult3.zero());
    assertEquals(zeroResult2, absResult2.zero());
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder3() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder4() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    Money absResult = adjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    Money absResult7 = absResult6.abs();
    assertEquals(absResult7, absResult7.zero());
    assertEquals(absResult7, absResult6.zero());
    assertEquals(absResult7, absResult5.zero());
    assertEquals(absResult7, absResult4.zero());
    assertEquals(absResult7, absResult3.zero());
    assertEquals(absResult7, absResult2.zero());
    assertEquals(absResult7, absResult.zero());
    assertEquals(absResult7, adjustmentValue.zero());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder5() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder6() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer,
            new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder7() {
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
    when(order.calculateOrderAdjustmentTotal()).thenReturn(new Money());
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
    Money absResult = adjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount = absResult6.getAmount();
    assertSame(amount, amount);
    assertSame(amount, absResult6.zero().getAmount());
    BigDecimal amount2 = absResult5.getAmount();
    assertSame(amount2, amount2);
    Money zeroResult = absResult5.zero();
    assertSame(amount2, zeroResult.abs().getAmount());
    assertSame(amount2, zeroResult.getAmount());
    assertSame(amount2, zeroResult.zero().getAmount());
    BigDecimal amount3 = absResult4.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount3, absResult7.abs().getAmount());
    assertSame(amount3, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount3, zeroResult3.abs().getAmount());
    assertSame(amount3, zeroResult2.getAmount());
    assertSame(amount3, absResult7.zero().getAmount());
    assertSame(amount3, zeroResult3.getAmount());
    assertSame(amount3, zeroResult3.zero().getAmount());
    BigDecimal amount4 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount4, absResult9.abs().getAmount());
    assertSame(amount4, amount4);
    assertSame(amount4, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount4, absResult10.abs().getAmount());
    assertSame(amount4, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount4, zeroResult6.abs().getAmount());
    assertSame(amount4, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount4, zeroResult7.abs().getAmount());
    assertSame(amount4, zeroResult4.getAmount());
    assertSame(amount4, absResult9.zero().getAmount());
    assertSame(amount4, zeroResult6.getAmount());
    assertSame(amount4, absResult10.zero().getAmount());
    assertSame(amount4, zeroResult5.getAmount());
    assertSame(amount4, zeroResult6.zero().getAmount());
    assertSame(amount4, zeroResult7.getAmount());
    assertSame(amount4, zeroResult7.zero().getAmount());
    BigDecimal amount5 = absResult2.getAmount();
    Money zeroResult8 = adjustmentValue.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount5, absResult15.abs().getAmount());
    Money zeroResult9 = absResult.zero();
    Money absResult16 = zeroResult9.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(amount5, absResult19.abs().getAmount());
    Money zeroResult10 = zeroResult8.zero();
    Money absResult20 = zeroResult10.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    Money absResult23 = absResult22.abs();
    assertSame(amount5, absResult23.abs().getAmount());
    assertSame(amount5, absResult15.getAmount());
    Money zeroResult11 = absResult2.zero();
    Money absResult24 = zeroResult11.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount5, absResult26.abs().getAmount());
    Money zeroResult12 = absResult11.zero();
    Money absResult27 = zeroResult12.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    assertSame(amount5, absResult29.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    Money zeroResult13 = zeroResult9.zero();
    Money absResult30 = zeroResult13.abs();
    Money absResult31 = absResult30.abs();
    Money absResult32 = absResult31.abs();
    assertSame(amount5, absResult32.abs().getAmount());
    Money zeroResult14 = zeroResult10.zero();
    Money absResult33 = zeroResult14.abs();
    Money absResult34 = absResult33.abs();
    Money absResult35 = absResult34.abs();
    assertSame(amount5, absResult35.abs().getAmount());
    assertSame(amount5, absResult23.getAmount());
    assertSame(amount5, absResult14.getAmount());
    Money zeroResult15 = absResult12.zero();
    Money absResult36 = zeroResult15.abs();
    Money absResult37 = absResult36.abs();
    assertSame(amount5, absResult37.abs().getAmount());
    assertSame(amount5, absResult26.getAmount());
    Money zeroResult16 = absResult16.zero();
    Money absResult38 = zeroResult16.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount5, absResult39.abs().getAmount());
    Money zeroResult17 = absResult20.zero();
    Money absResult40 = zeroResult17.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount5, absResult41.abs().getAmount());
    assertSame(amount5, absResult29.getAmount());
    assertSame(amount5, absResult18.getAmount());
    Money zeroResult18 = zeroResult11.zero();
    Money absResult42 = zeroResult18.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount5, absResult43.abs().getAmount());
    Money zeroResult19 = zeroResult12.zero();
    Money absResult44 = zeroResult19.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount5, absResult45.abs().getAmount());
    assertSame(amount5, absResult32.getAmount());
    Money zeroResult20 = zeroResult13.zero();
    Money absResult46 = zeroResult20.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount5, absResult47.abs().getAmount());
    assertSame(amount5, absResult35.getAmount());
    assertSame(amount5, absResult22.getAmount());
    assertSame(amount5, absResult13.getAmount());
    Money zeroResult21 = absResult13.zero();
    Money absResult48 = zeroResult21.abs();
    assertSame(amount5, absResult48.abs().getAmount());
    Money zeroResult22 = absResult17.zero();
    Money absResult49 = zeroResult22.abs();
    assertSame(amount5, absResult49.abs().getAmount());
    Money zeroResult23 = absResult21.zero();
    Money absResult50 = zeroResult23.abs();
    assertSame(amount5, absResult50.abs().getAmount());
    assertSame(amount5, absResult37.getAmount());
    assertSame(amount5, absResult25.getAmount());
    Money zeroResult24 = absResult24.zero();
    Money absResult51 = zeroResult24.abs();
    assertSame(amount5, absResult51.abs().getAmount());
    Money zeroResult25 = absResult27.zero();
    Money absResult52 = zeroResult25.abs();
    assertSame(amount5, absResult52.abs().getAmount());
    assertSame(amount5, absResult39.getAmount());
    Money zeroResult26 = absResult30.zero();
    Money absResult53 = zeroResult26.abs();
    assertSame(amount5, absResult53.abs().getAmount());
    Money zeroResult27 = absResult33.zero();
    Money absResult54 = zeroResult27.abs();
    assertSame(amount5, absResult54.abs().getAmount());
    assertSame(amount5, absResult41.getAmount());
    assertSame(amount5, absResult28.getAmount());
    assertSame(amount5, absResult17.getAmount());
    Money zeroResult28 = zeroResult15.zero();
    Money absResult55 = zeroResult28.abs();
    assertSame(amount5, absResult55.abs().getAmount());
    assertSame(amount5, absResult43.getAmount());
    Money zeroResult29 = zeroResult16.zero();
    Money absResult56 = zeroResult29.abs();
    assertSame(amount5, absResult56.abs().getAmount());
    Money zeroResult30 = zeroResult17.zero();
    Money absResult57 = zeroResult30.abs();
    assertSame(amount5, absResult57.abs().getAmount());
    assertSame(amount5, absResult45.getAmount());
    assertSame(amount5, absResult31.getAmount());
    Money zeroResult31 = zeroResult18.zero();
    Money absResult58 = zeroResult31.abs();
    assertSame(amount5, absResult58.abs().getAmount());
    Money zeroResult32 = zeroResult19.zero();
    Money absResult59 = zeroResult32.abs();
    assertSame(amount5, absResult59.abs().getAmount());
    assertSame(amount5, absResult47.getAmount());
    Money zeroResult33 = zeroResult20.zero();
    Money absResult60 = zeroResult33.abs();
    assertSame(amount5, absResult60.abs().getAmount());
    Money zeroResult34 = zeroResult14.zero();
    Money absResult61 = zeroResult34.abs();
    assertSame(amount5, absResult61.abs().getAmount());
    assertSame(amount5, absResult34.getAmount());
    assertSame(amount5, absResult21.getAmount());
    assertSame(amount5, absResult12.getAmount());
    assertSame(amount5, amount5);
    Money zeroResult35 = absResult14.zero();
    assertSame(amount5, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult18.zero();
    assertSame(amount5, zeroResult36.abs().getAmount());
    Money zeroResult37 = absResult22.zero();
    assertSame(amount5, zeroResult37.abs().getAmount());
    assertSame(amount5, absResult48.getAmount());
    Money zeroResult38 = absResult25.zero();
    assertSame(amount5, zeroResult38.abs().getAmount());
    Money zeroResult39 = absResult28.zero();
    assertSame(amount5, zeroResult39.abs().getAmount());
    assertSame(amount5, absResult49.getAmount());
    Money zeroResult40 = absResult31.zero();
    assertSame(amount5, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult34.zero();
    assertSame(amount5, zeroResult41.abs().getAmount());
    assertSame(amount5, absResult50.getAmount());
    assertSame(amount5, absResult36.getAmount());
    assertSame(amount5, absResult24.getAmount());
    Money zeroResult42 = absResult36.zero();
    assertSame(amount5, zeroResult42.abs().getAmount());
    assertSame(amount5, absResult51.getAmount());
    Money zeroResult43 = absResult38.zero();
    assertSame(amount5, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult40.zero();
    assertSame(amount5, zeroResult44.abs().getAmount());
    assertSame(amount5, absResult52.getAmount());
    assertSame(amount5, absResult38.getAmount());
    Money zeroResult45 = absResult42.zero();
    assertSame(amount5, zeroResult45.abs().getAmount());
    Money zeroResult46 = absResult44.zero();
    assertSame(amount5, zeroResult46.abs().getAmount());
    assertSame(amount5, absResult53.getAmount());
    Money zeroResult47 = absResult46.zero();
    assertSame(amount5, zeroResult47.abs().getAmount());
    assertSame(amount5, absResult54.getAmount());
    assertSame(amount5, absResult40.getAmount());
    assertSame(amount5, absResult27.getAmount());
    assertSame(amount5, absResult16.getAmount());
    Money zeroResult48 = zeroResult21.zero();
    assertSame(amount5, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult22.zero();
    assertSame(amount5, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult23.zero();
    assertSame(amount5, zeroResult50.abs().getAmount());
    assertSame(amount5, absResult55.getAmount());
    assertSame(amount5, absResult42.getAmount());
    Money zeroResult51 = zeroResult24.zero();
    assertSame(amount5, zeroResult51.abs().getAmount());
    Money zeroResult52 = zeroResult25.zero();
    assertSame(amount5, zeroResult52.abs().getAmount());
    assertSame(amount5, absResult56.getAmount());
    Money zeroResult53 = zeroResult26.zero();
    assertSame(amount5, zeroResult53.abs().getAmount());
    Money zeroResult54 = zeroResult27.zero();
    assertSame(amount5, zeroResult54.abs().getAmount());
    assertSame(amount5, absResult57.getAmount());
    assertSame(amount5, absResult44.getAmount());
    assertSame(amount5, absResult30.getAmount());
    Money zeroResult55 = zeroResult28.zero();
    assertSame(amount5, zeroResult55.abs().getAmount());
    assertSame(amount5, absResult58.getAmount());
    Money zeroResult56 = zeroResult29.zero();
    assertSame(amount5, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult30.zero();
    assertSame(amount5, zeroResult57.abs().getAmount());
    assertSame(amount5, absResult59.getAmount());
    assertSame(amount5, absResult46.getAmount());
    Money zeroResult58 = zeroResult31.zero();
    assertSame(amount5, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult32.zero();
    assertSame(amount5, zeroResult59.abs().getAmount());
    assertSame(amount5, absResult60.getAmount());
    Money zeroResult60 = zeroResult33.zero();
    assertSame(amount5, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult34.zero();
    assertSame(amount5, zeroResult61.abs().getAmount());
    assertSame(amount5, absResult61.getAmount());
    assertSame(amount5, absResult33.getAmount());
    assertSame(amount5, absResult20.getAmount());
    assertSame(amount5, absResult11.getAmount());
    assertSame(amount5, absResult15.zero().getAmount());
    assertSame(amount5, absResult19.zero().getAmount());
    assertSame(amount5, absResult23.zero().getAmount());
    assertSame(amount5, zeroResult35.getAmount());
    assertSame(amount5, absResult26.zero().getAmount());
    assertSame(amount5, absResult29.zero().getAmount());
    assertSame(amount5, zeroResult36.getAmount());
    assertSame(amount5, absResult32.zero().getAmount());
    assertSame(amount5, absResult35.zero().getAmount());
    assertSame(amount5, zeroResult37.getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, absResult37.zero().getAmount());
    assertSame(amount5, zeroResult38.getAmount());
    assertSame(amount5, absResult39.zero().getAmount());
    assertSame(amount5, absResult41.zero().getAmount());
    assertSame(amount5, zeroResult39.getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult43.zero().getAmount());
    assertSame(amount5, absResult45.zero().getAmount());
    assertSame(amount5, zeroResult40.getAmount());
    assertSame(amount5, absResult47.zero().getAmount());
    assertSame(amount5, zeroResult41.getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult15.getAmount());
    assertSame(amount5, zeroResult11.getAmount());
    assertSame(amount5, absResult48.zero().getAmount());
    assertSame(amount5, absResult49.zero().getAmount());
    assertSame(amount5, absResult50.zero().getAmount());
    assertSame(amount5, zeroResult42.getAmount());
    assertSame(amount5, zeroResult24.getAmount());
    assertSame(amount5, absResult51.zero().getAmount());
    assertSame(amount5, absResult52.zero().getAmount());
    assertSame(amount5, zeroResult43.getAmount());
    assertSame(amount5, absResult53.zero().getAmount());
    assertSame(amount5, absResult54.zero().getAmount());
    assertSame(amount5, zeroResult44.getAmount());
    assertSame(amount5, zeroResult25.getAmount());
    assertSame(amount5, zeroResult16.getAmount());
    assertSame(amount5, absResult55.zero().getAmount());
    assertSame(amount5, zeroResult45.getAmount());
    assertSame(amount5, absResult56.zero().getAmount());
    assertSame(amount5, absResult57.zero().getAmount());
    assertSame(amount5, zeroResult46.getAmount());
    assertSame(amount5, zeroResult26.getAmount());
    assertSame(amount5, absResult58.zero().getAmount());
    assertSame(amount5, absResult59.zero().getAmount());
    assertSame(amount5, zeroResult47.getAmount());
    assertSame(amount5, absResult60.zero().getAmount());
    assertSame(amount5, absResult61.zero().getAmount());
    assertSame(amount5, zeroResult27.getAmount());
    assertSame(amount5, zeroResult17.getAmount());
    assertSame(amount5, zeroResult12.getAmount());
    assertSame(amount5, zeroResult9.getAmount());
    assertSame(amount5, zeroResult35.zero().getAmount());
    assertSame(amount5, zeroResult36.zero().getAmount());
    assertSame(amount5, zeroResult37.zero().getAmount());
    assertSame(amount5, zeroResult48.getAmount());
    assertSame(amount5, zeroResult38.zero().getAmount());
    assertSame(amount5, zeroResult39.zero().getAmount());
    assertSame(amount5, zeroResult49.getAmount());
    assertSame(amount5, zeroResult40.zero().getAmount());
    assertSame(amount5, zeroResult41.zero().getAmount());
    assertSame(amount5, zeroResult50.getAmount());
    assertSame(amount5, zeroResult28.getAmount());
    assertSame(amount5, zeroResult18.getAmount());
    assertSame(amount5, zeroResult42.zero().getAmount());
    assertSame(amount5, zeroResult51.getAmount());
    assertSame(amount5, zeroResult43.zero().getAmount());
    assertSame(amount5, zeroResult44.zero().getAmount());
    assertSame(amount5, zeroResult52.getAmount());
    assertSame(amount5, zeroResult29.getAmount());
    assertSame(amount5, zeroResult45.zero().getAmount());
    assertSame(amount5, zeroResult46.zero().getAmount());
    assertSame(amount5, zeroResult53.getAmount());
    assertSame(amount5, zeroResult47.zero().getAmount());
    assertSame(amount5, zeroResult54.getAmount());
    assertSame(amount5, zeroResult30.getAmount());
    assertSame(amount5, zeroResult19.getAmount());
    assertSame(amount5, zeroResult13.getAmount());
    assertSame(amount5, zeroResult48.zero().getAmount());
    assertSame(amount5, zeroResult49.zero().getAmount());
    assertSame(amount5, zeroResult50.zero().getAmount());
    assertSame(amount5, zeroResult55.getAmount());
    assertSame(amount5, zeroResult31.getAmount());
    assertSame(amount5, zeroResult51.zero().getAmount());
    assertSame(amount5, zeroResult52.zero().getAmount());
    assertSame(amount5, zeroResult56.getAmount());
    assertSame(amount5, zeroResult53.zero().getAmount());
    assertSame(amount5, zeroResult54.zero().getAmount());
    assertSame(amount5, zeroResult57.getAmount());
    assertSame(amount5, zeroResult32.getAmount());
    assertSame(amount5, zeroResult20.getAmount());
    assertSame(amount5, zeroResult55.zero().getAmount());
    assertSame(amount5, zeroResult58.getAmount());
    assertSame(amount5, zeroResult56.zero().getAmount());
    assertSame(amount5, zeroResult57.zero().getAmount());
    assertSame(amount5, zeroResult59.getAmount());
    assertSame(amount5, zeroResult33.getAmount());
    assertSame(amount5, zeroResult58.zero().getAmount());
    assertSame(amount5, zeroResult59.zero().getAmount());
    assertSame(amount5, zeroResult60.getAmount());
    assertSame(amount5, zeroResult60.zero().getAmount());
    assertSame(amount5, zeroResult61.zero().getAmount());
    assertSame(amount5, zeroResult61.getAmount());
    assertSame(amount5, zeroResult34.getAmount());
    assertSame(amount5, zeroResult14.getAmount());
    assertSame(amount5, zeroResult10.getAmount());
    assertSame(amount5, zeroResult8.getAmount());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder8() {
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
    assertEquals(money, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder9() {
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
    Money absResult = adjustmentValue.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount = absResult6.getAmount();
    assertSame(amount, amount);
    assertSame(amount, absResult6.zero().getAmount());
    BigDecimal amount2 = absResult5.getAmount();
    assertSame(amount2, amount2);
    Money zeroResult = absResult5.zero();
    assertSame(amount2, zeroResult.abs().getAmount());
    assertSame(amount2, zeroResult.getAmount());
    assertSame(amount2, zeroResult.zero().getAmount());
    BigDecimal amount3 = absResult4.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount3, absResult7.abs().getAmount());
    assertSame(amount3, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount3, zeroResult3.abs().getAmount());
    assertSame(amount3, zeroResult2.getAmount());
    assertSame(amount3, absResult7.zero().getAmount());
    assertSame(amount3, zeroResult3.getAmount());
    assertSame(amount3, zeroResult3.zero().getAmount());
    BigDecimal amount4 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount4, absResult9.abs().getAmount());
    assertSame(amount4, amount4);
    assertSame(amount4, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount4, absResult10.abs().getAmount());
    assertSame(amount4, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount4, zeroResult6.abs().getAmount());
    assertSame(amount4, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount4, zeroResult7.abs().getAmount());
    assertSame(amount4, zeroResult4.getAmount());
    assertSame(amount4, absResult9.zero().getAmount());
    assertSame(amount4, zeroResult6.getAmount());
    assertSame(amount4, absResult10.zero().getAmount());
    assertSame(amount4, zeroResult5.getAmount());
    assertSame(amount4, zeroResult6.zero().getAmount());
    assertSame(amount4, zeroResult7.getAmount());
    assertSame(amount4, zeroResult7.zero().getAmount());
    BigDecimal amount5 = absResult2.getAmount();
    Money zeroResult8 = adjustmentValue.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    Money absResult14 = absResult13.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount5, absResult15.abs().getAmount());
    Money zeroResult9 = absResult.zero();
    Money absResult16 = zeroResult9.abs();
    Money absResult17 = absResult16.abs();
    Money absResult18 = absResult17.abs();
    Money absResult19 = absResult18.abs();
    assertSame(amount5, absResult19.abs().getAmount());
    Money zeroResult10 = zeroResult8.zero();
    Money absResult20 = zeroResult10.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    Money absResult23 = absResult22.abs();
    assertSame(amount5, absResult23.abs().getAmount());
    assertSame(amount5, absResult15.getAmount());
    Money zeroResult11 = absResult2.zero();
    Money absResult24 = zeroResult11.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount5, absResult26.abs().getAmount());
    Money zeroResult12 = absResult11.zero();
    Money absResult27 = zeroResult12.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    assertSame(amount5, absResult29.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    Money zeroResult13 = zeroResult9.zero();
    Money absResult30 = zeroResult13.abs();
    Money absResult31 = absResult30.abs();
    Money absResult32 = absResult31.abs();
    assertSame(amount5, absResult32.abs().getAmount());
    Money zeroResult14 = zeroResult10.zero();
    Money absResult33 = zeroResult14.abs();
    Money absResult34 = absResult33.abs();
    Money absResult35 = absResult34.abs();
    assertSame(amount5, absResult35.abs().getAmount());
    assertSame(amount5, absResult23.getAmount());
    assertSame(amount5, absResult14.getAmount());
    Money zeroResult15 = absResult12.zero();
    Money absResult36 = zeroResult15.abs();
    Money absResult37 = absResult36.abs();
    assertSame(amount5, absResult37.abs().getAmount());
    assertSame(amount5, absResult26.getAmount());
    Money zeroResult16 = absResult16.zero();
    Money absResult38 = zeroResult16.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount5, absResult39.abs().getAmount());
    Money zeroResult17 = absResult20.zero();
    Money absResult40 = zeroResult17.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount5, absResult41.abs().getAmount());
    assertSame(amount5, absResult29.getAmount());
    assertSame(amount5, absResult18.getAmount());
    Money zeroResult18 = zeroResult11.zero();
    Money absResult42 = zeroResult18.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount5, absResult43.abs().getAmount());
    Money zeroResult19 = zeroResult12.zero();
    Money absResult44 = zeroResult19.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount5, absResult45.abs().getAmount());
    assertSame(amount5, absResult32.getAmount());
    Money zeroResult20 = zeroResult13.zero();
    Money absResult46 = zeroResult20.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount5, absResult47.abs().getAmount());
    assertSame(amount5, absResult35.getAmount());
    assertSame(amount5, absResult22.getAmount());
    assertSame(amount5, absResult13.getAmount());
    Money zeroResult21 = absResult13.zero();
    Money absResult48 = zeroResult21.abs();
    assertSame(amount5, absResult48.abs().getAmount());
    Money zeroResult22 = absResult17.zero();
    Money absResult49 = zeroResult22.abs();
    assertSame(amount5, absResult49.abs().getAmount());
    Money zeroResult23 = absResult21.zero();
    Money absResult50 = zeroResult23.abs();
    assertSame(amount5, absResult50.abs().getAmount());
    assertSame(amount5, absResult37.getAmount());
    assertSame(amount5, absResult25.getAmount());
    Money zeroResult24 = absResult24.zero();
    Money absResult51 = zeroResult24.abs();
    assertSame(amount5, absResult51.abs().getAmount());
    Money zeroResult25 = absResult27.zero();
    Money absResult52 = zeroResult25.abs();
    assertSame(amount5, absResult52.abs().getAmount());
    assertSame(amount5, absResult39.getAmount());
    Money zeroResult26 = absResult30.zero();
    Money absResult53 = zeroResult26.abs();
    assertSame(amount5, absResult53.abs().getAmount());
    Money zeroResult27 = absResult33.zero();
    Money absResult54 = zeroResult27.abs();
    assertSame(amount5, absResult54.abs().getAmount());
    assertSame(amount5, absResult41.getAmount());
    assertSame(amount5, absResult28.getAmount());
    assertSame(amount5, absResult17.getAmount());
    Money zeroResult28 = zeroResult15.zero();
    Money absResult55 = zeroResult28.abs();
    assertSame(amount5, absResult55.abs().getAmount());
    assertSame(amount5, absResult43.getAmount());
    Money zeroResult29 = zeroResult16.zero();
    Money absResult56 = zeroResult29.abs();
    assertSame(amount5, absResult56.abs().getAmount());
    Money zeroResult30 = zeroResult17.zero();
    Money absResult57 = zeroResult30.abs();
    assertSame(amount5, absResult57.abs().getAmount());
    assertSame(amount5, absResult45.getAmount());
    assertSame(amount5, absResult31.getAmount());
    Money zeroResult31 = zeroResult18.zero();
    Money absResult58 = zeroResult31.abs();
    assertSame(amount5, absResult58.abs().getAmount());
    Money zeroResult32 = zeroResult19.zero();
    Money absResult59 = zeroResult32.abs();
    assertSame(amount5, absResult59.abs().getAmount());
    assertSame(amount5, absResult47.getAmount());
    Money zeroResult33 = zeroResult20.zero();
    Money absResult60 = zeroResult33.abs();
    assertSame(amount5, absResult60.abs().getAmount());
    Money zeroResult34 = zeroResult14.zero();
    Money absResult61 = zeroResult34.abs();
    assertSame(amount5, absResult61.abs().getAmount());
    assertSame(amount5, absResult34.getAmount());
    assertSame(amount5, absResult21.getAmount());
    assertSame(amount5, absResult12.getAmount());
    assertSame(amount5, amount5);
    Money zeroResult35 = absResult14.zero();
    assertSame(amount5, zeroResult35.abs().getAmount());
    Money zeroResult36 = absResult18.zero();
    assertSame(amount5, zeroResult36.abs().getAmount());
    Money zeroResult37 = absResult22.zero();
    assertSame(amount5, zeroResult37.abs().getAmount());
    assertSame(amount5, absResult48.getAmount());
    Money zeroResult38 = absResult25.zero();
    assertSame(amount5, zeroResult38.abs().getAmount());
    Money zeroResult39 = absResult28.zero();
    assertSame(amount5, zeroResult39.abs().getAmount());
    assertSame(amount5, absResult49.getAmount());
    Money zeroResult40 = absResult31.zero();
    assertSame(amount5, zeroResult40.abs().getAmount());
    Money zeroResult41 = absResult34.zero();
    assertSame(amount5, zeroResult41.abs().getAmount());
    assertSame(amount5, absResult50.getAmount());
    assertSame(amount5, absResult36.getAmount());
    assertSame(amount5, absResult24.getAmount());
    Money zeroResult42 = absResult36.zero();
    assertSame(amount5, zeroResult42.abs().getAmount());
    assertSame(amount5, absResult51.getAmount());
    Money zeroResult43 = absResult38.zero();
    assertSame(amount5, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult40.zero();
    assertSame(amount5, zeroResult44.abs().getAmount());
    assertSame(amount5, absResult52.getAmount());
    assertSame(amount5, absResult38.getAmount());
    Money zeroResult45 = absResult42.zero();
    assertSame(amount5, zeroResult45.abs().getAmount());
    Money zeroResult46 = absResult44.zero();
    assertSame(amount5, zeroResult46.abs().getAmount());
    assertSame(amount5, absResult53.getAmount());
    Money zeroResult47 = absResult46.zero();
    assertSame(amount5, zeroResult47.abs().getAmount());
    assertSame(amount5, absResult54.getAmount());
    assertSame(amount5, absResult40.getAmount());
    assertSame(amount5, absResult27.getAmount());
    assertSame(amount5, absResult16.getAmount());
    Money zeroResult48 = zeroResult21.zero();
    assertSame(amount5, zeroResult48.abs().getAmount());
    Money zeroResult49 = zeroResult22.zero();
    assertSame(amount5, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult23.zero();
    assertSame(amount5, zeroResult50.abs().getAmount());
    assertSame(amount5, absResult55.getAmount());
    assertSame(amount5, absResult42.getAmount());
    Money zeroResult51 = zeroResult24.zero();
    assertSame(amount5, zeroResult51.abs().getAmount());
    Money zeroResult52 = zeroResult25.zero();
    assertSame(amount5, zeroResult52.abs().getAmount());
    assertSame(amount5, absResult56.getAmount());
    Money zeroResult53 = zeroResult26.zero();
    assertSame(amount5, zeroResult53.abs().getAmount());
    Money zeroResult54 = zeroResult27.zero();
    assertSame(amount5, zeroResult54.abs().getAmount());
    assertSame(amount5, absResult57.getAmount());
    assertSame(amount5, absResult44.getAmount());
    assertSame(amount5, absResult30.getAmount());
    Money zeroResult55 = zeroResult28.zero();
    assertSame(amount5, zeroResult55.abs().getAmount());
    assertSame(amount5, absResult58.getAmount());
    Money zeroResult56 = zeroResult29.zero();
    assertSame(amount5, zeroResult56.abs().getAmount());
    Money zeroResult57 = zeroResult30.zero();
    assertSame(amount5, zeroResult57.abs().getAmount());
    assertSame(amount5, absResult59.getAmount());
    assertSame(amount5, absResult46.getAmount());
    Money zeroResult58 = zeroResult31.zero();
    assertSame(amount5, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult32.zero();
    assertSame(amount5, zeroResult59.abs().getAmount());
    assertSame(amount5, absResult60.getAmount());
    Money zeroResult60 = zeroResult33.zero();
    assertSame(amount5, zeroResult60.abs().getAmount());
    Money zeroResult61 = zeroResult34.zero();
    assertSame(amount5, zeroResult61.abs().getAmount());
    assertSame(amount5, absResult61.getAmount());
    assertSame(amount5, absResult33.getAmount());
    assertSame(amount5, absResult20.getAmount());
    assertSame(amount5, absResult11.getAmount());
    assertSame(amount5, absResult15.zero().getAmount());
    assertSame(amount5, absResult19.zero().getAmount());
    assertSame(amount5, absResult23.zero().getAmount());
    assertSame(amount5, zeroResult35.getAmount());
    assertSame(amount5, absResult26.zero().getAmount());
    assertSame(amount5, absResult29.zero().getAmount());
    assertSame(amount5, zeroResult36.getAmount());
    assertSame(amount5, absResult32.zero().getAmount());
    assertSame(amount5, absResult35.zero().getAmount());
    assertSame(amount5, zeroResult37.getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, absResult37.zero().getAmount());
    assertSame(amount5, zeroResult38.getAmount());
    assertSame(amount5, absResult39.zero().getAmount());
    assertSame(amount5, absResult41.zero().getAmount());
    assertSame(amount5, zeroResult39.getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult43.zero().getAmount());
    assertSame(amount5, absResult45.zero().getAmount());
    assertSame(amount5, zeroResult40.getAmount());
    assertSame(amount5, absResult47.zero().getAmount());
    assertSame(amount5, zeroResult41.getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult15.getAmount());
    assertSame(amount5, zeroResult11.getAmount());
    assertSame(amount5, absResult48.zero().getAmount());
    assertSame(amount5, absResult49.zero().getAmount());
    assertSame(amount5, absResult50.zero().getAmount());
    assertSame(amount5, zeroResult42.getAmount());
    assertSame(amount5, zeroResult24.getAmount());
    assertSame(amount5, absResult51.zero().getAmount());
    assertSame(amount5, absResult52.zero().getAmount());
    assertSame(amount5, zeroResult43.getAmount());
    assertSame(amount5, absResult53.zero().getAmount());
    assertSame(amount5, absResult54.zero().getAmount());
    assertSame(amount5, zeroResult44.getAmount());
    assertSame(amount5, zeroResult25.getAmount());
    assertSame(amount5, zeroResult16.getAmount());
    assertSame(amount5, absResult55.zero().getAmount());
    assertSame(amount5, zeroResult45.getAmount());
    assertSame(amount5, absResult56.zero().getAmount());
    assertSame(amount5, absResult57.zero().getAmount());
    assertSame(amount5, zeroResult46.getAmount());
    assertSame(amount5, zeroResult26.getAmount());
    assertSame(amount5, absResult58.zero().getAmount());
    assertSame(amount5, absResult59.zero().getAmount());
    assertSame(amount5, zeroResult47.getAmount());
    assertSame(amount5, absResult60.zero().getAmount());
    assertSame(amount5, absResult61.zero().getAmount());
    assertSame(amount5, zeroResult27.getAmount());
    assertSame(amount5, zeroResult17.getAmount());
    assertSame(amount5, zeroResult12.getAmount());
    assertSame(amount5, zeroResult9.getAmount());
    assertSame(amount5, zeroResult35.zero().getAmount());
    assertSame(amount5, zeroResult36.zero().getAmount());
    assertSame(amount5, zeroResult37.zero().getAmount());
    assertSame(amount5, zeroResult48.getAmount());
    assertSame(amount5, zeroResult38.zero().getAmount());
    assertSame(amount5, zeroResult39.zero().getAmount());
    assertSame(amount5, zeroResult49.getAmount());
    assertSame(amount5, zeroResult40.zero().getAmount());
    assertSame(amount5, zeroResult41.zero().getAmount());
    assertSame(amount5, zeroResult50.getAmount());
    assertSame(amount5, zeroResult28.getAmount());
    assertSame(amount5, zeroResult18.getAmount());
    assertSame(amount5, zeroResult42.zero().getAmount());
    assertSame(amount5, zeroResult51.getAmount());
    assertSame(amount5, zeroResult43.zero().getAmount());
    assertSame(amount5, zeroResult44.zero().getAmount());
    assertSame(amount5, zeroResult52.getAmount());
    assertSame(amount5, zeroResult29.getAmount());
    assertSame(amount5, zeroResult45.zero().getAmount());
    assertSame(amount5, zeroResult46.zero().getAmount());
    assertSame(amount5, zeroResult53.getAmount());
    assertSame(amount5, zeroResult47.zero().getAmount());
    assertSame(amount5, zeroResult54.getAmount());
    assertSame(amount5, zeroResult30.getAmount());
    assertSame(amount5, zeroResult19.getAmount());
    assertSame(amount5, zeroResult13.getAmount());
    assertSame(amount5, zeroResult48.zero().getAmount());
    assertSame(amount5, zeroResult49.zero().getAmount());
    assertSame(amount5, zeroResult50.zero().getAmount());
    assertSame(amount5, zeroResult55.getAmount());
    assertSame(amount5, zeroResult31.getAmount());
    assertSame(amount5, zeroResult51.zero().getAmount());
    assertSame(amount5, zeroResult52.zero().getAmount());
    assertSame(amount5, zeroResult56.getAmount());
    assertSame(amount5, zeroResult53.zero().getAmount());
    assertSame(amount5, zeroResult54.zero().getAmount());
    assertSame(amount5, zeroResult57.getAmount());
    assertSame(amount5, zeroResult32.getAmount());
    assertSame(amount5, zeroResult20.getAmount());
    assertSame(amount5, zeroResult55.zero().getAmount());
    assertSame(amount5, zeroResult58.getAmount());
    assertSame(amount5, zeroResult56.zero().getAmount());
    assertSame(amount5, zeroResult57.zero().getAmount());
    assertSame(amount5, zeroResult59.getAmount());
    assertSame(amount5, zeroResult33.getAmount());
    assertSame(amount5, zeroResult58.zero().getAmount());
    assertSame(amount5, zeroResult59.zero().getAmount());
    assertSame(amount5, zeroResult60.getAmount());
    assertSame(amount5, zeroResult60.zero().getAmount());
    assertSame(amount5, zeroResult61.zero().getAmount());
    assertSame(amount5, zeroResult61.getAmount());
    assertSame(amount5, zeroResult34.getAmount());
    assertSame(amount5, zeroResult14.getAmount());
    assertSame(amount5, zeroResult10.getAmount());
    assertSame(amount5, zeroResult8.getAmount());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   * with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder10() {
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
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue2() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue3() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue4() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

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
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue5() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue6() {
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
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order2, new Money());

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
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue7() {
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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    BigDecimal amount = absResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    Money absResult6 = absResult5.abs();
    assertSame(absResult6.abs().getAmount(), absResult6.abs().getAmount());
    BigDecimal amount2 = absResult6.getAmount();
    assertSame(amount2, amount2);
    assertSame(amount2, absResult6.zero().getAmount());
    BigDecimal amount3 = absResult5.getAmount();
    assertSame(amount3, amount3);
    Money zeroResult = absResult5.zero();
    assertSame(amount3, zeroResult.abs().getAmount());
    assertSame(amount3, zeroResult.getAmount());
    assertSame(amount3, zeroResult.zero().getAmount());
    BigDecimal amount4 = absResult4.getAmount();
    assertSame(amount4, amount4);
    Money zeroResult2 = absResult4.zero();
    Money absResult7 = zeroResult2.abs();
    assertSame(amount4, absResult7.abs().getAmount());
    assertSame(amount4, absResult7.getAmount());
    Money zeroResult3 = zeroResult2.zero();
    assertSame(amount4, zeroResult3.abs().getAmount());
    assertSame(amount4, zeroResult2.getAmount());
    assertSame(amount4, absResult7.zero().getAmount());
    assertSame(amount4, zeroResult3.getAmount());
    assertSame(amount4, zeroResult3.zero().getAmount());
    BigDecimal amount5 = absResult3.getAmount();
    Money zeroResult4 = absResult3.zero();
    Money absResult8 = zeroResult4.abs();
    Money absResult9 = absResult8.abs();
    assertSame(amount5, absResult9.abs().getAmount());
    assertSame(amount5, amount5);
    assertSame(amount5, absResult9.getAmount());
    Money zeroResult5 = zeroResult4.zero();
    Money absResult10 = zeroResult5.abs();
    assertSame(amount5, absResult10.abs().getAmount());
    assertSame(amount5, absResult8.getAmount());
    Money zeroResult6 = absResult8.zero();
    assertSame(amount5, zeroResult6.abs().getAmount());
    assertSame(amount5, absResult10.getAmount());
    Money zeroResult7 = zeroResult5.zero();
    assertSame(amount5, zeroResult7.abs().getAmount());
    assertSame(amount5, zeroResult4.getAmount());
    assertSame(amount5, absResult9.zero().getAmount());
    assertSame(amount5, zeroResult6.getAmount());
    assertSame(amount5, absResult10.zero().getAmount());
    assertSame(amount5, zeroResult5.getAmount());
    assertSame(amount5, zeroResult6.zero().getAmount());
    assertSame(amount5, zeroResult7.getAmount());
    assertSame(amount5, zeroResult7.zero().getAmount());
    BigDecimal amount6 = absResult2.getAmount();
    Money zeroResult8 = absResult2.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    Money absResult13 = absResult12.abs();
    assertSame(amount6, absResult13.abs().getAmount());
    assertSame(amount6, absResult13.getAmount());
    Money zeroResult9 = zeroResult8.zero();
    Money absResult14 = zeroResult9.abs();
    Money absResult15 = absResult14.abs();
    assertSame(amount6, absResult15.abs().getAmount());
    assertSame(amount6, absResult12.getAmount());
    Money zeroResult10 = absResult11.zero();
    Money absResult16 = zeroResult10.abs();
    assertSame(amount6, absResult16.abs().getAmount());
    assertSame(amount6, absResult15.getAmount());
    Money zeroResult11 = zeroResult9.zero();
    Money absResult17 = zeroResult11.abs();
    assertSame(amount6, absResult17.abs().getAmount());
    assertSame(amount6, amount6);
    Money zeroResult12 = absResult12.zero();
    assertSame(amount6, zeroResult12.abs().getAmount());
    assertSame(amount6, absResult11.getAmount());
    assertSame(amount6, absResult16.getAmount());
    Money zeroResult13 = absResult14.zero();
    assertSame(amount6, zeroResult13.abs().getAmount());
    assertSame(amount6, absResult14.getAmount());
    Money zeroResult14 = zeroResult10.zero();
    assertSame(amount6, zeroResult14.abs().getAmount());
    assertSame(amount6, absResult17.getAmount());
    Money zeroResult15 = zeroResult11.zero();
    assertSame(amount6, zeroResult15.abs().getAmount());
    assertSame(amount6, absResult13.zero().getAmount());
    assertSame(amount6, zeroResult12.getAmount());
    assertSame(amount6, absResult15.zero().getAmount());
    assertSame(amount6, zeroResult8.getAmount());
    assertSame(amount6, zeroResult10.getAmount());
    assertSame(amount6, absResult16.zero().getAmount());
    assertSame(amount6, zeroResult13.getAmount());
    assertSame(amount6, absResult17.zero().getAmount());
    assertSame(amount6, zeroResult12.zero().getAmount());
    assertSame(amount6, zeroResult9.getAmount());
    assertSame(amount6, zeroResult14.getAmount());
    assertSame(amount6, zeroResult13.zero().getAmount());
    assertSame(amount6, zeroResult11.getAmount());
    assertSame(amount6, zeroResult14.zero().getAmount());
    assertSame(amount6, zeroResult15.getAmount());
    assertSame(amount6, zeroResult15.zero().getAmount());
    Money zeroResult16 = adjustmentValue.zero();
    Money absResult18 = zeroResult16.abs();
    Money absResult19 = absResult18.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    Money absResult22 = absResult21.abs();
    assertSame(amount, absResult22.abs().getAmount());
    Money zeroResult17 = absResult.zero();
    Money absResult23 = zeroResult17.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    Money zeroResult18 = zeroResult16.zero();
    Money absResult27 = zeroResult18.abs();
    Money absResult28 = absResult27.abs();
    Money absResult29 = absResult28.abs();
    Money absResult30 = absResult29.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult22.getAmount());
    Money zeroResult19 = absResult18.zero();
    Money absResult31 = zeroResult19.abs();
    Money absResult32 = absResult31.abs();
    Money absResult33 = absResult32.abs();
    assertSame(amount, absResult33.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult20 = zeroResult17.zero();
    Money absResult34 = zeroResult20.abs();
    Money absResult35 = absResult34.abs();
    Money absResult36 = absResult35.abs();
    assertSame(amount, absResult36.abs().getAmount());
    Money zeroResult21 = zeroResult18.zero();
    Money absResult37 = zeroResult21.abs();
    Money absResult38 = absResult37.abs();
    Money absResult39 = absResult38.abs();
    assertSame(amount, absResult39.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    assertSame(amount, absResult21.getAmount());
    Money zeroResult22 = absResult19.zero();
    Money absResult40 = zeroResult22.abs();
    Money absResult41 = absResult40.abs();
    assertSame(amount, absResult41.abs().getAmount());
    Money zeroResult23 = absResult23.zero();
    Money absResult42 = zeroResult23.abs();
    Money absResult43 = absResult42.abs();
    assertSame(amount, absResult43.abs().getAmount());
    Money zeroResult24 = absResult27.zero();
    Money absResult44 = zeroResult24.abs();
    Money absResult45 = absResult44.abs();
    assertSame(amount, absResult45.abs().getAmount());
    assertSame(amount, absResult33.getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = zeroResult19.zero();
    Money absResult46 = zeroResult25.abs();
    Money absResult47 = absResult46.abs();
    assertSame(amount, absResult47.abs().getAmount());
    assertSame(amount, absResult36.getAmount());
    Money zeroResult26 = zeroResult20.zero();
    Money absResult48 = zeroResult26.abs();
    Money absResult49 = absResult48.abs();
    assertSame(amount, absResult49.abs().getAmount());
    assertSame(amount, absResult39.getAmount());
    assertSame(amount, absResult29.getAmount());
    assertSame(amount, absResult20.getAmount());
    Money zeroResult27 = absResult20.zero();
    Money absResult50 = zeroResult27.abs();
    assertSame(amount, absResult50.abs().getAmount());
    Money zeroResult28 = absResult24.zero();
    Money absResult51 = zeroResult28.abs();
    assertSame(amount, absResult51.abs().getAmount());
    Money zeroResult29 = absResult28.zero();
    Money absResult52 = zeroResult29.abs();
    assertSame(amount, absResult52.abs().getAmount());
    assertSame(amount, absResult41.getAmount());
    Money zeroResult30 = absResult31.zero();
    Money absResult53 = zeroResult30.abs();
    assertSame(amount, absResult53.abs().getAmount());
    assertSame(amount, absResult43.getAmount());
    Money zeroResult31 = absResult34.zero();
    Money absResult54 = zeroResult31.abs();
    assertSame(amount, absResult54.abs().getAmount());
    assertSame(amount, absResult45.getAmount());
    assertSame(amount, absResult32.getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult32 = zeroResult22.zero();
    Money absResult55 = zeroResult32.abs();
    assertSame(amount, absResult55.abs().getAmount());
    Money zeroResult33 = zeroResult23.zero();
    Money absResult56 = zeroResult33.abs();
    assertSame(amount, absResult56.abs().getAmount());
    Money zeroResult34 = zeroResult24.zero();
    Money absResult57 = zeroResult34.abs();
    assertSame(amount, absResult57.abs().getAmount());
    assertSame(amount, absResult47.getAmount());
    assertSame(amount, absResult35.getAmount());
    Money zeroResult35 = zeroResult25.zero();
    Money absResult58 = zeroResult35.abs();
    assertSame(amount, absResult58.abs().getAmount());
    assertSame(amount, absResult49.getAmount());
    Money zeroResult36 = zeroResult26.zero();
    Money absResult59 = zeroResult36.abs();
    assertSame(amount, absResult59.abs().getAmount());
    Money zeroResult37 = zeroResult21.zero();
    Money absResult60 = zeroResult37.abs();
    assertSame(amount, absResult60.abs().getAmount());
    assertSame(amount, absResult38.getAmount());
    assertSame(amount, absResult28.getAmount());
    assertSame(amount, absResult19.getAmount());
    Money zeroResult38 = absResult21.zero();
    assertSame(amount, zeroResult38.abs().getAmount());
    Money zeroResult39 = absResult25.zero();
    assertSame(amount, zeroResult39.abs().getAmount());
    Money zeroResult40 = absResult29.zero();
    assertSame(amount, zeroResult40.abs().getAmount());
    assertSame(amount, absResult50.getAmount());
    Money zeroResult41 = absResult32.zero();
    assertSame(amount, zeroResult41.abs().getAmount());
    assertSame(amount, absResult51.getAmount());
    Money zeroResult42 = absResult35.zero();
    assertSame(amount, zeroResult42.abs().getAmount());
    assertSame(amount, absResult52.getAmount());
    assertSame(amount, absResult40.getAmount());
    Money zeroResult43 = absResult40.zero();
    assertSame(amount, zeroResult43.abs().getAmount());
    Money zeroResult44 = absResult42.zero();
    assertSame(amount, zeroResult44.abs().getAmount());
    Money zeroResult45 = absResult44.zero();
    assertSame(amount, zeroResult45.abs().getAmount());
    assertSame(amount, absResult53.getAmount());
    assertSame(amount, absResult42.getAmount());
    Money zeroResult46 = absResult46.zero();
    assertSame(amount, zeroResult46.abs().getAmount());
    assertSame(amount, absResult54.getAmount());
    Money zeroResult47 = absResult48.zero();
    assertSame(amount, zeroResult47.abs().getAmount());
    Money zeroResult48 = absResult37.zero();
    assertSame(amount, zeroResult48.abs().getAmount());
    assertSame(amount, absResult44.getAmount());
    assertSame(amount, absResult31.getAmount());
    assertSame(amount, absResult23.getAmount());
    Money zeroResult49 = zeroResult27.zero();
    assertSame(amount, zeroResult49.abs().getAmount());
    Money zeroResult50 = zeroResult28.zero();
    assertSame(amount, zeroResult50.abs().getAmount());
    Money zeroResult51 = zeroResult29.zero();
    assertSame(amount, zeroResult51.abs().getAmount());
    assertSame(amount, absResult55.getAmount());
    Money zeroResult52 = zeroResult30.zero();
    assertSame(amount, zeroResult52.abs().getAmount());
    assertSame(amount, absResult56.getAmount());
    Money zeroResult53 = zeroResult31.zero();
    assertSame(amount, zeroResult53.abs().getAmount());
    assertSame(amount, absResult57.getAmount());
    assertSame(amount, absResult46.getAmount());
    assertSame(amount, absResult34.getAmount());
    Money zeroResult54 = zeroResult32.zero();
    assertSame(amount, zeroResult54.abs().getAmount());
    Money zeroResult55 = zeroResult33.zero();
    assertSame(amount, zeroResult55.abs().getAmount());
    Money zeroResult56 = zeroResult34.zero();
    assertSame(amount, zeroResult56.abs().getAmount());
    assertSame(amount, absResult58.getAmount());
    assertSame(amount, absResult48.getAmount());
    Money zeroResult57 = zeroResult35.zero();
    assertSame(amount, zeroResult57.abs().getAmount());
    assertSame(amount, absResult59.getAmount());
    Money zeroResult58 = zeroResult36.zero();
    assertSame(amount, zeroResult58.abs().getAmount());
    Money zeroResult59 = zeroResult37.zero();
    assertSame(amount, zeroResult59.abs().getAmount());
    assertSame(amount, absResult60.getAmount());
    assertSame(amount, absResult37.getAmount());
    assertSame(amount, absResult27.getAmount());
    assertSame(amount, absResult18.getAmount());
    assertSame(amount, absResult22.zero().getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult38.getAmount());
    assertSame(amount, absResult33.zero().getAmount());
    assertSame(amount, zeroResult39.getAmount());
    assertSame(amount, absResult36.zero().getAmount());
    assertSame(amount, absResult39.zero().getAmount());
    assertSame(amount, zeroResult40.getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult41.zero().getAmount());
    assertSame(amount, absResult43.zero().getAmount());
    assertSame(amount, absResult45.zero().getAmount());
    assertSame(amount, zeroResult41.getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult47.zero().getAmount());
    assertSame(amount, zeroResult42.getAmount());
    assertSame(amount, absResult49.zero().getAmount());
    assertSame(amount, absResult38.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult22.getAmount());
    assertSame(amount, absResult50.zero().getAmount());
    assertSame(amount, absResult51.zero().getAmount());
    assertSame(amount, absResult52.zero().getAmount());
    assertSame(amount, zeroResult43.getAmount());
    assertSame(amount, absResult53.zero().getAmount());
    assertSame(amount, zeroResult44.getAmount());
    assertSame(amount, absResult54.zero().getAmount());
    assertSame(amount, zeroResult45.getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult23.getAmount());
    assertSame(amount, absResult55.zero().getAmount());
    assertSame(amount, absResult56.zero().getAmount());
    assertSame(amount, absResult57.zero().getAmount());
    assertSame(amount, zeroResult46.getAmount());
    assertSame(amount, zeroResult31.getAmount());
    assertSame(amount, absResult58.zero().getAmount());
    assertSame(amount, zeroResult47.getAmount());
    assertSame(amount, absResult59.zero().getAmount());
    assertSame(amount, absResult60.zero().getAmount());
    assertSame(amount, zeroResult48.getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult19.getAmount());
    assertSame(amount, zeroResult17.getAmount());
    assertSame(amount, zeroResult38.zero().getAmount());
    assertSame(amount, zeroResult39.zero().getAmount());
    assertSame(amount, zeroResult40.zero().getAmount());
    assertSame(amount, zeroResult49.getAmount());
    assertSame(amount, zeroResult41.zero().getAmount());
    assertSame(amount, zeroResult50.getAmount());
    assertSame(amount, zeroResult42.zero().getAmount());
    assertSame(amount, zeroResult51.getAmount());
    assertSame(amount, zeroResult32.getAmount());
    assertSame(amount, zeroResult43.zero().getAmount());
    assertSame(amount, zeroResult44.zero().getAmount());
    assertSame(amount, zeroResult45.zero().getAmount());
    assertSame(amount, zeroResult52.getAmount());
    assertSame(amount, zeroResult33.getAmount());
    assertSame(amount, zeroResult46.zero().getAmount());
    assertSame(amount, zeroResult53.getAmount());
    assertSame(amount, zeroResult47.zero().getAmount());
    assertSame(amount, zeroResult48.zero().getAmount());
    assertSame(amount, zeroResult34.getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, zeroResult20.getAmount());
    assertSame(amount, zeroResult49.zero().getAmount());
    assertSame(amount, zeroResult50.zero().getAmount());
    assertSame(amount, zeroResult51.zero().getAmount());
    assertSame(amount, zeroResult54.getAmount());
    assertSame(amount, zeroResult52.zero().getAmount());
    assertSame(amount, zeroResult55.getAmount());
    assertSame(amount, zeroResult53.zero().getAmount());
    assertSame(amount, zeroResult56.getAmount());
    assertSame(amount, zeroResult35.getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult54.zero().getAmount());
    assertSame(amount, zeroResult55.zero().getAmount());
    assertSame(amount, zeroResult56.zero().getAmount());
    assertSame(amount, zeroResult57.getAmount());
    assertSame(amount, zeroResult36.getAmount());
    assertSame(amount, zeroResult57.zero().getAmount());
    assertSame(amount, zeroResult58.getAmount());
    assertSame(amount, zeroResult58.zero().getAmount());
    assertSame(amount, zeroResult59.zero().getAmount());
    assertSame(amount, zeroResult59.getAmount());
    assertSame(amount, zeroResult37.getAmount());
    assertSame(amount, zeroResult21.getAmount());
    assertSame(amount, zeroResult18.getAmount());
    assertSame(amount, zeroResult16.getAmount());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue8() {
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
    Money money = new Money();
    when(order.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, new Money());

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
    assertEquals(money, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue9() {
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
    Money money = new Money();
    when(order.calculateOrderAdjustmentTotal()).thenReturn(money);
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, new Money());

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
    assertEquals(money, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue10() {
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
    when(order.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(mock(Money.class));
    when(order.calculateSubtotalWithAdjustments()).thenReturn(money);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, new Money());

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
    assertEquals(money2, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   * with {@code promotableCandidateOrderOffer}, {@code order},
   * {@code adjustmentValue}.
   * <p>
   * Method under test:
   * {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)}
   */
  @Test
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue11() {
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

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult = promotableItemFactoryImpl
        .createPromotableOrderAdjustment(promotableCandidateOrderOffer, order, new Money());

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
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }
}
