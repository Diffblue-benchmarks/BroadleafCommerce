/*-
 * #%L
 * BroadleafCommerce Profile
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
package org.broadleafcommerce.profile.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
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
import java.util.ArrayList;
import java.util.List;
import org.broadleafcommerce.common.config.domain.ModuleConfiguration;
import org.broadleafcommerce.common.config.service.ModuleConfigurationService;
import org.broadleafcommerce.common.config.service.type.ModuleConfigurationType;
import org.broadleafcommerce.common.i18n.domain.ISOCountryImpl;
import org.broadleafcommerce.common.sitemap.domain.SiteMapConfigurationImpl;
import org.broadleafcommerce.profile.core.dao.AddressDao;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.CountrySubdivisionImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.broadleafcommerce.profile.core.service.exception.AddressVerificationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceImplDiffblueTest {
  @Mock private AddressDao addressDao;

  @InjectMocks private AddressServiceImpl addressServiceImpl;

  @Mock private CountrySubdivisionService countrySubdivisionService;

  @Mock private List<AddressVerificationProvider> list;

  @Mock private ModuleConfigurationService moduleConfigurationService;

  @Mock private PhoneService phoneService;

  /**
   * Test {@link AddressServiceImpl#saveAddress(Address)}.
   *
   * <p>Method under test: {@link AddressServiceImpl#saveAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.saveAddress(Address)"})
  public void testSaveAddress() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressDao.save(Mockito.<Address>any())).thenReturn(addressImpl);

    // Act
    Address actualSaveAddressResult = addressServiceImpl.saveAddress(new AddressImpl());

    // Assert
    verify(addressDao).save(isA(Address.class));
    assertSame(addressImpl, actualSaveAddressResult);
  }

  /**
   * Test {@link AddressServiceImpl#readAddressById(Long)}.
   *
   * <p>Method under test: {@link AddressServiceImpl#readAddressById(Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.readAddressById(Long)"})
  public void testReadAddressById() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressDao.readAddressById(Mockito.<Long>any())).thenReturn(addressImpl);

    // Act
    Address actualReadAddressByIdResult = addressServiceImpl.readAddressById(1L);

    // Assert
    verify(addressDao).readAddressById(1L);
    assertSame(addressImpl, actualReadAddressByIdResult);
  }

  /**
   * Test {@link AddressServiceImpl#create()}.
   *
   * <p>Method under test: {@link AddressServiceImpl#create()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.create()"})
  public void testCreate() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressDao.create()).thenReturn(addressImpl);

    // Act
    Address actualCreateResult = addressServiceImpl.create();

    // Assert
    verify(addressDao).create();
    assertSame(addressImpl, actualCreateResult);
  }

  /**
   * Test {@link AddressServiceImpl#delete(Address)}.
   *
   * <p>Method under test: {@link AddressServiceImpl#delete(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.delete(Address)"})
  public void testDelete() {
    // Arrange
    doNothing().when(addressDao).delete(Mockito.<Address>any());

    // Act
    addressServiceImpl.delete(new AddressImpl());

    // Assert
    verify(addressDao).delete(isA(Address.class));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress() throws AddressVerificationException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    AddressVerificationProvider addressVerificationProvider =
        mock(AddressVerificationProvider.class);
    when(addressVerificationProvider.validateAddress(
            Mockito.<Address>any(), Mockito.<ModuleConfiguration>any()))
        .thenThrow(new AddressVerificationException("Arg0"));
    when(addressVerificationProvider.canRespond(Mockito.<ModuleConfiguration>any()))
        .thenReturn(true);

    ArrayList<AddressVerificationProvider> addressVerificationProviderList = new ArrayList<>();
    addressVerificationProviderList.add(addressVerificationProvider);
    when(list.iterator()).thenReturn(addressVerificationProviderList.iterator());
    when(list.isEmpty()).thenReturn(false);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act and Assert
    assertThrows(
        AddressVerificationException.class, () -> addressServiceImpl.verifyAddress(address));
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(addressVerificationProvider).canRespond(isA(ModuleConfiguration.class));
    verify(address).getStandardized();
    verify(addressVerificationProvider)
        .validateAddress(isA(Address.class), isA(ModuleConfiguration.class));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@link AddressServiceImpl} (default constructor) MustValidateAddresses is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenAddressServiceImplMustValidateAddressesIsTrue()
      throws AddressVerificationException {
    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
    addressServiceImpl.setMustValidateAddresses(true);

    // Act and Assert
    assertThrows(
        AddressVerificationException.class,
        () -> addressServiceImpl.verifyAddress(new AddressImpl()));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@link AddressServiceImpl} (default constructor).
   *   <li>Then first return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenAddressServiceImpl_thenFirstReturnAddressImpl()
      throws AddressVerificationException {
    // Arrange
    AddressServiceImpl addressServiceImpl = new AddressServiceImpl();

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(new AddressImpl());

    // Assert
    assertEquals(1, actualVerifyAddressResult.size());
    assertTrue(actualVerifyAddressResult.get(0) instanceof AddressImpl);
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link SiteMapConfigurationImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenArrayListAddSiteMapConfigurationImpl()
      throws AddressVerificationException {
    // Arrange
    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(new SiteMapConfigurationImpl());
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    ArrayList<AddressVerificationProvider> addressVerificationProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(addressVerificationProviderList.iterator());
    when(list.isEmpty()).thenReturn(false);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>Then first return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenListIsEmptyReturnTrue_thenFirstReturnAddressImpl()
      throws AddressVerificationException {
    // Arrange
    when(list.isEmpty()).thenReturn(true);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(new AddressImpl());

    // Assert
    verify(list).isEmpty();
    assertEquals(1, actualVerifyAddressResult.size());
    assertTrue(actualVerifyAddressResult.get(0) instanceof AddressImpl);
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@link List} {@link List#isEmpty()} return {@code true}.
   *   <li>Then return first is {@link Address}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenListIsEmptyReturnTrue_thenReturnFirstIsAddress()
      throws AddressVerificationException {
    // Arrange
    when(list.isEmpty()).thenReturn(true);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(list).isEmpty();
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link AddressImpl} (default constructor) Active is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_givenTrue_whenAddressImplActiveIsTrue()
      throws AddressVerificationException {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setIsoCountrySubdivision("GB");
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setState(new StateImpl());
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setStandardized(true);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    assertEquals(1, actualVerifyAddressResult.size());
    assertTrue(actualVerifyAddressResult.get(0) instanceof AddressImpl);
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Then calls {@link ModuleConfiguration#getIsDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_thenCallsGetIsDefault() throws AddressVerificationException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    ArrayList<AddressVerificationProvider> addressVerificationProviderList = new ArrayList<>();
    when(list.iterator()).thenReturn(addressVerificationProviderList.iterator());
    when(list.isEmpty()).thenReturn(false);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_thenReturnEmpty() throws AddressVerificationException {
    // Arrange
    ModuleConfiguration moduleConfiguration = mock(ModuleConfiguration.class);
    when(moduleConfiguration.getIsDefault()).thenReturn(true);

    ArrayList<ModuleConfiguration> moduleConfigurationList = new ArrayList<>();
    moduleConfigurationList.add(moduleConfiguration);
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(moduleConfigurationList);

    AddressVerificationProvider addressVerificationProvider =
        mock(AddressVerificationProvider.class);
    when(addressVerificationProvider.validateAddress(
            Mockito.<Address>any(), Mockito.<ModuleConfiguration>any()))
        .thenReturn(new ArrayList<>());
    when(addressVerificationProvider.canRespond(Mockito.<ModuleConfiguration>any()))
        .thenReturn(true);

    ArrayList<AddressVerificationProvider> addressVerificationProviderList = new ArrayList<>();
    addressVerificationProviderList.add(addressVerificationProvider);
    when(list.iterator()).thenReturn(addressVerificationProviderList.iterator());
    when(list.isEmpty()).thenReturn(false);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(list).isEmpty();
    verify(list).iterator();
    verify(moduleConfiguration).getIsDefault();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(addressVerificationProvider).canRespond(isA(ModuleConfiguration.class));
    verify(address).getStandardized();
    verify(addressVerificationProvider)
        .validateAddress(isA(Address.class), isA(ModuleConfiguration.class));
    assertTrue(actualVerifyAddressResult.isEmpty());
  }

  /**
   * Test {@link AddressServiceImpl#verifyAddress(Address)}.
   *
   * <ul>
   *   <li>Then return first is {@link Address}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#verifyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List AddressServiceImpl.verifyAddress(Address)"})
  public void testVerifyAddress_thenReturnFirstIsAddress() throws AddressVerificationException {
    // Arrange
    when(moduleConfigurationService.findActiveConfigurationsByType(
            Mockito.<ModuleConfigurationType>any()))
        .thenReturn(new ArrayList<>());
    when(list.isEmpty()).thenReturn(false);

    Address address = mock(Address.class);
    when(address.getStandardized()).thenReturn(null);

    // Act
    List<Address> actualVerifyAddressResult = addressServiceImpl.verifyAddress(address);

    // Assert
    verify(list).isEmpty();
    verify(moduleConfigurationService)
        .findActiveConfigurationsByType(isA(ModuleConfigurationType.class));
    verify(address).getStandardized();
    assertEquals(1, actualVerifyAddressResult.size());
    assertSame(address, actualVerifyAddressResult.get(0));
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.copyAddress(Address, Address)"})
  public void testCopyAddressWithDestOrig_thenReturnAddressImpl() {
    // Arrange
    PhoneImpl phoneImpl = new PhoneImpl();
    when(phoneService.copyPhone(Mockito.<Phone>any(), Mockito.<Phone>any())).thenReturn(phoneImpl);
    AddressImpl dest = new AddressImpl();

    // Act
    Address actualCopyAddressResult = addressServiceImpl.copyAddress(dest, new AddressImpl());

    // Assert
    verify(phoneService, atLeast(1)).copyPhone(isNull(), isNull());
    assertTrue(actualCopyAddressResult instanceof AddressImpl);
    assertSame(phoneImpl, dest.getPhoneFax());
    assertSame(phoneImpl, dest.getPhonePrimary());
    assertSame(phoneImpl, dest.getPhoneSecondary());
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.copyAddress(Address, Address)"})
  public void testCopyAddressWithDestOrig_thenReturnAddressImpl2() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressDao.create()).thenReturn(addressImpl);
    when(phoneService.copyPhone(Mockito.<Phone>any(), Mockito.<Phone>any()))
        .thenReturn(new PhoneImpl());

    // Act
    Address actualCopyAddressResult = addressServiceImpl.copyAddress(null, new AddressImpl());

    // Assert
    verify(addressDao).create();
    verify(phoneService, atLeast(1)).copyPhone(isNull(), isNull());
    assertSame(addressImpl, actualCopyAddressResult);
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address, Address)} with {@code dest}, {@code orig}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#copyAddress(Address, Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.copyAddress(Address, Address)"})
  public void testCopyAddressWithDestOrig_whenNull_thenReturnNull() {
    // Arrange
    AddressImpl dest = new AddressImpl();

    // Act and Assert
    assertNull(addressServiceImpl.copyAddress(dest, null));
    assertNull(dest.getPhoneFax());
    assertNull(dest.getPhonePrimary());
    assertNull(dest.getPhoneSecondary());
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address)} with {@code orig}.
   *
   * <ul>
   *   <li>Then return {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#copyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.copyAddress(Address)"})
  public void testCopyAddressWithOrig_thenReturnAddressImpl() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressDao.create()).thenReturn(addressImpl);
    when(phoneService.copyPhone(Mockito.<Phone>any(), Mockito.<Phone>any()))
        .thenReturn(new PhoneImpl());

    // Act
    Address actualCopyAddressResult = addressServiceImpl.copyAddress(new AddressImpl());

    // Assert
    verify(addressDao).create();
    verify(phoneService, atLeast(1)).copyPhone(isNull(), isNull());
    assertSame(addressImpl, actualCopyAddressResult);
  }

  /**
   * Test {@link AddressServiceImpl#copyAddress(Address)} with {@code orig}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#copyAddress(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Address AddressServiceImpl.copyAddress(Address)"})
  public void testCopyAddressWithOrig_whenNull_thenReturnNull() {
    // Arrange
    when(addressDao.create()).thenReturn(new AddressImpl());

    // Act
    Address actualCopyAddressResult = addressServiceImpl.copyAddress(null);

    // Assert
    verify(addressDao).create();
    assertNull(actualCopyAddressResult);
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub() {
    // Arrange
    when(countrySubdivisionService.findSubdivisionByCountryAndAltAbbreviation(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision(" ");
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setStateProvinceRegion("not blank");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert
    verify(countrySubdivisionService).findSubdivisionByCountryAndAltAbbreviation(null, "not blank");
    assertNull(address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_givenEmptyString() {
    // Arrange
    when(countrySubdivisionService.findSubdivisionByCountryAndAltAbbreviation(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision("");
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setStateProvinceRegion("not blank");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert
    verify(countrySubdivisionService).findSubdivisionByCountryAndAltAbbreviation(null, "not blank");
    assertNull(address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) IsoCountrySubdivision is {@code 42 Main
   *       St}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_thenAddressImplIsoCountrySubdivisionIs42MainSt() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision("42 Main St");
    address.setIsoCountryAlpha2(null);
    address.setStateProvinceRegion("not blank");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert that nothing has changed
    assertEquals("42 Main St", address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>Then {@link AddressImpl} (default constructor) IsoCountrySubdivision is space.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_thenAddressImplIsoCountrySubdivisionIsSpace() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision(" ");
    address.setIsoCountryAlpha2(null);
    address.setStateProvinceRegion("not blank");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert that nothing has changed
    assertEquals(" ", address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>Then calls {@link CountrySubdivisionService#findSubdivisionByCountryAndName(String,
   *       String)}.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_thenCallsFindSubdivisionByCountryAndName() {
    // Arrange
    when(countrySubdivisionService.findSubdivisionByCountryAndAltAbbreviation(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(countrySubdivisionService.findSubdivisionByCountryAndName(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new CountrySubdivisionImpl());

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision(" ");
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setStateProvinceRegion("not blank");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert
    verify(countrySubdivisionService).findSubdivisionByCountryAndAltAbbreviation(null, "not blank");
    verify(countrySubdivisionService).findSubdivisionByCountryAndName(null, "not blank");
    assertNull(address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_whenAddressImpl() {
    // Arrange
    AddressImpl address = new AddressImpl();

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert that nothing has changed
    assertNull(address.getIsoCountrySubdivision());
  }

  /**
   * Test {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}.
   *
   * <ul>
   *   <li>When {@link AddressImpl} (default constructor) StateProvinceRegion is space.
   * </ul>
   *
   * <p>Method under test: {@link AddressServiceImpl#populateAddressISOCountrySub(Address)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AddressServiceImpl.populateAddressISOCountrySub(Address)"})
  public void testPopulateAddressISOCountrySub_whenAddressImplStateProvinceRegionIsSpace() {
    // Arrange
    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCountry(new CountryImpl());
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setLastName("Doe");
    address.setMailing(true);
    address.setPhoneFax(new PhoneImpl());
    address.setPhonePrimary(new PhoneImpl());
    address.setPhoneSecondary(new PhoneImpl());
    address.setPostalCode("Postal Code");
    address.setPrimaryPhone("6625550144");
    address.setSecondaryPhone("6625550144");
    address.setStandardized(true);
    address.setState(new StateImpl());
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountrySubdivision(" ");
    address.setIsoCountryAlpha2(new ISOCountryImpl());
    address.setStateProvinceRegion(" ");

    // Act
    addressServiceImpl.populateAddressISOCountrySub(address);

    // Assert that nothing has changed
    assertEquals(" ", address.getIsoCountrySubdivision());
  }
}
