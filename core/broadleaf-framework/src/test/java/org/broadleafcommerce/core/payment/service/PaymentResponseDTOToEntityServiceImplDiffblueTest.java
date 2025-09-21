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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.i18n.service.ISOService;
import org.broadleafcommerce.common.payment.dto.AddressDTO;
import org.broadleafcommerce.common.payment.dto.PaymentResponseDTO;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
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

  @Mock private ISOService iSOService;

  @InjectMocks private PaymentResponseDTOToEntityServiceImpl paymentResponseDTOToEntityServiceImpl;

  @Mock private PhoneService phoneService;

  @Mock private StateService stateService;

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
}
