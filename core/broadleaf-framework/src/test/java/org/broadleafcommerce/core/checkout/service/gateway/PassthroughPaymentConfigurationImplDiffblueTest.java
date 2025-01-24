package org.broadleafcommerce.core.checkout.service.gateway;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
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
public class PassthroughPaymentConfigurationImplDiffblueTest {
  @Autowired
  private PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#setFailureReportingThreshold(int)}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#setPerformAuthorizeAndCapture(boolean)}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#getFailureReportingThreshold()}
   *   <li>{@link PassthroughPaymentConfigurationImpl#getGatewayType()}
   *   <li>
   * {@link PassthroughPaymentConfigurationImpl#isPerformAuthorizeAndCapture()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl = new PassthroughPaymentConfigurationImpl();

    // Act
    passthroughPaymentConfigurationImpl.setFailureReportingThreshold(1);
    passthroughPaymentConfigurationImpl.setPerformAuthorizeAndCapture(true);
    int actualFailureReportingThreshold = passthroughPaymentConfigurationImpl.getFailureReportingThreshold();
    PaymentGatewayType actualGatewayType = passthroughPaymentConfigurationImpl.getGatewayType();

    // Assert that nothing has changed
    assertEquals(1, actualFailureReportingThreshold);
    assertFalse(passthroughPaymentConfigurationImpl.isPerformAuthorizeAndCapture());
    assertSame(actualGatewayType.PASSTHROUGH, actualGatewayType);
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}
   */
  @Test
  public void testHandlesAuthorize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesAuthorize2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass862 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesAuthorize();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesCapture()}
   */
  @Test
  public void testHandlesCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesCapture()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesCapture2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass868 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesCapture();
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}
   */
  @Test
  public void testHandlesAuthorizeAndCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesAuthorizeAndCapture());
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesAuthorizeAndCapture()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesAuthorizeAndCapture2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass865 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesAuthorizeAndCapture();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}
   */
  @Test
  public void testHandlesReverseAuthorize() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesReverseAuthorize());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesReverseAuthorize()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesReverseAuthorize2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass886 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesReverseAuthorize();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesVoid()}.
   * <p>
   * Method under test: {@link PassthroughPaymentConfigurationImpl#handlesVoid()}
   */
  @Test
  public void testHandlesVoid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesVoid());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesVoid()}.
   * <p>
   * Method under test: {@link PassthroughPaymentConfigurationImpl#handlesVoid()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesVoid2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass892 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesVoid();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRefund()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRefund()}
   */
  @Test
  public void testHandlesRefund() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new PassthroughPaymentConfigurationImpl()).handlesRefund());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRefund()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRefund()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesRefund2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass883 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesRefund();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}
   */
  @Test
  public void testHandlesPartialCapture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesPartialCapture());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesPartialCapture()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesPartialCapture2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass877 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesPartialCapture();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}
   */
  @Test
  public void testHandlesMultipleShipment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesMultipleShipment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultipleShipment()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesMultipleShipment2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass874 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesMultipleShipment();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}
   */
  @Test
  public void testHandlesRecurringPayment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesRecurringPayment());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesRecurringPayment()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesRecurringPayment2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass880 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesRecurringPayment();
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}
   */
  @Test
  public void testHandlesSavedCustomerPayment() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesSavedCustomerPayment());
  }

  /**
   * Test
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesSavedCustomerPayment()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesSavedCustomerPayment2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass889 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesSavedCustomerPayment();
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}
   */
  @Test
  public void testHandlesMultiplePayments() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertFalse((new PassthroughPaymentConfigurationImpl()).handlesMultiplePayments());
  }

  /**
   * Test {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}.
   * <p>
   * Method under test:
   * {@link PassthroughPaymentConfigurationImpl#handlesMultiplePayments()}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandlesMultiplePayments2() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.checkout.service.gateway;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass871 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl passthroughPaymentConfigurationImpl;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new PassthroughPaymentConfigurationImpl()).handlesMultiplePayments();
  }
}
