package org.broadleafcommerce.core.order.service.workflow.update;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.OrderItem;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
import org.broadleafcommerce.core.order.service.workflow.CartOperationRequest;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml",
    "/bl-framework-applicationContext-persistence.xml", "/bl-framework-applicationContext-workflow.xml",
    "/bl-framework-applicationContext.xml", "/blc-config/admin/framework/bl-framework-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UpdateOrderMultishipOptionActivityDiffblueTest {
  @Autowired
  private UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity;

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
   * <p>
   * Method under test:
   * {@link UpdateOrderMultishipOptionActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute3() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.update;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4581 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.update.UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    UpdateOrderMultishipOptionActivity updateOrderMultishipOptionActivity2 = new UpdateOrderMultishipOptionActivity();

    // Act
    updateOrderMultishipOptionActivity2
        .execute((ProcessContext<CartOperationRequest>) new DefaultProcessContextImpl<>());
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
