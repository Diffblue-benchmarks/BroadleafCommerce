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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.PaymentGatewayConfiguration;
import org.broadleafcommerce.core.checkout.service.gateway.PassthroughPaymentConfigurationImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.broadleafcommerce.profile.core.service.CustomerService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DefaultCustomerPaymentGatewayServiceDiffblueTest {
  @InjectMocks
  private DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;

  @Mock
  private CustomerPaymentService customerPaymentService;

  @Mock
  private CustomerService customerService;

  @Mock
  private PaymentResponseDTOToEntityService paymentResponseDTOToEntityService;

  @Mock
  private AddressService addressService;

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(null);
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualCreateCustomerPaymentFromResponseDTOResult = defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
    verify(customerService).readCustomerById(eq(42L));
    assertNull(actualCreateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link Customer#getCustomerPayments()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_thenCallsGetCustomerPayments() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());
    Customer customer = mock(Customer.class);
    when(customer.getCustomerPayments()).thenThrow(new IllegalArgumentException("foo"));
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(customer);
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentType();
    verify(responseDTO, atLeast(1)).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(customer).getCustomerPayments();
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    verify(customerService).readCustomerById(eq(42L));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_thenReturnNull() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualCreateCustomerPaymentFromResponseDTOResult = defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentType();
    verify(responseDTO, atLeast(1)).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    verify(customerService).readCustomerById(eq(42L));
    assertNull(actualCreateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testCreateCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    // Arrange
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .createCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any())).thenReturn(null);
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult = defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
    verify(customerPaymentService).readCustomerPaymentByToken(eq("ABC123"));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link PaymentResponseDTO#getBillTo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_thenCallsGetBillTo() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult = defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(customerPaymentService).readCustomerPaymentByToken(eq("ABC123"));
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link CustomerPayment#setPaymentGatewayType(PaymentGatewayType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_thenCallsSetPaymentGatewayType()
      throws IllegalArgumentException {
    // Arrange
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    doThrow(new IllegalArgumentException("foo")).when(customerPayment)
        .setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any())).thenReturn(customerPayment);
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(gatewayCustomerDTO).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(customerPayment).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(customerPaymentService).readCustomerPaymentByToken(eq("ABC123"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testUpdateCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    // Arrange
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .updateCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testDeleteCustomerPaymentFromResponseDTO_givenFalse() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .deleteCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testDeleteCustomerPaymentFromResponseDTO_givenGatewayCustomerDTO() throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then calls {@link CustomerPaymentService#deleteCustomerPaymentByToken(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testDeleteCustomerPaymentFromResponseDTO_thenCallsDeleteCustomerPaymentByToken()
      throws IllegalArgumentException {
    // Arrange
    doNothing().when(customerPaymentService).deleteCustomerPaymentByToken(Mockito.<String>any());
    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
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
    verify(customerPaymentService).deleteCustomerPaymentByToken(eq("ABC123"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testDeleteCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testDeleteCustomerPaymentFromResponseDTO_whenPaymentTypeWithTypeAndFriendlyType()
      throws IllegalArgumentException {
    // Arrange
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .deleteCustomerPaymentFromResponseDTO(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig() throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig_givenFalse() throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig_givenGatewayCustomerDTO() throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO} {@link GatewayCustomerDTO#getCustomerId()} return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig_givenGatewayCustomerDTOGetCustomerIdReturn42()
      throws IllegalArgumentException {
    // Arrange
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
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig_whenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.validateResponseAndConfig(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type} and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testValidateResponseAndConfig_whenPaymentTypeWithTypeAndFriendlyType() throws IllegalArgumentException {
    // Arrange
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .validateResponseAndConfig(responseDTO, new PassthroughPaymentConfigurationImpl()));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    PassthroughPaymentConfigurationImpl config = new PassthroughPaymentConfigurationImpl();

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO, config);

    // Assert
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    PaymentGatewayType paymentGatewayType = customerPayment.getPaymentGatewayType();
    assertEquals("Passthrough Payment", paymentGatewayType.getFriendlyType());
    assertEquals("Passthrough", paymentGatewayType.getType());
    assertEquals("Type", customerPayment.getPaymentType().getType());
    assertSame(paymentGatewayType, config.getGatewayType());
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment2() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doThrow(new IllegalArgumentException("isDefault")).when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .populateCustomerPayment(customerPayment, responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment3() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardHolderName()).thenThrow(new IllegalArgumentException("isDefault"));
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultCustomerPaymentGatewayService
        .populateCustomerPayment(customerPayment, responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO).getCreditCardHolderName();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardExpDate()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardExpDateReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn(null);
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardExpMonth()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardExpMonthReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn(null);
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardExpYear()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardExpYearReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn(null);
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardHolderName()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardHolderNameReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn(null);
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardLastFour()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardLastFourReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn(null);
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Given {@link CreditCardDTO} {@link CreditCardDTO#getCreditCardType()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_givenCreditCardDTOGetCreditCardTypeReturnNull() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn(null);
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(5, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) AdditionalFields size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_thenCustomerPaymentImplAdditionalFieldsSizeIsSix() {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardExpDate()).thenReturn("2020-03-01");
    when(creditCardDTO.getCreditCardExpMonth()).thenReturn("Credit Card Exp Month");
    when(creditCardDTO.getCreditCardExpYear()).thenReturn("Credit Card Exp Year");
    when(creditCardDTO.getCreditCardHolderName()).thenReturn("Credit Card Holder Name");
    when(creditCardDTO.getCreditCardLastFour()).thenReturn("Credit Card Last Four");
    when(creditCardDTO.getCreditCardType()).thenReturn("Credit Card Type");
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpDate();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpMonth();
    verify(creditCardDTO, atLeast(1)).getCreditCardExpYear();
    verify(creditCardDTO, atLeast(1)).getCreditCardHolderName();
    verify(creditCardDTO, atLeast(1)).getCreditCardLastFour();
    verify(creditCardDTO, atLeast(1)).getCreditCardType();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Map<String, String> additionalFields = customerPayment.getAdditionalFields();
    assertEquals(6, additionalFields.size());
    assertEquals("2020-03-01", additionalFields.get("EXP_DATE"));
    assertEquals("Credit Card Exp Month", additionalFields.get("EXP_MONTH"));
    assertEquals("Credit Card Exp Year", additionalFields.get("EXP_YEAR"));
    assertEquals("Credit Card Holder Name", additionalFields.get("NAME_ON_CARD"));
    assertEquals("Credit Card Last Four", additionalFields.get("LAST_FOUR"));
    assertEquals("Credit Card Type", additionalFields.get("CARD_TYPE"));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) BillingAddress {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_thenCustomerPaymentImplBillingAddressAddressImpl() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.create()).thenReturn(addressImpl);
    doNothing().when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    new IllegalArgumentException("foo");
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType("Type", "Friendly Type"));
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO,
        new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(paymentResponseDTOToEntityService).populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    verify(addressService).create();
    Address billingAddress = customerPayment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertTrue(customerPayment.getAdditionalFields().isEmpty());
    assertSame(addressImpl, billingAddress);
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) BillingAddress is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"})
  public void testPopulateCustomerPayment_thenCustomerPaymentImplBillingAddressIsNull() {
    // Arrange
    doNothing().when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentGatewayType gatewayType = new PaymentGatewayType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, gatewayType);

    PassthroughPaymentConfigurationImpl config = new PassthroughPaymentConfigurationImpl();

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(customerPayment, responseDTO, config);

    // Assert
    verify(paymentResponseDTOToEntityService).populateCustomerPaymentToken(isA(PaymentResponseDTO.class),
        isA(CustomerPayment.class));
    assertNull(customerPayment.getBillingAddress());
    PaymentGatewayType paymentGatewayType = gatewayType.PASSTHROUGH;
    assertSame(paymentGatewayType, config.getGatewayType());
    assertSame(paymentGatewayType, customerPayment.getPaymentGatewayType());
  }
}
