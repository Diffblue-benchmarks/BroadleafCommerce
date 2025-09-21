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
package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import java.util.List;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrency;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.ContextualInventoryService;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
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
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
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
public class ValidateAvailabilityActivityDiffblueTest {
  @Mock private ContextualInventoryService contextualInventoryService;

  @InjectMocks private ValidateAvailabilityActivity validateAvailabilityActivity;

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(skuImpl).isActive();
    verify(contextualInventoryService)
        .checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(1));
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getQuantity()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplGetQuantityThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenThrow(new IllegalArgumentException());
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(skuImpl).isActive();
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).getQuantity();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} return {@link
   *       SkuImpl} (default constructor).
   *   <li>Then calls {@link BundleOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplGetSkuReturnSkuImpl_thenCallsGetSku()
      throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenReturn(new SkuImpl());

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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} {@link BundleOrderItemImpl#getSku()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenBundleOrderItemImplGetSkuThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getSku()).thenThrow(new IllegalArgumentException());

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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(bundleOrderItemImpl).getSku();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link Order#getOrderItems()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetOrderItems() throws Exception {
    // Arrange
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException());
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(order).getOrderItems();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getSku()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetSku() throws Exception {
    // Arrange
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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> validateAvailabilityActivity.execute(context));
    verify(discreteOrderItemImpl).getSku();
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    CheckoutSeed checkoutSeed = new CheckoutSeed(null, new HashMap<>());
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateAvailabilityActivity.execute(context);

    // Assert
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData Order OrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderOrderItemsSizeIsOne() throws Exception {
    // Arrange
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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateAvailabilityActivity.execute(context);

    // Assert
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<OrderItem> orderItems2 = order2.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertEquals(1, order2.getItemCount());
    assertEquals(orderItems, order2.getNonDiscreteOrderItems());
    assertSame(orderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order Currency return {@link BroadleafCurrencyImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderCurrencyReturnBroadleafCurrencyImpl() throws Exception {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    SkuImpl skuImpl = mock(SkuImpl.class);
    when(skuImpl.isActive()).thenReturn(true);

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getQuantity()).thenReturn(1);
    when(bundleOrderItemImpl.getSku()).thenReturn(skuImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(bundleOrderItemImpl);

    OrderImpl order = new OrderImpl();
    order.setAdditionalOfferInformation(new HashMap<>());
    order.setAuditable(auditable);
    order.setCandidateOrderOffers(new ArrayList<>());
    BroadleafCurrencyImpl currency = new BroadleafCurrencyImpl();
    order.setCurrency(currency);
    CustomerImpl customer = new CustomerImpl();
    order.setCustomer(customer);
    order.setEmailAddress("42 Main St");
    order.setFulfillmentGroups(new ArrayList<>());
    order.setId(1L);
    LocaleImpl locale = new LocaleImpl();
    order.setLocale(locale);
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
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateAvailabilityActivity.execute(context);

    // Assert
    verify(skuImpl).isActive();
    verify(contextualInventoryService)
        .checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(1));
    verify(bundleOrderItemImpl).getSku();
    verify(bundleOrderItemImpl).getQuantity();
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    BroadleafCurrency currency2 = order2.getCurrency();
    assertTrue(currency2 instanceof BroadleafCurrencyImpl);
    Locale locale2 = order2.getLocale();
    assertTrue(locale2 instanceof LocaleImpl);
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    Customer customer2 = order2.getCustomer();
    assertTrue(customer2 instanceof CustomerImpl);
    assertEquals("42 Main St", order2.getEmailAddress());
    assertEquals("42", order2.getOrderNumber());
    assertEquals("42", ((OrderImpl) order2).getMainEntityName());
    assertEquals("Name", order2.getName());
    assertEquals(0, order2.getItemCount());
    assertEquals(1L, order2.getId().longValue());
    assertTrue(order2.getNonDiscreteOrderItems().isEmpty());
    assertTrue(order2.getTaxOverride());
    assertSame(orderItems, order2.getOrderItems());
    assertSame(auditable, order2.getAuditable());
    assertSame(currency, currency2);
    assertSame(locale, locale2);
    assertSame(customer, customer2);
  }

  /**
   * Test {@link ValidateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order return {@link OrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderReturnOrderImpl() throws Exception {
    // Arrange
    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    CheckoutSeed checkoutSeed = new CheckoutSeed(order, new HashMap<>());
    context.setSeedData(checkoutSeed);

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateAvailabilityActivity.execute(context);

    // Assert
    assertTrue(actualExecuteResult.getSeedData().getOrder() instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
  }
}
