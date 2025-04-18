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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.dao.FulfillmentGroupItemDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItem;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupItem;
import org.broadleafcommerce.core.order.domain.GiftWrapOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.domain.OrderItemImpl;
import org.broadleafcommerce.core.order.domain.PersonalMessageImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderMultishipOptionService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
public class AddWorkflowPriceOrderIfNecessaryActivityDiffblueTest {
  @InjectMocks
  private AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity;

  @Mock
  private FulfillmentGroupItemDao fulfillmentGroupItemDao;

  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderMultishipOptionService orderMultishipOptionService;

  @Mock
  private OrderService orderService;

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_givenAuditableCreatedByIsOne_thenCallsGetDiscreteOrderItems() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

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
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    orderItem.setParentOrderItem(new BundleOrderItemImpl());
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
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
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getId()} return one.</li>
   *   <li>Then calls {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_givenDiscreteOrderItemImplGetIdReturnOne_thenCallsSetBundleOrderItem() throws Exception {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getId()).thenReturn(1L);
    when(discreteOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    doNothing().when(discreteOrderItemImpl).setBundleOrderItem(Mockito.<BundleOrderItem>any());

    ArrayList<DiscreteOrderItem> discreteOrderItemList = new ArrayList<>();
    discreteOrderItemList.add(discreteOrderItemImpl);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(discreteOrderItemList);
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(new BundleOrderItemImpl());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getDiscreteOrderItems();
    verify(discreteOrderItemImpl).setBundleOrderItem(isA(BundleOrderItem.class));
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(discreteOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(discreteOrderItemImpl).getId();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) addOrderItem {@code null}.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderImplAddOrderItemNull_thenCallsGetDiscreteOrderItems() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(null);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).saveOrderItem(isNull());
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} ParentOrderItemId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemRequestDTOParentOrderItemIdIsOne() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(new BundleOrderItemImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setParentOrderItemId(1L);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, itemRequest, true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemService}.</li>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemService_thenReturnProcessContext() throws Exception {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetDiscreteOrderItems() throws Exception {
    // Arrange
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());
    when(orderItemService.saveOrderItem(Mockito.<OrderItem>any())).thenReturn(bundleOrderItemImpl);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderImpl order = new OrderImpl();
    order.addOrderItem(new BundleOrderItemImpl());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(bundleOrderItemImpl, atLeast(1)).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(orderItemService).saveOrderItem(isA(OrderItem.class));
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Given {@link OrderItemImpl} (default constructor) Auditable is {@link Auditable} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AddWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(CartOperationRequest, Order)"})
  public void testUpdateChildOrderItem_givenOrderItemImplAuditableIsAuditable() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(request).getItemRequest();
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AddWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(CartOperationRequest, Order)"})
  public void testUpdateChildOrderItem_thenCallsGetDiscreteOrderItems() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getDiscreteOrderItems()).thenReturn(new ArrayList<>());
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(bundleOrderItemImpl).getDiscreteOrderItems();
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(request).getItemRequest();
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}.
   * <ul>
   *   <li>Then calls {@link CartOperationRequest#getOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#updateChildOrderItem(CartOperationRequest, Order)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AddWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(CartOperationRequest, Order)"})
  public void testUpdateChildOrderItem_thenCallsGetOrderItem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    AddWorkflowPriceOrderIfNecessaryActivity addWorkflowPriceOrderIfNecessaryActivity = new AddWorkflowPriceOrderIfNecessaryActivity();

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(request.getItemRequest()).thenReturn(orderItemRequestDTO);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);
    BundleOrderItemImpl bundleOrderItemImpl = mock(BundleOrderItemImpl.class);
    when(bundleOrderItemImpl.getId()).thenReturn(1L);
    when(bundleOrderItemImpl.getChildOrderItems()).thenReturn(new ArrayList<>());

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
    order.setSubmitDate(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    order.setTaxOverride(true);
    order.setTotal(new Money());
    order.setTotalFulfillmentCharges(new Money());
    order.setTotalTax(new Money());

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.updateChildOrderItem(request, order);

    // Assert
    verify(bundleOrderItemImpl).getChildOrderItems();
    verify(bundleOrderItemImpl).getId();
    verify(request).getItemRequest();
    verify(request).getOrderItem();
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}.
   * <ul>
   *   <li>Then {@link OrderItemImpl} (default constructor) ParentOrderItem {@link BundleOrderItemImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AddWorkflowPriceOrderIfNecessaryActivity.checkAndUpdateChildren(CartOperationRequest, OrderItem)"})
  public void testCheckAndUpdateChildren_thenOrderItemImplParentOrderItemBundleOrderItemImpl() {
    // Arrange
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getItemRequest()).thenReturn(new OrderItemRequestDTO());

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
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItem.setParentOrderItem(parentOrderItem);
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    boolean actualCheckAndUpdateChildrenResult = addWorkflowPriceOrderIfNecessaryActivity
        .checkAndUpdateChildren(request, orderItem);

    // Assert
    verify(request).getItemRequest();
    OrderItem parentOrderItem2 = orderItem.getParentOrderItem();
    assertTrue(parentOrderItem2 instanceof BundleOrderItemImpl);
    assertFalse(actualCheckAndUpdateChildrenResult);
    assertTrue(orderItem.getChildOrderItems().isEmpty());
    assertSame(parentOrderItem, parentOrderItem2);
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#checkAndUpdateChildren(CartOperationRequest, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean AddWorkflowPriceOrderIfNecessaryActivity.checkAndUpdateChildren(CartOperationRequest, OrderItem)"})
  public void testCheckAndUpdateChildren_thenReturnTrue() {
    // Arrange
    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO();
    orderItemRequestDTO.setParentOrderItemId(1L);
    CartOperationRequest request = mock(CartOperationRequest.class);
    when(request.getOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(request.getItemRequest()).thenReturn(orderItemRequestDTO);

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderItemImpl orderItem = new OrderItemImpl();
    orderItem.setAuditable(auditable);
    orderItem.setCandidateItemOffers(new ArrayList<>());
    orderItem.setCartMessages(new ArrayList<>());
    ArrayList<OrderItem> childOrderItems = new ArrayList<>();
    orderItem.setChildOrderItems(childOrderItems);
    orderItem.setDiscountingAllowed(true);
    orderItem.setGiftWrapOrderItem(new GiftWrapOrderItemImpl());
    orderItem.setHasValidationError(true);
    orderItem.setId(1L);
    orderItem.setName("Name");
    orderItem.setOrder(new NullOrderImpl());
    orderItem.setOrderItemAdjustments(new ArrayList<>());
    orderItem.setOrderItemAttributes(new HashMap<>());
    orderItem.setOrderItemPriceDetails(new ArrayList<>());
    orderItem.setOrderItemQualifiers(new ArrayList<>());
    orderItem.setOrderItemType(OrderItemType.BASIC);
    BundleOrderItemImpl parentOrderItem = new BundleOrderItemImpl();
    orderItem.setParentOrderItem(parentOrderItem);
    orderItem.setPersonalMessage(new PersonalMessageImpl());
    orderItem.setPrice(new Money());
    orderItem.setProratedOrderItemAdjustments(new ArrayList<>());
    orderItem.setQuantity(1);
    orderItem.setRetailPrice(new Money());
    orderItem.setRetailPriceOverride(true);
    orderItem.setSalePrice(new Money());
    orderItem.setSalePriceOverride(true);
    orderItem.setTaxable(true);
    orderItem.updateSaleAndRetailPrices();

    // Act
    boolean actualCheckAndUpdateChildrenResult = addWorkflowPriceOrderIfNecessaryActivity
        .checkAndUpdateChildren(request, orderItem);

    // Assert
    verify(request).getItemRequest();
    verify(request).getOrderItem();
    assertTrue(actualCheckAndUpdateChildrenResult);
    assertSame(childOrderItems, orderItem.getChildOrderItems());
    assertSame(parentOrderItem, orderItem.getParentOrderItem());
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link FulfillmentGroupImpl} (default constructor).</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AddWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(Order, Map, OrderItem)"})
  public void testGetOiFgiMap_givenArrayListAddFulfillmentGroupImpl_thenHashMapSizeIsOne() {
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
    order.setTotalTax(new Money());
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    assertEquals(1, oiFgiMap.size());
  }

  /**
   * Test {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then {@link HashMap#HashMap()} size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AddWorkflowPriceOrderIfNecessaryActivity#getOiFgiMap(Order, Map, OrderItem)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AddWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(Order, Map, OrderItem)"})
  public void testGetOiFgiMap_givenAuditableCreatedByIsOne_thenHashMapSizeIsOne() {
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
    order.setTotalTax(new Money());
    HashMap<OrderItem, List<FulfillmentGroupItem>> oiFgiMap = new HashMap<>();

    // Act
    addWorkflowPriceOrderIfNecessaryActivity.getOiFgiMap(order, oiFgiMap, new BundleOrderItemImpl());

    // Assert
    assertEquals(1, oiFgiMap.size());
  }
}
