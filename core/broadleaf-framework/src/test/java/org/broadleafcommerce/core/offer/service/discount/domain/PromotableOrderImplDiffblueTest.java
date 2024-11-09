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
package org.broadleafcommerce.core.offer.service.discount.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.offer.domain.OrderAdjustment;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;

public class PromotableOrderImplDiffblueTest {
  /**
   * Test {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}
   */
  @Test
  public void testSetOrderSubTotalToPriceWithoutAdjustments() {
    // Arrange
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setOrderSubTotalToPriceWithoutAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getOrder() instanceof OrderImpl);
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}
   */
  @Test
  public void testSetOrderSubTotalToPriceWithoutAdjustments2() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setOrderSubTotalToPriceWithoutAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getOrder() instanceof OrderImpl);
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setOrderSubTotalToPriceWithoutAdjustments()}
   */
  @Test
  public void testSetOrderSubTotalToPriceWithoutAdjustments3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("ThreadLocalManager.notify.orphans");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setOrderSubTotalToPriceWithoutAdjustments();

    // Assert
    Order order2 = promotableOrderImpl.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertEquals(1, promotableOrderImpl.getDiscountableOrderItems().size());
    assertEquals(retailPrice, order2.getSubTotal());
  }

  /**
   * Test {@link PromotableOrderImpl#setOrderSubTotalToPriceWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setOrderSubTotalToPriceWithAdjustments()}
   */
  @Test
  public void testSetOrderSubTotalToPriceWithAdjustments() {
    // Arrange
    OrderImpl order = new OrderImpl();
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setOrderSubTotalToPriceWithAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getOrder() instanceof OrderImpl);
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#setOrderSubTotalToPriceWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setOrderSubTotalToPriceWithAdjustments()}
   */
  @Test
  public void testSetOrderSubTotalToPriceWithAdjustments2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    orderItem.setChildOrderItems(new ArrayList<>());
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("ThreadLocalManager.notify.orphans");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    Money retailPrice = new Money();
    orderItem.setRetailPrice(retailPrice);
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setOrderSubTotalToPriceWithAdjustments();

    // Assert
    Order order2 = promotableOrderImpl.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    assertEquals(1, promotableOrderImpl.getDiscountableOrderItems().size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertEquals(retailPrice, order2.getSubTotal());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#getAllOrderItems()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#getAllOrderItems()}
   */
  @Test
  public void testGetAllOrderItems_givenAuditableDateCreatedIsDate_thenReturnEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue((new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .getAllOrderItems()
        .isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getAllOrderItems()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#getAllOrderItems()}
   */
  @Test
  public void testGetAllOrderItems_thenReturnEmpty() {
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
    assertTrue((new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .getAllOrderItems()
        .isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.getDiscountableOrderItems();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItemsWithBoolean() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems(true);

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.currentSortParam);
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)} with
   * {@code boolean}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItemsWithBoolean2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.getDiscountableOrderItems(true);

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)} with
   * {@code boolean}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItemsWithBoolean_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems(true);

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.currentSortParam);
  }

  /**
   * Test {@link PromotableOrderImpl#getDiscountableOrderItems()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#buildPromotableOrderItemsList()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#buildPromotableOrderItemsList()}
   */
  @Test
  public void testBuildPromotableOrderItemsList() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.buildPromotableOrderItemsList();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#buildPromotableOrderItemsList()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#buildPromotableOrderItemsList()}
   */
  @Test
  public void testBuildPromotableOrderItemsList_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertTrue(promotableOrderImpl.buildPromotableOrderItemsList().isEmpty());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#buildPromotableOrderItemsList()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#buildPromotableOrderItemsList()}
   */
  @Test
  public void testBuildPromotableOrderItemsList_thenReturnEmpty() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertTrue(promotableOrderImpl.buildPromotableOrderItemsList().isEmpty());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getFulfillmentGroups()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#getFulfillmentGroups()}
   */
  @Test
  public void testGetFulfillmentGroups_givenAuditableDateCreatedIsDate_thenReturnEmpty() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());

    // Act and Assert
    assertTrue((new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .getFulfillmentGroups()
        .isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getFulfillmentGroups()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#getFulfillmentGroups()}
   */
  @Test
  public void testGetFulfillmentGroups_thenReturnEmpty() {
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
    assertTrue((new PromotableOrderImpl(order, new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true))
        .getFulfillmentGroups()
        .isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PromotableOrderImpl#getCandidateOrderAdjustments()}
   *   <li>{@link PromotableOrderImpl#getExtraDataMap()}
   *   <li>{@link PromotableOrderImpl#getOrder()}
   *   <li>{@link PromotableOrderImpl#isIncludeOrderAndItemAdjustments()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderAdjustment> actualCandidateOrderAdjustments = promotableOrderImpl
        .getCandidateOrderAdjustments();
    Map<String, Object> actualExtraDataMap = promotableOrderImpl.getExtraDataMap();
    Order actualOrder = promotableOrderImpl.getOrder();
    boolean actualIsIncludeOrderAndItemAdjustmentsResult = promotableOrderImpl.isIncludeOrderAndItemAdjustments();

    // Assert
    assertTrue(actualCandidateOrderAdjustments.isEmpty());
    assertTrue(actualExtraDataMap.isEmpty());
    assertTrue(actualIsIncludeOrderAndItemAdjustmentsResult);
    assertSame(promotableOrderImpl.order, actualOrder);
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateOfferAdjustments();

    // Assert
    assertEquals(1, promotableOrderImpl.getFulfillmentGroups().size());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateOfferAdjustments();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateItemOfferAdjustments() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateItemOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateItemOfferAdjustments2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateItemOfferAdjustments();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateItemOfferAdjustments_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateItemOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateFulfillmentOfferAdjustments() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateFulfillmentOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateFulfillmentOfferAdjustments2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateFulfillmentOfferAdjustments();

    // Assert
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateFulfillmentOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateFulfillmentOfferAdjustments3() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.removeAllCandidateFulfillmentOfferAdjustments();

    // Assert
    assertEquals(1, promotableOrderImpl.getFulfillmentGroups().size());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.isTotalitarianOfferApplied();

    // Assert
    assertEquals(1, promotableOrderImpl.getFulfillmentGroups().size());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianOfferApplied()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.isTotalitarianOfferApplied();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianOfferApplied()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied_givenAuditableDateCreatedIsDate_thenReturnFalse() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianOfferApplied());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianOfferApplied()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied_thenReturnFalse() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianOfferApplied());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}
   */
  @Test
  public void testIsTotalitarianItemOfferApplied() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.isTotalitarianItemOfferApplied();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}
   */
  @Test
  public void testIsTotalitarianItemOfferApplied_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianItemOfferApplied());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}
   */
  @Test
  public void testIsTotalitarianItemOfferApplied_thenReturnFalse() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianItemOfferApplied());
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}
   */
  @Test
  public void testIsTotalitarianFgOfferApplied() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianFgOfferApplied());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}.
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}
   */
  @Test
  public void testIsTotalitarianFgOfferApplied2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(new FulfillmentGroupImpl());

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    order.setCurrency(new BroadleafCurrencyImpl());
    order.setCustomer(new CustomerImpl());
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(fulfillmentGroups);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    boolean actualIsTotalitarianFgOfferAppliedResult = promotableOrderImpl.isTotalitarianFgOfferApplied();

    // Assert
    assertEquals(1, promotableOrderImpl.getFulfillmentGroups().size());
    assertFalse(actualIsTotalitarianFgOfferAppliedResult);
  }

  /**
   * Test {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}
   */
  @Test
  public void testIsTotalitarianFgOfferApplied_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act and Assert
    assertFalse(promotableOrderImpl.isTotalitarianFgOfferApplied());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Price is
   * {@link Money#Money()}.</li>
   *   <li>Then return {@link Money#Money()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}
   */
  @Test
  public void testCalculateItemAdjustmentTotal_givenOrderItemImplPriceIsMoney_thenReturnMoney() {
    // Arrange
    OrderItemImpl orderItem = new OrderItemImpl();
    Money finalPrice = new Money();
    orderItem.setPrice(finalPrice);
    BroadleafCurrency currency = mock(BroadleafCurrency.class);
    when(currency.getCurrencyCode()).thenReturn("GBP");

    OrderImpl order = new OrderImpl();
    order.setCurrency(currency);
    order.addOrderItem(orderItem);

    // Act
    Money actualCalculateItemAdjustmentTotalResult = (new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateItemAdjustmentTotal();

    // Assert
    verify(currency).getCurrencyCode();
    assertEquals(finalPrice, actualCalculateItemAdjustmentTotalResult);
  }

  /**
   * Test {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}
   */
  @Test
  public void testGetAllPromotableOrderItemPriceDetails() {
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItemPriceDetail> actualAllPromotableOrderItemPriceDetails = promotableOrderImpl
        .getAllPromotableOrderItemPriceDetails();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualAllPromotableOrderItemPriceDetails.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}
   */
  @Test
  public void testGetAllPromotableOrderItemPriceDetails2() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

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
    order.setOrderItems(orderItems);
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.getAllPromotableOrderItemPriceDetails();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Test {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) DateCreated is
   * {@link java.sql.Date}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}
   */
  @Test
  public void testGetAllPromotableOrderItemPriceDetails_givenAuditableDateCreatedIsDate() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(mock(java.sql.Date.class));
    auditable.setDateUpdated(
        java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order
        .setSubmitDate(java.util.Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalShipping(new Money());
    order.setTotalTax(new Money());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    List<PromotableOrderItemPriceDetail> actualAllPromotableOrderItemPriceDetails = promotableOrderImpl
        .getAllPromotableOrderItemPriceDetails();

    // Assert
    assertTrue(promotableOrderImpl.getAllOrderItems().isEmpty());
    assertTrue(actualAllPromotableOrderItemPriceDetails.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
  }

  /**
   * Test {@link PromotableOrderImpl#setTotalFufillmentCharges(Money)}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#setTotalFufillmentCharges(Money)}
   */
  @Test
  public void testSetTotalFufillmentCharges() {
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
    order.setName("NullOrder does not support any modification operations.");
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
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    promotableOrderImpl.setTotalFufillmentCharges(null);

    // Assert
    Order order2 = promotableOrderImpl.getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertNull(order2.getTotalFulfillmentCharges());
    assertNull(order2.getTotalShipping());
  }

  /**
   * Test
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer_givenFalse() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    PromotableCandidateOrderOfferImpl offer = mock(PromotableCandidateOrderOfferImpl.class);
    when(offer.isCombinable()).thenReturn(false);

    // Act
    boolean actualCanApplyOrderOfferResult = promotableOrderImpl.canApplyOrderOffer(offer);

    // Assert
    verify(offer).isCombinable();
    verify(order, atLeast(1)).getOrderAdjustments();
    assertTrue(actualCanApplyOrderOfferResult);
  }

  /**
   * Test
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}.
   * <ul>
   *   <li>Given {@link PromotableOrderAdjustmentImpl}
   * {@link PromotableOrderAdjustmentImpl#isCombinable()} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer_givenPromotableOrderAdjustmentImplIsCombinableReturnFalse() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderAdjustmentImpl orderAdjustment = mock(PromotableOrderAdjustmentImpl.class);
    when(orderAdjustment.isCombinable()).thenReturn(false);

    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    promotableOrderImpl.addCandidateOrderAdjustment(orderAdjustment);

    // Act
    boolean actualCanApplyOrderOfferResult = promotableOrderImpl
        .canApplyOrderOffer(mock(PromotableCandidateOrderOfferImpl.class));

    // Assert
    verify(orderAdjustment).isCombinable();
    verify(order, atLeast(1)).getOrderAdjustments();
    assertFalse(actualCanApplyOrderOfferResult);
  }

  /**
   * Test
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}.
   * <ul>
   *   <li>Given {@link PromotableOrderAdjustmentImpl}
   * {@link PromotableOrderAdjustmentImpl#isCombinable()} return
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer_givenPromotableOrderAdjustmentImplIsCombinableReturnTrue() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderAdjustmentImpl orderAdjustment = mock(PromotableOrderAdjustmentImpl.class);
    when(orderAdjustment.isCombinable()).thenReturn(true);

    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    promotableOrderImpl.addCandidateOrderAdjustment(orderAdjustment);
    PromotableCandidateOrderOfferImpl offer = mock(PromotableCandidateOrderOfferImpl.class);
    when(offer.isTotalitarian()).thenReturn(true);
    when(offer.isCombinable()).thenReturn(true);

    // Act
    boolean actualCanApplyOrderOfferResult = promotableOrderImpl.canApplyOrderOffer(offer);

    // Assert
    verify(offer).isCombinable();
    verify(offer).isTotalitarian();
    verify(orderAdjustment).isCombinable();
    verify(order, atLeast(1)).getOrderAdjustments();
    assertFalse(actualCanApplyOrderOfferResult);
  }

  /**
   * Test
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls
   * {@link PromotableCandidateOrderOfferImpl#isTotalitarian()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer_givenTrue_thenCallsIsTotalitarian() {
    // Arrange
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);
    PromotableCandidateOrderOfferImpl offer = mock(PromotableCandidateOrderOfferImpl.class);
    when(offer.isTotalitarian()).thenReturn(true);
    when(offer.isCombinable()).thenReturn(true);

    // Act
    boolean actualCanApplyOrderOfferResult = promotableOrderImpl.canApplyOrderOffer(offer);

    // Assert
    verify(offer).isCombinable();
    verify(offer).isTotalitarian();
    verify(order, atLeast(1)).getOrderAdjustments();
    assertTrue(actualCanApplyOrderOfferResult);
  }

  /**
   * Test {@link PromotableOrderImpl#calculateSubtotalWithoutAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#calculateSubtotalWithoutAdjustments()}
   */
  @Test
  public void testCalculateSubtotalWithoutAdjustments() {
    // Arrange
    BundleOrderItemImpl orderItem = new BundleOrderItemImpl();
    orderItem.setOrder(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(orderItem);

    // Act
    Money actualCalculateSubtotalWithoutAdjustmentsResult = (new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateSubtotalWithoutAdjustments();

    // Assert
    assertEquals(actualCalculateSubtotalWithoutAdjustmentsResult.ZERO, actualCalculateSubtotalWithoutAdjustmentsResult);
  }

  /**
   * Test {@link PromotableOrderImpl#calculateSubtotalWithAdjustments()}.
   * <p>
   * Method under test:
   * {@link PromotableOrderImpl#calculateSubtotalWithAdjustments()}
   */
  @Test
  public void testCalculateSubtotalWithAdjustments() {
    // Arrange
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    ArrayList<OrderAdjustment> orderAdjustmentList = new ArrayList<>();
    when(order.getOrderAdjustments()).thenReturn(orderAdjustmentList);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderImpl promotableOrderImpl = new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true);

    // Act
    Money actualCalculateSubtotalWithAdjustmentsResult = promotableOrderImpl.calculateSubtotalWithAdjustments();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    assertEquals(orderAdjustmentList, promotableOrderImpl.allOrderItems);
    assertEquals(actualCalculateSubtotalWithAdjustmentsResult.ZERO, actualCalculateSubtotalWithAdjustmentsResult);
  }
}
