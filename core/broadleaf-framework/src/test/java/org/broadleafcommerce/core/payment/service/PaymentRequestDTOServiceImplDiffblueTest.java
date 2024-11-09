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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.mockito.Mockito;

public class PaymentRequestDTOServiceImplDiffblueTest {
  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.customerId(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO).customerId(eq("1"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.firstName(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO2);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO2).customerId(eq("1"));
    verify(gatewayCustomerDTO).firstName(eq("Jane"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.lastName(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO3);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO3).customerId(eq("1"));
    verify(gatewayCustomerDTO2).firstName(eq("Jane"));
    verify(gatewayCustomerDTO).lastName(eq("Doe"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.email(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO4);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO4).customerId(eq("1"));
    verify(gatewayCustomerDTO).email(eq("42 Main St"));
    verify(gatewayCustomerDTO3).firstName(eq("Jane"));
    verify(gatewayCustomerDTO2).lastName(eq("Doe"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.phone(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO5);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO5).customerId(eq("1"));
    verify(gatewayCustomerDTO2).email(eq("42 Main St"));
    verify(gatewayCustomerDTO4).firstName(eq("Jane"));
    verify(gatewayCustomerDTO3).lastName(eq("Doe"));
    verify(gatewayCustomerDTO).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(new PhoneImpl());

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl).getPhone();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(new GatewayCustomerDTO<>());
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.customerId(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO).customerId(eq("1"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.firstName(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO2);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO2).customerId(eq("1"));
    verify(gatewayCustomerDTO).firstName(eq("Jane"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.lastName(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO3);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO3).customerId(eq("1"));
    verify(gatewayCustomerDTO2).firstName(eq("Jane"));
    verify(gatewayCustomerDTO).lastName(eq("Doe"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.email(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO4);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO4).customerId(eq("1"));
    verify(gatewayCustomerDTO).email(eq("42 Main St"));
    verify(gatewayCustomerDTO3).firstName(eq("Jane"));
    verify(gatewayCustomerDTO2).lastName(eq("Doe"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO.phone(Mockito.<String>any())).thenReturn(new GatewayCustomerDTO<>());
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO5);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO5).customerId(eq("1"));
    verify(gatewayCustomerDTO2).email(eq("42 Main St"));
    verify(gatewayCustomerDTO4).firstName(eq("Jane"));
    verify(gatewayCustomerDTO3).lastName(eq("Doe"));
    verify(gatewayCustomerDTO).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(new PhoneImpl());

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl).getPhone();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   * with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    when(phoneImpl.getPhoneNumber()).thenReturn("6625550144");
    when(phoneImpl.isDefault()).thenReturn(true);
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(phoneImpl);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(eq("6625550144"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl, atLeast(1)).getPhone();
    verify(phoneImpl).getPhoneNumber();
    verify(phoneImpl).isDefault();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <ul>
   *   <li>Given {@link GatewayCustomerDTO#GatewayCustomerDTO()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer_givenGatewayCustomerDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(new GatewayCustomerDTO<>());
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <ul>
   *   <li>Then calls {@link PhoneImpl#getPhoneNumber()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer_thenCallsGetPhoneNumber() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    when(phoneImpl.getPhoneNumber()).thenReturn("6625550144");
    when(phoneImpl.isDefault()).thenReturn(true);
    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(phoneImpl);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(eq("6625550144"));
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl, atLeast(1)).getPhone();
    verify(phoneImpl).getPhoneNumber();
    verify(phoneImpl).isDefault();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   * <ul>
   *   <li>Then return {@link PaymentRequestDTO} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  public void testPopulateCustomerInfoWithRequestDTOCustomer_thenReturnPaymentRequestDTO() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl = new PaymentRequestDTOServiceImpl();
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.done()).thenReturn(paymentRequestDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.phone(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.email(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO5 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO5.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO4);
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO6 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO6.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO5);
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO6);
    Customer customer = mock(Customer.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult = paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO,
        customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId(eq("1"));
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(eq("42 Main St"));
    verify(gatewayCustomerDTO5).firstName(eq("Jane"));
    verify(gatewayCustomerDTO4).lastName(eq("Doe"));
    verify(gatewayCustomerDTO2).phone(isNull());
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }
}
