/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2025 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
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
import org.junit.Test;

public class DefaultCustomerPaymentGatewayServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testCreateCustomerPaymentFromResponseDTO5() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testUpdateCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testDeleteCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig2() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig3() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig4() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig5() throws IllegalArgumentException {
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
   * Method under test:
   * {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  public void testValidateResponseAndConfig6() throws IllegalArgumentException {
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
}
