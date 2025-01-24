package org.broadleafcommerce.core.checkout.service.workflow;

import static org.junit.Assert.assertSame;
import java.util.HashMap;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
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
public class CompleteOrderActivityDiffblueTest {
  @Autowired
  private CompleteOrderActivity completeOrderActivity;

  /**
   * Test {@link CompleteOrderActivity#execute(ProcessContext)}.
   * <p>
   * Method under test: {@link CompleteOrderActivity#execute(ProcessContext)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testExecute() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1300 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.CompleteOrderActivity completeOrderActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CompleteOrderActivity completeOrderActivity2 = new CompleteOrderActivity(new CompleteOrderRollbackHandler());

    // Act
    completeOrderActivity2.execute((ProcessContext<CheckoutSeed>) new DefaultProcessContextImpl<>());
  }

  /**
   * Test {@link CompleteOrderActivity#execute(ProcessContext)}.
   * <ul>
   *   <li>Then return {@link DefaultProcessContextImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link CompleteOrderActivity#execute(ProcessContext)}
   */
  @Test
  public void testExecute_thenReturnDefaultProcessContextImpl() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CompleteOrderActivity completeOrderActivity = new CompleteOrderActivity(new CompleteOrderRollbackHandler());

    DefaultProcessContextImpl<CheckoutSeed> context = new DefaultProcessContextImpl<>();
    OrderImpl order = new OrderImpl();
    context.setSeedData(new CheckoutSeed(order, new HashMap<>()));

    // Act and Assert
    assertSame(context, completeOrderActivity.execute((ProcessContext<CheckoutSeed>) context));
  }

  /**
   * Test {@link CompleteOrderActivity#determineSubmitDate(Order)}.
   * <p>
   * Method under test: {@link CompleteOrderActivity#determineSubmitDate(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineSubmitDate() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1278 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.CompleteOrderActivity completeOrderActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CompleteOrderActivity completeOrderActivity2 = new CompleteOrderActivity(new CompleteOrderRollbackHandler());

    // Act
    completeOrderActivity2.determineSubmitDate(new NullOrderImpl());
  }

  /**
   * Test {@link CompleteOrderActivity#determineOrderNumber(Order)}.
   * <p>
   * Method under test: {@link CompleteOrderActivity#determineOrderNumber(Order)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDetermineOrderNumber() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.workflow;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1256 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.workflow.CompleteOrderActivity completeOrderActivity;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    CompleteOrderActivity completeOrderActivity2 = new CompleteOrderActivity(new CompleteOrderRollbackHandler());

    // Act
    completeOrderActivity2.determineOrderNumber(new NullOrderImpl());
  }

  /**
   * Test {@link CompleteOrderActivity#getCompletedStatus()}.
   * <p>
   * Method under test: {@link CompleteOrderActivity#getCompletedStatus()}
   */
  @Test
  public void testGetCompletedStatus() {
    // Arrange and Act
    OrderStatus actualCompletedStatus = (new CompleteOrderActivity(new CompleteOrderRollbackHandler()))
        .getCompletedStatus();

    // Assert
    assertSame(actualCompletedStatus.SUBMITTED, actualCompletedStatus);
  }
}
