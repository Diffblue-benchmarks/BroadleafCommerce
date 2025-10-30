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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXref;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXrefImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateOrderOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
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

@RunWith(MockitoJUnitRunner.class)
public class ItemOfferProcessorImplDiffblueTest {
  @InjectMocks
  private ItemOfferProcessorImpl itemOfferProcessorImpl;

  @Mock
  private PromotableItemFactory promotableItemFactory;

  /**
   * Test {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(PromotableOrder)"})
  public void testIsTotalitarianOfferAppliedToAnyItem_thenReturnFalse() {
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
    assertFalse(itemOfferProcessorImpl
        .isTotalitarianOfferAppliedToAnyItem(new PromotableOrderImpl(order, promotableItemFactory, true)));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}.
   * <ul>
   *   <li>Then calls {@link PromotableCandidateItemOffer#getCandidateFixedTargetsMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void ItemOfferProcessorImpl.applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)"})
  public void testApplyItemQualifiersAndTargets_thenCallsGetCandidateFixedTargetsMap() {
    // Arrange
    PromotableCandidateItemOffer itemOffer = mock(PromotableCandidateItemOffer.class);
    when(itemOffer.getCandidateFixedTargetsMap()).thenReturn(new HashMap<>());
    when(itemOffer.getCandidateQualifiersMap()).thenReturn(new HashMap<>());
    when(itemOffer.getCandidateTargetsMap()).thenReturn(new HashMap<>());
    when(itemOffer.getOffer()).thenReturn(new OfferImpl());

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

    // Act
    itemOfferProcessorImpl.applyItemQualifiersAndTargets(itemOffer,
        new PromotableOrderImpl(order, promotableItemFactory, true));

    // Assert
    verify(itemOffer).getCandidateFixedTargetsMap();
    verify(itemOffer).getCandidateQualifiersMap();
    verify(itemOffer).getCandidateTargetsMap();
    verify(itemOffer, atLeast(1)).getOffer();
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith000() {
    // Arrange
    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    verify(itemSubTotal).getAmount();
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 100.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith1000() {
    // Arrange
    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));
    Money itemSavings = mock(Money.class);
    when(itemSavings.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, itemSavings);

    // Assert
    verify(itemSubTotal).getAmount();
    verify(itemSavings).getAmount();
    assertEquals(new BigDecimal("100.0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenMoneyWithAmountIsTen_thenReturnBigDecimalWith000() {
    // Arrange
    Money itemSubTotal = new Money(10.0d);

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenMoney_thenReturnBigDecimalWith0() {
    // Arrange
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.useCalculatePercent(Offer)"})
  public void testUseCalculatePercent_givenHashSetAddOfferQualifyingCriteriaXrefImpl() {
    // Arrange
    HashSet<OfferQualifyingCriteriaXref> qualifyingItemCriteriaXref = new HashSet<>();
    qualifyingItemCriteriaXref.add(new OfferQualifyingCriteriaXrefImpl());

    OfferImpl offer = new OfferImpl();
    offer.setQualifyingItemCriteriaXref(qualifyingItemCriteriaXref);

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.useCalculatePercent(offer));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.</li>
   *   <li>When {@link OfferImpl} (default constructor) DiscountType is {@link OfferDiscountType#PERCENT_OFF}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.useCalculatePercent(Offer)"})
  public void testUseCalculatePercent_givenPercent_off_whenOfferImplDiscountTypeIsPercent_off() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.useCalculatePercent(offer));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.useCalculatePercent(Offer)"})
  public void testUseCalculatePercent_whenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.isPercentOffOffer(Offer)"})
  public void testIsPercentOffOffer_givenPercent_off_thenReturnTrue() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.isPercentOffOffer(offer));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.isPercentOffOffer(Offer)"})
  public void testIsPercentOffOffer_whenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.usePercentOffValue(Offer)"})
  public void testUsePercentOffValue_givenPercent_off_thenReturnTrue() {
    // Arrange
    OfferImpl offer = new OfferImpl();
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.usePercentOffValue(offer));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.usePercentOffValue(Offer)"})
  public void testUsePercentOffValue_whenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}.
   * <ul>
   *   <li>Then calls {@link PromotableOrderImpl#getAllOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ItemOfferProcessorImpl.applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)"})
  public void testApplyAndCompareOrderAndItemOffers_thenCallsGetAllOrderItems() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    PromotableOrderImpl order = mock(PromotableOrderImpl.class);
    when(order.getAllOrderItems()).thenReturn(new ArrayList<>());
    when(order.getAllPromotableOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    doNothing().when(order).setOrderSubTotalToPriceWithAdjustments();
    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl.applyAndCompareOrderAndItemOffers(order, qualifiedOrderOffers, new ArrayList<>());

    // Assert
    verify(order).getAllOrderItems();
    verify(order).getAllPromotableOrderItemPriceDetails();
    verify(order, atLeast(1)).setOrderSubTotalToPriceWithAdjustments();
  }

  /**
   * Test {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}.
   * <ul>
   *   <li>Then calls {@link NullOrderImpl#getCurrency()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ItemOfferProcessorImpl.applyAndCompareOrderAndItemOffers(PromotableOrder, List, List)"})
  public void testApplyAndCompareOrderAndItemOffers_thenCallsGetCurrency() {
    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(null);
    doNothing().when(order).setSubTotal(Mockito.<Money>any());
    PromotableOrderImpl order2 = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    ArrayList<PromotableCandidateOrderOffer> qualifiedOrderOffers = new ArrayList<>();

    // Act
    itemOfferProcessorImpl.applyAndCompareOrderAndItemOffers(order2, qualifiedOrderOffers, new ArrayList<>());

    // Assert
    verify(order, atLeast(1)).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    verify(order, atLeast(1)).setSubTotal(isA(Money.class));
  }
}
