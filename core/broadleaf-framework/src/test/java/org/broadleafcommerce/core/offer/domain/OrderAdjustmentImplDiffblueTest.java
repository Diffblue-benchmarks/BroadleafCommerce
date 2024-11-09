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
   * Test {@link OrderAdjustmentImpl#init(Order, Offer, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor)
   * {@link OrderAdjustmentImpl#deproxiedOffer} is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#init(Order, Offer, String)}
   */
  @Test
  public void testInit_whenNull_thenOrderAdjustmentImplDeproxiedOfferIsNull() {
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
   * Test {@link OrderAdjustmentImpl#init(Order, Offer, String)}.
   * <ul>
   *   <li>When {@link Order}.</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor) Value Currency
   * DisplayName is {@code British Pound}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#init(Order, Offer, String)}
   */
  @Test
  public void testInit_whenOrder_thenOrderAdjustmentImplValueCurrencyDisplayNameIsBritishPound() {
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
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("Just cause", orderAdjustmentImpl.getReason());
    assertEquals("£", currency.getSymbol());
    assertEquals('N', offer2.getArchived().charValue());
    assertNull(offer2.getId());
    assertNull(offer2.getMinimumDaysPerUsage());
    assertNull(offer2.getDescription());
    assertNull(offer2.getMarketingMessage());
    assertNull(offer2.getName());
    assertNull(offer2.getTargetSystem());
    assertNull(((OfferImpl) offer2).getMainEntityName());
    assertNull(orderAdjustmentImpl.getCurrencyCode());
    assertNull(offer2.getValue());
    assertNull(offer2.getEndDate());
    assertNull(offer2.getStartDate());
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
    assertEquals(826, currency.getNumericCode());
    assertFalse(offer2.getApplyToChildItems());
    assertFalse(offer2.getRequiresRelatedTargetAndQualifiers());
    assertFalse(offer2.getUseListForDiscounts());
    assertFalse(offer2.isFutureCredit());
    assertFalse(offer2.isLimitedUsePerOrder());
    assertTrue(offer2.getApplyDiscountToSalePrice());
    assertTrue(offer2.isUnlimitedUsePerOrder());
    assertTrue(((OfferImpl) offer2).getCombinableWithOtherOffers());
    assertEquals(value, value.abs());
    assertEquals(value, value.zero());
    assertSame(offer, orderAdjustmentImpl.getOffer());
    Set<OfferTargetCriteriaXref> expectedTargetItemCriteriaXref = offer.targetItemCriteria;
    assertSame(expectedTargetItemCriteriaXref, offer2.getTargetItemCriteriaXref());
    BigDecimal expectedAmount = orderAdjustmentImpl.value;
    assertSame(expectedAmount, value.getAmount());
    assertSame(order, orderAdjustmentImpl.getOrder());
  }

  /**
   * Test getters and setters.
   * <p>
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
   * Test {@link OrderAdjustmentImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderAdjustmentImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new OrderAdjustmentImpl()).getOffer());
  }

  /**
   * Test {@link OrderAdjustmentImpl#getOffer()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) Order is
   * {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getOffer()}
   */
  @Test
  public void testGetOffer_givenOrderAdjustmentImplOrderIsNullOrderImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();
    orderAdjustmentImpl.setOrder(mock(NullOrderImpl.class));

    // Act and Assert
    assertNull(orderAdjustmentImpl.getOffer());
  }

  /**
   * Test {@link OrderAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl}.</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor) Offer is
   * {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderAdjustmentImplOfferIsOfferImpl() {
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
   * Test {@link OrderAdjustmentImpl#setOffer(Offer)}.
   * <ul>
   *   <li>When {@link OfferImpl} (default constructor).</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor)
   * {@link OrderAdjustmentImpl#offer} {@link OfferImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setOffer(Offer)}
   */
  @Test
  public void testSetOffer_whenOfferImpl_thenOrderAdjustmentImplOfferOfferImpl() {
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
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenMoneyGetAmountReturnNull_thenReturnNull() {
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
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) Value is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_givenOrderAdjustmentImplValueIsMoney_thenReturnMoney() {
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
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Then calls {@link BroadleafCurrency#getCurrencyCode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_thenCallsGetCurrencyCode() {
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
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualValue.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualValue.getAmount());
    assertEquals(actualValue, actualValue.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    assertSame(amount2, absResult5.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult6 = zeroResult6.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    assertSame(amount2, absResult8.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult9 = zeroResult7.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    assertSame(amount2, absResult12.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult13 = zeroResult9.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult10 = absResult6.zero();
    Money absResult14 = zeroResult10.abs();
    assertSame(amount2, absResult14.abs().getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult15 = zeroResult11.abs();
    assertSame(amount2, absResult15.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult16 = zeroResult12.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    Money zeroResult13 = absResult4.zero();
    assertSame(amount2, zeroResult13.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    Money zeroResult14 = absResult7.zero();
    assertSame(amount2, zeroResult14.abs().getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult15 = absResult9.zero();
    assertSame(amount2, zeroResult15.abs().getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult16 = absResult11.zero();
    assertSame(amount2, zeroResult16.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    assertSame(amount2, zeroResult17.abs().getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult18 = zeroResult10.zero();
    assertSame(amount2, zeroResult18.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    assertSame(amount2, zeroResult19.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    assertSame(amount2, zeroResult20.abs().getAmount());
    assertSame(amount2, absResult.getAmount());
    assertSame(amount2, absResult5.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult8.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult12.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, absResult14.zero().getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult15.zero().getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult13.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult14.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult15.zero().getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult16.zero().getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult17.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult18.zero().getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult19.zero().getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult20.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult17 = zeroResult4.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount4, absResult18.abs().getAmount());
    assertSame(amount4, absResult18.getAmount());
    assertSame(amount4, absResult17.getAmount());
    assertSame(amount4, absResult18.zero().getAmount());
    assertSame(amount4, absResult17.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult19 = zeroResult3.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    assertSame(amount5, absResult21.abs().getAmount());
    assertSame(amount5, absResult21.getAmount());
    Money zeroResult21 = absResult19.zero();
    Money absResult22 = zeroResult21.abs();
    assertSame(amount5, absResult22.abs().getAmount());
    assertSame(amount5, absResult20.getAmount());
    Money zeroResult22 = absResult20.zero();
    assertSame(amount5, zeroResult22.abs().getAmount());
    assertSame(amount5, absResult22.getAmount());
    Money zeroResult23 = zeroResult21.zero();
    assertSame(amount5, zeroResult23.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    assertSame(amount5, absResult21.zero().getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult22.zero().getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, zeroResult22.zero().getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult23.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult23 = zeroResult2.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult24 = absResult23.zero();
    Money absResult27 = zeroResult24.abs();
    Money absResult28 = absResult27.abs();
    assertSame(amount, absResult28.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = absResult24.zero();
    Money absResult29 = zeroResult25.abs();
    assertSame(amount, absResult29.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    Money zeroResult26 = zeroResult24.zero();
    Money absResult30 = zeroResult26.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult27 = absResult25.zero();
    assertSame(amount, zeroResult27.abs().getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult28 = absResult27.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult29 = zeroResult25.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    Money zeroResult30 = zeroResult26.zero();
    assertSame(amount, zeroResult30.abs().getAmount());
    assertSame(amount, absResult23.getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, absResult29.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult27.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult30.zero().getAmount());
  }

  /**
   * Test {@link OrderAdjustmentImpl#getValue()}.
   * <ul>
   *   <li>Then return zero Amount is {@link BigDecimal#BigDecimal(String)} with
   * {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getValue()}
   */
  @Test
  public void testGetValue_thenReturnZeroAmountIsBigDecimalWith000() {
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
    Money actualValue = orderAdjustmentImpl.getValue();

    // Assert
    verify(value).getAmount();
    BigDecimal expectedAmount = new BigDecimal("0.00");
    Money zeroResult = actualValue.zero();
    BigDecimal amount = zeroResult.getAmount();
    assertEquals(expectedAmount, amount);
    BigDecimal expectedAmount2 = new BigDecimal("2.30");
    assertEquals(expectedAmount2, actualValue.getAmount());
    assertEquals(actualValue, actualValue.abs());
    Money zeroResult2 = zeroResult.zero();
    Money zeroResult3 = zeroResult2.zero();
    Money zeroResult4 = zeroResult3.zero();
    Money zeroResult5 = zeroResult4.zero();
    BigDecimal amount2 = zeroResult5.zero().getAmount();
    Money absResult = zeroResult.abs();
    Money absResult2 = absResult.abs();
    Money absResult3 = absResult2.abs();
    Money absResult4 = absResult3.abs();
    Money absResult5 = absResult4.abs();
    assertSame(amount2, absResult5.abs().getAmount());
    assertSame(amount2, absResult5.getAmount());
    Money zeroResult6 = absResult.zero();
    Money absResult6 = zeroResult6.abs();
    Money absResult7 = absResult6.abs();
    Money absResult8 = absResult7.abs();
    assertSame(amount2, absResult8.abs().getAmount());
    assertSame(amount2, absResult4.getAmount());
    Money zeroResult7 = absResult2.zero();
    Money absResult9 = zeroResult7.abs();
    Money absResult10 = absResult9.abs();
    assertSame(amount2, absResult10.abs().getAmount());
    assertSame(amount2, absResult8.getAmount());
    Money zeroResult8 = zeroResult6.zero();
    Money absResult11 = zeroResult8.abs();
    Money absResult12 = absResult11.abs();
    assertSame(amount2, absResult12.abs().getAmount());
    assertSame(amount2, absResult3.getAmount());
    Money zeroResult9 = absResult3.zero();
    Money absResult13 = zeroResult9.abs();
    assertSame(amount2, absResult13.abs().getAmount());
    assertSame(amount2, absResult10.getAmount());
    Money zeroResult10 = absResult6.zero();
    Money absResult14 = zeroResult10.abs();
    assertSame(amount2, absResult14.abs().getAmount());
    assertSame(amount2, absResult7.getAmount());
    Money zeroResult11 = zeroResult7.zero();
    Money absResult15 = zeroResult11.abs();
    assertSame(amount2, absResult15.abs().getAmount());
    assertSame(amount2, absResult12.getAmount());
    Money zeroResult12 = zeroResult8.zero();
    Money absResult16 = zeroResult12.abs();
    assertSame(amount2, absResult16.abs().getAmount());
    assertSame(amount2, absResult2.getAmount());
    Money zeroResult13 = absResult4.zero();
    assertSame(amount2, zeroResult13.abs().getAmount());
    assertSame(amount2, absResult13.getAmount());
    Money zeroResult14 = absResult7.zero();
    assertSame(amount2, zeroResult14.abs().getAmount());
    assertSame(amount2, absResult9.getAmount());
    Money zeroResult15 = absResult9.zero();
    assertSame(amount2, zeroResult15.abs().getAmount());
    assertSame(amount2, absResult14.getAmount());
    Money zeroResult16 = absResult11.zero();
    assertSame(amount2, zeroResult16.abs().getAmount());
    assertSame(amount2, absResult6.getAmount());
    Money zeroResult17 = zeroResult9.zero();
    assertSame(amount2, zeroResult17.abs().getAmount());
    assertSame(amount2, absResult15.getAmount());
    Money zeroResult18 = zeroResult10.zero();
    assertSame(amount2, zeroResult18.abs().getAmount());
    assertSame(amount2, absResult11.getAmount());
    Money zeroResult19 = zeroResult11.zero();
    assertSame(amount2, zeroResult19.abs().getAmount());
    assertSame(amount2, absResult16.getAmount());
    Money zeroResult20 = zeroResult12.zero();
    assertSame(amount2, zeroResult20.abs().getAmount());
    assertSame(amount2, absResult.getAmount());
    assertSame(amount2, absResult5.zero().getAmount());
    assertSame(amount2, zeroResult13.getAmount());
    assertSame(amount2, absResult8.zero().getAmount());
    assertSame(amount2, zeroResult9.getAmount());
    assertSame(amount2, absResult10.zero().getAmount());
    assertSame(amount2, zeroResult14.getAmount());
    assertSame(amount2, absResult12.zero().getAmount());
    assertSame(amount2, zeroResult7.getAmount());
    assertSame(amount2, absResult13.zero().getAmount());
    assertSame(amount2, zeroResult15.getAmount());
    assertSame(amount2, absResult14.zero().getAmount());
    assertSame(amount2, zeroResult10.getAmount());
    assertSame(amount2, absResult15.zero().getAmount());
    assertSame(amount2, zeroResult16.getAmount());
    assertSame(amount2, absResult16.zero().getAmount());
    assertSame(amount2, zeroResult6.getAmount());
    assertSame(amount2, zeroResult13.zero().getAmount());
    assertSame(amount2, zeroResult17.getAmount());
    assertSame(amount2, zeroResult14.zero().getAmount());
    assertSame(amount2, zeroResult11.getAmount());
    assertSame(amount2, zeroResult15.zero().getAmount());
    assertSame(amount2, zeroResult18.getAmount());
    assertSame(amount2, zeroResult16.zero().getAmount());
    assertSame(amount2, zeroResult8.getAmount());
    assertSame(amount2, zeroResult17.zero().getAmount());
    assertSame(amount2, zeroResult19.getAmount());
    assertSame(amount2, zeroResult18.zero().getAmount());
    assertSame(amount2, zeroResult12.getAmount());
    assertSame(amount2, zeroResult19.zero().getAmount());
    assertSame(amount2, zeroResult20.getAmount());
    assertSame(amount2, zeroResult20.zero().getAmount());
    assertSame(amount2, amount2);
    assertSame(zeroResult5.getAmount(), zeroResult5.getAmount());
    BigDecimal amount3 = zeroResult4.getAmount();
    assertSame(amount3, zeroResult5.abs().getAmount());
    assertSame(amount3, amount3);
    BigDecimal amount4 = zeroResult3.getAmount();
    Money absResult17 = zeroResult4.abs();
    Money absResult18 = absResult17.abs();
    assertSame(amount4, absResult18.abs().getAmount());
    assertSame(amount4, absResult18.getAmount());
    assertSame(amount4, absResult17.getAmount());
    assertSame(amount4, absResult18.zero().getAmount());
    assertSame(amount4, absResult17.zero().getAmount());
    assertSame(amount4, amount4);
    BigDecimal amount5 = zeroResult2.getAmount();
    Money absResult19 = zeroResult3.abs();
    Money absResult20 = absResult19.abs();
    Money absResult21 = absResult20.abs();
    assertSame(amount5, absResult21.abs().getAmount());
    assertSame(amount5, absResult21.getAmount());
    Money zeroResult21 = absResult19.zero();
    Money absResult22 = zeroResult21.abs();
    assertSame(amount5, absResult22.abs().getAmount());
    assertSame(amount5, absResult20.getAmount());
    Money zeroResult22 = absResult20.zero();
    assertSame(amount5, zeroResult22.abs().getAmount());
    assertSame(amount5, absResult22.getAmount());
    Money zeroResult23 = zeroResult21.zero();
    assertSame(amount5, zeroResult23.abs().getAmount());
    assertSame(amount5, absResult19.getAmount());
    assertSame(amount5, absResult21.zero().getAmount());
    assertSame(amount5, zeroResult22.getAmount());
    assertSame(amount5, absResult22.zero().getAmount());
    assertSame(amount5, zeroResult21.getAmount());
    assertSame(amount5, zeroResult22.zero().getAmount());
    assertSame(amount5, zeroResult23.getAmount());
    assertSame(amount5, zeroResult23.zero().getAmount());
    assertSame(amount5, amount5);
    Money absResult23 = zeroResult2.abs();
    Money absResult24 = absResult23.abs();
    Money absResult25 = absResult24.abs();
    Money absResult26 = absResult25.abs();
    assertSame(amount, absResult26.abs().getAmount());
    assertSame(amount, absResult26.getAmount());
    Money zeroResult24 = absResult23.zero();
    Money absResult27 = zeroResult24.abs();
    Money absResult28 = absResult27.abs();
    assertSame(amount, absResult28.abs().getAmount());
    assertSame(amount, absResult25.getAmount());
    Money zeroResult25 = absResult24.zero();
    Money absResult29 = zeroResult25.abs();
    assertSame(amount, absResult29.abs().getAmount());
    assertSame(amount, absResult28.getAmount());
    Money zeroResult26 = zeroResult24.zero();
    Money absResult30 = zeroResult26.abs();
    assertSame(amount, absResult30.abs().getAmount());
    assertSame(amount, absResult24.getAmount());
    Money zeroResult27 = absResult25.zero();
    assertSame(amount, zeroResult27.abs().getAmount());
    assertSame(amount, absResult29.getAmount());
    Money zeroResult28 = absResult27.zero();
    assertSame(amount, zeroResult28.abs().getAmount());
    assertSame(amount, absResult27.getAmount());
    Money zeroResult29 = zeroResult25.zero();
    assertSame(amount, zeroResult29.abs().getAmount());
    assertSame(amount, absResult30.getAmount());
    Money zeroResult30 = zeroResult26.zero();
    assertSame(amount, zeroResult30.abs().getAmount());
    assertSame(amount, absResult23.getAmount());
    assertSame(amount, absResult26.zero().getAmount());
    assertSame(amount, zeroResult27.getAmount());
    assertSame(amount, absResult28.zero().getAmount());
    assertSame(amount, zeroResult25.getAmount());
    assertSame(amount, absResult29.zero().getAmount());
    assertSame(amount, zeroResult28.getAmount());
    assertSame(amount, absResult30.zero().getAmount());
    assertSame(amount, zeroResult24.getAmount());
    assertSame(amount, zeroResult27.zero().getAmount());
    assertSame(amount, zeroResult29.getAmount());
    assertSame(amount, zeroResult28.zero().getAmount());
    assertSame(amount, zeroResult26.getAmount());
    assertSame(amount, zeroResult29.zero().getAmount());
    assertSame(amount, zeroResult30.getAmount());
    assertSame(amount, zeroResult30.zero().getAmount());
  }

  /**
   * Test {@link OrderAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor)
   * {@link OrderAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)}
   * with {@code 2.3}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_thenOrderAdjustmentImplValueIsBigDecimalWith23() {
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
   * Test {@link OrderAdjustmentImpl#setValue(Money)}.
   * <ul>
   *   <li>When {@link Money#Money()}.</li>
   *   <li>Then {@link OrderAdjustmentImpl} (default constructor)
   * {@link OrderAdjustmentImpl#value} is {@link BigDecimal#BigDecimal(String)}
   * with {@code 0.00}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#setValue(Money)}
   */
  @Test
  public void testSetValue_whenMoney_thenOrderAdjustmentImplValueIsBigDecimalWith000() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderAdjustmentImpl orderAdjustmentImpl = new OrderAdjustmentImpl();

    // Act
    orderAdjustmentImpl.setValue(new Money());

    // Assert
    assertEquals(new BigDecimal("0.00"), orderAdjustmentImpl.value);
  }

  /**
   * Test {@link OrderAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link Money} {@link Money#getAmount()} return
   * {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.</li>
   *   <li>Then calls {@link Money#getAmount()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenMoneyGetAmountReturnBigDecimalWith23_thenCallsGetAmount() {
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
   * Test {@link OrderAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@link BroadleafCurrencyImpl} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsBroadleafCurrencyImpl_thenReturnNull() {
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
   * Test {@link OrderAdjustmentImpl#getCurrencyCode()}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) Currency is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#getCurrencyCode()}
   */
  @Test
  public void testGetCurrencyCode_givenOrderImplCurrencyIsNull_thenReturnNull() {
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
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) FutureCredit is
   * {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOrderAdjustmentImplFutureCreditIsTrue_thenReturnTrue() {
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
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) Order is
   * {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOrderAdjustmentImplOrderIsNullOrderImpl_thenReturnFalse() {
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
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor) Order is
   * {@link NullOrderImpl}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOrderAdjustmentImplOrderIsNullOrderImpl_thenReturnFalse2() {
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
   * Test {@link OrderAdjustmentImpl#isFutureCredit()}.
   * <ul>
   *   <li>Given {@link OrderAdjustmentImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderAdjustmentImpl#isFutureCredit()}
   */
  @Test
  public void testIsFutureCredit_givenOrderAdjustmentImpl_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new OrderAdjustmentImpl()).isFutureCredit());
  }

  /**
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and
   * {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and
   * {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and
   * {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}, and
   * {@link OrderAdjustmentImpl#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test {@link OrderAdjustmentImpl#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
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
   * Test new {@link OrderAdjustmentImpl} (default constructor).
   * <p>
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
