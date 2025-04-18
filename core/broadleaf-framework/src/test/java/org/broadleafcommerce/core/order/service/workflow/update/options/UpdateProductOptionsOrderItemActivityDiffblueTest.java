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
package org.broadleafcommerce.core.order.service.workflow.update.options;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.OrderItemService;
import org.broadleafcommerce.core.order.service.OrderService;
import org.broadleafcommerce.core.order.service.call.DiscreteOrderItemRequest;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UpdateProductOptionsOrderItemActivityDiffblueTest {
  @Mock
  private OrderItemService orderItemService;

  @Mock
  private OrderService orderService;

  @InjectMocks
  private UpdateProductOptionsOrderItemActivity updateProductOptionsOrderItemActivity;

  /**
   * Test {@link UpdateProductOptionsOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateProductOptionsOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext UpdateProductOptionsOrderItemActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnNull() throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    CartOperationRequest cartOperationRequest = new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = updateProductOptionsOrderItemActivity.execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateProductOptionsOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link OrderItemService#updateDiscreteOrderItem(OrderItem, DiscreteOrderItemRequest)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UpdateProductOptionsOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext UpdateProductOptionsOrderItemActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsUpdateDiscreteOrderItem() throws Exception {
    // Arrange
    when(orderItemService.updateDiscreteOrderItem(Mockito.<OrderItem>any(), Mockito.<DiscreteOrderItemRequest>any()))
        .thenReturn(new BundleOrderItemImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());
    when(orderService.save(Mockito.<Order>any(), Mockito.<Boolean>any())).thenReturn(new NullOrderImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    CartOperationRequest cartOperationRequest = new CartOperationRequest(new NullOrderImpl(), itemRequest, true);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = updateProductOptionsOrderItemActivity.execute(context);

    // Assert
    verify(orderItemService, atLeast(1)).readOrderItemById(eq(1L));
    verify(orderItemService).updateDiscreteOrderItem(isA(OrderItem.class), isA(DiscreteOrderItemRequest.class));
    verify(orderService).save(isA(Order.class), eq(false));
    assertSame(context, actualExecuteResult);
  }
}
