package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
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
public class DefaultPaymentGatewayCheckoutServiceDiffblueTest {
  @Autowired
  private DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testApplyPaymentToOrder() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1891 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService2 = new DefaultPaymentGatewayCheckoutService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultPaymentGatewayCheckoutService2.applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl());
  }

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link PaymentResponseDTO} {@link PaymentResponseDTO#isValid()}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testApplyPaymentToOrder_givenFalse_whenPaymentResponseDTOIsValidReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultPaymentGatewayCheckoutService
        .applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   *   <li>Then calls {@link PaymentResponseDTO#getOrderId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testApplyPaymentToOrder_givenIllegalArgumentExceptionWithFoo_thenCallsGetOrderId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getOrderId()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getOrderId();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#applyPaymentToOrder(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testApplyPaymentToOrder_givenTrue_whenNull_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultPaymentGatewayCheckoutService.applyPaymentToOrder(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}.
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#handleUnsuccessfulTransaction(OrderPayment)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testHandleUnsuccessfulTransaction() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1928 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService2 = new DefaultPaymentGatewayCheckoutService();

    // Act
    defaultPaymentGatewayCheckoutService2.handleUnsuccessfulTransaction(new OrderPaymentImpl());
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}.
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#markPaymentAsInvalid(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testMarkPaymentAsInvalid() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1989 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultPaymentGatewayCheckoutService()).markPaymentAsInvalid(1L);
  }

  /**
   * Test {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}.
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#initiateCheckout(Long)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testInitiateCheckout() throws Exception {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1945 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange and Act
    (new DefaultPaymentGatewayCheckoutService()).initiateCheckout(1L);
  }

  /**
   * Test
   * {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}.
   * <p>
   * Method under test:
   * {@link DefaultPaymentGatewayCheckoutService#lookupOrderNumberFromOrderId(PaymentResponseDTO)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testLookupOrderNumberFromOrderId() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1961 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService2 = new DefaultPaymentGatewayCheckoutService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    // Act
    defaultPaymentGatewayCheckoutService2.lookupOrderNumberFromOrderId(
        new PaymentResponseDTO(paymentType, new PaymentGatewayType("Type", "Friendly Type")));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DefaultPaymentGatewayCheckoutService#setUseBillingAddressFromGateway(boolean)}
   *   <li>
   * {@link DefaultPaymentGatewayCheckoutService#isUseBillingAddressFromGateway()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    DefaultPaymentGatewayCheckoutService defaultPaymentGatewayCheckoutService = new DefaultPaymentGatewayCheckoutService();

    // Act
    defaultPaymentGatewayCheckoutService.setUseBillingAddressFromGateway(true);

    // Assert that nothing has changed
    assertTrue(defaultPaymentGatewayCheckoutService.isUseBillingAddressFromGateway());
  }
}
