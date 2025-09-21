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
package org.broadleafcommerce.core.web.controller.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.broadleafcommerce.common.audit.Auditable;
import org.broadleafcommerce.common.currency.domain.BroadleafCurrencyImpl;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.LocaleImpl;
import org.broadleafcommerce.common.money.Money;
import org.broadleafcommerce.core.order.domain.FulfillmentGroupImpl;
import org.broadleafcommerce.core.order.domain.NullOrderImpl;
import org.broadleafcommerce.core.order.domain.Order;
import org.broadleafcommerce.core.order.domain.OrderImpl;
import org.broadleafcommerce.core.order.service.FulfillmentGroupService;
import org.broadleafcommerce.core.order.service.type.OrderStatus;
import org.broadleafcommerce.core.payment.domain.OrderPayment;
import org.broadleafcommerce.core.payment.domain.OrderPaymentImpl;
import org.broadleafcommerce.core.payment.service.OrderPaymentService;
import org.broadleafcommerce.core.pricing.service.exception.PricingException;
import org.broadleafcommerce.core.web.checkout.model.PaymentInfoForm;
import org.broadleafcommerce.core.web.checkout.validator.CheckoutPaymentInfoFormValidator;
import org.broadleafcommerce.core.web.order.service.CartStateService;
import org.broadleafcommerce.core.web.payment.service.SavedPaymentService;
import org.broadleafcommerce.core.web.search.SearchRequestWrapper;
import org.broadleafcommerce.core.web.security.XssRequestWrapper;
import org.broadleafcommerce.profile.core.domain.Address;
import org.broadleafcommerce.profile.core.domain.AddressImpl;
import org.broadleafcommerce.profile.core.domain.CountryImpl;
import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.broadleafcommerce.profile.core.domain.CustomerPaymentImpl;
import org.broadleafcommerce.profile.core.domain.Phone;
import org.broadleafcommerce.profile.core.domain.PhoneImpl;
import org.broadleafcommerce.profile.core.domain.StateImpl;
import org.broadleafcommerce.profile.core.service.AddressService;
import org.broadleafcommerce.profile.core.service.CustomerPaymentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.owasp.esapi.filters.SecurityWrapperRequest;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@ExtendWith(MockitoExtension.class)
class BroadleafPaymentInfoControllerDiffblueTest {
  @Mock private AddressService addressService;

  @InjectMocks private BroadleafPaymentInfoController broadleafPaymentInfoController;

  @Mock private CartStateService cartStateService;

  @Mock private CheckoutPaymentInfoFormValidator checkoutPaymentInfoFormValidator;

  @Mock private CustomerPaymentService customerPaymentService;

  @Mock private FulfillmentGroupService fulfillmentGroupService;

  @Mock private OrderPaymentService orderPaymentService;

