package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.common.payment.service.AbstractPaymentGatewayConfiguration;
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
  @Mock private AddressService addressService;

  @Mock private CustomerPaymentService customerPaymentService;

  @Mock private CustomerService customerService;

  @InjectMocks private DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService;

  @Mock private PaymentResponseDTOToEntityService paymentResponseDTOToEntityService;

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId(null);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any()))
        .thenThrow(new IllegalArgumentException());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
    verify(customerService).readCustomerById(42L);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(customerPaymentService)
        .clearDefaultPaymentStatus(Mockito.<Customer>any());
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(customerPaymentService).clearDefaultPaymentStatus(isA(Customer.class));
    verify(customerService).readCustomerById(42L);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO5() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.create()).thenThrow(new IllegalArgumentException());
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.FALSE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(customerPaymentService).create();
    verify(customerService).readCustomerById(42L);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO6() throws IllegalArgumentException {
    // Arrange
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(null);

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualCreateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
            responseDTO, new AbstractPaymentGatewayConfiguration());

    // Assert
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
    verify(customerService).readCustomerById(42L);
    assertNull(actualCreateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO7() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());
    doNothing().when(customerPaymentService).clearDefaultPaymentStatus(Mockito.<Customer>any());
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doThrow(new IllegalArgumentException())
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentType();
    verify(responseDTO, atLeast(1)).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(customerPaymentService).clearDefaultPaymentStatus(isA(Customer.class));
    verify(customerPaymentService).create();
    verify(customerService).readCustomerById(42L);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO_givenFalse()
      throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentResponseDTO#getBillTo()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO_thenCallsGetBillTo()
      throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.create()).thenReturn(new CustomerPaymentImpl());
    doNothing().when(customerPaymentService).clearDefaultPaymentStatus(Mockito.<Customer>any());
    when(customerService.readCustomerById(Mockito.<Long>any())).thenReturn(new CustomerImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.getCustomerId()).thenReturn("42");
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualCreateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(gatewayCustomerDTO, atLeast(1)).getCustomerId();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentType();
    verify(responseDTO, atLeast(1)).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(customerPaymentService).clearDefaultPaymentStatus(isA(Customer.class));
    verify(customerPaymentService).create();
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    verify(customerService).readCustomerById(42L);
    assertNull(actualCreateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#createCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testCreateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>());
    gatewayCustomerDTO.customerId("Customer");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.createCustomerPaymentFromResponseDTO(
                responseDTO, null));
    verify(gatewayCustomerDTO).customerId("Customer");
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId(null);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any())).thenReturn(null);
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new AbstractPaymentGatewayConfiguration());

    // Assert
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO5() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(null);
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO6() throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenThrow(new IllegalArgumentException());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO7() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenThrow(new IllegalArgumentException());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO8() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doThrow(new IllegalArgumentException())
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO9() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(null);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO10() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.creditCardPopulated()).thenReturn(false);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO11() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.creditCardPopulated()).thenThrow(new IllegalArgumentException());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO12() throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    CreditCardDTO<PaymentResponseDTO> creditCardDTO = mock(CreditCardDTO.class);
    when(creditCardDTO.getCreditCardHolderName()).thenThrow(new IllegalArgumentException());
    when(creditCardDTO.creditCardPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(addressDTO).addressPopulated();
    verify(creditCardDTO).creditCardPopulated();
    verify(creditCardDTO).getCreditCardHolderName();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_givenAddressDTO()
      throws IllegalArgumentException {
    // Arrange
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link CreditCardDTO#CreditCardDTO()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_givenCreditCardDTO()
      throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_givenFalse()
      throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link CreditCardDTO#getCreditCardExpDate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_thenCallsGetCreditCardExpDate()
      throws IllegalArgumentException {
    // Arrange
    when(addressService.create()).thenReturn(new AddressImpl());
    when(customerPaymentService.saveCustomerPayment(Mockito.<CustomerPayment>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateAddressInfo(Mockito.<AddressDTO<PaymentResponseDTO>>any(), Mockito.<Address>any());
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

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
    when(responseDTO.getPaymentType()).thenReturn(new PaymentType());
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    when(responseDTO.getCreditCard()).thenReturn(creditCardDTO);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    Long actualUpdateCustomerPaymentFromResponseDTOResult =
        defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
            responseDTO, new PassthroughPaymentConfigurationImpl());

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
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getPaymentType();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(paymentResponseDTOToEntityService)
        .populateAddressInfo(isA(AddressDTO.class), isA(Address.class));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    verify(addressService).create();
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
    verify(customerPaymentService).saveCustomerPayment(isA(CustomerPayment.class));
    assertNull(actualUpdateCustomerPaymentFromResponseDTOResult);
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerPayment#setPaymentGatewayType(PaymentGatewayType)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_thenCallsSetPaymentGatewayType()
      throws IllegalArgumentException {
    // Arrange
    CustomerPayment customerPayment = mock(CustomerPayment.class);
    doThrow(new IllegalArgumentException())
        .when(customerPayment)
        .setPaymentGatewayType(Mockito.<PaymentGatewayType>any());
    when(customerPaymentService.readCustomerPaymentByToken(Mockito.<String>any()))
        .thenReturn(customerPayment);
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("isDefault", Boolean.TRUE.toString());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getResponseMap()).thenReturn(stringStringMap);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getResponseMap();
    verify(responseDTO).isValid();
    verify(customerPayment).setPaymentGatewayType(isA(PaymentGatewayType.class));
    verify(customerPaymentService).readCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#updateCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Long DefaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testUpdateCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.updateCustomerPaymentFromResponseDTO(
                responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO2() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId(null);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO3() throws IllegalArgumentException {
    // Arrange
    doNothing().when(customerPaymentService).deleteCustomerPaymentByToken(Mockito.<String>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
        responseDTO, new AbstractPaymentGatewayConfiguration());

    // Assert
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
    verify(customerPaymentService).deleteCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO4() throws IllegalArgumentException {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(customerPaymentService)
        .deleteCustomerPaymentByToken(Mockito.<String>any());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).isValid();
    verify(customerPaymentService).deleteCustomerPaymentByToken("ABC123");
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO_givenFalse()
      throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testDeleteCustomerPaymentFromResponseDTO_whenNull() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.deleteCustomerPaymentFromResponseDTO(
                responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testValidateResponseAndConfig() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.validateResponseAndConfig(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testValidateResponseAndConfig2() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId("Customer");

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act
    defaultCustomerPaymentGatewayService.validateResponseAndConfig(
        responseDTO, new AbstractPaymentGatewayConfiguration());

    // Assert
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testValidateResponseAndConfig3() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO paymentResponseDTO =
        new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    GatewayCustomerDTO<PaymentResponseDTO> gatewayCustomerDTO =
        new GatewayCustomerDTO<>(paymentResponseDTO);
    gatewayCustomerDTO.customerId(null);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getCustomer()).thenReturn(gatewayCustomerDTO);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.validateResponseAndConfig(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO, atLeast(1)).getCustomer();
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testValidateResponseAndConfig_givenFalse() throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(false);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.validateResponseAndConfig(
                responseDTO, new AbstractPaymentGatewayConfiguration()));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#validateResponseAndConfig(PaymentResponseDTO,
   * PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.validateResponseAndConfig(PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testValidateResponseAndConfig_whenNull_thenThrowIllegalArgumentException()
      throws IllegalArgumentException {
    // Arrange
    DefaultCustomerPaymentGatewayService defaultCustomerPaymentGatewayService =
        new DefaultCustomerPaymentGatewayService();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.isValid()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> defaultCustomerPaymentGatewayService.validateResponseAndConfig(responseDTO, null));
    verify(responseDTO).isValid();
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment,
   * PaymentResponseDTO, PaymentGatewayConfiguration)}.
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment,
   * PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testPopulateCustomerPayment() {
    // Arrange
    doNothing()
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());
    PassthroughPaymentConfigurationImpl config = new PassthroughPaymentConfigurationImpl();

    // Act
    defaultCustomerPaymentGatewayService.populateCustomerPayment(
        customerPayment, responseDTO, config);

    // Assert
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
    PaymentGatewayType paymentGatewayType = PaymentGatewayType.PASSTHROUGH;
    assertSame(paymentGatewayType, config.getGatewayType());
    assertSame(paymentGatewayType, customerPayment.getPaymentGatewayType());
  }

  /**
   * Test {@link DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment,
   * PaymentResponseDTO, PaymentGatewayConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultCustomerPaymentGatewayService#populateCustomerPayment(CustomerPayment,
   * PaymentResponseDTO, PaymentGatewayConfiguration)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultCustomerPaymentGatewayService.populateCustomerPayment(CustomerPayment, PaymentResponseDTO, PaymentGatewayConfiguration)"
  })
  public void testPopulateCustomerPayment_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(
            Mockito.<PaymentResponseDTO>any(), Mockito.<CustomerPayment>any());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            defaultCustomerPaymentGatewayService.populateCustomerPayment(
                customerPayment, responseDTO, new PassthroughPaymentConfigurationImpl()));
    verify(paymentResponseDTOToEntityService)
        .populateCustomerPaymentToken(isA(PaymentResponseDTO.class), isA(CustomerPayment.class));
  }
}
