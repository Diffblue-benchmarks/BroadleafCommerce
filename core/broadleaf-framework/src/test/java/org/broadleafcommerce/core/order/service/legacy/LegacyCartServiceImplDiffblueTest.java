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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.dao.OrderDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.MergeCartService;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.call.MergeCartResponse;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.ReconstructCartResponse;
import org.broadleafcommerce.core.order.service.exception.AddToCartException;
import org.broadleafcommerce.core.order.service.exception.RemoveFromCartException;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.pricing.service.PricingService;
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
public class LegacyCartServiceImplDiffblueTest {
  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @InjectMocks private LegacyCartServiceImpl legacyCartServiceImpl;

  @Mock private MergeCartService mergeCartService;

  @Mock private OrderDao orderDao;

  @Mock private OrderItemService orderItemService;

  @Mock private PricingService pricingService;

  /**
   * Test {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order, boolean)} with {@code
   * namedOrder}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.addAllItemsToCartFromNamedOrder(Order, boolean)"})
  public void testAddAllItemsToCartFromNamedOrderWithNamedOrderPriceOrder()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(new ArrayList<>());
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act
    Order actualAddAllItemsToCartFromNamedOrderResult =
        legacyCartServiceImpl.addAllItemsToCartFromNamedOrder(namedOrder, true);

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualAddAllItemsToCartFromNamedOrderResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order)} with {@code
   * namedOrder}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#addAllItemsToCartFromNamedOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.addAllItemsToCartFromNamedOrder(Order)"})
  public void testAddAllItemsToCartFromNamedOrderWithNamedOrder_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(new ArrayList<>());
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act
    Order actualAddAllItemsToCartFromNamedOrderResult =
        legacyCartServiceImpl.addAllItemsToCartFromNamedOrder(namedOrder);

    // Assert
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualAddAllItemsToCartFromNamedOrderResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order, boolean)} with {@code
   * namedOrder}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Order LegacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(Order, boolean)"
  })
  public void testMoveAllItemsToCartFromNamedOrderWithNamedOrderPriceOrder()
      throws PricingException {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(new ArrayList<>());
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act
    Order actualMoveAllItemsToCartFromNamedOrderResult =
        legacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(namedOrder, true);

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualMoveAllItemsToCartFromNamedOrderResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order)} with {@code
   * namedOrder}.
   *
   * <ul>
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#moveAllItemsToCartFromNamedOrder(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(Order)"})
  public void testMoveAllItemsToCartFromNamedOrderWithNamedOrder_thenReturnNullOrderImpl()
      throws PricingException {
    // Arrange
    doNothing().when(orderDao).delete(Mockito.<Order>any());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.readCartForCustomer(Mockito.<Customer>any())).thenReturn(nullOrderImpl);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl namedOrder = new OrderImpl();
    namedOrder.setAdditionalOfferInformation(new HashMap<>());
    namedOrder.setAuditable(auditable);
    namedOrder.setCandidateOrderOffers(new ArrayList<>());
    namedOrder.setCurrency(new BroadleafCurrencyImpl());
    namedOrder.setCustomer(new CustomerImpl());
    namedOrder.setEmailAddress("42 Main St");
    namedOrder.setFulfillmentGroups(new ArrayList<>());
    namedOrder.setId(1L);
    namedOrder.setLocale(new LocaleImpl());
    namedOrder.setName("Name");
    namedOrder.setOrderAttributes(new HashMap<>());
    namedOrder.setOrderItems(new ArrayList<>());
    namedOrder.setOrderMessages(new ArrayList<>());
    namedOrder.setOrderNumber("42");
    namedOrder.setPayments(new ArrayList<>());
    namedOrder.setStatus(OrderStatus.ARCHIVED);
    namedOrder.setSubTotal(new Money());
    namedOrder.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    namedOrder.setTaxOverride(true);
    namedOrder.setTotal(new Money());
    namedOrder.setTotalFulfillmentCharges(new Money());
    namedOrder.setTotalTax(new Money());

    // Act
    Order actualMoveAllItemsToCartFromNamedOrderResult =
        legacyCartServiceImpl.moveAllItemsToCartFromNamedOrder(namedOrder);

    // Assert
    verify(orderDao).delete(isA(Order.class));
    verify(orderDao).readCartForCustomer(isA(Customer.class));
    assertSame(nullOrderImpl, actualMoveAllItemsToCartFromNamedOrderResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order)} with {@code customer}, {@code
   * anonymousCart}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new RemoveFromCartException("An error occurred"));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl()));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order)} with {@code customer}, {@code
   * anonymousCart}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart2()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl()));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code customer},
   * {@code anonymousCart}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order, boolean)"})
  public void testMergeCartWithCustomerAnonymousCartPriceOrder()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new RemoveFromCartException("An error occurred"));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl(), true));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code customer},
   * {@code anonymousCart}, {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order, boolean)"})
  public void testMergeCartWithCustomerAnonymousCartPriceOrder2()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));
    CustomerImpl customer = new CustomerImpl();

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl(), true));
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)} with {@code customer},
   * {@code anonymousCart}, {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return {@link MergeCartResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order, boolean)"})
  public void testMergeCartWithCustomerAnonymousCartPriceOrder_thenReturnMergeCartResponse()
      throws RemoveFromCartException, PricingException {
    // Arrange
    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenReturn(mergeCartResponse);
    CustomerImpl customer = new CustomerImpl();

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl(), true);

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
    assertSame(mergeCartResponse, actualMergeCartResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#mergeCart(Customer, Order)} with {@code customer}, {@code
   * anonymousCart}.
   *
   * <ul>
   *   <li>Then return {@link MergeCartResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#mergeCart(Customer, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"MergeCartResponse LegacyCartServiceImpl.mergeCart(Customer, Order)"})
  public void testMergeCartWithCustomerAnonymousCart_thenReturnMergeCartResponse()
      throws RemoveFromCartException, PricingException {
    // Arrange
    MergeCartResponse mergeCartResponse = new MergeCartResponse();
    mergeCartResponse.setAddedItems(new ArrayList<>());
    mergeCartResponse.setMerged(true);
    mergeCartResponse.setOrder(new NullOrderImpl());
    mergeCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.mergeCart(Mockito.<Customer>any(), Mockito.<Order>any(), anyBoolean()))
        .thenReturn(mergeCartResponse);
    CustomerImpl customer = new CustomerImpl();

    // Act
    MergeCartResponse actualMergeCartResult =
        legacyCartServiceImpl.mergeCart(customer, new NullOrderImpl());

    // Assert
    verify(mergeCartService).mergeCart(isA(Customer.class), isA(Order.class), eq(true));
    assertSame(mergeCartResponse, actualMergeCartResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer)"})
  public void testReconstructCartWithCustomer() throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenThrow(new RemoveFromCartException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class, () -> legacyCartServiceImpl.reconstructCart(new CustomerImpl()));
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer)"})
  public void testReconstructCartWithCustomer2() throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class, () -> legacyCartServiceImpl.reconstructCart(new CustomerImpl()));
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)} with {@code customer},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenThrow(new RemoveFromCartException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.reconstructCart(new CustomerImpl(), true));
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)} with {@code customer},
   * {@code priceOrder}.
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder2()
      throws RemoveFromCartException, PricingException {
    // Arrange
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(
        PricingException.class,
        () -> legacyCartServiceImpl.reconstructCart(new CustomerImpl(), true));
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)} with {@code customer},
   * {@code priceOrder}.
   *
   * <ul>
   *   <li>Then return {@link ReconstructCartResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer, boolean)"
  })
  public void testReconstructCartWithCustomerPriceOrder_thenReturnReconstructCartResponse()
      throws RemoveFromCartException, PricingException {
    // Arrange
    ReconstructCartResponse reconstructCartResponse = new ReconstructCartResponse();
    reconstructCartResponse.setOrder(new NullOrderImpl());
    reconstructCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenReturn(reconstructCartResponse);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyCartServiceImpl.reconstructCart(new CustomerImpl(), true);

    // Assert
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
    assertSame(reconstructCartResponse, actualReconstructCartResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#reconstructCart(Customer)} with {@code customer}.
   *
   * <ul>
   *   <li>Then return {@link ReconstructCartResponse} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#reconstructCart(Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ReconstructCartResponse LegacyCartServiceImpl.reconstructCart(Customer)"})
  public void testReconstructCartWithCustomer_thenReturnReconstructCartResponse()
      throws RemoveFromCartException, PricingException {
    // Arrange
    ReconstructCartResponse reconstructCartResponse = new ReconstructCartResponse();
    reconstructCartResponse.setOrder(new NullOrderImpl());
    reconstructCartResponse.setRemovedItems(new ArrayList<>());
    when(mergeCartService.reconstructCart(Mockito.<Customer>any(), anyBoolean()))
        .thenReturn(reconstructCartResponse);

    // Act
    ReconstructCartResponse actualReconstructCartResult =
        legacyCartServiceImpl.reconstructCart(new CustomerImpl());

    // Assert
    verify(mergeCartService).reconstructCart(isA(Customer.class), eq(true));
    assertSame(reconstructCartResponse, actualReconstructCartResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}.
   *
   * <ul>
   *   <li>When {@link OrderItemRequestDTO#OrderItemRequestDTO()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#addItem(Long, OrderItemRequestDTO, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.addItem(Long, OrderItemRequestDTO, boolean)"})
  public void testAddItem_whenOrderItemRequestDTO_thenReturnNull() throws AddToCartException {
    // Arrange, Act and Assert
    assertNull(legacyCartServiceImpl.addItem(1L, new OrderItemRequestDTO(), true));
  }

  /**
   * Test {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}.
   *
   * <ul>
   *   <li>Given {@link OrderDao} {@link OrderDao#save(Order)} return {@link NullOrderImpl} (default
   *       constructor).
   *   <li>Then return {@link NullOrderImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem_givenOrderDaoSaveReturnNullOrderImpl_thenReturnNullOrderImpl()
      throws RemoveFromCartException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    NullOrderImpl nullOrderImpl = new NullOrderImpl();
    when(orderDao.save(Mockito.<Order>any())).thenReturn(nullOrderImpl);
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(orderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any())).thenReturn(new NullOrderImpl());

    // Act
    Order actualRemoveItemResult = legacyCartServiceImpl.removeItem(1L, 1L, true);

    // Assert
    verify(orderDao).readOrderById(1L);
    verify(orderDao).save(isA(Order.class));
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
    assertSame(nullOrderImpl, actualRemoveItemResult);
  }

  /**
   * Test {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RemoveFromCartException}.
   * </ul>
   *
   * <p>Method under test: {@link LegacyCartServiceImpl#removeItem(Long, Long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Order LegacyCartServiceImpl.removeItem(Long, Long, boolean)"})
  public void testRemoveItem_thenThrowRemoveFromCartException()
      throws RemoveFromCartException, PricingException {
    // Arrange
    doNothing()
        .when(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(Mockito.<Order>any(), Mockito.<OrderItem>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderImpl.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    orderImpl.setTaxOverride(true);
    orderImpl.setTotal(new Money());
    orderImpl.setTotalFulfillmentCharges(new Money());
    orderImpl.setTotalTax(new Money());
    when(orderDao.readOrderById(Mockito.<Long>any())).thenReturn(orderImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(pricingService.executePricing(Mockito.<Order>any()))
        .thenThrow(new PricingException("An error occurred"));

    // Act and Assert
    assertThrows(
        RemoveFromCartException.class, () -> legacyCartServiceImpl.removeItem(1L, 1L, true));
    verify(orderDao).readOrderById(1L);
    verify(fulfillmentGroupService)
        .removeOrderItemFromFullfillmentGroups(isA(Order.class), isA(OrderItem.class));
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).readOrderItemById(1L);
    verify(pricingService).executePricing(isA(Order.class));
  }
}
