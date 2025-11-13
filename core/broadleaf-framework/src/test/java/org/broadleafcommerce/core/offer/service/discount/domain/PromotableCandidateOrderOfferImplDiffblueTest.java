package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import org.mvel2.util.InternalNumber;

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

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
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
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("AMOUNT_OFF", discountType.getType());
    assertEquals("Amount Off", discountType.getFriendlyType());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
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

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
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
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("FIX_PRICE", discountType.getType());
    assertEquals("Fixed Price", discountType.getFriendlyType());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    assertEquals(new BigDecimal("-2.30"), potentialSavings.getAmount());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = potentialSavings.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    Money absResult = potentialSavings.abs();
    assertEquals(expectedAmount2, absResult.getAmount());
    assertEquals(absResult.abs(), absResult.abs());
    Money zeroResult2 = zeroResult.zero();
    assertEquals(zeroResult2, absResult.zero());
    assertEquals(zeroResult2, zeroResult2);
    Money actualAbsResult = zeroResult.abs();
    assertEquals(zeroResult, actualAbsResult);
    assertSame(amount, offer2.getOrderMinSubTotal().getAmount());
    assertSame(amount, offer2.getQualifyingItemSubTotal().getAmount());
    assertSame(amount, offer2.getTargetMinSubTotal().getAmount());
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

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
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
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("PERCENT_OFF", discountType.getType());
    assertEquals("Percent Off", discountType.getFriendlyType());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
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

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
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
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals(discountType, offer2.getDiscountType());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
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
  public void testNewPromotableCandidateOrderOfferImpl5() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
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
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualPromotableCandidateOrderOfferImpl.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("AMOUNT_OFF", discountType.getType());
    assertEquals("Amount Off", discountType.getFriendlyType());
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
  public void testNewPromotableCandidateOrderOfferImpl7() {
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
  public void testNewPromotableCandidateOrderOfferImpl8() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(offer).getDiscountType();
    verify(offer).getValue();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(0, actualPromotableCandidateOrderOfferImpl.getPriority());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(offer, actualPromotableCandidateOrderOfferImpl.getOffer());
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
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getDiscountType()).thenReturn(new OfferDiscountType());

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(offer, atLeast(1)).getDiscountType();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(0, actualPromotableCandidateOrderOfferImpl.getPriority());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(offer, actualPromotableCandidateOrderOfferImpl.getOffer());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType}.
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
  public void testNewPromotableCandidateOrderOfferImpl_givenOfferDiscountType() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getDiscountType()).thenReturn(mock(OfferDiscountType.class));

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(offer, atLeast(1)).getDiscountType();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(0, actualPromotableCandidateOrderOfferImpl.getPriority());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(offer, actualPromotableCandidateOrderOfferImpl.getOffer());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Then calls {@link InternalNumber#divide(BigDecimal)}.
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
  public void testNewPromotableCandidateOrderOfferImpl_thenCallsDivide() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any())).thenReturn(new BigDecimal("2.3"));

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class));
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer).getValue();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(0, actualPromotableCandidateOrderOfferImpl.getPriority());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(offer, actualPromotableCandidateOrderOfferImpl.getOffer());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Then calls {@link InternalNumber#setScale(int, int)}.
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
  public void testNewPromotableCandidateOrderOfferImpl_thenCallsSetScale() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.setScale(anyInt(), anyInt())).thenReturn(new BigDecimal("2.3"));

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.getValue()).thenReturn(internalNumber);
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    // Act
    PromotableCandidateOrderOfferImpl actualPromotableCandidateOrderOfferImpl =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer, new Money());

    // Assert
    verify(internalNumber).setScale(2, 6);
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer).getValue();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(0, actualPromotableCandidateOrderOfferImpl.getPriority());
    Money potentialSavings = actualPromotableCandidateOrderOfferImpl.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(offer, actualPromotableCandidateOrderOfferImpl.getOffer());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>Then return PotentialSavings is {@link Money#Money()}.
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
  public void testNewPromotableCandidateOrderOfferImpl_thenReturnPotentialSavingsIsMoney() {
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
    Money orderMinSubTotal = new Money();
    offer.setOrderMinSubTotal(orderMinSubTotal);
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
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(orderMinSubTotal, actualPromotableCandidateOrderOfferImpl.getPotentialSavings());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor) DiscountType is {@link
   *       OfferDiscountType#FIX_PRICE}.
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
  public void testNewPromotableCandidateOrderOfferImpl_whenOfferImplDiscountTypeIsFix_price() {
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
    Money orderMinSubTotal = new Money();
    offer.setOrderMinSubTotal(orderMinSubTotal);
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
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(orderMinSubTotal, actualPromotableCandidateOrderOfferImpl.getPotentialSavings());
  }

  /**
   * Test {@link
   * PromotableCandidateOrderOfferImpl#PromotableCandidateOrderOfferImpl(PromotableOrder, Offer,
   * Money)}.
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor) DiscountType is {@link
   *       OfferDiscountType#PERCENT_OFF}.
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
  public void testNewPromotableCandidateOrderOfferImpl_whenOfferImplDiscountTypeIsPercent_off() {
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
    Money orderMinSubTotal = new Money();
    offer.setOrderMinSubTotal(orderMinSubTotal);
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
    assertTrue(
        actualPromotableCandidateOrderOfferImpl.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(orderMinSubTotal, actualPromotableCandidateOrderOfferImpl.getPotentialSavings());
  }
}
