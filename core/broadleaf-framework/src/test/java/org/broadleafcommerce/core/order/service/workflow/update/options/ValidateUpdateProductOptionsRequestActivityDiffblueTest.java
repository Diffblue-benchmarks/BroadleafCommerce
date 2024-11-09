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
package org.broadleafcommerce.core.order.service.workflow.update.options;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Test;

public class ValidateUpdateProductOptionsRequestActivityDiffblueTest {
  /**
   * Test
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Given {@link OrderItemRequestDTO#OrderItemRequestDTO()} OrderItemId is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_givenOrderItemRequestDTOOrderItemIdIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity = new ValidateUpdateProductOptionsRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(null);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity = new ValidateUpdateProductOptionsRequestActivity();

    OrderItemRequestDTO itemRequest = new OrderItemRequestDTO();
    itemRequest.setOrderItemId(1L);
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setItemRequest(itemRequest);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> validateUpdateProductOptionsRequestActivity.execute((ProcessContext<CartOperationRequest>) context));
  }
}
