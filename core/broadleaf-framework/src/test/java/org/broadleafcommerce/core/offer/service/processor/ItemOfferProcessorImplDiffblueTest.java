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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXref;
import org.broadleafcommerce.core.offer.domain.OfferQualifyingCriteriaXrefImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactory;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetail;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderItemPriceDetailWrapper;
import org.broadleafcommerce.core.offer.service.type.OfferDiscountType;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemOfferProcessorImplDiffblueTest {
  @InjectMocks private ItemOfferProcessorImpl itemOfferProcessorImpl;

  @Mock private PromotableItemFactory promotableItemFactory;

  /**
   * Test {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   *
   * <p>Method under test: {@link
   * ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ItemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(PromotableOrder)"
  })
  public void testIsTotalitarianOfferAppliedToAnyItem() {
    // Arrange
    ArrayList<PromotableOrderItemPriceDetail> promotableOrderItemPriceDetailList =
        new ArrayList<>();
    PromotableOrderItemImpl promotableOrderItem =
        new PromotableOrderItemImpl(new BundleOrderItemImpl(), null, null, true);
    promotableOrderItemPriceDetailList.add(
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(promotableOrderItem, 1)));

    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getAllPromotableOrderItemPriceDetails())
        .thenReturn(promotableOrderItemPriceDetailList);

    // Act
    boolean actualIsTotalitarianOfferAppliedToAnyItemResult =
        itemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(order);

    // Assert
    verify(order).getAllPromotableOrderItemPriceDetails();
    assertFalse(actualIsTotalitarianOfferAppliedToAnyItemResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ItemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(PromotableOrder)"
  })
  public void testIsTotalitarianOfferAppliedToAnyItem_givenAuditableCreatedByIsOne() {
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

    // Act and Assert
    assertFalse(
        itemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(
            new PromotableOrderImpl(order, promotableItemFactory, true)));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ItemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(PromotableOrder)"
  })
  public void testIsTotalitarianOfferAppliedToAnyItem_thenReturnTrue() {
    // Arrange
    PromotableOrderItemPriceDetailImpl wrappedDetail =
        mock(PromotableOrderItemPriceDetailImpl.class);
    when(wrappedDetail.isTotalitarianOfferApplied()).thenReturn(true);
    PromotableOrderItemPriceDetailWrapper promotableOrderItemPriceDetailWrapper =
        new PromotableOrderItemPriceDetailWrapper(wrappedDetail);

    ArrayList<PromotableOrderItemPriceDetail> promotableOrderItemPriceDetailList =
        new ArrayList<>();
    promotableOrderItemPriceDetailList.add(promotableOrderItemPriceDetailWrapper);

    PromotableOrder order = mock(PromotableOrder.class);
    when(order.getAllPromotableOrderItemPriceDetails())
        .thenReturn(promotableOrderItemPriceDetailList);

    // Act
    boolean actualIsTotalitarianOfferAppliedToAnyItemResult =
        itemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(order);

    // Assert
    verify(order).getAllPromotableOrderItemPriceDetails();
    verify(wrappedDetail).isTotalitarianOfferApplied();
    assertTrue(actualIsTotalitarianOfferAppliedToAnyItemResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith000() {
    // Arrange
    Money itemSubTotal = mock(Money.class);
    when(itemSubTotal.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    verify(itemSubTotal).getAmount();
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>Given {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 20.0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith200() {
    // Arrange
    Money itemSubTotal = new Money(10.0d);

    Money itemSavings = mock(Money.class);
    when(itemSavings.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, itemSavings);

    // Assert
    verify(itemSavings).getAmount();
    assertEquals(new BigDecimal("20.0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenMoneyWithAmountIsTen_thenReturnBigDecimalWith000() {
    // Arrange
    Money itemSubTotal = new Money(10.0d);

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#Money()}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenMoney_thenReturnBigDecimalWith0() {
    // Arrange
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   *
   * <ul>
   *   <li>When {@link Money#ZERO}.
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"BigDecimal ItemOfferProcessorImpl.calculatePercent(Money, Money)"})
  public void testCalculatePercent_whenZero_thenReturnBigDecimalWith0() {
    // Arrange and Act
    BigDecimal actualCalculatePercentResult =
        itemOfferProcessorImpl.calculatePercent(Money.ZERO, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link
   *       OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.
   *   <li>When {@link OfferImpl} (default constructor) DiscountType is {@link
   *       OfferDiscountType#PERCENT_OFF}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.useCalculatePercent(Offer)"})
  public void testUseCalculatePercent_whenOfferImpl_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.isPercentOffOffer(Offer)"})
  public void testIsPercentOffOffer_whenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link
   *       OfferQualifyingCriteriaXrefImpl#OfferQualifyingCriteriaXrefImpl()}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.usePercentOffValue(Offer)"})
  public void testUsePercentOffValue_givenHashSetAddOfferQualifyingCriteriaXrefImpl() {
    // Arrange
    HashSet<OfferQualifyingCriteriaXref> qualifyingItemCriteriaXref = new HashSet<>();
    qualifyingItemCriteriaXref.add(new OfferQualifyingCriteriaXrefImpl());

    OfferImpl offer = new OfferImpl();
    offer.setQualifyingItemCriteriaXref(qualifyingItemCriteriaXref);
    offer.setDiscountType(OfferDiscountType.PERCENT_OFF);

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(offer));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   *
   * <ul>
   *   <li>Given {@link OfferDiscountType#PERCENT_OFF}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   *
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ItemOfferProcessorImpl.usePercentOffValue(Offer)"})
  public void testUsePercentOffValue_whenOfferImpl_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }
}
