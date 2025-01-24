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
class DefaultCurrentCustomerPaymentRequestServiceDiffblueTest {
  @Autowired
  private DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#getPaymentRequestFromCurrentCustomer()}
   */
  @Test
  @DisplayName("Test getPaymentRequestFromCurrentCustomer()")
  @Disabled("TODO: Complete this test")
  void testGetPaymentRequestFromCurrentCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9598 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService()).getPaymentRequestFromCurrentCustomer();
  }

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#addCustomerAttributeToCurrentCustomer(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#addCustomerAttributeToCurrentCustomer(String, String)}
   */
  @Test
  @DisplayName("Test addCustomerAttributeToCurrentCustomer(String, String)")
  @Disabled("TODO: Complete this test")
  void testAddCustomerAttributeToCurrentCustomer() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9566 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService()).addCustomerAttributeToCurrentCustomer("Customer Attribute Key",
        "42");
  }

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#addCustomerAttributeToCustomer(Long, String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#addCustomerAttributeToCustomer(Long, String, String)}
   */
  @Test
  @DisplayName("Test addCustomerAttributeToCustomer(Long, String, String)")
  @Disabled("TODO: Complete this test")
  void testAddCustomerAttributeToCustomer() throws PaymentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9575 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService()).addCustomerAttributeToCustomer(1L, "Customer Attribute Key",
        "42");
  }

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#retrieveCustomerAttributeFromCurrentCustomer(String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#retrieveCustomerAttributeFromCurrentCustomer(String)}
   */
  @Test
  @DisplayName("Test retrieveCustomerAttributeFromCurrentCustomer(String)")
  @Disabled("TODO: Complete this test")
  void testRetrieveCustomerAttributeFromCurrentCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9632 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService())
        .retrieveCustomerAttributeFromCurrentCustomer("Customer Attribute Key");
  }

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#retrieveCustomerAttributeFromCustomer(Long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#retrieveCustomerAttributeFromCustomer(Long, String)}
   */
  @Test
  @DisplayName("Test retrieveCustomerAttributeFromCustomer(Long, String)")
  @Disabled("TODO: Complete this test")
  void testRetrieveCustomerAttributeFromCustomer() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9674 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService()).retrieveCustomerAttributeFromCustomer(1L,
        "Customer Attribute Key");
  }

  /**
   * Test
   * {@link DefaultCurrentCustomerPaymentRequestService#logWarningIfCustomerMismatch(Long, Long)}.
   * <p>
   * Method under test:
   * {@link DefaultCurrentCustomerPaymentRequestService#logWarningIfCustomerMismatch(Long, Long)}
   */
  @Test
  @DisplayName("Test logWarningIfCustomerMismatch(Long, Long)")
  @Disabled("TODO: Complete this test")
  void testLogWarningIfCustomerMismatch() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.web.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-web-applicationContext.xml","/blc-config/admin/framework/bl-framework-web-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-web-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass9601 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.web.payment.service.DefaultCurrentCustomerPaymentRequestService defaultCurrentCustomerPaymentRequestService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultCurrentCustomerPaymentRequestService()).logWarningIfCustomerMismatch(1L, 1L);
  }
}
