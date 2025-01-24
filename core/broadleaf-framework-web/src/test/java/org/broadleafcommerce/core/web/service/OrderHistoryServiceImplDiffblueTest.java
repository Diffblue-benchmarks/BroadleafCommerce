package org.broadleafcommerce.core.web.service;

import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml",
    "/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml",
    "/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
@ExtendWith(SpringExtension.class)
class OrderHistoryServiceImplDiffblueTest {
  @Autowired
  private OrderHistoryServiceImpl orderHistoryServiceImpl;

  /**
   * Test {@link OrderHistoryServiceImpl#getOrderDetails(String)}.
   * <p>
   * Method under test: {@link OrderHistoryServiceImpl#getOrderDetails(String)}
   */
  @Test
  @DisplayName("Test getOrderDetails(String)")
  @Disabled("TODO: Complete this test")
  void testGetOrderDetails() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3297 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.OrderHistoryServiceImpl orderHistoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderHistoryServiceImpl()).getOrderDetails("42");
  }

  /**
   * Test {@link OrderHistoryServiceImpl#validateCustomerOwnedData(Order)}.
   * <p>
   * Method under test:
   * {@link OrderHistoryServiceImpl#validateCustomerOwnedData(Order)}
   */
  @Test
  @DisplayName("Test validateCustomerOwnedData(Order)")
  @Disabled("TODO: Complete this test")
  void testValidateCustomerOwnedData() throws SecurityException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3383 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.OrderHistoryServiceImpl orderHistoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    OrderHistoryServiceImpl orderHistoryServiceImpl2 = new OrderHistoryServiceImpl();

    // Act
    orderHistoryServiceImpl2.validateCustomerOwnedData(new NullOrderImpl());
  }

  /**
   * Test {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}.
   * <p>
   * Method under test:
   * {@link OrderHistoryServiceImpl#shouldValidateCustomerOwnedData()}
   */
  @Test
  @DisplayName("Test shouldValidateCustomerOwnedData()")
  @Disabled("TODO: Complete this test")
  void testShouldValidateCustomerOwnedData() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass3382 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.service.OrderHistoryServiceImpl orderHistoryServiceImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new OrderHistoryServiceImpl()).shouldValidateCustomerOwnedData();
  }
}
