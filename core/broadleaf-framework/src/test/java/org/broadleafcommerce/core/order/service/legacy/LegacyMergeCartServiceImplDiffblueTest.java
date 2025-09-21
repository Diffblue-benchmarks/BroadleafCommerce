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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OfferCode;
import org.broadleafcommerce.core.offer.domain.OfferCodeImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LegacyMergeCartServiceImplDiffblueTest {
  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new BundleOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddDiscreteOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new DiscreteOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testMergeGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new GiftWrapOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new BundleOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse,
   * Order, Map)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)"
  })
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(new GiftWrapOrderItemImpl());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualRemoveExpiredGiftWrapOrderItemsResult =
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(
            mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualRemoveExpiredGiftWrapOrderItemsResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@link OrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenAuditableCreatedByIsOne_thenReturnOrderImpl() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertSame(customerCart, actualMergeOfferCodesResult);
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   *   <li>Then return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenOfferCodeImpl_thenReturnOrderImpl() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();
    customerCart.addAddedOfferCode(offerCode);
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertTrue(actualMergeOfferCodesResult instanceof OrderImpl);
    List<OfferCode> addedOfferCodes = actualMergeOfferCodesResult.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   *
   * <ul>
   *   <li>Given {@link OfferCodeImpl} (default constructor).
   *   <li>Then return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyMergeCartServiceImpl.mergeOfferCodes(Order, Order)"})
  public void testMergeOfferCodes_givenOfferCodeImpl_thenReturnOrderImpl2() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.addAddedOfferCode(new OfferCodeImpl());
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl customerCart = new OrderImpl();
    OfferCodeImpl offerCode = new OfferCodeImpl();
    customerCart.addAddedOfferCode(offerCode);
    customerCart.setAdditionalOfferInformation(new HashMap<>());
    customerCart.setAuditable(auditable2);
    customerCart.setCandidateOrderOffers(new ArrayList<>());
    customerCart.setCurrency(new BroadleafCurrencyImpl());
    customerCart.setCustomer(new CustomerImpl());
    customerCart.setEmailAddress("42 Main St");
    customerCart.setFulfillmentGroups(new ArrayList<>());
    customerCart.setId(1L);
    customerCart.setLocale(new LocaleImpl());
    customerCart.setName("Name");
    customerCart.setOrderAttributes(new HashMap<>());
    customerCart.setOrderItems(new ArrayList<>());
    customerCart.setOrderMessages(new ArrayList<>());
    customerCart.setOrderNumber("42");
    customerCart.setPayments(new ArrayList<>());
    customerCart.setStatus(OrderStatus.ARCHIVED);
    customerCart.setSubTotal(new Money());
    customerCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalTax(new Money());

    // Act
    Order actualMergeOfferCodesResult =
        legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart);

    // Assert
    assertTrue(actualMergeOfferCodesResult instanceof OrderImpl);
    List<OfferCode> addedOfferCodes = actualMergeOfferCodesResult.getAddedOfferCodes();
    assertEquals(1, addedOfferCodes.size());
    assertSame(offerCode, addedOfferCodes.get(0));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order,
   * Map)}.
   *
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order,
   * MergeCartResponse, Order, Map)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyMergeCartServiceImpl.mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)"
  })
  public void testMergeRegularOrderItems_givenAuditableCreatedByIsOne_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable);
    anonymousCart.setCandidateOrderOffers(new ArrayList<>());
    anonymousCart.setCurrency(new BroadleafCurrencyImpl());
    anonymousCart.setCustomer(new CustomerImpl());
    anonymousCart.setEmailAddress("42 Main St");
    anonymousCart.setFulfillmentGroups(new ArrayList<>());
    anonymousCart.setId(1L);
    anonymousCart.setLocale(new LocaleImpl());
    anonymousCart.setName("Name");
    anonymousCart.setOrderAttributes(new HashMap<>());
    anonymousCart.setOrderItems(new ArrayList<>());
    anonymousCart.setOrderMessages(new ArrayList<>());
    anonymousCart.setOrderNumber("42");
    anonymousCart.setPayments(new ArrayList<>());
    anonymousCart.setStatus(OrderStatus.ARCHIVED);
    anonymousCart.setSubTotal(new Money());
    anonymousCart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalTax(new Money());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeRegularOrderItemsResult =
        legacyMergeCartServiceImpl.mergeRegularOrderItems(
            anonymousCart, mergeCartResponse, customerCart, new HashMap<>());

    // Assert
    assertSame(customerCart, actualMergeRegularOrderItemsResult);
  }

  /**
   * Test new {@link LegacyMergeCartServiceImpl} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * LegacyMergeCartServiceImpl}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void LegacyMergeCartServiceImpl.<init>()"})
  public void testNewLegacyMergeCartServiceImpl() {
    // Arrange, Act and Assert
    assertNull(new LegacyMergeCartServiceImpl().fulfillmentGroupService);
  }
}
