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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.junit.Test;

public class PaymentResponseDTOToEntityServiceImplDiffblueTest {
  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_givenAddressDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    verify(responseDTO, atLeast(1)).getBillTo();
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link AddressDTO#addressPopulated()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_whenFalse_thenCallsAddressPopulated() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, false);

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)}
   */
  @Test
  public void testPopulateBillingInfo_whenPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(responseDTO, payment, tempBillingAddress, true);

    // Assert
    assertSame(tempBillingAddress, payment.getBillingAddress());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = mock(PaymentType.class);
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert that nothing has changed
    assertNull(customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link PaymentResponseDTO#getCreditCard()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_givenNull_thenCallsGetCreditCard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn(null);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getResponseMap();
    assertNull(customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentToken is
   * {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_thenCustomerPaymentImplPaymentTokenIsAbc123() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert
    verify(responseDTO, atLeast(1)).getPaymentToken();
    assertEquals("ABC123", customerPayment.getPaymentToken());
  }

  /**
   * Test
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}.
   * <ul>
   *   <li>When {@link PaymentType#PaymentType(String, String)} with {@code Type}
   * and {@code Friendly Type}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)}
   */
  @Test
  public void testPopulateCustomerPaymentToken_whenPaymentTypeWithTypeAndFriendlyType() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl = new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType("Type", "Friendly Type");

    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType,
        new PaymentGatewayType("Type", "Friendly Type"));

    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(responseDTO, customerPayment);

    // Assert that nothing has changed
    assertNull(customerPayment.getPaymentToken());
  }
}
