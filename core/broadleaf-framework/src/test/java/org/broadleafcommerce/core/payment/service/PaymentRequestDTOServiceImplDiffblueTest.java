package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.broadleafcommerce.common.payment.dto.GatewayCustomerDTO;
import org.broadleafcommerce.common.payment.dto.PaymentRequestDTO;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPhone;
import org.broadleafcommerce.profile.core.domain.CustomerPhoneImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {PaymentRequestDTOServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class PaymentRequestDTOServiceImplDiffblueTest {
  @Autowired private PaymentRequestDTOServiceImpl paymentRequestDTOServiceImpl;

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO).customerId("1");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer2() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.firstName(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO2);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO2).customerId("1");
    verify(gatewayCustomerDTO).firstName("Jane");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer3() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.lastName(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO3);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO3).customerId("1");
    verify(gatewayCustomerDTO2).firstName("Jane");
    verify(gatewayCustomerDTO).lastName("Doe");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer4() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.email(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO4);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO4).customerId("1");
    verify(gatewayCustomerDTO).email("42 Main St");
    verify(gatewayCustomerDTO3).firstName("Jane");
    verify(gatewayCustomerDTO2).lastName("Doe");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer5() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.phone(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO5).customerId("1");
    verify(gatewayCustomerDTO2).email("42 Main St");
    verify(gatewayCustomerDTO4).firstName("Jane");
    verify(gatewayCustomerDTO3).lastName("Doe");
    verify(gatewayCustomerDTO).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer6() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn(null);
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email(null);
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer7() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
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
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.customerId(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO).customerId("1");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress2() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.firstName(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO2);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO2).customerId("1");
    verify(gatewayCustomerDTO).firstName("Jane");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress3() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.lastName(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO3);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO3).customerId("1");
    verify(gatewayCustomerDTO2).firstName("Jane");
    verify(gatewayCustomerDTO).lastName("Doe");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress4() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.email(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO2 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO2.lastName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO3 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO3.firstName(Mockito.<String>any())).thenReturn(gatewayCustomerDTO2);

    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO4 = mock(GatewayCustomerDTO.class);
    when(gatewayCustomerDTO4.customerId(Mockito.<String>any())).thenReturn(gatewayCustomerDTO3);

    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(gatewayCustomerDTO4);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO4).customerId("1");
    verify(gatewayCustomerDTO).email("42 Main St");
    verify(gatewayCustomerDTO3).firstName("Jane");
    verify(gatewayCustomerDTO2).lastName("Doe");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress5() {
    // Arrange
    GatewayCustomerDTO<PaymentRequestDTO> gatewayCustomerDTO = mock(GatewayCustomerDTO.class);
    PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO();
    when(gatewayCustomerDTO.phone(Mockito.<String>any()))
        .thenReturn(new GatewayCustomerDTO<>(paymentRequestDTO));

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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO5).customerId("1");
    verify(gatewayCustomerDTO2).email("42 Main St");
    verify(gatewayCustomerDTO4).firstName("Jane");
    verify(gatewayCustomerDTO3).lastName("Doe");
    verify(gatewayCustomerDTO).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress6() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn(null);
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress7() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
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
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress8() {
    // Arrange
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

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("6625550144");
    when(phone.isDefault()).thenReturn(true);

    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(phone);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone("6625550144");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl, atLeast(1)).getPhone();
    verify(phone).getPhoneNumber();
    verify(phone).isDefault();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <ul>
   *   <li>Then calls {@link GatewayCustomerDTO#done()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress_thenCallsDone() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer,
   * String)} with {@code requestDTO}, {@code customer}, {@code defaultEmailAddress}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer, String)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomerDefaultEmailAddress_thenReturnNull() {
    // Arrange
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(new GatewayCustomerDTO<>());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer, "42 Main St");

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
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link GatewayCustomerDTO#done()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer_thenCallsDone() {
    // Arrange
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

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone(null);
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <ul>
   *   <li>Then calls {@link Phone#getPhoneNumber()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer_thenCallsGetPhoneNumber() {
    // Arrange
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

    Phone phone = mock(Phone.class);
    when(phone.getPhoneNumber()).thenReturn("6625550144");
    when(phone.isDefault()).thenReturn(true);

    CustomerPhoneImpl customerPhoneImpl = mock(CustomerPhoneImpl.class);
    when(customerPhoneImpl.getPhone()).thenReturn(phone);

    ArrayList<CustomerPhone> customerPhoneList = new ArrayList<>();
    customerPhoneList.add(customerPhoneImpl);

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(customerPhoneList);

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(gatewayCustomerDTO6).customerId("1");
    verify(gatewayCustomerDTO).done();
    verify(gatewayCustomerDTO3).email("42 Main St");
    verify(gatewayCustomerDTO5).firstName("Jane");
    verify(gatewayCustomerDTO4).lastName("Doe");
    verify(gatewayCustomerDTO2).phone("6625550144");
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    verify(customerPhoneImpl, atLeast(1)).getPhone();
    verify(phone).getPhoneNumber();
    verify(phone).isDefault();
    assertSame(paymentRequestDTO, actualPopulateCustomerInfoResult);
  }

  /**
   * Test {@link PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   * with {@code requestDTO}, {@code customer}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentRequestDTOServiceImpl#populateCustomerInfo(PaymentRequestDTO, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PaymentRequestDTO PaymentRequestDTOServiceImpl.populateCustomerInfo(PaymentRequestDTO, Customer)"
  })
  public void testPopulateCustomerInfoWithRequestDTOCustomer_thenReturnNull() {
    // Arrange
    PaymentRequestDTO requestDTO = mock(PaymentRequestDTO.class);
    when(requestDTO.customer()).thenReturn(new GatewayCustomerDTO<>());

    CustomerImpl customer = mock(CustomerImpl.class);
    when(customer.getId()).thenReturn(1L);
    when(customer.getEmailAddress()).thenReturn("42 Main St");
    when(customer.getFirstName()).thenReturn("Jane");
    when(customer.getLastName()).thenReturn("Doe");
    when(customer.getCustomerPhones()).thenReturn(new ArrayList<>());

    // Act
    PaymentRequestDTO actualPopulateCustomerInfoResult =
        paymentRequestDTOServiceImpl.populateCustomerInfo(requestDTO, customer);

    // Assert
    verify(requestDTO).customer();
    verify(customer).getCustomerPhones();
    verify(customer, atLeast(1)).getEmailAddress();
    verify(customer).getFirstName();
    verify(customer).getId();
    verify(customer).getLastName();
    assertNull(actualPopulateCustomerInfoResult);
  }
}
