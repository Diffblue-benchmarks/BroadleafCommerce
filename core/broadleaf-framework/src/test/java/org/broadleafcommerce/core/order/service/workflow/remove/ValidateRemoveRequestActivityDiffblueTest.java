package org.broadleafcommerce.core.order.service.workflow.remove;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
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
public class ValidateRemoveRequestActivityDiffblueTest {
  @Autowired
  private ValidateRemoveRequestActivity validateRemoveRequestActivity;

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity = new ValidateRemoveRequestActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity = new ValidateRemoveRequestActivity();
    OrderItemRequestDTO itemRequest = mock(OrderItemRequestDTO.class);
    when(itemRequest.getOrderItemId()).thenReturn(1L);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(null, itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).getOrderItemId();
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity = new ValidateRemoveRequestActivity();
    OrderItemRequestDTO itemRequest = mock(OrderItemRequestDTO.class);
    when(itemRequest.getOrderItemId()).thenReturn(1L);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(new OrderImpl(), itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).getOrderItemId();
    verify(context).getSeedData();
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute4() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.remove;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass4286 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.remove.ValidateRemoveRequestActivity validateRemoveRequestActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity2 = new ValidateRemoveRequestActivity();

    // Act
    validateRemoveRequestActivity2.execute((ProcessContext<CartOperationRequest>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link ValidateRemoveRequestActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link Order#getOrderItems()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ValidateRemoveRequestActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenCallsGetOrderItems() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ValidateRemoveRequestActivity validateRemoveRequestActivity = new ValidateRemoveRequestActivity();
    Order order = mock(Order.class);
    when(order.getOrderItems()).thenThrow(new IllegalArgumentException("foo"));
    OrderItemRequestDTO itemRequest = mock(OrderItemRequestDTO.class);
    when(itemRequest.getOrderItemId()).thenReturn(1L);
    when(itemRequest.getChildOrderItems()).thenReturn(new ArrayList<>());
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, itemRequest, true));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> validateRemoveRequestActivity.execute(context));
    verify(order).getOrderItems();
    verify(itemRequest).getChildOrderItems();
    verify(itemRequest).getOrderItemId();
    verify(context).getSeedData();
  }
}
