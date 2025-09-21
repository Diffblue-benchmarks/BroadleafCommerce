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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.DiscreteOrderItemImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
  @Mock private OrderItemService orderItemService;

  @InjectMocks
  private ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity;

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute() throws Exception {
    // Arrange
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(null);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute2() throws Exception {
    // Arrange
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute(context));
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return
   *       {@link DiscreteOrderItemImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnDiscreteOrderItemImpl()
      throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new DiscreteOrderItemImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    OrderImpl order2 = new OrderImpl();
    cartOperationRequest.setOrder(order2);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateUpdateProductOptionsRequestActivity.execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order2, order3);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute_givenOrderItemServiceReadOrderItemByIdReturnNull() throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any())).thenReturn(null);

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    OrderImpl order2 = new OrderImpl();
    cartOperationRequest.setOrder(order2);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateUpdateProductOptionsRequestActivity.execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof OrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order2, order3);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Given {@link OrderItemService} {@link OrderItemService#readOrderItemById(Long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute_givenOrderItemServiceReadOrderItemByIdThrowIllegalArgumentException()
      throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute(context));
    verify(orderItemService).readOrderItemById(1L);
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then calls {@link CartOperationRequest#getItemRequest()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute_thenCallsGetItemRequest() throws Exception {
    // Arrange
    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);

    OrderItemRequestDTO orderItemRequestDTO = new OrderItemRequestDTO(1L, 1);
    orderItemRequestDTO.setOrderItemId(42L);

    CartOperationRequest cartOperationRequest = mock(CartOperationRequest.class);
    when(cartOperationRequest.getOrder()).thenThrow(new IllegalArgumentException());
    when(cartOperationRequest.getItemRequest()).thenReturn(orderItemRequestDTO);
    doNothing().when(cartOperationRequest).setItemRequest(Mockito.<OrderItemRequestDTO>any());
    doNothing().when(cartOperationRequest).setOrder(Mockito.<Order>any());
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute(context));
    verify(cartOperationRequest).getItemRequest();
    verify(cartOperationRequest).getOrder();
    verify(cartOperationRequest).setItemRequest(isA(OrderItemRequestDTO.class));
    verify(cartOperationRequest).setOrder(isA(Order.class));
  }

  /**
   * Test {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   *
   * <ul>
   *   <li>Then SeedData Order return {@link NullOrderImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext ValidateUpdateProductOptionsRequestActivity.execute(ProcessContext)"
  })
  public void testExecute_thenSeedDataOrderReturnNullOrderImpl() throws Exception {
    // Arrange
    when(orderItemService.readOrderItemById(Mockito.<Long>any()))
        .thenReturn(new BundleOrderItemImpl());

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO(1L, 1);
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    NullOrderImpl order2 = new NullOrderImpl();
    cartOperationRequest.setOrder(order2);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        validateUpdateProductOptionsRequestActivity.execute(context);

    // Assert
    verify(orderItemService).readOrderItemById(1L);
    Order order3 = actualExecuteResult.getSeedData().getOrder();
    assertTrue(order3 instanceof NullOrderImpl);
    assertTrue(actualExecuteResult instanceof DefaultProcessContextImpl);
    assertSame(order2, order3);
  }
}
