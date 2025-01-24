package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
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
public class DefaultCustomerPaymentGatewayServiceDiffblueTest {
  @Autowired
  private DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testCreateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1705 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService2 = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultCustomerPaymentGatewayService2.createCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_givenIllegalArgumentExceptionWithFoo()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link GatewayCustomerDTO#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_thenCallsGetCustomerId() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenThrow(new IllegalArgumentException("foo"));
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testUpdateCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1819 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService2 = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultCustomerPaymentGatewayService2.updateCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link GatewayCustomerDTO#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO_thenCallsGetCustomerId() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testDeleteCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1735 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService2 = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultCustomerPaymentGatewayService2.deleteCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .deleteCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .deleteCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link GatewayCustomerDTO#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO_thenCallsGetCustomerId() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .deleteCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenThrow(new IllegalArgumentException("foo"));
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testValidateResponseAndConfig2() throws IllegalArgumentException {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1855 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService2 = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultCustomerPaymentGatewayService2.validateResponseAndConfig(responseDTO,
        new PassthroughPaymentConfigurationImpl());
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_givenFalse() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_givenGatewayCustomerDTO() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(new GatewayCustomerDTO<>());
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO}
   * {@link GatewayCustomerDTO#getCustomerId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_givenGatewayCustomerDTOGetCustomerIdReturn42()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.validateResponseAndConfig(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_givenIllegalArgumentExceptionWithFoo() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenThrow(new IllegalArgumentException("foo"));
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.validateResponseAndConfig(responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_whenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.validateResponseAndConfig(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig_whenPaymentTypeWithTypeAndFriendlyType() throws IllegalArgumentException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService = new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test
   * {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Ignore("TODO: Complete this test")
  public void testPopulateCustomerPayment() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Reason: Missing beans when creating Spring context.
    //   Failed to create Spring context due to missing beans
    //   in the current Spring profile:
    //   when running class:
    //   package org.broadleafcommerce.core.payment.service;
    //   @org.springframework.test.context.ContextConfiguration(locations = {"/bl-framework-applicationContext-entity.xml","/bl-framework-applicationContext-persistence.xml","/bl-framework-applicationContext-workflow.xml","/bl-framework-applicationContext.xml","/blc-config/admin/framework/bl-framework-admin-applicationContext.xml","/blc-config/site/framework/bl-framework-applicationContext.xml"})
    //   @org.junit.runner.RunWith(value = org.springframework.test.context.junit4.SpringRunner.class) // if JUnit 4
    //   @org.junit.jupiter.api.extension.ExtendWith(value = org.springframework.test.context.junit.jupiter.SpringExtension.class) // if JUnit 5
    //   public class DiffblueFakeClass1771 {
    //     @org.springframework.beans.factory.annotation.Autowired org.broadleafcommerce.core.payment.service.DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;
    //     @org.junit.Test // if JUnit 4
    //     @org.junit.jupiter.api.Test // if JUnit 5
    //     public void testSpringContextLoads() {}
    //   }
    //   See https://diff.blue/R027 to resolve this issue.

    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService2 = new DefaultCustomerPaymentGatewayService();
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act
    defaultCustomerPaymentGatewayService2.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());
  }
}
