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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundle;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItem;
import org.broadleafcommerce.core.catalog.domain.SkuBundleItemImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
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

public class AutoBundleActivityDiffblueTest {
  /**
   * Test
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}
   */
  @Test
  public void testCountExistingUsesOfBundle_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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

    // Act and Assert
    assertEquals(0, autoBundleActivity.countExistingUsesOfBundle(order, new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}
   */
  @Test
  public void testCountExistingUsesOfBundle_givenAuditableCreatedByIsOne_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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
    assertEquals(0, autoBundleActivity.countExistingUsesOfBundle(order, new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is
   * {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}
   */
  @Test
  public void testCountExistingUsesOfBundle_givenOrderItemImplAuditableIsAuditable() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderItemImpl orderItemImpl = new OrderItemImpl();
    orderItemImpl.setAuditable(auditable2);
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
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(orderItemImpl);

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

    // Act and Assert
    assertEquals(0, autoBundleActivity.countExistingUsesOfBundle(order, new ProductBundleImpl()));
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl}
   * (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_givenArrayListAddBundleOrderItemImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(new BundleOrderItemImpl());
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    int actualPopulateItemMatchesForSkuResult = autoBundleActivity.populateItemMatchesForSku(matchingItems, order,
        new ArrayList<>(), 1L);

    // Assert
    verify(order).getOrderItems();
    assertEquals(0, actualPopulateItemMatchesForSkuResult);
    assertTrue(matchingItems.isEmpty());
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_givenArrayList_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(new ArrayList<>());

    // Act
    int actualPopulateItemMatchesForSkuResult = autoBundleActivity.populateItemMatchesForSku(matchingItems, order,
        new ArrayList<>(), 1L);

    // Assert
    verify(order).getOrderItems();
    assertEquals(0, actualPopulateItemMatchesForSkuResult);
    assertTrue(matchingItems.isEmpty());
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_givenAuditableCreatedByIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

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
    assertEquals(0, autoBundleActivity.populateItemMatchesForSku(matchingItems, order, new ArrayList<>(), 1L));
    assertTrue(matchingItems.isEmpty());
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl}
   * {@link DiscreteOrderItemImpl#getSku()} return {@link SkuImpl} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    int actualPopulateItemMatchesForSkuResult = autoBundleActivity.populateItemMatchesForSku(matchingItems, order,
        new ArrayList<>(), 1L);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    assertEquals(0, actualPopulateItemMatchesForSkuResult);
    assertTrue(matchingItems.isEmpty());
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Then {@link ArrayList#ArrayList()} size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_thenArrayListSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act
    int actualPopulateItemMatchesForSkuResult = autoBundleActivity.populateItemMatchesForSku(matchingItems, order,
        new ArrayList<>(), 1L);

    // Assert
    verify(skuImpl).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    assertEquals(1, matchingItems.size());
    assertEquals(1, actualPopulateItemMatchesForSkuResult);
  }

  /**
   * Test
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}
   */
  @Test
  public void testPopulateItemMatchesForSku_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException("foo"));
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(discreteOrderItemImpl);
    NullOrderImpl order = mock(NullOrderImpl.class);
    when(order.getOrderItems()).thenReturn(orderItemList);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> autoBundleActivity.populateItemMatchesForSku(matchingItems, order, new ArrayList<>(), 1L));
    verify(skuImpl).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(order).getOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
  }

  /**
   * Test
   * {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   * <ul>
   *   <li>When {@link SkuBundleItemImpl} (default constructor) Quantity is
   * one.</li>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}
   */
  @Test
  public void testCountMaximumApplications_whenSkuBundleItemImplQuantityIsOne_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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

    SkuImpl sku = new SkuImpl();
    sku.setId(1L);

    SkuBundleItemImpl skuBundleItem = new SkuBundleItemImpl();
    skuBundleItem.setQuantity(1);
    skuBundleItem.setSku(sku);

    // Act and Assert
    assertEquals(0, autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>()));
  }

  /**
   * Test new {@link AutoBundleActivity} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link AutoBundleActivity}
   */
  @Test
  public void testNewAutoBundleActivity() {
    // Arrange and Act
    AutoBundleActivity actualAutoBundleActivity = new AutoBundleActivity();

    // Assert
    assertNull(actualAutoBundleActivity.getBeanName());
    assertNull(actualAutoBundleActivity.getRollbackRegion());
    assertNull(actualAutoBundleActivity.getStateConfiguration());
    assertNull(actualAutoBundleActivity.getErrorHandler());
    assertNull(actualAutoBundleActivity.getRollbackHandler());
    assertFalse(actualAutoBundleActivity.getAutomaticallyRegisterRollbackHandler());
    assertEquals(Integer.MAX_VALUE, actualAutoBundleActivity.getOrder());
  }
}
