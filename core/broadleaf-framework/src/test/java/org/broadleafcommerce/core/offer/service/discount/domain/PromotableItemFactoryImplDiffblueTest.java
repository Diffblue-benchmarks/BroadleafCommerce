package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
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
  @Autowired private PromotableItemFactoryImpl promotableItemFactoryImpl;

  @MockBean private PromotableOfferUtility promotableOfferUtility;

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   *
   * <ul>
   *   <li>Then OrderCurrency return {@link BroadleafCurrencyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"
  })
  public void testCreatePromotableOrder_thenOrderCurrencyReturnBroadleafCurrencyImpl() {
    // Arrange
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    PromotableOrder actualCreatePromotableOrderResult =
        promotableItemFactoryImpl.createPromotableOrder(order, true);

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
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return not IncludeOrderAndItemAdjustments.
   * </ul>
   *
   * <p>Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"
  })
  public void testCreatePromotableOrder_whenFalse_thenReturnNotIncludeOrderAndItemAdjustments() {
    // Arrange and Act
    PromotableOrder actualCreatePromotableOrderResult =
        promotableItemFactoryImpl.createPromotableOrder(new NullOrderImpl(), false);

    // Assert
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualCreatePromotableOrderResult.isIncludeOrderAndItemAdjustments());
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}.
   *
   * <ul>
   *   <li>When {@link NullOrderImpl} (default constructor).
   *   <li>Then Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link PromotableItemFactoryImpl#createPromotableOrder(Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrder PromotableItemFactoryImpl.createPromotableOrder(Order, boolean)"
  })
  public void testCreatePromotableOrder_whenNullOrderImpl_thenOrderReturnNullOrderImpl() {
    // Arrange and Act
    PromotableOrder actualCreatePromotableOrderResult =
        promotableItemFactoryImpl.createPromotableOrder(new NullOrderImpl(), true);

    // Assert
    assertTrue(actualCreatePromotableOrderResult instanceof PromotableOrderImpl);
    Order order = actualCreatePromotableOrderResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    Money orderAdjustmentsValue = order.getOrderAdjustmentsValue();
    Money actualAbsResult = orderAdjustmentsValue.abs();
    assertEquals(orderAdjustmentsValue, actualAbsResult);
    Money actualZeroResult = orderAdjustmentsValue.zero();
    assertEquals(orderAdjustmentsValue, actualZeroResult);
    assertEquals(orderAdjustmentsValue, order.getSubTotal());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer);

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    PromotableOrder promotableOrder2 =
        actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder();
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    assertNull(
        ((PromotableCandidateOrderOfferImpl) actualCreatePromotableCandidateOrderOfferResult)
            .getCurrency());
    assertNull(promotableOrder2.getOrderCurrency());
    assertEquals(
        orderMinSubTotal, actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("AMOUNT_OFF", discountType.getType());
    assertEquals("Amount Off", discountType.getFriendlyType());
    Money potentialSavings = actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("FIX_PRICE", discountType.getType());
    assertEquals("Fixed Price", discountType.getFriendlyType());
    Money potentialSavings = actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings();
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
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("PERCENT_OFF", discountType.getType());
    assertEquals("Percent Off", discountType.getFriendlyType());
    Money potentialSavings = actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer5() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    assertEquals(discountType, offer2.getDiscountType());
    Money potentialSavings = actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer6() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    Money money = mock(Money.class);
    when(money.multiply(anyInt())).thenReturn(new Money());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSalePrice()).thenReturn(money);
    when(bundleOrderItemImpl.getIsOnSale()).thenReturn(true);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer));
    verify(broadleafCurrency).getCurrencyCode();
    verify(money).multiply(1);
    verify(bundleOrderItemImpl).getSalePrice();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getIsOnSale();
    verify(bundleOrderItemImpl).getOrderItemPriceDetails();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer)} with {@code promotableOrder}, {@code offer}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOffer7() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(mock(BundleOrderItemImpl.class));

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());

    PromotableOrderItemImpl promotableOrderItemImpl = mock(PromotableOrderItemImpl.class);
    when(promotableOrderItemImpl.calculateTotalWithoutAdjustments()).thenReturn(new Money());

    PromotableItemFactory itemFactory = mock(PromotableItemFactory.class);
    when(itemFactory.createPromotableOrderItem(
            Mockito.<OrderItem>any(), Mockito.<PromotableOrder>any(), anyBoolean()))
        .thenReturn(promotableOrderItemImpl);

    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order, itemFactory, true);

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            promotableItemFactoryImpl.createPromotableCandidateOrderOffer(promotableOrder, offer));
    verify(broadleafCurrency).getCurrencyCode();
    verify(itemFactory)
        .createPromotableOrderItem(isA(OrderItem.class), isA(PromotableOrder.class), eq(true));
    verify(promotableOrderItemImpl).calculateTotalWithoutAdjustments();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, new Money());

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    PromotableOrder promotableOrder2 =
        actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder();
    assertTrue(promotableOrder2 instanceof PromotableOrderImpl);
    OfferDiscountType discountType = offer2.getDiscountType();
    assertEquals("AMOUNT_OFF", discountType.getType());
    assertEquals("Amount Off", discountType.getFriendlyType());
    assertNull(
        ((PromotableCandidateOrderOfferImpl) actualCreatePromotableCandidateOrderOfferResult)
            .getCurrency());
    assertNull(promotableOrder2.getOrderCurrency());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings2() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    Money potentialSavings = new Money();

    // Act
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, potentialSavings);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableCandidateOrderOfferResult.getOffer() instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    assertSame(
        potentialSavings, actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings());
    assertSame(
        promotableOrder, actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings3() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(promotableOfferUtility), false);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableCandidateOrderOfferResult.getOffer() instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    Money potentialSavings = actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    assertSame(
        promotableOrder, actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings4() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    Money potentialSavings = new Money();

    // Act
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, potentialSavings);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableCandidateOrderOfferResult.getOffer() instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    assertSame(
        potentialSavings, actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings());
    assertSame(
        promotableOrder, actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings5() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    Money potentialSavings = new Money();

    // Act
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, potentialSavings);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(actualCreatePromotableCandidateOrderOfferResult.getOffer() instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    assertSame(
        potentialSavings, actualCreatePromotableCandidateOrderOfferResult.getPotentialSavings());
    assertSame(
        promotableOrder, actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings6() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);

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
    PromotableCandidateOrderOffer actualCreatePromotableCandidateOrderOfferResult =
        promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
            promotableOrder, offer, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Offer offer2 = actualCreatePromotableCandidateOrderOfferResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult
            instanceof PromotableCandidateOrderOfferImpl);
    assertTrue(
        actualCreatePromotableCandidateOrderOfferResult.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(discountType, offer2.getDiscountType());
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings7() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    Money money = mock(Money.class);
    when(money.multiply(anyInt())).thenReturn(new Money());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSalePrice()).thenReturn(money);
    when(bundleOrderItemImpl.getIsOnSale()).thenReturn(true);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
                promotableOrder, offer, new Money()));
    verify(broadleafCurrency).getCurrencyCode();
    verify(money).multiply(1);
    verify(bundleOrderItemImpl).getSalePrice();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(bundleOrderItemImpl).getIsOnSale();
    verify(bundleOrderItemImpl).getOrderItemPriceDetails();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder,
   * Offer, Money)} with {@code promotableOrder}, {@code offer}, {@code potentialSavings}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableCandidateOrderOffer PromotableItemFactoryImpl.createPromotableCandidateOrderOffer(PromotableOrder, Offer, Money)"
  })
  public void testCreatePromotableCandidateOrderOfferWithPromotableOrderOfferPotentialSavings8() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(mock(BundleOrderItemImpl.class));

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    doNothing().when(order).addOrderItem(Mockito.<OrderItem>any());
    order.addOrderItem(new BundleOrderItemImpl());

    PromotableOrderItemImpl promotableOrderItemImpl = mock(PromotableOrderItemImpl.class);
    when(promotableOrderItemImpl.calculateTotalWithoutAdjustments()).thenReturn(new Money());

    PromotableItemFactory itemFactory = mock(PromotableItemFactory.class);
    when(itemFactory.createPromotableOrderItem(
            Mockito.<OrderItem>any(), Mockito.<PromotableOrder>any(), anyBoolean()))
        .thenReturn(promotableOrderItemImpl);

    PromotableOrderImpl promotableOrder = new PromotableOrderImpl(order, itemFactory, true);

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

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            promotableItemFactoryImpl.createPromotableCandidateOrderOffer(
                promotableOrder, offer, new Money()));
    verify(broadleafCurrency).getCurrencyCode();
    verify(itemFactory)
        .createPromotableOrderItem(isA(OrderItem.class), isA(PromotableOrder.class), eq(true));
    verify(promotableOrderItemImpl).calculateTotalWithoutAdjustments();
    verify(order).addOrderItem(isA(OrderItem.class));
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(null);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isFutureCredit()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer, atLeast(1)).getValue();
    verify(offer).isFutureCredit();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    assertTrue(
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult)
                .promotableCandidateOrderOffer
            instanceof PromotableCandidateOrderOfferImpl);
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder2() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(null);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    PromotableOrderImpl promotableOrder = mock(PromotableOrderImpl.class);
    when(promotableOrder.getOrderCurrency()).thenReturn(broadleafCurrency);
    when(promotableOrder.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    OfferImpl offer = mock(OfferImpl.class);
    when(offer.isFutureCredit()).thenReturn(true);
    when(offer.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offer.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        new PromotableCandidateOrderOfferImpl(promotableOrder, offer);

    BroadleafCurrency broadleafCurrency2 = mock(BroadleafCurrency.class);
    when(broadleafCurrency2.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency2);
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(broadleafCurrency2, atLeast(1)).getCurrencyCode();
    verify(offer, atLeast(1)).getDiscountType();
    verify(offer, atLeast(1)).getValue();
    verify(offer).isFutureCredit();
    verify(promotableOrder).calculateSubtotalWithoutAdjustments();
    verify(promotableOrder, atLeast(1)).getOrderCurrency();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    PromotableCandidateOrderOffer promotableCandidateOrderOffer2 =
        ((PromotableOrderAdjustmentImpl) actualCreatePromotableOrderAdjustmentResult)
            .promotableCandidateOrderOffer;
    assertTrue(promotableCandidateOrderOffer2 instanceof PromotableCandidateOrderOfferImpl);
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult.getPromotableOrder()
            instanceof PromotableOrderImpl);
    Money potentialSavings = promotableCandidateOrderOffer2.getPotentialSavings();
    Money actualAbsResult = potentialSavings.abs();
    assertEquals(potentialSavings, actualAbsResult);
    Money actualZeroResult = potentialSavings.zero();
    assertEquals(potentialSavings, actualZeroResult);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Money actualAbsResult2 = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult2);
    Money actualZeroResult2 = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult2);
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder3() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(null);

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOffer promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult.getPromotableOrder()
            instanceof PromotableOrderImpl);
    assertEquals(orderAdjustmentList, order2.allOrderItems);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)} with {@code promotableCandidateOrderOffer}, {@code order}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder)"
  })
  public void testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrder4() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl = new PromotableItemFactoryImpl(null);

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOffer promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOffer.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateOrderAdjustmentTotal()).thenReturn(new Money());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order);

    // Assert
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order).calculateOrderAdjustmentTotal();
    verify(order).calculateSubtotalWithAdjustments();
    verify(order, atLeast(1)).getOrderCurrency();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(order, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue2() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(promotableOfferUtility), false);

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, new Money());

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    Money adjustmentValue = actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue();
    Currency currency = adjustmentValue.getCurrency();
    assertEquals("British Pound Sterling", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.getSymbol());
    assertEquals("GBP", currency.toString());
    assertEquals(826, currency.getNumericCode());
    Money actualAbsResult = adjustmentValue.abs();
    assertEquals(adjustmentValue, actualAbsResult);
    Money actualZeroResult = adjustmentValue.zero();
    assertEquals(adjustmentValue, actualZeroResult);
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue3() {
    // Arrange
    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(new BigDecimal("-2.3"));
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.AMOUNT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(promotableOfferUtility), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue4() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.FIX_PRICE);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue5() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    InternalNumber internalNumber = mock(InternalNumber.class);
    when(internalNumber.divide(Mockito.<BigDecimal>any(), anyInt(), Mockito.<RoundingMode>any()))
        .thenReturn(new BigDecimal("2.3"));

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.getValue()).thenReturn(internalNumber);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(OfferDiscountType.PERCENT_OFF);

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(internalNumber).divide(isA(BigDecimal.class), eq(5), eq(RoundingMode.HALF_EVEN));
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).getValue();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue6() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(new OfferDiscountType());

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }

  /**
   * Test {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)} with {@code promotableCandidateOrderOffer}, {@code order}, {@code
   * adjustmentValue}.
   *
   * <p>Method under test: {@link
   * PromotableItemFactoryImpl#createPromotableOrderAdjustment(PromotableCandidateOrderOffer,
   * PromotableOrder, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PromotableOrderAdjustment PromotableItemFactoryImpl.createPromotableOrderAdjustment(PromotableCandidateOrderOffer, PromotableOrder, Money)"
  })
  public void
      testCreatePromotableOrderAdjustmentWithPromotableCandidateOrderOfferOrderAdjustmentValue7() {
    // Arrange
    PromotableItemFactoryImpl promotableItemFactoryImpl =
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl());

    OfferImpl offerImpl = mock(OfferImpl.class);
    when(offerImpl.isFutureCredit()).thenReturn(true);
    when(offerImpl.getDiscountType()).thenReturn(mock(OfferDiscountType.class));

    PromotableCandidateOrderOfferImpl promotableCandidateOrderOffer =
        mock(PromotableCandidateOrderOfferImpl.class);
    when(promotableCandidateOrderOffer.getOffer()).thenReturn(offerImpl);

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    Money adjustmentValue = new Money();

    // Act
    PromotableOrderAdjustment actualCreatePromotableOrderAdjustmentResult =
        promotableItemFactoryImpl.createPromotableOrderAdjustment(
            promotableCandidateOrderOffer, order2, adjustmentValue);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(offerImpl, atLeast(1)).getDiscountType();
    verify(offerImpl).isFutureCredit();
    verify(promotableCandidateOrderOffer).getOffer();
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertTrue(
        actualCreatePromotableOrderAdjustmentResult instanceof PromotableOrderAdjustmentImpl);
    assertSame(adjustmentValue, actualCreatePromotableOrderAdjustmentResult.getAdjustmentValue());
    assertSame(order2, actualCreatePromotableOrderAdjustmentResult.getPromotableOrder());
  }
}
