/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
package org.broadleafcommerce.core.order.service.workflow.update;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class UpdateOrderMultishipOptionActivityDiffblueTest {
  /**
   * Test {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity = new UpdateOrderMultishipOptionActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItemQuantityDelta(2);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = updateOrderMultishipOptionActivity.execute(context);

    // Assert
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity = new UpdateOrderMultishipOptionActivity();
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(orderItem);
    cartOperationRequest.setOrderItemQuantityDelta(Integer.MIN_VALUE);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = updateOrderMultishipOptionActivity.execute(context);

    // Assert
    verify(orderItem).getOrder();
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }

  /**
   * Test {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItem} {@link OrderItem#getOrder()} return
   * {@link NullOrderImpl} (default constructor).</li>
   *   <li>Then calls {@link OrderItem#getOrder()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenOrderItemGetOrderReturnNullOrderImpl_thenCallsGetOrder() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity = new UpdateOrderMultishipOptionActivity();
    OrderItem orderItem = mock(OrderItem.class);
    when(orderItem.getOrder()).thenReturn(new NullOrderImpl());
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrderItem(orderItem);
    cartOperationRequest.setOrderItemQuantityDelta(-1);
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(cartOperationRequest);

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = updateOrderMultishipOptionActivity.execute(context);

    // Assert
    verify(orderItem).getOrder();
    verify(context).getSeedData();
    assertSame(context, actualExecuteResult);
  }
}