  @Mock private SavedPaymentService savedPaymentService;

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("blcAjax", "blcAjax"));

    // Act
    broadleafPaymentInfoController.savePaymentInfo(request, response, model, paymentForm, result);

    // Assert that nothing has changed
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertFalse(paymentForm.getShouldUseCustomerPayment());
    assertFalse(paymentForm.hasCustomerPaymentId());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo2() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(1L, paymentForm.getCustomerPaymentId().longValue());
    assertTrue(paymentForm.getShouldUseCustomerPayment());
    assertTrue(paymentForm.hasCustomerPaymentId());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo3() throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    SearchRequestWrapper servletRequest2 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request));
    String[] whiteListParamNames2 = new String[] {"White List Param Names"};

    XssRequestWrapper request2 =
        new XssRequestWrapper(
            servletRequest2, new StandardReactiveWebEnvironment(), whiteListParamNames2);
    SearchRequestWrapper servletRequest3 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request2));
    SearchRequestWrapper request3 = new SearchRequestWrapper(servletRequest3);
    HttpServletRequestWrapper request4 = new HttpServletRequestWrapper(request3);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
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
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setCountry(null);

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldSaveNewPayment(true);
    paymentForm.setShouldUseCustomerPayment(false);
    paymentForm.setCustomerPaymentId(null);
    paymentForm.setShouldUseShippingAddress(false);
    paymentForm.setEmailAddress("not empty");
    paymentForm.setAddress(address);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request4, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertEquals(1L, paymentForm.getCustomerPaymentId().longValue());
    assertTrue(paymentForm.getShouldUseCustomerPayment());
    assertTrue(paymentForm.hasCustomerPaymentId());
    assertSame(address, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is {@link CountryImpl} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); given AddressImpl (default constructor) Country is CountryImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_givenAddressImplCountryIsCountryImpl()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    SecurityWrapperRequest servletRequest = new SecurityWrapperRequest(request);
    SearchRequestWrapper request2 = new SearchRequestWrapper(servletRequest);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
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
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setCountry(new CountryImpl());

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldSaveNewPayment(false);
    paymentForm.setShouldUseCustomerPayment(false);
    paymentForm.setCustomerPaymentId(null);
    paymentForm.setShouldUseShippingAddress(false);
    paymentForm.setEmailAddress("not empty");
    paymentForm.setAddress(address);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request3, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert that nothing has changed
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertFalse(paymentForm.getShouldUseCustomerPayment());
    assertFalse(paymentForm.hasCustomerPaymentId());
    assertSame(address, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link AddressImpl} (default constructor) Country is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); given AddressImpl (default constructor) Country is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_givenAddressImplCountryIsNull()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    MockHttpServletRequest servletRequest = new MockHttpServletRequest();
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper request =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    SearchRequestWrapper servletRequest2 =
        new SearchRequestWrapper(new HttpServletRequestWrapper(request));
    SearchRequestWrapper request2 = new SearchRequestWrapper(servletRequest2);
    HttpServletRequestWrapper request3 = new HttpServletRequestWrapper(request2);
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    AddressImpl address = new AddressImpl();
    address.setActive(true);
    address.setAddressLine1("42 Main St");
    address.setAddressLine2("42 Main St");
    address.setAddressLine3("42 Main St");
    address.setBusiness(true);
    address.setCity("Oxford");
    address.setCompanyName("Company Name");
    address.setCounty("3");
    address.setDefault(true);
    address.setEmailAddress("42 Main St");
    address.setFax("Fax");
    address.setFirstName("Jane");
    address.setFullName("Dr Jane Doe");
    address.setId(1L);
    address.setIsoCountrySubdivision("GB");
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
    address.setStateProvinceRegion("us-east-2");
    address.setStreet(true);
    address.setTokenizedAddress("42 Main St");
    address.setVerificationLevel("Verification Level");
    address.setZipFour("21654");
    address.setIsoCountryAlpha2(null);
    address.setCountry(null);

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldSaveNewPayment(false);
    paymentForm.setShouldUseCustomerPayment(false);
    paymentForm.setCustomerPaymentId(null);
    paymentForm.setShouldUseShippingAddress(false);
    paymentForm.setEmailAddress("not empty");
    paymentForm.setAddress(address);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request3, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert that nothing has changed
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertFalse(paymentForm.getShouldUseCustomerPayment());
    assertFalse(paymentForm.hasCustomerPaymentId());
    assertSame(address, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then calls {@link AddressService#copyAddress(Address)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then calls copyAddress(Address)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_thenCallsCopyAddress() throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentInfoForm#getCustomerPaymentId()}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then calls getCustomerPaymentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_thenCallsGetCustomerPaymentId()
      throws ServiceException, PricingException {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(null);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getShouldSaveNewPayment()).thenReturn(true);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setCustomerPaymentId(Mockito.<Long>any());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setCustomerPaymentId(1L);
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    String actualSavePaymentInfoResult =
        broadleafPaymentInfoController.savePaymentInfo(
            request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldSaveNewPayment();
    verify(paymentForm, atLeast(1)).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(paymentForm).setCustomerPaymentId(1L);
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    assertEquals("redirect:/checkout", actualSavePaymentInfoResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then calls {@link SavedPaymentService#updateSavedPayment(Customer, PaymentInfoForm)}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then calls updateSavedPayment(Customer, PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_thenCallsUpdateSavedPayment() throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.updateSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setCustomerPaymentId(1L);
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(savedPaymentService).updateSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then {@link PaymentInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then PaymentInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_thenPaymentInfoFormAddressAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(1L, paymentForm.getCustomerPaymentId().longValue());
    assertTrue(paymentForm.getShouldUseCustomerPayment());
    assertTrue(paymentForm.hasCustomerPaymentId());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} {@link PaymentInfoForm#getShouldSaveNewPayment()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); when PaymentInfoForm getShouldSaveNewPayment() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_whenPaymentInfoFormGetShouldSaveNewPaymentReturnFalse()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getShouldSaveNewPayment()).thenReturn(false);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(false);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(false);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setCustomerPaymentId(Mockito.<Long>any());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setCustomerPaymentId(1L);
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    String actualSavePaymentInfoResult =
        broadleafPaymentInfoController.savePaymentInfo(
            request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(paymentForm).getAddress();
    verify(paymentForm).getShouldSaveNewPayment();
    verify(paymentForm, atLeast(1)).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setCustomerPaymentId(1L);
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertEquals("redirect:/checkout", actualSavePaymentInfoResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor) ShouldUseCustomerPayment is {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); when PaymentInfoForm (default constructor) ShouldUseCustomerPayment is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_whenPaymentInfoFormShouldUseCustomerPaymentIsTrue()
      throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseCustomerPayment(true);
    paymentForm.setCustomerPaymentId(1L);
    paymentForm.setShouldUseShippingAddress(true);

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService, atLeast(1)).readCustomerPaymentById(1L);
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).
   *   <li>Then {@link PaymentInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link BroadleafPaymentInfoController#savePaymentInfo(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); when PaymentInfoForm (default constructor); then PaymentInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.savePaymentInfo(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSavePaymentInfo_whenPaymentInfoForm_thenPaymentInfoFormAddressAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(cartStateService.cartHasCreditCardPaymentWithSameToken(Mockito.<String>any()))
        .thenReturn(true);
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    when(savedPaymentService.addSavedPayment(
            Mockito.<Customer>any(), Mockito.<PaymentInfoForm>any()))
        .thenReturn(1L);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.savePaymentInfo(
        request, response, model, paymentForm, new BindException("Target", "Object Name"));

    // Assert
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(cartStateService).cartHasCreditCardPaymentWithSameToken(null);
    verify(savedPaymentService).addSavedPayment(isNull(), isA(PaymentInfoForm.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(1L, paymentForm.getCustomerPaymentId().longValue());
    assertTrue(paymentForm.getShouldUseCustomerPayment());
    assertTrue(paymentForm.hasCustomerPaymentId());
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress() throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("");
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveBillingAddressResult =
        broadleafPaymentInfoController.saveBillingAddress(
            request, response, model, paymentForm, result);

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertEquals("redirect:/checkout", actualSaveBillingAddressResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress2() throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("");
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper servletRequest =
        new HttpServletRequestWrapper(new MockHttpServletRequest());
    String[] whiteListParamNames = new String[] {"White List Param Names"};

    XssRequestWrapper servletRequest2 =
        new XssRequestWrapper(
            servletRequest, new StandardReactiveWebEnvironment(), whiteListParamNames);
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(servletRequest2));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveBillingAddressResult =
        broadleafPaymentInfoController.saveBillingAddress(
            request, response, model, paymentForm, result);

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertEquals("redirect:/checkout", actualSaveBillingAddressResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Given {@link CustomerPaymentImpl} (default constructor) BillingAddress is {@link
   *       AddressImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); given CustomerPaymentImpl (default constructor) BillingAddress is AddressImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress_givenCustomerPaymentImplBillingAddressIsAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("");
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveBillingAddressResult =
        broadleafPaymentInfoController.saveBillingAddress(
            request, response, model, paymentForm, result);

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm, atLeast(1)).setAddress(isA(Address.class));
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService, atLeast(1)).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertEquals("redirect:/checkout", actualSaveBillingAddressResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then {@link PaymentInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then PaymentInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress_thenPaymentInfoFormAddressAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    broadleafPaymentInfoController.saveBillingAddress(
        request, response, model, paymentForm, result);

    // Assert that nothing has changed
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then {@link PaymentInfoForm} (default constructor) Address is {@link AddressImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then PaymentInfoForm (default constructor) Address is AddressImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress_thenPaymentInfoFormAddressIsAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("");
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = new PaymentInfoForm();
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    broadleafPaymentInfoController.saveBillingAddress(
        request, response, model, paymentForm, result);

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>Then return {@code redirect:/checkout}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); then return 'redirect:/checkout'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress_thenReturnRedirectCheckout()
      throws ServiceException, PricingException {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    addressImpl.setPrimaryPhone("");
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());
    doNothing().when(paymentForm).setShouldUseShippingAddress(anyBoolean());
    paymentForm.setShouldUseShippingAddress(true);

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    String actualSaveBillingAddressResult =
        broadleafPaymentInfoController.saveBillingAddress(
            request, response, model, paymentForm, result);

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isNull());
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(paymentForm).setShouldUseShippingAddress(true);
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
    assertEquals("redirect:/checkout", actualSaveBillingAddressResult);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest,
   * HttpServletResponse, Model, PaymentInfoForm, BindingResult)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).
   *   <li>Then {@link PaymentInfoForm} (default constructor) Address {@link AddressImpl}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#saveBillingAddress(HttpServletRequest, HttpServletResponse,
   * Model, PaymentInfoForm, BindingResult)}
   */
  @Test
  @DisplayName(
      "Test saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult); when PaymentInfoForm (default constructor); then PaymentInfoForm (default constructor) Address AddressImpl")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String BroadleafPaymentInfoController.saveBillingAddress(HttpServletRequest, HttpServletResponse, Model, PaymentInfoForm, BindingResult)"
  })
  void testSaveBillingAddress_whenPaymentInfoForm_thenPaymentInfoFormAddressAddressImpl()
      throws ServiceException, PricingException {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    doNothing()
        .when(checkoutPaymentInfoFormValidator)
        .validate(Mockito.<Object>any(), Mockito.<Errors>any());
    HttpServletRequestWrapper request =
        new HttpServletRequestWrapper(new SearchRequestWrapper(new MockHttpServletRequest()));
    MockHttpServletResponse response = new MockHttpServletResponse();
    ConcurrentModel model = new ConcurrentModel();
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    BindException result = new BindException("Target", "Object Name");
    result.addError(new ObjectError("Object Name", "Default Message"));

    // Act
    broadleafPaymentInfoController.saveBillingAddress(
        request, response, model, paymentForm, result);

    // Assert that nothing has changed
    verify(checkoutPaymentInfoFormValidator).validate(isA(Object.class), isA(Errors.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(false);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress2() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress3() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress_givenFalse() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(false);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@link FulfillmentGroupImpl} (default constructor) Address is {@link AddressImpl}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName(
      "Test preProcessBillingAddress(PaymentInfoForm, Order); given FulfillmentGroupImpl (default constructor) Address is AddressImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress_givenFulfillmentGroupImplAddressIsAddressImpl() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);

    FulfillmentGroupImpl fulfillmentGroupImpl = new FulfillmentGroupImpl();
    fulfillmentGroupImpl.setAddress(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(true);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm, atLeast(1)).setAddress(isA(Address.class));
    verify(addressService, atLeast(1)).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName("Test preProcessBillingAddress(PaymentInfoForm, Order); given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress_givenNull() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    when(paymentForm.getCustomerPaymentId()).thenReturn(null);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(false);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(paymentForm).getAddress();
    verify(paymentForm).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then calls {@link PaymentInfoForm#setAddress(Address)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName(
      "Test preProcessBillingAddress(PaymentInfoForm, Order); then calls setAddress(Address)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress_thenCallsSetAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());

    CustomerPaymentImpl customerPaymentImpl = new CustomerPaymentImpl();
    customerPaymentImpl.setBillingAddress(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);

    PaymentInfoForm paymentForm = mock(PaymentInfoForm.class);
    doNothing().when(paymentForm).setAddress(Mockito.<Address>any());
    when(paymentForm.getCustomerPaymentId()).thenReturn(1L);
    when(paymentForm.getShouldUseShippingAddress()).thenReturn(false);
    when(paymentForm.getShouldUseCustomerPayment()).thenReturn(true);
    when(paymentForm.getAddress()).thenReturn(new AddressImpl());

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(paymentForm).getAddress();
    verify(paymentForm, atLeast(1)).getCustomerPaymentId();
    verify(paymentForm).getShouldUseCustomerPayment();
    verify(paymentForm).getShouldUseShippingAddress();
    verify(paymentForm).setAddress(isA(Address.class));
    verify(addressService).copyAddress(isA(Address.class));
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(1L);
  }

  /**
   * Test {@link BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>When {@link PaymentInfoForm} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#preProcessBillingAddress(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName(
      "Test preProcessBillingAddress(PaymentInfoForm, Order); when PaymentInfoForm (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.preProcessBillingAddress(PaymentInfoForm, Order)"
  })
  void testPreProcessBillingAddress_whenPaymentInfoForm() {
    // Arrange
    doNothing().when(addressService).populateAddressISOCountrySub(Mockito.<Address>any());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.preProcessBillingAddress(paymentForm, new NullOrderImpl());

    // Assert
    verify(addressService).populateAddressISOCountrySub(isA(Address.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order,
   * PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"
  })
  void testCopyShippingAddressToBillingAddress() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(new FulfillmentGroupImpl());
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(
        order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order,
   * PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"
  })
  void testCopyShippingAddressToBillingAddress2() {
    // Arrange
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(null);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(
        order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupService).getFirstShippableFulfillmentGroup(isA(Order.class));
  }

  /**
   * Test {@link BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order,
   * PaymentInfoForm)}.
   *
   * <ul>
   *   <li>Then calls {@link FulfillmentGroupImpl#getAddress()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyShippingAddressToBillingAddress(Order, PaymentInfoForm)}
   */
  @Test
  @DisplayName(
      "Test copyShippingAddressToBillingAddress(Order, PaymentInfoForm); then calls getAddress()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyShippingAddressToBillingAddress(Order, PaymentInfoForm)"
  })
  void testCopyShippingAddressToBillingAddress_thenCallsGetAddress() {
    // Arrange
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(new AddressImpl());

    FulfillmentGroupImpl fulfillmentGroupImpl = mock(FulfillmentGroupImpl.class);
    when(fulfillmentGroupImpl.getAddress()).thenReturn(new AddressImpl());
    when(fulfillmentGroupService.getFirstShippableFulfillmentGroup(Mockito.<Order>any()))
        .thenReturn(fulfillmentGroupImpl);
    NullOrderImpl order = new NullOrderImpl();

    // Act
    broadleafPaymentInfoController.copyShippingAddressToBillingAddress(
        order, new PaymentInfoForm());

    // Assert
    verify(fulfillmentGroupImpl).getAddress();
    verify(fulfillmentGroupService, atLeast(1)).getFirstShippableFulfillmentGroup(isA(Order.class));
    verify(addressService).copyAddress(isA(Address.class));
  }

  /**
   * Test {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"
  })
  void testCopyCustomerPaymentAddressToBillingAddress() {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(new CustomerPaymentImpl());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert that nothing has changed
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"
  })
  void testCopyCustomerPaymentAddressToBillingAddress2() {
    // Arrange
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any())).thenReturn(null);
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert that nothing has changed
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    Address address = paymentForm.getAddress();
    assertTrue(address instanceof AddressImpl);
    Phone phoneFax = address.getPhoneFax();
    assertTrue(phoneFax instanceof PhoneImpl);
    Phone phonePrimary = address.getPhonePrimary();
    assertTrue(phonePrimary instanceof PhoneImpl);
    Phone phoneSecondary = address.getPhoneSecondary();
    assertTrue(phoneSecondary instanceof PhoneImpl);
    assertEquals(phoneFax, phonePrimary);
    assertEquals(phoneFax, phoneSecondary);
  }

  /**
   * Test {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}.
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)}
   */
  @Test
  @DisplayName("Test copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(PaymentInfoForm)"
  })
  void testCopyCustomerPaymentAddressToBillingAddress3() {
    // Arrange
    AddressImpl addressImpl = new AddressImpl();
    when(addressService.copyAddress(Mockito.<Address>any())).thenReturn(addressImpl);

    CustomerPaymentImpl customerPaymentImpl = mock(CustomerPaymentImpl.class);
    when(customerPaymentImpl.getBillingAddress()).thenReturn(new AddressImpl());
    when(customerPaymentService.readCustomerPaymentById(Mockito.<Long>any()))
        .thenReturn(customerPaymentImpl);
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    // Act
    broadleafPaymentInfoController.copyCustomerPaymentAddressToBillingAddress(paymentForm);

    // Assert
    verify(customerPaymentImpl).getBillingAddress();
    verify(addressService).copyAddress(isA(Address.class));
    verify(customerPaymentService).readCustomerPaymentById(isNull());
    assertSame(addressImpl, paymentForm.getAddress());
  }

  /**
   * Test {@link BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}.
   *
   * <ul>
   *   <li>Then {@link OrderImpl} (default constructor) Payments is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BroadleafPaymentInfoController#addTemporaryOrderPayment(PaymentInfoForm, Order)}
   */
  @Test
  @DisplayName(
      "Test addTemporaryOrderPayment(PaymentInfoForm, Order); then OrderImpl (default constructor) Payments is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BroadleafPaymentInfoController.addTemporaryOrderPayment(PaymentInfoForm, Order)"
  })
  void testAddTemporaryOrderPayment_thenOrderImplPaymentsIsArrayList() {
    // Arrange
    when(orderPaymentService.create()).thenReturn(new OrderPaymentImpl());
    PaymentInfoForm paymentForm = new PaymentInfoForm();

    Auditable auditable = new Auditable();
    auditable.setCreatedBy(1L);
    auditable.setDateCreated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setDateUpdated(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    auditable.setUpdatedBy(1L);

    OrderImpl cart = new OrderImpl();
    cart.setAdditionalOfferInformation(new HashMap<>());
    cart.setAuditable(auditable);
    cart.setCandidateOrderOffers(new ArrayList<>());
    cart.setCurrency(new BroadleafCurrencyImpl());
    cart.setCustomer(new CustomerImpl());
    cart.setEmailAddress("42 Main St");
    cart.setFulfillmentGroups(new ArrayList<>());
    cart.setId(1L);
    cart.setLocale(new LocaleImpl());
    cart.setName("Name");
    cart.setOrderAttributes(new HashMap<>());
    cart.setOrderItems(new ArrayList<>());
    cart.setOrderMessages(new ArrayList<>());
    cart.setOrderNumber("42");
    ArrayList<OrderPayment> payments = new ArrayList<>();
    cart.setPayments(payments);
    cart.setStatus(new OrderStatus("Type", "Friendly Type"));
    cart.setSubTotal(new Money());
    cart.setSubmitDate(
        Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
    cart.setTaxOverride(true);
    cart.setTotal(new Money());
    cart.setTotalFulfillmentCharges(new Money());
    cart.setTotalTax(new Money());

    // Act
    broadleafPaymentInfoController.addTemporaryOrderPayment(paymentForm, cart);

    // Assert
    verify(orderPaymentService).create();
    assertSame(payments, cart.getPayments());
  }

  /**
   * Test new {@link BroadleafPaymentInfoController} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * BroadleafPaymentInfoController}
   */
  @Test
  @DisplayName("Test new BroadleafPaymentInfoController (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BroadleafPaymentInfoController.<init>()"})
  void testNewBroadleafPaymentInfoController() {
    // Arrange and Act
    BroadleafPaymentInfoController actualBroadleafPaymentInfoController =
        new BroadleafPaymentInfoController();

    // Assert
    assertEquals(
        "ajaxredirect:/confirmation",
        actualBroadleafPaymentInfoController.getBaseConfirmationView());
    assertEquals("checkout/checkout", actualBroadleafPaymentInfoController.getCheckoutView());
    assertEquals(
        "checkout/partials/checkoutStages",
        actualBroadleafPaymentInfoController.getCheckoutStagesPartial());
    assertEquals("redirect:/cart", actualBroadleafPaymentInfoController.getCartPageRedirect());
    assertEquals(
        "redirect:/checkout", actualBroadleafPaymentInfoController.getCheckoutPageRedirect());
    assertNull(actualBroadleafPaymentInfoController.isoService);
    assertNull(actualBroadleafPaymentInfoController.paymentGatewayCheckoutService);
    assertNull(actualBroadleafPaymentInfoController.checkoutService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentGroupService);
    assertNull(actualBroadleafPaymentInfoController.fulfillmentOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderMultishipOptionService);
    assertNull(actualBroadleafPaymentInfoController.orderService);
    assertNull(actualBroadleafPaymentInfoController.orderPaymentService);
    assertNull(actualBroadleafPaymentInfoController.dtoTranslationService);
    assertNull(actualBroadleafPaymentInfoController.billingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.paymentInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.giftCardInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.multishipAddAddressFormValidator);
    assertNull(actualBroadleafPaymentInfoController.orderInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.shippingInfoFormValidator);
    assertNull(actualBroadleafPaymentInfoController.checkoutControllerExtensionManager);
    assertNull(actualBroadleafPaymentInfoController.cartStateService);
    assertNull(actualBroadleafPaymentInfoController.savedPaymentService);
    assertNull(actualBroadleafPaymentInfoController.initBinderService);
    assertNull(actualBroadleafPaymentInfoController.addressService);
    assertNull(actualBroadleafPaymentInfoController.countryService);
    assertNull(actualBroadleafPaymentInfoController.countrySubdivisionService);
    assertNull(actualBroadleafPaymentInfoController.customerAddressService);
    assertNull(actualBroadleafPaymentInfoController.customerPaymentService);
    assertNull(actualBroadleafPaymentInfoController.customerService);
    assertNull(actualBroadleafPaymentInfoController.phoneService);
    assertNull(actualBroadleafPaymentInfoController.stateService);
  }
}
