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
package org.broadleafcommerce.core.order.service.legacy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class LegacyMergeCartServiceImplDiffblueTest {
  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
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
    Order actualMergeGiftWrapOrderItemsResult = legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(mergeCartResponse,
        customerCart, new HashMap<>());

    // Assert
    assertTrue(actualMergeGiftWrapOrderItemsResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeGiftWrapOrderItemsResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeGiftWrapOrderItemsResult.getSubTotal());
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl() throws PricingException {
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
    Order actualMergeGiftWrapOrderItemsResult = legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(mergeCartResponse,
        customerCart, new HashMap<>());

    // Assert
    assertTrue(actualMergeGiftWrapOrderItemsResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeGiftWrapOrderItemsResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeGiftWrapOrderItemsResult.getSubTotal());
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl() throws PricingException {
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
    Order actualMergeGiftWrapOrderItemsResult = legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(mergeCartResponse,
        customerCart, new HashMap<>());

    // Assert
    assertTrue(actualMergeGiftWrapOrderItemsResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeGiftWrapOrderItemsResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeGiftWrapOrderItemsResult.getSubTotal());
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeGiftWrapOrderItems_givenBundleOrderItemImpl() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    HashMap<OrderItem, OrderItem> oldNewItemMap = new HashMap<>();
    oldNewItemMap.computeIfPresent(new BundleOrderItemImpl(), mock(BiFunction.class));

    // Act
    Order actualMergeGiftWrapOrderItemsResult = legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(mergeCartResponse,
        customerCart, oldNewItemMap);

    // Assert
    assertTrue(actualMergeGiftWrapOrderItemsResult instanceof NullOrderImpl);
    Money orderAdjustmentsValue = actualMergeGiftWrapOrderItemsResult.getOrderAdjustmentsValue();
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.abs());
    assertEquals(orderAdjustmentsValue, orderAdjustmentsValue.zero());
    assertEquals(orderAdjustmentsValue, actualMergeGiftWrapOrderItemsResult.getSubTotal());
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Then return SubTotal is {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeGiftWrapOrderItems_thenReturnSubTotalIsMoney() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable);
    orderItemImpl.setCandidateItemOffers(new ArrayList<>());
    orderItemImpl.setCartMessages(new ArrayList<>());
    orderItemImpl.setChildOrderItems(new ArrayList<>());
    orderItemImpl.setDiscountingAllowed(true);
    orderItemImpl.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItemImpl.setHasValidationError(true);
    orderItemImpl.setId(1L);
    orderItemImpl.setName("Name");
    orderItemImpl.setOrder(new NullOrderImpl());
    orderItemImpl.setOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setOrderItemAttributes(new HashMap<>());
    orderItemImpl.setOrderItemPriceDetails(new ArrayList<>());
    orderItemImpl.setOrderItemQualifiers(new ArrayList<>());
    orderItemImpl.setOrderItemType(OrderItemType.BASIC);
    orderItemImpl.setParentOrderItem(new BundleOrderItemImpl());
    orderItemImpl.setPersonalMessage(new PersonalMessageImpl());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    Money retailPrice = new Money();
    orderItemImpl.setRetailPrice(retailPrice);
    orderItemImpl.setRetailPriceOverride(true);
    Money salePrice = new Money();
    orderItemImpl.setSalePrice(salePrice);
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> addedItems = new ArrayList<>();
    addedItems.add(orderItemImpl);

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(addedItems);
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act
    Order actualMergeGiftWrapOrderItemsResult = legacyMergeCartServiceImpl.mergeGiftWrapOrderItems(mergeCartResponse,
        customerCart, new HashMap<>());

    // Assert
    assertTrue(actualMergeGiftWrapOrderItemsResult instanceof NullOrderImpl);
    assertEquals(retailPrice, actualMergeGiftWrapOrderItemsResult.getSubTotal());
    Money expectedOrderAdjustmentsValue = salePrice.ZERO;
    assertSame(expectedOrderAdjustmentsValue, actualMergeGiftWrapOrderItemsResult.getOrderAdjustmentsValue());
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddBundleOrderItemImpl() throws PricingException {
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

    // Act and Assert
    assertSame(customerCart,
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(mergeCartResponse, customerCart, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link GiftWrapOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testRemoveExpiredGiftWrapOrderItems_givenArrayListAddGiftWrapOrderItemImpl() throws PricingException {
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

    // Act and Assert
    assertSame(customerCart,
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(mergeCartResponse, customerCart, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testRemoveExpiredGiftWrapOrderItems_givenBundleOrderItemImpl() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    HashMap<OrderItem, OrderItem> oldNewItemMap = new HashMap<>();
    oldNewItemMap.computeIfPresent(new BundleOrderItemImpl(), mock(BiFunction.class));

    // Act and Assert
    assertSame(customerCart,
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(mergeCartResponse, customerCart, oldNewItemMap));
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#removeExpiredGiftWrapOrderItems(MergeCartResponse, Order, Map)}
   */
  @Test
  public void testRemoveExpiredGiftWrapOrderItems_whenHashMap() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act and Assert
    assertSame(customerCart,
        legacyMergeCartServiceImpl.removeExpiredGiftWrapOrderItems(mergeCartResponse, customerCart, new HashMap<>()));
  }

  /**
   * Test {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}.
   * <ul>
   *   <li>Then return {@link OrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeOfferCodes(Order, Order)}
   */
  @Test
  public void testMergeOfferCodes_thenReturnOrderImpl() {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    anonymousCart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalShipping(new Money());
    anonymousCart.setTotalTax(new Money());

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    customerCart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    customerCart.setTaxOverride(true);
    customerCart.setTotal(new Money());
    customerCart.setTotalFulfillmentCharges(new Money());
    customerCart.setTotalShipping(new Money());
    customerCart.setTotalTax(new Money());

    // Act and Assert
    assertSame(customerCart, legacyMergeCartServiceImpl.mergeOfferCodes(anonymousCart, customerCart));
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeRegularOrderItems_givenAuditableDateCreatedIsDate() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    anonymousCart
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalShipping(new Money());
    anonymousCart.setTotalTax(new Money());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act and Assert
    assertSame(customerCart, legacyMergeCartServiceImpl.mergeRegularOrderItems(anonymousCart, mergeCartResponse,
        customerCart, new HashMap<>()));
  }

  /**
   * Test
   * {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)}.
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LegacyMergeCartServiceImpl#mergeRegularOrderItems(Order, MergeCartResponse, Order, Map)}
   */
  @Test
  public void testMergeRegularOrderItems_thenReturnNullOrderImpl() throws PricingException {
    // Arrange
    LegacyMergeCartServiceImpl legacyMergeCartServiceImpl = new LegacyMergeCartServiceImpl();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    anonymousCart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    anonymousCart.setTaxOverride(true);
    anonymousCart.setTotal(new Money());
    anonymousCart.setTotalFulfillmentCharges(new Money());
    anonymousCart.setTotalShipping(new Money());
    anonymousCart.setTotalTax(new Money());

    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    NullOrderImpl customerCart = new NullOrderImpl();

    // Act and Assert
    assertSame(customerCart, legacyMergeCartServiceImpl.mergeRegularOrderItems(anonymousCart, mergeCartResponse,
        customerCart, new HashMap<>()));
  }

  /**
   * Test new {@link LegacyMergeCartServiceImpl} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link LegacyMergeCartServiceImpl}
   */
  @Test
  public void testNewLegacyMergeCartServiceImpl() {
    // Arrange, Act and Assert
    assertNull((new LegacyMergeCartServiceImpl()).fulfillmentGroupService);
  }
}
