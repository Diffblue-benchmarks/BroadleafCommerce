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
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.BundleOrderItem;
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
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.type.OrderItemType;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemoveWorkflowPriceOrderIfNecessaryActivityDiffblueTest {
  @Mock
  private OrderService orderService;

  @InjectMocks
  private RemoveWorkflowPriceOrderIfNecessaryActivity removeWorkflowPriceOrderIfNecessaryActivity;

  @Mock
  private OrderItemService orderItemService;

  /**
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link Auditable} (default constructor) CreatedBy is one.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
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
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
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
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link DiscreteOrderItemImpl} {@link OrderItemImpl#getId()} return one.</li>
   *   <li>Then calls {@link DiscreteOrderItemImpl#setBundleOrderItem(BundleOrderItem)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
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
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
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
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderImpl} (default constructor) addOrderItem {@code null}.</li>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
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
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
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
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} ParentOrderItemId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
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
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
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
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link BundleOrderItemImpl#getDiscreteOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
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
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
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
   * Test {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link ProcessContext}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RemoveWorkflowPriceOrderIfNecessaryActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext RemoveWorkflowPriceOrderIfNecessaryActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnProcessContext() throws Exception {
    // Arrange
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    OrderImpl order = new OrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = removeWorkflowPriceOrderIfNecessaryActivity
        .execute(context);

    // Assert
    verify(orderService).save(isA(Order.class), eq(true));
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }
}
