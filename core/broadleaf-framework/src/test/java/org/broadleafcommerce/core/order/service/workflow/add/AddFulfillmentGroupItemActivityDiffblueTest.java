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
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.order.strategy.FulfillmentGroupItemStrategy;
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
public class AddFulfillmentGroupItemActivityDiffblueTest {
  @InjectMocks private AddFulfillmentGroupItemActivity addFulfillmentGroupItemActivity;

  @Mock private FulfillmentGroupItemStrategy fulfillmentGroupItemStrategy;

  /**
   * Test {@link AddFulfillmentGroupItemActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link AddFulfillmentGroupItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext AddFulfillmentGroupItemActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    when(fulfillmentGroupItemStrategy.onItemAdded(Mockito.<CartOperationRequest>any()))
        .thenReturn(cartOperationRequest);
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        addFulfillmentGroupItemActivity.execute(context);

    // Assert
    verify(fulfillmentGroupItemStrategy).onItemAdded(isNull());
    assertSame(cartOperationRequest, context.getSeedData());
    assertSame(context, actualExecuteResult);
  }
}
