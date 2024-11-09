/*-
 * #%L
 * BroadleafCommerce Framework Web
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
package org.broadleafcommerce.core.web.controller.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;

class BroadleafManageCustomerAddressesControllerDiffblueTest {
  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewCustomerAddresses(HttpServletRequest, Model)")
  void testViewCustomerAddresses() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressesResult = broadleafManageCustomerAddressesController.viewCustomerAddresses(request,
        model);

    // Assert
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressesResult);
    assertNull(((CustomerAddressForm) getResult).getCustomerAddressId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(((CustomerAddressForm) getResult).getAddressName());
    assertNull(address.getAddressLine1());
    assertNull(address.getAddressLine2());
    assertNull(address.getAddressLine3());
    assertNull(address.getCity());
    assertNull(address.getCompanyName());
    assertNull(address.getCounty());
    assertNull(address.getEmailAddress());
    assertNull(address.getFax());
    assertNull(address.getFirstName());
    assertNull(address.getFullName());
    assertNull(address.getIsoCountrySubdivision());
    assertNull(address.getLastName());
    assertNull(address.getPostalCode());
    assertNull(address.getPrimaryPhone());
    assertNull(address.getSecondaryPhone());
    assertNull(address.getStateProvinceRegion());
    assertNull(address.getTokenizedAddress());
    assertNull(address.getVerificationLevel());
    assertNull(address.getZipFour());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(address.getIsoCountryAlpha2());
    assertNull(address.getCountry());
    assertNull(address.getState());
    assertFalse(address.getStandardized());
    assertFalse(address.isBusiness());
    assertFalse(address.isDefault());
    assertFalse(address.isMailing());
    assertFalse(address.isStreet());
    assertFalse(phoneFax.isDefault());
    assertTrue(address.isActive());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}.
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewCustomerAddresses(HttpServletRequest, Model)")
  void testViewCustomerAddresses2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    DefaultMultipartHttpServletRequest servletRequest = mock(DefaultMultipartHttpServletRequest.class);
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressesResult = broadleafManageCustomerAddressesController.viewCustomerAddresses(request,
        model);

    // Assert
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressesResult);
    assertNull(((CustomerAddressForm) getResult).getCustomerAddressId());
    assertNull(address.getId());
    assertNull(phoneFax.getId());
    assertNull(((CustomerAddressForm) getResult).getAddressName());
    assertNull(address.getAddressLine1());
    assertNull(address.getAddressLine2());
    assertNull(address.getAddressLine3());
    assertNull(address.getCity());
    assertNull(address.getCompanyName());
    assertNull(address.getCounty());
    assertNull(address.getEmailAddress());
    assertNull(address.getFax());
    assertNull(address.getFirstName());
    assertNull(address.getFullName());
    assertNull(address.getIsoCountrySubdivision());
    assertNull(address.getLastName());
    assertNull(address.getPostalCode());
    assertNull(address.getPrimaryPhone());
    assertNull(address.getSecondaryPhone());
    assertNull(address.getStateProvinceRegion());
    assertNull(address.getTokenizedAddress());
    assertNull(address.getVerificationLevel());
    assertNull(address.getZipFour());
    assertNull(phoneFax.getCountryCode());
    assertNull(phoneFax.getExtension());
    assertNull(phoneFax.getPhoneNumber());
    assertNull(address.getIsoCountryAlpha2());
    assertNull(address.getCountry());
    assertNull(address.getState());
    assertFalse(address.getStandardized());
    assertFalse(address.isBusiness());
    assertFalse(address.isDefault());
    assertFalse(address.isMailing());
    assertFalse(address.isStreet());
    assertFalse(phoneFax.isDefault());
    assertTrue(address.isActive());
    assertTrue(phoneFax.isActive());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) Fax is 'Fax'")
  void testRemoveUnusedPhones_givenAddressImplFaxIsFax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("Fax");
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return
   * {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl getPhoneFax() return PhoneImpl")
  void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    when(phoneImpl.getPhoneNumber()).thenThrow(new IllegalArgumentException("foo"));
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(phoneImpl);
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafManageCustomerAddressesController.removeUnusedPhones(form));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(addressImpl, atLeast(1)).getPhoneFax();
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl, atLeast(1)).getPhoneSecondary();
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
    verify(phoneImpl).getPhoneNumber();
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return
   * {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl getPhonePrimary() return PhoneImpl")
  void testRemoveUnusedPhones_givenAddressImplGetPhonePrimaryReturnPhoneImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    PhoneImpl phoneImpl = mock(PhoneImpl.class);
    when(phoneImpl.getPhoneNumber()).thenThrow(new IllegalArgumentException("foo"));
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhonePrimary()).thenReturn(phoneImpl);
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    new IllegalArgumentException("foo");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafManageCustomerAddressesController.removeUnusedPhones(form));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(phoneImpl).getPhoneNumber();
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  void testRemoveUnusedPhones_givenAddressImplPrimaryPhoneIs6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is
   * {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  void testRemoveUnusedPhones_givenAddressImplSecondaryPhoneIs6625550144() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();

    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneFax(Phone)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then calls setPhoneFax(Phone)")
  void testRemoveUnusedPhones_thenCallsSetPhoneFax() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    AddressImpl addressImpl = mock(AddressImpl.class);
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(addressImpl, atLeast(1)).getPhoneFax();
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl, atLeast(1)).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address
   * {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then CustomerAddressForm (default constructor) Address AddressImpl")
  void testRemoveUnusedPhones_thenCustomerAddressFormAddressAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then throw SecurityException")
  void testRemoveUnusedPhones_thenThrowSecurityException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    AddressImpl addressImpl = mock(AddressImpl.class);
    doThrow(new SecurityException("foo")).when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController.removeUnusedPhones(form));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl).setPhonePrimary(isNull());
  }

  /**
   * Test
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>When {@link CustomerAddressForm} {@link CustomerAddressForm#getAddress()}
   * return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); when CustomerAddressForm getAddress() return AddressImpl (default constructor)")
  void testRemoveUnusedPhones_whenCustomerAddressFormGetAddressReturnAddressImpl() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);

    // Act
    broadleafManageCustomerAddressesController.removeUnusedPhones(form);

    // Assert
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link BroadleafManageCustomerAddressesController}
   *   <li>
   * {@link BroadleafManageCustomerAddressesController#getAddressAddedMessage()}
   *   <li>
   * {@link BroadleafManageCustomerAddressesController#getAddressRemovedErrorMessage()}
   *   <li>
   * {@link BroadleafManageCustomerAddressesController#getAddressRemovedMessage()}
   *   <li>
   * {@link BroadleafManageCustomerAddressesController#getAddressUpdatedMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BroadleafManageCustomerAddressesController actualBroadleafManageCustomerAddressesController = new BroadleafManageCustomerAddressesController();
    String actualAddressAddedMessage = actualBroadleafManageCustomerAddressesController.getAddressAddedMessage();
    String actualAddressRemovedErrorMessage = actualBroadleafManageCustomerAddressesController
        .getAddressRemovedErrorMessage();
    String actualAddressRemovedMessage = actualBroadleafManageCustomerAddressesController.getAddressRemovedMessage();

    // Assert
    assertEquals("Address could not be removed as it is in use", actualAddressRemovedErrorMessage);
    assertEquals("Address successfully added", actualAddressAddedMessage);
    assertEquals("Address successfully removed", actualAddressRemovedMessage);
    assertEquals("Address successfully updated",
        actualBroadleafManageCustomerAddressesController.getAddressUpdatedMessage());
  }
}
