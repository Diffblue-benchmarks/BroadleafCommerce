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
import static org.junit.Assert.assertNull;
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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXref;
import org.broadleafcommerce.core.offer.domain.OfferOfferRuleXrefImpl;
import org.broadleafcommerce.core.offer.service.discount.FulfillmentGroupOfferPotential;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateFulfillmentGroupOfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroup;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableFulfillmentGroupImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.type.CustomerMaxUsesStrategyType;
import org.broadleafcommerce.core.offer.service.type.OfferAdjustmentType;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.offer.service.type.OfferItemRestrictionRuleType;
import org.broadleafcommerce.core.offer.service.type.OfferType;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
public class FulfillmentGroupOfferProcessorImplDiffblueTest {
  @InjectMocks private FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl;

  @Mock private PromotableItemFactory promotableItemFactory;

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)"
  })
  public void testFilterFulfillmentGroupLevelOffer() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setPromotableItemFactory(
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    ArrayList<PromotableFulfillmentGroup> promotableFulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    promotableFulfillmentGroupList.add(promotableFulfillmentGroupImpl);

    PromotableOrder order2 = mock(PromotableOrder.class);
    when(order2.getFulfillmentGroups()).thenReturn(promotableFulfillmentGroupList);
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

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
    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offer.setOfferMatchRulesXref(offerMatchRulesXref);
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
    fulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(
        order2, qualifiedFGOffers, offer);

    // Assert
    verify(order2).getFulfillmentGroups();
    assertEquals(1, qualifiedFGOffers.size());
    PromotableCandidateFulfillmentGroupOffer getResult = qualifiedFGOffers.get(0);
    Offer offer2 = getResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(getResult instanceof PromotableCandidateFulfillmentGroupOfferImpl);
    assertTrue(offer2.getOfferMatchRulesXref().isEmpty());
    assertEquals(offerMatchRulesXref, getResult.getCandidateQualifiersMap());
    assertEquals(orderMinSubTotal, offer2.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)"
  })
  public void testFilterFulfillmentGroupLevelOffer2() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setPromotableItemFactory(
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    ArrayList<PromotableFulfillmentGroup> promotableFulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    promotableFulfillmentGroupList.add(promotableFulfillmentGroupImpl);

    PromotableOrder order2 = mock(PromotableOrder.class);
    when(order2.getFulfillmentGroups()).thenReturn(promotableFulfillmentGroupList);
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

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
    offer.setQualifyingItemSubTotal(null);
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
    fulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(
        order2, qualifiedFGOffers, offer);

    // Assert
    verify(order2).getFulfillmentGroups();
    assertEquals(1, qualifiedFGOffers.size());
    PromotableCandidateFulfillmentGroupOffer getResult = qualifiedFGOffers.get(0);
    Offer offer2 = getResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(getResult instanceof PromotableCandidateFulfillmentGroupOfferImpl);
    assertNull(offer2.getQualifyingItemSubTotal());
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)"
  })
  public void testFilterFulfillmentGroupLevelOffer3() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    fulfillmentGroupOfferProcessorImpl.setPromotableItemFactory(
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));

    ArrayList<PromotableFulfillmentGroup> promotableFulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    promotableFulfillmentGroupList.add(promotableFulfillmentGroupImpl);

    PromotableOrder order2 = mock(PromotableOrder.class);
    when(order2.getFulfillmentGroups()).thenReturn(promotableFulfillmentGroupList);
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("FULFILLMENT_GROUP", new OfferOfferRuleXrefImpl());

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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);
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
    fulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(
        order2, qualifiedFGOffers, offer);

    // Assert
    verify(order2).getFulfillmentGroups();
    assertEquals(1, qualifiedFGOffers.size());
    PromotableCandidateFulfillmentGroupOffer getResult = qualifiedFGOffers.get(0);
    Offer offer2 = getResult.getOffer();
    assertTrue(offer2 instanceof OfferImpl);
    assertTrue(getResult instanceof PromotableCandidateFulfillmentGroupOfferImpl);
    assertSame(offerMatchRulesXref, offer2.getOfferMatchRulesXref());
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)"
  })
  public void testFilterFulfillmentGroupLevelOffer4() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    ArrayList<PromotableFulfillmentGroup> promotableFulfillmentGroupList = new ArrayList<>();
    FulfillmentGroupImpl fulfillmentGroup = new FulfillmentGroupImpl();
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrder =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    PromotableFulfillmentGroupImpl promotableFulfillmentGroupImpl =
        new PromotableFulfillmentGroupImpl(
            fulfillmentGroup,
            promotableOrder,
            new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()));
    promotableFulfillmentGroupList.add(promotableFulfillmentGroupImpl);

    PromotableOrder order2 = mock(PromotableOrder.class);
    when(order2.getFulfillmentGroups()).thenReturn(promotableFulfillmentGroupList);
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

    OfferOfferRuleXrefImpl offerOfferRuleXrefImpl = new OfferOfferRuleXrefImpl();
    offerOfferRuleXrefImpl.setMatchRule("FULFILLMENT_GROUP");

    HashMap<String, OfferOfferRuleXref> offerMatchRulesXref = new HashMap<>();
    offerMatchRulesXref.put("FULFILLMENT_GROUP", offerOfferRuleXrefImpl);

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
    offer.setOfferMatchRulesXref(offerMatchRulesXref);
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
    fulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(
        order2, qualifiedFGOffers, offer);

    // Assert that nothing has changed
    verify(order2).getFulfillmentGroups();
    assertTrue(qualifiedFGOffers.isEmpty());
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}.
   *
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#filterFulfillmentGroupLevelOffer(PromotableOrder, List,
   * Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(PromotableOrder, List, Offer)"
  })
  public void testFilterFulfillmentGroupLevelOffer_thenArrayListEmpty() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

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
    ArrayList<PromotableCandidateFulfillmentGroupOffer> qualifiedFGOffers = new ArrayList<>();

    // Act
    fulfillmentGroupOfferProcessorImpl.filterFulfillmentGroupLevelOffer(
        order2, qualifiedFGOffers, new OfferImpl());

    // Assert that nothing has changed
    assertTrue(qualifiedFGOffers.isEmpty());
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal() {
    // Arrange
    PromotableOrderImpl order =
        new PromotableOrderImpl(new OrderImpl(), promotableItemFactory, true);

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(order);

    // Assert
    assertTrue(order.getOrder() instanceof OrderImpl);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal_thenCallsGetCurrencyCode() {
    // Arrange
    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(broadleafCurrency).getCurrencyCode();
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}.
   *
   * <ul>
   *   <li>When {@link Order} {@link Order#getCurrency()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#calculateFulfillmentGroupTotal(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void FulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(PromotableOrder)"
  })
  public void testCalculateFulfillmentGroupTotal_whenOrderGetCurrencyReturnNull() {
    // Arrange
    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setTotalFulfillmentCharges(Mockito.<Money>any());

    // Act
    fulfillmentGroupOfferProcessorImpl.calculateFulfillmentGroupTotal(
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(order).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).setTotalFulfillmentCharges(isA(Money.class));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order2, true));
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers2() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    PromotableOrder order = mock(PromotableOrder.class);
    doNothing().when(order).removeAllCandidateFulfillmentOfferAdjustments();
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.calculateSubtotalWithAdjustments()).thenReturn(new Money());
    when(order.getOrderCurrency()).thenReturn(null);
    when(order.calculateSubtotalWithoutAdjustments()).thenReturn(new Money());

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult =
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order, true);

    // Assert
    verify(order).calculateSubtotalWithAdjustments();
    verify(order).calculateSubtotalWithoutAdjustments();
    verify(order, atLeast(1)).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderCurrency();
    verify(order).removeAllCandidateFulfillmentOfferAdjustments();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#compareAndAdjustFulfillmentGroupOffers(PromotableOrder,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean FulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(PromotableOrder, boolean)"
  })
  public void testCompareAndAdjustFulfillmentGroupOffers_thenCallsGetCurrencyCode() {
    // Arrange
    FulfillmentGroupOfferProcessorImpl fulfillmentGroupOfferProcessorImpl =
        new FulfillmentGroupOfferProcessorImpl(new PromotableOfferUtilityImpl());

    BroadleafCurrency broadleafCurrency = mock(BroadleafCurrency.class);
    when(broadleafCurrency.getCurrencyCode()).thenReturn("GBP");

    Order order = mock(Order.class);
    when(order.getFulfillmentGroups()).thenReturn(new ArrayList<>());
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrency);
    PromotableOrderImpl order2 =
        new PromotableOrderImpl(
            order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    boolean actualCompareAndAdjustFulfillmentGroupOffersResult =
        fulfillmentGroupOfferProcessorImpl.compareAndAdjustFulfillmentGroupOffers(order2, true);

    // Assert
    verify(broadleafCurrency, atLeast(1)).getCurrencyCode();
    verify(order, atLeast(1)).getCurrency();
    verify(order).getFulfillmentGroups();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertFalse(actualCompareAndAdjustFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(List)"
  })
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnArrayList() {
    // Arrange
    FulfillmentGroupOfferPotential fulfillmentGroupOfferPotential =
        new FulfillmentGroupOfferPotential();
    fulfillmentGroupOfferPotential.setOffer(new OfferImpl());
    fulfillmentGroupOfferPotential.setPriority(1);
    fulfillmentGroupOfferPotential.setTotalSavings(new Money());

    ArrayList<FulfillmentGroupOfferPotential> candidateOffers = new ArrayList<>();
    candidateOffers.add(fulfillmentGroupOfferPotential);

    // Act
    List<FulfillmentGroupOfferPotential>
        actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult =
            fulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(
                candidateOffers);

    // Assert
    assertEquals(candidateOffers, actualRemoveTrailingNotCombinableFulfillmentGroupOffersResult);
  }

  /**
   * Test {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * FulfillmentGroupOfferProcessorImpl#removeTrailingNotCombinableFulfillmentGroupOffers(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List FulfillmentGroupOfferProcessorImpl.removeTrailingNotCombinableFulfillmentGroupOffers(List)"
  })
  public void testRemoveTrailingNotCombinableFulfillmentGroupOffers_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        fulfillmentGroupOfferProcessorImpl
            .removeTrailingNotCombinableFulfillmentGroupOffers(new ArrayList<>())
            .isEmpty());
  }
}
