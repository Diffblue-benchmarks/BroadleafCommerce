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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
import org.broadleafcommerce.core.catalog.service.type.ProductOptionValidationStrategyType;
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
import org.broadleafcommerce.core.order.service.exception.RequiredAttributeNotProvidedException;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ValidateProductOptionsActivityDiffblueTest {
  @InjectMocks private ValidateProductOptionsActivity validateProductOptionsActivity;

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

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
        RequiredAttributeNotProvidedException.class,
        () -> validateProductOptionsActivity.execute(context));
    verify(discreteOrderItemImpl).getOrderItemAttributes();
  }

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ProductBundleImpl#getProductOptionXrefs()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetProductOptionXrefs() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ProductBundleImpl productBundleImpl = mock(ProductBundleImpl.class);
    when(productBundleImpl.getProductOptionXrefs())
        .thenThrow(new RequiredAttributeNotProvidedException("Attribute Name"));

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(productBundleImpl);

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
        RequiredAttributeNotProvidedException.class,
        () -> validateProductOptionsActivity.execute(context));
    verify(productBundleImpl).getProductOptionXrefs();
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
  }

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData Order DiscreteOrderItems size is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderDiscreteOrderItemsSizeIsOne() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    DiscreteOrderItemImpl discreteOrderItemImpl = new DiscreteOrderItemImpl();
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

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateProductOptionsActivity.execute(context);

    // Assert
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    List<DiscreteOrderItem> discreteOrderItems = order2.getDiscreteOrderItems();
    assertEquals(1, discreteOrderItems.size());
    DiscreteOrderItem getResult = discreteOrderItems.get(0);
    assertTrue(getResult instanceof DiscreteOrderItemImpl);
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    List<OrderItem> orderItems2 = order2.getOrderItems();
    assertEquals(1, orderItems2.size());
    assertSame(discreteOrderItemImpl, getResult);
    assertSame(discreteOrderItemImpl, orderItems2.get(0));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData Order ItemCount is one.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderItemCountIsOne() throws Exception {
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
        validateProductOptionsActivity.execute(context);

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
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return SeedData Order ItemCount is zero.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnSeedDataOrderItemCountIsZero() throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getOrderItemAttributes()).thenReturn(new HashMap<>());
    when(discreteOrderItemImpl.getProduct()).thenReturn(new ProductBundleImpl());

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

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateProductOptionsActivity.execute(context);

    // Assert
    verify(discreteOrderItemImpl).getProduct();
    verify(discreteOrderItemImpl).getOrderItemAttributes();
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertEquals(0, order2.getItemCount());
    assertEquals(1, order2.getOrderItems().size());
    assertTrue(order2.getNonDiscreteOrderItems().isEmpty());
    assertEquals(orderItems, order2.getDiscreteOrderItems());
  }

  /**
   * Test {@link ValidateProductOptionsActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order OrderItems first return {@link BundleOrderItemImpl}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext ValidateProductOptionsActivity.execute(ProcessContext)"})
  public void testExecute_thenSeedDataOrderOrderItemsFirstReturnBundleOrderItemImpl()
      throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    BundleOrderItemImpl bundleOrderItemImpl = new BundleOrderItemImpl();
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

    // Act
    ProcessContext<CheckoutSeed> actualExecuteResult =
        validateProductOptionsActivity.execute(context);

    // Assert
    Order order2 = actualExecuteResult.getSeedData().getOrder();
    List<OrderItem> orderItems2 = order2.getOrderItems();
    assertEquals(1, orderItems2.size());
    OrderItem getResult = orderItems2.get(0);
    assertTrue(getResult instanceof BundleOrderItemImpl);
    assertTrue(order2 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(bundleOrderItemImpl, getResult);
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BundleOrderItemImpl} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidateProductOptionsActivity.getOrderItems(Order)"})
  public void testGetOrderItems_givenArrayListAddBundleOrderItemImpl_thenReturnEmpty() {
    // Arrange
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
    assertTrue(validateProductOptionsActivity.getOrderItems(order).isEmpty());
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidateProductOptionsActivity.getOrderItems(Order)"})
  public void testGetOrderItems_givenArrayListAddDiscreteOrderItemImpl_thenReturnArrayList() {
    // Arrange
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
    assertEquals(orderItems, validateProductOptionsActivity.getOrderItems(order));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getOrderItems(Order)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default
   *       constructor).
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#getOrderItems(Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List ValidateProductOptionsActivity.getOrderItems(Order)"})
  public void testGetOrderItems_givenOrderItemImplAuditableIsAuditable_thenReturnEmpty() {
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

    // Act and Assert
    assertTrue(validateProductOptionsActivity.getOrderItems(order).isEmpty());
  }

  /**
   * Test {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.shouldValidateWithException(boolean, boolean, boolean, boolean)"
  })
  public void testShouldValidateWithException_whenFalse_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.shouldValidateWithException(false, false, false, false));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.shouldValidateWithException(boolean, boolean, boolean, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.shouldValidateWithException(true, true, false, false));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.shouldValidateWithException(boolean, boolean, boolean, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(validateProductOptionsActivity.shouldValidateWithException(true, true, true, true));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateProductOptionsActivity#shouldValidateWithException(boolean, boolean, boolean, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.shouldValidateWithException(boolean, boolean, boolean, boolean)"
  })
  public void testShouldValidateWithException_whenTrue_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(validateProductOptionsActivity.shouldValidateWithException(true, true, false, true));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_when42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.isMissingRequiredAttribute(true, true, true, true, "42"));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_when42_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.isMissingRequiredAttribute(true, true, false, true, "42"));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_when42_thenReturnFalse3() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.isMissingRequiredAttribute(true, true, false, false, "42"));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_whenEmptyString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(
        validateProductOptionsActivity.isMissingRequiredAttribute(false, false, false, false, ""));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        validateProductOptionsActivity.isMissingRequiredAttribute(true, true, true, true, ""));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean, boolean,
   * boolean, boolean, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ValidateProductOptionsActivity#isMissingRequiredAttribute(boolean,
   * boolean, boolean, boolean, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ValidateProductOptionsActivity.isMissingRequiredAttribute(boolean, boolean, boolean, boolean, String)"
  })
  public void testIsMissingRequiredAttribute_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        validateProductOptionsActivity.isMissingRequiredAttribute(true, false, false, false, null));
  }

  /**
   * Test {@link ValidateProductOptionsActivity#getProductOptionValidationStrategyType()}.
   *
   * <p>Method under test: {@link
   * ValidateProductOptionsActivity#getProductOptionValidationStrategyType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProductOptionValidationStrategyType ValidateProductOptionsActivity.getProductOptionValidationStrategyType()"
  })
  public void testGetProductOptionValidationStrategyType() {
    // Arrange, Act and Assert
    assertSame(
        ProductOptionValidationStrategyType.SUBMIT_ORDER,
        new ValidateProductOptionsActivity().getProductOptionValidationStrategyType());
  }
}
