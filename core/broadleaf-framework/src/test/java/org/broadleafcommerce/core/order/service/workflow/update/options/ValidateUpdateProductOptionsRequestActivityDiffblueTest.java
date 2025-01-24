package org.broadleafcommerce.core.order.service.workflow.update.options;

import static org.junit.Assert.assertThrows;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
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
public class ValidateUpdateProductOptionsRequestActivityDiffblueTest {
  @Autowired
  private ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity;

  /**
   * Test
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link ValidateUpdateProductOptionsRequestActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow.update.options;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass28 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.update.options.ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    ValidateUpdateProductOptionsRequestActivity validateUpdateProductOptionsRequestActivity2 = new ValidateUpdateProductOptionsRequestActivity();

    // Act
    validateUpdateProductOptionsRequestActivity2
        .execute((ProcessContext<CartOperationRequest>) new DefaultProcessContextImpl<>());
  }

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
