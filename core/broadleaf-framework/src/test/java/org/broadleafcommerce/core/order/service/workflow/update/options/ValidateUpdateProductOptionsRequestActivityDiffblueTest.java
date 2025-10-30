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
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.OrderItemService;
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
public class ValidateUpdateProductOptionsRequestActivityDiffblueTest {
  @InjectMocks
  private ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity;

  @Mock
  private OrderItemService orderItemService;

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} OrderItemId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemRequestDTOOrderItemIdIsNull() throws Exception {
    // Arrange
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(null);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateUpdateProductOptionsRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return {@link BundleOrderItemImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnBundleOrderItemImpl() throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateUpdateProductOptionsRequestActivity
        .execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"})
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnNull() throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateUpdateProductOptionsRequestActivity
        .execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(eq(1L));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link DiscreteOrderItemImpl#getBundleOrderItem()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenCallsGetBundleOrderItem() throws Exception {
    // Arrange
    DiscreteOrderItemImpl discreteOrderItemImpl = mock(DiscreteOrderItemImpl.class);
    when(discreteOrderItemImpl.getBundleOrderItem()).thenReturn(new BundleOrderItemImpl());
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(discreteOrderItemImpl);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = validateUpdateProductOptionsRequestActivity
        .execute(context);

    // Assert
    verify(discreteOrderItemImpl).getBundleOrderItem();
    verify(orderItemService).readOrderItemById(eq(1L));
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"})
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateUpdateProductOptionsRequestActivity.execute(context));
  }
}
