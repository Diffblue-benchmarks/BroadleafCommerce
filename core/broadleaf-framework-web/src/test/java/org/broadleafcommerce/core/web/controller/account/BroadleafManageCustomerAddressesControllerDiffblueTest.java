/*-
 * #%L
 * BroadleafCommerce Framework Web
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
import com.diffblue.cover.annotations.MethodsUnderTest;
import javax.servlet.http.HttpServletRequest;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.core.web.controller.account.validator.CustomerAddressValidator;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CustomerAddress;
import org.broadleafcommerce.profile.core.domain.CustomerAddressImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerAddressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

@ExtendWith(MockitoExtension.class)
class BroadleafManageCustomerAddressesControllerDiffblueTest {
  @Mock
  private AddressService addressService;

  @InjectMocks
  private BroadleafManageCustomerAddressesController broadleafManageCustomerAddressesController;

  @Mock
  private CustomerAddressValidator customerAddressValidator;

  @Mock
  private CustomerAddressService customerAddressService;

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddresses(HttpServletRequest, Model)}
   */
  @Test
  @DisplayName("Test viewCustomerAddresses(HttpServletRequest, Model)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddresses(HttpServletRequest, Model)"})
  void testViewCustomerAddresses() {
    // Arrange
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
    assertTrue(((CustomerAddressForm) getResult).getAddress() instanceof AddressImpl);
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressesResult);
    assertNull(((CustomerAddressForm) getResult).getCustomerAddressId());
    assertNull(((CustomerAddressForm) getResult).getAddressName());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("6625550144");
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertEquals("6625550144", address.getPrimaryPhone());
    assertEquals("6625550144", phonePrimary.getPhoneNumber());
    assertNull(phonePrimary.getId());
    assertNull(phonePrimary.getCountryCode());
    assertNull(phonePrimary.getExtension());
    assertFalse(phonePrimary.isDefault());
    assertTrue(phonePrimary.isActive());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress2() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setSecondaryPhone("6625550144");
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals("6625550144", address.getSecondaryPhone());
    assertEquals("6625550144", phoneSecondary.getPhoneNumber());
    assertNull(phoneSecondary.getId());
    assertNull(phoneSecondary.getCountryCode());
    assertNull(phoneSecondary.getExtension());
    assertFalse(phoneSecondary.isDefault());
    assertTrue(phoneSecondary.isActive());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress3() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setFax("customerAddressForm");
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
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
    assertEquals("customerAddressForm", address.getFax());
    assertEquals("customerAddressForm", phoneFax.getPhoneNumber());
    assertNull(phonePrimary.getPhoneNumber());
    assertEquals(phonePrimary, phoneSecondary);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); given AddressImpl getPhoneFax() return PhoneImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult = broadleafManageCustomerAddressesController.viewCustomerAddress(request,
        model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneFax(Phone)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then calls setPhoneFax(Phone)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenCallsSetPhoneFax() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(null);
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(addressImpl).setPhoneFax(Mockito.<Phone>any());
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult = broadleafManageCustomerAddressesController.viewCustomerAddress(request,
        model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhonePrimary(Phone)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then calls setPhonePrimary(Phone)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenCallsSetPhonePrimary() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(null);
    when(addressImpl.getPhoneSecondary()).thenReturn(new PhoneImpl());
    doNothing().when(addressImpl).setPhonePrimary(Mockito.<Phone>any());
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult = broadleafManageCustomerAddressesController.viewCustomerAddress(request,
        model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhonePrimary(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneSecondary(Phone)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then calls setPhoneSecondary(Phone)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenCallsSetPhoneSecondary() {
    // Arrange
    AddressImpl addressImpl = mock(AddressImpl.class);
    when(addressImpl.getPhoneFax()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    when(addressImpl.getPhoneSecondary()).thenReturn(null);
    doNothing().when(addressImpl).setPhoneSecondary(Mockito.<Phone>any());
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(addressImpl);
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualViewCustomerAddressResult = broadleafManageCustomerAddressesController.viewCustomerAddress(request,
        model, 1L);

    // Assert
    verify(addressImpl).getPhoneFax();
    verify(addressImpl).getPhonePrimary();
    verify(addressImpl).getPhoneSecondary();
    verify(addressImpl).setPhoneSecondary(isA(Phone.class));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    assertEquals("42 Main St", ((CustomerAddressForm) getResult).getAddressName());
    assertEquals("account/manageCustomerAddresses", actualViewCustomerAddressResult);
    assertEquals(1L, ((CustomerAddressForm) getResult).getCustomerAddressId().longValue());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then {@link ConcurrentModel#ConcurrentModel()} {@code customerAddressForm} Address Fax is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then ConcurrentModel() 'customerAddressForm' Address Fax is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenConcurrentModelCustomerAddressFormAddressFaxIsNull() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getId()).thenReturn(1L);
    when(customerAddressImpl.getAddressName()).thenReturn("42 Main St");
    when(customerAddressImpl.getAddress()).thenReturn(new AddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    broadleafManageCustomerAddressesController.viewCustomerAddress(request, model, 1L);

    // Assert
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressImpl).getId();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals(1, model.size());
    Object getResult = model.get("customerAddressForm");
    assertTrue(getResult instanceof CustomerAddressForm);
    Address address = ((CustomerAddressForm) getResult).getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    assertNull(address.getFax());
    assertNull(address.getPrimaryPhone());
    assertNull(address.getSecondaryPhone());
    assertNull(phoneFax.getPhoneNumber());
    assertEquals(phoneFax, phonePrimary);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenThrowIllegalArgumentException() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> broadleafManageCustomerAddressesController.viewCustomerAddress(request, new ConcurrentModel(), 1L));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#viewCustomerAddress(HttpServletRequest, Model, Long)}
   */
  @Test
  @DisplayName("Test viewCustomerAddress(HttpServletRequest, Model, Long); then throw SecurityException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.viewCustomerAddress(HttpServletRequest, Model, Long)"})
  void testViewCustomerAddress_thenThrowSecurityException() {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    when(customerAddressImpl.getAddressName()).thenThrow(new SecurityException("customerAddressForm"));
    when(customerAddressImpl.getAddress()).thenReturn(new AddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));

    // Act and Assert
    assertThrows(SecurityException.class,
        () -> broadleafManageCustomerAddressesController.viewCustomerAddress(request, new ConcurrentModel(), 1L));
    verify(customerAddressImpl).getAddress();
    verify(customerAddressImpl).getAddressName();
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testAddCustomerAddress_thenThrowIllegalArgumentException() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doThrow(new IllegalArgumentException("foo")).when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafManageCustomerAddressesController
        .addCustomerAddress(request, model, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes); then throw SecurityException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.addCustomerAddress(HttpServletRequest, Model, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testAddCustomerAddress_thenThrowSecurityException() throws ServiceException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();
    AddressImpl addressImpl = mock(AddressImpl.class);
    doThrow(new SecurityException("ThreadLocalManager.notify.orphans")).when(addressImpl)
        .setPhonePrimary(Mockito.<Phone>any());
    when(addressImpl.getPhonePrimary()).thenReturn(new PhoneImpl());
    doNothing().when(addressImpl).setPrimaryPhone(Mockito.<String>any());
    addressImpl.setPrimaryPhone("");
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(addressImpl);
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController.addCustomerAddress(request,
        model, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPrimaryPhone(eq(""));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress() throws ServiceException {
    // Arrange
    doThrow(new IllegalArgumentException("Customer Address not found with the specified customerAddressId"))
        .when(customerAddressValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress2() throws ServiceException {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(null);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress3() throws ServiceException {
    // Arrange
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();
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
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl).setPhonePrimary(isNull());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); given AddressImpl (default constructor) Fax is 'Fax'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_givenAddressImplFaxIsFax() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

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
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_givenAddressImplPrimaryPhoneIs6625550144() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

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
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_givenAddressImplSecondaryPhoneIs6625550144() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

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
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#getPhoneFax()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); then calls getPhoneFax()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_thenCallsGetPhoneFax() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();
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
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressImpl, atLeast(1)).getPhoneFax();
    verify(addressImpl, atLeast(1)).getPhonePrimary();
    verify(addressImpl, atLeast(1)).getPhoneSecondary();
    verify(addressImpl).setPhoneFax(isNull());
    verify(addressImpl).setPhonePrimary(isNull());
    verify(addressImpl).setPhoneSecondary(isNull());
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); then CustomerAddressForm (default constructor) Address AddressImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_thenCustomerAddressFormAddressAddressImpl() throws ServiceException {
    // Arrange
    when(customerAddressService.saveCustomerAddress(Mockito.<CustomerAddress>any()))
        .thenReturn(new CustomerAddressImpl());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(new CustomerAddressImpl());
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act
    String actualUpdateCustomerAddressResult = broadleafManageCustomerAddressesController.updateCustomerAddress(request,
        model, 1L, form, result, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    verify(customerAddressService).saveCustomerAddress(isA(CustomerAddress.class));
    Address address = form.getAddress();
    assertTrue(address instanceof AddressImpl);
    assertEquals("redirect:/account/addresses", actualUpdateCustomerAddressResult);
    assertNull(address.getPhoneFax());
    assertNull(address.getPhonePrimary());
    assertNull(address.getPhoneSecondary());
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link CustomerAddressForm} (default constructor) Address is {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); when CustomerAddressForm (default constructor) Address is AddressImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_whenCustomerAddressFormAddressIsAddressImpl() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    CustomerAddressForm form = new CustomerAddressForm();
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}.
   * <ul>
   *   <li>When {@link CustomerAddressForm} {@link CustomerAddressForm#getAddress()} return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes); when CustomerAddressForm getAddress() return AddressImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.updateCustomerAddress(HttpServletRequest, Model, Long, CustomerAddressForm, BindingResult, RedirectAttributes)"})
  void testUpdateCustomerAddress_whenCustomerAddressFormGetAddressReturnAddressImpl() throws ServiceException {
    // Arrange
    CustomerAddressImpl customerAddressImpl = mock(CustomerAddressImpl.class);
    doThrow(new SecurityException("foo")).when(customerAddressImpl).setAddress(Mockito.<Address>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(customerAddressImpl);
    doNothing().when(customerAddressValidator).validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();
    CustomerAddressForm form = mock(CustomerAddressForm.class);
    when(form.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(form).setAddress(Mockito.<Address>any());
    doNothing().when(form).setAddressName(Mockito.<String>any());
    doNothing().when(form).setCustomerAddressId(Mockito.<Long>any());
    form.setAddress(new AddressImpl());
    form.setAddressName("42 Main St");
    form.setCustomerAddressId(1L);
    BindException result = new BindException("Target", "Object Name");

    // Act and Assert
    assertThrows(SecurityException.class, () -> broadleafManageCustomerAddressesController
        .updateCustomerAddress(request, model, 1L, form, result, new RedirectAttributesModelMap()));
    verify(form, atLeast(1)).getAddress();
    verify(form).setAddress(isA(Address.class));
    verify(form).setAddressName(eq("42 Main St"));
    verify(form).setCustomerAddressId(eq(1L));
    verify(customerAddressValidator).validate(isA(Object.class), isA(Errors.class));
    verify(customerAddressImpl).setAddress(isA(Address.class));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"})
  void testRemoveCustomerAddress() {
    // Arrange
    doNothing().when(customerAddressService).deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult = broadleafManageCustomerAddressesController.removeCustomerAddress(request,
        model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).deleteCustomerAddressById(eq(1L));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"})
  void testRemoveCustomerAddress2() {
    // Arrange
    doThrow(new DataIntegrityViolationException("successMessage")).when(customerAddressService)
        .deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult = broadleafManageCustomerAddressesController.removeCustomerAddress(request,
        model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).deleteCustomerAddressById(eq(1L));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}.
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"})
  void testRemoveCustomerAddress3() {
    // Arrange
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(null);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act
    String actualRemoveCustomerAddressResult = broadleafManageCustomerAddressesController.removeCustomerAddress(request,
        model, 1L, new RedirectAttributesModelMap());

    // Assert
    verify(customerAddressService).readCustomerAddressById(eq(1L));
    assertEquals("redirect:/account/addresses", actualRemoveCustomerAddressResult);
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)}
   */
  @Test
  @DisplayName("Test removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "String BroadleafManageCustomerAddressesController.removeCustomerAddress(HttpServletRequest, Model, Long, RedirectAttributes)"})
  void testRemoveCustomerAddress_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("successMessage")).when(customerAddressService)
        .deleteCustomerAddressById(Mockito.<Long>any());
    when(customerAddressService.readCustomerAddressById(Mockito.<Long>any())).thenReturn(new CustomerAddressImpl());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    SearchRequestWrapper request = new SearchRequestWrapper(new XssRequestWrapper(servletRequest,
        new StandardReactiveWebEnvironment(), new String[]{"White List Param Names"}));
    ConcurrentModel model = new ConcurrentModel();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> broadleafManageCustomerAddressesController
        .removeCustomerAddress(request, model, 1L, new RedirectAttributesModelMap()));
    verify(customerAddressService).deleteCustomerAddressById(eq(1L));
    verify(customerAddressService).readCustomerAddressById(eq(1L));
  }

  /**
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Fax is {@code Fax}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) Fax is 'Fax'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_givenAddressImplFaxIsFax() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhoneFax()} return {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl getPhoneFax() return PhoneImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_givenAddressImplGetPhoneFaxReturnPhoneImpl() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} {@link AddressImpl#getPhonePrimary()} return {@link PhoneImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl getPhonePrimary() return PhoneImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_givenAddressImplGetPhonePrimaryReturnPhoneImpl() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) PrimaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) PrimaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_givenAddressImplPrimaryPhoneIs6625550144() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) SecondaryPhone is {@code 6625550144}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); given AddressImpl (default constructor) SecondaryPhone is '6625550144'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_givenAddressImplSecondaryPhoneIs6625550144() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then calls {@link AddressImpl#setPhoneFax(Phone)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then calls setPhoneFax(Phone)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_thenCallsSetPhoneFax() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then {@link CustomerAddressForm} (default constructor) Address {@link AddressImpl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then CustomerAddressForm (default constructor) Address AddressImpl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_thenCustomerAddressFormAddressAddressImpl() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>Then throw {@link SecurityException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); then throw SecurityException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_thenThrowSecurityException() {
    // Arrange
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
   * Test {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}.
   * <ul>
   *   <li>When {@link CustomerAddressForm} {@link CustomerAddressForm#getAddress()} return {@link AddressImpl} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BroadleafManageCustomerAddressesController#removeUnusedPhones(CustomerAddressForm)}
   */
  @Test
  @DisplayName("Test removeUnusedPhones(CustomerAddressForm); when CustomerAddressForm getAddress() return AddressImpl (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.removeUnusedPhones(CustomerAddressForm)"})
  void testRemoveUnusedPhones_whenCustomerAddressFormGetAddressReturnAddressImpl() {
    // Arrange
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
   *   <li>default or parameterless constructor of {@link BroadleafManageCustomerAddressesController}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressAddedMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressRemovedErrorMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressRemovedMessage()}
   *   <li>{@link BroadleafManageCustomerAddressesController#getAddressUpdatedMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void BroadleafManageCustomerAddressesController.<init>()",
      "String BroadleafManageCustomerAddressesController.getAddressAddedMessage()",
      "String BroadleafManageCustomerAddressesController.getAddressRemovedErrorMessage()",
      "String BroadleafManageCustomerAddressesController.getAddressRemovedMessage()",
      "String BroadleafManageCustomerAddressesController.getAddressUpdatedMessage()"})
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
