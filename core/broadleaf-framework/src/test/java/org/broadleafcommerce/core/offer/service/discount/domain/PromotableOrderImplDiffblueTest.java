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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
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
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
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
import org.mockito.Mockito;

public class PromotableOrderImplDiffblueTest {
  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(promotableOrderImpl.getCandidateOrderAdjustments().isEmpty());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.discountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.fulfillmentGroups.isEmpty());
    assertSame(order, promotableOrderImpl.getOrder());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(promotableOrderImpl.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(promotableOrderImpl.getCandidateOrderAdjustments().isEmpty());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.discountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.fulfillmentGroups.isEmpty());
    assertSame(order, promotableOrderImpl.getOrder());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    orderItem.setRetailPrice(new Money());
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> discountableOrderItems = promotableOrderImpl.getDiscountableOrderItems();
    assertEquals(1, discountableOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(promotableOrderImpl.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(promotableOrderImpl.getCandidateOrderAdjustments().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.fulfillmentGroups.isEmpty());
    assertSame(order, promotableOrderImpl.getOrder());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(discountableOrderItems, promotableOrderImpl.discountableOrderItems);
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(promotableOrderImpl.getCandidateOrderAdjustments().isEmpty());
    assertTrue(promotableOrderImpl.getDiscountableOrderItems().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.discountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.fulfillmentGroups.isEmpty());
    assertSame(order, promotableOrderImpl.getOrder());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    orderItem.setRetailPrice(new Money());
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> discountableOrderItems = promotableOrderImpl.getDiscountableOrderItems();
    assertEquals(1, discountableOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(promotableOrderImpl.getAllPromotableOrderItemPriceDetails().isEmpty());
    assertTrue(promotableOrderImpl.getCandidateOrderAdjustments().isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.fulfillmentGroups.isEmpty());
    assertSame(order, promotableOrderImpl.getOrder());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(discountableOrderItems, promotableOrderImpl.discountableOrderItems);
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#getAllOrderItems()}
   */
  @Test
  public void testGetAllOrderItems() {
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
    List<PromotableOrderItem> actualAllOrderItems = promotableOrderImpl.getAllOrderItems();

    // Assert
    assertTrue(actualAllOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, actualAllOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#getAllOrderItems()}
   */
  @Test
  public void testGetAllOrderItems2() {
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
    List<PromotableOrderItem> actualAllOrderItems = promotableOrderImpl.getAllOrderItems();

    // Assert
    assertTrue(actualAllOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, actualAllOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#getDiscountableOrderItems()}
   */
  @Test
  public void testGetDiscountableOrderItems3() {
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
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItems4() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.currentSortParam);
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItems5() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.currentSortParam);
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#getDiscountableOrderItems(boolean)}
   */
  @Test
  public void testGetDiscountableOrderItems6() {
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
    List<PromotableOrderItem> actualDiscountableOrderItems = promotableOrderImpl.getDiscountableOrderItems(true);

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(actualDiscountableOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.currentSortParam);
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
    assertSame(promotableOrderImpl.discountableOrderItems, actualDiscountableOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#buildPromotableOrderItemsList()}
   */
  @Test
  public void testBuildPromotableOrderItemsList2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#buildPromotableOrderItemsList()}
   */
  @Test
  public void testBuildPromotableOrderItemsList3() {
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
    List<PromotableOrderItem> actualBuildPromotableOrderItemsListResult = promotableOrderImpl
        .buildPromotableOrderItemsList();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(actualBuildPromotableOrderItemsListResult.isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#getFulfillmentGroups()}
   */
  @Test
  public void testGetFulfillmentGroups() {
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
   * Method under test: {@link PromotableOrderImpl#getFulfillmentGroups()}
   */
  @Test
  public void testGetFulfillmentGroups2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateOfferAdjustments4() {
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
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateItemOfferAdjustments2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#removeAllCandidateItemOfferAdjustments()}
   */
  @Test
  public void testRemoveAllCandidateItemOfferAdjustments3() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied3() {
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
    boolean actualIsTotalitarianOfferAppliedResult = promotableOrderImpl.isTotalitarianOfferApplied();

    // Assert
    assertEquals(1, promotableOrderImpl.getFulfillmentGroups().size());
    assertFalse(actualIsTotalitarianOfferAppliedResult);
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test: {@link PromotableOrderImpl#isTotalitarianOfferApplied()}
   */
  @Test
  public void testIsTotalitarianOfferApplied4() {
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
    boolean actualIsTotalitarianOfferAppliedResult = promotableOrderImpl.isTotalitarianOfferApplied();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertFalse(actualIsTotalitarianOfferAppliedResult);
    assertTrue(promotableOrderImpl.getFulfillmentGroups().isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}
   */
  @Test
  public void testIsTotalitarianItemOfferApplied2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#isTotalitarianItemOfferApplied()}
   */
  @Test
  public void testIsTotalitarianItemOfferApplied3() {
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
    boolean actualIsTotalitarianItemOfferAppliedResult = promotableOrderImpl.isTotalitarianItemOfferApplied();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertFalse(actualIsTotalitarianItemOfferAppliedResult);
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
   * Method under test: {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}
   */
  @Test
  public void testIsTotalitarianFgOfferApplied2() {
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
   * Method under test: {@link PromotableOrderImpl#isTotalitarianFgOfferApplied()}
   */
  @Test
  public void testIsTotalitarianFgOfferApplied3() {
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
   * Method under test: {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}
   */
  @Test
  public void testCalculateItemAdjustmentTotal() {
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
    Money actualCalculateItemAdjustmentTotalResult = promotableOrderImpl.calculateItemAdjustmentTotal();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Currency currency = actualCalculateItemAdjustmentTotalResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualCalculateItemAdjustmentTotalResult.getAmount());
    assertEquals(orderAdjustmentList, promotableOrderImpl.allOrderItems);
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.abs());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.zero());
  }

  /**
   * Method under test: {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}
   */
  @Test
  public void testCalculateItemAdjustmentTotal2() {
    // Arrange
    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);

    // Act
    Money actualCalculateItemAdjustmentTotalResult = (new PromotableOrderImpl(order,
        new PromotableItemFactoryImpl(new PromotableOfferUtilityImpl()), true)).calculateItemAdjustmentTotal();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Currency currency = actualCalculateItemAdjustmentTotalResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualCalculateItemAdjustmentTotalResult.getAmount());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.abs());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.zero());
  }

  /**
   * Method under test: {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}
   */
  @Test
  public void testCalculateItemAdjustmentTotal3() {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getAllowDiscountsOnChildItems()).thenReturn(true);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    orderItemList.add(bundleOrderItemImpl);
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    BundleOrderItemImpl bundleOrderItemImpl2 = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl2.getAllowDiscountsOnChildItems()).thenReturn(false);
    PromotableOrderItemImpl promotableOrderItemImpl = mock(PromotableOrderItemImpl.class);
    when(promotableOrderItemImpl.getOrderItemContainer()).thenReturn(bundleOrderItemImpl2);
    when(promotableOrderItemImpl.isDiscountingAllowed()).thenReturn(false);
    when(promotableOrderItemImpl.isOrderItemContainer()).thenReturn(true);
    PromotableItemFactoryImpl itemFactory = mock(PromotableItemFactoryImpl.class);
    when(itemFactory.createPromotableOrderItem(Mockito.<OrderItem>any(), Mockito.<PromotableOrder>any(), anyBoolean()))
        .thenReturn(promotableOrderItemImpl);

    // Act
    Money actualCalculateItemAdjustmentTotalResult = (new PromotableOrderImpl(order, itemFactory, true))
        .calculateItemAdjustmentTotal();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(itemFactory, atLeast(1)).createPromotableOrderItem(Mockito.<OrderItem>any(), isA(PromotableOrder.class),
        eq(true));
    verify(promotableOrderItemImpl, atLeast(1)).getOrderItemContainer();
    verify(promotableOrderItemImpl, atLeast(1)).isDiscountingAllowed();
    verify(promotableOrderItemImpl, atLeast(1)).isOrderItemContainer();
    verify(bundleOrderItemImpl2, atLeast(1)).getAllowDiscountsOnChildItems();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Currency currency = actualCalculateItemAdjustmentTotalResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualCalculateItemAdjustmentTotalResult.getAmount());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.abs());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.zero());
  }

  /**
   * Method under test: {@link PromotableOrderImpl#calculateItemAdjustmentTotal()}
   */
  @Test
  public void testCalculateItemAdjustmentTotal4() {
    // Arrange
    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    orderItemList.add(mock(BundleOrderItemImpl.class));
    BroadleafCurrencyImpl broadleafCurrencyImpl = mock(BroadleafCurrencyImpl.class);
    when(broadleafCurrencyImpl.getCurrencyCode()).thenReturn("GBP");
    Order order = mock(Order.class);
    when(order.getOrderAdjustments()).thenReturn(new ArrayList<>());
    when(order.getOrderItems()).thenReturn(orderItemList);
    when(order.getCurrency()).thenReturn(broadleafCurrencyImpl);
    PromotableOrderItemImpl promotableOrderItemImpl = mock(PromotableOrderItemImpl.class);
    when(promotableOrderItemImpl.isDiscountingAllowed()).thenReturn(false);
    when(promotableOrderItemImpl.isOrderItemContainer()).thenReturn(false);
    PromotableItemFactoryImpl itemFactory = mock(PromotableItemFactoryImpl.class);
    when(itemFactory.createPromotableOrderItem(Mockito.<OrderItem>any(), Mockito.<PromotableOrder>any(), anyBoolean()))
        .thenReturn(promotableOrderItemImpl);

    // Act
    Money actualCalculateItemAdjustmentTotalResult = (new PromotableOrderImpl(order, itemFactory, true))
        .calculateItemAdjustmentTotal();

    // Assert
    verify(broadleafCurrencyImpl).getCurrencyCode();
    verify(itemFactory, atLeast(1)).createPromotableOrderItem(Mockito.<OrderItem>any(), isA(PromotableOrder.class),
        eq(true));
    verify(promotableOrderItemImpl, atLeast(1)).isDiscountingAllowed();
    verify(promotableOrderItemImpl, atLeast(1)).isOrderItemContainer();
    verify(order).getCurrency();
    verify(order, atLeast(1)).getOrderAdjustments();
    verify(order).getOrderItems();
    Currency currency = actualCalculateItemAdjustmentTotalResult.getCurrency();
    assertEquals("British Pound", currency.getDisplayName());
    assertEquals("GBP", currency.getCurrencyCode());
    assertEquals("GBP", currency.toString());
    assertEquals("£", currency.getSymbol());
    assertEquals(2, currency.getDefaultFractionDigits());
    assertEquals(826, currency.getNumericCode());
    BigDecimal expectedAmount = new BigDecimal("0.00");
    assertEquals(expectedAmount, actualCalculateItemAdjustmentTotalResult.getAmount());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.abs());
    assertEquals(actualCalculateItemAdjustmentTotalResult, actualCalculateItemAdjustmentTotalResult.zero());
  }

  /**
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualAllPromotableOrderItemPriceDetails.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}
   */
  @Test
  public void testGetAllPromotableOrderItemPriceDetails2() {
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
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertTrue(allOrderItems.isEmpty());
    assertTrue(actualAllPromotableOrderItemPriceDetails.isEmpty());
    assertTrue(promotableOrderImpl.allOrderItems.isEmpty());
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#getAllPromotableOrderItemPriceDetails()}
   */
  @Test
  public void testGetAllPromotableOrderItemPriceDetails3() {
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
    List<PromotableOrderItemPriceDetail> actualAllPromotableOrderItemPriceDetails = promotableOrderImpl
        .getAllPromotableOrderItemPriceDetails();

    // Assert
    List<PromotableOrderItem> allOrderItems = promotableOrderImpl.getAllOrderItems();
    assertEquals(1, allOrderItems.size());
    List<PromotableOrderItem> promotableOrderItemList = promotableOrderImpl.allOrderItems;
    assertEquals(1, promotableOrderItemList.size());
    assertTrue(actualAllPromotableOrderItemPriceDetails.isEmpty());
    assertSame(allOrderItems.get(0), promotableOrderItemList.get(0));
    assertSame(promotableOrderImpl.allOrderItems, allOrderItems);
  }

  /**
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
    assertSame(order, promotableOrderImpl.getOrder());
  }

  /**
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer() {
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
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer2() {
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
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer3() {
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
   * Method under test:
   * {@link PromotableOrderImpl#canApplyOrderOffer(PromotableCandidateOrderOffer)}
   */
  @Test
  public void testCanApplyOrderOffer4() {
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
}
