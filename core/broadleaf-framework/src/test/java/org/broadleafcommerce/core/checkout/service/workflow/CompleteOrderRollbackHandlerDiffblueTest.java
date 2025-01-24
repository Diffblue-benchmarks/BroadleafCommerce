package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.workflow.Activity;
import org.broadleafcommerce.core.workflow.DefaultProcessContextImpl;
import org.broadleafcommerce.core.workflow.ProcessContext;
import org.broadleafcommerce.core.workflow.state.RollbackFailureException;
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
public class CompleteOrderRollbackHandlerDiffblueTest {
  @Autowired
  private CompleteOrderRollbackHandler completeOrderRollbackHandler;

  /**
   * Test
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <p>
   * Method under test:
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testRollbackState() throws RollbackFailureException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1316 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.CompleteOrderRollbackHandler completeOrderRollbackHandler;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CompleteOrderRollbackHandler completeOrderRollbackHandler2 = new CompleteOrderRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());
    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();

    // Act
    completeOrderRollbackHandler2.rollbackState(activity, processContext, new HashMap<>());
  }

  /**
   * Test
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}.
   * <ul>
   *   <li>Then {@link DefaultProcessContextImpl} (default constructor) SeedData
   * Order {@link OrderImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CompleteOrderRollbackHandler#rollbackState(Activity, ProcessContext, Map)}
   */
  @Test
  public void testRollbackState_thenDefaultProcessContextImplSeedDataOrderOrderImpl() throws RollbackFailureException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CompleteOrderRollbackHandler completeOrderRollbackHandler = new CompleteOrderRollbackHandler();
    CommitTaxActivity activity = new CommitTaxActivity(new CommitTaxRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> processContext = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    processContext.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act
    completeOrderRollbackHandler.rollbackState(activity, processContext, new HashMap<>());

    // Assert
    Order order2 = processContext.getSeedData().getOrder();
    assertTrue(order2 instanceof OrderImpl);
    OrderStatus status = order2.getStatus();
    assertEquals("IN_PROCESS", status.getType());
    assertEquals("In Process", status.getFriendlyType());
    assertTrue(status.isEditable());
  }
}
