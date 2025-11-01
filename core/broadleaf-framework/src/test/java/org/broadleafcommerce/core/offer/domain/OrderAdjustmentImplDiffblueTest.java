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
package org.broadleafcommerce.core.offer.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class OrderAdjustmentImplDiffblueTest {
  /**
   * Method under test: {@link OrderAdjustmentImpl#init(Order, Offer, String)}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    Order order = mock(Order.class);
    OfferImpl offer = new OfferImpl();

    // Act
    orderAdjustmentImpl.init(order, offer, "Just cause");

    // Assert
    Offer offer2 = orderAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    Money value = orderAdjustmentImpl.getValue();
    Currency currency = value.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("Just cause", orderAdjustmentImpl.getReason());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(orderAdjustmentImpl.getCurrencyCode());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(2147483646, offer2.getPriority());
    assertEquals(840, currency.getNumericCode());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertFalse(orderAdjustmentImpl.isFutureCredit);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertEquals(value, value.abs());
    assertEquals(value, value.zero());
    assertSame(offer, orderAdjustmentImpl.getOffer());
    assertSame(offer, orderAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
    BigDecimal expectedAmount = orderAdjustmentImpl.value;
    assertSame(expectedAmount, value.getAmount());
    assertSame(order, orderAdjustmentImpl.getOrder());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#init(Order, Offer, String)}
   */
  @Test
  public void testInit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl.init(new NullOrderImpl(), null, "Just cause");

    // Assert
    assertNull(orderAdjustmentImpl.deproxiedOffer);
    assertNull(orderAdjustmentImpl.offer);
    assertFalse(orderAdjustmentImpl.isFutureCredit);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderAdjustmentImpl()).getOffer());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setOrder(mock(NullOrderImpl.class));

    // Act and Assert
    assertNull(orderAdjustmentImpl.getOffer());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    OfferImpl offer = new OfferImpl();

    // Act
    orderAdjustmentImpl.setOffer(offer);

    // Assert
    Offer offer2 = orderAdjustmentImpl.offer;
    assertTrue(offer2 instanceof OfferImpl);
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(((OfferImpl) offer2).maxUsesPerOrder);
    assertNull(((OfferImpl) offer2).priority);
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(((OfferImpl) offer2).maxUsesPerCustomer);
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(((OfferImpl) offer2).adjustmentType);
    assertNull(((OfferImpl) offer2).discountType);
    assertNull(((OfferImpl) offer2).marketingMessage);
    assertNull(((OfferImpl) offer2).maxUsesStrategy);
    assertNull(((OfferImpl) offer2).offerItemQualifierRuleType);
    assertNull(((OfferImpl) offer2).offerItemTargetRuleType);
    assertNull(((OfferImpl) offer2).type);
    assertNull(offer2.getValue());
    assertNull(((OfferImpl) offer2).orderMinSubTotal);
    assertNull(((OfferImpl) offer2).qualifyingItemSubTotal);
    assertNull(((OfferImpl) offer2).targetMinSubTotal);
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
    assertNull(((OfferImpl) offer2).startDate);
    assertNull(offer2.getOrderMinSubTotal());
    assertNull(offer2.getQualifyingItemSubTotal());
    assertNull(offer2.getTargetMinSubTotal());
    assertNull(offer2.getMaxUsesStrategyType());
    assertNull(offer2.getDiscountType());
    assertNull(offer2.getType());
    assertEquals(0, offer2.getMaxUsesPerOrder());
    assertEquals(0L, offer2.getMaxUsesPerCustomer().longValue());
    assertEquals(2147483646, offer2.getPriority());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertFalse(((OfferImpl) offer2).applyToChildItems);
    assertFalse(((OfferImpl) offer2).automaticallyAdded);
    assertFalse(((OfferImpl) offer2).requiresRelatedTargetAndQualifiers);
    assertFalse(((OfferImpl) offer2).totalitarianOffer);
    assertFalse(((OfferImpl) offer2).useListForDiscounts);
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertTrue(((OfferImpl) offer2).applyToSalePrice);
    assertTrue(((OfferImpl) offer2).combinableWithOtherOffers);
    assertSame(offer, orderAdjustmentImpl.getOffer());
    assertSame(offer, orderAdjustmentImpl.deproxiedOffer);
    assertSame(offer.archiveStatus, ((OfferImpl) offer2).archiveStatus);
    assertSame(offer.legacyQualifyingItemCriteria, ((OfferImpl) offer2).legacyQualifyingItemCriteria);
    assertSame(offer.legacyTargetItemCriteria, ((OfferImpl) offer2).legacyTargetItemCriteria);
    Set<OfferTargetCriteriaXref> offerTargetCriteriaXrefSet = offer.targetItemCriteria;
    assertSame(offerTargetCriteriaXrefSet, offer2.getTargetItemCriteriaXref());
    assertSame(offerTargetCriteriaXrefSet, ((OfferImpl) offer2).targetItemCriteria);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    OfferImpl offer = mock(OfferImpl.class);

    // Act
    orderAdjustmentImpl.setOffer(offer);

    // Assert
    assertSame(offer, orderAdjustmentImpl.getOffer());
    assertSame(offer, orderAdjustmentImpl.deproxiedOffer);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    Money value = new Money();
    orderAdjustmentImpl.setValue(value);
    orderAdjustmentImpl.setOrder(order);

    // Act and Assert
    assertEquals(value, orderAdjustmentImpl.getValue());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
    order.setLocale(new LocaleImpl());
    order.setName("Name");
    order.setOrderAttributes(new HashMap<>());
    order.setOrderItems(new ArrayList<>());
    order.setOrderMessages(new ArrayList<>());
    order.setOrderNumber("42");
    order.setPayments(new ArrayList<>());
    order.setStatus(OrderStatus.ARCHIVED);
    Money subTotal = new Money();
    order.setSubTotal(subTotal);
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);
    orderAdjustmentImpl.setOrder(order);

    // Act
    Money actualValue = orderAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    Currency currency = actualValue.getCurrency();
    assertEquals("$", currency.getSymbol());
    assertEquals("US Dollar", currency.getDisplayName());
    assertEquals("USD", currency.getCurrencyCode());
    assertEquals("USD", currency.toString());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(840, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("2.30");
    assertEquals(expectedAmount, actualValue.getAmount());
    assertEquals(subTotal, actualValue.zero());
    assertEquals(actualValue, actualValue.abs());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);
    orderAdjustmentImpl.setOrder(order);

    // Act
    Money actualValue = orderAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    assertNull(actualValue);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(currency);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);
    orderAdjustmentImpl.setOrder(order);

    // Act
    Money actualValue = orderAdjustmentImpl.getValue();

    // Assert
    verify(currency).getCurrencyCode();
    verify(value).getAmount();
    Currency currency2 = actualValue.getCurrency();
    assertEquals("British Pound", currency2.getDisplayName());
    assertEquals("GBP", currency2.getCurrencyCode());
    assertEquals("GBP", currency2.toString());
    assertEquals("£", currency2.getSymbol());
    assertEquals(2, currency2.getDefaultFractionDigits());
    assertEquals(826, currency2.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualValue.zero();
    assertEquals(expectedAmount, zeroResult.getAmount());
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualValue.getAmount());
    assertEquals(zeroResult.zero(), zeroResult.zero());
    assertEquals(zeroResult, zeroResult.abs());
    assertEquals(actualValue, actualValue.abs());
    assertSame(currency2, zeroResult.getCurrency());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), orderAdjustmentImpl.value);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    // Act
    orderAdjustmentImpl.setValue(value);

    // Assert
    verify(value).getAmount();
    assertEquals(new BigDecimal("2.3"), orderAdjustmentImpl.value);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    orderAdjustmentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(new BroadleafCurrencyImpl());

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    orderAdjustmentImpl.setOrder(order);

    // Act and Assert
    assertNull(orderAdjustmentImpl.getCurrencyCode());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(new BigDecimal("2.3"));

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(OrderAdjustmentImpl.serialVersionUID);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(OrderAdjustmentImpl.serialVersionUID);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(OrderAdjustmentImpl.serialVersionUID);
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
    order.setCurrency(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);
    orderAdjustmentImpl.setOrder(order);

    // Act
    String actualCurrencyCode = orderAdjustmentImpl.getCurrencyCode();

    // Assert
    verify(value).getAmount();
    assertNull(actualCurrencyCode);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderAdjustmentImpl()).isFutureCredit());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    orderAdjustmentImpl.setFutureCredit(null);

    // Act and Assert
    assertFalse(orderAdjustmentImpl.isFutureCredit());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    orderAdjustmentImpl.setFutureCredit(true);

    // Act and Assert
    assertTrue(orderAdjustmentImpl.isFutureCredit());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(mock(NullOrderImpl.class));
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());
    orderAdjustmentImpl.setFutureCredit(null);

    // Act and Assert
    assertFalse(orderAdjustmentImpl.isFutureCredit());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int notExpectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(mock(Order.class));
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int notExpectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertNotEquals(notExpectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
    int expectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAdjustmentImpl2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#equals(Object)}
   *   <li>{@link OrderAdjustmentImpl#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertEquals(orderAdjustmentImpl, orderAdjustmentImpl);
    int expectedHashCodeResult = orderAdjustmentImpl.hashCode();
    assertEquals(expectedHashCodeResult, orderAdjustmentImpl.hashCode());
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(2L);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(null);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(new NullOrderImpl());
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(false);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Reason");
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason(null);
    orderAdjustmentImpl.setValue(new Money());

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money(10.0d));

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Money value = mock(Money.class);
    when(value.getAmount()).thenReturn(null);

    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(null);
    orderAdjustmentImpl.setOrder(null);
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(value);

    OrderAdjustmentImpl orderAdjustmentImpl2 = new OrderAdjustmentImpl();
    orderAdjustmentImpl2.setFutureCredit(true);
    orderAdjustmentImpl2.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl2.setOrder(null);
    orderAdjustmentImpl2.setReason("Just cause");
    orderAdjustmentImpl2.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, orderAdjustmentImpl2);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, null);
  }

  /**
   * Method under test: {@link OrderAdjustmentImpl#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    orderAdjustmentImpl.setOrder(new NullOrderImpl());
    orderAdjustmentImpl.setReason("Just cause");
    orderAdjustmentImpl.setValue(new Money());

    // Act and Assert
    assertNotEquals(orderAdjustmentImpl, "Different type to OrderAdjustmentImpl");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderAdjustmentImpl#setFutureCredit(Boolean)}
   *   <li>{@link OrderAdjustmentImpl#setId(Long)}
   *   <li>{@link OrderAdjustmentImpl#setOrder(Order)}
   *   <li>{@link OrderAdjustmentImpl#setReason(String)}
   *   <li>{@link OrderAdjustmentImpl#getId()}
   *   <li>{@link OrderAdjustmentImpl#getOrder()}
   *   <li>{@link OrderAdjustmentImpl#getReason()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl.setFutureCredit(true);
    orderAdjustmentImpl.setId(OrderAdjustmentImpl.serialVersionUID);
    NullOrderImpl order = new NullOrderImpl();
    orderAdjustmentImpl.setOrder(order);
    orderAdjustmentImpl.setReason("Just cause");
    Long actualId = orderAdjustmentImpl.getId();
    Order actualOrder = orderAdjustmentImpl.getOrder();

    // Assert that nothing has changed
    assertEquals("Just cause", orderAdjustmentImpl.getReason());
    assertEquals(OrderAdjustmentImpl.serialVersionUID, actualId.longValue());
    assertSame(order, actualOrder);
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link OrderAdjustmentImpl}
   */
  @Test
  public void testNewOrderAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    OrderAdjustmentImpl actualOrderAdjustmentImpl = new OrderAdjustmentImpl();

    // Assert
    assertNull(actualOrderAdjustmentImpl.getId());
    assertNull(actualOrderAdjustmentImpl.getReason());
    assertNull(actualOrderAdjustmentImpl.getOffer());
    assertNull(actualOrderAdjustmentImpl.deproxiedOffer);
    assertNull(actualOrderAdjustmentImpl.offer);
    assertNull(actualOrderAdjustmentImpl.getOrder());
    assertFalse(actualOrderAdjustmentImpl.isFutureCredit);
    assertEquals(new BigDecimal("0.00"), actualOrderAdjustmentImpl.value);
  }
}
