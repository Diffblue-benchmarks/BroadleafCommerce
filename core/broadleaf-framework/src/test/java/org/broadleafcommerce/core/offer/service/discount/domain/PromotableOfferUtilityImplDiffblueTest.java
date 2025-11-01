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
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.Offer;
import org.broadleafcommerce.core.offer.domain.OfferImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PromotableOfferUtilityImplDiffblueTest {
  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getRetailPrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeRetailAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail)}
   */
  @Test
  public void testComputeRetailAdjustmentValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("ThreadLocalManager.notify.orphans");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getRetailPrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    promotableOfferUtilityImpl.computeRetailAdjustmentValue(promotableCandidateItemOffer,
        new PromotableOrderItemPriceDetailWrapper(
            new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)));

    // Assert
    verify(currency).getCurrencyCode();
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getRetailPrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getSalePrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#computeAdjustmentValue(PromotableCandidateItemOffer, PromotableOrderItemPriceDetail, boolean)}
   */
  @Test
  public void testComputeAdjustmentValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    PromotableCandidateItemOffer promotableCandidateItemOffer = mock(PromotableCandidateItemOffer.class);
    when(promotableCandidateItemOffer.calculateTargetQuantityForTieredOffer()).thenReturn(1);
    when(promotableCandidateItemOffer.getOffer()).thenReturn(new OfferImpl());
    Money money = mock(Money.class);
    when(money.lessThan(Mockito.<Money>any())).thenReturn(true);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(currency);
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("currency.default");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(new ArrayList<>());
    orderImpl.setOrderMessages(new ArrayList<>());
    orderImpl.setOrderNumber("42");
    orderImpl.setPayments(new ArrayList<>());
    orderImpl.setStatus(OrderStatus.ARCHIVED);
    orderImpl.setSubTotal(new Money());
    orderImpl.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalShipping(new Money());
    orderImpl.setTotalTax(new Money());
    BundleOrderItemImpl orderItem = mock(BundleOrderItemImpl.class);
    when(orderItem.getOrderItemPriceDetails()).thenReturn(new ArrayList<>());
    when(orderItem.getSalePrice()).thenReturn(money);
    when(orderItem.getOrder()).thenReturn(orderImpl);

    // Act
    promotableOfferUtilityImpl
        .computeAdjustmentValue(promotableCandidateItemOffer,
            new PromotableOrderItemPriceDetailWrapper(
                new PromotableOrderItemPriceDetailImpl(new PromotableOrderItemImpl(orderItem, null, null, true), 1)),
            true);

    // Assert
    verify(currency).getCurrencyCode();
    verify(money).lessThan(isA(Money.class));
    verify(promotableCandidateItemOffer, atLeast(1)).calculateTargetQuantityForTieredOffer();
    verify(promotableCandidateItemOffer).getOffer();
    verify(orderItem).getSalePrice();
    verify(orderItem).getOrder();
    verify(orderItem).getOrderItemPriceDetails();
  }

  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}
   */
  @Test
  public void testDetermineOfferUnitValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();

    // Act and Assert
    assertNull(promotableOfferUtilityImpl.determineOfferUnitValue(new OfferImpl(), 1));
  }

  /**
   * Method under test:
   * {@link PromotableOfferUtilityImpl#determineOfferUnitValue(Offer, Integer)}
   */
  @Test
  public void testDetermineOfferUnitValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PromotableOfferUtilityImpl promotableOfferUtilityImpl = new PromotableOfferUtilityImpl();
    Offer offer = mock(Offer.class);
    BigDecimal bigDecimal = new BigDecimal("2.3");
    when(offer.getValue()).thenReturn(bigDecimal);

    // Act
    BigDecimal actualDetermineOfferUnitValueResult = promotableOfferUtilityImpl.determineOfferUnitValue(offer, 1);

    // Assert
    verify(offer).getValue();
    assertEquals(new BigDecimal("2.3"), actualDetermineOfferUnitValueResult);
    assertSame(bigDecimal, actualDetermineOfferUnitValueResult);
  }
}
