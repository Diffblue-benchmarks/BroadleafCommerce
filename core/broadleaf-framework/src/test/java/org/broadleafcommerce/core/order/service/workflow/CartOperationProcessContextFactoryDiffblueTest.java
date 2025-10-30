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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.WorkflowException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CartOperationProcessContextFactoryDiffblueTest {
  /**
   * Test {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)} with {@code CartOperationRequest}.
   * <p>
   * Method under test: {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessContext CartOperationProcessContextFactory.createContext(CartOperationRequest)"})
  public void testCreateContextWithCartOperationRequest() throws WorkflowException {
    // Arrange
    CartOperationProcessContextFactory cartOperationProcessContextFactory = new CartOperationProcessContextFactory();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest seedData = new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    ProcessContext<CartOperationRequest> actualCreateContextResult = cartOperationProcessContextFactory
        .createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(
        ((DefaultProcessContextImpl<CartOperationRequest>) actualCreateContextResult).getActivityMessages().isEmpty());
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }
}
