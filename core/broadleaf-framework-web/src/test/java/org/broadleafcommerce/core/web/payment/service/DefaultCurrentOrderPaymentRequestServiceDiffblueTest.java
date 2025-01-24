package org.broadleafcommerce.core.web.payment.service;

import org.broadleafcommerce.common.vendor.service.exception.PaymentException;
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
class DefaultCurrentOrderPaymentRequestServiceDiffblueTest {
  @Autowired
  private DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#getPaymentRequestFromCurrentOrder()}
   */
  @Test
  @DisplayName("Test getPaymentRequestFromCurrentOrder()")
  @Disabled("TODO: Complete this test")
  void testGetPaymentRequestFromCurrentOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9730 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).getPaymentRequestFromCurrentOrder();
  }

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#addOrderAttributeToCurrentOrder(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#addOrderAttributeToCurrentOrder(String, String)}
   */
  @Test
  @DisplayName("Test addOrderAttributeToCurrentOrder(String, String)")
  @Disabled("TODO: Complete this test")
  void testAddOrderAttributeToCurrentOrder() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9694 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).addOrderAttributeToCurrentOrder("Order Attribute Key", "42");
  }

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#addOrderAttributeToOrder(Long, String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#addOrderAttributeToOrder(Long, String, String)}
   */
  @Test
  @DisplayName("Test addOrderAttributeToOrder(Long, String, String)")
  @Disabled("TODO: Complete this test")
  void testAddOrderAttributeToOrder() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9705 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).addOrderAttributeToOrder(1L, "Order Attribute Key", "42");
  }

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#logWarningIfCartMismatch(Long, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#logWarningIfCartMismatch(Long, Long)}
   */
  @Test
  @DisplayName("Test logWarningIfCartMismatch(Long, Long)")
  @Disabled("TODO: Complete this test")
  void testLogWarningIfCartMismatch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9733 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).logWarningIfCartMismatch(1L, 1L);
  }

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#retrieveOrderAttributeFromCurrentOrder(String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#retrieveOrderAttributeFromCurrentOrder(String)}
   */
  @Test
  @DisplayName("Test retrieveOrderAttributeFromCurrentOrder(String)")
  @Disabled("TODO: Complete this test")
  void testRetrieveOrderAttributeFromCurrentOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9764 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).retrieveOrderAttributeFromCurrentOrder("Order Attribute Key");
  }

  /**
   * Test
   * {@link DefaultCurrentOrderPaymentRequestService#retrieveOrderAttributeFromOrder(Long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentOrderPaymentRequestService#retrieveOrderAttributeFromOrder(Long, String)}
   */
  @Test
  @DisplayName("Test retrieveOrderAttributeFromOrder(Long, String)")
  @Disabled("TODO: Complete this test")
  void testRetrieveOrderAttributeFromOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9851 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentOrderPaymentRequestService defaultCurrentOrderPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentOrderPaymentRequestService()).retrieveOrderAttributeFromOrder(1L, "Order Attribute Key");
  }
}
