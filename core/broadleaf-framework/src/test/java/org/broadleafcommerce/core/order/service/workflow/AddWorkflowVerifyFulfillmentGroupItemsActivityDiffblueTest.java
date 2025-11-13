package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
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
public class AddWorkflowVerifyFulfillmentGroupItemsActivityDiffblueTest {
  @InjectMocks
  private AddWorkflowVerifyFulfillmentGroupItemsActivity
      addWorkflowVerifyFulfillmentGroupItemsActivity;

  @Mock private FulfillmentGroupItemStrategy fulfillmentGroupItemStrategy;

  /**
   * Test {@link AddWorkflowVerifyFulfillmentGroupItemsActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link
   * AddWorkflowVerifyFulfillmentGroupItemsActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext AddWorkflowVerifyFulfillmentGroupItemsActivity.execute(ProcessContext)"
  })
  public void testExecute() throws Exception {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    when(fulfillmentGroupItemStrategy.verify(Mockito.<CartOperationRequest>any()))
        .thenReturn(cartOperationRequest);
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        addWorkflowVerifyFulfillmentGroupItemsActivity.execute(context);

    // Assert
    verify(fulfillmentGroupItemStrategy).verify(isNull());
    assertSame(cartOperationRequest, context.getSeedData());
    assertSame(context, actualExecuteResult);
  }
}
