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
package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.catalog.domain.ProductBundleImpl;
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
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.call.ConfigurableOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.NonDiscreteOrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CheckUpdateAvailabilityActivityDiffblueTest {
  @InjectMocks private CheckUpdateAvailabilityActivity checkUpdateAvailabilityActivity;

  @Mock private ContextualInventoryService contextualInventoryService;

  @Mock private OrderItemService orderItemService;

  /**
   * Test {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link DiscreteOrderItemImpl#getSku()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckUpdateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenDiscreteOrderItemImplGetSkuReturnNull() throws Exception {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getSku()).thenReturn(null);
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("name");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl2);

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
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(configurableOrderItemRequest);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        checkUpdateAvailabilityActivity.execute(context);

    // Assert
    verify(contextualInventoryService).checkSkuAvailability(isA(Order.class), isNull(), eq(1));
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl2).getSku();
    verify(discreteOrderItemImpl).getChildOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(orderItemService).readOrderItemById(1L);
    verify(cartOperationRequest, atLeast(1)).getItemRequest();
    verify(cartOperationRequest).getOrder();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return
   *       {@link OrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckUpdateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnOrderItemImpl()
      throws Exception {
    // Arrange
    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
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
    orderItemImpl.setPrice(new Money());
    orderItemImpl.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItemImpl.setQuantity(1);
    orderItemImpl.setRetailPrice(new Money());
    orderItemImpl.setRetailPriceOverride(true);
    orderItemImpl.setSalePrice(new Money());
    orderItemImpl.setSalePriceOverride(true);
    orderItemImpl.setTaxable(true);
    orderItemImpl.updateSaleAndRetailPrices();
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(orderItemImpl);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getItemRequest()).thenReturn(new OrderItemRequestDTO());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        checkUpdateAvailabilityActivity.execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(isNull());
    verify(cartOperationRequest, atLeast(1)).getItemRequest();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ContextualInventoryService#checkSkuAvailability(Order, Sku, Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckUpdateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCheckSkuAvailability() throws Exception {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("name");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl2.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(discreteOrderItemImpl2);

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
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(configurableOrderItemRequest);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        checkUpdateAvailabilityActivity.execute(context);

    // Assert
    verify(contextualInventoryService)
        .checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(2));
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl2).getSku();
    verify(discreteOrderItemImpl).getChildOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl2).getQuantity();
    verify(orderItemService).readOrderItemById(1L);
    verify(cartOperationRequest, atLeast(1)).getItemRequest();
    verify(cartOperationRequest).getOrder();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link ContextualInventoryService#checkSkuAvailability(Order, Sku, Integer)}.
   * </ul>
   *
   * <p>Method under test: {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckUpdateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsCheckSkuAvailability2() throws Exception {
    // Arrange
    doNothing()
        .when(contextualInventoryService)
        .checkSkuAvailability(Mockito.<Order>any(), Mockito.<Sku>any(), Mockito.<Integer>any());

    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(discreteOrderItemImpl.getSku()).thenReturn(new SkuImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);

    ConfigurableOrderItemRequest configurableOrderItemRequest = new ConfigurableOrderItemRequest();
    configurableOrderItemRequest.setAdditionalAttributes(new HashMap<>());
    configurableOrderItemRequest.setCategoryId(1L);
    configurableOrderItemRequest.setChildOrderItems(new ArrayList<>());
    configurableOrderItemRequest.setDiscountsAllowed(true);
    configurableOrderItemRequest.setDisplayPrice(new Money());
    configurableOrderItemRequest.setExpandable(true);
    configurableOrderItemRequest.setFirstExpandable(true);
    configurableOrderItemRequest.setHasConfigurationError(true);
    configurableOrderItemRequest.setHasOverridenPrice(true);
    configurableOrderItemRequest.setIsMultiSelect(true);
    configurableOrderItemRequest.setItemAttributes(new HashMap<>());
    configurableOrderItemRequest.setLastExpandable(true);
    configurableOrderItemRequest.setMaxQuantity(3);
    configurableOrderItemRequest.setMinQuantity(1);
    configurableOrderItemRequest.setOrderItemId(1L);
    configurableOrderItemRequest.setOrderItemIndex(1);
    configurableOrderItemRequest.setOverrideRetailPrice(new Money());
    configurableOrderItemRequest.setOverrideSalePrice(new Money());
    configurableOrderItemRequest.setParentOrderItemId(1L);
    configurableOrderItemRequest.setPricingModelType("name");
    configurableOrderItemRequest.setProduct(new ProductBundleImpl());
    configurableOrderItemRequest.setProductChoices(new ArrayList<>());
    configurableOrderItemRequest.setProductId(1L);
    configurableOrderItemRequest.setQuantity(1);
    configurableOrderItemRequest.setSku(new SkuImpl());
    configurableOrderItemRequest.setSkuId(1L);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    DiscreteOrderItemImpl discreteOrderItemImpl2 = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl2.getQuantity()).thenReturn(1);
    when(discreteOrderItemImpl2.getSku()).thenReturn(new SkuImpl());

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());
    orderItems.add(discreteOrderItemImpl2);

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
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getItemRequest()).thenReturn(configurableOrderItemRequest);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        checkUpdateAvailabilityActivity.execute(context);

    // Assert
    verify(contextualInventoryService)
        .checkSkuAvailability(isA(Order.class), isA(Sku.class), eq(2));
    verify(discreteOrderItemImpl).getSku();
    verify(discreteOrderItemImpl2).getSku();
    verify(discreteOrderItemImpl).getChildOrderItems();
    verify(discreteOrderItemImpl).getQuantity();
    verify(discreteOrderItemImpl2).getQuantity();
    verify(orderItemService).readOrderItemById(1L);
    verify(cartOperationRequest, atLeast(1)).getItemRequest();
    verify(cartOperationRequest).getOrder();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl}.
   * </ul>
   *
   * <p>Method under test: {@link CheckUpdateAvailabilityActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext CheckUpdateAvailabilityActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
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
    NullOrderImpl order2 = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order2, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(new NonDiscreteOrderItemRequestDTO());
    cartOperationRequest.setOrder(order);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        checkUpdateAvailabilityActivity.execute(context);

    // Assert
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(cartOperationRequest, actualExecuteResult.getSeedData());
  }
}
