package org.broadleafcommerce.core.order.service.workflow;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.catalog.domain.SkuImpl;
import org.broadleafcommerce.core.inventory.service.InventoryUnavailableException;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.call.OrderItemRequestDTO;
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
public class AbstractCheckAvailabilityActivityDiffblueTest {
  @Autowired
  private AbstractCheckAvailabilityActivity abstractCheckAvailabilityActivity;

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(new NullOrderImpl());

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertTrue(checkAddAvailabilityActivity.shouldExecute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testShouldExecute2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3520 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AbstractCheckAvailabilityActivity abstractCheckAvailabilityActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();

    // Act
    checkAddAvailabilityActivity
        .shouldExecute((ProcessContext<CartOperationRequest>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Then calls {@link ProcessContext#getSeedData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_thenCallsGetSeedData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    ProcessContext<CartOperationRequest> context = mock(ProcessContext.class);
    NullOrderImpl order = new NullOrderImpl();
    when(context.getSeedData()).thenReturn(new CartOperationRequest(order, new OrderItemRequestDTO(), true));

    // Act
    boolean actualShouldExecuteResult = checkAddAvailabilityActivity.shouldExecute(context);

    // Assert
    verify(context).getSeedData();
    assertTrue(actualShouldExecuteResult);
  }

  /**
   * Test {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#shouldExecute(ProcessContext)}
   */
  @Test
  public void testShouldExecute_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    CartOperationRequest cartOperationRequest = new CartOperationRequest(order, new OrderItemRequestDTO(), true);
    cartOperationRequest.setOrder(null);

    DefaultProcessContextImpl<CartOperationRequest> context = new DefaultProcessContextImpl<>();
    context.setSeedData(cartOperationRequest);

    // Act and Assert
    assertFalse(checkAddAvailabilityActivity.shouldExecute((ProcessContext<CartOperationRequest>) context));
  }

  /**
   * Test
   * {@link AbstractCheckAvailabilityActivity#checkSkuAvailability(Order, Sku, Integer)}.
   * <p>
   * Method under test:
   * {@link AbstractCheckAvailabilityActivity#checkSkuAvailability(Order, Sku, Integer)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCheckSkuAvailability() throws InventoryUnavailableException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3490 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.service.workflow.AbstractCheckAvailabilityActivity abstractCheckAvailabilityActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CheckAddAvailabilityActivity checkAddAvailabilityActivity = new CheckAddAvailabilityActivity();
    NullOrderImpl order = new NullOrderImpl();

    // Act
    checkAddAvailabilityActivity.checkSkuAvailability(order, new SkuImpl(), 1);
  }
}
