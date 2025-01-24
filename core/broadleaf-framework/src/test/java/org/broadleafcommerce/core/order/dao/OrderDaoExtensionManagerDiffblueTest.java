package org.broadleafcommerce.core.order.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
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
public class OrderDaoExtensionManagerDiffblueTest {
  @Autowired
  private OrderDaoExtensionManager orderDaoExtensionManager;

  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    OrderDaoExtensionManager orderDaoExtensionManager = new OrderDaoExtensionManager();
    orderDaoExtensionManager.registerHandler(mock(AbstractOrderDaoExtensionHandler.class));

    // Act and Assert
    assertTrue(orderDaoExtensionManager.continueOnHandled());
  }

  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   * <p>
   * Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testContinueOnHandled2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.order.dao;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass140 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.order.dao.OrderDaoExtensionManager orderDaoExtensionManager;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderDaoExtensionManager()).continueOnHandled();
  }

  /**
   * Test {@link OrderDaoExtensionManager#continueOnHandled()}.
   * <ul>
   *   <li>Given {@link OrderDaoExtensionManager} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link OrderDaoExtensionManager#continueOnHandled()}
   */
  @Test
  public void testContinueOnHandled_givenOrderDaoExtensionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new OrderDaoExtensionManager()).continueOnHandled());
  }
}
