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
package org.broadleafcommerce.core.order.service.workflow.add;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.dao.GenericEntityDao;
import org.broadleafcommerce.core.order.domain.BundleOrderItemImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
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
public class AddOrderItemActivityDiffblueTest {
  @InjectMocks
  private AddOrderItemActivity addOrderItemActivity;

  @Mock
  private GenericEntityDao genericEntityDao;

  @Mock
  private OrderItemService orderItemService;

  /**
   * Test {@link AddOrderItemActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AddOrderItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext AddOrderItemActivity.execute(ProcessContext)"})
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    // Arrange
    doNothing().when(genericEntityDao).persist(Mockito.<Object>any());
    when(orderItemService.buildOrderItemFromDTO(Mockito.<Order>any(), Mockito.<OrderItemRequestDTO>any()))
        .thenReturn(new BundleOrderItemImpl());
    doNothing().when(orderItemService).priceOrderItem(Mockito.<OrderItem>any());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    context.setSeedData(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult = addOrderItemActivity.execute(context);

    // Assert
    verify(genericEntityDao).persist(isA(Object.class));
    verify(orderItemService).buildOrderItemFromDTO(isA(Order.class), isA(OrderItemRequestDTO.class));
    verify(orderItemService).priceOrderItem(isA(OrderItem.class));
    assertSame(context, actualExecuteResult);
  }
}
