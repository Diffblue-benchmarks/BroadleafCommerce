/*-
 * #%L
 * BroadleafCommerce Framework
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
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
}
