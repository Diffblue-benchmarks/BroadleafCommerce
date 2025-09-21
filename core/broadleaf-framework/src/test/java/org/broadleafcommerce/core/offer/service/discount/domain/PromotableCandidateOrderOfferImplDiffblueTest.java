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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

public class PromotableCandidateOrderOfferImplDiffblueTest {
  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    Money money = new Money();
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(money);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    assertEquals(potentialSavings, offer2.getOrderMinSubTotal());
    assertEquals(potentialSavings, offer2.getQualifyingItemSubTotal());
    assertEquals(potentialSavings, offer2.getTargetMinSubTotal());
    assertSame(money, potentialSavings);
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money(10.0d));

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money zeroResult = potentialSavings.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    assertEquals(new BigDecimal("2.30"), potentialSavings.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    Money money = Money.ZERO;
    assertEquals(money, offer2.getOrderMinSubTotal());
    assertEquals(money, offer2.getQualifyingItemSubTotal());
    assertEquals(money, offer2.getTargetMinSubTotal());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    OfferDiscountType discountType = new OfferDiscountType("Type", "Friendly Type");
    offer.setDiscountType(discountType);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    Currency currency = actualPromotableCandidateOrderOfferImpl.getPotentialSavings().getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(826, currency.getNumericCode());
    assertEquals(discountType, offer2.getDiscountType());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(money2);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.FIX_PRICE);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(money).greaterThan(isA(Money.class));
    verify(money2).subtract(isA(Money.class));
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("FIX_PRICE", discountType.getType());
    assertEquals("Fixed Price", discountType.getFriendlyType());
    Money orderMinSubTotal = offer2.getOrderMinSubTotal();
    BigDecimal amount = orderMinSubTotal.getAmount();
    assertEquals(new BigDecimal("0.00"), amount);
    assertSame(amount, orderMinSubTotal.abs().getAmount());
    Money qualifyingItemSubTotal = offer2.getQualifyingItemSubTotal();
    assertSame(amount, qualifyingItemSubTotal.abs().getAmount());
    Money targetMinSubTotal = offer2.getTargetMinSubTotal();
    assertSame(amount, targetMinSubTotal.abs().getAmount());
    assertSame(amount, orderMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.zero().getAmount());
    assertSame(amount, targetMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.getAmount());
    assertSame(amount, targetMinSubTotal.getAmount());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl5() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.multiply(Mockito.<BigDecimal>any())).thenReturn(money);

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(money2);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(money).greaterThan(isA(Money.class));
    verify(money2).multiply(isA(BigDecimal.class));
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("PERCENT_OFF", discountType.getType());
    assertEquals("Percent Off", discountType.getFriendlyType());
    Money orderMinSubTotal = offer2.getOrderMinSubTotal();
    BigDecimal amount = orderMinSubTotal.getAmount();
    assertEquals(new BigDecimal("0.00"), amount);
    assertSame(amount, orderMinSubTotal.abs().getAmount());
    Money qualifyingItemSubTotal = offer2.getQualifyingItemSubTotal();
    assertSame(amount, qualifyingItemSubTotal.abs().getAmount());
    Money targetMinSubTotal = offer2.getTargetMinSubTotal();
    assertSame(amount, targetMinSubTotal.abs().getAmount());
    assertSame(amount, orderMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.zero().getAmount());
    assertSame(amount, targetMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.getAmount());
    assertSame(amount, targetMinSubTotal.getAmount());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl6() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    assertSame(promotableOrder, actualPromotableCandidateOrderOfferImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl7() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), false);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order).getOrderItems();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(promotableOrder, actualPromotableCandidateOrderOfferImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl8() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    OfferDiscountType discountType = new OfferDiscountType("Type", "Friendly Type");
    offer.setDiscountType(discountType);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(discountType, offer2.getDiscountType());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl9() {
    // Arrange
    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.isIncludeOrderAndItemAdjustments()).thenReturn(true);
    when(promotableOrder.getOrderCurrency()).thenReturn(null);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.AMOUNT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(promotableOrder).isIncludeOrderAndItemAdjustments();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    assertSame(promotableOrder, actualPromotableCandidateOrderOfferImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType#FIX_PRICE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl_givenFix_price() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.FIX_PRICE);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    assertSame(promotableOrder, actualPromotableCandidateOrderOfferImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer, Money)"
  })
  public void testNewPromotableCandidateOrderOfferImpl_givenPercent_off() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    assertSame(promotableOrder, actualPromotableCandidateOrderOfferImpl.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <ul>
   *   <li>Then return Offer Value is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl_thenReturnOfferValueIsNull() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Money money = mock(Money.class);
    when(money.greaterThan(Mockito.<Money>any())).thenReturn(true);

    Money money2 = mock(Money.class);
    when(money2.subtract(Mockito.<Money>any())).thenReturn(money);

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(money2);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.FIX_PRICE);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(null);

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(money).greaterThan(isA(Money.class));
    verify(money2).subtract(isNull());
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("FIX_PRICE", discountType.getType());
    assertEquals("Fixed Price", discountType.getFriendlyType());
    assertNull(offer2.getValue());
    Money orderMinSubTotal = offer2.getOrderMinSubTotal();
    BigDecimal amount = orderMinSubTotal.getAmount();
    assertEquals(new BigDecimal("0.00"), amount);
    assertSame(amount, orderMinSubTotal.abs().getAmount());
    Money qualifyingItemSubTotal = offer2.getQualifyingItemSubTotal();
    assertSame(amount, qualifyingItemSubTotal.abs().getAmount());
    Money targetMinSubTotal = offer2.getTargetMinSubTotal();
    assertSame(amount, targetMinSubTotal.abs().getAmount());
    assertSame(amount, orderMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.zero().getAmount());
    assertSame(amount, targetMinSubTotal.zero().getAmount());
    assertSame(amount, qualifyingItemSubTotal.getAmount());
    assertSame(amount, targetMinSubTotal.getAmount());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}.
   *
   * <ul>
   *   <li>Then return PotentialSavings is {@link Money#Money()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void PromotableCandidateOrderOfferImpl.<init>(PromotableOrder, Offer)"})
  public void testNewPromotableCandidateOrderOfferImpl_thenReturnPotentialSavingsIsMoney() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    Money money = new Money();
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(money);

    OfferImpl offer = new OfferImpl();
    offer.setAdjustmentType(OfferAdjustmentType.FUTURE_CREDIT);
    offer.setApplyDiscountToSalePrice(true);
    offer.setApplyToChildItems(true);
    offer.setAutomaticallyAdded(true);
    offer.setCombinableWithOtherOffers(true);
    offer.setDescription("The characteristics of someone or something");
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);
    offer.setEndDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setId(OfferImpl.serialVersionUID);
    offer.setMarketingMessage("Marketing Message");
    offer.setMaxUsesPerCustomer(OfferImpl.serialVersionUID);
    offer.setMaxUsesPerOrder(3);
    offer.setMaxUsesStrategyType(CustomerMaxUsesStrategyType.ACCOUNT);
    offer.setMinimumDaysPerUsage(OfferImpl.serialVersionUID);
    offer.setName("Name");
    offer.setOfferCodes(new ArrayList<>());
    offer.setOfferItemQualifierRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferItemTargetRuleType(OfferItemRestrictionRuleType.NONE);
    offer.setOfferMatchRulesXref(new HashMap<>());
    offer.setOfferPriceData(new ArrayList<>());
    offer.setOrderMinSubTotal(new Money());
    offer.setPriority(1);
    offer.setQualifyingItemCriteriaXref(new HashSet<>());
    offer.setQualifyingItemSubTotal(new Money());
    offer.setRequiresRelatedTargetAndQualifiers(true);
    offer.setStartDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    offer.setTargetItemCriteriaXref(new HashSet<>());
    offer.setTargetMinSubTotal(new Money());
    offer.setTargetSystem("Target System");
    offer.setTotalitarianOffer(true);
    offer.setType(OfferType.FULFILLMENT_GROUP);
    offer.setUseListForDiscounts(true);
    offer.setValue(new BigDecimal("2.3"));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder).getOrderCurrency();
    assertTrue(actualPromotableCandidateOrderOfferImpl.getOffer() instanceof OfferImpl);
    assertEquals(money, actualPromotableCandidateOrderOfferImpl.getPotentialSavings());
  }
}
