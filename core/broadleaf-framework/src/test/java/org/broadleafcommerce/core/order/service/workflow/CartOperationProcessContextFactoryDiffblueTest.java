package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   * Test {@link CartOperationProcessContextFactory#createContext(CartOperationRequest)} with {@code
   * CartOperationRequest}.
   *
   * <p>Method under test: {@link
   * CartOperationProcessContextFactory#createContext(CartOperationRequest)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessContext CartOperationProcessContextFactory.createContext(CartOperationRequest)"
  })
  public void testCreateContextWithCartOperationRequest() throws WorkflowException {
    // Arrange
    CartOperationProcessContextFactory cartOperationProcessContextFactory =
        new CartOperationProcessContextFactory();
    NullOrderImpl order = new NullOrderImpl();
    CartOperationRequest seedData =
        new CartOperationRequest(order, new OrderItemRequestDTO(), true);

    // Act
    ProcessContext<CartOperationRequest> actualCreateContextResult =
        cartOperationProcessContextFactory.createContext(seedData);

    // Assert
    assertTrue(actualCreateContextResult instanceof DefaultProcessContextImpl);
    assertFalse(actualCreateContextResult.isStopped());
    assertTrue(
        ((DefaultProcessContextImpl<CartOperationRequest>) actualCreateContextResult)
            .getActivityMessages()
            .isEmpty());
    assertSame(seedData, actualCreateContextResult.getSeedData());
  }
}
