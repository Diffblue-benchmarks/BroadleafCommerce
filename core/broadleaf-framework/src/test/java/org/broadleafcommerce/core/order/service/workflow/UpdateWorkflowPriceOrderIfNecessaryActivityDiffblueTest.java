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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentOptionImpl;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.FulfillmentGroupStatusType;
import org.broadleafcommerce.core.order.service.type.FulfillmentType;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpdateWorkflowPriceOrderIfNecessaryActivityDiffblueTest {
  @Mock private OrderItemService orderItemService;

  @Mock private OrderService orderService;

  @InjectMocks
  private UpdateWorkflowPriceOrderIfNecessaryActivity updateWorkflowPriceOrderIfNecessaryActivity;

  /**
   * Test {@link UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link DiscreteOrderItemImpl} (default
   *       constructor).
   *   <li>Then calls {@link CartOperationRequest#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext UpdateWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"
  })
  public void testExecute_givenArrayListAddDiscreteOrderItemImpl_thenCallsGetOrderItem()
      throws Exception {
    // Arrange
    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(new DiscreteOrderItemImpl());

    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setParentOrderItem(null);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl2);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(cartOperationRequest.isPriceOrder()).thenReturn(true);
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    when(cartOperationRequest.getItemRequest()).thenReturn(orderItemRequestDTO);
    when(cartOperationRequest.getFgisToDelete()).thenReturn(fulfillmentGroupItemList);
    when(cartOperationRequest.getOisToDelete()).thenReturn(orderItemList);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getMultishipOptionsToDelete()).thenReturn(new ArrayList<>());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        updateWorkflowPriceOrderIfNecessaryActivity.execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(cartOperationRequest, atLeast(1)).getFgisToDelete();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getMultishipOptionsToDelete();
    verify(cartOperationRequest).getOisToDelete();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).getOrderItem();
    verify(cartOperationRequest).isPriceOrder();
    verify(cartOperationRequest).setOrder(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link BundleOrderItemImpl} (default constructor) ParentOrderItem is {@link
   *       BundleOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext UpdateWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"
  })
  public void testExecute_givenBundleOrderItemImplParentOrderItemIsBundleOrderItemImpl()
      throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

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

    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    parentOrderItem.setAuditable(auditable2);
    parentOrderItem.setBaseRetailPrice(new Money());
    parentOrderItem.setBaseSalePrice(new Money());
    parentOrderItem.setBundleOrderItemFeePrices(new ArrayList<>());
    parentOrderItem.setCandidateItemOffers(new ArrayList<>());
    parentOrderItem.setCartMessages(new ArrayList<>());
    parentOrderItem.setChildOrderItems(new ArrayList<>());
    parentOrderItem.setDiscountingAllowed(true);
    parentOrderItem.setDiscreteOrderItems(new ArrayList<>());
    parentOrderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    parentOrderItem.setHasValidationError(true);
    parentOrderItem.setId(1L);
    parentOrderItem.setName("Name");
    parentOrderItem.setOrder(new NullOrderImpl());
    parentOrderItem.setOrderItemAdjustments(new ArrayList<>());
    parentOrderItem.setOrderItemAttributes(new HashMap<>());
    parentOrderItem.setOrderItemPriceDetails(new ArrayList<>());
    parentOrderItem.setOrderItemQualifiers(new ArrayList<>());
    parentOrderItem.setOrderItemType(OrderItemType.BASIC);
    parentOrderItem.setParentOrderItem(new BundleOrderItemImpl());
    parentOrderItem.setPersonalMessage(new PersonalMessageImpl());
    parentOrderItem.setPrice(new Money());
    parentOrderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    parentOrderItem.setQuantity(1);
    parentOrderItem.setRetailPrice(new Money());
    parentOrderItem.setRetailPriceOverride(true);
    parentOrderItem.setSalePrice(new Money());
    parentOrderItem.setSalePriceOverride(true);
    parentOrderItem.setTaxable(true);
    parentOrderItem.updateSaleAndRetailPrices();

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setParentOrderItem(parentOrderItem);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl2);

    Auditable auditable3 = new Auditable();
    auditable3.setCreatedBy(1L);
    auditable3.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable3.setUpdatedBy(1L);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable3);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(cartOperationRequest.isPriceOrder()).thenReturn(true);
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    when(cartOperationRequest.getItemRequest()).thenReturn(orderItemRequestDTO);
    when(cartOperationRequest.getFgisToDelete()).thenReturn(fulfillmentGroupItemList);
    when(cartOperationRequest.getOisToDelete()).thenReturn(orderItemList);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getMultishipOptionsToDelete()).thenReturn(new ArrayList<>());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        updateWorkflowPriceOrderIfNecessaryActivity.execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(cartOperationRequest, atLeast(1)).getFgisToDelete();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getMultishipOptionsToDelete();
    verify(cartOperationRequest).getOisToDelete();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).getOrderItem();
    verify(cartOperationRequest).isPriceOrder();
    verify(cartOperationRequest).setOrder(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} ParentOrderItemId is one.
   *   <li>Then calls {@link CartOperationRequest#getOrderItem()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext UpdateWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"
  })
  public void testExecute_givenOrderItemRequestDTOParentOrderItemIdIsOne_thenCallsGetOrderItem()
      throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setParentOrderItem(null);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl2);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(cartOperationRequest.isPriceOrder()).thenReturn(true);
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    when(cartOperationRequest.getItemRequest()).thenReturn(orderItemRequestDTO);
    when(cartOperationRequest.getFgisToDelete()).thenReturn(fulfillmentGroupItemList);
    when(cartOperationRequest.getOisToDelete()).thenReturn(orderItemList);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getMultishipOptionsToDelete()).thenReturn(new ArrayList<>());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        updateWorkflowPriceOrderIfNecessaryActivity.execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(cartOperationRequest, atLeast(1)).getFgisToDelete();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getMultishipOptionsToDelete();
    verify(cartOperationRequest).getOisToDelete();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).getOrderItem();
    verify(cartOperationRequest).isPriceOrder();
    verify(cartOperationRequest).setOrder(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * UpdateWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext UpdateWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"
  })
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    doNothing().when(orderItemService).delete(Mockito.<OrderItem>any());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any()))
        .thenReturn(new NullOrderImpl());

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItemList = new ArrayList<>();
    fulfillmentGroupItemList.add(new FulfillmentGroupItemImpl());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    BundleOrderItemImpl bundleOrderItemImpl2 = new BundleOrderItemImpl();
    bundleOrderItemImpl2.setAuditable(auditable);
    bundleOrderItemImpl2.setBaseRetailPrice(new Money());
    bundleOrderItemImpl2.setBaseSalePrice(new Money());
    bundleOrderItemImpl2.setBundleOrderItemFeePrices(new ArrayList<>());
    bundleOrderItemImpl2.setCandidateItemOffers(new ArrayList<>());
    bundleOrderItemImpl2.setCartMessages(new ArrayList<>());
    bundleOrderItemImpl2.setChildOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setDiscountingAllowed(true);
    bundleOrderItemImpl2.setDiscreteOrderItems(new ArrayList<>());
    bundleOrderItemImpl2.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    bundleOrderItemImpl2.setHasValidationError(true);
    bundleOrderItemImpl2.setId(1L);
    bundleOrderItemImpl2.setName("Name");
    bundleOrderItemImpl2.setOrder(new NullOrderImpl());
    bundleOrderItemImpl2.setOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemAttributes(new HashMap<>());
    bundleOrderItemImpl2.setOrderItemPriceDetails(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemQualifiers(new ArrayList<>());
    bundleOrderItemImpl2.setOrderItemType(OrderItemType.BASIC);
    bundleOrderItemImpl2.setPersonalMessage(new PersonalMessageImpl());
    bundleOrderItemImpl2.setPrice(new Money());
    bundleOrderItemImpl2.setProratedOrderItemAdjustments(new ArrayList<>());
    bundleOrderItemImpl2.setQuantity(1);
    bundleOrderItemImpl2.setRetailPrice(new Money());
    bundleOrderItemImpl2.setRetailPriceOverride(true);
    bundleOrderItemImpl2.setSalePrice(new Money());
    bundleOrderItemImpl2.setSalePriceOverride(true);
    bundleOrderItemImpl2.setTaxable(true);
    bundleOrderItemImpl2.updateSaleAndRetailPrices();
    bundleOrderItemImpl2.setParentOrderItem(null);

    ArrayList<OrderItem> orderItemList = new ArrayList<>();
    orderItemList.add(bundleOrderItemImpl2);

    Auditable auditable2 = new Auditable();
    auditable2.setCreatedBy(1L);
    auditable2.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable2.setUpdatedBy(1L);

    ArrayList<FulfillmentGroupItem> fulfillmentGroupItems = new ArrayList<>();
    fulfillmentGroupItems.add(new FulfillmentGroupItemImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    fulfillmentGroupImpl.setCandidateFulfillmentGroupOffer(new ArrayList<>());
    fulfillmentGroupImpl.setDeliveryInstruction("Delivery Instruction");
    fulfillmentGroupImpl.setFulfillmentGroupAdjustments(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentGroupFees(new ArrayList<>());
    fulfillmentGroupImpl.setFulfillmentOption(new FulfillmentOptionImpl());
    fulfillmentGroupImpl.setFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setId(1L);
    fulfillmentGroupImpl.setIsShippingPriceTaxable(true);
    fulfillmentGroupImpl.setMerchandiseTotal(new Money());
    fulfillmentGroupImpl.setMethod("Fulfillment Method");
    fulfillmentGroupImpl.setOrder(new NullOrderImpl());
    fulfillmentGroupImpl.setPersonalMessage(new PersonalMessageImpl());
    fulfillmentGroupImpl.setPhone(new PhoneImpl());
    fulfillmentGroupImpl.setPrimary(true);
    fulfillmentGroupImpl.setReferenceNumber("42");
    fulfillmentGroupImpl.setRetailFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSaleFulfillmentPrice(new Money());
    fulfillmentGroupImpl.setSequence(1);
    fulfillmentGroupImpl.setService("Service");
    fulfillmentGroupImpl.setShippingOverride(true);
    fulfillmentGroupImpl.setStatus(FulfillmentGroupStatusType.CANCELLED);
    fulfillmentGroupImpl.setTaxes(new ArrayList<>());
    fulfillmentGroupImpl.setTotal(new Money());
    fulfillmentGroupImpl.setTotalFeeTax(new Money());
    fulfillmentGroupImpl.setTotalFulfillmentGroupTax(new Money());
    fulfillmentGroupImpl.setTotalItemTax(new Money());
    fulfillmentGroupImpl.setTotalTax(new Money());
    fulfillmentGroupImpl.setType(FulfillmentType.DIGITAL);
    fulfillmentGroupImpl.setFulfillmentGroupItems(fulfillmentGroupItems);

    ArrayList<FulfillmentGroup> fulfillmentGroups = new ArrayList<>();
    fulfillmentGroups.add(fulfillmentGroupImpl);

    ArrayList<OrderItem> orderItems = new ArrayList<>();
    orderItems.add(new BundleOrderItemImpl());

    OrderImpl orderImpl = new OrderImpl();
    orderImpl.setAdditionalOfferInformation(new HashMap<>());
    orderImpl.setAuditable(auditable2);
    orderImpl.setCandidateOrderOffers(new ArrayList<>());
    orderImpl.setCurrency(new BroadleafCurrencyImpl());
    orderImpl.setCustomer(new CustomerImpl());
    orderImpl.setEmailAddress("42 Main St");
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
    orderImpl.setFulfillmentGroups(fulfillmentGroups);
    orderImpl.setOrderItems(orderItems);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.isPriceOrder()).thenReturn(true);
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    when(cartOperationRequest.getItemRequest()).thenReturn(new OrderItemRequestDTO());
    when(cartOperationRequest.getFgisToDelete()).thenReturn(fulfillmentGroupItemList);
    when(cartOperationRequest.getOisToDelete()).thenReturn(orderItemList);
    when(cartOperationRequest.getOrder()).thenReturn(orderImpl);
    when(cartOperationRequest.getMultishipOptionsToDelete()).thenReturn(new ArrayList<>());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        updateWorkflowPriceOrderIfNecessaryActivity.execute(context);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).delete(isA(OrderItem.class));
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(cartOperationRequest, atLeast(1)).getFgisToDelete();
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getMultishipOptionsToDelete();
    verify(cartOperationRequest).getOisToDelete();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).isPriceOrder();
    verify(cartOperationRequest).setOrder(isA(Order.class));
    assertSame(context, actualExecuteResult);
  }
}
