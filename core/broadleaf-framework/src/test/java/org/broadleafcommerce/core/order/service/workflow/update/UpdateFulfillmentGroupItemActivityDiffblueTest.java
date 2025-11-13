package org.broadleafcommerce.core.order.service.workflow.update;

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
public class UpdateFulfillmentGroupItemActivityDiffblueTest {
  @Mock private FulfillmentGroupItemStrategy fulfillmentGroupItemStrategy;

  @InjectMocks private UpdateFulfillmentGroupItemActivity updateFulfillmentGroupItemActivity;

  /**
   * Test {@link UpdateFulfillmentGroupItemActivity#execute(ProcessContext)}.
   *
   * <p>Method under test: {@link UpdateFulfillmentGroupItemActivity#execute(ProcessContext)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessContext UpdateFulfillmentGroupItemActivity.execute(ProcessContext)"})
  public void testExecute() throws Exception {
    // Arrange
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest cartOperationRequest =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    when(fulfillmentGroupItemStrategy.onItemUpdated(Mockito.<CartOperationRequest>any()))
        .thenReturn(cartOperationRequest);
    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();

    // Act
    ProcessContext<CartOperationRequest> actualExecuteResult =
        updateFulfillmentGroupItemActivity.execute(context);

    // Assert
    verify(fulfillmentGroupItemStrategy).onItemUpdated(isNull());
    assertSame(cartOperationRequest, context.getSeedData());
    assertSame(context, actualExecuteResult);
  }
}
