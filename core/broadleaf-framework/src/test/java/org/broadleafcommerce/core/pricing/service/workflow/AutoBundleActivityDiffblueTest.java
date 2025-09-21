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
package org.broadleafcommerce.core.pricing.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.broadleafcommerce.core.catalog.domain.Sku;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AutoBundleActivityDiffblueTest {
  @InjectMocks private AutoBundleActivity autoBundleActivity;

  /**
   * Test {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countExistingUsesOfBundle(Order,
   * ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countExistingUsesOfBundle(Order, ProductBundle)"})
  public void testCountExistingUsesOfBundle_givenArrayListAddBundleOrderItemImpl() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(0, autoBundleActivity.countExistingUsesOfBundle(order, new ProductBundleImpl()));
  }

  /**
   * Test {@link AutoBundleActivity#countExistingUsesOfBundle(Order, ProductBundle)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countExistingUsesOfBundle(Order,
   * ProductBundle)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countExistingUsesOfBundle(Order, ProductBundle)"})
  public void testCountExistingUsesOfBundle_givenArrayListAddDiscreteOrderItemImpl() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new DiscreteOrderItemImpl());

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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(0, autoBundleActivity.countExistingUsesOfBundle(order, new ProductBundleImpl()));
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenThrow(new IllegalArgumentException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);

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
    order.setOrderItems(orderItems);

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(mock(DiscreteOrderItemImpl.class));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L));
    verify(discreteOrderItemImpl).getSku();
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_givenDiscreteOrderItemImplGetSkuReturnSkuImpl() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(discreteOrderItemImpl);

    // Act
    int actualPopulateItemMatchesForSkuResult =
        autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L);

    // Assert
    verify(discreteOrderItemImpl).getSku();
    assertEquals(0, actualPopulateItemMatchesForSkuResult);
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertTrue(matchingItems.isEmpty());
    assertTrue(order.getDiscreteOrderItems().isEmpty());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) DiscreteOrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_thenOrderImplDiscreteOrderItemsSizeIsOne() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);

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
    order.setOrderItems(orderItems);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl2.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(discreteOrderItemImpl2);

    // Act
    int actualPopulateItemMatchesForSkuResult =
        autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L);

    // Assert
    verify(skuImpl).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl2).getSku();
    verify(discreteOrderItemImpl2).getQuantity();
    assertEquals(1, order.getDiscreteOrderItems().size());
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, actualPopulateItemMatchesForSkuResult);
    assertTrue(matchingItems.isEmpty());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_thenReturnOne() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(discreteOrderItemImpl);

    // Act
    int actualPopulateItemMatchesForSkuResult =
        autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L);

    // Assert
    verify(skuImpl).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).getQuantity();
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, actualPopulateItemMatchesForSkuResult);
    assertTrue(matchingItems.isEmpty());
    assertTrue(order.getDiscreteOrderItems().isEmpty());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_thenReturnTwo() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl);

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
    order.setOrderItems(orderItems);

    SkuImpl skuImpl2 = mock(SkuImpl.class);
    when(skuImpl2.getId()).thenReturn(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl2.getSku()).thenReturn(skuImpl2);

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(discreteOrderItemImpl2);

    // Act
    int actualPopulateItemMatchesForSkuResult =
        autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L);

    // Assert
    verify(skuImpl).getId();
    verify(skuImpl2).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl2).getSku();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl2).getQuantity();
    assertEquals(1, matchingItems.size());
    assertEquals(2, actualPopulateItemMatchesForSkuResult);
    assertEquals(matchingItems, order.getDiscreteOrderItems());
    assertSame(orderItems, order.getOrderItems());
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_thenReturnZero() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(
        0,
        autoBundleActivity.populateItemMatchesForSku(matchingItems, order, new ArrayList<>(), 1L));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertTrue(matchingItems.isEmpty());
    assertTrue(order.getDiscreteOrderItems().isEmpty());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.getId()).thenReturn(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException());
    when(discreteOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<DiscreteOrderItem> unbundledItems = new ArrayList<>();
    unbundledItems.add(discreteOrderItemImpl);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            autoBundleActivity.populateItemMatchesForSku(matchingItems, order, unbundledItems, 1L));
    verify(skuImpl).getId();
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List, Long)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#populateItemMatchesForSku(List, Order, List,
   * Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.populateItemMatchesForSku(List, Order, List, Long)"})
  public void testPopulateItemMatchesForSku_whenNull_thenReturnZero() {
    // Arrange
    ArrayList<DiscreteOrderItem> matchingItems = new ArrayList<>();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setOrderItems(orderItems);

    // Act and Assert
    assertEquals(0, autoBundleActivity.populateItemMatchesForSku(matchingItems, order, null, 1L));
    List<OrderItem> orderItems2 = order.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertTrue(matchingItems.isEmpty());
    assertTrue(order.getDiscreteOrderItems().isEmpty());
    assertSame(orderItems, orderItems2);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProductBundle()).thenReturn(new ProductBundleImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>());

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).getProductBundle();
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications2() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProductBundle()).thenThrow(new IllegalArgumentException());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>()));
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl).getProductBundle();
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications3() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAutoBundle()).thenThrow(new IllegalArgumentException());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getProductBundle()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>()));
    verify(productBundleImpl).getAutoBundle();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).getProductBundle();
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications4() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAutoBundle()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenThrow(new IllegalArgumentException());
    when(bundleOrderItemImpl.getProductBundle()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>()));
    verify(productBundleImpl).getAutoBundle();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).getProductBundle();
    verify(bundleOrderItemImpl).getId();
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_givenArrayListAddBundleOrderItemImpl_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>());

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_givenOrderItemImplAuditableIsAuditable() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItemImpl.setPrice(new Money());
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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>());

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link HashSet#HashSet()} add zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_givenZero_whenHashSetAddZero_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    HashSet<Long> processedBundles = new HashSet<>();
    processedBundles.add(0L);
    processedBundles.add(1L);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, processedBundles);

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_thenCallsGetDiscreteOrderItems() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAutoBundle()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getProductBundle()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>());

    // Assert
    verify(productBundleImpl).getAutoBundle();
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl, atLeast(1)).getProductBundle();
    verify(bundleOrderItemImpl).getId();
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_thenCallsGetId() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getAutoBundle()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getProductBundle()).thenReturn(productBundleImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

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
    order.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    HashSet<Long> processedBundles = new HashSet<>();
    processedBundles.add(1L);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, processedBundles);

    // Assert
    verify(productBundleImpl).getAutoBundle();
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    verify(bundleOrderItemImpl, atLeast(1)).getProductBundle();
    verify(bundleOrderItemImpl).getId();
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, new HashSet<>());

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link AutoBundleActivity#countMaximumApplications(Order, SkuBundleItem,
   * Set)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AutoBundleActivity.countMaximumApplications(Order, SkuBundleItem, Set)"})
  public void testCountMaximumApplications_whenHashSetAddOne_thenReturnZero() {
    // Arrange
    AutoBundleActivity autoBundleActivity = new AutoBundleActivity();

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

    SkuBundleItemImpl skuBundleItem = mock(SkuBundleItemImpl.class);
    when(skuBundleItem.getQuantity()).thenReturn(1);
    when(skuBundleItem.getSku()).thenReturn(new SkuImpl());
    doNothing().when(skuBundleItem).setSku(Mockito.<Sku>any());
    skuBundleItem.setSku(null);

    HashSet<Long> processedBundles = new HashSet<>();
    processedBundles.add(1L);

    // Act
    int actualCountMaximumApplicationsResult =
        autoBundleActivity.countMaximumApplications(order, skuBundleItem, processedBundles);

    // Assert
    verify(skuBundleItem).getQuantity();
    verify(skuBundleItem).getSku();
    verify(skuBundleItem).setSku(isNull());
    assertEquals(0, actualCountMaximumApplicationsResult);
  }

  /**
   * Test new {@link AutoBundleActivity} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link AutoBundleActivity}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AutoBundleActivity.<init>()"})
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
