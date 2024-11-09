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
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableCandidateItemOffer;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableItemFactoryImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtility;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOfferUtilityImpl;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrder;
import org.broadleafcommerce.core.offer.service.discount.domain.PromotableOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class ItemOfferProcessorImplDiffblueTest {
  /**
   * Test
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#isTotalitarianOfferAppliedToAnyItem(PromotableOrder)}
   */
  @Test
  public void testIsTotalitarianOfferAppliedToAnyItem_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

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
    assertFalse(itemOfferProcessorImpl.isTotalitarianOfferAppliedToAnyItem(
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)));
  }

  /**
   * Test
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}.
   * <ul>
   *   <li>Then calls
   * {@link PromotableCandidateItemOffer#getCandidateFixedTargetsMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#applyItemQualifiersAndTargets(PromotableCandidateItemOffer, PromotableOrder)}
   */
  @Test
  public void testApplyItemQualifiersAndTargets_thenCallsGetCandidateFixedTargetsMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
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
        new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true));

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
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
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
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with
   * {@code 100.0}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenBigDecimalWith23_thenReturnBigDecimalWith1000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
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
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}.
   * <ul>
   *   <li>When {@link Money#Money(double)} with amount is ten.</li>
   *   <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_whenMoneyWithAmountIsTen_thenReturnBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
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
   * Method under test:
   * {@link ItemOfferProcessorImpl#calculatePercent(Money, Money)}
   */
  @Test
  public void testCalculatePercent_whenMoney_thenReturnBigDecimalWith0() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());
    Money itemSubTotal = new Money();

    // Act
    BigDecimal actualCalculatePercentResult = itemOfferProcessorImpl.calculatePercent(itemSubTotal, new Money());

    // Assert
    assertEquals(new BigDecimal("0"), actualCalculatePercentResult);
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  public void testUseCalculatePercent_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#useCalculatePercent(Offer)}
   */
  @Test
  public void testUseCalculatePercent_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertTrue(itemOfferProcessorImpl.useCalculatePercent(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  public void testIsPercentOffOffer_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#isPercentOffOffer(Offer)}
   */
  @Test
  public void testIsPercentOffOffer_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.isPercentOffOffer(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>Given
   * {@link ItemOfferProcessorImpl#ItemOfferProcessorImpl(PromotableOfferUtility)}
   * with {@link PromotableOfferUtility}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  public void testUsePercentOffValue_givenItemOfferProcessorImplWithPromotableOfferUtility() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(mock(PromotableOfferUtility.class));

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }

  /**
   * Test {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ItemOfferProcessorImpl#usePercentOffValue(Offer)}
   */
  @Test
  public void testUsePercentOffValue_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ItemOfferProcessorImpl itemOfferProcessorImpl = new ItemOfferProcessorImpl(new PromotableOfferUtilityImpl());

    // Act and Assert
    assertFalse(itemOfferProcessorImpl.usePercentOffValue(new OfferImpl()));
  }
}
