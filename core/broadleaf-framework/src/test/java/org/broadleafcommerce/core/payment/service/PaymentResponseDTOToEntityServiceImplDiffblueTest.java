package org.broadleafcommerce.core.payment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.PaymentGatewayType;
import org.broadleafcommerce.common.payment.PaymentType;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.CreditCardDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.core.order.domain.FulfillmentGroup;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPayment;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CountryService;
import org.broadleafcommerce.profile.core.service.CountrySubdivisionService;
import org.broadleafcommerce.profile.core.service.PhoneService;
import org.broadleafcommerce.profile.core.service.StateService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PaymentResponseDTOToEntityServiceImplDiffblueTest {
  @Mock private AddressService addressService;

  @Mock private CountryService countryService;

  @Mock private CountrySubdivisionService countrySubdivisionService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private ISOService iSOService;

  @InjectMocks private PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;

  @Mock private PhoneService phoneService;

  @Mock private StateService stateService;

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, tempBillingAddress, true);

    // Assert
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertSame(tempBillingAddress, billingAddress);
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo2() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo3() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(null);
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertEquals("us-east-2", billingAddress.getStateProvinceRegion());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenAddressDTO() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(new AddressDTO<>());
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, tempBillingAddress, true);

    // Assert
    verify(responseDTO, atLeast(1)).getBillTo();
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertSame(tempBillingAddress, billingAddress);
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressCountryCode()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenAddressDTOGetAddressCountryCodeReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn(null);
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getIsoCountryAlpha2());
    assertNull(billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressStateRegion()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenAddressDTOGetAddressStateRegionReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn(null);
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation(null);
    verify(phoneService).create();
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getState());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link CountryService} {@link CountryService#findCountryByAbbreviation(String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenCountryServiceFindCountryByAbbreviationReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(null);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getCountry());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ISOService} {@link ISOService#findISOCountryByAlpha2Code(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenISOServiceFindISOCountryByAlpha2CodeReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(null);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Given {@link StateService} {@link StateService#findStateByAbbreviation(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_givenStateServiceFindStateByAbbreviationReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(null);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getState());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) BillingAddress CompanyName is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_thenOrderPaymentImplBillingAddressCompanyNameIsNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn(null);
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getCompanyName());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) BillingAddress EmailAddress is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_thenOrderPaymentImplBillingAddressEmailAddressIsNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn(null);
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getEmailAddress());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>Then {@link OrderPaymentImpl} (default constructor) BillingAddress PhonePrimary is {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_thenOrderPaymentImplBillingAddressPhonePrimaryIsNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn(null);
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, new AddressImpl(), true);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getBillTo();
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(stateService).findStateByAbbreviation("us-east-2");
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertNull(billingAddress.getPhonePrimary());
    assertSame(isoCountryImpl, billingAddress.getIsoCountryAlpha2());
    assertSame(countryImpl, billingAddress.getCountry());
    assertSame(stateImpl, billingAddress.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO,
   * OrderPayment, Address, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateBillingInfo(PaymentResponseDTO, OrderPayment,
   * Address, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateBillingInfo(PaymentResponseDTO, OrderPayment, Address, boolean)"
  })
  public void testPopulateBillingInfo_whenFalse() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getBillTo()).thenReturn(addressDTO);
    OrderPaymentImpl payment = new OrderPaymentImpl();
    AddressImpl tempBillingAddress = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateBillingInfo(
        responseDTO, payment, tempBillingAddress, false);

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getBillTo();
    Address billingAddress = payment.getBillingAddress();
    assertTrue(billingAddress instanceof AddressImpl);
    assertSame(tempBillingAddress, billingAddress);
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo2() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(null);
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo3() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo4() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any())).thenReturn(null);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO#AddressDTO()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTO() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(new AddressDTO<>());

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressCompanyName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTOGetAddressCompanyNameReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn(null);
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressCountryCode()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTOGetAddressCountryCodeReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn(null);
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressEmail()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTOGetAddressEmailReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn(null);
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressPhone()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTOGetAddressPhoneReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn(null);
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link AddressDTO} {@link AddressDTO#getAddressStateRegion()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenAddressDTOGetAddressStateRegionReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn(null);
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation(null);
    verify(phoneService).create();
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link CountryService} {@link CountryService#findCountryByAbbreviation(String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenCountryServiceFindCountryByAbbreviationReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(null);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link ISOService} {@link ISOService#findISOCountryByAlpha2Code(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenISOServiceFindISOCountryByAlpha2CodeReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(null);
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Given {@link StateService} {@link StateService#findStateByAbbreviation(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_givenStateServiceFindStateByAbbreviationReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(null);

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO,
   * Order)}.
   *
   * <ul>
   *   <li>Then calls {@link ISOService#findISOCountryByAlpha2Code(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateShippingInfo(PaymentResponseDTO, Order)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateShippingInfo(PaymentResponseDTO, Order)"
  })
  public void testPopulateShippingInfo_thenCallsFindISOCountryByAlpha2Code() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(addressService.create()).thenReturn(new AddressImpl());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountryImpl());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(fulfillmentGroupService.save(Mockito.<FulfillmentGroup>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.findFulfillmentGroupById(Mockito.<Long>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any()))
        .thenReturn(new ISOCountryImpl());
    when(phoneService.create()).thenReturn(new PhoneImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> addressDTO = mock(AddressDTO.class);
    when(addressDTO.getAddressCityLocality()).thenReturn("42 Main St");
    when(addressDTO.getAddressCompanyName()).thenReturn("42 Main St");
    when(addressDTO.getAddressCountryCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressEmail()).thenReturn("42 Main St");
    when(addressDTO.getAddressFullName()).thenReturn("Dr Jane Doe");
    when(addressDTO.getAddressLastName()).thenReturn("Doe");
    when(addressDTO.getAddressLine1()).thenReturn("42 Main St");
    when(addressDTO.getAddressLine2()).thenReturn("42 Main St");
    when(addressDTO.getAddressPhone()).thenReturn("6625550144");
    when(addressDTO.getAddressPostalCode()).thenReturn("42 Main St");
    when(addressDTO.getAddressStateRegion()).thenReturn("us-east-2");
    when(addressDTO.getCounty()).thenReturn("3");
    when(addressDTO.getAddressFirstName()).thenReturn("Jane");
    when(addressDTO.addressPopulated()).thenReturn(true);

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getShipTo()).thenReturn(addressDTO);

    // Act
    paymentResponseDTOToEntityServiceImpl.populateShippingInfo(responseDTO, new NullOrderImpl());

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("42 Main St");
    verify(addressDTO).addressPopulated();
    verify(addressDTO).getAddressCityLocality();
    verify(addressDTO, atLeast(1)).getAddressCompanyName();
    verify(addressDTO, atLeast(1)).getAddressCountryCode();
    verify(addressDTO, atLeast(1)).getAddressEmail();
    verify(addressDTO).getAddressFirstName();
    verify(addressDTO).getAddressFullName();
    verify(addressDTO).getAddressLastName();
    verify(addressDTO).getAddressLine1();
    verify(addressDTO).getAddressLine2();
    verify(addressDTO, atLeast(1)).getAddressPhone();
    verify(addressDTO).getAddressPostalCode();
    verify(addressDTO, atLeast(1)).getAddressStateRegion();
    verify(addressDTO).getCounty();
    verify(responseDTO, atLeast(1)).getShipTo();
    verify(fulfillmentGroupService).findFulfillmentGroupById(isNull());
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(fulfillmentGroupService).save(isA(FulfillmentGroup.class));
    verify(addressService).create();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("42 Main St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(null);
    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, new AddressImpl());

    // Assert that nothing has changed
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation(null);
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Given {@code 42 Main St}.
   *   <li>Then {@link AddressImpl} (default constructor) EmailAddress is {@code 42 Main St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_given42MainSt_thenAddressImplEmailAddressIs42MainSt() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneService.create()).thenReturn(phoneImpl);
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressEmail("42 Main St");
    dto.addressPhone("+44 1865 4960636");
    dto.addressCountryCode("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("17 High St");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("17 High St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertEquals("42 Main St", address.getEmailAddress());
    assertSame(isoCountryImpl, address.getIsoCountryAlpha2());
    assertSame(countryImpl, address.getCountry());
    assertSame(phoneImpl, address.getPhonePrimary());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Given {@link CountryService} {@link CountryService#findCountryByAbbreviation(String)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_givenCountryServiceFindCountryByAbbreviationReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(null);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneService.create()).thenReturn(phoneImpl);
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressPhone("+44 1865 4960636");
    dto.addressCountryCode("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("17 High St");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("17 High St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertSame(isoCountryImpl, address.getIsoCountryAlpha2());
    assertSame(phoneImpl, address.getPhonePrimary());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Given {@link ISOService} {@link ISOService#findISOCountryByAlpha2Code(String)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_givenISOServiceFindISOCountryByAlpha2CodeReturnNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(null);
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneService.create()).thenReturn(phoneImpl);
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressPhone("+44 1865 4960636");
    dto.addressCountryCode("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("17 High St");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("17 High St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertSame(countryImpl, address.getCountry());
    assertSame(phoneImpl, address.getPhonePrimary());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) CompanyName is {@code 17 High St}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_thenAddressImplCompanyNameIs17HighSt() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressCompanyName("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertEquals("17 High St", address.getCompanyName());
    assertNull(address.getIsoCountryAlpha2());
    assertNull(address.getCountry());
    assertNull(address.getPhonePrimary());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) IsoCountryAlpha2 is {@link ISOCountryImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_thenAddressImplIsoCountryAlpha2IsISOCountryImpl() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressCountryCode("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("17 High St");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("17 High St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertSame(isoCountryImpl, address.getIsoCountryAlpha2());
    assertSame(countryImpl, address.getCountry());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) IsoCountryAlpha2 is {@link ISOCountryImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_thenAddressImplIsoCountryAlpha2IsISOCountryImpl2() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    CountryImpl countryImpl = new CountryImpl();
    when(countryService.findCountryByAbbreviation(Mockito.<String>any())).thenReturn(countryImpl);
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    ISOCountryImpl isoCountryImpl = new ISOCountryImpl();
    when(iSOService.findISOCountryByAlpha2Code(Mockito.<String>any())).thenReturn(isoCountryImpl);
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneService.create()).thenReturn(phoneImpl);
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(new StateImpl());

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressPhone("+44 1865 4960636");
    dto.addressCountryCode("17 High St");
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(iSOService).findISOCountryByAlpha2Code("17 High St");
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countryService).findCountryByAbbreviation("17 High St");
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(phoneService).create();
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertSame(isoCountryImpl, address.getIsoCountryAlpha2());
    assertSame(countryImpl, address.getCountry());
    assertSame(phoneImpl, address.getPhonePrimary());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) State is {@link StateImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_thenAddressImplStateIsStateImpl() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    StateImpl stateImpl = new StateImpl();
    when(stateService.findStateByAbbreviation(Mockito.<String>any())).thenReturn(stateImpl);

    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();
    dto.addressStateRegion("us-east-2");
    AddressImpl address = new AddressImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, address);

    // Assert
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation("us-east-2");
    verify(stateService).findStateByAbbreviation("us-east-2");
    assertSame(stateImpl, address.getState());
  }

  /**
   * Test {@link PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}.
   *
   * <ul>
   *   <li>When {@link AddressDTO#AddressDTO()}.
   *   <li>Then calls {@link AddressService#populateAddressISOCountrySub(Address)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateAddressInfo(AddressDTO, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateAddressInfo(AddressDTO, Address)"
  })
  public void testPopulateAddressInfo_whenAddressDTO_thenCallsPopulateAddressISOCountrySub() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(countrySubdivisionService.findSubdivisionByAbbreviation(Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());
    AddressDTO<PaymentResponseDTO> dto = new AddressDTO<>();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateAddressInfo(dto, new AddressImpl());

    // Assert that nothing has changed
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(countrySubdivisionService).findSubdivisionByAbbreviation(null);
  }

  /**
   * Test {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then calls {@link PaymentResponseDTO#getCreditCard()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)"
  })
  public void testPopulateCustomerPaymentToken_givenNull_thenCallsGetCreditCard() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn(null);
    when(responseDTO.getResponseMap()).thenReturn(new HashMap<>());
    when(responseDTO.getCreditCard()).thenReturn(new CreditCardDTO<>());

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(
        responseDTO, new CustomerPaymentImpl());

    // Assert that nothing has changed
    verify(responseDTO, atLeast(1)).getCreditCard();
    verify(responseDTO).getPaymentToken();
    verify(responseDTO).getResponseMap();
  }

  /**
   * Test {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}.
   *
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentToken is {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)"
  })
  public void testPopulateCustomerPaymentToken_thenCustomerPaymentImplPaymentTokenIsAbc123() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();

    PaymentResponseDTO responseDTO = mock(PaymentResponseDTO.class);
    when(responseDTO.getPaymentToken()).thenReturn("ABC123");
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(
        responseDTO, customerPayment);

    // Assert
    verify(responseDTO, atLeast(1)).getPaymentToken();
    assertEquals("ABC123", customerPayment.getPaymentToken());
  }

  /**
   * Test {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}.
   *
   * <ul>
   *   <li>Then {@link CustomerPaymentImpl} (default constructor) PaymentToken is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PaymentResponseDTOToEntityServiceImpl#populateCustomerPaymentToken(PaymentResponseDTO,
   * CustomerPayment)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void PaymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(PaymentResponseDTO, CustomerPayment)"
  })
  public void testPopulateCustomerPaymentToken_thenCustomerPaymentImplPaymentTokenIsNull() {
    // Arrange
    PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl =
        new PaymentResponseDTOToEntityServiceImpl();
    PaymentType paymentType = new PaymentType();
    PaymentResponseDTO responseDTO = new PaymentResponseDTO(paymentType, new PaymentGatewayType());
    CustomerPaymentImpl customerPayment = new CustomerPaymentImpl();

    // Act
    paymentResponseDTOToEntityServiceImpl.populateCustomerPaymentToken(
        responseDTO, customerPayment);

    // Assert that nothing has changed
    assertNull(customerPayment.getPaymentToken());
  }
}
