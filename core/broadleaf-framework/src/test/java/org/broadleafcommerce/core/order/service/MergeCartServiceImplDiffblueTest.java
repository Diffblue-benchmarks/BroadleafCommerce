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
package org.broadleafcommerce.core.order.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.extension.ExtensionManager;
import org.broadleafcommerce.common.extension.ExtensionResultStatusType;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.CategoryImpl;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.call.ReconstructCartResponse;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MergeCartServiceImplDiffblueTest {
  @InjectMocks
  private MergeCartServiceImpl mergeCartServiceImpl;

  @Mock
  private OrderService orderService;

  @Mock
  private MergeCartServiceExtensionManager mergeCartServiceExtensionManager;

  /**
   * Test {@link MergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code customer}, {@code anonymousCart}, {@code priceOrder}.
   * <ul>
   *   <li>Then calls {@link OrderService#cancelOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MergeCartResponse MergeCartServiceImpl.mergeCart(Customer, Order, boolean)"})
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenCallsCancelOrder()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), anyBoolean(), anyBoolean())).thenReturn(nullOrderImpl);
    doNothing().when(orderService).cancelOrder(Mockito.<Order>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
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

    // Act
    MergeCartResponse actualMergeCartResult = mergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(orderService).cancelOrder(isA(Order.class));
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(false));
    verify(orderService).save(isA(Order.class), eq(true), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code customer}, {@code anonymousCart}, {@code priceOrder}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MergeCartResponse MergeCartServiceImpl.mergeCart(Customer, Order, boolean)"})
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenCallsGetProxy()
      throws RemoveFromCartException, PricingException {
    // Arrange
    MergeCartServiceExtensionHandler mergeCartServiceExtensionHandler = mock(MergeCartServiceExtensionHandler.class);
    when(mergeCartServiceExtensionHandler.setNewCartOwnership(Mockito.<Order>any(), Mockito.<Customer>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(mergeCartServiceExtensionManager.getProxy()).thenReturn(mergeCartServiceExtensionHandler);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(1L);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), anyBoolean(), anyBoolean())).thenReturn(nullOrderImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(orderImpl2);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
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

    // Act
    MergeCartResponse actualMergeCartResult = mergeCartServiceImpl.mergeCart(customer, anonymousCart, true);

    // Assert
    verify(mergeCartServiceExtensionManager).getProxy();
    verify(mergeCartServiceExtensionHandler).setNewCartOwnership(isA(Order.class), isA(Customer.class));
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(false));
    verify(orderService).save(isA(Order.class), eq(true), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer}, {@code anonymousCart}.
   * <ul>
   *   <li>Then calls {@link OrderService#cancelOrder(Order)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MergeCartResponse MergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenCallsCancelOrder()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), anyBoolean(), anyBoolean())).thenReturn(nullOrderImpl);
    doNothing().when(orderService).cancelOrder(Mockito.<Order>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable2);
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

    // Act
    MergeCartResponse actualMergeCartResult = mergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(orderService).cancelOrder(isA(Order.class));
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(false));
    verify(orderService).save(isA(Order.class), eq(true), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#mergeCart(Customer, Order)} with {@code customer}, {@code anonymousCart}.
   * <ul>
   *   <li>Then calls {@link ExtensionManager#getProxy()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MergeCartResponse MergeCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenCallsGetProxy()
      throws RemoveFromCartException, PricingException {
    // Arrange
    MergeCartServiceExtensionHandler mergeCartServiceExtensionHandler = mock(MergeCartServiceExtensionHandler.class);
    when(mergeCartServiceExtensionHandler.setNewCartOwnership(Mockito.<Order>any(), Mockito.<Customer>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(mergeCartServiceExtensionManager.getProxy()).thenReturn(mergeCartServiceExtensionHandler);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    OrderImpl orderImpl2 = new OrderImpl();
    orderImpl2.setAdditionalOfferInformation(new HashMap<>());
    orderImpl2.setAuditable(auditable2);
    orderImpl2.setCandidateOrderOffers(new ArrayList<>());
    orderImpl2.setCurrency(new BroadleafCurrencyImpl());
    orderImpl2.setCustomer(new CustomerImpl());
    orderImpl2.setEmailAddress("42 Main St");
    orderImpl2.setFulfillmentGroups(new ArrayList<>());
    orderImpl2.setId(1L);
    orderImpl2.setLocale(new LocaleImpl());
    orderImpl2.setName("Name");
    orderImpl2.setOrderAttributes(new HashMap<>());
    orderImpl2.setOrderItems(new ArrayList<>());
    orderImpl2.setOrderMessages(new ArrayList<>());
    orderImpl2.setOrderNumber("42");
    orderImpl2.setPayments(new ArrayList<>());
    orderImpl2.setStatus(OrderStatus.ARCHIVED);
    orderImpl2.setSubTotal(new Money());
    orderImpl2.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl2.setTaxOverride(true);
    orderImpl2.setTotal(new Money());
    orderImpl2.setTotalFulfillmentCharges(new Money());
    orderImpl2.setTotalShipping(new Money());
    orderImpl2.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), anyBoolean(), anyBoolean())).thenReturn(nullOrderImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(orderImpl2);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);
    CustomerImpl customer = new CustomerImpl();

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    OrderImpl anonymousCart = new OrderImpl();
    anonymousCart.setAdditionalOfferInformation(new HashMap<>());
    anonymousCart.setAuditable(auditable3);
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

    // Act
    MergeCartResponse actualMergeCartResult = mergeCartServiceImpl.mergeCart(customer, anonymousCart);

    // Assert
    verify(mergeCartServiceExtensionManager).getProxy();
    verify(mergeCartServiceExtensionHandler).setNewCartOwnership(isA(Order.class), isA(Customer.class));
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(false));
    verify(orderService).save(isA(Order.class), eq(true), eq(true));
    Order order = actualMergeCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertFalse(actualMergeCartResult.isMerged());
    assertTrue(actualMergeCartResult.getAddedItems().isEmpty());
    assertTrue(actualMergeCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code customer}, {@code priceOrder}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReconstructCartResponse MergeCartServiceImpl.reconstructCart(Customer, boolean)"})
  public void testReconstructCartWithCustomerPriceOrder_givenArrayListAddBundleOrderItemImpl()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult = mergeCartServiceImpl.reconstructCart(new CustomerImpl(),
        true);

    // Assert
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#reconstructCart(Customer, boolean)} with {@code customer}, {@code priceOrder}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReconstructCartResponse MergeCartServiceImpl.reconstructCart(Customer, boolean)"})
  public void testReconstructCartWithCustomerPriceOrder_thenOrderReturnNullOrderImpl()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult = mergeCartServiceImpl.reconstructCart(new CustomerImpl(),
        true);

    // Assert
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReconstructCartResponse MergeCartServiceImpl.reconstructCart(Customer)"})
  public void testReconstructCartWithCustomer_givenArrayListAddBundleOrderItemImpl()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
    orderImpl.setOrderAttributes(new HashMap<>());
    orderImpl.setOrderItems(orderItems);
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult = mergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   * <ul>
   *   <li>Then Order return {@link NullOrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReconstructCartResponse MergeCartServiceImpl.reconstructCart(Customer)"})
  public void testReconstructCartWithCustomer_thenOrderReturnNullOrderImpl()
      throws RemoveFromCartException, PricingException {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
    orderImpl.setFulfillmentGroups(new ArrayList<>());
    orderImpl.setId(1L);
    orderImpl.setLocale(new LocaleImpl());
    orderImpl.setName("Name");
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
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(nullOrderImpl);
    when(orderService.findCartForCustomerWithEnhancements(Mockito.<Customer>any())).thenReturn(orderImpl);

    // Act
    ReconstructCartResponse actualReconstructCartResult = mergeCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(orderService).findCartForCustomerWithEnhancements(isA(Customer.class));
    verify(orderService).save(isA(Order.class), eq(true));
    Order order = actualReconstructCartResult.getOrder();
    assertTrue(order instanceof NullOrderImpl);
    assertTrue(actualReconstructCartResult.getRemovedItems().isEmpty());
    assertSame(nullOrderImpl, order);
  }

  /**
   * Test {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Status Type is {@code NAMED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#setSavedCartAttributes(Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeCartServiceImpl.setSavedCartAttributes(Order)"})
  public void testSetSavedCartAttributes_thenOrderImplStatusTypeIsNamed() {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("MMM dd, ''yy");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());

    // Act
    mergeCartServiceImpl.setSavedCartAttributes(cart);

    // Assert
    OrderStatus status = cart.getStatus();
    assertEquals("NAMED", status.getType());
    assertEquals("Named", status.getFriendlyType());
    assertTrue(status.isEditable());
  }

  /**
   * Test {@link MergeCartServiceImpl#setNewCartOwnership(Order, Customer)}.
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Customer is {@link Customer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#setNewCartOwnership(Order, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeCartServiceImpl.setNewCartOwnership(Order, Customer)"})
  public void testSetNewCartOwnership_thenOrderImplCustomerIsCustomer() {
    // Arrange
    MergeCartServiceExtensionHandler mergeCartServiceExtensionHandler = mock(MergeCartServiceExtensionHandler.class);
    when(mergeCartServiceExtensionHandler.setNewCartOwnership(Mockito.<Order>any(), Mockito.<Customer>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(mergeCartServiceExtensionManager.getProxy()).thenReturn(mergeCartServiceExtensionHandler);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("NullOrder does not support any modification operations.");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    Customer customer = mock(Customer.class);
    when(customer.getEmailAddress()).thenReturn("42 Main St");

    // Act
    mergeCartServiceImpl.setNewCartOwnership(cart, customer);

    // Assert
    verify(mergeCartServiceExtensionManager).getProxy();
    verify(mergeCartServiceExtensionHandler).setNewCartOwnership(isA(Order.class), isA(Customer.class));
    verify(customer, atLeast(1)).getEmailAddress();
    assertSame(customer, cart.getCustomer());
  }

  /**
   * Test {@link MergeCartServiceImpl#setNewCartOwnership(Order, Customer)}.
   * <ul>
   *   <li>When {@link CustomerImpl} (default constructor).</li>
   *   <li>Then {@link OrderImpl} (default constructor) Customer {@link CustomerImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#setNewCartOwnership(Order, Customer)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MergeCartServiceImpl.setNewCartOwnership(Order, Customer)"})
  public void testSetNewCartOwnership_whenCustomerImpl_thenOrderImplCustomerCustomerImpl() {
    // Arrange
    MergeCartServiceExtensionHandler mergeCartServiceExtensionHandler = mock(MergeCartServiceExtensionHandler.class);
    when(mergeCartServiceExtensionHandler.setNewCartOwnership(Mockito.<Order>any(), Mockito.<Customer>any()))
        .thenReturn(ExtensionResultStatusType.HANDLED);
    when(mergeCartServiceExtensionManager.getProxy()).thenReturn(mergeCartServiceExtensionHandler);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    CustomerImpl customer = new CustomerImpl();
    cart.setCustomer(customer);
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("NullOrder does not support any modification operations.");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    cart.setPayments(new ArrayList<>());
    cart.setStatus(OrderStatus.ARCHIVED);
    cart.setSubTotal(new Money());
    cart.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalShipping(new Money());
    cart.setTotalTax(new Money());
    CustomerImpl customer2 = new CustomerImpl();

    // Act
    mergeCartServiceImpl.setNewCartOwnership(cart, customer2);

    // Assert
    verify(mergeCartServiceExtensionManager).getProxy();
    verify(mergeCartServiceExtensionHandler).setNewCartOwnership(isA(Order.class), isA(Customer.class));
    Customer customer3 = cart.getCustomer();
    assertTrue(customer3 instanceof CustomerImpl);
    assertEquals(customer, customer3);
    assertSame(customer2, customer3);
  }

  /**
   * Test {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link SkuImpl} {@link SkuImpl#isActive(Product, Category)} return {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeCartServiceImpl.checkActive(DiscreteOrderItem)"})
  public void testCheckActive_givenSkuImplIsActiveReturnTrue_thenReturnTrue() {
    // Arrange
    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive(Mockito.<Product>any(), Mockito.<org.broadleafcommerce.core.catalog.domain.Category>any()))
        .thenReturn(true);
    DiscreteOrderItem orderItem = mock(DiscreteOrderItem.class);
    when(orderItem.getCategory()).thenReturn(new CategoryImpl());
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItem.getSku()).thenReturn(skuImpl);

    // Act
    boolean actualCheckActiveResult = mergeCartServiceImpl.checkActive(orderItem);

    // Assert
    verify(skuImpl).isActive(isA(Product.class), isA(org.broadleafcommerce.core.catalog.domain.Category.class));
    verify(orderItem).getProduct();
    verify(orderItem).getSku();
    verify(orderItem).getCategory();
    assertTrue(actualCheckActiveResult);
  }

  /**
   * Test {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}.
   * <ul>
   *   <li>Given {@link SkuImpl} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkActive(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeCartServiceImpl.checkActive(DiscreteOrderItem)"})
  public void testCheckActive_givenSkuImpl_thenReturnFalse() {
    // Arrange
    DiscreteOrderItem orderItem = mock(DiscreteOrderItem.class);
    when(orderItem.getCategory()).thenReturn(new CategoryImpl());
    when(orderItem.getProduct()).thenReturn(new ProductBundleImpl());
    when(orderItem.getSku()).thenReturn(new SkuImpl());

    // Act
    boolean actualCheckActiveResult = mergeCartServiceImpl.checkActive(orderItem);

    // Assert
    verify(orderItem).getProduct();
    verify(orderItem).getSku();
    verify(orderItem).getCategory();
    assertFalse(actualCheckActiveResult);
  }

  /**
   * Test {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}.
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkInventory(DiscreteOrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeCartServiceImpl.checkInventory(DiscreteOrderItem)"})
  public void testCheckInventory() {
    // Arrange, Act and Assert
    assertTrue(mergeCartServiceImpl.checkInventory(new DiscreteOrderItemImpl()));
  }

  /**
   * Test {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}.
   * <p>
   * Method under test: {@link MergeCartServiceImpl#checkOtherValidity(OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MergeCartServiceImpl.checkOtherValidity(OrderItem)"})
  public void testCheckOtherValidity() {
    // Arrange, Act and Assert
    assertTrue(mergeCartServiceImpl.checkOtherValidity(new BundleOrderItemImpl()));
  }
}
