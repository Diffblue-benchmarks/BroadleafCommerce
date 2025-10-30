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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mvel2.util.InternalNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PromotableItemFactoryImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PromotableItemFactoryImplDiffblueTest {
  @Autowired
  private PromotableItemFactoryImpl promotableItemFactoryImpl;

  @MockBean
  private PromotableOfferUtility promotableOfferUtility;

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>Then OrderCurrency return {@link BroadleafCurrencyImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"})
  public void testCreatePromotableOrder_thenOrderCurrencyReturnBroadleafCurrencyImpl() {
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
    BroadleafCurrency orderCurrency = actualCreatePromotableOrderResult.getOrderCurrency();
    assertTrue(orderCurrency instanceof BroadleafCurrencyImpl);
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order2 = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualCreatePromotableOrderResult.getAllOrderItems().isEmpty());
    assertTrue(actualCreatePromotableOrderResult.getFulfillmentGroups().isEmpty());
    assertSame(currency, orderCurrency);
    assertSame(order, order2);
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return not IncludeOrderAndItemAdjustments.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"})
  public void testCreatePromotableOrder_whenFalse_thenReturnNotIncludeOrderAndItemAdjustments() {
    // Arrange and Act
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
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"})
  public void testCreatePromotableOrder_whenNullOrderImpl_thenOrderReturnNullOrderImpl() {
    // Arrange and Act
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
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder2() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    assertEquals(zeroResult2, absResult.abs().zero());
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    assertEquals(zeroResult, zeroResult.abs());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder3() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder4() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Money absResult = adjustmentValue.abs();
    assertEquals(expectedAmount, absResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("0.00000");
    assertEquals(expectedAmount2, adjustmentValue.getAmount());
    Money absResult2 = absResult.abs();
    assertEquals(absResult2, absResult2.zero());
    assertEquals(absResult2, absResult.zero());
    assertEquals(absResult2, adjustmentValue.zero());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder5() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(new OfferDiscountType());
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   * <p>
   * Method under test: {@link PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"})
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder6() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(
        new PromotableOfferUtilityImpl());
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));
    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer = mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    assertEquals(expectedAmount, adjustmentValue.getAmount());
    assertEquals(adjustmentValue, adjustmentValue.abs());
    assertEquals(adjustmentValue, adjustmentValue.zero());
  }
}
